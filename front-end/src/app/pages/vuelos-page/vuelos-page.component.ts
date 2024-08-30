import { Component } from '@angular/core';
import {NavbarComponent} from "../../shared/components/navbar/navbar.component";

@Component({
  selector: 'app-vuelos-page',
  standalone: true,
  imports: [
    NavbarComponent
  ],
  templateUrl: './vuelos-page.component.html',
  styleUrl: './vuelos-page.component.css'
})
export class VuelosPageComponent {

}
