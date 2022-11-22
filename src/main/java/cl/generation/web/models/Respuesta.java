package cl.generation.web.models;

import java.util.Date;
import java.util.List;

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
@Table(name = "respuestas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Respuesta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name ="usuario_id")
	private Usuario usuario;
	
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name ="emocion_id")
	private Emocion emocion;
	

	@NotNull
	private String respuesta;
	@NotNull
	private String texto;

	@Column(updatable = false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;

	public Respuesta() {
		super();
	}

	public Respuesta(Long id, @NotNull String respuesta, @NotNull String texto, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.respuesta = respuesta;
		this.texto = texto;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRespuesta() {
		return respuesta;
	}

	/*
	 * @Transient private int usuarioId;
	 */

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

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
