package cl.generation.web.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "respuestas")
public class Respuesta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//El "porque" de la respuesta, o "desahogo de la persona"
	@NotNull
	private String texto;
	
	// las respuestas pueden tener solo 1 usuario - por eso una variable solamente
	@JsonIgnore
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name ="usuario_id")
	private Usuario usuario;
	
	// esta es la "respuesta" del usuario
	// las emociones pueden tener solo 1 usuario - por eso una variable solamente 
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name ="emocion_id")
	private Emocion emocion;
	
	// fecha de la respuesta
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	
	// fecha de modificacion respuesta
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

}
