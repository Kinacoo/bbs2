package bean;

import java.io.Serializable;

public class commentBean implements Serializable{
    private int comment_id;
    private String name;
    private String comment;
    
    public void setComment_id(int comment_id){
        this.comment_id = comment_id;
    }
    public int getComment_id(){
        return comment_id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    
    public void setComment(String comment){
        this.comment = comment;
    }
    public String getComment(){
        return comment;
    }
}


