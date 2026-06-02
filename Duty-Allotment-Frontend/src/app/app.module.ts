import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainLayoutComponent } from './layout/main-layout/main-layout.component';
import { HeaderComponent } from './layout/header/header.component';
import { SidebarComponent } from './layout/sidebar/sidebar.component';
import { FooterComponent } from './layout/footer/footer.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { AssignedDutiesComponent } from './pages/assigned-duties/assigned-duties.component';
import { SwapRequestComponent } from './pages/swap-request/swap-request.component';
import { DutyHistoryComponent } from './pages/duty-history/duty-history.component';
import { DashboardCardComponent } from './shared/components/dashboard-card/dashboard-card.component';
import { AdminDashboardComponent } from './pages/admin-dashboard/admin-dashboard.component';
import { FacultyManagementComponent } from './pages/faculty-management/faculty-management.component';
import { CreateDutyComponent } from './pages/create-duty/create-duty.component';
import { AssignDutyComponent } from './pages/assign-duty/assign-duty.component';
import { AdminSwapRequestComponent } from './pages/admin-swap-request/admin-swap-request.component';
import { DutyRecordsComponent } from './pages/duty-records/duty-records.component';

@NgModule({
  declarations: [
    AppComponent,
    MainLayoutComponent,
    HeaderComponent,
    SidebarComponent,
    FooterComponent,
    DashboardComponent,
    AssignedDutiesComponent,
    SwapRequestComponent,
    DutyHistoryComponent,
    DashboardCardComponent,
    AdminDashboardComponent,
    FacultyManagementComponent,
    CreateDutyComponent,
    AssignDutyComponent,
    AdminSwapRequestComponent,
    DutyRecordsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
