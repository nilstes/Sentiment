package services;

import analysis.Analyser;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Service that analyzes text value
 * @author nilstes
 */
@Path("sentiment")
public class SentimentService {
    
    private static final Logger log = Logger.getLogger(SentimentService.class.getName());

    private static Analyser analyser = new Analyser();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Sentiment getSentiment(@Context UriInfo ui, @Context HttpServletRequest req, SentimentRequest sr) {

        String apiKey = ui.getQueryParameters().getFirst("api-key");
        if (apiKey == null || !apiKey.equals("Happy!!!")) {
            throw new NotAuthorizedException("Sorry :(");
        }

        log.log(Level.INFO, "SentimentService.getSentiment(): sentence={0}", new Object[]{sr.getSentence()});
        int sentiment = analyser.findSentiment(sr.getSentence());
        log.log(Level.INFO, "Returning {0}", sentiment);
        return new Sentiment(sentiment);
    }
}

