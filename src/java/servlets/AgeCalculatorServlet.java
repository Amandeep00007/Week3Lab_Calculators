package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static java.lang.Integer.parseInt;

/**
 *
 * @author amand
 */
public class AgeCalculatorServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                .forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String age = request.getParameter("age");
      request.setAttribute("age", age);
      String message= "";
      
     if (age == null || age.equals("")){
         
         request.setAttribute("message", "You must enter a number");
         getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                 .forward(request, response);
         
         
     }
     else{
     
     try{
           int parsedAge = Integer.parseInt(age);
           
     }
     catch(NumberFormatException e){
            message="You must enter a number";
            request.setAttribute("message", message);
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp")
                .forward(request, response);
            return;
        }
        request.setAttribute("message", "your age next birthday will be "+(parseInt(age)+ 1));
        
        request.setAttribute("message", message);
        
        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp")
                .forward(request, response);
        }
    }
         
     }
     

