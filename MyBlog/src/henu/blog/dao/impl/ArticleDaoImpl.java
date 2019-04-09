package henu.blog.dao.impl;

import java.util.ArrayList;

import henu.blog.bean.Article;
import henu.blog.dao.ArticleDao;
import henu.blog.util.DBUtil;
import henu.blog.bean.PageModel;

public class ArticleDaoImpl implements ArticleDao {
	DBUtil dbutil=new DBUtil();
	@Override
	public ArrayList<Article> showArticle(int user_id) {
		// TODO Auto-generated method stub
		return dbutil.showArticle(user_id);
	}
	@Override
	public ArrayList<Article> showAllArticle(int begin) {
		// TODO Auto-generated method stub
		int end=begin+PageModel.pageNum-1;
		return dbutil.showAllArticle(begin, end);
	}
	@Override
	public int insertArticle(Article article) {
		// TODO Auto-generated method stub
		return dbutil.insertArticle(article);
	}
	@Override
	public int deleteArticle(int article_id) {
		// TODO Auto-generated method stub
		return dbutil.deleteArticle(article_id);
	}
	@Override
	public ArrayList<Article> showRandomAllArticle() {
		// TODO Auto-generated method stub
		return dbutil.showRandomAllArticle();
	}
	@Override
	public int searchArticleNum() {
		// TODO Auto-generated method stub
		return dbutil.searchArticleNum();
	}
	

}
