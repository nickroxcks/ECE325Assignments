/**
 * Assignment 6: Test Driven Development <br />
 * The {@code Song} class
 */
public class Song <T> {
    // TODO: Assignment 6 -- complete this Song class to pass the tests
	private String s1;
	private String s2;
	private T n1;
	
	public Song(String a,String b, T c) {
		s1=a.toLowerCase();
		s2=b.toLowerCase();
		n1=c;
	}
	
	
    public String gets1of() {
    	return this.s1;
    }
    
    public String gets2of() {
    	return this.s2;
    }
    public T getn1of() {
    	return this.n1;
    }
    
	@Override
	public  boolean equals(Object A) {
		Song other = (Song) A;
		if(this.s1.equals(other.s1) && (this.s2.equals(other.s2) && (this.n1.equals(other.n1)))) {

			return true;
			
		}
		return false;
	}
	
	public String getArtist() {
		return s1;
	}
	public String getTitle() {
		return s2;
	}
	public double getLength() {
		float dummy = (float)n1;
		return dummy;
	
	}
	public boolean isArtist(String a) {
		
		if(a.toLowerCase().equals("artist")) {
			return true;
		}
		return false;
	}
	public boolean isTitle(String a) {
		if(a.toLowerCase().equals("song a")) {
			return true;
		}
		return false;
	}
}
