import { Component, OnInit } from '@angular/core';
import { AdServiceService } from '../ad-service/ad-service.service';
import { FormBuilder ,FormGroup, Validators , FormControl} from '@angular/forms';
import { Items } from '../../models/Items';
import { Router, ActivatedRoute } from '@angular/router';
import { first } from 'rxjs/operators';
@Component({
  selector: 'app-admin-type-detail',
  templateUrl: './admin-type-detail.component.html',
  styleUrls: ['./admin-type-detail.component.css',
'../../assets/admin/assets/css/bootstrap.min.css',
'../../assets/admin/assets/css/animate.min.css',
'../../assets/admin/assets/css/paper-dashboard.css',
'../../assets/admin/assets/css/demo.css',
'../../assets/admin/assets/css/themify-icons.css',
'../../assets/admin/assets/css/pgwslider.css',
'../../assets/admin/assets/css/pgwslider.min.css']
})
export class AdminTypeDetailComponent implements OnInit {
  item:Items;
  itemUpdate:Items;
  error : string;
  id : string
  constructor(private router: Router,private adService:AdServiceService,private activatedRoute: ActivatedRoute) { 
    this.item = new Items();
    this.itemUpdate = new Items();
    this.itemUpdate.status=1;
  }

  ngOnInit() {
    this.activatedRoute.queryParamMap.subscribe(queryParams => {
      this.id = queryParams.get("id");      
    });
    this.retrieveItemById(this.id);
   
  }
  updateItem(){
    this.adService.updateItem(this.itemUpdate)
    .pipe(first())
    .subscribe(res=>{
        if(res.id){
          alert("Cập nhật thành công!!");
        }
        else
        {
          alert("Cập nhật thất bại!!");
            this.error = res.message
        }
    },err => {
      console.log(err);
    });
  }
  retrieveItemById(id) {
    if(this.id)
    {
      this.adService.findItemById(this.id)
      .pipe(first())
      .subscribe(res => {
        if(res.success == "true")
        {
          this.item = res.data;
          this.itemUpdate = this.item;
          console.log(this.item.id);
        }
        else
        {
            this.error = res.message
        }
      }, err => {
        console.log(err)
      })  

    }
  }

}
