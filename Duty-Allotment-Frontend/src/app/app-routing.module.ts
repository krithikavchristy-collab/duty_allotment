import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { AssignedDutiesComponent } from './pages/assigned-duties/assigned-duties.component';
import { SwapRequestComponent } from './pages/swap-request/swap-request.component';
import { DutyHistoryComponent } from './pages/duty-history/duty-history.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'dashboard',
    pathMatch: 'full'
  },
  {
    path: 'dashboard',
    component: DashboardComponent
  },
  {
    path: 'assigned-duties',
    component: AssignedDutiesComponent
  },
  {
    path: 'swap-request',
    component: SwapRequestComponent
  },
  {
    path: 'duty-history',
    component: DutyHistoryComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }