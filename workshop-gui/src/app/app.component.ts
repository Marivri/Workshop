import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ObjectListComponent } from "./object-list/object-list.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ObjectListComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'workshop-gui';
}
