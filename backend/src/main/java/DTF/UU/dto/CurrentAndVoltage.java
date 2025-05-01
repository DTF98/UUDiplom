package DTF.UU.dto;

import DTF.UU.model.ValuePoint;

import java.util.List;

public record CurrentAndVoltage(List<ValuePoint> current, List<ValuePoint> voltage) {
}
