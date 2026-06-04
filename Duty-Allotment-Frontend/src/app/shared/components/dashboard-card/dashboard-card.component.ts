import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-dashboard-card',
  templateUrl: './dashboard-card.component.html',
  styleUrls: ['./dashboard-card.component.scss']
})
export class DashboardCardComponent {
  @Input() title = '';
  @Input() count = '00';
  @Input() description = '';
  @Input() iconType: 'calendar' | 'clock' | 'swap' = 'calendar';
}