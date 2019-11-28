package pl.polsl.temperature.measurement;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.temperature.station.Station;
import pl.polsl.temperature.station.StationRepository;

@RestController
@AllArgsConstructor
public class MeasurementController {

    private final StationRepository stationRepository;
    private final MeasurementRepository measurementRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Measurement addMeasurement(@RequestBody MeasurementPost measurementPost) throws Exception {
        Station station = stationRepository.findById(measurementPost.getStationId()).orElseThrow(Exception::new);
        if(!station.getSecretId().equals(measurementPost.getSecretId()))
            throw new Exception();
        Measurement measurement = new Measurement();
        measurement.setMeasurementTypeId(measurementPost.getMeasurementTypeId());
        measurement.setStationId(measurementPost.getStationId());
        measurement.setValue(measurementPost.getValue());
        return measurementRepository.save(measurement);
    }

}
