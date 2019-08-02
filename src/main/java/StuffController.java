import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StuffController extends HttpServlet {

    private static final long serialVersionUD=1L;
    private DAOStuff stuffDao = DAOStuff.getInstance();
    private static final Logger LOGGER = Logger.getLogger(StuffController.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String action = req.getServletPath();
        try {
            switch (action){
                case "/new":
                    showNewForm(req,resp);
                    break;
                case "/insert":
                    insertStuff(req,resp);
                    break;
                case "/delete":
                    deleteStuff(req,resp);
                    break;
                //case "/edit":
                 //   editStuff(req,resp);
                //    break;
                case "/update":
                    updateStuff(req,resp);
                    break;
                 default:
                   //  listStuff(req,resp);
                 //    break;
            }
        }catch(SQLException e){
                LOGGER.log(Level.SEVERE,"SQL Error",e );
        }
    }

    private void updateStuff(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException, SQLException{
        int id=Integer.parseInt(req.getParameter("id"));
        String name=req.getParameter("name");
        String description=req.getParameter("description");
        int quantity=Integer.parseInt(req.getParameter("quantity"));
        String location=req.getParameter("location");

        Stuff stuff = new Stuff(id,name,description,quantity,location);
        stuffDao.update(stuff);
        resp.sendRedirect("list");
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException, SQLException{
        String id=req.getParameter("id");
        Optional<Stuff> existingStuff = stuffDao.find(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/StuffForm.jsp");
        existingStuff.ifPresent(s->req.setAttribute("stuff",s));
        dispatcher.forward(req,resp);
    }

    private void deleteStuff(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException, SQLException{
        int id = Integer.parseInt(req.getParameter("id"));
        Stuff stuff = new Stuff(id);
        stuffDao.delete(stuff);
        resp.sendRedirect("list");
    }

    private void insertStuff(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException, SQLException{
        String name=req.getParameter("name");
        String description=req.getParameter("description");
        int quantity=Integer.parseInt(req.getParameter("quantity"));
        String location=req.getParameter("location");

        Stuff newStuff = new Stuff(name,description,quantity,location);
        stuffDao.save(newStuff);
        resp.sendRedirect("list");
    }




}
