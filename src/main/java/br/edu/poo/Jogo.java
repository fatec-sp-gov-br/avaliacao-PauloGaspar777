package br.edu.poo;

import java.util.Scanner;

public class jogo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		personagem heroi = null;
		personagem inimigo1 = new personagem("Geringonça", 50, 5, 7, false);
		
		Pocao pocaoGrande = new Pocao("Poção grande", 15);
		
		System.out.println("!!! Ajude a salvar o reino de Arcádia !!!");
		System.out.println("Escolha seu personagem: ");
		System.out.println("1. Geremias");
		System.out.println("2. Asdemona");
		System.out.println("3. Cadelo");
		
		int resp = sc.nextInt();
		
		switch(resp) {
		case 1: heroi = new personagem("Geremias", 50, 5, 5, false);
		break;
		
		case 2: heroi = new personagem("Asdemona", 35, 20, 9, false);
		break;
		
		case 3: heroi = new personagem("Cadelo", 80, 40, 12, false);
		break;
		
		default: System.out.println("Opção inválida");
		}
		
		System.out.println("=== Iniciando combate ===");
		
		System.out.println(inimigo1.getNome() + ": vida = "+ inimigo1.getVida());
		
		System.out.println(heroi.getNome() + ": vida = "+ heroi.getVida());
		
		int turno = 1;
		
		do {
			
			System.out.println("//////////////////");
			System.out.println("! Seu Turno !");
			System.out.println("Sua ação: ");
			System.out.println("1. Atacar ");
			System.out.println("2. Usar poção");
			
			int respTurn = sc.nextInt();
			if(respTurn == 1) {
				heroi.atacar(inimigo1);
			}
			else if(respTurn == 2) {
				heroi.usarPocao(pocaoGrande);
			}
			inimigo1.estaVivo();
			turno++;
			
			System.out.println("//////////////////");
			System.out.println("! Turno do oponente !");
			
			if(turno == 6) {
				inimigo1.usarPocao(pocaoGrande);
			}
			else {
				inimigo1.atacar(heroi);
			}
			heroi.estaVivo();
			turno++;
			
			
		} while(heroi.estaVivo() == true && inimigo1.estaVivo() == true);
		
		if(heroi.estaVivo() == true) {
			System.out.println("!!! VITÓRIA !!!");
			System.out.println("O mundo de Arcádia está a salvo :)");
		}
		else {
			System.out.println("!!! DERROTA !!!");
			System.out.println("O mundo de Arcádia sucumbiu às forças do mal :( ");
		}

		sc.close();
	}

}
