// ExcelDocumentFactory.java - Concrete Creator
public class ExcelDocumentFactory extends DocumentFactory {
    
    public Documents createDocument() {
        return new ExcelDocument();
    }
}