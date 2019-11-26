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
    public Measurement addMeasurement(@RequestBody Measurement measurement) {
        if(measurement.getValue() == null || measurement.getMeasurementTypeId() == null || measurement.getStationId() == null)
            throw new WrongBodyException("measurement:id && station:id && measurementType:id");
        return repository.save(measurement);
    }

}
