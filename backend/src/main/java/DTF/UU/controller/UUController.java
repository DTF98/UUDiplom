package DTF.UU.controller;

import DTF.UU.dto.CurrentAndVoltage;
import DTF.UU.service.UUService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/load")
public class UUController {
    private final UUService uuService;

    public UUController(UUService uuService) {
        this.uuService = uuService;
    }

    @GetMapping("/device-state")
    public Boolean updateDeviceState() {
        return uuService.changeDeviceState();
    }

    @GetMapping("/chart-points")
    public CurrentAndVoltage getChartPoints(@RequestParam Integer load) {
        return uuService.getCurrentAndVoltage(load);
    }
}
