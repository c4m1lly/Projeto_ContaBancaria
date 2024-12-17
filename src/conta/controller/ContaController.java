package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository {

	private ArrayList<Conta> listagem = new ArrayList<Conta>();
	int numero = 0;

	public int gerarNumero() {
		return ++numero;
	}

	public Conta buscarNaCollection(int numero) {
		for (var conta : listagem) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}
		return null;
	}

	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);
		if (conta != null) {
			conta.visualizar();

		} else {
			System.out.println("\nA conta número:" + numero + "Não foi encontrado!");

		}

	}

	@Override
	public void listarTodas() {
		for (Conta conta : listagem) {
			conta.visualizar();
		}
	}

	@Override
	public void cadastrar(Conta conta) {
		listagem.add(conta);
		System.out.println("\nA conta número:" + conta.getNumero() + " Foi criada com sucesso! ");
	}

	@Override
	public void atualizar(Conta conta) {
		var buscaConta = buscarNaCollection(conta.getNumero());
		if (buscaConta != null) {
			listagem.set(listagem.indexOf(buscaConta), conta);
			System.out.println("\nA Conta numero: " + conta.getNumero() + "Foi atualizada com sucesso");
		} else
			System.out.println("\nA Conta numero: " + conta.getNumero() + "Não foi encontrada.");

	}

	@Override
	public void deletar(int numero) {

	}

	@Override
	public void sacar(int numero, float valor) {

	}

	@Override
	public void depositar(int numero, float valor) {

	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {

	}

}