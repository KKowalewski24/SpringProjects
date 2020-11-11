package pl.kkowalewski.services;

import org.springframework.stereotype.Service;
import pl.springframework.norris.chuck.ChuckNorrisQuotes;

@Service
public class JokeServiceImpl implements JokeService {

    /*------------------------ FIELDS REGION ------------------------*/
    private final ChuckNorrisQuotes quotes;

    /*------------------------ METHODS REGION ------------------------*/
    public JokeServiceImpl(ChuckNorrisQuotes quotes) {
        this.quotes = quotes;
    }

    @Override
    public String getJoke() {
        return quotes.getRandomQuote();
    }
}
