package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BoardDB.BoardDAO;
import BoardDB.BoardDTO;
@WebServlet("/List.do")
public class ListController extends HttpServlet {
		protected void doGet(HttpServletRequest req,HttpServletResponse resp)
					throws IOException,ServletException{
			
				HttpSession session = req.getSession(true);
			
				
				try {
					if((session.getAttribute("user_id")) != null) {
						BoardDAO dao = new BoardDAO();
						Map<String,Object> map = new HashMap<String,Object>();
						
						String searchField = req.getParameter("searchField");
						String searchWord = req.getParameter("searchWord");
						
						if(searchWord != null) {
							map.put("searchField", searchField);
							map.put("searchWord", searchWord);
						}
						
						int totalNumber = dao.selectCount(map);
						
						List<BoardDTO> boardLists = dao.selectList(map);
						dao.close();
			
						req.setAttribute("boardLists", boardLists);
						 req.getRequestDispatcher("/List.jsp").forward(req, resp);
					}
				}catch(Exception e) {
						
				}
				if((session.getAttribute("user_id")) == null)
					resp.sendRedirect("/HomePreos/Login.jsp");
			
			}
	
}
