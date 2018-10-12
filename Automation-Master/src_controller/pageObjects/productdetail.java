package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class productdetail {

	
public RemoteWebDriver driver=null;
	
	By breadcrumbProductDetail=By.cssSelector("#top-page > div.jsx-2093859422.contain-cover > div");
	By getProductName=By.cssSelector("#top-page > div.jsx-2921700402.pd-item > div.jsx-2921700402.pd-itemcol2 > div.jsx-2921700402.pd-titleprod");
	By getBrandName=By.cssSelector("#top-page > div.jsx-2921700402.pd-item > div.jsx-2921700402.pd-itemcol2 > a");
	By getPrice=By.cssSelector("#top-page > div.jsx-2921700402.pd-item > div.jsx-2921700402.pd-itemcol2 > div.jsx-2921700402.pd-price");
	By getAddReviewButton=By.cssSelector("#top-page > div.jsx-2921700402.pd-item > div.jsx-2921700402.pd-itemcol2 > button");
	By getEdEReviewButton=By.cssSelector("#top-page > div.jsx-2921700402.pd-item > div.jsx-2921700402.pd-itemcol2 > button");
	
	By getWishlistButton=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-right > div.jsx-2784532334.sorter-cover > div > button");
	By getTriedButton=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-right > div.jsx-2784532334.sorter-cover > div > button");
	By getFilterHairButton=By.cssSelector("#top-page > div.jsx-2790062022.cover-tabrev > div.jsx-2790062022.tab-review-cover-filter > div > div:nth-child(1)");
	By hairTypeWavy=By.cssSelector("#myDropdown1 > div:nth-child(1) > a.jsx-3197642051.drop-selected");
	By hairTextureThick=By.cssSelector("#myDropdown1 > div:nth-child(2) > a:nth-child(2)");
	By getFilterAgeButton=By.cssSelector("#top-page > div.jsx-2790062022.cover-tabrev > div.jsx-2790062022.tab-review-cover-filter > div > div:nth-child(2)");
	
	By age25till29=By.cssSelector("#myDropdown2 > a:nth-child(4)");
	By age30till34=By.cssSelector("#myDropdown2 > a:nth-child(5)");
	
	By getFilterSkinButton=By.cssSelector("#top-page > div.jsx-2790062022.cover-tabrev > div.jsx-2790062022.tab-review-cover-filter > div > div:nth-child(1)");
	By getOily=By.cssSelector("#myDropdown1 > div > a:nth-child(5)");
	By getFilterAgeButton2=By.cssSelector("#top-page > div.jsx-2790062022.cover-tabrev > div.jsx-2790062022.tab-review-cover-filter > div > div:nth-child(2) > button");
	
	
	By getSortButton=By.cssSelector("#top-page > div.jsx-2790062022.cover-tabrev > div.jsx-2790062022.tab-review-cover-filter > div > div:nth-child(3)");
	By mostLike=By.cssSelector("#top-page > div.jsx-2790062022.cover-tabrev > div.jsx-2790062022.tab-review-cover-filter > div > div:nth-child(3) > div > div > a:nth-child(3)");
	By sortOldest=By.cssSelector("#top-page > div.jsx-2790062022.cover-tabrev > div.jsx-2790062022.tab-review-cover-filter > div > div:nth-child(3) > div > div > a:nth-child(2)");
	By getReviewerButtonInReview=By.cssSelector("#top-page > div.jsx-2790062022.cover-tabrev > div.jsx-2790062022.prodlist-review-cover > div:nth-child(1) > div > div.card-review-new-detail > div.card-review-new-detail-row1 > div.card-review-new-userdet > div.card-review-new-username");
	By getReviewerButtonInReviewDesc=By.cssSelector("body > div:nth-child(9) > div > div.jsx-3475087559.modal-review > div > div.jsx-3475087559.modal-feed-scroll > div > div.jsx-1569223425.cardrv-content > div.jsx-1569223425.cardrv-item-comment-modal > div.jsx-1569223425.cardrv-contain > div > div > div.card-review-modal-detail > div.card-review-modal-detail-row1 > div.card-review-modal-user > div.card-review-modal-user-info");
	By getNameReviewer=By.cssSelector("#top-page > div.jsx-2790062022.cover-tabrev > div.jsx-2790062022.prodlist-review-cover > div:nth-child(1) > div > div.card-review-new-detail > div.card-review-new-detail-row1 > div.card-review-new-userdet > div.card-review-new-username > span:nth-child(1)");
	By getNameReviewerRevDesc=By.cssSelector("body > div:nth-child(7) > div > div.jsx-3475087559.modal-review > div > div.jsx-3475087559.modal-feed-scroll > div > div.jsx-1569223425.cardrv-content > div.jsx-1569223425.cardrv-item-comment-modal > div.jsx-1569223425.cardrv-contain > div > div > div.card-review-modal-detail > div.card-review-modal-detail-row1 > div.card-review-modal-user > div.card-review-modal-user-info > a");
	By getReviewDescButton=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-right > div.jsx-2784532334.sorter-cover > div > button");
	By getPage3=By.cssSelector("#top-page > div.jsx-2790062022.cover-tabrev > div.jsx-557237353.paging > div.jsx-557237353.paging-number > div.jsx-557237353.paging-list-number > a:nth-child(3) > span");
	By getPrevPageButton=By.cssSelector("#top-page > div.jsx-2790062022.cover-tabrev > div.jsx-557237353.paging > div.jsx-557237353.paging-number > a:nth-child(1)");
	By getNextPageButton=By.cssSelector("#top-page > div.jsx-2790062022.cover-tabrev > div.jsx-557237353.paging > div.jsx-557237353.paging-number > a:nth-child(3)");
	By getbacktotopButton=By.cssSelector("#top-page > div.jsx-2784532334.ctg-cover > div.jsx-2784532334.ctg-right > div.jsx-2784532334.sorter-cover > div > button");
	By getComment=By.cssSelector("#top-page > div.jsx-2790062022.cover-tabrev > div.jsx-2790062022.prodlist-review-cover > div > div > div.card-review-new-single-bottom > div > div > div.jsx-2508623835.cardrv-bottom1");
	By getCommentDouble=By.cssSelector("#top-page > div.jsx-2790062022.cover-tabrev > div.jsx-2790062022.prodlist-review-cover > div:nth-child(2) > div > div.card-review-new-single-bottom > div > div > div.jsx-2508623835.cardrv-bottom1");
	By getCommentPage3=By.cssSelector("#top-page > div.jsx-2790062022.cover-tabrev > div.jsx-2790062022.prodlist-review-cover > div:nth-child(1) > div > div.card-review-new-single-bottom > div > div > div.jsx-2508623835.cardrv-bottom1 > a");
	
	//element review people
	By commentReview=By.cssSelector("#top-page > div.jsx-2790062022.cover-tabrev > div.jsx-2790062022.prodlist-review-cover > div > div > div.card-review-new-single-bottom > div > div > div.jsx-2508623835.cardrv-bottom1");
	
	//element form review
	By getFieldReview=By.cssSelector("#form-add-review > div.jsx-4114744673.ar-form > textarea");
	By getOverallRat4=By.cssSelector("#form-add-review > div.jsx-4114744673.ar-clicked-cv > div.jsx-4114744673.ar-clicked > div.jsx-4114744673.ar-col1 > div.jsx-4114744673.ar-starlist > i:nth-child(4)");
	By getProductPriceExpensive=By.cssSelector("#form-add-review > div.jsx-4114744673.ar-clicked-cv > div.jsx-4114744673.ar-clicked > div.jsx-4114744673.ar-col1 > div.jsx-4114744673.ar-btn-txt > button:nth-child(3)");
	By getPackageQuality=By.cssSelector("#form-add-review > div.jsx-4114744673.ar-clicked-cv > div.jsx-4114744673.ar-clicked > div.jsx-4114744673.ar-col2 > div:nth-child(2) > button:nth-child(4)");
	By getPurchase=By.cssSelector("#form-add-review > div.jsx-4114744673.ar-clicked-cv > div.jsx-4114744673.ar-clicked > div.jsx-4114744673.ar-col2 > div:nth-child(4) > button.jsx-4114744673.right");
	By getButtonSubmitReview=By.cssSelector("#form-add-review > div.jsx-4114744673.ar-clicked-cv > div.jsx-4114744673.ar-bottom > div.jsx-4114744673.ar-submit");
	By detailDesc=By.cssSelector("#top-page > div.jsx-2790062022.cover-tabrev > div.jsx-2790062022.prodlist-review-cover > div:nth-child(1) > div > div.card-review-new-detail > div.card-review-new-coment");
	
	//element login
	By clickloginProdDetail=By.cssSelector("#__next > div > div > div.jsx-1986071017.gbheader > div.jsx-1986071017.gbheader-right > div.jsx-3923003960.gbheader-login");
	
	//element descr review
	By getBrandNameInReviewDetail=By.cssSelector("body > div:nth-child(7) > div > div.jsx-3475087559.modal-review > div > div.jsx-3475087559.modal-feed-scroll > div > div.jsx-3475087559.modal-review-cv > div.jsx-3475087559.modal-review-detail > div.jsx-3475087559.modal-review-brand-name > a");
	By getAddComment=By.cssSelector("body > div:nth-child(6) > div > div.jsx-3475087559.modal-review > div > div.jsx-3475087559.modal-feed-scroll > div > div.jsx-1569223425.cardrv-content > div.jsx-1569223425.addcomment-container > div > div > h3");
	By getCommentField=By.cssSelector("body > div:nth-child(7) > div > div.jsx-3475087559.modal-review > div > div.jsx-3475087559.modal-feed-scroll > div > div.jsx-1569223425.cardrv-content > div.jsx-1569223425.addcomment-container > div.jsx-1311756822.addcomment-txtx-container > form > textarea");
	By getNextCommentField=By.cssSelector("body > div:nth-child(6) > div > div.jsx-3475087559.modal-review > div > div.jsx-3475087559.modal-feed-scroll > div > div.jsx-1569223425.cardrv-content > div.jsx-1569223425.addcomment-container > div.jsx-1311756822.addcomment-txtx-container > form > textarea");
	By getButtonPost=By.cssSelector("body > div:nth-child(7) > div > div.jsx-3475087559.modal-review > div > div.jsx-3475087559.modal-feed-scroll > div > div.jsx-1569223425.cardrv-content > div.jsx-1569223425.addcomment-container > div.jsx-1311756822.addcomment-txtx-container > form > div > input.jsx-1311756822.addcomment-btn-post");
	By getButtonNextPost=By.cssSelector("body > div:nth-child(6) > div > div.jsx-3475087559.modal-review > div > div.jsx-3475087559.modal-feed-scroll > div > div.jsx-1569223425.cardrv-content > div.jsx-1569223425.addcomment-container > div.jsx-1311756822.addcomment-txtx-container > form > div > input.jsx-1311756822.addcomment-btn-post");
	By getButtonCancel=By.cssSelector("body > div:nth-child(8) > div > div.jsx-3475087559.modal-review > div > div.jsx-3475087559.modal-feed-scroll > div > div.jsx-1569223425.cardrv-content > div.jsx-1569223425.addcomment-container > div.jsx-1311756822.addcomment-txtx-container > form > div > input.jsx-1311756822.addcomment-btn-cancel");
	By closeModalDesc=By.xpath("/html/body/div[4]/div/div[2]/div/img");
	By getLoadMoreCommentButton=By.cssSelector("body > div:nth-child(8) > div > div.jsx-3475087559.modal-review > div > div.jsx-3475087559.modal-feed-scroll > div > div.jsx-1569223425.cardrv-content > div.jsx-2578519810.cardrv-coment-list-modal > div.jsx-2578519810.cardrv-coment-loadmore");
	
	public productdetail(RemoteWebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	
	public WebElement clickAddReview(){
		
		return driver.findElement(getAddReviewButton);
	}
	
	public WebElement findBreadcrumb(){
		
		return driver.findElement(breadcrumbProductDetail);
	}
	
	public WebElement findProductName(){
		
		return driver.findElement(getProductName);
	}
	
	public WebElement findBrandName(){
		
		return driver.findElement(getBrandName);
	}
	
	public WebElement clickBrandInRevDesc(){
		
		return driver.findElement(getBrandNameInReviewDetail);
	}
	
	
	public WebElement findReviewDesc(){
		
		return driver.findElement(getReviewDescButton);
	}
	
	//element review form
	public WebElement fillFieldReview(){
		
		return driver.findElement(getFieldReview);
	}
	
	public WebElement chooseRating(){
		
		return driver.findElement(getOverallRat4);
	}
	
	public WebElement chooseProductPrice(){
		
		return driver.findElement(getProductPriceExpensive);
	}
	
	public WebElement choosePackageQuality(){
		
		return driver.findElement(getPackageQuality);
	}
	
	public WebElement chooseRepurchaseThisProduct(){
		
		return driver.findElement(getPurchase);
	}
	
	public WebElement clickSubmitReview(){
		
		return driver.findElement(getButtonSubmitReview);
	}
	
	public WebElement getDetailDesc(){
		
		return driver.findElement(detailDesc);
	}
	
	public WebElement getReviewInPage3(){
		
		return driver.findElement(getCommentPage3);
	}
	
	//element review description
	public WebElement clickFilterHairProDet(){
		
		return driver.findElement(getBrandNameInReviewDetail);
	}
	
	//filter sort
	public WebElement clickSortProDett(){
		
		return driver.findElement(getSortButton);
	}
	
	public WebElement chooseSortOledest(){
		
		return driver.findElement(sortOldest);
	}
	
	public WebElement chooseMostLike(){
		
		return driver.findElement(mostLike);
	}
	
	//filter by skin
	public WebElement clickFilterBySkin(){
		
		return driver.findElement(getFilterSkinButton);
	}
	
	public WebElement chooseSkinOily(){
		
		return driver.findElement(getOily);
	}
	
	//filterby hair
	public WebElement clickFilterByHair(){
		
		return driver.findElement(getFilterHairButton);
	}
	
	public WebElement chooseWafy(){
		
		return driver.findElement(hairTypeWavy);
	}
	
	public WebElement chooseThick(){
		
		return driver.findElement(hairTextureThick);
	}
	
	//filterby age
	public WebElement clickFilterByAge(){
		
		return driver.findElement(getFilterAgeButton);
	}
	
	public WebElement chooseAge25till29(){
		
		return driver.findElement(age25till29);
	}
	
	public WebElement chooseAge30till34(){
		
		return driver.findElement(age30till34);
	}
	
	public WebElement clickComment(){
		
		return driver.findElement(getComment);
	}
	
	public WebElement clickCommentDouble(){
		
		return driver.findElement(getCommentDouble);
	}
	
	public WebElement clickAddComment(){
		
		return driver.findElement(getAddComment);
	}
	
	public WebElement findCommentField(){
		
		return driver.findElement(getCommentField);
	}
	
	public WebElement findNextCommentField(){
		
		return driver.findElement(getNextCommentField);
	}
	
	//post comment
	public WebElement clickPostComment(){
		
		return driver.findElement(getButtonPost);
	}
	
	public WebElement clickPostNextComment(){
		
		return driver.findElement(getButtonNextPost);
	}
	
	public WebElement clickCancelComment(){
		
		return driver.findElement(getButtonCancel);
	}
	
	public WebElement closeModal(){
		
		return driver.findElement(closeModalDesc);
	}
	
	public WebElement clickLoginProdDet(){
		
		return driver.findElement(clickloginProdDetail);
	}
	
	public WebElement clickLoadMoreCommentButton(){
		
		return driver.findElement(getLoadMoreCommentButton);
	}
	
	//pagination
	public WebElement clickPage3(){
		
		return driver.findElement(getPage3);
	}
	
	public WebElement clickPrevPageProdDet(){
		
		return driver.findElement(getPrevPageButton);
	}
	
	public WebElement clickNextPageProdDet(){
		
		return driver.findElement(getNextPageButton);
	}
	
	//reviewer profile
	public WebElement clickReviewerProdDet(){
		
		return driver.findElement(getReviewerButtonInReview);
	}
	
	public WebElement clickReviewerRevDesc(){
		
		return driver.findElement(getReviewerButtonInReviewDesc);
	}
	
	public WebElement clickNameReviewer(){
		
		return driver.findElement(getNameReviewer);
	}

	public WebElement clickNameReviewerRevDesc(){
	
	return driver.findElement(getNameReviewerRevDesc);
}

}