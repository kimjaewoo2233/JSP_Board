package BoardDB;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletContext;

import common.JDBConnect;

public class BoardDAO extends JDBConnect {
		public BoardDAO() {
			super();
		}
		public BoardDAO(ServletContext application) {
			super(application);
		}
		public int selectCount(Map<String,Object> map) {
			int totalCount = 0; 	//��� �Խù��� ���� �޴´�.
			
			//  �Խù� ���� ������ ������ �ۼ��ϱ�
			String sql = "SELECT count(*) FROM proboard";
			if(map.get("searchWord") != null) {
				sql += " WHERE "+ map.get("searchField")+" "
						+" LIKE '%" + map.get("searchWord") + "%'";
			}
			
			try {
				stmt = con.createStatement();	//������ ����
				rs = stmt.executeQuery(sql);	//���� ����
				rs.next();		//Ŀ���� ù��° ������ �̵�
				totalCount = rs.getInt(1); //ù��° Į�� �� ������
			}   catch (Exception e) {
	            System.out.println("�Խù� ���� ���ϴ� �� ���� �߻�");
	            e.printStackTrace();
	        }
			return totalCount;
		}
		
		public List<BoardDTO> selectList(Map<String,Object> map){
			List<BoardDTO> bbs = new Vector<BoardDTO>();
			
			String sql = "SELECT * FROM proboard";
			if(map.get("searchWord") != null) {
				sql += " WHERE "+map.get("searchField") + " "
						+" LIKE '%" + map.get("searchWord")+"%' ";
			}
			sql += " ORDER BY idx DESC";
			
			try {
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					BoardDTO dto = new BoardDTO();
					
					dto.setIdx(rs.getString("idx"));
					dto.setName(rs.getString("name"));
					dto.setTitle(rs.getString("title"));
					dto.setContent(rs.getString("content"));
					dto.setContent(rs.getString("id"));
					dto.setPostdate(rs.getDate("postdate"));
					dto.setOfile(rs.getString("ofile"));
					dto.setSfile(rs.getString("sfile"));
					dto.setDowncount(rs.getInt("downcount"));
					dto.setVisitcount(rs.getInt("visitcount"));
					
					bbs.add(dto);
				}
			} catch (Exception e) {
	            System.out.println("�Խù� ��ȸ �� ���� �߻�");
	            e.printStackTrace();
	        }
			 return bbs;
		}
		
		//�Խñ� �����͸� �޾� DB�� �߰�
		public int insertWrite(BoardDTO dto) {
			int result= 0;
			try {
				String sql = "INSERT INTO proboard (idx,name,title,content,id,postdate,ofile,sfile,downcount,visitcount)"
						+ " VALUES (seq_board_num.NEXTVAL,?,?,?,?,sysdate,?,?,0,0)";
				psmt = con.prepareStatement(sql);
				psmt.setString(1,dto.getName());
				psmt.setString(2,dto.getTitle());
				psmt.setString(3, dto.getContent());
				psmt.setString(4,dto.getId());
				psmt.setString(5,dto.getOfile());
				psmt.setString(6,dto.getSfile());
				
				result = psmt.executeUpdate();
			}catch(Exception e) {
				 System.out.println("�Խù� �Է� �� ���� �߻�");
				e.printStackTrace();
			}
			return result;
			
		}
		public BoardDTO selectView(String idx) {
			BoardDTO dto = new BoardDTO();
			String sql = "SELECT * FROM proboard WHERE idx=?";
			try {
				psmt = con.prepareStatement(sql);
				psmt.setString(1, idx);
				rs = psmt.executeQuery();
				
				if(rs.next()) {
						dto.setIdx(rs.getString(1));
		                dto.setName(rs.getString(2));
		                dto.setTitle(rs.getString(3));
		                dto.setContent(rs.getString(4));
		                dto.setId(rs.getString(5));
		                dto.setPostdate(rs.getDate(6));
		                dto.setOfile(rs.getString(7));
		                dto.setSfile(rs.getString(8));
		                dto.setDowncount(rs.getInt(9));
		                dto.setVisitcount(rs.getInt(10));
				}
			}catch (Exception e) {
	            System.out.println("게시물 상세보기 중 예외 발생");
	            e.printStackTrace();
	        }
			return dto;
		}
		
		public void updateVisitCount(String idx) {
			String sql = "UPDATE proboard SET "
						+" visitcount=visitcount+1"
						+" WHERE idx=?";
			try {
				psmt = con.prepareStatement(sql);
				psmt.setString(1, idx);
				psmt.executeQuery();
			}catch(Exception e) {
				System.out.println("게시물 조회수 증가 중 예외 발생");
				e.printStackTrace();
			}
		}
}
