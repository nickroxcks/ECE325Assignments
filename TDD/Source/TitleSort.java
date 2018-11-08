import java.util.Comparator;

public class TitleSort implements Comparator<Song> {

	@Override
	public int compare(Song s1, Song s2) {
		// compareTo auto sorts strings alpabetically
		
		return s1.getTitle().compareTo(s2.getTitle());
	}

}
