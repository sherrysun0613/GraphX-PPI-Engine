public class Stmt{


    String type;
    String content;

    int ID; 
    Stmt Tnext;
    Stmt Fnext;

   public Stmt(){
    type="";
    content="";
   
    ID=-1;
    Tnext=null;
    Fnext=null;
   }


   public String getType(){
       return type;
   }
   public void setType(String type){
     this.type=type;
   }

   public String getContent(){
    return content;
   }
   public void setContent(String content){
    this.content=content;
   }

   public int getID(){
    return ID;
    }
   public void setID(int ID){
       this.ID=ID;
   }

   public Stmt getTnext(){
    return Tnext;
   }
   public void setTnext(Stmt stmt1){
    this.Tnext=stmt1;
   }

   public Stmt getFnext(){
    return Fnext;
   }
   public void setFnext(Stmt stmt1){
    this.Fnext=stmt1;
   }


}