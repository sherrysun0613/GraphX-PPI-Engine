import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.Interval;

import java.io.File;
import  java.io.FileInputStream;
import  java.io.InputStream;
import  java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader; 

public class LoadVar extends DiscretePLBaseListener{

    
     /*------------------   laoding data or variable   -------------------*/

     /**  load   data */
     public  String storeData(String pathname){
        try { 
            File filename = new File(pathname); 
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); 
            BufferedReader br = new BufferedReader(reader); 
           
            StringBuilder sb = new StringBuilder();
            String line = "";
            line = br.readLine();
            String  res="";
            while (line != null) {

                String[] strarray=line.split(" |\t|,"); 
                for (int i = 0; i < strarray.length; i++) {
                    sb.append(strarray[i]+"," );
                }
                
                line = br.readLine(); 
            }
            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
     }

      /**  load   bool but as int  */
     public   ArrayList<Integer> storeBool(String pathname){

        String res = storeData(pathname);
        String[] strarray=res.split(","); 
        int n = strarray.length;
        ArrayList<Integer> al1 = new ArrayList<Integer>();
 
        for(int i =0;i <n;i++){
            if(strarray[i].length()>0)  al1.add(Integer.valueOf(strarray[i]));
        }

        return al1;
     }

     /**  load   int */
     public  ArrayList<Integer> storeInt(String pathname){

        String res = storeData(pathname);
        String[] strarray=res.split(","); 
        int n = strarray.length;
        ArrayList<Integer> al1 = new ArrayList<Integer>();

        for(int i =0;i <n;i++){

             if(strarray[i].length()>0)  al1.add(Integer.valueOf(strarray[i]));
        }
   
        return al1;
     }

     /**  load  double */
     public   ArrayList<Double> storeDouble(String pathname){

        String res = storeData(pathname);
        String[] strarray=res.split(","); 
        int n = strarray.length;
        ArrayList<Double> al1 = new ArrayList<Double>();

        for(int i =0;i <n;i++){
            if(strarray[i].length()>0) al1.add(Double.valueOf(strarray[i]));
        }

        return al1;
    }


    //Discrete parser;
    //public LoadVar(DiscretePLParser parser){this.parser=parser;}
    

    /**  variable   table: name-type */
    //Integer symbolI = 1;  //int
    //Integer symbolD = 2;  //discrete
    int varcount = 0;
    Map<String,Integer>  varList = new HashMap<String, Integer>();//variable table
    /**  discrete variable table: name - pos */
    //int disCount=0;
    //Map<String,Integer>  discreteVar = new HashMap<String, Integer>();

  
     
     /**  bool Array table: name - pos */
     Map<String,ArrayList<Integer>>  boolList = new HashMap<String, ArrayList<Integer>>();

     /**  int Array table: name - pos */
     Map<String,ArrayList<Integer>>  intList = new HashMap<String,ArrayList<Integer>>();

    /**  double Array table: name - array */
    Map<String,ArrayList<Double>>  doubleList = new HashMap<String, ArrayList<Double>>();

    /**  int constant table: name-value */
    Map<String,Integer>  conList = new HashMap<String, Integer>();



    @Override 
    public void enterBoolVar(DiscretePLParser.BoolVarContext ctx) { 
        
        int i=0;
        String id="";
        
        while(ctx.ID(i)!=null){
         id=ctx.ID(i).getText();
         varList.put(id,  Integer.valueOf(varcount));
         varcount++;
         i++;
        }

    }


    @Override 
    public void enterIntVar(DiscretePLParser.IntVarContext ctx) { 
        int i=0;
        String id="";
        
        while(ctx.ID(i)!=null){
            id=ctx.ID(i).getText();
            varList.put(id, Integer.valueOf(varcount));
            varcount++;
            i++;
        }

    }




    //these are constant int val
    @Override 
     public void enterIntData(DiscretePLParser.IntDataContext ctx) { 

       String name= ctx.ID().getText();
       Integer conval = Integer.valueOf(ctx.INT().getText());
       conList.put(name,conval);

    }

