import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { Forms1 } from './forms1.component';

@NgModule({
  imports: [BrowserModule,
            FormsModule
            ],
  declarations: [AppComponent,
                Forms1
                ],
  bootstrap: [AppComponent]
})

export class AppModule {

}