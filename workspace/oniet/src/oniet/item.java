package oniet;

import java.sql.Date;

public class item {
public String id;
public String date;
public String siteld;
public String tite;
public Long	sellerId;
public  String categoryId;
public float price;
public float 	basePrice;
public String currencyId;
public int 	initialQuantity;
public int availableQuantity;

public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getSiteld() {
	return siteld;
}
public void setSiteld(String siteld) {
	this.siteld = siteld;
}
public String getTite() {
	return tite;
}
public void setTite(String tite) {
	this.tite = tite;
}

public Long getSellerId() {
	return sellerId;
}
public void setSellerId(Long sellerId) {
	this.sellerId = sellerId;
}
public String getCategoryId() {
	return categoryId;
}
public void setCategoryId(String categoryId) {
	this.categoryId = categoryId;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public float getBasePrice() {
	return basePrice;
}
public void setBasePrice(float basePrice) {
	this.basePrice = basePrice;
}
public String getCurrencyId() {
	return currencyId;
}
public void setCurrencyId(String currencyId) {
	this.currencyId = currencyId;
}
public int getInitialQuantity() {
	return initialQuantity;
}
public void setInitialQuantity(int initialQuantity) {
	this.initialQuantity = initialQuantity;
}
public int getAvailableQuantity() {
	return availableQuantity;
}
public void setAvailableQuantity(int availableQuantity) {
	this.availableQuantity = availableQuantity;
}



	
}