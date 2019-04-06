package henu.rjxy.dao.impl;

import java.util.ArrayList;

import henu.rjxy.bean.PageModel;
import henu.rjxy.dao.RankDao;
import henu.rjxy.dto.searchSport;
import henu.rjxy.dto.searchStudy;
import henu.rjxy.util.DBUtil;

public class RankDaoImpl implements RankDao {
	DBUtil dbutil=new DBUtil();
	@Override
	public ArrayList<searchStudy> searchAllstudy_list(int begin) {
		// TODO Auto-generated method stub
		return dbutil.searchAllstudy_list(begin, PageModel.pageNum);
	}

	@Override
	public ArrayList<searchSport> searchAllsport_list(int begin) {
		// TODO Auto-generated method stub
		return dbutil.searchAllsport_list(begin, PageModel.pageNum);
	}

	@Override
	public int searchStudyNum() {
		// TODO Auto-generated method stub
		return dbutil.searchStudyNum();
	}

	@Override
	public int searchSportNum() {
		// TODO Auto-generated method stub
		return dbutil.searchSportNum();
	}

}
