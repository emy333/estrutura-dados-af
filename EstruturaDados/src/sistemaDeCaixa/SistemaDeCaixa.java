package sistemaDeCaixa;
import java.math.BigDecimal;
import java.util.HashMap;

public class SistemaDeCaixa {
    private HashMap<String, Cliente> clientes;

    public SistemaDeCaixa() {
        clientes = new HashMap<>();
    }

    public void adicionarCliente(String cpf, Cliente cliente) {
        clientes.put(cpf, cliente);
    }

    public Cliente buscarCliente(String cpf) {
        return clientes.get(cpf);
    }


    static class Cliente {
        private String nome;
        private String endereco;
        private String telefone;
        private String email;
        private BigDecimal id;
        
        public Cliente(String nome, String endereco, String telefone, String email, BigDecimal id) {
            this.nome = nome;
            this.endereco = endereco;
            this.telefone = telefone;
            this.email = email;
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getEndereco() {
            return endereco;
        }

        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }

        public String getTelefone() {
            return telefone;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }
        
        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.telefone = email;
        }
        
        public BigDecimal getId() {
            return id;
        }

        public void setId(BigDecimal id) {
            this.id = id;
        }
        
      
    }
    
    
}
