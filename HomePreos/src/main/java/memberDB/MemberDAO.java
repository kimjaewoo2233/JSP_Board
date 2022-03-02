package memberDB;

import java.text.SimpleDateFormat;

import common.JDBConnect;

public class MemberDAO extends JDBConnect{
		public MemberDAO() {
			super();
		}
		public MemberDAO(String drv,String url,String id,String pwd) {
			super(drv,url,id,pwd);
		}
		
		public String checkMember(String id) {
			String x=null;
			String sql = "SELECT * FROM member WHERE id=?";
			try {
				psmt = con.prepareStatement(sql);
				psmt.setString(1, id);
				rs = psmt.executeQuery();
				if(rs.next()) {
					 x = rs.getString(1);
				}
			}catch(Exception e) {
				e.printStackTrace();
				
			}
			return x;
		}
		public MemberDTO getMemberDTO(String uid,String upass) {
			MemberDTO dto = new MemberDTO();
			String sql = "SELECT * FROM member WHERE id=? AND pass=?";
			
			try{
				psmt = con.prepareStatement(sql);
				psmt.setString(1, uid);
				psmt.setString(2,upass);
				rs = psmt.executeQuery();
				
				if(rs.next()) {	//���� ����� ���� ȸ�� ������ DTO�� ����
					dto.setId(rs.getString("id"));
					dto.setPass(rs.getString("pass"));
					dto.setName(rs.getString(3));
					dto.setRegidate(rs.getString(4));
					}
			
			}catch(Exception e) {
				e.printStackTrace();
			}
			return dto;
		}
		public void setMemberDTO(String uid,String upass,String name) {
			String sql = "INSERT INTO member VALUES (?,?,?,sysdate)";
			
			try{
				psmt = con.prepareStatement(sql);
				psmt.setString(1, uid);
				psmt.setString(2, upass);
				psmt.setString(3, name);
				psmt.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
}
