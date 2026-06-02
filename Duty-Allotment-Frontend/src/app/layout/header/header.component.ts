import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
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
}