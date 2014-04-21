/**
 * 
 */
function kalendar(format) {
	window.prettyPrint && prettyPrint();
	jQuery("input[role='datepicker']").datepicker({
	format: format,
	todayBtn: 'linked'
	});
}
