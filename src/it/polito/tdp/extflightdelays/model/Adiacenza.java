package it.polito.tdp.extflightdelays.model;

public class Adiacenza implements Comparable<Adiacenza>{
	
	private String stato1;
	private String stato2;
	private int peso;
	
	public Adiacenza(String stato1, String stato2, int peso) {
		super();
		this.stato1 = stato1;
		this.stato2 = stato2;
		this.peso = peso;
	}

	public String getStato1() {
		return stato1;
	}

	public void setStato1(String stato1) {
		this.stato1 = stato1;
	}

	public String getStato2() {
		return stato2;
	}

	public void setStato2(String stato2) {
		this.stato2 = stato2;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	@Override
	public int compareTo(Adiacenza other) {
		return other.getPeso() - this.getPeso();
	}
	
}
