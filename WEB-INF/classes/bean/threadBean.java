package bean;

public class threadBean{
    private int thread_id;
    private String thread_name;
    private int comment_id;
    private String name;
    private String comment;

    public void setThread_id(int thread_id){
        this.thread_id = thread_id;
    }
    public int getThread_id(){
        return thread_id;
    }
    
    public void setThread_name(String thread_name){
        this.thread_name = thread_name;
    }
    public String getThread_name(){
        return thread_name;
    }
    
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