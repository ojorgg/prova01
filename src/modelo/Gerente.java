package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gerente")
@DiscriminatorValue(value = "G")
public class Gerente extends Funcionario implements Serializable {

    @Column(name = "porcentagem")
    private double porcentagem;

    public Gerente() {
    }

    public Gerente(double porcentagem) {
        this.porcentagem = porcentagem;
    }

    public Gerente(String nome, String login, double salario, double porcentagem) {
        super(nome, login, salario);
        this.porcentagem = porcentagem;
    }

//    O salário dos funcionários com cargo de gerente é calculado com base em um percentual sobre o valor total de vendas realizadas
//    . O percentual e o valor de vendas pode ser diferente para cada gerente.
    public double getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(double porcentagem) {
        this.porcentagem = porcentagem;
    }
}
