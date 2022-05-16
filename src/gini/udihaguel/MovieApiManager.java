package gini.udihaguel;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
public class MovieApiManager implements MovieService{
    private final OkHttpClient client = new OkHttpClient();
    private final Moshi moshi = new Moshi.Builder().build();
    private final JsonAdapter<MovieResponse> moviesJsonAdapter = moshi.adapter(MovieResponse.class);
    private final String url = "https://api.themoviedb.org/3/discover/movie?api_key=96624ea86553cd7a4caed4ecbdc35ec1";

    @Override
    public MovieResponse getMovies() throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            assert response.body() != null;
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            MovieResponse movieResponse = moviesJsonAdapter.fromJson(response.body().source());
            return movieResponse;
        }
    }
}