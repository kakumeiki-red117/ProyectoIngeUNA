import { Component } from '@angular/core';

@Component({
    moduleId: module.id,
    selector: 'my-app',
    template: `
    <div class="container-logo">
        <img id="logo" src="img/K9.png">
    </div>
    <div id = "afterlogo">
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">K9</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">Home</a></li>
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Informes<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Informe 1</a></li>
                            <li><a href="#">Informe 1</a></li>
                            <li><a href="#">Informe 1</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Canes</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                </ul>
            </div>
            <div class="jumbotron">
                <h1>{{title}}</h1>
            </div>
        </nav>
    </div>

    <section id='initialpage'>
    <div id="container">
        <b>¿QUÉ ES LA POLICÍA MUNICIPAL?</b><br/>
        <p>Es un cuerpo policial que desarrolla plenamente las funciones públicas de seguridad y vigilancia.</p>
        <p>Posee autonomía funcional en el ámbito de su jurisdicción.</p>
        <p>Es una policía preventiva, administrativa y de presencia al beneficio del ciudadano.</p><br/>

        <b>CREACIÓN</b>
        <p>La Policía Municipal de Heredia fue creada el jueves 07 de setiembre de 1995, en la sesión ordinaria #177-95. Inició
            con dos plazas para oficiales en ese momento, al día de hoy es integrada por 35 personas organizadas en cinco
            grupos de acción</p><br/><br/>
    </div>
</section><br><br>


    <footer>
        <p>La Policia Municipal mantiene un horario de trabajo las 24 horas</p>
        <p>Teléfonos: 2277-6735 / 6736/6737</p>
        <p>Contact information: <a href="mailto:someone@example.com">
        someone@example.com</a>.</p>
    </footer>
  `
})
export class AppComponent {
    title = 'Sistema Gestor de la Unidad Canina';
}