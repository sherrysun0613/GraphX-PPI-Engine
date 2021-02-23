import org.apache.log4j.{Level,Logger}
import org.apache.spark._
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import org.apache.spark.graphx._
import org.apache.spark.rdd.RDD




import scala.io.Source
import scala.collection.mutable.Map
import collection.mutable.ArrayBuffer
import scala.collection.mutable.Stack
import java.util.Date



object SimpleGraphX{
   def main(args: Array[String]){
   
    if(args.length>=6){    

    case   class ProbStmt(content: String, stmtType: String, preIn: Map[ArrayBuffer[Int],Double],inDistri: Map[Long,Map[ArrayBuffer[Int],Double]]) 

     //屏蔽日志
     Logger.getLogger("org.apache.spark").setLevel(Level.WARN)
     Logger.getLogger("org.eclipse.jetty.server").setLevel(Level.OFF)
    //设置运行环境
     val conf = new SparkConf().setAppName("SimpleGraphX")
     val sc = new SparkContext(conf)
    
     
    /****************************
     * 1.  加载变量
     * 2.  构成初始分布并转换为String方便map
    *****************************/


      var varbTab:  Map[String,Int] = Map()
      var varbIndex = 0
      var iniDist = new ArrayBuffer[Int]()  //based on it to update current distribution

         val result1 = sc.textFile(args(0))
         val tmpA1  = result1.collect
   	 for(date <- tmpA1){
              var nameWPos = date.split(",")
              if(nameWPos.length>1){
                  varbTab += (nameWPos(0).toString -> nameWPos(1).toInt)
                  iniDist += 0
                  varbIndex += 1
              }
         }

     // for((k,v)<-varbTab)println("  "+k+" -> "+v)
     // println("$$                            $$")



      /****************************
       * 3.  加载cfg的stmt和边
       * 4.  对Vertex, Edge 数组序列化
       *****************************/
      val vertexArr = new ArrayBuffer[(Long, ProbStmt)]()
      val edgeArr = new ArrayBuffer[Edge[String]]()
      val startID = "0"


         val result2 = sc.textFile(args(1))
         val tmpA2  = result2.collect
         for(date <- tmpA2){
            var pp  = date.split(",")
            if(pp.length>2){
              if(pp(0).toLong==1) vertexArr += (( pp(0).toLong, ProbStmt(pp(1),pp(2),Map(),Map(startID.toLong->Map(iniDist->1.0)))   ))
              else  vertexArr += (( pp(0).toLong, ProbStmt( pp(1),pp(2),Map(),Map()) ))
           }
         }


       val result3 = sc.textFile(args(2))
       val tmpA3  = result3.collect
       for(date <- tmpA3){
             var ee  = date.split(",")
             if(ee.length>2){
                edgeArr += Edge(ee(0).toLong, ee(1).toLong, ee(2))
               }
         }

       
        val endflag = vertexArr.length
        // println("  "+endflag)


       var intDataList : Map[String,ArrayBuffer[Int]] = Map()
       var probDataList : Map[String,ArrayBuffer[Double]] = Map()

       val result4 = sc.textFile(args(3))
       val tmpA4  = result4.collect
       for(date <- tmpA4){
            val ee = date.split(" ")
                if(ee.length>1){
                  val datas = ee(1).split(",")
                  var  templist: ArrayBuffer[Int] = ArrayBuffer()
                  for(dataone <- datas)  templist += dataone.toInt
                  intDataList += (ee(0) -> templist )

               } 
       }





        val result5 = sc.textFile(args(4))
         val tmpA5  = result5.collect
         for(date <- tmpA5){
            var ee  = date.split(" ")
             if(ee.length>1){
                  val datas = ee(1).split(",")
                  var  templist: ArrayBuffer[Double] = ArrayBuffer()
                  for(dataone <- datas)  templist += dataone.toDouble
                  probDataList += (ee(0) -> templist )

               }
         }
 

       
   

      val users: RDD[(VertexId, ProbStmt)] = sc.parallelize(vertexArr)
      val relationships: RDD[Edge[String]] = sc.parallelize(edgeArr)
      val graph = Graph(users, relationships)

     /****************************
      * 5. 展示CFG图的属性 
      *****************************/
 //     println("\n-----------------------------")
  //    graph.vertices.collect().foreach{ case (id,stmt) => println("The stmt's id is " + id + ", content is " + stmt.content+" ,type is "+stmt.stmtType) }




    //  println("\n-----------------------------")
    //  graph.triplets.foreach(triplet =>println( triplet.srcId + "----->" + triplet.dstId + "    attr:" + triplet.attr))
   
     

    /**************************** 
     * 6.  用于布尔运算优先级  
     * 7.  两个函数，1）只计算布尔表达式的值   2）根据变量名和右侧表达式，给变量赋值           
    *****************************/
       val  opPre:   Map[Char,Int] = Map( '('->5, '['->5,'!'->4,'>'->3,'<'->3,'='->3 ,'&'->2, '|'->1, ')'->0,']'->0 )
       var  opB = Stack[Char]()
       var  postExpr = Stack[String]()
       var  valB = Stack[Int]()
       def getExprVal(expr: String, distri: ArrayBuffer[Int], varIndex: Map[String,Int]): Int = {
        
           val len = expr.length()
           var i = 0
           valB.clear
           opB.clear
           postExpr.clear
           while(i<len){
           
            //  println("current location is "+i)
              if(opPre.contains(expr.charAt(i))){

                val curOp  = expr.charAt(i);

                if( curOp=='('||curOp=='[' ){
                    opB.push(curOp)
                }
                else if ( curOp==')'  ){
                    while(opB.top!='('){
                          postExpr.push(""+opB.pop)
                      }
                      opB.pop
                }
                else if ( curOp==']' ){
                   while(opB.top!='['){
                         
                          postExpr.push(""+opB.pop)
                      }
                      postExpr.push(""+opB.pop)
                }
                else {
                        if( i>0&&curOp==expr.charAt(i-1) ) {
                        
                          }
                        else if(!opB.isEmpty&&(opB.top=='('||opB.top=='[' ) ) {
                          opB.push(curOp)	
                        }
                        else{
                            var curPre   = opPre(curOp)
                            while(!opB.isEmpty&&opPre(opB.top)>curPre){
                                postExpr.push(""+opB.pop)
                            }
                            opB.push(curOp)
                        }
                
                }
                i=i+1
              }
              else{

                var pos1 = i
                var sym = expr.charAt(pos1)
                while(sym>='a'&&sym<='z'||sym>='A'&&sym<='Z'||sym>='0'&&sym<='9') {
                  pos1=pos1+1
                  if(pos1<len) sym=expr.charAt(pos1)
                  else sym='.'
                }
                // println("** "+i+" , "+pos1)
                //if(pos1==len) pos1=pos1-1

                val curVar:String = expr.substring(i,pos1)
                            
                
                if(curVar.charAt(0)>='0'&&curVar.charAt(0)<='9'){
                    postExpr.push(curVar)
                    i=pos1
                }
                else if(varIndex.contains(curVar)) {
                    //  println("Table contians case:"+curVar+"-> "+varIndex.contains(curVar))
                     // println("***  "+curVar)
                      val curIndex: Int = varIndex(curVar)
                      val curVal: String = String.valueOf(distri(curIndex))
                      postExpr.push(curVal)
                      i = pos1
                }
                //array name
                else{
                      postExpr.push(curVar)
                      i = pos1
                }

              }
           }
     
            
          while(!opB.isEmpty){
              postExpr.push(""+opB.pop)
           }          
   
   	  // println(postExpr)

          val postArr = postExpr.toArray
        //  println(postArr.mkString(" , ") )
          var loc = postArr.length-1
          while( loc >= 0){
            val x = postArr(loc)
            loc = loc-1
             if(x.charAt(0)>='0'&&x.charAt(0)<='9'){
                valB.push(x.toInt)  
             }
             else if (x.charAt(0)>='a'&&x.charAt(0)<='z'||x.charAt(0)>='A'&&x.charAt(0)<='Z'){
              //  println(x)
                val leftV:String = x;
                val rightV   = postArr(loc);
              //  println(rightV)
                val temparray = intDataList(x); 
                val tempindex = rightV.toInt               
                valB.push(temparray(tempindex))
                loc=loc-2;
             }
             else if (x=="!"){
               var curV = valB.pop
               if(curV>0)valB.push(0)
               else  valB.push(1)
             }
            else if (x==">"){
              val rightV = valB.pop
              val leftV  = valB.pop
              if(leftV>rightV)  valB.push(1)
              else             valB.push(0)
            }
            else if (x=="="){
              val leftV = valB.pop
              val rightV  = valB.pop
              if(leftV==rightV)  valB.push(1)
              else             valB.push(0)
            }
            else if (x=="<"){
              val rightV = valB.pop
              val leftV  = valB.pop
              if(leftV<rightV)  valB.push(1)
              else             valB.push(0)
            }
            else{
               val rightV = valB.pop
               val leftV  = valB.pop
               var  rightOne: Boolean = false
               var leftOne: Boolean = false
               if(rightV>0) rightOne = true
               if(leftV >0) leftOne = true
          //       println("//  "+x+"  "+rightV+"  "+leftV)           
   
                if(x=="&")valB.push( if(leftOne&&rightOne) 1  else 0)
                else   valB.push( if (leftOne||rightOne) 1 else 0)
            //    println(valB.top)
            }
          }

          valB.top
          
           
      }





      // change variable val according to: variable ID + computed bool expr value
                  //   left var id, right expr,  current single distri, var table
     def newDistri(varId:String ,expr: String, distri: ArrayBuffer[Int], varIndex: Map[String,Int]): ArrayBuffer[Int] ={
        val varPos=varIndex(varId)
        var temparray: ArrayBuffer[Int] = ArrayBuffer();
        temparray  ++= distri  

        if(expr=="true"){
           temparray(varPos) = 1
         }else if (expr=="false"){
           temparray(varPos) = 0
         }else{
           temparray(varPos) = getExprVal(expr, distri, varIndex)
         }
          temparray
      }
    


    /****************************
     * 8.  分布两次合并
     *     a) DeterAssg+BernoulliAssg  
     *     b）mergeMsg
     *****************************/
      def joinDistri(distri: ArrayBuffer[Int] ,prob: Double, outDistri: Map[ArrayBuffer[Int],Double]): Unit  = {
         var temparray: ArrayBuffer[Int] = ArrayBuffer();
         temparray  ++= distri  
          var chenge = true
           for((k,v)<-outDistri){
                      if(k sameElements temparray){ 
                          outDistri(k) =   outDistri(k) + prob
                           chenge = false
                      }

            }

        if(chenge) outDistri+=(temparray->prob)
      }





     /****************************
     * 8.5  pregel func  parameter list 
     *     1) 所有顶点的消息初始化
     *     2) 遍历每个triplet,把出度数发射给目标对象
     *     3) 目标合并所有的出度数(每次都利用上次的Iterator)
     *     4) updateVertex 最终处理
     *****************************/
      val firstMessage: Map[Long,Map[ArrayBuffer[Int],Double]] = Map()
      val iterations = Int.MaxValue
      val edgeDirection = EdgeDirection.Out
      val inwhile = "-1".toLong
      val duringWhile = "-2".toLong
      val accu = "-3".toLong
      val inFor = "-4".toLong
      var precision: Double = 0.01
      val precOne: Double = 1.00000
 
       
       val result6 = sc.textFile(args(5))
       val tmpA6  = result6.collect
       for(date <- tmpA6){
         precision = date.toDouble 
      }









         println("/-------------                          ------------------/")






       /****************************
        * 9. vertex program
        *****************************/
         val updateVertex = (vId: Long, vData: ProbStmt, msgSum: Map[Long,Map[ArrayBuffer[Int],Double]]) =>{

              if ( msgSum.contains(inwhile)||msgSum.contains(inFor)||vData.stmtType=="For"||vData.stmtType=="Loop"){ 
                      //在while 和 for 里面   都是直接等，不用检查
               
                     ProbStmt(vData.content,vData.stmtType,Map(),msgSum)
               }
               else if(vId==1){
               
           
                     vData  
               }
               else{
                   var newPreIn: Map[ArrayBuffer[Int],Double] = Map()  //store oldIn in previous step 
                   var disTab: Map[Long,Map[ArrayBuffer[Int],Double]]= Map()//update current multiple Ins table

                    for((k,v)<- msgSum){
                            disTab+=(k->v)
                    }
                    for((k,v)<- vData.inDistri){
                            if(!msgSum.contains(k)){
                                 disTab+=(k->v)
                            }
                            for((w,t)<-v){
                                 joinDistri(w,t,newPreIn)
                            }
                   }

                   ProbStmt(vData.content,vData.stmtType,newPreIn,disTab)
                }
         }        



 

       /****************************
        * 10. sendMsg: EdgeTriplet[VD, ED] => Iterator[(VertexId,A)]
        *****************************/
       def inferOut(inSum:  Map[ArrayBuffer[Int],Double], stmtType:String, content:String, whileflag:Boolean): Map[ArrayBuffer[Int],Double]= {
                     var outDistri:  Map[ArrayBuffer[Int],Double] = Map() 

                     if(stmtType=="Observe")
                     {
                            if(whileflag){
                                for((w,t)<-inSum){
                                    if(t>precision && getExprVal(content,w,varbTab)==1 ){  //inwhile，精度和当前stmt的条件均需符合
                                              // outDistri += (w->t)
                                               joinDistri(w,t ,  outDistri)
                                    }
                                }   
                            }
                            else{
                                for((w,t)<-inSum){
                                    if(getExprVal(content,w,varbTab)==1 ){  //stmt的条件均需符合
                                             //  outDistri += (w->t)
                                             joinDistri(w,t,outDistri)
                                    }
                                }   
                            }
                     }
                     else if (stmtType=="DeterAssg"){

                        val berPars = content.split("-");
                        var varId = berPars(0)
                        var exprStr = berPars(1)
                           
                        if(whileflag){
                            for((w,t)<-inSum){  
                                if(t>precision){ 
                                    val distri1 = newDistri(varId,exprStr, w, varbTab)
                                    joinDistri(distri1,t,outDistri)
                                }
                            }   
                        }
                        else{
                            for((w,t)<-inSum){
                                val distri1 = newDistri(varId,exprStr, w, varbTab)
                                joinDistri(distri1,t,outDistri)
                            }   
                        }
                     }
                     else if (stmtType=="BernoulliAssg"){ 
                         
                           val berPars = content.split("-");
                           var prob:Double = 0.00
                           var varId = berPars(0)
                           if(berPars.length==3){
                               val temparray = probDataList(berPars(1))
                               //下标取变值
                               if(varbTab.contains(berPars(2))){
                                   val pos = varbTab(berPars(2))
                                   prob = temparray(pos)
                               }
                               //下表取常量
                               else{
                                   prob = temparray(berPars(2).toInt)
                               }
                           }
                           else{
                               prob= berPars(1).toDouble
                           }

                           if(whileflag){
                                for((w,t)<-inSum){
                                    val  prob1 = prob*t
                                    val  prob2 = (precOne-prob)*t
                                    if(prob1 > precision){  
                                        val distri1= newDistri(varId , "true", w, varbTab)  //一定要声明新的地址，不能在原地址改
                                        joinDistri(distri1,prob1,  outDistri)
                                    }
                                    if ( prob2 > precision ){
                                        val distri2= newDistri(varId , "false", w, varbTab)
                                        joinDistri(distri2,prob2,  outDistri)
                                    }
                                }   
                            }
                            else{
                                for((w,t)<-inSum){
                                    var  prob1 = prob*t
                                    var  prob2 = (precOne-prob)*t
         
                                    
                                    if(prob1 >= 1.0E-5){
                                       if(prob1.toString.length>10){      
                                         prob1 =  prob1.formatted("%.8"+"f").toDouble
                                       }
                                    }
                                    else if(prob1 >= 1.0E-10 ){
                                       if(prob1.toString.length>17){
                                        prob1 =  prob1.formatted("%.15f").toDouble
                                       }
                                    }
                                    else if (prob1 >= 1.0E-20 ){
                                       if(prob1.toString.length>27){
                                        prob1 =  prob1.formatted("%.25f").toDouble
                                       }
                                    }
                                    else{
                                       prob1 =  prob1.formatted("%.35f").toDouble
                                    }


                                    if(prob2 >= 1.0E-5){
                                       if(prob2.toString.length>10){ 
                                         prob2 =  prob2.formatted("%.8"+"f").toDouble
                                       }
                                    }
                                    else if(prob2 >= 1.0E-10 ){
                                       if(prob2.toString.length>17){
                                        prob1 =  prob1.formatted("%.15f").toDouble
                                       }
                                    }
                                    else if (prob2 >= 1.0E-20 ){
                                       if(prob2.toString.length>27){
                                        prob2 =  prob2.formatted("%.25f").toDouble
                                       }
                                    }
                                    else{
                                       prob2 =  prob2.formatted("%.35f").toDouble
                                    }
 

                                    val distri1= newDistri(varId , "true", w, varbTab)
                                    joinDistri(distri1,prob1,  outDistri)
                                    val distri2= newDistri(varId , "false", w, varbTab)
                                    joinDistri(distri2,prob2,  outDistri)
                                }   
                            }
                     }
                     else if (stmtType=="DiscreteAssg"){
                           val berPars = content.split("-");
                           var problist: ArrayBuffer[Double] = ArrayBuffer();
                           var varId = berPars(0)
                            if(probDataList.contains(berPars(1))){
                                problist ++= probDataList(berPars(1))
                            }
                            else{
                                 val probrange = berPars(1).toInt
                                 val uniprob: Double  = precOne/probrange
                                 var a =0 
                                 for( a <- 1 to probrange ){   
                                     problist += uniprob
                                 } 
                            }
                                    

                            if(whileflag){ 
                                for((w,t)<-inSum){
                                    var pos = 0;
                                    for(pos <- 0 until problist.length){
                                        val prob1 = t*problist(pos)
                                        if(prob1 > precision){
                                          val distri1= newDistri(varId , pos.toString, w, varbTab)
                                          joinDistri(distri1,prob1,  outDistri)
                                        }
                                    }
                                }   
                            }
                            else{
                                for((w,t)<-inSum){
                                    var pos = 0;
                                    for(pos <- 0 until problist.length){
                                        val prob1 = t*problist(pos)
                                        val distri1= newDistri(varId , pos.toString, w, varbTab)
                                        joinDistri(distri1,prob1,  outDistri)  
                                    }
                                }             
                            }
                     }
                     else{
                       if(whileflag){
                            for((w,t)<-inSum){
                                if(t > precision ){  //inwhile，精度和当前stmt的条件均需符合
                                   outDistri += (w->t)
                                }
                            }   
                        }
                        else{
                            outDistri=inSum;
                        }
                     }

                     outDistri
        }   
        
     val sendMsg = (triplet: EdgeTriplet[ProbStmt, String]) =>{
           
        //    println("continue")
            var curIn : Map[ArrayBuffer[Int],Double] = Map()
            var containWhile = false
            var containFor =false
             var containAccu = false

            /**   newIn not in Loop,then compare preIn and curIn, 
            *        if equal then should't active dstId  
            */
           
            for( (k,v) <-  triplet.srcAttr.inDistri ){  
                if(k==inwhile){
                     containWhile = true
                }
                else if (k==inFor){
                     containFor = true
                }
                else if (k==duringWhile){

                }
                else if (k==accu){
                     containAccu = true
                }
                else{
                    for((w,t)<-v){ 
                        joinDistri(w,t,curIn)
                    }   
                }      
            }
           
            
            
            if(!containAccu  && !curIn.isEmpty&&curIn.equals(triplet.srcAttr.preIn)){
                        Iterator.empty
            }
            else{

               if(triplet.srcAttr.stmtType=="Observe"){   // type is Observe

                  var labelOut: Map[Long,Map[ArrayBuffer[Int],Double]] = Map()
                  var transOut:  Map[ArrayBuffer[Int],Double] = Map() 

                  if (containWhile){
                     labelOut+=(inwhile->Map())  
                     transOut = inferOut(curIn, "Observe", triplet.srcAttr.content, false)
                  }
                  else if (containFor){
                     labelOut+=(inFor->Map())  
                     transOut = inferOut(curIn, "Observe", triplet.srcAttr.content, false)
                  }
                  else{
                     transOut = inferOut(curIn, "Observe", triplet.srcAttr.content, false)
                  }

                 

                  if(transOut.isEmpty){   
                        Iterator.empty
                  }
                  else{
                         //block内的语句，若后继节点为for,记得自增
                        if(triplet.dstAttr.stmtType=="For"&& containFor){
                             val condi = triplet.dstAttr.content.split("-")(0)
                             var forIndex = varbTab(condi)
                             for((k,v)<-transOut){
                                 k(forIndex)=k(forIndex)+1
                             }
                        }
                        labelOut+=(triplet.srcId->transOut)
                        Iterator((triplet.dstId, labelOut))
                  }
               }
               else if(triplet.srcAttr.stmtType=="DeterAssg") {
                  var labelOut: Map[Long,Map[ArrayBuffer[Int],Double]] = Map()
                  var transOut:  Map[ArrayBuffer[Int],Double] = Map() 

                  if (containWhile){
                     labelOut+=(inwhile->Map())  
                     transOut = inferOut(curIn, "DeterAssg", triplet.srcAttr.content, false)
                  }
                  else if (containFor){
                     labelOut+=(inFor->Map())  
                     transOut = inferOut(curIn, "DeterAssg", triplet.srcAttr.content, false)
                  }
                  else{
                     transOut = inferOut(curIn, "DeterAssg", triplet.srcAttr.content, false)
                  }

                 

                  if(transOut.isEmpty){   
                        Iterator.empty
                  }
                  else{
                         //block内的语句，若后继节点为for,记得自增
                        if(triplet.dstAttr.stmtType=="For"&& containFor){
                             val condi = triplet.dstAttr.content.split("-")(0)
                             var forIndex = varbTab(condi)
                             for((k,v)<-transOut){
                                 k(forIndex)=k(forIndex)+1
                             }
                        }
                        labelOut+=(triplet.srcId->transOut)
                        Iterator((triplet.dstId, labelOut))
                  }

                  
               }
                else if (triplet.srcAttr.stmtType=="BernoulliAssg"){
                  var labelOut: Map[Long,Map[ArrayBuffer[Int],Double]] = Map()
                  var transOut:  Map[ArrayBuffer[Int],Double] = Map() 

                  if (containWhile){
                     labelOut+=(inwhile->Map())  
                     transOut = inferOut(curIn, "BernoulliAssg", triplet.srcAttr.content, false)
                  }
                  else if (containFor){
                     labelOut+=(inFor->Map())  
                     transOut = inferOut(curIn, "BernoulliAssg", triplet.srcAttr.content, false)
                  }
                  else{
                     transOut = inferOut(curIn, "BernoulliAssg", triplet.srcAttr.content, false)
                  }

                 

                  if(transOut.isEmpty){   
                        Iterator.empty
                  }
                  else{
                         //block内的语句，若后继节点为for,记得自增
                        if(triplet.dstAttr.stmtType=="For"&& containFor){
                             val condi = triplet.dstAttr.content.split("-")(0)
                             var forIndex = varbTab(condi)
                             for((k,v)<-transOut){
                                 k(forIndex)=k(forIndex)+1
                             }
                        }
                        labelOut+=(triplet.srcId->transOut)
                        Iterator((triplet.dstId, labelOut))
                  }  
               }
               else if (triplet.srcAttr.stmtType=="Conditional"){

                  var labelOut: Map[Long,Map[ArrayBuffer[Int],Double]] = Map()
                  var transOut:  Map[ArrayBuffer[Int],Double] = Map() 
                  var subexpr = triplet.srcAttr.content
            
                  var condiset = 0
                  if (triplet.attr=="true"){
                        condiset=1
                  }

                  if (containWhile){
                      labelOut+=(inwhile->Map())
                      for((w,t)<-curIn){
                         if(getExprVal(subexpr,w,varbTab)==condiset)
                            joinDistri(w,t, transOut)
                      }
                  }
                  else if (containFor){
                      labelOut+=(inFor->Map())
                      for((w,t)<-curIn){
                         if(getExprVal(subexpr,w,varbTab)==condiset)
                            joinDistri(w,t, transOut)
                      }
                  }
                  else{
                      for((w,t)<-curIn){
                        if(getExprVal(subexpr,w,varbTab)==condiset)
                            joinDistri(w,t, transOut)
                      }
                  }
                  
                  if(transOut.isEmpty){   
                        Iterator.empty
                  }
                  else{
                        labelOut+=(triplet.srcId->transOut)
                        Iterator((triplet.dstId, labelOut))
                  }
               }
                else if (triplet.srcAttr.stmtType=="Loop"){
                    var labelOut: Map[Long,Map[ArrayBuffer[Int],Double]] = Map()
                    var transOut:  Map[ArrayBuffer[Int],Double] = Map() 
                    var subexpr = triplet.srcAttr.content
                  //  println( "\n  "+subexpr )

                    if (triplet.attr=="true"){

                        for((w,t)<-curIn){
                           if(t>=precision && getExprVal(subexpr,w,varbTab)==1)
                                joinDistri(w,t, transOut)
                        }

                        if(transOut.isEmpty){   
                             Iterator.empty
                        }
                        else{
                             labelOut+=(inwhile->Map())  
                             labelOut+=(triplet.srcId->transOut)
                             Iterator((triplet.dstId, labelOut))
                        }

                    }
                    else{

                        for((w,t)<-curIn){
                           if(t>=precision && getExprVal(subexpr,w,varbTab)==0)
                                joinDistri(w,t, transOut)
                        }
                     

                       if(curIn.isEmpty){
                          //   println("22")
                            Iterator.empty
                       }
                       else  if (transOut.isEmpty){
                            if(triplet.dstAttr.stmtType != "Infer"){
                                 Iterator.empty
                            }   
                            else{
                                   labelOut+=(accu->Map())
                                 Iterator((  triplet.dstId, labelOut))///completed,收集的msg总和可以发了
                            }
                        }
                        else{

                            if(triplet.dstAttr.stmtType != "Infer"){
                                labelOut+=(triplet.srcId->transOut)
                                Iterator((triplet.dstId, labelOut))
                            }
                            else{
                                var preOut:  Map[ArrayBuffer[Int],Double] = Map()
                                if (triplet.dstAttr.inDistri.contains(triplet.srcId)){
                                    preOut = triplet.dstAttr.inDistri.getOrElse(triplet.srcId,Map())
                              
                                    for((w,t)<-preOut){
                                        joinDistri(w,t, transOut)
                                    }
                                }

                                labelOut+=(triplet.srcId->transOut)//Loop条件的false chain跳出循环
                                labelOut+=(duringWhile->Map())
                                Iterator((triplet.dstId, labelOut))
                            }
                           
                        }
                    }

               }
                 else if (triplet.srcAttr.stmtType=="For"){

                    var labelOut: Map[Long,Map[ArrayBuffer[Int],Double]] = Map()
                    var transOut:  Map[ArrayBuffer[Int],Double] = Map() 
                    val temparray = triplet.srcAttr.content.split("-")
                    val indexval= varbTab(temparray(0)) //下标，  Int型
                    val condi = temparray(1).toInt   //条件值 ，常量，也是Int型
                 
                    
                    if (triplet.attr=="true"){
                        //还是以curIn为准
                        //记得检查条件哦，小于的才给接受

                        for((w,t)<-curIn){
                             val posval = w(indexval)
                             if(posval<condi){
                                transOut+=(w->t)
                             }
                        }

                        if(transOut.isEmpty){   
                             Iterator.empty
                        }
                        else{
                             labelOut += (triplet.srcId->transOut)
                             labelOut += (inFor->Map())
                             Iterator((triplet.dstId, labelOut))
                        }
                    }
                    else{
                        //也以curIn为准
                        //记得检查条件哦，等于的才给发，而且要还原为0
                        for((w,t)<-curIn){
                             val posval = w(indexval)
                             if(posval>=condi){
                                 var arrayresult: ArrayBuffer[Int] = ArrayBuffer()
                                 arrayresult ++= w
                                 arrayresult(indexval) = 0  //下标值还原
                                 transOut+=(arrayresult->t)
                             }
                        }
                        
                        if(transOut.isEmpty){   
                             Iterator.empty
                        }
                        else{
                             labelOut += (triplet.srcId->transOut)
                             Iterator((triplet.dstId, labelOut))
                        }
                    }

                      

               }
                else if(triplet.srcAttr.stmtType == "Infer"){
                   val newcurIn = triplet.srcAttr.inDistri

                   if(triplet.srcAttr.inDistri.contains(duringWhile) && !triplet.srcAttr.inDistri.contains(accu)){
                       Iterator.empty
                   } 
                   else{
                        var labelOut: Map[Long,Map[ArrayBuffer[Int],Double]] = Map()
                        var transOut:  Map[ArrayBuffer[Int],Double] = Map() 
                        val targetpos = varbTab(triplet.srcAttr.content)
                        var targetarray : Map[Int,Double] = Map()

                        if(triplet.srcAttr.content!="ALL"){
                            for((w,t)<-curIn){
                                if( targetarray.contains(w(targetpos)) ){
                                   targetarray(w(targetpos)) += t
                                }
                               else{
                                   targetarray+=( w(targetpos)->t )
                                }
                            }

                            if(targetarray.isEmpty){
                                Iterator.empty
                            }
                            else{

                                for((k,v)<-targetarray){
                                    var result: ArrayBuffer[Int] = ArrayBuffer();
                                    result ++= iniDist
                                    result(targetpos)=k
                                    transOut+=(result->v)
                                }
                                labelOut+=(triplet.srcId->transOut)
                                Iterator((triplet.dstId, labelOut))
                            }
                        }
                        else{
                            for((w,t)<-curIn){
                                joinDistri(w,t, transOut)
                            }

                            if(transOut.isEmpty){
                                Iterator.empty
                            }
                            else{
                                labelOut+=(triplet.srcId->transOut)
                                Iterator((triplet.dstId, labelOut))
                            }
                        }
                   }
               }
                else if (triplet.srcAttr.stmtType == "DiscreteAssg"){
                  var labelOut: Map[Long,Map[ArrayBuffer[Int],Double]] = Map()
                  var transOut:  Map[ArrayBuffer[Int],Double] = Map() 

                  if (containWhile){
                     labelOut+=(inwhile->Map())  
                     transOut = inferOut(curIn, "DiscreteAssg", triplet.srcAttr.content, false)
                  }
                  else if (containFor){
                     labelOut+=(inFor->Map())  
                     transOut = inferOut(curIn, "DiscreteAssg", triplet.srcAttr.content, false)
                  }
                  else{
                     transOut = inferOut(curIn, "DiscreteAssg", triplet.srcAttr.content, false)
                  }

                 

                  if(transOut.isEmpty){   
                        Iterator.empty
                  }
                  else{
                         //block内的语句，若后继节点为for,记得自增
                        if(triplet.dstAttr.stmtType=="For"&& containFor){
                             val condi = triplet.dstAttr.content.split("-")(0)
                             var forIndex = varbTab(condi)
                             for((k,v)<-transOut){
                                 k(forIndex)=k(forIndex)+1
                             }
                        }
                        labelOut+=(triplet.srcId->transOut)
                        Iterator((triplet.dstId, labelOut))
                  }
                   

               }
               else{
                  Iterator.empty
               } 
            }  

        }




        /****************************
         * 11.  mergeMsg: (A, A) => A)
         *****************************/
      val aggregateMsgs = (map1: Map[Long,Map[ArrayBuffer[Int],Double]], map2: Map[Long,Map[ArrayBuffer[Int],Double]]) =>  map1 ++ map2


         var start_time =new Date().getTime

        /****************************
         * 12.  show the vertex's  out distribution
         *****************************/
         val influenceGraph = graph.pregel(firstMessage, iterations, edgeDirection)(updateVertex, sendMsg, aggregateMsgs)  

         var end_time =new Date().getTime 
         println(end_time-start_time)

         println("\n**************************************")
         println("          展示图属性")
        

        println("          终节点信息") 
        influenceGraph.vertices.filter{case (id,stmt)=>id==endflag}.collect.foreach{case (id, stmt) =>         
                   for( (k,v)<- stmt.inDistri) {
                           println("source id is: "+k)
                           for((w,t)<-v ){
                               println("  "+w+" , "+t)
                           }                              
                    }
         }
     

        





    }


  }
}