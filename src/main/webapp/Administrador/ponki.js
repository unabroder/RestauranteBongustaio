var elizabeth, barrios, duran, color;
var ponerT, ponerB, ponerBC, bandera, fechaFNCval, horaFNCval;
var fechaFNC = {anio: "", mes: "", dia: "", };
var horaFNC = {horaria: "", hora: "", minu: "", segu: "", };
(function () {
    fechaFNCval = "";
    horaFNCval = "";
    ponerT = new Array();
    ponerB = new Array();
    ponerBC = new Array();
    document.getElementsByTagName("head")[0].innerHTML += "<meta charset='utf-8' />";
    importarMaterialize();
    elizabeth = new Array();
    barrios = new Array();
    duran = new Array();
    bandera = true;
    color = "black";
    if (obId("ponkImsj") != undefined || obId("ponkImsj") != null) {
        obId("ponkImsj").setAttribute("style", "position:fixed;top:-100%;left:-100%;width:100%;height:100%;" +
                "background-color:rgba(0,0,0,1);border-radius:250%;overflow:hidden;-webkit-transition:all 0.25s;" +
                "z-index:1000;padding:0px;overflow-y:scroll;");
        obId("ponkImsj").innerHTML = "<div id='msjPonki'><h1 id='h1Msj'></h1><br /><br /><center><label id='lblMsj'>" +
                "</label></center><footer><article onclick='quitMSJ();' id='btnAcepMsj'>Aceptar</article></footer>" +
                "<br /></div>";
    }
    setTimeout(function () {
        verificarTablas();
        editarMSJ();
    }, 500);
    if (obId("ponkItool") != null || obId("ponkItool") != undefined) {
        desactivarHerramienta();
    }
})();
function desactivarHerramienta(x) {
    fechaFNCval = "";
    horaFNCval = "";
    if (x == 0) {
        fechaFNC = {anio: "", mes: "", dia: "", };
    } else {
        horaFNC = {horaria: "", hora: "", minu: "", segu: "", };
    }
    obId("ponkItool").setAttribute("style", "width:100%;height:100%;background-color:white;z-index:5000;posit" +
            "ion:fixed;left:0%;top:-100%;opacity:0;-webkit-transition:all 0.5s;overflow-y:scroll;");
}
var editarMSJ = function () {
    var clase = "ui-growl-item-container";
    setTimeout(function () {
        obCl(clase)[0].style.color = color;
        obCl(clase)[0].style.backgroundColor = "white";
        obCl(clase)[0].style.opacity = "1";
        obCl(clase)[0].style.textShadow = "none";
        obCl(clase)[0].style.boxShadow = "0px 0px 10px black";
        obCl(clase)[0].style.border = "2px solid " + color;
        obCl(clase)[0].style.borderRadius = "10px";
        obCl(clase)[0].style.backgroundImage = "none";
    }, 100);
    reiniciarTema();
}
var reiniciarTema = function () {
    setTimeout(function () {
        bandera = false;
        ponerTema(ponerT[0], ponerT[1], ponerT[2], ponerT[3], ponerT[4], ponerT[5]);
        var b = parseInt(ponerB.length);
        var bc = parseInt(ponerBC.length);
        for (var alexis = 0; alexis < b; alexis++) {
            arreglarBoton(ponerB[alexis].xx, ponerB[alexis].yy, ponerB[alexis].zz);
        }
        for (var kevin2 = 0; kevin2 < bc; kevin2++) {
            arreglarBotonClase(ponerBC[kevin2].xx, ponerBC[kevin2].yy, ponerBC[kevin2].zz);
        }
        verificarTablas();
    }, 200);
}
function verificarTablas() {
    var a = '<div class="row">' +
            '<div class="col s12 m6">' +
            '<div class="card blue-grey darken-1">' +
            '<div class="card-content white-text">' +
            '<span class="card-title">Vacio</span>' +
            '<p style="color: #fff">No se encuentraron datos en esta pagina</p>' +
            '</div>' +
            '<div class="card-action">' +
            '<a onclick="location.reload();">Recargar pagina</a>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '</div>';
    for (var i = 0; i < obEt("td").length; i++) {
        if (obEt("td")[i].innerHTML == "No records found.") {
            obEt("td")[i].innerHTML = a;
        }
    }
}
var mensaje = function (e, d) {
    obId("ponkImsj").setAttribute("style", "position:fixed;top:0%;left:0%;width:100%;height:100%;" +
            "background-color:rgba(0,0,0,0.5);border-radius:0%;overflow:hidden;-webkit-transition:all 0.25s;" +
            "z-index:1000;padding:0px;");
    obId("h1Msj").setAttribute("style", "padding:10px;font-size:20px;color:white;background-color:" + color +
            ";margin:0px;box-shadow:0px 0px 20px black;");
    obId("msjPonki").setAttribute("style", "background-color: white;box-shadow:0px 0px 50px white;");
    obId("btnAcepMsj").setAttribute("style", "padding:5px;color:white;background-color:" + color + ";" +
            "border-radius:5px;box-shadow:0px 0px 5px black;width:auto;margin: 20px;width:100px;" +
            "text-align: center;cursor: pointer;");
    obId("lblMsj").innerHTML = e;
    obId("lblMsj").setAttribute("style", "margin: 20px;color:" + color + ";font-size:20px;");
    obId("h1Msj").innerHTML = d;
}
function quitMSJ() {
    obId("ponkImsj").setAttribute("style", "position:fixed;top:-100%;left:-100%;width:100%;height:100%;" +
            "background-color:rgba(0,0,0,1);border-radius:250%;overflow:hidden;-webkit-transition:all 0.25s;" +
            "z-index:1000;padding:0px;");
}
function ponerTema(x, y, z, p, n, b) {
    if (bandera == true) {
        ponerT[0] = x;
        ponerT[1] = y;
        ponerT[2] = z;
        ponerT[3] = p;
        ponerT[4] = n;
        ponerT[5] = b;
    }
    color = x;
    var kevin = "table.thead.tbody.tr.th.td.fieldset.form.legend";
    kevin = kevin.split(".");
    for (var q = 0; q < obEt("nav").length; q++) {
        obEt("nav")[q].style.boxShadow = "0px 0px 25px " + x;
        obEt("nav")[q].style.backgroundColor = x;
    }
    for (var q = 0; q < kevin.length; q++) {
        for (var w = 0; w < obEt(kevin[q]).length; w++) {
            obEt(kevin[q])[w].style.border = "2";
            obEt(kevin[q])[w].style.backgroundColor = "rgba(0,0,0,0)";
            obEt(kevin[q])[w].style.backgroundImage = "none";
            obEt(kevin[q])[w].style.boxShadow = "none";
            obEt(kevin[q])[w].style.textShadow = "none";
            obEt(kevin[q])[w].style.textAlign = "center";
        }
    }
    for (var q = 0; q < obEt("th").length; q++) {
        obEt("th")[q].style.color = y;
    }
    for (var q = 0; q < obEt("thead").length; q++) {
        obEt("thead")[q].style.backgroundColor = x;
    }
    for (var q = 0; q < obEt("fieldset").length; q++) {
        obEt("fieldset")[q].style.backgroundColor = "rgba(255,255,255," + n + ")";
        obEt("fieldset")[q].style.borderRadius = "20px";
        obEt("fieldset")[q].style.boxShadow = "0px 0px 5px " + x;
    }
    for (var q = 0; q < obEt("legend").length; q++) {
        obEt("legend")[q].style.backgroundColor = x;
        obEt("legend")[q].style.color = y;
        obEt("legend")[q].setAttribute("onclick", "elProfe(" + q + ")");
        elizabeth[q] = 1;
        barrios[q] = z;
        duran[q] = p;
        obEt("legend")[q].innerHTML = z;
        obEt("table")[q].setAttribute("style", "-webkit-transition: all 0.5s");
    }
    for (var q = 0; q < obCl("ui-dialog-titlebar").length; q++) {
        obCl("ui-dialog-titlebar")[q].style.backgroundColor = x;
        obCl("ui-dialog-titlebar")[q].style.backgroundImage = "none";
        obCl("ui-dialog-titlebar")[q].style.textShadow = "none";
        obCl("ui-dialog-titlebar")[q].style.color = y;
        obCl("ui-dialog-titlebar")[q].style.boxShadow = "0px 0px 20px " + x;
    }
    for (var q = 0; q < obCl("ui-dialog ui-widget").length; q++) {
        obCl("ui-dialog ui-widget")[q].style.boxShadow = "0px 0px 20px " + x;
        obCl("ui-dialog ui-widget")[q].style.borderRadius = "10px";
        obCl("ui-dialog ui-widget")[q].style.border = "none";
        obCl("ui-dialog ui-widget")[q].style.backgroundColor = "rgba(255,255,255," + b + ")";
    }
    for (var q = 0; q < obCl("ui-outputlabel").length; q++) {
        obCl("ui-outputlabel")[q].style.color = "black";
        obCl("ui-outputlabel")[q].style.textShadow = "none";
    }
    for (var q = 0; q < obCl("center").length; q++) {
        obCl("center")[q].style.textAlign = "center";
    }
    for (var q = 0; q < obCl("left").length; q++) {
        obCl("left")[q].style.textAlign = "left";
    }
    for (var q = 0; q < obCl("right").length; q++) {
        obCl("right")[q].style.textAlign = "right";
    }
    for (var q = 0; q < obCl("fecha").length; q++) {
        obCl("fecha")[q].setAttribute("onclick", "validarFecha(" + q + ");");
    }
    for (var q = 0; q < obCl("hora").length; q++) {
        obCl("hora")[q].setAttribute("onclick", "validarHora(" + q + ");");
    }
    for (var q = 0; q < obCl("telefono").length; q++) {
        obCl("telefono")[q].setAttribute("onclick", "validarTelefono(" + q + ");");
    }
}
function seleccionEsta(x, y) {
    for (var i = 0; i < obCl(x).length; i++) {
        obCl(x)[i].style.color = "black";
        obCl(x)[i].style.backgroundColor = "white";
    }
    obCl(x)[y].style.color = "white";
    obCl(x)[y].style.backgroundColor = "black";
    if (x == "sAN") {
        var r = "";
        if (y == 0) {
            r = 2019;
        } else if (y == 1) {
            r = 2020;
        } else if (y == 2) {
            r = 2021;
        } else if (y == 3) {
            r = 2022;
        } else if (y == 4) {
            r = 2023;
        } else if (y == 5) {
            r = 2024;
        } else if (y == 6) {
            r = 2025;
        } else if (y == 7) {
            r = 2026;
        } else if (y == 8) {
            r = 2027;
        } else if (y == 9) {
            r = 2028;
        } else if (y == 10) {
            r = 2029;
        } else {
            r = 2030;
        }
        fechaFNC.anio = r;
    } else if (x == "sME") {
        fechaFNC.mes = y + 1;
        fechaFNC.mes < 10 ? fechaFNC.mes = "0" + fechaFNC.mes : fechaFNC.mes = fechaFNC.mes;
    } else if (x == "sDI") {
        fechaFNC.dia = y + 1;
        fechaFNC.dia < 10 ? fechaFNC.dia = "0" + fechaFNC.dia : fechaFNC.dia = fechaFNC.dia;
    } else if (x == "sAP") {
        horaFNC.horaria = y;
    } else if (x == "sHO") {
        horaFNC.hora = y + 1;
        if (horaFNC.horaria == 0) {
            horaFNC.hora < 10 ? horaFNC.hora = "0" + horaFNC.hora : horaFNC.hora = horaFNC.hora;
        } else if (horaFNC.horaria == 1) {
            horaFNC.hora += 12;
            horaFNC.hora < 10 ? horaFNC.hora = "0" + horaFNC.hora : horaFNC.hora = horaFNC.hora;
        } else {
            horaFNC.hora = "";
        }
    } else if (x == "sMI") {
        horaFNC.minu = y;
        horaFNC.minu < 10 ? horaFNC.minu = "0" + horaFNC.minu : horaFNC.minu = horaFNC.minu;
    } else if (x == "sSE") {
        horaFNC.segu = y;
        horaFNC.segu < 10 ? horaFNC.segu = "0" + horaFNC.segu : horaFNC.segu = horaFNC.segu;
    }
}
function guardar(x) {
    if (x == 0) {
        if (fechaFNC.anio == "" || fechaFNC.dia == "" || fechaFNC.mes == "") {
            obCl("btnG")[0].innerHTML = "Debe completar la fecha";
        } else {
            obCl("fecha")[fechaFNCval].value = fechaFNC.anio + "/" + fechaFNC.mes + "/" + fechaFNC.dia;
            desactivarHerramienta(0);
        }
    } else if (x == 1) {
        if (horaFNC.horaria == "" || horaFNC.hora == "" || horaFNC.minu == "" || horaFNC.segu == "") {
            obCl("btnG")[0].innerHTML = "Debe completar la hora";
        } else {
            obCl("hora")[horaFNCval].value = horaFNC.hora + ":" + horaFNC.minu + ":" + horaFNC.segu;
            desactivarHerramienta(1);
        }
    } else {

    }
}
var validarFecha = function (c) {
    fechaFNCval = c;
    var mes = ["", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto",
        "Septiembre", "Octubre", "Noviembre", "Diciembre"];
    var titulo = {
        dia: "<br /><strong>Dia:</strong><hr /><br />",
        mes: "<br /><strong>Mes:</strong><hr /><br />",
        anio: "<br /><strong>Año:</strong><hr /><br />",
    };
    obCl("fecha")[c].innerHTML = "";
    obId("ponkItool").setAttribute("style", "width:100%;height:100%;background-color:white;z-index:5000;posit" +
            "ion:fixed;left:0%;top:0%;opacity:1;-webkit-transition:all 0.5s;text-align:center;overflow-y:scroll;");
    obId("ponkItool").innerHTML = "<div class='btnHerra btnCanc' onclick='desactivarHerramienta(0);'>Cancelar</div><br />";
    for (var i = 2019; i <= 2030; i++) {
        obId("ponkItool").innerHTML += "<div class='btnHerra sAN btntn'>" + i + "</div>";
    }
    obId("ponkItool").innerHTML += titulo.anio;
    for (var i = 1; i <= 12; i++) {
        obId("ponkItool").innerHTML += "<div class='btnHerra sME btntn'>" + mes[i] + "</div>";
        i < 10 ? i = "0" + i : i = i;
    }
    obId("ponkItool").innerHTML += titulo.mes;
    for (var i = 1; i <= 31; i++) {
        i < 10 ? i = "0" + i : i = i;
        obId("ponkItool").innerHTML += "<div class='btnHerra sDI btntn'>" + i + "</div>";
    }
    obId("ponkItool").innerHTML += titulo.dia;
    obId("ponkItool").innerHTML += "<div class='btnHerra btntn btnG' onclick='guardar(0)'>Guardar</div>";
    obCl("btnCanc")[0].setAttribute("style", "padding:10px;background-color:black;color:white;" +
            "width:100%;box-shadow:0px 0px 10px black;text-align:center;");
    for (var i = 0; i < obCl("btnHerra").length; i++) {
        obCl("btnHerra")[i].style.cursor = "pointer";
    }
    for (var i = 0; i < obCl("btntn").length; i++) {
        obCl("btntn")[i].style.display = "inline-block";
        obCl("btntn")[i].style.margin = "5px";
        obCl("btntn")[i].style.padding = "10px";
        obCl("btntn")[i].style.border = "1px solid black";
        obCl("btntn")[i].style.borderRadius = "5px";
    }
    for (var i = 0; i < obCl("sAN").length; i++) {
        obCl("sAN")[i].setAttribute("onclick", "seleccionEsta('sAN', " + i + ");");
    }
    for (var i = 0; i < obCl("sME").length; i++) {
        obCl("sME")[i].setAttribute("onclick", "seleccionEsta('sME', " + i + ")");
    }
    for (var i = 0; i < obCl("sDI").length; i++) {
        obCl("sDI")[i].setAttribute("onclick", "seleccionEsta('sDI', " + i + ")");
    }
    obCl("btnG")[0].style.backgroundColor = "black";
    obCl("btnG")[0].style.color = "#FFFFFF";
    obCl("btnG")[0].style.borderRadius = "0px";
    obCl("btnG")[0].style.boxShadow = "0px 0px 20px black";
}
var validarHora = function (c) {
    horaFNCval = c;
    var titulo = {
        horaria: "<br /><strong>Sona horaria:</strong><hr /><br />",
        hora: "<br /><strong>Hora:</strong><hr /><br />",
        minuto: "<br /><strong>Minutos:</strong><hr /><br />",
        segundo: "<br /><strong>Segundos:</strong><hr /><br /><br />",
    };
    obCl("fecha")[c].innerHTML = "";
    obId("ponkItool").setAttribute("style", "width:100%;height:100%;background-color:white;z-index:5000;posit" +
            "ion:fixed;left:0%;top:0%;opacity:1;-webkit-transition:all 0.5s;text-align:center;overflow-y:scroll;");
    obId("ponkItool").innerHTML = "<div class='btnHerra btnCanc' onclick='desactivarHerramienta(1);'>Cancelar</div>";
    obId("ponkItool").innerHTML += "<br /><div class='btnHerra sAP btntn'>AM</div>" +
            "<div class='btnHerra sAP btntn'>PM</div>" + titulo.horaria;
    for (var i = 1; i <= 12; i++) {
        i < 10 ? i = "0" + i : i = i;
        obId("ponkItool").innerHTML += "<div class='btnHerra sHO btntn'>" + i + "</div>";
    }
    obId("ponkItool").innerHTML += titulo.hora;
    for (var i = 0; i <= 59; i++) {
        i < 10 ? i = "0" + i : i = i;
        obId("ponkItool").innerHTML += "<div class='btnHerra sMI btntn'>" + i + "</div>";
    }
    obId("ponkItool").innerHTML += titulo.minuto;
    for (var i = 0; i <= 59; i++) {
        i < 10 ? i = "0" + i : i = i;
        obId("ponkItool").innerHTML += "<div class='btnHerra sSE btntn'>" + i + "</div>";
    }
    obId("ponkItool").innerHTML += titulo.segundo + "<div class='btnHerra btntn btnG' onclick='guardar(1);'>Guardar</div>";
    obCl("btnCanc")[0].setAttribute("style", "padding:10px;background-color:black;color:white;" +
            "width:100%;box-shadow:0px 0px 10px black;text-align:center;");
    for (var i = 0; i < obCl("btnHerra").length; i++) {
        obCl("btnHerra")[i].style.cursor = "pointer";
    }
    for (var i = 0; i < obCl("btntn").length; i++) {
        obCl("btntn")[i].style.display = "inline-block";
        obCl("btntn")[i].style.margin = "5px";
        obCl("btntn")[i].style.padding = "10px";
        obCl("btntn")[i].style.border = "1px solid black";
        obCl("btntn")[i].style.borderRadius = "5px";
    }
    for (var i = 0; i < obCl("sAP").length; i++) {
        obCl("sAP")[i].setAttribute("onclick", "seleccionEsta('sAP', " + i + ")");
    }
    for (var i = 0; i < obCl("sHO").length; i++) {
        obCl("sHO")[i].setAttribute("onclick", "seleccionEsta('sHO', " + i + ")");
    }
    for (var i = 0; i < obCl("sMI").length; i++) {
        obCl("sMI")[i].setAttribute("onclick", "seleccionEsta('sMI', " + i + ")");
    }
    for (var i = 0; i < obCl("sSE").length; i++) {
        obCl("sSE")[i].setAttribute("onclick", "seleccionEsta('sSE', " + i + ")");
    }
    obCl("btnG")[0].style.backgroundColor = "black";
    obCl("btnG")[0].style.color = "#FFFFFF";
    obCl("btnG")[0].style.borderRadius = "0px";
    obCl("btnG")[0].style.boxShadow = "0px 0px 20px black";
}
var validarTelefono = function (c) {

}
var elProfe = function (x) {
    elizabeth[x]++;
    if (elizabeth[x] % 2 != 0) {
        obEt("legend")[x].innerHTML = barrios[x];
        obEt("table")[x].style.opacity = "1";
        obEt("fieldset")[x].style.backgroundColor = "rgba(255,255,255,0.7)";
    } else {
        obEt("legend")[x].innerHTML = duran[x];
        obEt("table")[x].style.opacity = "0";
        obEt("fieldset")[x].style.backgroundColor = "1";
        obEt("fieldset")[x].style.backgroundColor = "rgba(255,255,255,0)";
    }
}
var arreglarBoton = function (x, y, z) {
    if (bandera == true) {
        ponerB[ponerB.length] = {
            xx: x,
            yy: y,
            zz: z,
        };
    }
    var x = x.split(".");
    obEt("button")[x[0]].style.backgroundImage = "none";
    obEt("button")[x[0]].style.textShadow = "none";
    x[1] == "transparente" ? obEt("button")[x[0]].style.backgroundColor = "rgba(0,0,0,0)" :
            obEt("button")[x[0]].style.backgroundColor = x[1];
    x[2] == "transparente" ? obEt("button")[x[0]].style.color = "rgba(0,0,0,0)" :
            obEt("button")[x[0]].style.color = x[2];
    x[3] == "cuadrado" ? obEt("button")[x[0]].style.borderRadius = "0px" :
            obEt("button")[x[0]].style.borderRadius = "10px";
    var yy = y.split(".")
    y == "borde.no" ? obEt("button")[x[0]].style.border = "none" :
            obEt("button")[x[0]].style.border = yy[2] + "px solid " + yy[3];
    var zz = z.split(".");
    z == "degradado.no" ? obEt("button")[x[0]].style.boxShadow = "none" :
            obEt("button")[x[0]].style.boxShadow = "0px 0px " + zz[2] + "px " + zz[3];
}

