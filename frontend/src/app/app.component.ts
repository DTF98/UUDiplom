import { Component } from '@angular/core';
import { ToolbarComponent } from './toolbar/toolbar.component';
import { DeviceState } from './core/domain/device-state';
import { MatSidenavContainer, MatSidenavContent } from '@angular/material/sidenav';
import { ChartComponent } from './chart/chart.component';
import { AppService } from './core/service/app.service';
import { DevicePoints } from './core/domain/device-points';
import { finalize } from 'rxjs';

@Component({
    selector: 'app-root',
    imports: [ToolbarComponent, MatSidenavContainer, ChartComponent, MatSidenavContent],
    templateUrl: './app.component.html',
    styleUrl: './app.component.scss',
    standalone: true
})
export class AppComponent {

    deviceState: DeviceState = {
        enabled: true,
    };

    devicePoints: DevicePoints = {
        amperagePoints: [],
        voltagePoints: []
    }

    requestInProgress = false;

    constructor(private appService: AppService) {
        this.appService.loadDeviceState().subscribe(deviceState => this.deviceState = deviceState);
    }

    loadDevicePoints(loadKind: number) {
        this.requestInProgress = true;
        this.appService.loadDevicePoints(loadKind).pipe(
            finalize(() => this.requestInProgress = false)
        ).subscribe(devicePoints => this.devicePoints = devicePoints);
    }

    loadDeviceState() {
        this.requestInProgress = true;
        this.appService.loadDeviceState().pipe(
            finalize(() => this.requestInProgress = false)
        ).subscribe(deviceState => this.deviceState = deviceState);
    }
}