    //bool array 
    @Override 
     public void enterBoolArray(DiscretePLParser.BoolArrayContext ctx) { 

        int i=0;
        String id=ctx.ID().getText();
        String val="";
        ArrayList<Integer> al1 = new ArrayList<Integer>();
        
        while(ctx.C(i)!=null){
            val=ctx.C(i).getText();
            if(val.equals("true")) {  al1.add(1); }
            else                   {  al1.add(0);  }
            i++;
        }

        boolList.put(id, al1);

    }

    //int array
    @Override 
     public void enterIntArray(DiscretePLParser.IntArrayContext ctx) {

        int i=0;
        String id=ctx.ID().getText();
        String val="";
        ArrayList<Integer> al1 = new ArrayList<Integer>();
        
        while(ctx.INT(i)!=null){
            val=ctx.INT(i).getText();
            al1.add(Integer.valueOf(val));
            i++;
        }
        intList.put(id, al1);
    }

   //double array
   @Override 
     public void enterDoubleArray(DiscretePLParser.DoubleArrayContext ctx) { 
        int i=0;
        String id=ctx.ID().getText();
        String val="";
        ArrayList<Double> al1 = new ArrayList<Double>();
        
        while(ctx.DOUBLE(i)!=null){
            val=ctx.DOUBLE(i).getText();
            al1.add(Double.valueOf(val));
            i++;
        }
        doubleList.put(id, al1);
      
    }


    //these are many to bool data
    @Override 
     public void enterBoolRead(DiscretePLParser.BoolReadContext ctx) { 
        String id=ctx.ID().getText();
        String pathname = ctx.FILENAME().getText();
        boolList.put(id, storeBool(pathname));
    }

    @Override 
     public void enterIntRead(DiscretePLParser.IntReadContext ctx) { 
        String id=ctx.ID().getText();
        String pathname = ctx.FILENAME().getText();
        intList.put(id, storeInt(pathname));
    }

    @Override 
     public void enterDoubleRead(DiscretePLParser.DoubleReadContext ctx) { 
        String id=ctx.ID().getText();
        String pathname = ctx.FILENAME().getText();
        doubleList.put(id, storeDouble(pathname));
    }











     /*------------------   following are extends Bernoulli   -------------------*/


    /**stmt and patten numbers */
    int stmtNums=0;
    int patternNums=0;

    /** list of stmts */
    List<Stmt> stmts= new ArrayList<Stmt>();

    /** temporary store*/
    Stack<Stmt> stack=new Stack<Stmt>();//



    /**
     *   empty-> not inwhile ,not in if
     *    0  ->    set just enter while ,and then in it
     *    1  ->    pop and set  when leave while         last is while tail ,next time pop
     * 
     *    3  ->    set just enter if, and then  in it
     *    4  ->    pop and set when leave if  
     *    5  ->    during else   
     *    6  ->    leave else 
     * 
     *    9  ->    set just enter for ,and then in it
     *    10 ->    pop and set  when leave for         last is for tail ,next time pop
     */
    Stack<Integer> inBlock=new Stack<Integer>();
    /**  current while head */
    Stack<Stmt>loops=new Stack<Stmt>();
    /*  current if-else head */
    Stack<Stmt> ifExpr = new Stack<Stmt>();
    Stack<Stmt> ifTails = new Stack<Stmt>();
    Stack<Integer> tailsNumber = new Stack<Integer>();
    /** current for head */
    Stack<Stmt>fors=new Stack<Stmt>();

    
   
    //Stack<Boolean>inwhile=new Stack<Boolean>();

    Stmt front;



   // boolean inif=false;

    //filter the whitespace
    public String filterStr(String content){
        String res="";
        int len = content.length();
        int offset = 0;
       while(offset<len){
           if(content.charAt(offset)!=' ')
             res+=content.charAt(offset);
             offset++;
       }
       return res;
    }

