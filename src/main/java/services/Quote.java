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
        add(new Quote("The Wizard of Oz", "Toto, I've got a feeling we're not in Kansas anymore."));
        add(new Quote("Sudden Impact", "Go ahead, make my day."));
        add(new Quote("Star Wars", "May the Force be with you."));
        add(new Quote("Taxi Driver", "You talking to me?"));
        add(new Quote("Apocalypse Now", "I love the smell of napalm in the morning."));
        add(new Quote("E.T. The Extra-Terrestrial", "E.T. phone home."));
        add(new Quote("Citizen Kane", "Rosebud."));
        add(new Quote("When Harry Met Sally", "I'll have what she's having."));
        add(new Quote("The Terminator", "I'll be back."));
        add(new Quote("Forrest Gump", "Mama always said life was like a box of chocolates. You never know what you're gonna get."));
        add(new Quote("Dirty Harry", "You've got to ask yourself one question: 'Do I feel lucky?' Well, do ya, punk?"));
        add(new Quote("The Godfather II", "Keep your friends close, but your enemies closer."));
        add(new Quote("The Adventures of Sherlock Holmes", "Elementary, my dear Watson."));
        add(new Quote("The Shining", "Here's Johnny!"));
        add(new Quote("Terminator 2: Judgment Day", "Hasta la vista, baby."));
        add(new Quote("Dirty Dancing", "Nobody puts Baby in a corner."));
        add(new Quote("Titanic", "I'm king of the world!"));
        add(new Quote("Die Hard", "Yippee-ki-yay, motherfucker."));
    }};

    public static Quote getRandom() {
        return quotes.get(rnd.nextInt(quotes.size()));
    }
}
