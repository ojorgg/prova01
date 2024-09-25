package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gerente")
@DiscriminatorValue(value = "C")
public class Comissionados extends Funcionario implements Serializable {

    
    @Column(name = "comissao")
    private double comissao;

//    O salário dos funcionários com cargo de gerente é calculado com base em um percentual sobre o valor total de vendas realizadas
//    . O percentual e o valor de vendas pode ser diferente para cada gerente.
}
