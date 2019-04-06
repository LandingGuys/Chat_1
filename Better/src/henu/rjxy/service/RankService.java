package henu.rjxy.service;

import java.util.ArrayList;


public interface RankService {
	 public ArrayList<henu.rjxy.dto.searchStudy> searchAllstudy_list(int currentPage);
	 public ArrayList<henu.rjxy.dto.searchSport> searchAllsport_list(int currentPage);
	 public int searchStudyNum();
	 public int searchSportNum();
	 
}
