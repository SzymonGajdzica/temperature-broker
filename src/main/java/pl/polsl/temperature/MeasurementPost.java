package pl.polsl.temperature;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class MeasurementPost {

    private Double value;
    private Long measurementTypeId;
    private Long stationId;

}
