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
	 * "Static member class is not an Inner class:
	 * is a nested top-level class"
	 * Cap. 2 Inner clases, pag 51 libro Beginnnig Java 8 languaje features
	 * Esto significa que puede ser utilizada fuera de Persona a traves de su
	 * nombre "Builder" sin el nombre qualificado Persona.Builder, tan solo importando
	 * su tipo: 
	 * import org.formacion.builder.Persona.Builder;
	 * Si no fuese estatica, esto no seria posible, ya que habria que crear
	 * una instancia de la clase Persona antes de crear una instancia de la
	 * clase Builder
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
		
		public BuilderMenor setMenor(int edad) {
			if (edad >= 18) throw new IllegalArgumentException("es mayor de edad " + edad);
			persona.edad = edad;
			persona.lugarTrabajo = null;

			/**
			 * BuilderMenor es inner class (no es static)
			 * Para crear una instancia de BuilderMenor
			 * antes ha de crearse una instancia de la clase Persona
			 * que la contiene
			 */

			return persona.new BuilderMenor(persona);
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

	/**
	 * Ahora hacemos una inner class con BuilderMenor
	 * (no usamos static)
	 * Esto implica que para crear una instancia de BuilderMenor
	 * antes ha de crearse una instancia de la clase Persona
	 * que la contiene
	 */

	public class BuilderMenor {

		private Persona personaMenor;

		public BuilderMenor(Persona persona) {
			personaMenor = persona;
		}

		public BuilderMenor setColegio(String colegio) {
			personaMenor.colegio = colegio;
			return this;
		}

		public Persona build() {
			return personaMenor;
		}

	}
	
}
