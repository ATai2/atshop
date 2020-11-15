import {Component} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ssodemo';
  authenticated = false;
  credentials = {username: "aaa", password: "ddd"}


  constructor(private http:HttpClient) {
  }

  login() {
    this.http.post("login")
  }
}
