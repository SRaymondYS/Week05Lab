package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 794471
 */
public class ShoppingListServlet extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        handleIt(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        handleIt(request, response);
    }

    
    private void handleIt(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        
        String action = request.getParameter("action");
        String name = request.getParameter("name");
        
        
        if(action != null)
        {
            if(action.equals("register"))
            {               
                session.setAttribute("username", name);
                
                ArrayList<String> itemList = new ArrayList<>();
                session.setAttribute("list", itemList);
            }
            else if(action.equals("logout"))
            {
                session.invalidate();
                
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                    .forward(request, response);
            }
            else if(action.equals("add"))
            {
                String str = request.getParameter("item");
                ArrayList tempList = (ArrayList) session.getAttribute("list");
                tempList.add(str);
                session.setAttribute("list", tempList);
            }
            else if(action.equals("delete"))
            {
                String str = request.getParameter("thing");
                ArrayList tempList = (ArrayList) session.getAttribute("list");
                tempList.remove(str);
                session.setAttribute("list", tempList);
            }
        }

        
        String username = (String) session.getAttribute("username");
        ArrayList list = (ArrayList) session.getAttribute("list");
        
        if(username == null)
        {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                .forward(request, response);
        }
        else 
        {
            request.setAttribute("name", username);           
            request.setAttribute("displayList", list);
            
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                .forward(request, response);
        }
        
    }
    
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() 
    {
        return "Short description";
    }
}