package org.csu.mypetstore.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

public class Order implements Serializable
{

    private static final long serialVersionUID = 6321792448424424931L;

    private int orderId;
    private String username;
    private Date orderDate;

    private String shipToFirstName;
    private String shipToLastName;
    private String shipAddress1;
    private String shipAddress2;
    private String shipCity;
    private String shipState;
    private String shipZip;
    private String shipCountry;

    private String billToFirstName;
    private String billToLastName;
    private String billAddress1;
    private String billAddress2;
    private String billCity;
    private String billState;
    private String billZip;
    private String billCountry;

    private String creditCard;
    private String expiryDate;
    private String cardType;
    private BigDecimal totalPrice;
    private String courier;
    private String locale;
    private String status;
    private List<LineItem> lineItems = new ArrayList<LineItem>();

    private boolean shippingAddressRequired;

    public boolean isShippingAddressRequired()
    {
        return shippingAddressRequired;
    }

    public void setShippingAddressRequired(boolean shippingAddressRequired)
    {
        this.shippingAddressRequired = shippingAddressRequired;
    }

    public int getOrderId()
    {
        return orderId;
    }

    public void setOrderId(int orderId)
    {
        this.orderId = orderId;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public Date getOrderDate()
    {
        return orderDate;
    }

    public void setOrderDate(Date orderDate)
    {
        this.orderDate = orderDate;
    }

    public String getShipAddress1()
    {
        return shipAddress1;
    }

    public void setShipAddress1(String shipAddress1)
    {
        this.shipAddress1 = shipAddress1;
    }

    public String getShipAddress2()
    {
        return shipAddress2;
    }

    public void setShipAddress2(String shipAddress2)
    {
        this.shipAddress2 = shipAddress2;
    }

    public String getShipCity()
    {
        return shipCity;
    }

    public void setShipCity(String shipCity)
    {
        this.shipCity = shipCity;
    }

    public String getShipState()
    {
        return shipState;
    }

    public void setShipState(String shipState)
    {
        this.shipState = shipState;
    }

    public String getShipZip()
    {
        return shipZip;
    }

    public void setShipZip(String shipZip)
    {
        this.shipZip = shipZip;
    }

    public String getShipCountry()
    {
        return shipCountry;
    }

    public void setShipCountry(String shipCountry)
    {
        this.shipCountry = shipCountry;
    }

    public String getBillAddress1()
    {
        return billAddress1;
    }

    public void setBillAddress1(String billAddress1)
    {
        this.billAddress1 = billAddress1;
    }

    public String getBillAddress2()
    {
        return billAddress2;
    }

    public void setBillAddress2(String billAddress2)
    {
        this.billAddress2 = billAddress2;
    }

    public String getBillCity()
    {
        return billCity;
    }

    public void setBillCity(String billCity)
    {
        this.billCity = billCity;
    }

    public String getBillState()
    {
        return billState;
    }

    public void setBillState(String billState)
    {
        this.billState = billState;
    }

    public String getBillZip()
    {
        return billZip;
    }

    public void setBillZip(String billZip)
    {
        this.billZip = billZip;
    }

    public String getBillCountry()
    {
        return billCountry;
    }

    public void setBillCountry(String billCountry)
    {
        this.billCountry = billCountry;
    }

    public String getCourier()
    {
        return courier;
    }

    public void setCourier(String courier)
    {
        this.courier = courier;
    }

    public BigDecimal getTotalPrice()
    {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    public String getBillToFirstName()
    {
        return billToFirstName;
    }

    public void setBillToFirstName(String billToFirstName)
    {
        this.billToFirstName = billToFirstName;
    }

    public String getBillToLastName()
    {
        return billToLastName;
    }

    public void setBillToLastName(String billToLastName)
    {
        this.billToLastName = billToLastName;
    }

    public String getShipToFirstName()
    {
        return shipToFirstName;
    }

    public void setShipToFirstName(String shipFoFirstName)
    {
        this.shipToFirstName = shipFoFirstName;
    }

    public String getShipToLastName()
    {
        return shipToLastName;
    }

    public void setShipToLastName(String shipToLastName)
    {
        this.shipToLastName = shipToLastName;
    }

    public String getCreditCard()
    {
        return creditCard;
    }

    public void setCreditCard(String creditCard)
    {
        this.creditCard = creditCard;
    }

    public String getExpiryDate()
    {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate)
    {
        this.expiryDate = expiryDate;
    }

    public String getCardType()
    {
        return cardType;
    }

    public void setCardType(String cardType)
    {
        this.cardType = cardType;
    }

    public String getLocale()
    {
        return locale;
    }

    public void setLocale(String locale)
    {
        this.locale = locale;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public void setLineItems(List<LineItem> lineItems)
    {
        this.lineItems = lineItems;
    }

    public List<LineItem> getLineItems()
    {
        return lineItems;
    }

    public void initOrder(Account account, Cart cart)
    {

        username = account.getUsername();
        orderDate = new Date(System.currentTimeMillis());

        billToFirstName = account.getFirstName();
        billToLastName = account.getLastName();
        billAddress1 = account.getAddress1();
        billAddress2 = account.getAddress2();
        billCity = account.getCity();
        billState = account.getState();
        billZip = account.getZip();
        billCountry = account.getCountry();

        this.copyBillToShip(this);

        totalPrice = cart.getSubTotal();

        creditCard = "999 9999 9999 9999";
        expiryDate = "12/03";
        cardType = "Visa";
        courier = "UPS";
        locale = "CA";
        status = "P";

        Iterator<CartItem> i = cart.getAllCartItems();
        while (i.hasNext())
        {
            CartItem cartItem = (CartItem) i.next();
            addLineItem(cartItem);
        }

    }

    public void addLineItem(CartItem cartItem)
    {
        LineItem lineItem = new LineItem(lineItems.size() + 1, cartItem);
        lineItem.setOrderId(orderId);
        addLineItem(lineItem);
    }

    public void addLineItem(LineItem lineItem)
    {
        lineItems.add(lineItem);
    }

    public void copyBillToShip(Order order){
        this.shipToFirstName = order.getBillToFirstName();
        this.shipToLastName = order.getBillToLastName();
        this.shipAddress1 = order.getBillAddress1();
        this.shipAddress2 = order.getBillAddress2();
        this.shipCity = order.getBillCity();
        this.shipState = order.getBillState();
        this.shipZip = order.getBillZip();
        this.shipCountry = order.getBillCountry();
    }

    public void updateShip(Order order){
        shipToFirstName = order.getShipToFirstName();
        shipToLastName = order.getShipToLastName();
        shipAddress1 = order.getShipAddress1();
        shipAddress2 = order.getShipAddress2();
        shipCity = order.getShipCity();
        shipState = order.getShipState();
        shipZip = order.getShipZip();
        shipCountry = order.getShipCountry();
    }

    public void updateBill(Order order){
        billToFirstName = order.getBillToFirstName();
        billToLastName = order.getBillToLastName();
        billAddress1 = order.getBillAddress1();
        billAddress2 = order.getBillAddress2();
        billCity = order.getBillCity();
        billState = order.getBillState();
        billZip = order.getBillZip();
        billCountry = order.getBillCountry();
    }

    @Override
    public String toString()
    {
        return  " 1: " + this.getOrderId() + "\n" +
                " 2: " + this.getUsername() + "\n" +
                " 3: " + this.getOrderDate() + "\n" +
                " 4: " + this.getShipToFirstName() + "\n" +
                " 5: " + this.getShipToLastName() + "\n" +
                " 6: " + this.getShipAddress1() + "\n" +
                " 7: " + this.getShipAddress2() + "\n" +
                " 8: " + this.getShipCity() + "\n" +
                " 9: " + this.getShipZip() + "\n" +
                "10: " + this.getShipCountry() + "\n" +
                "11: " + this.getBillAddress1() + "\n" +
                "12: " + this.getBillAddress1()  + "\n" +
                "13: " + this.getBillCity()  + "\n" +
                "14: " + this.getBillState() + "\n" +
                "15: " + this.getBillZip() + "\n" +
                "16: " + this.getBillCountry() + "\n" +
                "17: " + this.getCreditCard() + "\n" +
                "18: " + this.getExpiryDate() + "\n" +
                "19: " + this.getCardType() + "\n" +
                "20: " + this.getTotalPrice() + "\n" +
                "21: " + this.getCourier() + "\n" +
                "22: " + this.getLocale() + "\n" +
                "23: " + this.getStatus()+ "\n" +
                "END" + "\n";
    }
}