    /**  'while'  '(' expr ')'  '{' NL stat+ NL* '}' NL+  */
    @Override 
    public void enterLoop(DiscretePLParser.LoopContext ctx) { 
        stmtNums++;
        patternNums++;

        Stmt stmt1=new Stmt();
        stmt1.setType("Loop");
        String content="";
        content=ctx.expr().getText();
        stmt1.setContent(filterStr(content));
        stmt1.setID(stmtNums);
        stmts.add(stmt1);


        if(!stack.empty())//chain have tail
        {
            
            if (!inBlock.empty()&&inBlock.peek()==6){  // after a parallel if-else
               
                int n = tailsNumber.pop().intValue();
                int i = 0;
                while(i<n){
                    Stmt tmp = ifTails.pop();
                   if(tmp.type=="Loop" || tmp.type=="For" ){
                    tmp.setFnext(stmt1);
                   }
                   else{
                    tmp.setTnext(stmt1);
                   }
                   i++;
                }

                inBlock.pop();
                stack.pop();
                stack.push(stmt1);
                loops.push(stmt1);   

            }
            else if (!inBlock.empty()&&inBlock.peek()==4){     //just after 'else'
                Stmt tmp=ifExpr.pop();
                tmp.setFnext(stmt1);

                inBlock.pop();
                inBlock.push(5);
                stack.push(stmt1);
                loops.push(stmt1);          

            }
            else if ((stack.peek().getType()=="Loop"||stack.peek().getType()=="For")&&stack.peek().getTnext()!=null){  //before stmt is parallel while/For block,not in while/for
                Stmt tmp=stack.pop();
                tmp.setFnext(stmt1);  //be careful with the false child
                stack.push(stmt1);
                loops.push(stmt1);

                inBlock.pop();//before while stat can clear
                //inwhile.pop();
            }
            else //other case
            {
                Stmt tmp=stack.pop();
                tmp.setTnext(stmt1);
                stack.push(stmt1);
                loops.push(stmt1);
            }
           
        }
        else{
            stack.push(stmt1);
            front=stmt1;
            loops.push(stmt1);
        }
        
        inBlock.push(0);//enterwhile
        //inwhile.push(true);
    }

    @Override 
    public void exitLoop(DiscretePLParser.LoopContext ctx) { 


        Stmt currentLoop=loops.pop();
       
        //Stmt ending=stack.pop();

        if (!inBlock.empty()&&inBlock.peek()==6){  //  a parallel if-else at last
               
            int n = tailsNumber.pop().intValue();
            int i = 0;
            while(i<n){

               Stmt tmp = ifTails.pop();
               if(tmp.type=="Loop" || tmp.type=="For"){
                tmp.setFnext(currentLoop);
               }
               else{
                tmp.setTnext(currentLoop);
               }
               i++;
            }
            inBlock.pop();
            stack.push(currentLoop);
        }
        else {
            
            Stmt ending=stack.peek();
            if(ending.getType()=="Loop"||ending.getType()=="For"){ // while/For  at  last
                ending.setFnext(currentLoop);
                stack.push(currentLoop);
            }
            else{//sequence or conditional at  while last
                ending.setTnext(currentLoop);
                stack.push(currentLoop);
            }
        }

        if(!inBlock.empty()){
            inBlock.pop();
            inBlock.push(1);  
        }
      
    }

