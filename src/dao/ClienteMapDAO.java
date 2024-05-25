package dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import domain.Cliente;

public class ClienteMapDAO implements IClienteDAO {
	
	private Map<Long, Cliente> map;
	
	public ClienteMapDAO() {
		this.map = new HashMap<>();
	}

	@Override
	public Boolean cadastrar(Cliente cliente) {
		if (this.map.containsKey(cliente.getCpf())) {
			return false;
		}
		this.map.put(cliente.getCpf(), cliente);
		return true;
	}

	@Override
	public Boolean excluir(Long cpf) {
		Cliente clienteCadastrado = this.map.get(cpf);
		
		if (clienteCadastrado != null) {
			this.map.remove(clienteCadastrado.getCpf(), clienteCadastrado);
			
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Boolean alterar(Cliente cliente) {
		Cliente clienteCadastrado = this.map.get(cliente.getCpf());
		
		if (clienteCadastrado != null) {
			clienteCadastrado.setNome(cliente.getNome());
			clienteCadastrado.setCidade(cliente.getCidade());
			clienteCadastrado.setEnd(cliente.getEnd());
			clienteCadastrado.setEstado(cliente.getEstado());
			clienteCadastrado.setNumero(cliente.getNumero());
			clienteCadastrado.setTel(cliente.getTel());
			
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public Cliente consultar(Long cpf) {
		return this.map.get(cpf);
	}

	@Override
	public Collection<Cliente> buscarTodos() {
		return this.map.values();
	}

        @Override
        public void excluirTodos() {
            this.map.clear();
        }

}
