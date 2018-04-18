package org.formacion.builder;

import org.formacion.builder.Persona.Builder;

public class Main {

	/**
	 * Aqui otra version del patron
	 * https://medium.com/@modestofiguereo/design-patterns-2-the-builder-pattern-and-the-telescoping-constructor-anti-pattern-60a33de7522e
	 */

	/**
	 * Este ejercicio es también un kata sobre clases inner y local
	 * Ver Cap. 2 Inner clases, pag 51 libro Beginnnig Java 8 languaje features
	 */
	  
	public static void main (String[] args) {

		// este codigo debe compilar
		
		Persona madre = new Persona.Builder("Maria")
			.setMunicipio("Selva")
			.setMayor(37)
			.setLugarTrabajo("Google")
			.build();

		System.out.println(madre.toString());

		/**
		 * Builder es Nested top-level class:
		 * podemos instanciarla por su nombre
		 * sin Persona.Builder
		 */

		Persona hijo = new Builder("Pedro")
			.setMenor(4)
			.setColegio("Colegio de Selva")
			.build();
		
		System.out.println(hijo.toString());
		
		// este codigo NO debe compilar
		/*
		Persona mal = new Persona.Builder("Luisa")
				    .setMayor(20)
				    .setColegio("Colegio de Villa Arriba")
				    .build();
		*/
	}
}
