import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { first } from 'rxjs/operators';
@Component({
  selector: 'app-admin-menu',
  templateUrl: './admin-menu.component.html',
  styleUrls: ['./admin-menu.component.css',
  '../../assets/admin/assets/css/bootstrap.min.css',
'../../assets/admin/assets/css/animate.min.css',
'../../assets/admin/assets/css/paper-dashboard.css',
'../../assets/admin/assets/css/demo.css',
'../../assets/admin/assets/css/themify-icons.css']
})
export class AdminMenuComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
