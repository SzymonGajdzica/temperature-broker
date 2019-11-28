package pl.polsl.temperature.measurement;

import lombok.Data;
import lombok.ToString;

import java.util.UUID;

@ToString
@Data
public class MeasurementPost {

    private Double value;
    private Long measurementTypeId;
    private Long stationId;
    private UUID secretId;

}
