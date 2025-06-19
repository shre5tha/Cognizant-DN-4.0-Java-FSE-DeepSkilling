// WordDocumentFactory.java - Concrete Creator
public class WordDocumentFactory extends DocumentFactory {
    
    public Documents createDocument() {
        return new WordDocument();
    }
}