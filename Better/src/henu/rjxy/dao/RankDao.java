package henu.rjxy.dao;

import java.util.ArrayList;

import henu.rjxy.dto.searchSport;
import henu.rjxy.dto.searchStudy;

public interface RankDao {
	public ArrayList<searchStudy> searchAllstudy_list(int begin);
	public ArrayList<searchSport> searchAllsport_list(int begin);
	public int searchStudyNum();
	public int searchSportNum();
}
