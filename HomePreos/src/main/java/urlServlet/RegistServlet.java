package urlServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.JSFunction;
import memberDB.MemberDAO;

@WebServlet("/Regist.do")
public class RegistServlet extends HttpServlet  {
		protected void doPost(HttpServletRequest req,HttpServletResponse resp) 
					throws IOException,ServletException{
				HttpSession session = req.getSession(true);
				session.invalidate();
				String reg_id = req.getParameter("user_R_id");
				String reg_pwd = req.getParameter("user_R_pw");
				String reg_name = req.getParameter("user_R_name");
				
				MemberDAO dao = new MemberDAO();
				try {
					String chekec_number = dao.checkMember(reg_id);
				if( chekec_number != null) {
					req.setAttribute("ErrMsg", "있는 아이디입니다");
					req.getRequestDispatcher("Regist.jsp").forward(req, resp);
					return;
				}
				dao.setMemberDTO(reg_id, reg_pwd, reg_name);
				req.setAttribute("LoginErrMsg", "연결");
				req.getRequestDispatcher("Login.jsp").forward(req, resp);
				}catch(Exception e) {
					req.setAttribute("LoginErrMsg", "2");
					req.getRequestDispatcher("Login.jsp").forward(req, resp);
					e.printStackTrace();
				}
				}
}
