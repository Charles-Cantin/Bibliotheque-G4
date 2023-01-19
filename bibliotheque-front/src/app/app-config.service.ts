import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AppConfigService {
  backEndUrl: string = "http://localhost:9999/";

  constructor() { }
}