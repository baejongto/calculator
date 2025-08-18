import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BasicMovieParser implements MovieParser {
    @Override
    public List<Movie> parse() throws IOException {
        List<Movie> movies = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/movies.csv"))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");
                long movieId = Long.parseLong(parts[0]);
                String title = parts[1];
                Set<String> genres = new HashSet<>();
                for (String genre : parts[2].split("\\|")) {
                    genres.add(genre.trim());
                }

                Movie movie = new Movie(movieId, title, genres);

                movies.add(movie);

            }
            return movies;

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