    /**  'if'  '(' expr ')' NL  stat ';' NL+ 'else'  NL stat  */
   @Override 
   public void enterConditional(DiscretePLParser.ConditionalContext ctx) { 
       stmtNums++;
       patternNums++;

        Stmt stmt1=new Stmt();
        stmt1.setType("Conditional");
        String content="";
        content=ctx.expr().getText();
        stmt1.setContent(filterStr(content));
        stmt1.setID(stmtNums);
        stmts.add(stmt1);

        if(!stack.empty()) //chain have tail
        {
            if (!inBlock.empty()&&inBlock.peek()==6){  // after a if-else
                
               
                int n = tailsNumber.pop().intValue();
                int i = 0;
                while(i<n){
                    Stmt tmp = ifTails.pop();
                   if(tmp.type=="Loop" || tmp.type=="For"){
                    tmp.setFnext(stmt1);
                   }
                   else{
                    tmp.setTnext(stmt1);
                   }
                   i++;
                }

                stack.pop();
                inBlock.pop();
                stack.push(stmt1);
                ifExpr.push(stmt1); 
                
            }
            else if (!inBlock.empty()&&inBlock.peek()==4){     //just after 'else'
                Stmt tmp=ifExpr.pop();
                tmp.setFnext(stmt1);

                inBlock.pop();
                inBlock.push(5);
                stack.push(stmt1);
                ifExpr.push(stmt1);          

            }
            else if(!inBlock.empty()&&(inBlock.peek()==1||inBlock.peek()==10)){  //after a parallel while/For 
                Stmt tmp=stack.pop();
                tmp.setFnext(stmt1);
                stack.push(stmt1);
                inBlock.pop();
                ifExpr.push(stmt1);

            }
            else{
                Stmt tmp=stack.pop();
                tmp.setTnext(stmt1);
                stack.push(stmt1);
                ifExpr.push(stmt1);
            }
        }
        else{
            stack.push(stmt1);
            front=stmt1;
            ifExpr.push(stmt1);
        }

        
        inBlock.push(3);   //enter  if 
         //inif=true;
   }

   //current if is scanned over
   @Override 
   public void enterEbranch(DiscretePLParser.EbranchContext ctx) { 


        if(!inBlock.empty()&&inBlock.peek()==6){  // if's  last : if-else 
            inBlock.pop();

            int pre = tailsNumber.pop().intValue(); //before total tails
            tailsNumber.push(Integer.valueOf(pre));
        }
        else{
            tailsNumber.push(Integer.valueOf(1));
            ifTails.push(stack.peek());
        }

        if(!inBlock.empty()){
            inBlock.pop();   //enter  if 
            inBlock.push(4); // 
        }
    
   }



   @Override 
   public void exitConditional(DiscretePLParser.ConditionalContext ctx) { 

        if(!inBlock.empty()&&inBlock.peek()==6){  // else's  last : if-else  
            inBlock.pop();
            int pre = tailsNumber.pop().intValue();  //else tails
            pre += tailsNumber.pop().intValue();    // if tails
            tailsNumber.push(Integer.valueOf(pre));
        }
        else{
            int pre = tailsNumber.pop().intValue(); // adjacent if
            pre=pre+1;
            tailsNumber.push(Integer.valueOf(pre));
            ifTails.push(stack.peek());
        }

        if(!inBlock.empty()){
            inBlock.pop();
            inBlock.push(6);  
        }

    }



   /** ID  '='   expr  */
   @Override 
   public void exitDeterAssg(DiscretePLParser.DeterAssgContext ctx) { 
       stmtNums++;

        Stmt stmt1=new Stmt();
        stmt1.setType("DeterAssg");
        String content="";
        content=ctx.ID().getText()+'-'+ctx.expr().getText();
        stmt1.setContent( filterStr(content));
        stmt1.setID(stmtNums);
        stmts.add(stmt1);
        
        if(!stack.empty())//chain have tail
        {

            if (!inBlock.empty()&&inBlock.peek()==6){  // after a parallel if-else
               
                int n = tailsNumber.pop().intValue();
                int i = 0;
                while(i<n){
                    Stmt tmp = ifTails.pop();
                   if(tmp.type=="Loop" || tmp.type=="For"){
                    tmp.setFnext(stmt1);
                   }
                   else{
                    tmp.setTnext(stmt1);
                   }
                   i++;
                }

                inBlock.pop();
                stack.pop();
                stack.push(stmt1);
            }
            else if (!inBlock.empty()&&inBlock.peek()==4){     //just after 'else'
                Stmt tmp=ifExpr.pop();
                tmp.setFnext(stmt1);

                inBlock.pop();
                inBlock.push(5);
                stack.push(stmt1);       
            }
            else if (!inBlock.empty()&&(inBlock.peek()==1||inBlock.peek()==10)){  //before stmt is parallel while/For  
                Stmt tmp=stack.pop();
                tmp.setFnext(stmt1);  //be careful with the false child
                stack.push(stmt1);
                inBlock.pop();//before while stat can clear
                //inwhile.pop();
            }
            else{
                Stmt tmp=stack.pop();
                tmp.setTnext(stmt1);
                stack.push(stmt1);
            }




            
        }
        else{
            stack.push(stmt1);
            front=stmt1;
        }

        





        
        
   }

