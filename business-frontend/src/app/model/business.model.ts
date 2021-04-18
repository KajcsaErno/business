import {OpeningHours} from './opening-hours.model'

export class Business {
    id: number;
    name: string;
    address: string;
    workingDays: OpeningHours[];
}
