package services;

import java.util.*;

public class Quote {
    private String movie;
    private String quote;

    public Quote() {
    }

    public Quote(String movie, String quote) {
        this.movie = movie;
        this.quote = quote;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    private static Random rnd = new Random();
    private static List<Quote> quotes = new ArrayList<Quote>() {{
        add(new Quote("Gone With the Wind", "Frankly, my dear, I don't give a damn."));
        add(new Quote("The Godfather", "I'm going to make him an offer he can't refuse."));
        add(new Quote("Toto, I've got a feeling we're not in Kansas anymore.", "The Wizard of Oz"));
        add(new Quote("Go ahead, make my day.", "Sudden Impact"));
        add(new Quote("May the Force be with you.", "Star Wars"));
        add(new Quote("You talking to me?", "Taxi Driver,"));
        add(new Quote("I love the smell of napalm in the morning.", "Apocalypse Now"));
        add(new Quote("E.T. phone home.", "E.T. The Extra-Terrestrial"));
        add(new Quote("Rosebud.", "Citizen Kane"));
        add(new Quote("I'll have what she's having.", "When Harry Met Sally,"));
        add(new Quote("I'll be back.", "The Terminator"));
        add(new Quote("Mama always said life was like a box of chocolates. You never know what you're gonna get.", "Forrest Gump"));
        add(new Quote("You've got to ask yourself one question: 'Do I feel lucky?' Well, do ya, punk?", "Dirty Harry"));
        add(new Quote("Keep your friends close, but your enemies closer.", "The Godfather II"));
        add(new Quote("Elementary, my dear Watson.", "The Adventures of Sherlock Holmes"));
        add(new Quote("Here's Johnny!", "The Shining"));
        add(new Quote("Hasta la vista, baby.", "Terminator 2: Judgment Day"));
        add(new Quote("Nobody puts Baby in a corner.", "Dirty Dancing"));
        add(new Quote("I'm king of the world!", "Titanic"));
        add(new Quote("Yippee-ki-yay, motherfucker.", "Die Hard"));
    }};

    public static Quote getRandom() {
        return quotes.get(rnd.nextInt(quotes.size()));
    }
}
