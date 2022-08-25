import { Seller } from './seller.model';

export class CarCreateRequest {
    id?: number;
    year?: number;
    mileage?: number;
    engine?: string;
    transmission?: string;
    description?: string;
    price?: number;
    created?: string;
    modified?: string;
    modelId?: number;
    seller: Seller = {}
}
