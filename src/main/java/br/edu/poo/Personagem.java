package br.edu.poo;


public class personagem {

	
	private String nome;
	private int vida;
	private int ataque;
	private int defesa;
	private int dano;
	private boolean pocaoUtilizada;
	
	
	
	public personagem(String nome, int vida, int ataque, int defesa, boolean pocaoUtilizada) {
		this.nome = nome;
		this.vida = vida;
		this.ataque = ataque;
		this.defesa = defesa;
		this.pocaoUtilizada = false;
	}
	
	public void atacar(personagem inimigo) {
		
		System.out.println(this.nome + " ataca " + inimigo.getNome());
		dano = this.ataque - inimigo.defesa;
		
		inimigo.receberDano(dano);
		System.out.println(inimigo.getNome() +": Vida = "+ inimigo.getVida());
		
		
	}
	
	public void receberDano(int dano) {
		
		if(dano < 1) {
			dano = 1;
		}
		this.vida -= dano;
		
		if(vida < 0) {
			vida = 0;
		}
	}
	
	public void usarPocao(Pocao pocao) {
		
		if(!pocaoUtilizada) {
			
			vida += pocao.getCura();
			pocaoUtilizada = true;
			
			System.out.println(this.nome + " utiliza " + pocao.getNome());
			System.out.println(this.nome + ": vida = " + this.vida);
			
		} else {
			System.out.println("Ação inválida. Poção já foi utilizda");
		}
		
		
	}
	
	public boolean estaVivo() {
		if(this.vida <= 0) {
			return false;
		}
		else {
			return true;
		}
			
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getVida() {
		return vida;
	}
	

}

