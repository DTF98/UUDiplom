import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of, timeout } from 'rxjs';
import { DeviceState } from '../domain/device-state';
import { DevicePoints } from '../domain/device-points';

@Injectable({
    providedIn: 'root',
})
export class AppService {

    constructor(private httpClient: HttpClient) {
    }

    loadDeviceState(): Observable<DeviceState> {
        // return of({
        //     enabled: true
        // })
        return this.httpClient.get<DeviceState>(`http://localhost:8080/api/load-device-state`);
    }

    loadDevicePoints(deviceLoadKind: number): Observable<DevicePoints> {
        // return of({
        //     amperagePoints: [
        //         { time: new Date(1000), value: (Math.random()+1)*100 },
        //         { time: new Date(2000), value: (Math.random()+1)*100 },
        //         { time: new Date(3000), value: (Math.random()+1)*100 },
        //         { time: new Date(4000), value: (Math.random()+1)*100 },
        //         { time: new Date(5000), value: (Math.random()+1)*100 }
        //     ],
        //     voltagePoints: [
        //         { time: new Date(1000), value: (Math.random()+1)*100 },
        //         { time: new Date(2000), value: (Math.random()+1)*100 },
        //         { time: new Date(3000), value: (Math.random()+1)*100 },
        //         { time: new Date(4000), value: (Math.random()+1)*100 },
        //         { time: new Date(5000), value: (Math.random()+1)*100 }
        //     ],
        //     load: 123
        // });
        return this.httpClient.post<DevicePoints>(`http://localhost:8080/api/load-chart-points`,
            JSON.stringify(deviceLoadKind), { headers: { 'Content-Type': 'application/json' } });
    }
}
