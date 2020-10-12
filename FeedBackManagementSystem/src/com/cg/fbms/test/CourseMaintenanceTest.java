package com.cg.fbms.test;

import org.junit.Test;

import com.cg.fbms.dto.CourseMaster;
import com.cg.fbms.service.CourseMaintenanceService;
import com.cg.fbms.service.ICourseMaintenance;

import static org.junit.Assert.*;

public class CourseMaintenanceTest {

	ICourseMaintenance course = new CourseMaintenanceService();

	@Test
	public void addCourseTest() {
		CourseMaster courseMaster = new CourseMaster("HTML", 30);
		boolean actualResult = course.addCourse(courseMaster);
		boolean expectedResult = true;
		assertEquals(expectedResult, actualResult);
		courseMaster = new CourseMaster("", 30);
		actualResult = course.addCourse(courseMaster);
		expectedResult = false;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void changeCourseNameTest() {

		boolean actualResult = course.changeCourseName(2, "C#");
		boolean expectedResult = true;
		assertEquals(expectedResult, actualResult);

	}

	@Test
	public void changeCourseDaysTest() {
		boolean actualResult = course.changeCourseDuration(2, 15);
		boolean expectedResult = true;
		assertEquals(expectedResult, actualResult);

	}

	@Test
	public void getCourseByIdTest() {
		CourseMaster courseById = new CourseMaster();
		courseById = course.getCourseById(1);
		assertEquals(10, courseById.getCourseDays());

	}
}