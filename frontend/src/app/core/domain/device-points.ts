import { ValuePoint } from './value-point';

export interface DevicePoints {
    amperagePoints: ValuePoint[];
    voltagePoints: ValuePoint[];
    load?: number;
}
