package services;

public class SentimentRequest {
    String sentence;

    public SentimentRequest() {
    }

    public SentimentRequest(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
}
