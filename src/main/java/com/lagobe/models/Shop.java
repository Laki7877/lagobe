package com.lagobe.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="shop")
public class Shop extends AbstractModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="shop_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long shopId;

	@Column(name="store_name",length=100)
	private String storeName;

	@Column(name="website",length=100)
	private String website;

	@Column(name="facebook",length=100)
	private String facebook;

	@Column(name="pickup_address",length=255)
	private String pickupAddress;

	@Column(name="document_address",length=255)
	private String documentAddress;

	@Column(name="bank_account_number",length=20)
	private String bankAccountNumber;

	@Column(name="bank_name",length=100)
	private String bankName;

	@Column(name="bank_account_name",length=100)
	private String bankAccountName;

	@Column(name="commission")
	private Double commission;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "owner_id")
	private User owner;
    
    @JoinColumn(name = "is_company")
    private Boolean isCompany;
    
    @Column(name="citizen_id",length=20)
	private String citizenId;
    
    @Column(name="company_tax_id",length=20)
	private String companyTaxId;
    
    @Column(name="invoice_name",length=100)
	private String invoiceName;
    
    
    @OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="citizen_img_id")
	private Resource citizenImg;
    
    @OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="house_register_img_id")
	private Resource houseRegisterImg;
    
	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getPickupAddress() {
		return pickupAddress;
	}

	public void setPickupAddress(String pickupAddress) {
		this.pickupAddress = pickupAddress;
	}

	public String getDocumentAddress() {
		return documentAddress;
	}

	public void setDocumentAddress(String documentAddress) {
		this.documentAddress = documentAddress;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAccountName() {
		return bankAccountName;
	}

	public void setBankAccountName(String bankAccountName) {
		this.bankAccountName = bankAccountName;
	}

	public Double getCommission() {
		return commission;
	}

	public void setCommission(Double commission) {
		this.commission = commission;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Boolean getIsCompany() {
		return isCompany;
	}

	public void setIsCompany(Boolean isCompany) {
		this.isCompany = isCompany;
	}

	public String getCitizenId() {
		return citizenId;
	}

	public void setCitizenId(String citizenId) {
		this.citizenId = citizenId;
	}

	public String getCompanyTaxId() {
		return companyTaxId;
	}

	public void setCompanyTaxId(String companyTaxId) {
		this.companyTaxId = companyTaxId;
	}

	public String getInvoiceName() {
		return invoiceName;
	}

	public void setInvoiceName(String invoiceName) {
		this.invoiceName = invoiceName;
	}

	public Resource getCitizenImg() {
		return citizenImg;
	}

	public void setCitizenImg(Resource citizenImg) {
		this.citizenImg = citizenImg;
	}

	public Resource getHouseRegisterImg() {
		return houseRegisterImg;
	}

	public void setHouseRegisterImg(Resource houseRegisterImg) {
		this.houseRegisterImg = houseRegisterImg;
	}
	
}
