package cl.generation.web.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "emociones")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
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
	
	// 1 emocion puede estar en muchas respuestas - por eso una lista de respuestas
	@NotNull
	@JsonIgnore
	@OneToMany(mappedBy="emocion",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Respuesta> respuestas;

}
