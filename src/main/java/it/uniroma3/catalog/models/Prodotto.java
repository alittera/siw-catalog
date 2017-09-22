package it.uniroma3.catalog.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Min;

import java.util.Date;
import java.util.List;


@Entity
@Table(name="Prodotto")
public class Prodotto {
	
	
	//siano di interesse il nome, il prezzo, la descrizione e i fornitori.
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

    @NotBlank(message = "è richiesta una stringa non nulla e non vuota")
    @Column(nullable=false)
	private String nome;

	@ManyToMany(mappedBy = "prodotti")
	private List<Fornitore> fornitori;

    @Min(value = 0, message = "Inserire un valore positivo")
	private int prezzo;

	private String descrizione;

	private String imageUri;

	public Prodotto(){}

	public Prodotto(String name, List <Fornitore> fornitori, String descr, int prezzo)
	{
		this.nome=name;
		this.fornitori=fornitori;
		this.prezzo=prezzo;
		this.descrizione = descr;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Fornitore> getFornitori() {
		return fornitori;
	}

	public void setFornitori(List<Fornitore> nfornitori) {
		this.fornitori = nfornitori;
	}

	public void addFornitore(Fornitore fornitore) {
		this.fornitori.add(fornitore);
	}

    public int getPrezzo() {return prezzo;}

    public void setPrezzo(int prezzo) { this.prezzo=prezzo;}

	public String getImageUri() {return imageUri;}

	public void setImageUri(String imageUri) {this.imageUri = imageUri;}

	public String getDescrizione() {return descrizione;}

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }


}
