import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { first } from 'rxjs/operators';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css',
  '../../assets/member/css/style.css',
  '../../assets/member/fonts/font-awesome-4.7.0/css/font-awesome.min.css'
]
})
export class HeaderComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
