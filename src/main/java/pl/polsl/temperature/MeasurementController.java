package pl.polsl.temperature;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MeasurementController {

    private final MeasurementRepository repository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Measurement addMeasurement(@RequestBody MeasurementPost measurementPost) {
        Measurement measurement = new Measurement();
        measurement.setMeasurementTypeId(measurementPost.getMeasurementTypeId());
        measurement.setStationId(measurementPost.getStationId());
        measurement.setValue(measurementPost.getValue());
        return repository.save(measurement);
    }

}
