package sistemaDeCaixa;

import java.math.BigDecimal;

import sistemaDeCaixa.SistemaDeCaixa.Cliente;

public class main {

	public static void main(String[] args) {
		
		SistemaDeCaixa sistema = new SistemaDeCaixa();

        sistema.adicionarCliente("12345678900", new Cliente("Humberto", "Rua A", "(85)99885544", "humberto@gmail.com", BigDecimal.valueOf(1)));
        sistema.adicionarCliente("98765432100", new Cliente("Isabel", "Rua B", "(85)99885544", "isabel@gmail.com", BigDecimal.valueOf(1)));

        Cliente cliente = sistema.buscarCliente("12345678900");

        if (cliente != null) {
            System.out.println("Cliente encontrado: " + "\n\n" + cliente.getId() + " | " + cliente.getNome() +  " | "  + cliente.getTelefone() + " | " + cliente.getEmail()  );
        } else {
            System.out.println("Cliente não encontrado.");
        }

	}

}
