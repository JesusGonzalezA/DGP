import { Component, OnInit } from '@angular/core';
import { Socio } from 'src/app/models/Socio';
import { Router } from '@angular/router';
import { SociosService } from 'src/app/services/socios.service';

@Component({
  selector: 'app-socios-page',
  templateUrl: './socios-page.component.html',
  styleUrls: ['./socios-page.component.css']
})
export class SociosPageComponent implements OnInit {
  //Listado
  listadoSocios : Socio[] = [];
  listadoSociosFiltrado : Socio[] = [];
  filtro : string = '';


  constructor( private sociosService : SociosService, private router: Router) {
   }

  ngOnInit(): void {
    this.getSocios();
  }

  getSocios() {
    this.sociosService.getSocios().subscribe(
      res => {
        this.listadoSocios = this.listadoSociosFiltrado = res as Socio[];
      },
      err => console.error(err)
    );
   }

  filtrarListado (){
    this.listadoSociosFiltrado = this.listadoSocios.filter(
      socio => 
      (socio.nombre + " " + socio.apellidos).toLowerCase().includes(this.filtro.toLowerCase()) 
    )
  }

  navegaVer (id : number | string) {
    this.router.navigate(['/socios/ver/' + id]);
  }
}
