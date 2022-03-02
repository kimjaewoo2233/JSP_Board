package urlServlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import memberDB.MemberDAO;
import memberDB.MemberDTO;

@WebServlet("/LoginProcess.do")
public class LoginServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws 
				IOException,ServletException{
				
				HttpSession session = req.getSession(true);
				
				String user_id = req.getParameter("user_id");
				String user_pw = req.getParameter("user_pw");
		
				ServletContext application = getServletContext();
				
				String oracleDriver = application.getInitParameter("OracleDriver");
				String oracleURL = application.getInitParameter("OracleURL");
				String oracleId = application.getInitParameter("OracleId");
				String oraclePwd = application.getInitParameter("OraclePwd");
				
				MemberDAO dao = new MemberDAO(oracleDriver,oracleURL,oracleId,oraclePwd);
				MemberDTO dto = dao.getMemberDTO(user_id, user_pw);
				dao.close();
				
				if(dto.getId() != null) {
					session.setAttribute("user_id", dto.getId());
					session.setAttribute("user_name", dto.getName());
					resp.sendRedirect("Login.jsp");
				}else {
					req.setAttribute("LoginErrMsg", "에러"); 
					req.getRequestDispatcher("Login.jsp").forward(req,resp);
				}
	}

}