   /** ID  '='  'Bernoulli'  '(' R ')'      */
   @Override 
   public void exitBernoulliAssg(DiscretePLParser.BernoulliAssgContext ctx) {
        stmtNums++;
  
        Stmt stmt1=new Stmt();
        stmt1.setType("BernoulliAssg");

        String content="";
        if(ctx.r().getText().contains("[")){
             String[] nameparameters=ctx.r().getText().split("\\[|\\]"); 
             content=ctx.ID().getText()+"-"+nameparameters[0]+"-"+nameparameters[1];
        }
        else{
             content=ctx.ID().getText()+"-"+ctx.r().getText();
        }
        stmt1.setContent(filterStr(content));
        stmt1.setID(stmtNums);
        stmts.add(stmt1);

        if(!stack.empty())//chain have tail
        {  
            if (!inBlock.empty()&&inBlock.peek()==6){  // after a parallel if-else
               
                int n = tailsNumber.pop().intValue();
                int i = 0;
                while(i<n){
                    Stmt tmp = ifTails.pop();
                   if(tmp.type=="Loop" || tmp.type=="For"){
                    tmp.setFnext(stmt1);
                   }
                   else{
                    tmp.setTnext(stmt1);
                   }
                   i++;
                }

                inBlock.pop();
                stack.pop();
                stack.push(stmt1);
            }
            else if (!inBlock.empty()&&inBlock.peek()==4){     //just after 'else'
                Stmt tmp=ifExpr.pop();
                tmp.setFnext(stmt1);

                inBlock.pop();
                inBlock.push(5);
                stack.push(stmt1);       
            }
            else if (!inBlock.empty()&&(inBlock.peek()==1||inBlock.peek()==10)){  //before stmt is parallel while 
                Stmt tmp=stack.pop();
                tmp.setFnext(stmt1);  //be careful with the false child
                stack.push(stmt1);
                inBlock.pop();//before while stat can clear
                //inwhile.pop();
            }
            else{
                Stmt tmp=stack.pop();
                tmp.setTnext(stmt1);
                stack.push(stmt1);
            }

        }
        else{
            stack.push(stmt1);
            front=stmt1;
        }
    }

    /** 'observe'  '('  expr  ')'     */
    @Override 
    public void exitObserve(DiscretePLParser.ObserveContext ctx) { 
        stmtNums++;
        
        Stmt stmt1=new Stmt();
        stmt1.setType("Observe");
        String content="";
        content=ctx.expr().getText();
        stmt1.setContent( filterStr(content));
        stmt1.setID(stmtNums);
        stmts.add(stmt1);

        if(!stack.empty())//chain have tail
        {
            if (!inBlock.empty()&&inBlock.peek()==6){  // after a parallel if-else
               
                int n = tailsNumber.pop().intValue();
                int i = 0;
                while(i<n){
                    Stmt tmp = ifTails.pop();
                   if(tmp.type=="Loop" || tmp.type=="For"){
                    tmp.setFnext(stmt1);
                   }
                   else{
                    tmp.setTnext(stmt1);
                   }
                   i++;
                }

                inBlock.pop();
                stack.pop();
                stack.push(stmt1);
            }
            else if (!inBlock.empty()&&inBlock.peek()==4){     //just after 'else'
                Stmt tmp=ifExpr.pop();
                tmp.setFnext(stmt1);

                inBlock.pop();
                inBlock.push(5);
                stack.push(stmt1);       
            }
            else if (!inBlock.empty()&&(inBlock.peek()==1||inBlock.peek()==10)){  //before stmt is parallel while 
                Stmt tmp=stack.pop();
                tmp.setFnext(stmt1);  //be careful with the false child
                stack.push(stmt1);
                inBlock.pop();//before while stat can clear
                //inwhile.pop();
            }
            else{
                Stmt tmp=stack.pop();
                tmp.setTnext(stmt1);
                stack.push(stmt1);
            }

        }
        else{
            stack.push(stmt1);
            front=stmt1;
        }
    }


