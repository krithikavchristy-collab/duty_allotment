import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HeaderComponent } from './layout/header/header.component';
import { SidebarComponent } from './layout/sidebar/sidebar.component';
import { FooterComponent } from './layout/footer/footer.component';
import { MainLayoutComponent } from './layout/main-layout/main-layout.component';

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

import { DashboardCardComponent } from './shared/components/dashboard-card/dashboard-card.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    SidebarComponent,
    FooterComponent,
    MainLayoutComponent,
    DashboardComponent,
    AssignedDutiesComponent,
    SwapRequestComponent,
    ReceivedRequestComponent,
    DutyHistoryComponent,
    AdminDashboardComponent,
    FacultyManagementComponent,
    CreateDutyComponent,
    AssignDutyComponent,
    AdminSwapRequestComponent,
    DutyRecordsComponent,
    DashboardCardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    RouterModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }