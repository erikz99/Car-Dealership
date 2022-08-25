import { Model } from './model.model';
import { Buyer } from './buyer.model';
import { Seller } from './seller.model';

export class Car {
    id?: number;
    year?: number;
    mileage?: number;
    engine?: string;
    transmission?: string;
    description?: string;
    price?: number;
    imageUrl?: string;
    created?: string;
    modified?: string;
    model?: Model;
    buyer?: Buyer;
    seller?: Seller
    sold?: boolean
}
