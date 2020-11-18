package tn.example.productExample;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CommandId implements Serializable  {
    @Column(name ="product_id")
    private Long idProduct;
    @ Column(name ="custommer_id")
    private Long idCustomer;
}
