import { Component } from '@angular/core';

@Component({
  selector: 'app-admin-swap-request',
  templateUrl: './admin-swap-request.component.html',
  styleUrls: ['./admin-swap-request.component.css']
})
export class AdminSwapRequestComponent {

  swapRequests = [
    {
      requester: {
        name: 'Bonnie Green',
        image: 'assets/images/image1.jpg',
        duty: 'Exam Duty - 22 May 2026',
        time: '9:00 AM - 12:00 PM',
        block: 'Block A 101',
        reason: 'I have a meeting',
        requestedOn: '18 May 2026'
      },
      requestedWith: {
        name: 'John',
        image: 'assets/images/image2.jpg'
      }
    },
    {
      requester: {
        name: 'Bonnie Green',
        image: 'assets/images/image1.jpg',
        duty: 'Exam Duty - 22 May 2026',
        time: '9:00 AM - 12:00 PM',
        block: 'Block A 101',
        reason: 'I have a meeting',
        requestedOn: '18 May 2026'
      },
      requestedWith: {
        name: 'John',
        image: 'assets/images/image2.jpg'
      }
    }
  ];

}