import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Product> ProductList = new ArrayList<>();
    static ArrayList<Category> CategoryList = new ArrayList<>();
    public static void main(String [] args){

        int menuchoice;
        do { System.out.println("1. Ny produkt" + "\n" + "2. Sök produkt" + "\n" + "3. Lista produkter" +
                    "\n" + "4. Radera produkt" + "\n"+ "5. Ny kategori"+ "\n" +
                    "6. Lägg till produkt till kategori" + "\n" + "7. Lista kategorier" + "\n" +  "8. Avsluta");
            menuchoice = sc.nextInt();
            sc.nextLine();
            switch (menuchoice){
                case 1: RegisterProduct();
                        break;
                case 2: SearchProduct();
                        break;
                case 3: ListProducts();
                        break;
                case 4: DeleteProduct();
                        break;
                case 5: NewCategory();
                        break;
                case 6: AddProductToCategory();
                        break;
                case 7: ListCategories();
                        break;
                case 8: //Avslutar program

            }

        }while(menuchoice!=8);
    }

    public static void RegisterProduct() {
        System.out.print("SKU: ");
        String SKU = sc.nextLine();

        if(FindProductBySKU(SKU)!=null){
            System.out.println("Produkt redan registrerad");
            PauseProgram();
            return;
        }

        System.out.print("Namn: ");
        String Namn = sc.nextLine();

        System.out.print("Beskrivning: ");
        String Beskrivning = sc.nextLine();

        System.out.print("Pris: ");
        String Pris = sc.nextLine();

        Product product = new Product(SKU, Namn, Beskrivning, Pris);
        ProductList.add(product);
        System.out.println("Produkt registrerad");
        PauseProgram();
    }

    public static void SearchProduct() {
        System.out.print("Ange SKU: ");
        String SKU = sc.nextLine();
        Product product = FindProductBySKU(SKU);
        if(product==null){
            System.out.println("Produkt saknas");
            PauseProgram();
            return;
        }
        System.out.println(product);
        System.out.println("Ange ENTER för att återgå till huvudmenyn");
        sc.nextLine();
    }

    public static void ListProducts() {
        System.out.printf("%-10s %-20s %-1s%n", "SKU" , "Namn", "Pris");
        System.out.println("-----------------------------------------");
        for(Product product : ProductList){
            System.out.printf("%-10s %-20s %-1s%n", product.getSKU(), product.getNamn(), product.getPris());
        }
        System.out.println("Tryck ENTER för att återgå till huvudmenyn");
        sc.nextLine();
    }

    public static void DeleteProduct() {
        System.out.print("Ange SKU: ");
        String SKU = sc.nextLine();
        Product product = FindProductBySKU(SKU);
        if(product==null){
            System.out.println("Produkt saknas");
            PauseProgram();
            return;
        }
        ProductList.remove(product);
        System.out.println("Produkt raderad");
        PauseProgram();
    }

    public static void NewCategory() {
        System.out.print("Namn: ");
        String CategoryName = sc.nextLine();
        Category category = new Category(CategoryName);
        CategoryList.add(category);
        System.out.println("Kategori tillagd");
        PauseProgram();
    }

    public static void AddProductToCategory() {
        System.out.print("SKU: ");
        String SKU = sc.nextLine();
        Product product = FindProductBySKU(SKU);
        if(product==null){
            System.out.println("Produkt saknas");
            PauseProgram();
            return;
        }
        System.out.println("Namn: " + product.getNamn());

        System.out.print("Ange kategori: ");
        String CategoryName = sc.nextLine();
        Category category = FindCategoryByName(CategoryName);

        if(category==null){
            System.out.println("Kategori finns inte");
            PauseProgram();
            return;
        }

        try{
            category.AddProduct(product);
        } catch (IllegalArgumentException e){
            System.out.println("Produkt redan tillagd");
            PauseProgram();
            return;
        }

        System.out.println("Produkt tillagd");
        PauseProgram();
    }

    public static void ListCategories() {
        System.out.printf("%-15s %7s%n", "Namn", "Pris");
        System.out.println("-----------------------------");
        for (Category category : CategoryList) {
            System.out.printf("%s (%s)%n", category.getCategoryName(), category.CategorySize());
            ArrayList<Product> ProductsListInCategory = category.getProductsListInCategory();
            for (Product product : ProductsListInCategory) {
                System.out.printf(" %-15s %7s%n", product.getNamn(), product.getPris());
            }
        }
        System.out.println("Tryck ENTER för att återgå till huvudmenyn");
        sc.nextLine();
    }

            public static Product FindProductBySKU (String SKU){
                for (Product product : ProductList) {
                    if (product.getSKU().equalsIgnoreCase(SKU)) {
                        return product;
                    }
                }
                return null;
            }

            public static void PauseProgram () {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            private static Category FindCategoryByName (String CategoryName){
                for (Category category : CategoryList) {
                    if (category.getCategoryName().equalsIgnoreCase(CategoryName)) {
                        return category;
                    }
                }
                return null;
            }


}
