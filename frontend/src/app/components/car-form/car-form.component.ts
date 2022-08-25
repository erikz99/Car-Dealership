import { Component, OnInit } from '@angular/core';
import { CarFormService } from '../../services/car.service';
import { ActivatedRoute, Router } from '@angular/router';
import { CarCreateRequest } from 'src/app/model/create.model';
import { Brand } from '../../model/brand.model';
import { Model } from '../../model/model.model';

@Component({
  selector: 'app-car-form',
  templateUrl: './car-form.component.html'
})
export class CarFormComponent implements OnInit {

  car: CarCreateRequest = {
    year: undefined,
    mileage: undefined,
    engine: undefined,
    transmission: undefined,
    description: undefined,
    price: undefined,
    modelId: undefined,
    seller: {
      sellerName: "",
      sellerEmail: "",
      sellerPhoneNumber: ""
    }
  };

  engines: string[] = [ 'GASOLINE', 'DIESEL', 'ELECTRIC', 'HYBRID' ];
  selectedEngine?: string;

  transmissions: string[] = [ 'AUTOMATIC', 'SEMI_AUTOMATIC', 'MANUAL' ];
  selectedTransmission?: string

  brands: Brand[] = [];
  selectedBrand?: string;
  models?: Model[];
  selectedModel?: string;

  selectedFiles?: FileList;
  currentFile?: File;

  constructor(
    private carService: CarFormService,
    private route: ActivatedRoute,
    private router: Router) {
  }

  ngOnInit(): void {
    const id = this.route.snapshot.params['id'];
    if (id) {
      this.editCar(this.route.snapshot.params['id']);
    } 
    this.carService.listBrands().subscribe(brands => {
      this.brands = brands;
    });
  }

  editCar(id: number): void {
    this.carService.getCar(id)
      .subscribe(
        data => {
          this.car = data;
        },
        error => {
          console.error(error);
        });
  }

  fillModels(): void {
    console.log(this.selectedBrand);
    this.brands.forEach(brand => {
      if (this.selectedBrand != undefined && brand.name === this.selectedBrand) {
        this.models = brand.models;
      }
    })
  }

  selectFile(event: any): void {
    this.selectedFiles = event.target.files;
    if (this.selectedFiles !== undefined) {
       const file: File | null = this.selectedFiles.item(0);
       if (file !== null) {
         this.currentFile = file;
       }
    }
  }

  saveCar() {
    if (this.car.id) {
      if (this.currentFile) {
        this.car.created = undefined;
        this.car.modified = undefined;
        this.carService.updateCar(this.car.id, this.car, this.currentFile)
        .subscribe(
          response => {
            this.router.navigate([ '/cars' ]);
          },
          error => {
            console.error(error);
          });
      }
    } else {
      if (this.currentFile !== undefined) {
        this.carService.createCar(this.car, this.currentFile)
        .subscribe(
          response => {
            this.router.navigate([ '/cars' ]);
          },
          error => {
            console.error(error);
          });
      }
    }
  }

}
