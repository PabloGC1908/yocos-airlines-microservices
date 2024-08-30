import { Component } from '@angular/core';
import {NavbarComponent} from "../../shared/components/navbar/navbar.component";

@Component({
  selector: 'app-nosotros-page',
  standalone: true,
  imports: [
    NavbarComponent
  ],
  templateUrl: './nosotros-page.component.html',
  styleUrl: './nosotros-page.component.css'
})
export class NosotrosPageComponent {

}