    @Override 
    public void exitDiscreteAssg(DiscretePLParser.DiscreteAssgContext ctx) {
        stmtNums++;
        
        Stmt stmt1=new Stmt();
        stmt1.setType("DiscreteAssg");
        String content="";
        content=ctx.ID().getText()+"-"+ctx.r().getText();
        stmt1.setContent(filterStr(content));
        stmt1.setID(stmtNums);
        stmts.add(stmt1);

        if(!stack.empty())//chain have tail
        {
            if (!inBlock.empty()&&inBlock.peek()==6){  // after a parallel if-else
               
                int n = tailsNumber.pop().intValue();
                int i = 0;
                while(i<n){
                    Stmt tmp = ifTails.pop();
                   if(tmp.type=="Loop" || tmp.type=="For"){
                    tmp.setFnext(stmt1);
                   }
                   else{
                    tmp.setTnext(stmt1);
                   }
                   i++;
                }

                inBlock.pop();
                stack.pop();
                stack.push(stmt1);
            }
            else if (!inBlock.empty()&&inBlock.peek()==4){     //just after 'else'
                Stmt tmp=ifExpr.pop();
                tmp.setFnext(stmt1);

                inBlock.pop();
                inBlock.push(5);
                stack.push(stmt1);       
            }
            else if (!inBlock.empty()&&(inBlock.peek()==1||inBlock.peek()==10)){  //before stmt is parallel while 
                Stmt tmp=stack.pop();
                tmp.setFnext(stmt1);  //be careful with the false child
                stack.push(stmt1);
                inBlock.pop();//before while stat can clear
                //inwhile.pop();
            }
            else{
                Stmt tmp=stack.pop();
                tmp.setTnext(stmt1);
                stack.push(stmt1);
            }
            



        }
        else{
            stack.push(stmt1);
            front=stmt1;
        }

     }







   /** stat   ';'  stat?      */
   @Override 
   public void exitSequential(DiscretePLParser.SequentialContext ctx) { 
      //stmtNums++;
      patternNums++;
   }

   /** NL+    */
   @Override 
   public void exitSkip(DiscretePLParser.SkipContext ctx) { 

   }



   @Override 
   public void enterForfold(DiscretePLParser.ForfoldContext ctx) { 
    stmtNums++;
    patternNums++;

    Stmt stmt1=new Stmt();
    stmt1.setType("For");
    String content="";

    if(conList.containsKey(ctx.r().getText())){
        //System.out.println(ctx.r().getText()+"#");
        Integer item = conList.get(ctx.r().getText());
        content=ctx.ID().getText()+"-"+Integer.toString(item);
   }
   else{
        content=ctx.ID().getText()+"-"+ctx.r().getText();
   }

   
    stmt1.setContent(filterStr(content));
    stmt1.setID(stmtNums);
    stmts.add(stmt1);

     

    if(!stack.empty())//chain have tail
    {
        
        if (!inBlock.empty()&&inBlock.peek()==6){  // after a parallel if-else
           
            int n = tailsNumber.pop().intValue();
            int i = 0;
            while(i<n){
                Stmt tmp = ifTails.pop();
               if(tmp.type=="Loop" || tmp.type=="For"){
                tmp.setFnext(stmt1);
               }
               else{
                tmp.setTnext(stmt1);
               }
               i++;
            }

            inBlock.pop();
            stack.pop();
            stack.push(stmt1);
            fors.push(stmt1);   
        }
        else if (!inBlock.empty()&&inBlock.peek()==4){     //just after 'else'
            Stmt tmp=ifExpr.pop();
            tmp.setFnext(stmt1);

            inBlock.pop();
            inBlock.push(5);
            stack.push(stmt1);
            fors.push(stmt1);          

        }
        else if ((stack.peek().getType()=="Loop"||stack.peek().getType()=="For")&&stack.peek().getTnext()!=null){  //before stmt is parallel while/For block
            Stmt tmp=stack.pop();
            tmp.setFnext(stmt1);  //be careful with the false child
            stack.push(stmt1);
            fors.push(stmt1);

            inBlock.pop();//before while stat can clear
            //inwhile.pop();
        }
        else //other case
        {
            Stmt tmp=stack.pop();
            tmp.setTnext(stmt1);
            stack.push(stmt1);
            fors.push(stmt1);
        }
       
    }
    else{
        stack.push(stmt1);
        front=stmt1;
        loops.push(stmt1);
    }
    
    inBlock.push(9);//enterwhile
    //inwhile.push(true);

   }

