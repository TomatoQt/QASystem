package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;

@WebFilter(filterName = "EncodingFilter", urlPatterns = {"/*"})
public class EncodingFilter extends HttpFilter implements Filter {
    public void destroy() {
        System.out.println("EncodingFilter destroyed.");
    }

    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String method=req.getMethod();

        if (method.equalsIgnoreCase("post")){
            System.out.println("post --request");
            req.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;charset=utf-8");
        }else {//get
            System.out.println("get --request");

            Enumeration<String> enumeration= req.getParameterNames();
            while(enumeration.hasMoreElements()) {
                String key = enumeration.nextElement();
                String[] values = req.getParameterValues(key);
                // 对值进行字符集的编码设置
                for(int i=0; i<values.length; i++) {
                    values[i] = new String(values[i].getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
                }
            }
        }

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("EncodingFilter initialized.");
        super.init();
    }

}
