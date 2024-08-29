import { Routes } from '@angular/router';
import {AppComponent} from "./app.component";
import {HomePageComponent} from "./pages/home-page/home-page.component";
import {VuelosPageComponent} from "./pages/vuelos-page/vuelos-page.component";
import {LoginPageComponent} from "./pages/login-page/login-page.component";
import {NosotrosPageComponent} from "./pages/nosotros-page/nosotros-page.component";

export const routes: Routes = [
  {
    path: '',
    component: HomePageComponent
  },
  {
    path: 'vuelos',
    component: VuelosPageComponent
  },
  {
    path: 'login',
    component: LoginPageComponent
  },
  {
    path: 'nosotros',
    component: NosotrosPageComponent
  }
];
