
class SentimentAnalyzer:
    def analyze_sentiment(self, text):
        print(text)
        return "Neutral"

class RemovePunctuationDecorator:
    def __init__(self, sentiment_analyzer):
        self._sentiment_analyzer = sentiment_analyzer

    def analyze_sentiment(self, text):
        import string
        text = text.translate(str.maketrans("", "", string.punctuation))
        return self._sentiment_analyzer.analyze_sentiment(text)

class RemoveStopwordsDecorator:
    def __init__(self, sentiment_analyzer):
        self._sentiment_analyzer = sentiment_analyzer
        self.stopwords = set(["a", "an", "the", "in", "on", "of", "for"])

    def analyze_sentiment(self, text):
        words = text.split()
        filtered_words = [word for word in words if word.lower() not in self.stopwords]
        text = " ".join(filtered_words)
        return self._sentiment_analyzer.analyze_sentiment(text)

if __name__ == "__main__":
    # Creating the base SentimentAnalyzer object
    sentiment_analyzer = SentimentAnalyzer()

    # Adding decorators to add functionaltiy of the sentiment analysis process
    sentiment_analyzer = RemovePunctuationDecorator(sentiment_analyzer)
    sentiment_analyzer = RemoveStopwordsDecorator(sentiment_analyzer)

    # Analyzing sentiments
    text = "This is a great movie! I loved it."
    result = sentiment_analyzer.analyze_sentiment(text)
    print("Sentiment:", result)
    # Output: This is great movie I loved it \n Sentiment: Neutral