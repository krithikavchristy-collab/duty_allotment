import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { AssignedDutiesComponent } from './pages/assigned-duties/assigned-duties.component';
import { SwapRequestComponent } from './pages/swap-request/swap-request.component';
import { ReceivedRequestComponent } from './pages/received-request/received-request.component';
import { DutyHistoryComponent } from './pages/duty-history/duty-history.component';

import { AdminDashboardComponent } from './pages/admin-dashboard/admin-dashboard.component';
import { FacultyManagementComponent } from './pages/faculty-management/faculty-management.component';
import { CreateDutyComponent } from './pages/create-duty/create-duty.component';
import { AssignDutyComponent } from './pages/assign-duty/assign-duty.component';
import { AdminSwapRequestComponent } from './pages/admin-swap-request/admin-swap-request.component';
import { DutyRecordsComponent } from './pages/duty-records/duty-records.component';

const routes: Routes = [
  { path: '', redirectTo: 'dashboard', pathMatch: 'full' },

  { path: 'dashboard', component: DashboardComponent },
  { path: 'assigned-duties', component: AssignedDutiesComponent },
  { path: 'swap-request', component: SwapRequestComponent },
  { path: 'received-request', component: ReceivedRequestComponent },
  { path: 'duty-history', component: DutyHistoryComponent },

  { path: 'admin-dashboard', component: AdminDashboardComponent },
  { path: 'faculty-management', component: FacultyManagementComponent },
  { path: 'create-duty', component: CreateDutyComponent },
  { path: 'assign-duty', component: AssignDutyComponent },
  { path: 'admin-swap-request', component: AdminSwapRequestComponent },
  { path: 'duty-records', component: DutyRecordsComponent },

  { path: '**', redirectTo: 'dashboard' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }