package edu.model;

public class Marca {
	private String Nome_Marca;
	
	public Marca(String Marca) {
		setNome_Marca(Marca);
	}
	
	public String getNome_Marca() {
		return Nome_Marca;
	}
	public void setNome_Marca(String nome_Marca) {
		Nome_Marca = nome_Marca;
	}
}