import {Component, OnInit} from '@angular/core';
import {NavbarComponent} from "../../shared/components/navbar/navbar.component";
import {VueloService} from "../../core/services/VueloService";
import {
  MatCell,
  MatCellDef,
  MatColumnDef,
  MatHeaderCell,
  MatHeaderCellDef,
  MatHeaderRow, MatHeaderRowDef, MatRow, MatRowDef,
  MatTable
} from "@angular/material/table";

@Component({
  selector: 'app-vuelos-page',
  standalone: true,
  imports: [
    NavbarComponent,
    MatTable,
    MatCell,
    MatCellDef,
    MatHeaderCell,
    MatHeaderCellDef,
    MatColumnDef,
    MatHeaderRow,
    MatRow,
    MatRowDef,
    MatHeaderRowDef
  ],
  templateUrl: './vuelos-page.component.html',
  styleUrl: './vuelos-page.component.css'
})
export class VuelosPageComponent implements OnInit {
  columns: string[] = ['position', 'aerolinea']
  vuelos: any[];

  constructor(private vueloService: VueloService) {
    this.vuelos = [];
  }

  ngOnInit() {
    this.getVuelos();
  }

  getVuelos () {
    this.vueloService.getVuelos().subscribe({
      next: (data) => {
        this.vuelos = data;
        console.log(this.vuelos);
      },
      error: (err) => {
        console.log(err);
      }
    })
  }
}
