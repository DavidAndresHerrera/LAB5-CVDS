import java.io.IOException;
import java.io.Writer;
import java.util.Optional;


@WebServlet(
	    urlPatterns = "/AndresyDavidServlet"
)


public class TimeServlet extends HttpServlet{
	
	public TimeServlet() {
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Writer responseWriter = resp.getWriter();
       Optional<String> optName = Optional.ofNullable(req.getParameter("name"));
       String name = optName.isPresent() && !optName.get().isEmpty() ? optName.get() : "";

       resp.setStatus(HttpServletResponse.SC_OK);
       responseWriter.write("Hello" + name + "!");
       responseWriter.flush();
    }
	

}
