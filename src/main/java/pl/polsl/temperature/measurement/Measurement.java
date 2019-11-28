package pl.polsl.temperature.measurement;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "measurement")
@ToString
@Data
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date", nullable = false)
    @Setter(AccessLevel.NONE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date date = new Date();

    @Column(name = "value", nullable = false)
    private Double value;

    @Column(name = "measurement_type_id", nullable = false)
    private Long measurementTypeId;

    @Column(name = "station_id", nullable = false)
    private Long stationId;

}
