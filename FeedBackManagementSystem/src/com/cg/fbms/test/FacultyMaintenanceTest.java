package com.cg.fbms.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.cg.fbms.dto.CourseFacultyMapping;
import com.cg.fbms.dto.CourseMaster;
import com.cg.fbms.dto.Faculty;
import com.cg.fbms.service.FacultymaintenanceService;
import com.cg.fbms.service.IFacutlyMaintenance;

class FacultyMaintenanceTest {

	IFacutlyMaintenance facultyMaintenanceService = new FacultymaintenanceService();

	@Test
	void addFacultyTest() {

		Boolean actualResult = facultyMaintenanceService.addFaculty(new Faculty("Mubeena", "c,c++"));
		Boolean expectedResult = true;
		assertEquals(expectedResult, actualResult);

		actualResult = facultyMaintenanceService.addFaculty(new Faculty("Amit", ""));
		expectedResult = false;
		assertEquals(expectedResult, actualResult);

		actualResult = facultyMaintenanceService.addFaculty(new Faculty("", "java"));
		expectedResult = false;
		assertEquals(expectedResult, actualResult);

		actualResult = facultyMaintenanceService.addFaculty(new Faculty("", ""));
		expectedResult = false;
		assertEquals(expectedResult, actualResult);

	}

	@Test
	void getAllFacultyListTest() {
		ArrayList<Faculty> actualResult = facultyMaintenanceService.getAllFacultyList();
		String expectedResult = "[FacultySkill [facultyId=1, facultyName=Sushantika, facultySkillSet=javascript,c,python,java], FacultySkill [facultyId=2, facultyName=Reshu, facultySkillSet=javascript,c,python,java], FacultySkill [facultyId=3, facultyName=Pratik, facultySkillSet=c,python,java], FacultySkill [facultyId=4, facultyName=Rajesh, facultySkillSet=c,python,java,c++], FacultySkill [facultyId=5, facultyName=Alok, facultySkillSet=c,python,java,c++], FacultySkill [facultyId=6, facultyName=Suppu, facultySkillSet=c,python,java,c++], FacultySkill [facultyId=7, facultyName=Sharu, facultySkillSet=c,java,c++], FacultySkill [facultyId=9, facultyName=A, facultySkillSet=c,python,java,c++], FacultySkill [facultyId=10, facultyName=B, facultySkillSet=c,python,java,c++], FacultySkill [facultyId=12, facultyName=Abhishek, facultySkillSet=c,python,java,c++], FacultySkill [facultyId=13, facultyName=Amit, facultySkillSet=java]]";
		assertEquals(expectedResult, actualResult.toString());
	}

	@Test
	void getFacultyByIdTest() {
		Faculty actualResult = facultyMaintenanceService.getFacultyById(2);
		String expectedResult = "FacultySkill [facultyId=2, facultyName=Reshu, facultySkillSet=javascript,c,python,java]";
		assertEquals(expectedResult, actualResult.toString());

		actualResult = facultyMaintenanceService.getFacultyById(20);
		expectedResult = null; /// Id dosen't exist in database;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	void getAllFacultyId() {
		ArrayList<Integer> actualResult = facultyMaintenanceService.getAllFacultyId();
		String expectedResult = "[1, 2, 3, 4, 5, 6, 7, 9, 10, 12, 13]";
		assertEquals(expectedResult, actualResult.toString());
	}

	@Test
	void getFaultyBySkillTest() {
		ArrayList<Faculty> actualResult = facultyMaintenanceService.getFacultyBySkill("java");
		String expectedResult = "[FacultySkill [facultyId=1, facultyName=Sushantika, facultySkillSet=javascript,c,python,java], FacultySkill [facultyId=2, facultyName=Reshu, facultySkillSet=javascript,c,python,java], FacultySkill [facultyId=3, facultyName=Pratik, facultySkillSet=c,python,java], FacultySkill [facultyId=4, facultyName=Rajesh, facultySkillSet=c,python,java,c++], FacultySkill [facultyId=5, facultyName=Alok, facultySkillSet=c,python,java,c++], FacultySkill [facultyId=6, facultyName=Suppu, facultySkillSet=c,python,java,c++], FacultySkill [facultyId=7, facultyName=Sharu, facultySkillSet=c,java,c++], FacultySkill [facultyId=9, facultyName=A, facultySkillSet=c,python,java,c++], FacultySkill [facultyId=10, facultyName=B, facultySkillSet=c,python,java,c++], FacultySkill [facultyId=12, facultyName=Abhishek, facultySkillSet=c,python,java,c++], FacultySkill [facultyId=13, facultyName=Amit, facultySkillSet=java]]";
		assertEquals(expectedResult, actualResult.toString());

		actualResult = facultyMaintenanceService.getFacultyBySkill("python");
		expectedResult = "[FacultySkill [facultyId=1, facultyName=Sushantika, facultySkillSet=javascript,c,python,java], FacultySkill [facultyId=2, facultyName=Reshu, facultySkillSet=javascript,c,python,java], FacultySkill [facultyId=3, facultyName=Pratik, facultySkillSet=c,python,java], FacultySkill [facultyId=4, facultyName=Rajesh, facultySkillSet=c,python,java,c++], FacultySkill [facultyId=5, facultyName=Alok, facultySkillSet=c,python,java,c++], FacultySkill [facultyId=6, facultyName=Suppu, facultySkillSet=c,python,java,c++], FacultySkill [facultyId=9, facultyName=A, facultySkillSet=c,python,java,c++], FacultySkill [facultyId=10, facultyName=B, facultySkillSet=c,python,java,c++], FacultySkill [facultyId=12, facultyName=Abhishek, facultySkillSet=c,python,java,c++]]";
		assertEquals(expectedResult, actualResult.toString());
	}

	/*
	 * @Test void courseFacultyMappingTest() { Boolean actualResult =
	 * facultyMaintenanceService.courseFacultyMapping(new
	 * CourseFacultyMapping(75690,54079)); Boolean expectedResult = true;
	 * assertEquals(expectedResult, actualResult.toString()); actualResult =
	 * facultyMaintenanceService.courseFacultyMapping(new
	 * CourseFacultyMapping(89750,54435)); expectedResult = true;
	 * assertEquals(expectedResult, actualResult.toString()); actualResult =
	 * facultyMaintenanceService.courseFacultyMapping(new
	 * CourseFacultyMapping(34356,65784)); expectedResult = true;
	 * assertEquals(expectedResult, actualResult.toString()); }
	 * 
	 * @Test void getMappedFacultyWithCourseTest() { ArrayList<Faculty> actualResult
	 * = facultyMaintenanceService.getMappedFacultyWithCourse(76789); //have to add
	 * String expectedResult = "Will insert"; assertEquals(expectedResult,
	 * actualResult.toString()); }
	 * 
	 * @Test void getFacultyNotMappedWithCourseTest() { ArrayList<Faculty>
	 * actualResult = facultyMaintenanceService.getFacultyNotMappedWithCourse(new
	 * CourseMaster()); //have to add String expectedResult = "Will insert";
	 * assertEquals(expectedResult, actualResult.toString()); }
	 */
}
