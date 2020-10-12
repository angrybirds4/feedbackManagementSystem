<%@page import="com.cg.fbms.dto.Faculty"%>
<%@page import="com.cg.fbms.dto.CourseMaster"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.cg.fbms.service.CourseMaintenanceService"%>
<%@page import="com.cg.fbms.service.ICourseMaintenance"%>
<%@page import="com.cg.fbms.service.FacultymaintenanceService"%>
<%@page import="com.cg.fbms.service.IFacutlyMaintenance"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<%
	IFacutlyMaintenance facultyMaintenance = new FacultymaintenanceService();
%>


<script type="text/javascript">
	
	function facultyForCourse(){
		var courseName = document.getElementById("course");
		
		<%//String courseName =
		out.println("hellllllllllllllllllllllllllo");
		System.out.println("sdkjfsd");
		System.out.println(session.getAttribute("courseSelected"));
		if(session.getAttribute("courseSelected")!=null){
			System.out.println("sdkjfsdttttttttttttttttttttt");	
			Integer status = (Integer)session.getAttribute("courseSelected");
			if(status.equals(1)){
				
				ArrayList<Faculty> facultyList = facultyMaintenance.getFacultyBySkill("python");
				int i;
				for(i = 0 ; i<facultyList.size();i++){
					
				}%>
				document.getElementById("facultyList").options[<%=i%>].value=<%=facultyList.get(i).getFacultyName()%>
				document.getElementById("facultyList").options[<%=i%>].text=<%=facultyList.get(i).getFacultyName()%>
			<%}
		}
		
		//request.getRequestDispatcher("facultyMaintenance.jsp").forward(request, response);%>
	}	
	
</script>


</head>
<body>


	<form action="GetFacultyServlet" method="get" id="courseSelection">
	
	
	
	
		<select onchange="facultyForCourse()" id="course">

	<%
		session.setAttribute("courseSelected",1);
		System.out.println(session.getAttribute("courseSelected"));
		ICourseMaintenance courseMaintenance = new CourseMaintenanceService();
		ArrayList<CourseMaster> courseList   =    courseMaintenance.getAllCourse();
		for(CourseMaster allCourse : courseList){
	%>
			<option  value=<%=allCourse.getCourseName() %>><%= allCourse.getCourseName() %></option>
		
		
		<% } %>
		</select>
		
		
		
		
		<select  id="facultyList">		
		</select>
	</form>
		
		
</body>
</html>