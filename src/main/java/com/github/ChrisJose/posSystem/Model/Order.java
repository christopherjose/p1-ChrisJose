package com.github.ChrisJose.posSystem.Model;

import java.util.Map;

public class Order {

    String customerId;
    String orderId;
    String status;
    String comment;
    String salesAssociate;
    String orderDate;
    float subTotal;
    float salesTax;
    float totalAmt;
    float payment;
    float financing;
    float balanceDue;
    Map<String, String> deliverySchedule; // productName,quantity, deliveryService,delivery date, invoiced
    Map<String, OrderProduct> products;
    Customer customer;

    Order(String customerId, String orderId, String status, String comment,
               String salesAssociate, String orderDate, float subTotal, float salesTax,
               float totalAmt, float financing, float balanceDue) {
        this.customerId = customerId;
        this.orderId = orderId;
        this.status = status;
        this.comment = comment;
        this.salesAssociate = salesAssociate;
        this.orderDate = orderDate;
        this.subTotal = subTotal;
        this.salesTax = salesTax;
        this.totalAmt = totalAmt;
        this.financing = financing;
        this.balanceDue = balanceDue;
        }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getSalesAssociate() {
        return salesAssociate;
    }

    public void setSalesAssociate(String salesAssociate) {
        this.salesAssociate = salesAssociate;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public float getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(float salesTax) {
        this.salesTax = salesTax;
    }

    public float getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(float totalAmt) {
        this.totalAmt = totalAmt;
    }

    public float getPayment() {
        return payment;
    }

    public void setPayment(float payment) {
        this.payment = payment;
    }

    public float getFinancing() {
        return financing;
    }

    public void setFinancing(float financing) {
        this.financing = financing;
    }

    public float getBalanceDue() {
        return balanceDue;
    }

    public void setBalanceDue(float balanceDue) {
        this.balanceDue = balanceDue;
    }


    }

 class OrderProduct {
    String orderId;
    String productId;
    String productName;
    String size;
    String disposition;
    String vendorName;
    String type;
    String deliveryDate;
    String deliveryService;
    String atpDate;
    boolean invoiced;
    int quantity;
    float stickerPrice;
    float salePrice;
    float totalSalePrice;
    float percentDiscount;

    OrderProduct(String orderId, String productId, String productName, String size, String disposition, int quantity,
                 float stickerPrice, float salePrice, float percentDiscount, float totalSalePrice)
    {
        this.orderId = orderId;
        this.productId = productId;
        this.productName = productName;
        this.size = size;
        this.disposition = disposition;
        this.quantity = quantity;
        this.stickerPrice = stickerPrice;
        this.salePrice = salePrice;
        this.percentDiscount = percentDiscount;
        this.totalSalePrice = totalSalePrice;
    }

    OrderProduct(String productId, String productName, String size, String disposition, String vendorName, String atpDate)
    {
        this.productId = productId;
        this.productName = productName;
        this.size = size;
        this.disposition = disposition;
        this.vendorName = vendorName;
        this.atpDate = atpDate;
    }








}

