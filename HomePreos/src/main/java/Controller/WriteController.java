package Controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import BoardDB.BoardDAO;
import BoardDB.BoardDTO;
import FileDown.FileUtil;
import common.JSFunction;


@WebServlet("/write.do")
public class WriteController extends HttpServlet {
		protected void doGet(HttpServletRequest req,HttpServletResponse resp)
					throws IOException,ServletException{
			req.getRequestDispatcher("/Write.jsp").forward(req, resp);
		}
		
		protected void doPost(HttpServletRequest req,HttpServletResponse resp)
					throws IOException,ServletException{
			//1. ���� ���ε� ó��
			String saveDirectory = req.getServletContext().getRealPath("/Uploads");
			
			//�ʱ�ȭ �Ű������� ������ ÷�� ���� �ִ� �뷮 Ȯ��
			ServletContext application = getServletContext();
			int maxPostSize = Integer.parseInt(application.getInitParameter("maxPostSize"));
			
			MultipartRequest mr = FileUtil.uploadFile(req, saveDirectory, maxPostSize);
			if(mr == null) {
				  // ���� ���ε� ����
	            JSFunction.alertLocation(resp, "÷�� ������ ���� �뷮�� �ʰ��մϴ�.",
	                                     "/write.do");  
	            return;
			}
			
			//2.  ���� ���ε� �� ó��----
			//�� ���� DTO �� ����
			HttpSession session = req.getSession(true);
			session.getAttribute("user_id");
			BoardDTO dto = new BoardDTO();
			dto.setName(mr.getParameter("name"));
			dto.setTitle(mr.getParameter("title"));
			dto.setContent(mr.getParameter("content"));
			dto.setId(session.getAttribute("user_id").toString());
			
			//���� ���ϸ�� ����� ���� �̸�����
			
			String fileName = mr.getFilesystemName("ofile");
			if(fileName != null) {
					//÷�� ������ ���� ��� ���ϸ� ����
					//���ο� ���ϸ� ����
					String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
					String ext = fileName.substring(fileName.lastIndexOf("."));
					String newFileName = now+ext;
					//���ϸ� ����
					File oldFile = new File( saveDirectory + File.separator+fileName);
					File newFile = new File(saveDirectory + File.separator+newFileName);
					oldFile.renameTo(newFile);
					
					dto.setOfile(fileName);
					dto.setSfile(newFileName);
			}
			BoardDAO dao = new BoardDAO();
			int result = dao.insertWrite(dto);
			dao.close();
			System.out.print(result);
			if (result == 1) {  // �۾��� ����
	            resp.sendRedirect("/HomePreos/List.do");
	        }
	        else {  // �۾��� ����
	            resp.sendRedirect("../mvcboard/write.do");
	        }
			
		}
}
