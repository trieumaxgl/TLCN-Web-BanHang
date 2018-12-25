import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { first } from 'rxjs/operators';
import { Users } from '../../models/Users';
import { UserServiceService } from '../ad-service/user-service.service';
import { AttachFile } from '../../models/Attach_File';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css',
  '../../assets/member/css/style.css',
  '../../assets/member/fonts/font-awesome-4.7.0/css/font-awesome.min.css'
]
})
export class HeaderComponent implements OnInit {
  username : string
  email : string
  avatar : string
  error : String;
  user: Users;
  constructor( private route : Router,private userService:UserServiceService) {
    this.user = new Users();
    this.avatar = "";
   }

  ngOnInit() {
    this.email = localStorage.getItem("email");
    console.log(this.email);
    this.loadUser();
  }
  loadUser() {
    this.userService.findUser(this.email)
      .subscribe(res => {
        if (res.success == "true") {
          this.user = res.data;
          console.log("last name :" +this.user.lastname)
          this.avatar= res.data.avatar;

        }
      }, err => {
        console.log(err.message)
      });
  }
  onLogout(){
    localStorage.clear()
    this.route.navigate(["/login"]);
  }
}
