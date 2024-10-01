/**
 * 
 */

document.addEventListener("DOMContentLoaded", function() {

	const roboACheckbox = document.getElementsByName("apostaA");
	const roboBCheckbox = document.getElementsByName("apostaB");

	roboACheckbox.forEach(roboA => {
		roboA.addEventListener('change', () => {
			const selectedValueA = roboA.value;
			console.log(selectedValueA);


			roboBRadios.forEach(roboB => {
				if (roboB.value === selectedValueA) {
					roboB.disabled = true;
				} else {
					roboB.disabled = false;
				}
			});
		});
	});

	roboBCheckbox.forEach(roboB => {
		roboB.addEventListener('change', () => {
				
			
			const selectedValueB = roboB.value;
			console.log(selectedValueB)

			roboARadios.forEach(roboA => {
				if (roboA.value === selectedValueB) {
					roboA.disabled = true;
				} else {
					roboA.disabled = false;
				}
			});
		});
	});
	
});