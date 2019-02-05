package be.sdlg.webapps.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import be.sdlg.webapps.model.ArmToSeg;
import be.sdlg.webapps.model.Cohort;
import be.sdlg.webapps.model.CohortRange;
import be.sdlg.webapps.model.User;
import be.sdlg.webapps.dao.ArmToSegDao;
import be.sdlg.webapps.dao.CohortDao;
import be.sdlg.webapps.dao.CohortRangeDao;
import be.sdlg.webapps.dao.UserDao;

@Controller
public class HomeController {
	@Autowired 
	ArmToSegDao armToSegDao;
	@Autowired
	CohortDao cohortDao;
	@Autowired
	CohortRangeDao cohortRangeDao;
	@RequestMapping(value={"/", "home.htm"}, method=RequestMethod.GET)
	public String home(Model model) {
	
		List<ArmToSeg> armToSeglist = armToSegDao.findByStudyId("1");
		// To do: fill the stub
		for (ArmToSeg as : armToSeglist) {
			System.out.println(as.segment.segmentCode + " - " + as.arm.armCode);
		}
		List<Cohort> cohortList = cohortDao.findByStudyId("1");
		for (Cohort c : cohortList) {
			System.out.println(c.code);
		}
		List<CohortRange> cohortRangeList = cohortRangeDao.findByCohortId("1");
		for (CohortRange cr : cohortRangeList) {
			System.out.println(cr.cohortId);
		}
		model.addAttribute("user", armToSeglist);
		return "home";
	}
}
