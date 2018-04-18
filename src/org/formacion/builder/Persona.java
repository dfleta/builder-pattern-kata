package org.formacion.builder;

public class Persona {

	private String nombre;
	private int edad;
	private String municipio;
	private String colegio;
	private String lugarTrabajo;
	
	private Persona() {
	}	

	@Override
	public String toString() {
		return nombre + " " + edad + " " + municipio + " " + colegio + " " + lugarTrabajo;
	}
	
	/**
	 * Static member class is not an Inner class:
	 * is a nested top-level class
	 * Cap. 2 Inner clases, pag 51 libro Beginnnig Java 8 languaje features
	 */

	public static class Builder {

		private Persona persona;
		
		public Builder(String nombre) {
			persona = new Persona();
			persona.nombre = nombre;
		}
		
		public Builder setMunicipio (String municipio) {
			persona.municipio = municipio;
			return this;
		}
		
		public BuilderMayor setMayor(int edad) {
			if (edad < 18) throw new IllegalArgumentException("es menor de edad " + edad);
			persona.edad = edad;
			persona.colegio = null;
			return new BuilderMayor(persona);
		}
		
		public Builder setMenor(int edad, String colegio) {
			if (edad >= 18) throw new IllegalArgumentException("es mayor de edad " + edad);
			persona.edad = edad;
			persona.colegio = colegio;
			persona.lugarTrabajo = null;
			return this;
		}

		public Persona build() {
			return persona;
		}

	}

	public static class BuilderMayor {

		private Persona personaAdulta;

		public BuilderMayor(Persona persona) {
			personaAdulta = persona;
		}

		public BuilderMayor setLugarTrabajo(String lugarTrabajo) {
			personaAdulta.lugarTrabajo = lugarTrabajo;
			return this;
		}

		public Persona build() {
			return personaAdulta;
		}
	}
	
}
