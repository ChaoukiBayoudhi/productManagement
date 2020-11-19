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
    public enum CommandState{Traited, Waiting,Cancelled, NotFinishedYet}
    @EmbeddedId
    private CommandId id; //id1=(P1,C1)   id2=(P1,C2) id3=(P2,C1)
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private CommandState state;
    private int quantity;
    @ManyToOne
    @MapsId("idCustomer")
    private Customer cust;
    @ManyToOne
    @MapsId("idProduct")
    private Product prod;
}
