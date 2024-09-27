<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Robocup bet</title>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
</head>
<body class="bg-black">
	<main
		class="container d-flex flex-column justify-content-center align-items-center">

		<h1 class="title-cup mt-2">Integrantes</h1>
		
		<div class="d-flex flex-column align-items-center bg-fiap-grey form-usuario p-5">
			<h2 class="text-light">Grupo: ${equipes.nome}</h2>
			<div class="d-flex">
				<c:forEach var="integrante" items="${integrantes}">
					<div class="d-flex flex-column align-items-center mx-3">
						<img src="${integrante.urlFoto}"
							class="img-loja img-fluid">
						<h3 class="title-cup">${integrante.nome}</h3>
					</div>
				</c:forEach>
				
			</div>

			<a href="/robocupbet/PartidaServlet"
				class="btn btn-style w-75 text-light fw-bold mt-5"> Voltar 
			</a>

		</div>

	</main>
</body>
</html>