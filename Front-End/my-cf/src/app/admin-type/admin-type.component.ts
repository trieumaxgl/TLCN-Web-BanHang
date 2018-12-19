import { AfterViewInit, Component, OnInit, Renderer } from '@angular/core';
import { Route, Router } from '@angular/router';
import { AdServiceService } from '../ad-service/ad-service.service';
import { Items } from '../../models/Items';
import { Types } from '../../models/Types';
import { first } from 'rxjs/operators';
import { environment } from '../../environments/environment';
import {HttpClient,HttpHeaders,HttpResponse} from '@angular/common/http';

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
export class AdminTypeComponent implements AfterViewInit,OnInit {
  dtOptions: DataTables.Settings = {};
  items:Items[];
  context = environment.base_admin_url;
  
  constructor(private http: HttpClient,private renderer: Renderer, private router: Router) { }

  ngOnInit(): void {
    const that = this;
    
        this.dtOptions = {
          pagingType: 'full_numbers',
          pageLength: 2,
          serverSide: true,
          processing: true,
          ajax: (dataTablesParameters: any, callback) => {
            that.http
              .post<DataTablesResponse>(
                `${this.context}api/v1/admin/items/load`,
                dataTablesParameters, {}
              ).subscribe(resp => {
                that.items = resp.data;
                callback({
                  recordsTotal: resp.recordsTotal,
                  recordsFiltered: resp.recordsFiltered,
                  data: []
                });
              });
          },
          columns: [{ data: 'id' }, { data: 'name' }, 
          { data: 'description' }, { data: 'status' },
           { data: 'price' }, { data: 'typesId' }, {
            render: function (data: any, type: any, full: any) {
              return 'View';
            }
          }]
        };
  }
  ngAfterViewInit(): void {
    this.renderer.listenGlobal('document', 'click', (event) => {
      if (event.target.hasAttribute("view-item-id")) {
        this.router.navigate(["/item/" + event.target.getAttribute("view-item-id")]);
      }
    });
  }

}
