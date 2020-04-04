import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignupComponent } from './signup/signup.component';
import { NewsComponent } from './news/news.component';
import { LoginComponent } from './login/login.component';
import { AdminComponent } from './admin/admin.component';
import { FavouritesComponent } from './favourites/favourites.component';
import { HeaderComponent } from './header/header.component';
import { AuthGuard } from './auth.guard';

const routes: Routes = [
  {path:"news",component:NewsComponent,canActivate: [AuthGuard] },
  {path:"signup",component:SignupComponent},
  {path:"",component:SignupComponent},
  {path:"login",component:LoginComponent},
  {path:"search",component:AdminComponent},
  {path:"favourite",component:FavouritesComponent,canActivate: [AuthGuard] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
