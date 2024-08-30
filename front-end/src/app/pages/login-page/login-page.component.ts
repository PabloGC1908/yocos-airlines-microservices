import { Component } from '@angular/core';
import {NavbarComponent} from "../../shared/components/navbar/navbar.component";
import {FormsModule} from "@angular/forms";
import {MatSlideToggle} from "@angular/material/slide-toggle";

@Component({
  selector: 'app-login-page',
  standalone: true,
  imports: [
    NavbarComponent,
    FormsModule,
    MatSlideToggle
  ],
  templateUrl: './login-page.component.html',
  styleUrl: './login-page.component.css'
})
export class LoginPageComponent {
  email = '';
  password = '';

  mostrarCredencialesConsola() {
    console.log(this.email);
  }
}
