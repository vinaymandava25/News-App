import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {


  previousSelectedSkill: any;
  userList: any;
  userId;
  userName;
  constructor(private adminService: AdminService) { }

  ngOnInit() {
    
  }

  searchAnalyst() {
    this.adminService.usersOnSearch(this.userName).subscribe(
      data => {
        this.userList = data;
        console.log("search data :",this.userList)
      });
    
  }

  block(email) {
    console.log(email)
    this.adminService.blockAnalyst(email).subscribe(
      data => {
        this.userList = data;
        console.log(this.userList)
        this.userList.status=data.status;
        this.searchAnalyst();
        console.log(this.userList.status)
      });

  }


}
