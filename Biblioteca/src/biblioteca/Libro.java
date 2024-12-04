package biblioteca;

public class Libro 
{
	private String titolo;
	private String autore;
	private int annoPublicazione;
	private int nDisp;
	private int nPrest;
	
	public Libro() {
		super();
	}

	public Libro(String titolo, String autore, int annoPublicazione, int nDisp) {
		super();
		this.titolo = titolo;
		this.autore = autore;
		this.annoPublicazione = annoPublicazione;
		this.nDisp = nDisp;
	}

	public Libro(String titolo, String autore, int annoPublicazione, int nDisp, int nPrest) {
		super();
		this.titolo = titolo;
		this.autore = autore;
		this.annoPublicazione = annoPublicazione;
		this.nDisp = nDisp;
		this.nPrest = nPrest;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public int getAnnoPublicazione() {
		return annoPublicazione;
	}

	public void setAnnoPublicazione(int annoPublicazione) {
		this.annoPublicazione = annoPublicazione;
	}

	public int getnDisp() {
		return nDisp;
	}

	public void setnDisp(int nDisp) {
		this.nDisp = nDisp;
	}

	public int getnPrest() {
		return nPrest;
	}

	public void setnPrest(int nPrest) {
		this.nPrest = nPrest;
	}

	@Override
	public String toString() {
		return "titolo: " + titolo + ", | autore: " + autore + ", | annoPublicazione: " + annoPublicazione
				+ ", | nDisp: " + nDisp + ", | nPrest: " + nPrest + "]";
	}

	
	
	
	
	
	
	

}
