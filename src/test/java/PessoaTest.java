import org.example.DAO.PessoaDAO;
import org.example.Entity.Email;
import org.example.Entity.Pessoa;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PessoaTest {

    @Test
    public void deveRetornarErroParaNomeComUmaParte() {
        Pessoa pessoa = new Pessoa(1, "Vitor", 25, List.of(new Email(1, "joao@example.com")));
        PessoaDAO pessoaDAO = new PessoaDAO();
        List<String> erros = pessoaDAO.isValidToInclude(pessoa);
        assertEquals(List.of("Nome deve ser composto por pelo menos duas partes"), erros);
    }

    @Test
    public void deveRetornarErroParaNomeComNumeros() {
        Pessoa pessoa = new Pessoa(2, "Vitor123 Lima", 30, List.of(new Email(1, "joao@example.com")));
        PessoaDAO pessoaDAO = new PessoaDAO();
        List<String> erros = pessoaDAO.isValidToInclude(pessoa);
        assertEquals(List.of("Nome deve conter apenas letras"), erros);
    }

    @Test
    public void deveRetornarErroParaIdadeForaDoIntervalo() {
        Pessoa pessoa = new Pessoa(3, "Vitor Lima", 0, List.of(new Email(1, "joao@example.com")));
        PessoaDAO pessoaDAO = new PessoaDAO();
        List<String> erros = pessoaDAO.isValidToInclude(pessoa);

        // Verificar se o único erro é o da idade
        assertEquals(List.of("Idade deve estar entre 1 e 200"), erros);
    }

    @Test
    public void deveRetornarErroParaPessoaSemEmail() {
        Pessoa pessoa = new Pessoa(4, "Vitor Lima", 25, List.of());
        PessoaDAO pessoaDAO = new PessoaDAO();
        List<String> erros = pessoaDAO.isValidToInclude(pessoa);
        assertEquals(List.of("Pessoa deve ter pelo menos um email associado"), erros);
    }

    @Test
    public void deveRetornarErroParaEmailInvalido() {
        Pessoa pessoa = new Pessoa(5, "Vitor Lima", 25, List.of(new Email(1, "joao@exemplo")));
        PessoaDAO pessoaDAO = new PessoaDAO();
        List<String> erros = pessoaDAO.isValidToInclude(pessoa);
        assertEquals(List.of("Email inválido: joao@exemplo"), erros);
    }

    @Test
    public void devePassarComPessoaValida() {
        Pessoa pessoa = new Pessoa(6, "Vitor Lima", 25, List.of(new Email(1, "joao@example.com")));
        PessoaDAO pessoaDAO = new PessoaDAO();
        List<String> erros = pessoaDAO.isValidToInclude(pessoa);
        assertEquals(List.of(), erros);
    }
}