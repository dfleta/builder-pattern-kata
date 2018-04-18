package org.formacion.builder;

public class Main {

	/**
	 * Aqui otra version del patron
	 * https://medium.com/@modestofiguereo/design-patterns-2-the-builder-pattern-and-the-telescoping-constructor-anti-pattern-60a33de7522e
	 */

	public static void main (String[] args) {

		// este codigo debe compilar
		
		Persona madre = new Persona.Builder("Maria")
			.setMunicipio("Selva")
			.setMayor(37)
			.setLugarTrabajo("Google")
			.build();

		System.out.println(madre.toString());

		
		Persona hijo = new Persona.Builder("Pedro")
			.setMenor(4)
			.setColegio("Colegio de Selva")
			.build();
		
		System.out.println(hijo.toString());

		
		// esta codigo NO debe compilar
		/*
		Persona mal = new Persona.Builder("Luisa")
				    .setMayor(20)
				    .setColegio("Colegio de Villa Arriba")
				    .build();
        */
	}
}
