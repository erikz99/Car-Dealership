import { Injectable } from '@angular/core';
import { HttpClient, HttpEvent, HttpHeaders, HttpParams, HttpRequest, HttpParamsOptions } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Car } from '../model/car.model';
import { Buyer } from '../model/buyer.model';
import { environment } from 'src/environments/environment';

const brandUrl = `${environment.host}/brands`
const carUrl = `${environment.host}/cars`


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

  getCarsByBrand(brandName: string): Observable<any> {
    return this.http.get(`${carUrl}/brand/${brandName}`);
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
