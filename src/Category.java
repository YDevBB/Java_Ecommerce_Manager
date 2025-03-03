import java.util.ArrayList;

public class Category {
private String CategoryName;
private ArrayList<Product> ProductsListInCategory = new ArrayList<>();

    public Category(String CategoryName){
        if(CategoryName == null || CategoryName.trim().isEmpty()){
            throw new IllegalArgumentException("Kategori måste ha ett namn");
        }
        this.CategoryName = CategoryName;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public ArrayList<Product> getProductsListInCategory() {
        return ProductsListInCategory;
    }

    public void setProductsListInCategory(ArrayList<Product> productsListInCategory) {
        ProductsListInCategory = productsListInCategory;
    }

    public int CategorySize(){
        return ProductsListInCategory.size();
    }

    public void AddProduct(Product product){
        if(ProductsListInCategory.contains(product)){
            throw new IllegalArgumentException();
        }else{
            ProductsListInCategory.add(product);
        }
    }
}
