package product;

public class ProductModel {
    private String barCode;
    private String name;
    private Integer priceInCents;
    private Integer stock;

    public ProductModel(String barCode) {
        this.barCode = barCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPriceInCents(Integer priceInCents) {
        this.priceInCents = priceInCents;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getBarCode() {
        return barCode;
    }

    public String getName() {
        return name;
    }

    public Integer getPriceInCents() {
        return priceInCents;
    }

    public Integer getStock() {
        return stock;
    }
}
