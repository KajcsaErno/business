import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { Business } from '../model/business.model';


@Injectable()
export class BusinessService {

  private businessUrl: string;

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) {
    this.businessUrl = 'http://localhost:8080/business';
  }

  public findAllBusiness(): Observable<Business[]> {
    const allBusinessUrl = 'http://localhost:8080/allBusinesses' 
    return this.http.get<Business[]>(allBusinessUrl)
    .pipe(map(data => data), catchError(this.handleError));
     }

  public getBusinessById(id: number): Observable<Business> {
    const url = `${this.businessUrl}/${id}`;
    return this.http.get<Business>(url).pipe(
     tap(_ => console.log(`fetched business with id=${id}`)),
     catchError(this.handleError<Business>(`getBusinessById id=${id}`))
   );
 }

 private handleError<T>(operation = 'operation', result?: T) {
  return (error: any): Observable<T> => {
    console.error(error); 
    console.log(`${operation} failed: ${error.message}`);
    return of(result as T);
  };
}

}
