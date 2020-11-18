package tn.example.productExample;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private double price;
    @NonNull
    private int stock;
    @OneToMany(mappedBy = "prod",cascade=CascadeType.ALL)
    private Set<Command> commandes=new HashSet<>();
}