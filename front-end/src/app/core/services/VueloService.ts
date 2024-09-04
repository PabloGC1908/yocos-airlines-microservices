import {Injectable} from "@angular/core";
import {environment} from "../../../environtments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class VueloService {
  private readonly API_URL = environment.apiUrl;

  constructor(private http: HttpClient) {
  }

  getVuelos(): Observable<any> {
    return this.http.get<Observable<any[]>>(`${this.API_URL}/airlines`);
  }
}
