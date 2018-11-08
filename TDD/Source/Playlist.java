import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Assignment 6: Test Driven Development <br />
 * The {@code Playlist} class
 */
@SuppressWarnings("serial")//Nicholas SERRANO
public class Playlist<E extends Song > extends java.util.Vector<E>{// implements Comparator<Song> {
    java.util.Iterator<E> itr = this.iterator();       // Generic Iterator; Use it whenever you need it!
   
    private String plst;
    List<E> listplay = new ArrayList<>();
    public Playlist(String a){
    	plst = a;
    }
    
    public boolean addtoPlist(E a) {
    	
    	if(a == null) {
    		return false;
    	}
    	if(listplay.contains(a)) {
    		return false;
    	}
    	listplay.add(a);
    	return true;
    }

    public String getTitle() {
    	
    	return plst;
    }

    	@Override
    	public int size() {
    		
    		return listplay.size();
    	}
    	public boolean removeFromPlist(E a) {
    		
    		if(a == null) {
    			return false;
    		}
    		if(!listplay.contains(a)) {
    			return false;
    		}
    		listplay.remove(a);
    		return true;
    	}
    	
    	@Override
    	public boolean contains(Object a) {
    		
    		E inside = (E)a;
    		if(listplay.contains(inside)) {
    		return true;
    		}
    		return false;
    	}
    	public E getSong(int a) {
    		return listplay.get(a);
    	}
    	public boolean hasTitle(String a) {
    		if(plst == a) {
    		return true;
    		}
    	return false;
    	}
    	public boolean hasArtist(String artist) {
    		for (int i=0; i < listplay.size();i++) {
    			E dummy = listplay.get(i);
    			Song actualsong = (Song)dummy;
    			if(actualsong.getArtist().equals(artist.toLowerCase())) {
    				return true;
    			}
    		}
    		return false;
    	}
    	public int numberOfSongs() {
    		return listplay.size();
    	}
    	public int numberOfArtists() {
    		 List<String> templist = new ArrayList<>();
    		for (int i=0; i < listplay.size();i++) {
    			E dummy = listplay.get(i);
    			Song actualsong = (Song)dummy;
    			String Artist = actualsong.getArtist();
    			if(templist.contains(Artist)) {
    				continue;
    			}
    			templist.add(actualsong.getArtist());
    		}
    		return templist.size();
    	}
    	public int numberOfTitles() {
    		 List<String> templist = new ArrayList<>();
     		for (int i=0; i < listplay.size();i++) {
     			E dummy = listplay.get(i);
     			Song actualsong = (Song)dummy;
     			String Title = actualsong.getTitle();
     			if(templist.contains(Title)) {
     				continue;
     			}
     			templist.add(actualsong.getTitle());
     		}
     		return templist.size();
    	}
    	public double playTime() {
    		double totaltime = 0;
    		for (int i=0; i < listplay.size();i++) {
     			E dummy = listplay.get(i);
     			Song actualsong = (Song)dummy;
     		Object test = actualsong.getn1of();	//this is done with reference to songs generics
     		double time = (double)test;
     		totaltime = time + totaltime;
    		}
    		return totaltime;
    	}
    	public int findSong(Song a) {
    		if(listplay.contains(a)) {
    			return listplay.indexOf(a);
    		}
    		
    		return -1;
    	}
    	public void sortArtist() {
    		
    		//created customized sort method for artist. see ArtSort.java
    	Collections.sort(listplay, new ArtSort());
    		
    	}
    	
    	public void sortTitle() {
    		//created customized sort method for titles. see TitleSort.java
    		Collections.sort(listplay, new TitleSort());
    	}
    	 
}
