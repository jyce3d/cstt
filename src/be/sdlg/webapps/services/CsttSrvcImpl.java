package be.sdlg.webapps.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.sdlg.webapps.dao.ArmDao;
import be.sdlg.webapps.dao.ArmToSegDao;
import be.sdlg.webapps.dao.CohortDao;
import be.sdlg.webapps.dao.CohortRangeDao;
import be.sdlg.webapps.dao.CountryCalendarDao;
import be.sdlg.webapps.dao.CountryDao;
import be.sdlg.webapps.dao.SegmentDao;
import be.sdlg.webapps.dao.SiteCalendarDao;
import be.sdlg.webapps.dao.SiteDao;
import be.sdlg.webapps.dao.SiteRefDao;
import be.sdlg.webapps.dao.SlotCalendarDao;
import be.sdlg.webapps.dao.StudyDao;
import be.sdlg.webapps.dao.StudyEventDefDao;
import be.sdlg.webapps.dao.StudyEventRefDao;
import be.sdlg.webapps.dao.WeeklyCalendarDao;
import be.sdlg.webapps.model.Arm;
import be.sdlg.webapps.model.ArmToSeg;
import be.sdlg.webapps.model.ArmToSegNodeComposite;
import be.sdlg.webapps.model.Cohort;
import be.sdlg.webapps.model.CohortNodeComposite;
import be.sdlg.webapps.model.CohortRange;
import be.sdlg.webapps.model.Country;
import be.sdlg.webapps.model.CountryCalendar;
import be.sdlg.webapps.model.Segment;
import be.sdlg.webapps.model.Site;
import be.sdlg.webapps.model.SiteCalendar;
import be.sdlg.webapps.model.SiteRef;
import be.sdlg.webapps.model.SlotCalendar;
import be.sdlg.webapps.model.Study;
import be.sdlg.webapps.model.StudyEventDef;
import be.sdlg.webapps.model.StudyEventRef;
import be.sdlg.webapps.model.StudyEventRefComposite;
import be.sdlg.webapps.model.StudyEventRefNode;
import be.sdlg.webapps.model.WeeklyCalendar;
import be.sdlg.webapps.utils.Helper;
import be.sdlg.webapps.utils.TreeNode;

@Service
public class CsttSrvcImpl implements CsttSrvc {
	@Autowired StudyDao studyDao;
	@Autowired SiteRefDao siteRefDao;
	@Autowired SiteDao siteDao;
	@Autowired StudyEventDefDao studyEventDefDao;
	@Autowired StudyEventRefDao studyEventRefDao;
	@Autowired SiteCalendarDao siteCalendarDao;
	@Autowired CountryCalendarDao countryCalendarDao;
	@Autowired CountryDao countryDao;
	@Autowired ArmToSegDao armToSegDao;
	@Autowired ArmDao armDao;
	@Autowired SegmentDao segmentDao;
	@Autowired WeeklyCalendarDao weeklyCalendarDao;
	@Autowired SlotCalendarDao slotCalendarDao;
	@Autowired CohortDao cohortDao;
	@Autowired CohortRangeDao cohortRangeDao;
	/*
	 * Study ; has been created with full parameters
	 */
	public void refreshStudyProjection(Study study) {
		for (Object o : study.segments.iterator) {
			Segment seg = (Segment) o;
			
		}
	}
	
