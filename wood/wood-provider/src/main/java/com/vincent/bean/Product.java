package com.vincent.bean;

import java.io.Serializable;

public class Product implements Serializable {

    private static final long serialVersionUID = 7364718632441964830L;

    // 产品货号
    private String itemCode;

    // 产品名称
    private String name;

    // 产品品牌名称
    private String bankName;

    // 产品价格
    private String price;

    public Product(){}

    public Product(String itemCode,String name,String bankName,String price){
        this.itemCode = itemCode;
        this.name = name;
        this.bankName = bankName;
        this.price = price;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
