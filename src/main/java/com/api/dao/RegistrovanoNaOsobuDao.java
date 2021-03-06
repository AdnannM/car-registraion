package com.api.dao;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "registrovanoNaOsobu")
public class RegistrovanoNaOsobuDao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "ime",
			unique = true)
	@NotBlank(message = "Name can't be empty")
	@Size(min=2, max=30)
	private String ime;
	
	@NotBlank(message = "LastName can't be empty")
	@Column(name = "prezime")
	private String prezime;
	
	@Column(name = "jmbg",
			unique = true)
	@Size(min = 14, max = 14)
	private long jmbg;
	
	@Column(name = "datumRodjenja")
	@Min(value = 18,
		 message = "Age must be greater or equel than 18.")
	private Date datumRodjenja;
	
	@Column(name = "grad")
	@NotBlank(message = "City can't be empty")
	private String grad;
	
	@OneToOne(mappedBy = "registrovano", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private VoziloDao voziloDao;
	
	public RegistrovanoNaOsobuDao() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public long getJmbg() {
		return jmbg;
	}

	public void setJmbg(long jmbg) {
		this.jmbg = jmbg;
	}

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public VoziloDao getVoziloDao() {
		return voziloDao;
	}

	public void setVoziloDao(VoziloDao voziloDao) {
		this.voziloDao = voziloDao;
	}

	@Override
	public String toString() {
		return "RegistrovanoNaOsobuDao [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg
				+ ", datumRodjenja=" + datumRodjenja + ", grad=" + grad + ", voziloDao=" + voziloDao + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(datumRodjenja, grad, id, ime, jmbg, prezime, voziloDao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistrovanoNaOsobuDao other = (RegistrovanoNaOsobuDao) obj;
		return Objects.equals(datumRodjenja, other.datumRodjenja) && Objects.equals(grad, other.grad)
				&& Objects.equals(id, other.id) && Objects.equals(ime, other.ime) && jmbg == other.jmbg
				&& Objects.equals(prezime, other.prezime) && Objects.equals(voziloDao, other.voziloDao);
	}
}