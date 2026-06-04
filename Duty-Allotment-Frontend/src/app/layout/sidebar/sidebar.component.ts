import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent {
  constructor(public router: Router) {}

  isAdminRoute(): boolean {
    return [
      '/admin-dashboard',
      '/faculty-management',
      '/create-duty',
      '/assign-duty',
      '/admin-swap-request',
      '/duty-records'
    ].some(path => this.router.url.includes(path));
  }

  isSwapActive(): boolean {
    return this.router.url === '/swap-request' ||
           this.router.url === '/received-request';
  }
}