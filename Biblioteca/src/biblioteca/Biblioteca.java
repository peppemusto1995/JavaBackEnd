package biblioteca;

import java.util.ArrayList;

public class Biblioteca 
{
	private ArrayList<Libro> scafale;

	public Biblioteca() {
		super();
		scafale = new ArrayList<Libro>();
	}

	public Biblioteca(ArrayList<Libro> scafale) {
		super();
		this.scafale = scafale;
	}

	public ArrayList<Libro> getScafale() {
		return scafale;
	}

	public void setScafale(ArrayList<Libro> scafale) {
		this.scafale = scafale;
	}

	
	public String stampaLibriDisponibili()
	{
		
		String res = "";
		
		if(scafale.isEmpty())
			return "Nessun libro nella biblioteca";
		
		for( int i = 0; i< scafale.size(); i++)
			if(scafale.get(i).getnDisp()>0)
				res += i+") "+ scafale.get(i).toString()+"\n";
		
		return res;
	}
	
	

}
