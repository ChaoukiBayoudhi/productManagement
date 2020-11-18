package tn.example.productExample;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Command {
    public enum CommandType{Traited, Waiting,Cancelled, NotFinishedYet}
    @EmbeddedId
    private CommandId id;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private CommandType state;
    @ManyToOne(fetch=FetchType.LAZY)
    @MapsId("idProduct")
    private Product prod;
    @ManyToOne
    @MapsId("idCustomer")
    private Customer custm;

}
