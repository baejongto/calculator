import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ApacheCommonsCsvMovieParser implements MovieParser{

    @Override
    public List<Movie> parse() throws IOException {
        List<Movie> movies = new ArrayList<>();
        Reader csvData = new FileReader("src/main/resources/movies.csv");
        CSVParser csvParser = CSVParser.parse(csvData, CSVFormat.EXCEL);

        List<CSVRecord> csvRecordList = csvParser.getRecords();

        for(int record_i=1; record_i<csvRecordList.size(); record_i++){
            CSVRecord csvRecord = csvRecordList.get(record_i);

            long movieId = Long.parseLong(csvRecord.get(0));
            String title = csvRecord.get(1);
            Set<String> genres =  Arrays.stream(csvRecord.get(2).split("\\|")).collect(Collectors.toSet());

            Movie movie = new Movie(movieId, title, genres);
            movies.add(movie);

        }
        return movies;

    }


}
