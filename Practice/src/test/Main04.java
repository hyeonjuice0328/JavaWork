package test;

public class Main04 {

	public class BoardWrite {
		private int uid;
		private String subject;
		private String content;
		private int viewCnt;
		
		//기본 생성자
		public BoardWrite() {
			this.subject = "";
			this.content = "";
			this.viewCnt = 0;
		}
		
		//매개변수를 받는 생성자
		public BoardWrite(int uid, String subject, String content, int viewCnt) {
			super();
			this.uid = uid;
			this.subject = subject;
			this.content = content;
			this.viewCnt = viewCnt;
		}

		//getter & setter
		public int getUid() {
			return uid;
		}

		public void setUid(int uid) {
			this.uid = uid;
		}

		public String getSubject() {
			return subject;
		}

		public void setSubject(String subject) {
			this.subject = subject;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public int getViewCnt() {
			return viewCnt;
		}

		public void setViewCnt(int viewCnt) {
			this.viewCnt = viewCnt;
		}
		

	}

}
