<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Welcome</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">

		<!-- Sidebar -->
		<div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 10%">
			<h3 class="w3-bar-item">Menu</h3>
			<a href="/home" class="w3-bar-item w3-button">Home</a> <a
				href="/create-product" class="w3-bar-item w3-button">Create
				product</a> <a href="/buckets" class="w3-bar-item w3-button">Bucket</a>
		</div>

		<!-- Page Content -->
		<div style="margin-left: 10%">

			<div class="w3-container w3-teal">
				<h1>Store</h1>
			</div>

			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<form id="logoutForm" method="POST" action="${contextPath}/logout">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form>

				<h2>
					Welcome ${pageContext.request.userPrincipal.name} | <a
						onclick="document.forms['logoutForm'].submit()">Logout</a>
				</h2>

			</c:if>

			<c:if test="${not empty products}">
				<c:forEach items="${products }" var="currentProduct">
					<div class="w3-card-4" style="width: 30%">
						<img class="w3-circle"
							style="width: 140px; margin: auto; vertical-align: middle; display: block;"
							src="data:image/jpg;base64, ${currentProduct.encodedImage }"
							alt="Alps" style="width: 100%">
						<div class="w3-container w3-center">
							<h3>${currentProduct.name}</h3>
							<p>${currentProduct.title}</p>
							<p>${currentProduct.description}</p>
							<p>${currentProduct.price}</p>
						</div>
						
						<form:form method="POST" action="${contextPath}/bucket" enctype="multipart/form-data">
						<input type="hidden" value="${currentProduct.id}" class="form-control" name="productId">
							<input type="submit" class="w3-button w3-block w3-dark-gray"
								value="+ Add To	The Bucket">
						</form:form>
					</div>
				</c:forEach>
			</c:if>



		</div>
	</div>
	<!-- /container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>