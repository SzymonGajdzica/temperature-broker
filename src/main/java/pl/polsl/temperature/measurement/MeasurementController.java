package pl.polsl.temperature.measurement;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.temperature.base.Message;
import pl.polsl.temperature.station.Station;
import pl.polsl.temperature.station.StationRepository;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class MeasurementController {

    private final StationRepository stationRepository;
    private final MeasurementRepository measurementRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Message addMeasurements(@RequestBody List<MeasurementPost> measurementsPost) {
        int successCounter = 0;
        for(MeasurementPost measurementPost: measurementsPost){
            Optional<Station> station = stationRepository.findById(measurementPost.getStationId());
            if(station.isPresent() && station.get().getSecretId().equals(measurementPost.getSecretId())){
                Measurement measurement = new Measurement();
                measurement.setMeasurementTypeId(measurementPost.getMeasurementTypeId());
                measurement.setStationId(measurementPost.getStationId());
                measurement.setValue(measurementPost.getValue());
                try {
                    measurementRepository.save(measurement);
                    successCounter++;
                }catch (Exception ignore){

                }
            }
        }
        return new Message("Post results", successCounter + " succeeded and " + (measurementsPost.size() - successCounter) + " failed");
    }

}
