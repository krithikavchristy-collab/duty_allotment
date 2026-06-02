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
import { ReceivedRequestComponent } from './pages/received-request/received-request.component';

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
    ReceivedRequestComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
