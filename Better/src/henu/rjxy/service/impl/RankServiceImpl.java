package henu.rjxy.service.impl;

import java.util.ArrayList;

import henu.rjxy.bean.PageModel;
import henu.rjxy.dao.RankDao;
import henu.rjxy.dao.impl.RankDaoImpl;
import henu.rjxy.dto.searchSport;
import henu.rjxy.dto.searchStudy;
import henu.rjxy.service.RankService;

public class RankServiceImpl implements RankService {
	RankDao rankdao = new RankDaoImpl();
	@Override
	public ArrayList<searchStudy> searchAllstudy_list(int currentPage) {
		// TODO Auto-generated method stub
		int begin=(currentPage-1)*PageModel.pageNum;
		return rankdao.searchAllstudy_list(begin);
	}

	@Override
	public ArrayList<searchSport> searchAllsport_list(int currentPage) {
		// TODO Auto-generated method stub
		int begin=(currentPage-1)*PageModel.pageNum;
		return rankdao.searchAllsport_list(begin);
	}

	@Override
	public int searchStudyNum() {
		// TODO Auto-generated method stub
		return rankdao.searchStudyNum();
	}

	@Override
	public int searchSportNum() {
		// TODO Auto-generated method stub
		return rankdao.searchSportNum();
	}

}
