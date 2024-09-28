/**
 * 
 */

document.addEventListener("DOMContentLoaded", function() {

	const partidas = document.querySelectorAll('[id-partida]');

	partidas.forEach(partida => {
		
			const apostaA = partida.querySelector('input[name="apostaRoboA"]');
			const apostaB = partida.querySelector('input[name="apostaRoboB"]');
	
			apostaA.addEventListener('input', function() {
				if (apostaA.value) {
					apostaB.disabled = true;
				} else {
					apostaB.disabled = false;
				}
			});
	
			apostaB.addEventListener('input', function() {
				if (apostaB.value) {
					apostaA.disabled = true;
				} else {
					apostaA.disabled = false;
				}
			})

	});

});