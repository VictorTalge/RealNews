package model;

import java.io.Serializable;

public class Comentario implements Serializable {
    private static final long serialVersionUID = 1L;
	private int id;
	private String nome;
	private String texto;
	private int fk_id;

	public Comentario() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getFkId() {
		return fk_id;
	}

	public void setFkId(int fk_id) {
		this.fk_id = fk_id;
	}

	@Override
	public String toString() {
		return "Comentario [id=" + id + ", nome=" + nome + ", texto=" + texto
				+ ", fk_id=" + fk_id + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comentario other = (Comentario) obj;
		if (fk_id == 0) {
			if (other.fk_id != 0)
				return false;
		} else if (fk_id != (other.fk_id))
			return false;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
