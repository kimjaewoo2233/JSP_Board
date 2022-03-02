package BoardDB;

public class BoardDTO {
		private String idx;
		private String name;
		private String title;
		private String content;
		private String id;
		private java.sql.Date postdate;
	    private String ofile;
		private String sfile;
	    private int downcount;
		private int visitcount;
	    
	    
		public String getIdx() {
			return idx;
		}
		public void setIdx(String idx) {
			this.idx = idx;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public java.sql.Date getPostdate() {
			return postdate;
		}
		public void setPostdate(java.sql.Date postdate) {
			this.postdate = postdate;
		}
		public String getOfile() {
			return ofile;
		}
		public void setOfile(String ofile) {
			this.ofile = ofile;
		}
		public String getSfile() {
			return sfile;
		}
		public void setSfile(String sfile) {
			this.sfile = sfile;
		}
		public int getDowncount() {
			return downcount;
		}
		public void setDowncount(int downcount) {
			this.downcount = downcount;
		}
		public int getVisitcount() {
			return visitcount;
		}
		public void setVisitcount(int visitcount) {
			this.visitcount = visitcount;
		}
	/*
	 * table sql
	 * create table proboard (
	idx number primary key, 
	name varchar2(50) not null, 
	title varchar2(200) not null, 
	content varchar2(2000) not null, 
	id varchar2(10) not null,
	postdate date default sysdate not null, 
	ofile varchar2(200), 
	sfile varchar2(30), 
	downcount number(5) default 0 not null, 	
	visitcount number default 0 not null
);*/
}
