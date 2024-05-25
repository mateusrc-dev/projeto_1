package dao;

import java.util.Collection;

import domain.Cliente;

public interface IClienteDAO {
	public Boolean cadastrar(Cliente cliente);
	public Boolean excluir(Long cpf);
        public void excluirTodos();
	public Boolean alterar(Cliente cliente);
	public Cliente consultar(Long cpf);
	public Collection<Cliente> buscarTodos();
}
