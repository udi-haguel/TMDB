package gini.udihaguel;

public class Main {
    public static final MovieApiManager movieApiManager = new MovieApiManager();

    public static void main(String[] args) {
        MovieResponse movies = null;
        try {
            movies = movieApiManager.getMovies();
        } catch (Exception e){
            e.printStackTrace();
        }
        if (movies != null) {
            for (Movie movie: movies.getResults()) {
                System.out.println(
                        "Movie Title: " + movie.getOriginal_title()
                        + "\n"
                        + "Overview: " + movie.getOverview()
                        + "\n"
                        + "Ratings: " + movie.getVote_average()
                        + "\n"
                );
            }
        }
    }
}
