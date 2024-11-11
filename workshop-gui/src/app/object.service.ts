import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AstronomicalObject } from './object';

@Injectable({
  providedIn: 'root'
})
export class ObjectService {

  constructor(public http: HttpClient) { }

  getAll() {
    return this.http.get<AstronomicalObject[]>('http://localhost:8080/api/objects')
  }
}
