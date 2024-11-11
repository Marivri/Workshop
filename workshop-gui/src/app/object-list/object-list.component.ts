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
    console.log(this.objects)
  }

  constructor(public objectService: ObjectService) {}

  getAll() {
    this.objectService.getAll().subscribe(data => this.objects = data)
  }

}