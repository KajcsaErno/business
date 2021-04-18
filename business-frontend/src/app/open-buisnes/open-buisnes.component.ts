import { Component } from '@angular/core';
import { Location } from '@angular/common';
import { Business } from '../model/business.model';
import { BusinessService } from '../business-service/business-service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-open-buisnes',
  templateUrl: './open-buisnes.component.html',
  styleUrls: ['./open-buisnes.component.scss']
})
export class OpenBuisnesComponent  {

  busines: Business;
  private id = +this.route.snapshot.paramMap.get('id');

  constructor(
    private route: ActivatedRoute,
      private router: Router,
        private businessService: BusinessService,
          private location: Location) {}

  ngOnInit(): void {
    this.getBusiness();
  }

  getBusiness(): void {
    this.businessService.getBusinessById(this.id)
      .subscribe(bis => this.busines = bis);
  }


  goBack() {
    this.location.back();
    console.log(this.busines)
  }

}
