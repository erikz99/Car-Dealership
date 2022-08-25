import { Component, OnInit } from '@angular/core';
import { Car } from '../../model/car.model';
import { Buyer } from '../../model/buyer.model';
import { CarFormService } from '../../services/car.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-car-list',
  templateUrl: './car-list.components.html'
})
export class CarListComponent implements OnInit {
  cars?: Car[];
  selected?: Car;
  currentIndex: number = -1;
  title: string = '';
  message: string = '';
  buyer: Buyer = {
    buyerName: "",
    buyerEmail: "",
    buyerPhoneNumber: ""
  }

  constructor(private carService: CarFormService, private route: ActivatedRoute) {
    route.params.subscribe(val => {
      this.carService.getCars().subscribe(cars => {
        this.cars = cars;
        this.refreshList();
      });
    });
  }

  ngOnInit(): void {
    this.carService.getCars().subscribe(cars => {
      this.cars = cars;
      this.refreshList();
    });
  }

  refreshList(): void {
    this.carService.getCars().subscribe(cars => {
      this.cars = cars;
    });
  }

  buyCar(id?: number): void {
    if (id !== undefined) {
      this.carService.buyCar(id, this.buyer).subscribe((updatedCar => {
        if (this.cars !== undefined) {
          this.cars.forEach((car, i) => {
            if (car.id === updatedCar.id) {
              if (this.cars !== undefined) {
                this.cars[i] = updatedCar;
              }
            }
          })
        }
      }));
    }
  }

  deleteCar(id?: number): void {
    if (id !== undefined) {
      this.carService.deleteCar(id)
      .subscribe(
        response => {
          this.refreshList();
        },
        error => {
          console.error(error);
        });
    }
  }

}
