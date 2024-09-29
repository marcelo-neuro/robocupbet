<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RobocupBet</title>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
</head>
<body class="bg-black">
	<main
		class="container d-flex flex-column justify-content-center align-items-center">

		<h1 class="text-light mt-4">
			<span class="title-cup">ROBOCUP</span> BET
		</h1>

		<div
			class="position-loja form-usuario mt-5 me-5 d-flex flex-column align-items-center">
			<p class="px-5 text-center text-light mt-2">FIAPoints: ${pontos}</p>
			<a href="/robocupbet/loja.jsp"
				class="btn btn-style w-75 text-light fw-bold m-2"> Loja </a>
		</div>

		<c:forEach var="partida" items="${partidas}">
			<form method="GET" action="<c:url value='ApostaServlet' />"
				class="d-flex flex-column form-usuario justify-content-center align-items-center p-5 w-50 mt-5 mb-5 bg-fiap-grey" id-partida="${partida.id}">
					<div
						class="d-flex flex-row justify-content-center align-items-center w-100">
						<div class="d-flex align-items-center flex-column w-50">
							<h3 class="text-center text-light fs-3">${partida.equipeA.robo.nome}</h3>
							<img src="${partida.equipeA.robo.urlFoto}"
								class="img-robos img-fluid rounded">

							<input type="number" class="form-control w-50 mt-4 mb-4"
								placeholder="$00.00" name="apostaNoA"
								id="apostaRoboA-${partida.id}"> <a
								class="btn w-75 text-light fw-bold mb-2"
								href="<c:url value='IntegrantesServlet'>
                    <c:param name='equipeId' value='${partida.equipeA.id}'/>
                </c:url>">Ver
								equipe</a>
						</div>

						<div class="d-flex align-items-center justify-content-center">
							<h4 class="text-center text-light fs-1">VS</h4>
						</div>

						<div class="d-flex align-items-center flex-column w-50">
							<h3 class="text-center text-light fs-3">${partida.equipeB.robo.nome}</h3>
							<img src="${partida.equipeB.robo.urlFoto}"
								class="img-robos img-fluid rounded"> <input type="number"
								class="form-control w-50 mt-4 mb-4" placeholder="$00.00"
								name="apostaNoB" id="apostaRoboB-${partida.id}"> <a
								class="btn w-75 text-light fw-bold mb-2"
								href="<c:url value='IntegrantesServlet'>
                    <c:param name='equipeId' value='${partida.equipeB.id}'/>
                </c:url>">Ver
								equipe</a>
						</div>
					</div>

					<input type="hidden" name="partidaId" value="${partida.id}">
					<button type="submit"
						class="button-aposta p-2 d-flex
						align-items-center justify-content-centertext-decoration-none">
						Confirmar aposta</button>
			</form>
		</c:forEach>

	</main>

	<script src="scripts/aposta.js"></script>

</body>
</html>