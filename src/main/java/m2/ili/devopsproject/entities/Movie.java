package m2.ili.devopsproject.entities;


public class Movie {

	private long id;

    private int rank;

	private int rating;

	private String title;

	private String year;

	private long nbOfReviews;


    public Movie() {
    }

    public Movie(int rank, int rating, String title, String year, long nbOfReviews) {
        this.rank = rank;
        this.rating = rating;
        this.title = title;
        this.year = year;
        this.nbOfReviews = nbOfReviews;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public long getNbOfReviews() {
        return nbOfReviews;
    }

    public void setNbOfReviews(long nbOfReviews) {
        this.nbOfReviews = nbOfReviews;
    }
}
