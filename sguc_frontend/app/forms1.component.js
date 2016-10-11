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
var Forms1 = (function () {
    function Forms1() {
    }
    Forms1 = __decorate([
        core_1.Component({
            moduleId: module.id,
            selector: 'first-form',
            template: "\n        <div class=\"container\">\n    <h1>Hero Form</h1>\n    <form>\n      <div class=\"form-group\">\n        <label for=\"name\">Name</label>\n        <input type=\"text\" class=\"form-control\" id=\"name\" required [(ngModel)]=\"model.name\" name=\"name\" #spy >\n        <br>TODO: remove this: {{spy.className}}\n      </div>\n      <div class=\"form-group\">\n        <label for=\"alterEgo\">Alter Ego</label>\n        <input type=\"text\" class=\"form-control\" id=\"alterEgo\">\n\n\n\n            <div class=\"form-group\">\n            <label for=\"power\">Hero Power</label>\n                <select class=\"form-control\" id=\"power\" required>\n                    <option *ngFor=\"let p of powers\" [value]=\"p\">{{p}}</option>\n                </select>\n            </div>\n\n\n\n      </div>\n      <button type=\"submit\" class=\"btn btn-default\">Submit</button>\n    </form>\n</div><br>\n    "
        }), 
        __metadata('design:paramtypes', [])
    ], Forms1);
    return Forms1;
}());
exports.Forms1 = Forms1;
//# sourceMappingURL=forms1.component.js.map