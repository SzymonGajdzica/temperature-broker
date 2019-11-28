package pl.polsl.temperature.station;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "station")
@ToString
@Data
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "gateway_id", nullable = false)
    private Long gatewayId;

    @Column(name = "secret_id", nullable = false)
    private UUID secretId;


}