	public Study createStudy(Long studyId, Map<String, Integer> params) {
		// Construction du template de l'étude
		Study study = studyDao.findOne(studyId);
		// Create segment and arms
		List<ArmToSeg> armToSegs = armToSegDao.findByStudyId(studyId);
		List<Arm> arms = armDao.findAll();
		List<Segment> segments = segmentDao.findAll();
		List<StudyEventRef> studyEventRefs;
		for (ArmToSeg ats : armToSegs) {
			ats.study = study;
			for (Arm a : arms) {
				if (ats.armId.equals(a.id)) 
					ats.arm = a;
			}
			for (Segment seg : segments) {
				if (ats.segmentId.equals(seg.id))
					ats.segment = seg;
			}
		}
		ArmToSegNodeBuilder asnBuilder = new ArmToSegNodeBuilder(armToSegs);
		study.armToSegs =  new ArmToSegNodeComposite(asnBuilder);
		
		if (params.get("sites") !=null && params.get("sites")==1) {
			String siteIds ="";
			String countryIds = "";
			study.sites = new ArrayList<SiteRef>();
			List<SiteRef> siteRefs = siteRefDao.findByStudyId(studyId.toString());
			List<Site> sites = siteDao.findAll();
			List<Country> countries = countryDao.findAll();
			for (Country c: countries) {
				for (Site s: sites) {
					if (s.countryId.equals(c.id))
						s.country = c;
				}
			}
			for (SiteRef sr : siteRefs) {
				for (Site s : sites) {
					if (sr.siteId.equals(s.id)) {  
						study.sites.add(sr);
						sr.site = s;
						siteIds = Helper.addOnceTo(siteIds, s.id.toString());
						countryIds = Helper.addOnceTo(countryIds, s.countryId.toString());
					}
				}
			}
			if ((params.get("calendars") !=null) && (params.get("calendars").equals(1)) ) {
				// Retrieve SiteCalendars
				List<SiteCalendar> siteCalendars = siteCalendarDao.findByIds(siteIds);			
				List<CountryCalendar> countryCalendars = countryCalendarDao.findByIds(countryIds);
				List<WeeklyCalendar> weeklyCalendars = weeklyCalendarDao.findBySiteIds(siteIds);
				List<SlotCalendar> slotCalendars = slotCalendarDao.findBySiteIds(siteIds);
				
				// Link site calendar to sites trough the site ref
				for (SiteRef sr: study.sites) {
					for (SiteCalendar sc : siteCalendars) {
						if (sc.siteId.equals(sr.siteId)) {
							sc.site = sr.site;
							if (sr.site.siteCalendars == null)
								sr.site.siteCalendars = new ArrayList<SiteCalendar>();
							sr.site.siteCalendars.add(sc);
						}
					}
					for (WeeklyCalendar wkc : weeklyCalendars) {
						if (sr.id.equals(wkc.siteId)) {
							if (sr.site.weeklyCalendars == null) 
								sr.site.weeklyCalendars = new ArrayList<WeeklyCalendar>();
							sr.site.weeklyCalendars.add(wkc);
						}
					}
					for (SlotCalendar slc : slotCalendars) {
						if (slc.siteRefId.equals(sr.id)) {
							slc.siteRef = sr;
							if (sr.slotCalendars == null)
								sr.slotCalendars = new ArrayList<SlotCalendar>();
							sr.slotCalendars.add(slc);
						}
					}
				}
				// Link country calendar to country
				for (CountryCalendar cc : countryCalendars) {
					for (SiteRef sr: study.sites) {
						if (cc.countryId.equals(sr.site.countryId)) {
							cc.country = sr.site.country;
							if (sr.site.country.countryCalendars == null)
								sr.site.country.countryCalendars = new ArrayList<CountryCalendar>();
							sr.site.country.countryCalendars.add(cc);
						}
					}
					
				}		
				
			}
		}
		if (params.get("studyEvents") !=null && params.get("studyEvents")==1) {
			List<StudyEventDef> sds = studyEventDefDao.findAll();
			studyEventRefs = new ArrayList<StudyEventRef>();
			List<StudyEventRef> srs= studyEventRefDao.findByStudyId(studyId.toString());
			for ( StudyEventRef sr : srs) {
				for (StudyEventDef sd: sds) {
					if (sr.studyEventDefId.equals(sd.id)) {
						sr.studyEventDef = sd;
					}
				}
			}
			
			// Create the Tree with iterator
			StudyEventRefNodeBuilder sernBuilder =new StudyEventRefNodeBuilder(studyEventRefs);
			StudyEventRefComposite tree = new StudyEventRefComposite(sernBuilder);
			study.studyEventRefs = tree;
			
		}
		if (params.get("cohorts") !=null && params.get("cohorts")== 1 ) {
			// créer le cohort tree
			for (Object oseg : study.segments.iterator) {
				Segment seg = (Segment) oseg;
				for (Object o : seg.armToSegs.iterator) {
					ArmToSeg as = (ArmToSeg) o;
					List<Cohort> cohorts = cohortDao.findByArmToSegId(as.id);
					for (Cohort c : cohorts) {
						c.armToSeg = as;
						c.study = study;
						c.assignStudyEventDef(studyEventDefs);
						c.rangeList = cohortRangeDao.findByCohortId(c.id);
						for (CohortRange cr : c.rangeList) 
						 	cr.cohort = c;	
							cr.assignStudyEventDef(studyEventDefs);
					}
					CohortNodeBuilder cnBuilder = new CohortNodeBuilder(cohorts);
					as.cohorts = new CohortNodeComposite(cnBuilder);
				}
			}
			
		}
		return study;
	}

}