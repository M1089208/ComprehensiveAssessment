package com.UiStore;

import org.openqa.selenium.By;

public class ShopProductsUi {
	
	public By shopProductsLink=By.xpath("//a[contains(text(),'Shop Products')]");
	
	public By stainRemover=By.xpath("//span[contains(text(),'Stain Remover')]");
	
	public By deepClean =By.xpath("//a[contains(text(),'Deep Clean')]");
	
	public By productsNo=By.cssSelector(".plp-products-count");
	
	public By text=By.xpath("//p[contains(text(),'How to Remove Ink Stains')]");
	
	public By popUp=By.xpath("//button[@class='sticker_close']");

}
