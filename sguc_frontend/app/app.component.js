"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require('@angular/core');
var AppComponent = (function () {
    function AppComponent() {
        this.title = 'Sistema Gestor de la Unidad Canina';
    }
    AppComponent = __decorate([
        core_1.Component({
            moduleId: module.id,
            selector: 'my-app',
            template: "\n    <div class=\"container-logo\">\n        <img id=\"logo\" src=\"img/K9.png\">\n    </div>\n    <div id = \"afterlogo\">\n        <nav class=\"navbar navbar-inverse\">\n            <div class=\"container-fluid\">\n                <div class=\"navbar-header\">\n                    <a class=\"navbar-brand\" href=\"#\">K9</a>\n                </div>\n                <ul class=\"nav navbar-nav\">\n                    <li class=\"active\"><a href=\"#\">Home</a></li>\n                    <li class=\"dropdown\"><a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">Informes<span class=\"caret\"></span></a>\n                        <ul class=\"dropdown-menu\">\n                            <li><a href=\"#\">Informe 1</a></li>\n                            <li><a href=\"#\">Informe 1</a></li>\n                            <li><a href=\"#\">Informe 1</a></li>\n                        </ul>\n                    </li>\n                    <li><a href=\"#\">Canes</a></li>\n                </ul>\n                <ul class=\"nav navbar-nav navbar-right\">\n                    <li><a href=\"#\"><span class=\"glyphicon glyphicon-user\"></span> Sign Up</a></li>\n                    <li><a href=\"#\"><span class=\"glyphicon glyphicon-log-in\"></span> Login</a></li>\n                </ul>\n            </div>\n            <div class=\"jumbotron\">\n                <h1>{{title}}</h1>\n            </div>\n        </nav>\n    </div>\n\n    <section id='initialpage'>\n    <div id=\"container\">\n        <b>\u00BFQU\u00C9 ES LA POLIC\u00CDA MUNICIPAL?</b><br/>\n        <p>Es un cuerpo policial que desarrolla plenamente las funciones p\u00FAblicas de seguridad y vigilancia.</p>\n        <p>Posee autonom\u00EDa funcional en el \u00E1mbito de su jurisdicci\u00F3n.</p>\n        <p>Es una polic\u00EDa preventiva, administrativa y de presencia al beneficio del ciudadano.</p><br/>\n\n        <b>CREACI\u00D3N</b>\n        <p>La Polic\u00EDa Municipal de Heredia fue creada el jueves 07 de setiembre de 1995, en la sesi\u00F3n ordinaria #177-95. Inici\u00F3\n            con dos plazas para oficiales en ese momento, al d\u00EDa de hoy es integrada por 35 personas organizadas en cinco\n            grupos de acci\u00F3n</p><br/><br/>\n    </div>\n</section><br><br>\n\n\n    <footer>\n        <p>La Policia Municipal mantiene un horario de trabajo las 24 horas</p>\n        <p>Tel\u00E9fonos: 2277-6735 / 6736/6737</p>\n        <p>Contact information: <a href=\"mailto:someone@example.com\">\n        someone@example.com</a>.</p>\n    </footer>\n  "
        }), 
        __metadata('design:paramtypes', [])
    ], AppComponent);
    return AppComponent;
}());
exports.AppComponent = AppComponent;
//# sourceMappingURL=app.component.js.map