import { AfterViewInit, ChangeDetectionStrategy, Component, Input } from '@angular/core';
import Chart from 'chart.js/auto';
import 'chartjs-adapter-moment';
import { v4 as uuidv4 } from 'uuid';
import { ValuePoint } from '../core/domain/value-point';

@Component({
    selector: 'app-chart',
    imports: [],
    templateUrl: './chart.component.html',
    styleUrl: './chart.component.scss',
    changeDetection: ChangeDetectionStrategy.OnPush,
    standalone: true
})
export class ChartComponent implements AfterViewInit {

    @Input()
    yAxisTitle?: string;

    @Input()
    lineColorHex: string = "#000000";

    @Input()
    set points(points: ValuePoint[]) {
        this._points = points;
        if (this.chart) {
            this.chart.data.datasets[0].data = points.map(p => ({x: p.time.getTime(), y: p.value}));
            this.chart.update();
        }
    }

    _points: ValuePoint[] = [];

    uuid = uuidv4();

    chart: any;

    ngAfterViewInit(): void {
        Chart.defaults.color = '#D3D3D3';
        this.chart = new Chart(this.uuid, {
            type: 'line',

            data: {
                datasets: [{
                    data: this._points.map(p => ({x: p.time.getTime(), y: p.value})),
                    fill: false,
                    borderColor: this.lineColorHex
                }]
            },

            options: {
                plugins: {
                    legend: {
                        display: false
                    }
                },
                scales: {
                    xAxis: {
                        type: 'linear'
                    },
                    x: {
                        ticks: {
                            callback: function (val, index) {
                                return val;
                            },
                            color: 'red',
                        },
                        title: {
                            display: true,
                            text: 'Время',
                            font: {
                                size: 20
                            }
                        },
                        border: {
                          display: false
                        },
                        grid: {
                            display: false,
                            lineWidth: 10
                        }
                    },
                    y: {
                        title: {
                            display: true,
                            text: this.yAxisTitle,
                            font: {
                                size: 20
                            }
                        },
                        grid: {
                            color: "#4A4A4A"
                        }
                    },
                },
                maintainAspectRatio: false
            }
        });
    }
}
