public abstract class DocumentFactory {
    // The factory method
    public abstract Documents createDocument();
    
    // Some operation that uses the product
    public void newDocument() {
        Documents doc = createDocument();
        doc.open();
        doc.save();
        doc.close();
    }
}