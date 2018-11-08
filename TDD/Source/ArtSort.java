import java.util.Comparator;

public class ArtSort implements Comparator<Song>{

	@Override
	public int compare(Song s1, Song s2) {
		// compareTo auto sorts strings alpabetically
		return s1.getArtist().compareTo(s2.getArtist());
	}

}
