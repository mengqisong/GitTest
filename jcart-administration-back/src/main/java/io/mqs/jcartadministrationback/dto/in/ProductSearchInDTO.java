package io.mqs.jcartadministrationback.dto.in;

public class ProductSearchInDTO {
    private String productName;
    private String productCode;
    private Double price;
    private String stockQuantity;
    private Byte status;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(String stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
