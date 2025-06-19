// PdfDocumentFactory.java - Concrete Creator
public class PdfDocumentFactory extends DocumentFactory {
    
    public Documents createDocument() {
        return new PdfDocument();
    }
}