var arreglarBotonClase = function (x, y, z) {
    if (bandera == true) {
        ponerBC[ponerBC.length] = {
            xx: x,
            yy: y,
            zz: z,
        };
    }
    var x = x.split(".");
    for (var i = 0; i < obCl(x[0]).length; i++) {
        obCl(x[0])[i].style.backgroundImage = "none";
        obCl(x[0])[i].style.textShadow = "none";
        x[1] == "transparente" ? obCl(x[0])[i].style.backgroundColor = "rgba(0,0,0,0)" :
                obCl(x[0])[i].style.backgroundColor = x[1];
        x[2] == "transparente" ? obCl(x[0])[i].style.color = "rgba(0,0,0,0)" :
                obCl(x[0])[i].style.color = x[2];
        x[3] == "cuadrado" ? obCl(x[0])[i].style.borderRadius = "0px" :
                obCl(x[0])[i].style.borderRadius = "10px";
        var yy = y.split(".")
        y == "borde.no" ? obCl(x[0])[i].style.border = "none" :
                obCl(x[0])[i].style.border = yy[2] + "px solid " + yy[3];
        var zz = z.split(".");
        z == "degradado.no" ? obCl(x[0])[i].style.boxShadow = "none" :
                obCl(x[0])[i].style.boxShadow = "0px 0px " + zz[2] + "px " + zz[3];
    }
}
var efectoInicio = function () {
    obEt("body")[0].style.opacity = "0";
    setTimeout(function () {
        obEt("body")[0].setAttribute("style", "-webkit-transition: all 0.5s");
        setTimeout(function () {
            obEt("body")[0].style.opacity = "1";
        }, 50);
    }, 450);
}
var ponerFondo = function (x, y, z) {
    var colorBL;
    z == "blancoynegro" ? colorBL = "filter: grayscale(1)" : colorBL = "filter: grayscale(0)";
    obId("ponkIfondo").setAttribute("src", x);
    obId("ponkIfondo").setAttribute("style", "z-index:-100;position:fixed;top:0%;left:0%;" +
            "width:100%;height:100%;opacity:" + y + ";" + colorBL + ";");
}
function importarMaterialize() {
    var valentina = ['<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />',
        '<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1' +
                '.0.0/css/materialize.min.css" />',
        '<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>'];
    for (var i = 0; i < valentina.length; i++) {
        i == 0 || i == 1 ? obEt("head")[0].innerHTML += valentina[i] :
                obEt("headscript")[0].innerHTML += valentina[i];
    }
}
var ponerIcono = function (x) {
    obEt("head")[0].innerHTML += '<link href=' + x + ' rel="icon" />';
}
function obEt(x) {
    return document.getElementsByTagName(x);
}
function obId(x) {
    return document.getElementById(x);
}
function obCl(x) {
    return document.getElementsByClassName(x);
}
function nose() {
    manual();
}
function quehago() {
    manual();
}
function help() {
    manual();
}
function ayuda() {
    manual();
}
function instrucciones() {
    manual();
}
function manual() {
    var d = ["<br><strong>Inicializacion: </strong>", "<br><strong>Parametros recibidos: </strong>",
        "<br><strong>Significado de parametros: </strong>", "<br><br><center>Ejemplo:</center>"];
    var q = ['</label><center>ponerIcono("source/img/icono.png");</center>',
        '</label><center>ponerFondo("source/img/fondo2.gif", "0.50", "blancoynegro");</center>',
        '</label><center>efectoInicio();</center>',
        '</label><center>arreglarBoton("0.transparente.white.cuadrado", "borde.no", "degradado.n' +
                'o");</center>',
        '<center>arreglarBoton("0.transparente.white.cuadrado", "borde.si.1.white", ' +
                '"degradado.si.10.black");</center>',
        '</label><center>arreglarBotonClase("btnEliminar.transparente.white.cuadrado", "borde.no", "degradado.n' +
                'o");</center>',
        '<center>arreglarBotonClase("btnEliminar.transparente.white.cuadrado", "borde.si.1.white", ' +
                '"degradado.si.10.black");</center>',
        'mensaje("Hola we", "Mensaje de JAVA")'];
    var i = {
        estilo: "<style>*{padding:0px;margin:0px;cursor:default;}" +
                "h1{padding:0px;margin:0px;background:black;color:white;padding:20px;text-" +
                "align:center;box-shadow: 0px 0px 25px black;-webkit-user-select:none;" +
                "}body::-webkit-scrollbar{width:0px}" +
                "label{display:block;margin:25px;font-size:16px;color:crimson;text-align:justify;-webkit-u" +
                "ser-select:none;}strong{color:black;}</style>",
        icono: "<label>Aveces se tiene que limpiar y construir</label>" +
                "<h1>Instrucciones de ponki.js</h1><h1>1. ponerIcono</h1><label>" + d[0] + "ponerIcono();" +
                d[1] + "1 parametro" + d[2] + " #1) La ruta de el icono; puede ser " +
                "(.jpg), (.png) o (.jpeg)). Tambien puede sacar url de internet" + d[3] + q[0],
        fondo: "<h1>2. ponerFondo</h1><label>" + d[0] + "ponerFondo();" +
                d[1] + "3 parametros" + d[2] + " #1) La ruta del fondo; puede ser " +
                "(.jpg), (.png) o (.jpeg)). Tambien puede sacar url de internet" +
                d[2] + " #2) La opacidad del fondo (debe ser en decimal)" +
                ". Mientras el resultado se acerque mas al cero... mas opaco sera el fondo" +
                d[2] + " #3) Si quieres blanco y negro O a color" +
                "Blanco y negro: (blancoynegro). A color: (acolor)" + d[3] + q[1] +
                "<label><strong>Nota: se necesita una etiqueta imagen con id de >ponkIfondo< </strong></label>",
        inicio: "<h1>3. efectoInicio</h1><label>" + d[0] + "efectoInicio();" +
                d[1] + "ningun parametro" + d[3] + q[2],
        boton: "<h1>4. arreglarBoton</h1><label>" + d[0] + "arreglarBoton();" +
                d[1] + "3 parametros" + d[2] + " #1) El numero de boton al que quieres reparar" +
                "... (Comienza desde 0), + punto, si lo quieres transparente o con color... " +
                "(Si es con color pones el color con todo y el numeral... si no quieres" +
                " que lleve color solo con transparente) + punto, mas el color del texto " +
                "(Puede ser transparente tambien) + punto, mas... el borde si es cuadrado o redondo " +
                "... (Si es cuadrado solo digitar cuadrado... y si es redondo, digitar redondo)" +
                d[2] + " #2) El borde + punto, massss... si o no (Si pone no tendria que ser 'borde.no')" +
                "Si digita que si tendria que ser el tamanio del borde y el color del borde (borde.si.1.black)" +
                d[2] + " #3) Si no lo desea con degradado ... solo digitar (degradado.no) pero... si lo quieres" +
                " con degradado deberas poner si mas el tamanio del degradado mas el color (degradado.si.10.black)" +
                d[3] + q[3] + "<label><center><strong>O tambien...</strong></center></label>" + q[4],
        botonClase: "<h1>5. arreglarBotonClase</h1><label>" + d[0] + "arreglarBotonClase();" +
                d[1] + "3 parametros<br><br>Lo mismo que en arreglarBoton() pero en vez de la pocision" +
                " del boton se pone la clase<br><br><strong><center>Ejemplo:</center></strong>" +
                q[5] + "<label><center><strong>O tambien...</strong></center></label>" + q[6],
        telefono: "<h1>6. telefono</h1><label>Para que se ingrese un telefono y coloque el guion automaticamente" +
                " agregar la clase telefono en el inputText normalmente class='telefono'</label>",
        hora: "<h1>7. hora (ponkItool)</h1><label>Para que se ingrese una hora y coloque el los dos puntos automaticamente" +
                " agregar la clase hora en el inputText normalmente class='hora'</label>",
        fecha: "<h1>8. fecha (ponkItool)</h1><label>Para que se ingrese una fecha y coloque los slash automaticamente" +
                " agregar la clase fecha en el inputText normalmente class='fecha'</label>",
        right: "<h1>9. right</h1><label>Para que el texto dentro del inputText se centre a la derecha agregar" +
                " la clase normalmente dentro del inputText normalmente class='right</label>",
        left: "<h1>10. left</h1><label>Para que el texto dentro del inputText se centre a la izquierda agregar" +
                " la clase normalmente dentro del inputText normalmente class='left</label>",
        center: "<h1>11. center</h1><label>Para que el texto dentro del inputText se centre agregar" +
                " la clase normalmente dentro del inputText normalmente class='center'</label>",
        alerta: "<h1>12. mensaje</h1><label>" + d[0] + "mensaje();" +
                d[1] + "2 parametros" + d[2] + " #1) El mensaje que dira" +
                d[2] + " #2) El titulo de la alerta" + d[3] + q[7] +
                "<label><strong>Nota: se necesita una etiqueta div con id de >ponkImsj< </strong></label></label>",
        reiniciarTema: "<h1>13. reiniciarTema</h1><label>Cuando se edita, se elimina o se inserta..." +
                "El estilo vuelve a reiniciarce al de primefaces... pero, puede anularlo con la etiqueta" +
                "onclick en html y con la llamada a la funcion reinciarTema() </label>onclick='reinicarTema()'" +
                " <label>y esto hace que todo el estilo vuelva a ser como antes..." +
                " dentro de las etiquetas del commandButton donde se quita el tema</label>",
        personalizarMSJ: "<h1>14. editarMSJ</h1><label>El mensaje que muestra en negro primeFaces por defecto se puede" +
                " hacer igual a su estilo (con el color principal y con un blanco de fondo) " +
                " con el codigo de editarMSJ en el onclick del html</label> onclick='editarMSJ()'" +
                " dentro de las etiquetas del commandButton donde se realiza el mensaje",
        todo: '<h1>Ejemplo</h1><br><br>manual();<br>efectoInicio();<br>ponerFondo("source/img/fondo2.gif", "0.50' +
                '", "blancoynegro");<br>' +
                'ponerIcono("source/img/icono.png");<br>' +
                'arreglarBoton("0.transparente.white.cuadrado", "borde.no", "degradado.no");<br>' +
                'ponerTema("#01579b", "white", "Ocultar", "Mostrar", "0.5", "0.9");<br>' +
                'arreglarBotonClase("btnDescripcion.#01579b.white.redondo", "borde.no", "degradado.si.5.black");<br>' +
                'arreglarBotonClase("btnEdicion.orange.white.redondo", "borde.no", "degradado.si.5.black");<br>' +
                'arreglarBotonClase("btnGuardar.#00695c.white.redondo", "borde.no", "degradado.si.5.black");<br>' +
                'arreglarBotonClase("btnEditar.crimson.white.redondo", "borde.no", "degradado.si.5.black");<br>' +
                'arreglarBotonClase("btnEliminacion.red.white.redondo", "borde.no", "degradado.si.5.red");<br><br><br>' +
                "<br><br><label>Recuerda que tenes que exportar el archivo po'" +
                "nki.js antes de hacer este codigo</label>",
    };
    obEt("title")[0].innerHTML = "Instrucciones ponki";
    obEt("body")[0].innerHTML = i.estilo + i.icono + "<br><br><br>" + i.fondo + "<br><br><br>" +
            i.inicio + "<br><br><br>" + i.boton + "<br><br><br>" + i.botonClase + "<br><br><br>" +
            i.telefono + "<br><br><br>" + i.hora + "<br><br><br>" + i.fecha + "<br><br><br>" +
            i.right + "<br><br><br>" + i.left + "<br><br><br>" + i.center + "<br><br><br>" +
            i.alerta + "<br><br><br>" + i.reiniciarTema + "<br><br><br>" + i.personalizarMSJ +
            "<br><br><br><center>" + i.todo + "</center>";
}