import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

class Product {
    private String productId;
    private String productName;
    private String productCategory;

    public Product(String productId, String productName, String productCategory){
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
    }

    public String getProductId(){
        return productId;
    }
    public String getProductName(){
        return productName;
    }
    public String getProductCategory() {
        return productCategory;
    }
}

class sortByName implements Comparator<Product>{
    public int compare(Product p1, Product p2){
        return p1.getProductName().compareTo(p2.getProductName());
    }
}

public class ProductSearchSystem{
    static Product[] productlist;
    static Product[] sortedProducts;

    private static void initializeProducts(){
        productlist = new Product[] {
            new Product("E001","Mobile","Electronics"),
            new Product("E002","TV","Electronics"),
            new Product("E003","Headphone","Electronics"),
            new Product("E004","PowerBank","Electronics"),
            new Product("H001","Curtain","Home&Kitchen"),
            new Product("H002","CookingPan","Home&Kitchen"),
            new Product("H003","Chair","Home&Kitchen"),
            new Product("F001","Dress","Fashion"),
            new Product("F002","Shoes","Fashion"),
            new Product("F003","Handbag","Fashion"),
        };

        sortedProducts = Arrays.copyOf(productlist, productlist.length);
        Arrays.sort(sortedProducts, new sortByName());
    }

    public static void main(String[] args) {
        initializeProducts();
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("1. Search by product ID");
            System.out.println("2. Search by product Name");
            System.out.println("3. Search by product Category");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter product ID: ");
                    String id = sc.nextLine();
                    searchById(id);
                    break;
            
                case 2:
                    System.out.println("Enter product name: ");
                    String name = sc.nextLine();
                    searchByName(name);
                    break;

                case 3:
                    System.out.println("Enter product category: ");
                    String cat = sc.nextLine();
                    searchByCategory(cat);
                    break;

                case 4: 
                    System.out.println("Exited");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    static void searchById(String id){
        // Linear search
        boolean found = false;
        for(Product p : productlist){
            if(p.getProductId().equalsIgnoreCase(id)){
                System.out.println("Product with id " + id  + " found");
                found = true;
                break;
            }
        }
        if(!found)
            System.out.println("Product with ID " + id + " not found");
    }

    static void searchByName(String name){
        // Binary Search
        boolean found = false;
        int left=0;
        int right= sortedProducts.length-1;

        while(left<=right){
            int mid = (left+right)/2;
            int comparison = sortedProducts[mid].getProductName().compareToIgnoreCase(name);

            if(comparison == 0){
                System.out.println("Product " + name + " found");
                found = true;
                break;
            }
            else if(comparison<0){
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        if(!found)
            System.out.println("Product " + name + " not found");
    }

    static void searchByCategory(String cat){
        // Linear Search
        boolean found = false;

        for(Product p : productlist){
            if(p.getProductCategory().equalsIgnoreCase(cat)){
                System.out.println(p.getProductName());
                found= true;
            }
        }
        if(!found)
            System.out.println("No product in category " + cat);
    }
}
