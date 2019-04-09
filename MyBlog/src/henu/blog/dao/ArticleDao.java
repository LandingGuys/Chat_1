package henu.blog.dao;

import java.util.ArrayList;

import henu.blog.bean.Article;

public interface ArticleDao {
	public ArrayList<Article> showArticle(int user_id);
	public ArrayList<Article> showAllArticle(int begin);
	public int searchArticleNum();
	public int insertArticle(Article article);
	public int deleteArticle(int article_id);
	public ArrayList<Article> showRandomAllArticle();
}
