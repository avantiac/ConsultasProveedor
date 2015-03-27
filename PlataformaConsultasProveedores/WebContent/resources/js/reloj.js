//Creado para el Req. de Rebranding ,19/06/2012, Sandra Garcia
function mueveReloj() {
	var LaFecha = new Date();
	var Mes = new Array("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
			"Julio", "Agosto", "Septiembre", "Octubre", "Noviembre",
			"Diciembre");
	var diasem = new Array('Domingo', 'Lunes', 'Martes', 'Miercoles', 'Jueves',
			'Viernes', 'Sabado');
	var diasemana = LaFecha.getDay();
	var FechaCompleta = "";
	var NumeroDeMes = "";
	var hora = LaFecha.getHours();
	if (hora < 10) {
		hora = "0" + hora;
	}
	;
	var minuto = LaFecha.getMinutes();
	if (minuto < 10) {
		minuto = "0" + minuto;
	}
	;
	var segundo = LaFecha.getSeconds();
	if (segundo < 10) {
		segundo = "0" + segundo;
	}
	;
	NumeroDeMes = LaFecha.getMonth();
	FechaCompleta = diasem[diasemana] + " " + LaFecha.getDate() + " de "
			+ Mes[NumeroDeMes] + " de " + LaFecha.getFullYear() + " " + hora
			+ ":" + minuto + ":" + segundo;
	document.getElementById('reloj').innerHTML = FechaCompleta;
	setTimeout('mueveReloj()', 1000);
	// alert('Entre');
}

function fixPFDialogToggleMaximize(dlg) {
	if (undefined == dlg.doToggleMaximize) {
		dlg.doToggleMaximize = dlg.toggleMaximize;
		dlg.toggleMaximize = function() {
			this.doToggleMaximize();

			var marginsDiff = this.content.outerHeight()
					- this.content.height();
			var newHeight = this.jq.innerHeight() - this.titlebar.outerHeight()
					- marginsDiff;
			this.content.height(newHeight);
		};
	}
}

// alert('Entre');
