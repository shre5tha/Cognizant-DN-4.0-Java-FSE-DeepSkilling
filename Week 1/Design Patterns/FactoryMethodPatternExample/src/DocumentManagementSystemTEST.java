// Client class
public class DocumentManagementSystemTEST {
    public static void main(String[] args) {
        // Create different types of documents using the appropriate factories
        DocumentFactory wordFactory = new WordDocumentFactory();
        Documents wordDoc = wordFactory.createDocument();
        System.out.println("Word Document Operations:");
        wordDoc.open();
        wordDoc.save();
        wordDoc.close();
        
        System.out.println("\nPDF Document Operations:");
        DocumentFactory pdfFactory = new PdfDocumentFactory();
       // Documents pdfDoc = pdfFactory.createDocument();
        pdfFactory.newDocument(); // Using the template method
        
        System.out.println("\nExcel Document Operations:");
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Documents excelDoc = excelFactory.createDocument();
        excelDoc.open();
        excelDoc.save();
        excelDoc.close();
        
        /*
        // Alternatively, we can use the factory method directly
        System.out.println("\nCreating documents through factory methods:");
        createAndProcessDocument(new WordDocumentFactory());
        createAndProcessDocument(new PdfDocumentFactory());
        createAndProcessDocument(new ExcelDocumentFactory());

        */
    }
    
    /*
    private static void createAndProcessDocument(DocumentFactory factory) {
        System.out.println("\n--- " + factory.getClass().getSimpleName() + " ---");
        Documents doc = factory.createDocument();
        doc.open();
        doc.save();
        doc.close();
    }
    */
}