


document.addEventListener("DOMContentLoaded", function() {
	const t = document.getElementById("aposta");

	t.addEventListener("change", function() {
		console.log(t);
	})

	const lutas = document.querySelectorAll('[id^="luta-"]');



	lutas.forEach(luta => {
		//pega id das duas lutas
		const lutaIds = luta.getAttribute('id').split('-').slice(1);
		const lutaIdA = lutaIds[0];
		const lutaIdB = lutaIds[1];

		const b = luta.getElementsByClassName("aposta")
		const a = luta.getAttributeNames("aposta");

		const apostaA = luta.querySelector(`input[name="apostaNoA-${lutaIdA}"]`);
		const apostaB = luta.querySelector(`input[name="apostaNoB-${lutaIdB}"]`);

		if (apostaA && apostaB) {
			apostaA.addEventListener('input', function() {
				if (apostaA.value && apostaA.value > 0) {
					apostaB.value = 0;
					apostaB.disabled = true;
				} else {
					apostaB.disabled = false;
				}
			});

			apostaB.addEventListener('input', function() {
				if (apostaB.value && apostaB.value > 0) {
					apostaA.value = 0;
					apostaA.disabled = true;
				} else {
					apostaA.disabled = false;
				}
			});
		}
	});
});