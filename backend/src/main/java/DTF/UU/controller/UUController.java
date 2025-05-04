package DTF.UU.controller;

import DTF.UU.dto.CurrentAndVoltage;
import DTF.UU.model.ValuePoint;
import DTF.UU.service.UUService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/load")
public class UUController {
    private final UUService uuService;

    public UUController(UUService uuService) {
        this.uuService = uuService;
    }

    @GetMapping("/device-state")
    public boolean updateDeviceState() {
        //return uuService.changeDeviceState();
        return true;
    }

    @GetMapping("/chart-points")
    public CurrentAndVoltage getChartPoints(@RequestParam Integer load) {
        //return uuService.getCurrentAndVoltage(load);
        List<ValuePoint> current = new ArrayList<>();
        List<ValuePoint> voltage = new ArrayList<>();
        Instant time = Instant.now();
        for (double i = 0; i < 9; i++) {
            current.add(new ValuePoint(time.plusMillis(10), i+1));
            voltage.add(new ValuePoint(time.plusMillis(10), i+10));
        }
        return new CurrentAndVoltage(current, voltage, load);
    }
}
