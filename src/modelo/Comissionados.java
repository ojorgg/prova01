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

    public Comissionados() {
    }

//    O salário dos funcionários com cargo de gerente é calculado com base em um percentual sobre o valor total de vendas realizadas
//    . O percentual e o valor de vendas pode ser diferente para cada gerente.
    public Comissionados(double comissao) {
        this.comissao = comissao;
    }

    public Comissionados(String nome, String login, double salario, double comissao) {
        super(nome, login, salario);
        this.comissao = comissao;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

}
