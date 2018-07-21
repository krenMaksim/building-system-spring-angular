<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<title>Avtorization</title>	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<body style="background-color: #bad0ca">
	<div style="text-align: center">
	<h1 >ЖУРНАЛ ПРОИЗВОДСТВА РАБОТ</h1>
		<c:if test="${not empty error}">
			<h5  style=" color: red"><b>${error}</b></h5>
		</c:if>
	</div>
	<div class="row">
		<div class="col-md-5"></div>
		<form name='form_login' action="j_spring_security_check" method='POST' class="well col-md-2">
			<input type="hidden" name="${_csrf.parameterName}" 	value="${_csrf.token}" />
			
			<div class="form-group">
				<label for="login">Логин:</label> <input class="form-control"
					id="login" name='user_login' type="text" value="Petrov">
			</div>
			<div class="form-group">
				<label for="password">Пароль:</label> <input class="form-control"
					id="password" name='password_login' type="password" value="dfssf35">
			</div>
			<button type="submit" class="btn btn-primary btn-block"	>ENTER TO APP</button>			
		</form>		
		<div class="col-md-5"></div>
	</div>	
</body>
</html>