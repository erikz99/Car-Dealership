import { Injectable } from '@angular/core';
import { HttpClient, HttpEvent, HttpHeaders, HttpParams, HttpRequest, HttpParamsOptions } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Car } from '../model/car.model';
import { Buyer } from '../model/buyer.model';
import { Seller } from '../model/seller.model';

const baseUrl = 'http://localhost:8080/api/v1/car-dealership';
const brandUrl = `${baseUrl}/brands`
const carUrl = `${baseUrl}/cars`


@Injectable({
  providedIn: 'root'
})
export class CarFormService {

  constructor(private http: HttpClient) { }

  listBrands(): Observable<any> {
    return this.http.get(brandUrl);
  }

  getCar(id: number): Observable<any> {
    return this.http.get(`${carUrl}/${id}`);
  }

  getCars(): Observable<any> {
    return this.http.get(`${carUrl}`);
  }


  createCar(data: Car, file: File): Observable<any> {
    const formData: FormData = new FormData();

    formData.append('file', file);
    formData.append('car', new Blob([JSON
      .stringify(data)], {
      type: 'application/json'
    }));

    const req = new HttpRequest('POST', carUrl, formData, {
      reportProgress: true,
      responseType: 'text'
    });

    return this.http.request(req);
  }

  updateCar(id: number, data: Car, file: File): Observable<any> {
    const formData: FormData = new FormData();

    formData.append('file', file);
    formData.append('car', new Blob([JSON
      .stringify(data)], {
      type: 'application/json'
    }));

    const req = new HttpRequest('PUT', carUrl, formData, {
      reportProgress: true,
      responseType: 'text'
    });

    return this.http.request(req);
  }

  buyCar(id: number, data: Buyer): Observable<any> {
    return this.http.patch(`${carUrl}/${id}`, data);
  }

  deleteCar(id: number): Observable<any> {
    return this.http.delete(`${carUrl}/${id}`);
  }

}
