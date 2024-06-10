import { Routes } from '@angular/router';
import {HomeComponent} from "./pages/home/home.component";
import {AboutComponent} from "./pages/about/about.component";
import {CareerComponent} from "./pages/career/career.component";

export const routes: Routes = [
  {path:'home',component:HomeComponent},
  {path:'',redirectTo:'/home',pathMatch:'full'},
  {path:'about',component:AboutComponent},
  {path:'career',component:CareerComponent}
];
