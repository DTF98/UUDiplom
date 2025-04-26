import { ChangeDetectionStrategy, Component, EventEmitter, Input, Output } from '@angular/core';
import { DeviceState } from '../core/domain/device-state';
import { NgIf, NgOptimizedImage } from '@angular/common';
import { MatFormField } from '@angular/material/input';
import { MatOption, MatSelect, MatLabel } from '@angular/material/select';

@Component({
    selector: 'app-toolbar',
    imports: [
        NgIf,
        MatFormField,
        MatSelect,
        MatOption,
        MatLabel,
    ],
    templateUrl: './toolbar.component.html',
    styleUrl: './toolbar.component.scss',
    standalone: true,
    changeDetection: ChangeDetectionStrategy.OnPush
})
export class ToolbarComponent {
    @Input()
    deviceState?: DeviceState;

    @Input()
    requestInProgress = false;

    @Output()
    readonly loadNewDevicePoints: EventEmitter<number> = new EventEmitter();

    @Output()
    readonly loadDeviceState = new EventEmitter();

    deviceLoadKinds: number[] = [24, 12, 8, 6];

    selectedLoadKind = this.deviceLoadKinds[0];

    updateDeviceState() {
        this.loadDeviceState.emit();
    }

    loadNewPoints() {
        this.loadNewDevicePoints.emit(this.selectedLoadKind);
    }
}
