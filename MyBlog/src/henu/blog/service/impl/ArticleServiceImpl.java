package henu.blog.service.impl;

import java.util.ArrayList;

import henu.blog.bean.Article;
import henu.blog.dao.ArticleDao;
import henu.blog.dao.impl.ArticleDaoImpl;
import henu.blog.service.ArticleService;
import henu.blog.bean.PageModel;

public class ArticleServiceImpl implements ArticleService {
	ArticleDao articleDao=new ArticleDaoImpl();
	@Override
	public ArrayList<Article> showArticle(int user_id) {
		// TODO Auto-generated method stub
		return articleDao.showArticle(user_id);
	}
	@Override
	public ArrayList<Article> showAllArticle(int currentPage) {
		// TODO Auto-generated method stub
		int begin=(currentPage-1)*PageModel.pageNum+1;
		return articleDao.showAllArticle(begin);
	}
	@Override
	public int insertArticle(Article article) {
		// TODO Auto-generated method stub
		return articleDao.insertArticle(article);
	}
	@Override
	public int deleteArticle(int article_id) {
		// TODO Auto-generated method stub
		return articleDao.deleteArticle(article_id);
	}
	@Override
	public ArrayList<Article> showRandomAllArticle() {
		// TODO Auto-generated method stub
		return articleDao.showRandomAllArticle();
	}
	@Override
	public int searchArticleNum() {
		// TODO Auto-generated method stub
		return articleDao.searchArticleNum();
	}
	

}
