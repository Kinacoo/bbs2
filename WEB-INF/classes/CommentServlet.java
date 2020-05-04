import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.CommentInsert;
import database.CommentQuery;
import bean.commentBean;
import java.util.List;

public class CommentServlet extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
        doGet(req,res);
    }
    
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
        req.setCharacterEncoding("Windows-31J");
        
        String name = req.getParameter("name");
        String comment = req.getParameter("comment");
        
        System.out.println(name);
        System.out.println(comment);
        
        //DB‚É‘‚«‚İ
        CommentInsert.insert(name,comment);
    
        //ƒpƒ‰ƒ[ƒ^‚ğjsp‚É“]‘—
        List<commentBean> list = CommentQuery.getQueryList();
        
        req.setAttribute("list",list);
        
        RequestDispatcher rd = req.getRequestDispatcher("/read.jsp");
        rd.forward(req,res);
    }
}