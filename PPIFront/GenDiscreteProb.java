import java.io.InputStream;
import java.io.FileInputStream;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.*;


public class GenDiscreteProb{
        public static void main(String []args)throws Exception
        {
            String inputFile=null;
            if(args.length>0)inputFile=args[0];
            InputStream is = System.in;
            if(inputFile!=null) is = new FileInputStream(inputFile);

         //   long startTime = System.currentTimeMillis();    //symbol startTime

            ANTLRInputStream input = new ANTLRInputStream(is);
       
            //create lexer
            DiscretePLLexer lexer =new  DiscretePLLexer(input);
            //create token stream
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            //create parser
            DiscretePLParser parser =new DiscretePLParser(tokens);
           
       
            //launch the parser
            ParseTree tree =parser.prog(); //start at prog
            //System.out.println(tree.toStringTree(parser));

            ParseTreeWalker walker =new ParseTreeWalker();
            LoadVar loader=new LoadVar();
            walker.walk(loader,tree);
           
          //  long endTime = System.currentTimeMillis();    //get end time
          //  System.out.println("running time: " + (endTime - startTime) + "ms");    


           
            /*---------------------------------  1.  store variables --------------------------------- */
            /*---------------------------------2.   store stmt: nodes  --------------------------------- */
            /*--------------------------------- 3.   store edges  --------------------------------- */
            File writename1 = new File("/usr/local/lib/gram1/graphTab/stmtList.txt"); 
            
            File writename2 = new File("/usr/local/lib/gram1/graphTab/edgeList.txt"); 
            File writename3 = new File("/usr/local/lib/gram1/graphTab/variabTab.txt"); 

            writename1.createNewFile(); 
            writename2.createNewFile(); 
            writename3.createNewFile(); 
            BufferedWriter out1 = new BufferedWriter(new FileWriter(writename1));  
            BufferedWriter out2 = new BufferedWriter(new FileWriter(writename2));  
            BufferedWriter out3 = new BufferedWriter(new FileWriter(writename3)); 


          if(loader.varList.isEmpty()){
              String tmp="NULL";
              out3.write(tmp);
          }
          else{
            for(Map.Entry<String,Integer> entry : loader.varList.entrySet()){
                  String tmp1 = "";
                  tmp1=entry.getKey()+","+entry.getValue()+"\r\n";
                  out3.write(tmp1);
             }
          }
            
           
          int count=loader.stmts.size();
            int tag=count-1;
            for(int j=0;j<count;j++){
              Stmt tmp=loader.stmts.get(j);
              String atLast="\r\n";
              if(j==tag)
                 atLast="";

              String tmp1="";//  the stmt node  format is :  id, content, type
              tmp1=tmp.getID()+","+tmp.getContent()+","+tmp.getType()+atLast;
              out1.write(tmp1); 
             
              String tmp2=""; // the edge info is : srcId,dstId,EdgeType
              if(tmp.getTnext()!=null)
              {
                tmp2=tmp.getID()+","+tmp.getTnext().getID()+","+"true"+atLast;
                out2.write(tmp2); 
              }
              
              if(tmp.getFnext()!=null){
                tmp2=tmp.getID()+","+tmp.getFnext().getID()+","+"false"+atLast;
                out2.write(tmp2);
              }
            }

            out1.flush(); out2.flush(); out3.flush();
            out1.close(); out2.close(); out3.close();
            
            


         /*--------------------------------- 4.   store probs --------------------------------- */
          File writename4 = new File("/usr/local/lib/gram1/graphTab/doubleProbList.txt");
          writename4.createNewFile(); 
          BufferedWriter out4 = new BufferedWriter(new FileWriter(writename4));  
          if(loader.doubleList.isEmpty()){
             String tmp="NULL";
             out4.write(tmp);
          }
          else{
            for(Map.Entry<String,ArrayList<Double>> entry : loader.doubleList.entrySet()){
                 String tmp1 = "";
                 String tmp2 = "";
                 for (Double item: entry.getValue()) {
                  tmp2+=item.toString()+",";
                 }
                 tmp2+="\r\n";
                 tmp1=entry.getKey()+" "+tmp2;
                 out4.write(tmp1);
            }
          }

          /*--------------------------------- 5.   store bool and int  datas for observed  --------------------------------- */
          File writename5 = new File("/usr/local/lib/gram1/graphTab/intDataList.txt");
          writename5.createNewFile(); 
          BufferedWriter out5 = new BufferedWriter(new FileWriter(writename5));  
          if(loader.boolList.isEmpty()&&loader.intList.isEmpty()){
             String tmp="NULL";
             out5.write(tmp);
          }
          else{
            for(Map.Entry<String,ArrayList<Integer>> entry : loader.boolList.entrySet()){
                 String tmp1 = "";
                 String tmp2 = "";
                 for (Integer item: entry.getValue()) {
                  tmp2+=item.toString()+",";
                 }
                 tmp2+="\r\n";
                 tmp1=entry.getKey()+" "+tmp2;
                 out5.write(tmp1);
            }
            for(Map.Entry<String,ArrayList<Integer>> entry : loader. intList.entrySet()){
              String tmp1 = "";
              String tmp2 = "";
              for (Integer item: entry.getValue()) {
               tmp2+=item.toString()+",";
              }
              tmp2+="\r\n";
              tmp1=entry.getKey()+" "+tmp2;
              out5.write(tmp1);
          }
         }

          out4.flush(); out5.flush(); 
          out4.close(); out5.close();

          







           
            
            
          
          

           



        }

}