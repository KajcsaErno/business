import { Component, OnInit } from '@angular/core';
import {Business} from '../model/business.model'
import {BusinessService} from '../business-service/business-service'
 
@Component({
  selector: 'app-business-list',
  templateUrl: './business-list.component.html',
  styleUrls: ['./business-list.component.scss']
})
export class BusinessListComponent implements OnInit {

  businesses: Business[];

  constructor(private businessService: BusinessService) { }

  ngOnInit(): void {
    this.getAllBusiness();
  }

  public getAllBusiness() {
    this.businessService.findAllBusiness()
    .subscribe(data => {this.businesses = data;
    });
  }

}
