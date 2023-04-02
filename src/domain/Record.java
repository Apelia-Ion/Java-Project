package domain;

public class Record {
    private int id;
    private String title;
    private Author artist;
    private int year;
    private String label;

    public Record(int id, String title, Author artist, int year, String label) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getArtist() {
        return artist;
    }

    public void setArtist(Author artist) {
        this.artist = artist;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", artist=" + artist +
                ", year=" + year +
                ", label='" + label + '\'' +
                '}';
    }
}
