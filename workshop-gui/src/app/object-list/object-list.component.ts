import { Component, OnInit } from '@angular/core';
import { ObjectService } from '../object.service';
import { CommonModule } from '@angular/common';
import { AstronomicalObject } from '../object';

@Component({
  selector: 'app-object-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './object-list.component.html',
  styleUrl: './object-list.component.css'
})
export class ObjectListComponent implements OnInit {

  objects: AstronomicalObject[] = [];

  ngOnInit(): void {
    this.getAll();
    this.getObject(1);
    console.log(this.objects)
  }

  constructor(public objectService: ObjectService) {}

  getAll() {
    this.objectService.getAll().subscribe(data => this.objects = data)
  }

  getObject(id: number){
    this.objectService.getObjectById(id).subscribe(data => console.log(data))
  }
}