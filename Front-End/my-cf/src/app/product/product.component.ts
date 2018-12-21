import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { AdServiceService } from '../ad-service/ad-service.service';
import { Items } from '../../models/Items';
import { AttachFile } from '../../models/Attach_File';
import { Types } from '../../models/Types';
import { first } from 'rxjs/operators';
import { environment } from '../../environments/environment';
import {HttpClient,HttpHeaders,HttpResponse} from '@angular/common/http';
import * as $ from 'jquery';
import 'datatables.net';
import 'datatables.net-bs4';
@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css',
  '../../assets/member/css/style.css',
  '../../assets/member/fonts/font-awesome-4.7.0/css/font-awesome.min.css',
  '../../assets/member/css/lightbox.css',
  '../../assets/member/css/slider.css',
  '../../assets/member/css/util.css'
]
})
export class ProductComponent implements OnInit {
  items:Items[];
  attachFiles : AttachFile[];
  constructor(private adService: AdServiceService, private router: Router) { }

  ngOnInit(): void {
    this.adService.loadAllItem()
    .subscribe(res => {
      if(res.success == "true")
      {
        this.items = res.data; 
      }
     
    }, err => {
      console.log(err.message)
  });
  this.adService.findItemByAttachFile()
  .pipe(first())
  .subscribe(res=>{
    if(res.success == "true")
    {
      this.attachFiles = res.data; 
    }
  }, err => {
    console.log(err.message)
});
  
  }
  onGotoProductView(id) {
    this.router.navigate(["/product/view"], { queryParams: { id: id } });
  }
  onGotoProductDetail(id) {
    this.router.navigate(["/product/detail"], { queryParams: { id: id } });
  }
}
