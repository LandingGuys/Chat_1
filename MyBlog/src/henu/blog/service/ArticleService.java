package henu.blog.service;

import java.util.ArrayList;

import henu.blog.bean.Article;

public interface ArticleService {
	//查询个人所有博客
	public ArrayList<Article> showArticle(int user_id);
	//查询所有博客
	public ArrayList<Article> showAllArticle(int currentPage);
	public int searchArticleNum();
	public int insertArticle(Article article);
	public int deleteArticle(int article_id);
	public ArrayList<Article> showRandomAllArticle();
}
