import { AfterViewInit, Component, OnInit, Renderer ,ChangeDetectorRef} from '@angular/core';
import { Route, Router } from '@angular/router';
import { AdServiceService } from '../ad-service/ad-service.service';
import { Items } from '../../models/Items';
import { Types } from '../../models/Types';
import { first } from 'rxjs/operators';
import { environment } from '../../environments/environment';
import {HttpClient,HttpHeaders,HttpResponse} from '@angular/common/http';
import * as $ from 'jquery';
import 'datatables.net';
import 'datatables.net-bs4';

class DataTablesResponse {
  data: any[];
  draw: number;
  recordsFiltered: number;
  recordsTotal: number;
}
@Component({
  selector: 'app-admin-type',
  templateUrl: './admin-type.component.html',
  styleUrls: ['./admin-type.component.css',
  '../../assets/admin/assets/css/bootstrap.min.css',
'../../assets/admin/assets/css/animate.min.css',
'../../assets/admin/assets/css/paper-dashboard.css',
'../../assets/admin/assets/css/demo.css',
'../../assets/admin/assets/css/themify-icons.css']
})
export class AdminTypeComponent implements OnInit {
  dataTable: any;
  items:Items[];
  context = environment.base_admin_url;
  
  constructor(private http: HttpClient,private adService: AdServiceService, private router: Router,private chRef: ChangeDetectorRef) { }

  ngOnInit(): void {
    this.adService.loadAllItem()
    .subscribe(res => {
      if(res.success == "true")
      {
        
        this.items = res.data;
        
      }
     

      // You'll have to wait that changeDetection occurs and projects data into 
      // the HTML template, you can ask Angular to that for you ;-)
      this.chRef.detectChanges();

      // Now you can use jQuery DataTables :
      const table: any = $('table');
      this.dataTable = table.DataTable();
    }, err => {
      console.log(err.message)
  });
  
  }
  onGotoItemDetail(id) {
    this.router.navigate(["/admin/type/detail"], { queryParams: { id: id } });
  }
 

}
