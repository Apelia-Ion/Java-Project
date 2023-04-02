package domain;

public class CD {
    private int id;
    private String title;
    private Author artist;
    private int year;
    private String label;

    public CD(int id, String title, Author artist, int year, String label) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getArtist() {
        return artist;
    }

    public int getYear() {
        return year;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "CD{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", artist=" + artist +
                ", year=" + year +
                ", label='" + label + '\'' +
                '}';
    }
}
