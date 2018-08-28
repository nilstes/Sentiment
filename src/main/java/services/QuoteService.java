package services;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Service that analyzes text value
 * @author nilstes
 */
@Path("quote")
public class QuoteService {
    
    private static final Logger log = Logger.getLogger(QuoteService.class.getName());

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Quote getQuote() {
        log.log(Level.INFO, "QuoteService.getQuote()");
        Quote quote = Quote.getRandom();
        log.log(Level.INFO, "Returning {0}: {1}", new Object[]{quote.getMovie(), quote.getQuote()});
        return quote;
    }
}

