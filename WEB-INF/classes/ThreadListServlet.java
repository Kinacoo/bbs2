import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class ThreadListServlet extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
        doGet(req,res);
    }
    
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
        req.setCharacterEncoding("Windows-31J");

        

        

        //ÉpÉâÉÅÅ[É^ÇjspÇ…ì]ëó
        List<commentBean> list = CommentQuery.getQueryList();

        req.setAttribute("list",list);

        RequestDispatcher rd = req.getRequestDispatcher("/threadlist.jsp");
        rd.forward(req,res);
    }
}