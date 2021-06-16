import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserRegistationService } from '../user-registration.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {


  user: User=new User();
  message:any;

  constructor(private service:UserRegistationService) { }

  ngOnInit() {
    this.user.name="";
    this.user.email="";
    this.user.password="";
  }
  

  public registerNow(){
let resp=this.service.doRegistration(this.user);
resp.subscribe((data)=>this.message=data);
  }

}
