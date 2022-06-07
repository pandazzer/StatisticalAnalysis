package team.yasp.StatisticalAnalysis;
import com.opencsv.bean.CsvBindByPosition;

public class TopHits {
    @CsvBindByPosition(position = 0)
    private String artist;
    @CsvBindByPosition(position = 1)
    private String song;
    @CsvBindByPosition(position = 2)
    private String duration_ms;
    @CsvBindByPosition(position = 3)
    private String explicit;
    @CsvBindByPosition(position = 4)
    private String year;
    @CsvBindByPosition(position = 5)
    private String popularity;
    @CsvBindByPosition(position = 6)
    private String danceability;
    @CsvBindByPosition(position = 7)
    private String energy;
    @CsvBindByPosition(position = 8)
    private String key;
    @CsvBindByPosition(position = 9)
    private String loudness;
    @CsvBindByPosition(position = 10)
    private String mode;
    @CsvBindByPosition(position = 11)
    private String speechiness;
    @CsvBindByPosition(position = 12)
    private String acousticness;
    @CsvBindByPosition(position = 13)
    private String instrumentalness;
    @CsvBindByPosition(position = 14)
    private String liveness;
    @CsvBindByPosition(position = 15)
    private String valence;
    @CsvBindByPosition(position = 16)
    private String tempo;
    @CsvBindByPosition(position = 17)
    private String genre;

    public String getArtist() {
        return artist;
    }

    public String getSong() {
        return song;
    }

    public String getDuration_ms() {
        return duration_ms;
    }

    public String getExplicit() {
        return explicit;
    }

    public String getYear() {
        return year;
    }

    public String getPopularity() {
        return popularity;
    }

    public String getDanceability() {
        return danceability;
    }

    public String getEnergy() {
        return energy;
    }

    public String getKey() {
        return key;
    }

    public String getLoudness() {
        return loudness;
    }

    public String getMode() {
        return mode;
    }

    public String getSpeechiness() {
        return speechiness;
    }

    public String getAcousticness() {
        return acousticness;
    }

    public String getInstrumentalness() {
        return instrumentalness;
    }

    public String getLiveness() {
        return liveness;
    }

    public String getValence() {
        return valence;
    }

    public String getTempo() {
        return tempo;
    }

    public String getGenre() {
        return genre;
    }
}
