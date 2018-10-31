package services;

import analysis.Analyser;
import logger.RequestLogger;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
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
    @Consumes("text/plain")
    @Produces("text/plain")
    public int getSentiment(@Context HttpServletRequest req, String text) {
        String userAgent = req.getHeader("User-Agent");
        log.log(Level.INFO, "SentimentService.getSentiment(): text={0}, userAgent={1}", new Object[]{text, userAgent});
        int sentiment = analyser.findSentiment(text);
        log.log(Level.INFO, "Returning {0}", sentiment);
        return sentiment;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/log")
    public Sentiment getSentimentAndLog(@Context UriInfo ui, @Context HttpServletRequest req, SentimentRequest sr) {

        String apiKey = ui.getQueryParameters().getFirst("api-key");
        if (apiKey == null || !apiKey.equals("Happy!!!")) {
            throw new NotAuthorizedException("Sorry :(");
        }

        log.log(Level.INFO, "SentimentService.getSentimentAndLog(): sentence={0}", new Object[]{sr.getSentence()});
        int sentiment = analyser.findSentiment(sr.getSentence());
        RequestLogger requestLogger = new RequestLogger();
        requestLogger.logRequest(sr.getSentence(), sentiment, req);
        log.log(Level.INFO, "Returning {0}", sentiment);
        return new Sentiment(sentiment);
    }
}

