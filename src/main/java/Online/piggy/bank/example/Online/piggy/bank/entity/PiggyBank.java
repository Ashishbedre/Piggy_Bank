package Online.piggy.bank.example.Online.piggy.bank.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Setter
@Getter
@NoArgsConstructor
public class PiggyBank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double balance;
    private boolean isBroken;

}

