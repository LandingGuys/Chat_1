package henu.blog.bean;

public class Article {
	private int article_id;
	private int user_id;
	private String article_title;
	private String article_content;
	private String article_images;
	public int getArticle_id() {
		return article_id;
	}
	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getArticle_title() {
		return article_title;
	}
	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}
	public String getArticle_content() {
		return article_content;
	}
	public void setArticle_content(String article_content) {
		this.article_content = article_content;
	}
	public String getArticle_images() {
		return article_images;
	}
	public void setArticle_images(String article_images) {
		this.article_images = article_images;
	}
	

}