   @Override 
   public void exitForfold(DiscretePLParser.ForfoldContext ctx) { 


    Stmt currentFor=fors.pop();
   
    //Stmt ending=stack.pop();

    if (!inBlock.empty()&&inBlock.peek()==6){  //  a parallel if-else at last
           
        int n = tailsNumber.pop().intValue();
        int i = 0;
        while(i<n){

           Stmt tmp = ifTails.pop();
           if(tmp.type=="Loop" || tmp.type=="For"){
            tmp.setFnext(currentFor);
           }
           else{
            tmp.setTnext(currentFor);
           }
           i++;
        }
        inBlock.pop();
        stack.push(currentFor);
    }
    else {
        
        Stmt ending=stack.peek();
        if(ending.getType()=="Loop"||ending.getType()=="For"){ // while or For at  last
            ending.setFnext(currentFor);
            stack.push(currentFor);
        }
        else{//sequence or conditional at  while last
            ending.setTnext(currentFor);
            stack.push(currentFor);
        }
    }

    if(!inBlock.empty()){
        inBlock.pop();
        inBlock.push(10);  
    }

   }

   //if has ID, then calculate excepatation ;else nothing to do

   @Override 
   public void exitInferExpectation(DiscretePLParser.InferExpectationContext ctx) { 

        stmtNums++;
        
        Stmt stmt1=new Stmt();
        stmt1.setType("Infer");
        String content="";
        content=ctx.ID().getText();
        stmt1.setContent(filterStr(content));
        stmt1.setID(stmtNums);
        stmts.add(stmt1);

        if(!stack.empty())//chain have tail
        {
            if (!inBlock.empty()&&inBlock.peek()==6){  // after a parallel if-else
               
                int n = tailsNumber.pop().intValue();
                int i = 0;
                while(i<n){
                    Stmt tmp = ifTails.pop();
                   if(tmp.type=="Loop" || tmp.type=="For"){
                    tmp.setFnext(stmt1);
                   }
                   else{
                    tmp.setTnext(stmt1);
                   }
                   i++;
                }

                inBlock.pop();
                stack.pop();
                stack.push(stmt1);
            }
            else if (!inBlock.empty()&&inBlock.peek()==4){     //just after 'else'
                Stmt tmp=ifExpr.pop();
                tmp.setFnext(stmt1);

                inBlock.pop();
                inBlock.push(5);
                stack.push(stmt1);       
            }
            else if (!inBlock.empty()&&(inBlock.peek()==1||inBlock.peek()==10)){  //before stmt is parallel while 
                Stmt tmp=stack.pop();
                tmp.setFnext(stmt1);  //be careful with the false child
                stack.push(stmt1);
                inBlock.pop();//before while/For stat can clear
            }
            else{
                Stmt tmp=stack.pop();
                tmp.setTnext(stmt1);
                stack.push(stmt1);
            }

        }
        else{
            stack.push(stmt1);
            front=stmt1;
        }

   }



    

    @Override 
    public void exitProg(DiscretePLParser.ProgContext ctx) {
        
     }


}