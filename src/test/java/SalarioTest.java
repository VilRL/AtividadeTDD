import org.example.Enum.Cargo;
import org.example.Entity.Funcionario;
import org.example.Service.CalculadoraSalario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalarioTest {

    @Test
    public void calcularSalarioDesenvolvedorAbaixoDe3000() {
        Funcionario desenvolvedor = new Funcionario("João", "joao@example.com", 2500.0, Cargo.DESENVOLVEDOR);
        CalculadoraSalario calculadora = new CalculadoraSalario();
        double salarioLiquido = calculadora.calcularSalarioLiquido(desenvolvedor);
        assertEquals(2250.0, salarioLiquido);
    }

    @Test
    public void calcularSalarioDesenvolvedoroAcimaDe3000() {
        Funcionario desenvolvedor = new Funcionario("Maria", "maria@example.com", 4000.0, Cargo.DESENVOLVEDOR);
        CalculadoraSalario calculadora = new CalculadoraSalario();
        double salarioLiquido = calculadora.calcularSalarioLiquido(desenvolvedor);
        assertEquals(3200.0, salarioLiquido);
    }

    @Test
    public void calcularSalarioDBAAbaixoDe2000() {
        Funcionario dba = new Funcionario("Pedro", "pedro@example.com", 1500.0, Cargo.DBA);
        CalculadoraSalario calculadora = new CalculadoraSalario();
        double salarioLiquido = calculadora.calcularSalarioLiquido(dba);
        assertEquals(1275.0, salarioLiquido);
    }

    @Test
    public void calcularSalarioDBAComAcimaDe2000() {
        Funcionario dba = new Funcionario("Ana", "ana@example.com", 2500.0, Cargo.DBA);
        CalculadoraSalario calculadora = new CalculadoraSalario();
        double salarioLiquido = calculadora.calcularSalarioLiquido(dba);
        assertEquals(1875.0, salarioLiquido);
    }

    @Test
    public void calcularSalarioGerenteAbaixoDe5000() {
        Funcionario gerente = new Funcionario("Carlos", "carlos@example.com", 4500.0, Cargo.GERENTE);
        CalculadoraSalario calculadora = new CalculadoraSalario();
        double salarioLiquido = calculadora.calcularSalarioLiquido(gerente);
        assertEquals(3600.0, salarioLiquido);
    }

    @Test
    public void calcularSalarioGerenteAcimaDe5000() {
        Funcionario gerente = new Funcionario("Fernanda", "fernanda@example.com", 6000.0, Cargo.GERENTE);
        CalculadoraSalario calculadora = new CalculadoraSalario();
        double salarioLiquido = calculadora.calcularSalarioLiquido(gerente);
        assertEquals(4200.0, salarioLiquido);
    }

    @Test
    public void calcularSalarioTestadorAbaixoDe2000() {
        Funcionario testador = new Funcionario("Lucas", "lucas@example.com", 1800.0, Cargo.TESTADOR);
        CalculadoraSalario calculadora = new CalculadoraSalario();
        double salarioLiquido = calculadora.calcularSalarioLiquido(testador);
        assertEquals(1530.0, salarioLiquido);
    }

    @Test
    public void calcularSalarioTestadorAcimaDe2000() {
        Funcionario testador = new Funcionario("Roberta", "roberta@example.com", 2200.0, Cargo.TESTADOR);
        CalculadoraSalario calculadora = new CalculadoraSalario();
        double salarioLiquido = calculadora.calcularSalarioLiquido(testador);
        assertEquals(1650.0, salarioLiquido);
    }
}
