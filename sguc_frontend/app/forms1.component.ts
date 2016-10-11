import { Component } from '@angular/core';

@Component({
    moduleId: module.id,
    selector: 'first-form',
    template: `
        <div class="container">
    <h1>Hero Form</h1>
    <form>
      <div class="form-group">
        <label for="name">Name</label>
        <input type="text" class="form-control" id="name" required [(ngModel)]="model.name" name="name" #spy >
        <br>TODO: remove this: {{spy.className}}
      </div>
      <div class="form-group">
        <label for="alterEgo">Alter Ego</label>
        <input type="text" class="form-control" id="alterEgo">



            <div class="form-group">
            <label for="power">Hero Power</label>
                <select class="form-control" id="power" required>
                    <option *ngFor="let p of powers" [value]="p">{{p}}</option>
                </select>
            </div>



      </div>
      <button type="submit" class="btn btn-default">Submit</button>
    </form>
</div><br>
    `
})
export class Forms1 {

}