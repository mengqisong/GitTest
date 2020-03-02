package io.mqs.jcartadministrationback.dto.out;

public class ProductListOutDTO {
    private Integer productId;
    private String productName;
    private String productCode;
    private Double price;
    private Double discount;
    private String productAbstract;
    private String stockQuantity;
    private Byte status;
    private String mainPicUrl;

    @Override
    public String toString() {
        return "ProductListOutDTO{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productCode='" + productCode + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", productAbstract='" + productAbstract + '\'' +
                ", stockQuantity='" + stockQuantity + '\'' +
                ", status=" + status +
                ", mainPicUrl='" + mainPicUrl + '\'' +
                '}';
    }

    public String getProductAbstract() {
        return productAbstract;
    }

    public void setProductAbstract(String productAbstract) {
        this.productAbstract = productAbstract;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

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

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
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

    public String getMainPicUrl() {
        return mainPicUrl;
    }

    public void setMainPicUrl(String mainPicUrl) {
        this.mainPicUrl = mainPicUrl;
    }
}
