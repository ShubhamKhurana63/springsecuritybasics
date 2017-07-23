<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Le's Cleaning Service Center</title>

<link rel="stylesheet"
	href="<spring:url value="/resources/css/global.css"/>" />
<link rel="stylesheet"
	href="<spring:url value="/resources/css/datepicker.css"/>" />
<link rel="stylesheet"
	href="<spring:url value="/resources/css/bootstrap-multiselect.css"/>" />

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Latest Jquery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"
	type="text/javascript"></script>
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script
	src="<spring:url value="/resources/js/bootstrap-datepicker.js"/>"></script>
<script
	src="<spring:url value="/resources/js/bootstrap-multiselect.js"/>"></script>
<script src="<spring:url value="/resources/js/appointments.js"/>"></script>
<script>
	var root = "${pageContext.request.contextPath}";
</script>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div class="container">
		<div class="row">
			<h1>Appointments</h1>
			<div class="row">
				<h3 class="col col-md-8">Review your scheduled cleaning
					appointments.</h3>
				<div class="col col-md-4">
					<button id="add-appointment-btn" type="button"
						class="btn btn-default" data-toggle="modal"
						data-target="#add-appointment-form">
						<span class="glyphicon glyphicon-plus"></span> Create Appointment
					</button>
				</div>
			</div>
			<table id="appointment-table" class="table">
				<thead>
					<tr>
						<th>Customer</th>
						<th>Appointment Date</th>
						<th>Type</th>
						<th>Services</th>
						<th>Status</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>There are currently no appointments scheduled.</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	
</body>
</html>