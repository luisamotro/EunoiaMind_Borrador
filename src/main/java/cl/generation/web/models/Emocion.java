package cl.generation.web.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity 
@Table(name="emociones")
public class Emocion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nombreEmocion;
	@NotNull
	private String descripcion;
	@NotNull
	private String pregunta;
	@NotNull
	private int tipo;
	
	
	public Emocion() {
		super();
	}


	public Emocion(Long id, @NotNull String nombreEmocion, @NotNull String descripcion, @NotNull String pregunta,
			@NotNull int tipo) {
		super();
		this.id = id;
		this.nombreEmocion = nombreEmocion;
		this.descripcion = descripcion;
		this.pregunta = pregunta;
		this.tipo = tipo;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombreEmocion() {
		return nombreEmocion;
	}


	public void setNombreEmocion(String nombreEmocion) {
		this.nombreEmocion = nombreEmocion;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getPregunta() {
		return pregunta;
	}


	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}


	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	
	
	
	
	

	
	
	
	
}
