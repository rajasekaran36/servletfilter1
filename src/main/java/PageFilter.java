import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

public class PageFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("PageFilter Initiated");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
            
            response.setContentType("text/html");

            String userName = request.getParameter("uname");
            String passWord = request.getParameter("password");

            if(DBHandler.checkUser(userName, passWord)){
                System.out.println("DB Data ok");
                chain.doFilter(request, response);
            }

            else{
                response.getWriter().println("You are not qualified to login");
            }

    }

    @Override
    public void destroy() {

        System.out.println("PageFilter Destroyed");

    }

}