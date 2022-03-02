package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import FileDown.FileUtil;


@WebServlet("/dowload.do")
public class DownloadController extends HttpServlet{

		protected void doGet(HttpServletRequest req,HttpServletResponse resp)
				throws IOException,ServletException{
					String ofile = req.getParameter("ofile");
					String sfile = req.getParameter("sfile");
					
					FileUtil.dowload(req,resp,"/Uploads",sfile,ofile);
					
		}
}
