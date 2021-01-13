<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninja Gold</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container mt-3">
		<h1 class="text-center text-warning">Ninja Gold Game</h1>
		<div class="row mt-3">
			<h2 class="col-10 mt-4 mb-3">Your Gold: <span class="border border-dark px-4 text-dark"><c:out value="${gold}"/></span></h2>
			<a href="/reset" class="text-danger">Reset</a>
		</div>
		<div class="row justify-content-between mt-4">
			<div class="col-3">
				<div class="card">
					<div class="card-body border border-dark text-center">
						<h4>Farm</h4>
						<p>Earns 10-20 gold</p>
						<form action="/process_money" method="post">
							<input type="hidden" name="find" value="farm">
							<button type="submit" class="btn btn-dark">Find Gold!</button>
						</form>
					</div>
				</div>
			</div>
			
			<div class="col-3">
				<div class="card">
					<div class="card-body border border-dark text-center">
						<h4>Cave</h4>
						<p>Earns 5-10 gold</p>
						<form action="/process_money" method="post">
							<input type="hidden" name="find" value="cave">
							<button type="submit" class="btn btn-dark">Find Gold!</button>
						</form>
					</div>
				</div>
			</div>
			
			<div class="col-3">
				<div class="card">
					<div class="card-body border border-dark text-center">
						<h4>House</h4>
						<p>Earns 2-5 gold</p>
						<form action="/process_money" method="post">
							<input type="hidden" name="find" value="house">
							<button type="submit" class="btn btn-dark">Find Gold!</button>
						</form>
					</div>
				</div>
			</div>
			
			<div class="col-3">
				<div class="card">
					<div class="card-body border border-dark text-center">
						<h4>Casino</h4>
						<p>Earns/Takes 0-50 gold</p>
						<form action="/process_money" method="post">
							<input type="hidden" name="find" value="casino">
							<button type="submit" class="btn btn-dark">Find Gold!</button>
						</form>
					</div>
				</div>
			</div>
			
		</div>
		
		<div class="row mt-5">
		<h3>Activities:</h3>
		</div>
		<div>
		<p style ="overflow-y: scroll;">
		<c:forEach var="i" items="${activity}" >
		<c:out value = "${i}"/>
		<br>
		</c:forEach>
		</p>
		</div>
	</div>
</body>
</html>