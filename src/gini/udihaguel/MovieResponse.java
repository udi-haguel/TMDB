package gini.udihaguel;
import java.util.List;

public class MovieResponse {
    List<Movie> results;

    public MovieResponse(){}

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }
}