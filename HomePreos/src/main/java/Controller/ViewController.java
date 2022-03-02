package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BoardDB.BoardDAO;
import BoardDB.BoardDTO;

@WebServlet("/view.do")
public class ViewController extends HttpServlet {
		
	@Override
	protected void service(HttpServletRequest req,HttpServletResponse resp)
					throws IOException,ServletException{
				BoardDAO dao = new BoardDAO();
				String idx = req.getParameter("idx");
				dao.updateVisitCount(idx);
				BoardDTO dto = dao.selectView(idx);
				dao.close();
				
				dto.setContent(dto.getContent().replaceAll("\r\n","<br/>"));
				
				req.setAttribute("dto", dto);
				req.getRequestDispatcher("/View.jsp").forward(req, resp);
	}

}
