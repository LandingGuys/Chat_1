package henu.rjxy.bean;

public class PageModel {
		//当前页
		public int currentPage;
		//上一页
		public int prePage;
		//下一页
		public int nextPage;
		//首页
		public  int firstPage=1;
		//尾页,总页数
		public int totalPage;
		//每一页显示的条目数
		public static int pageNum=5;
		//总条目数
		private int total;
		
		public int getTotal() {
			return total;
		}
		public void setTotal(int total) {
			this.total = total;
		}
		public int getTotalPage() {
			totalPage=(total+4)/pageNum;
			return totalPage;
		}
		public int getCurrentPage() {
			return currentPage;
		}
		public void setCurrentPage(int currentPage) {
			this.currentPage = currentPage;
		}
		public int getPrePage() {
			if(this.currentPage<=1){
				prePage= 1;
			}else{
				prePage=this.currentPage-1;
			}
			return prePage;
		}
		public int getNextPage() {
			if(this.currentPage>=this.getTotalPage()){
				this.nextPage=this.getTotalPage();
			}else{
				this.nextPage=this.currentPage+1;
			}
			return nextPage;
		}

		

}
