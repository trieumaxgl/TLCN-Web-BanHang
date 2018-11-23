import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { DataTablesModule } from 'angular-datatables';

import { AppComponent } from './app.component';
import { IndexComponent } from './index/index.component';
import { AppRoutingModule } from './app-routing.module';
import { FooterComponent } from './footer/footer.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ProductComponent } from './product/product.component';
import { ProductDetailComponent } from './product-detail/product-detail.component';
import { AdminIndexComponent } from './admin-index/admin-index.component';
import { AdminAccountInfoComponent } from './admin-account-info/admin-account-info.component';
import { AdminMemberComponent } from './admin-member/admin-member.component';
import { AdminBillComponent } from './admin-bill/admin-bill.component';
import { AdminBillDetailComponent } from './admin-bill-detail/admin-bill-detail.component';
import { AdminTypeComponent } from './admin-type/admin-type.component';
import { AdminTypeDetailComponent } from './admin-type-detail/admin-type-detail.component';
import { ModalAccountInfoComponent } from './modal-account-info/modal-account-info.component';
import { CartComponent } from './cart/cart.component';
import { AdminMenuComponent } from './admin-menu/admin-menu.component';
import { AdminTypeAddComponent } from './admin-type-add/admin-type-add.component';

@NgModule({
  declarations: [
    AppComponent,
    IndexComponent,
    FooterComponent,
    DashboardComponent,
    HeaderComponent,
    LoginComponent,
    RegisterComponent,
    ProductComponent,
    ProductDetailComponent,
    AdminIndexComponent,
    AdminAccountInfoComponent,
    AdminMemberComponent,
    AdminBillComponent,
    AdminBillDetailComponent,
    AdminTypeComponent,
    AdminTypeDetailComponent,
    ModalAccountInfoComponent,
    CartComponent,
    AdminMenuComponent,
    AdminTypeAddComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    DataTablesModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
