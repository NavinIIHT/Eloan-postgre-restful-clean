package com.iiht.training.eloan.model;

public class ProcessingDto {
	private Double acresOfLand;
	private Double landValue;
	private String appraisedBy;
	private String valuationDate;
	private String addressOfProperty;
	private Double suggestedAmountOfLoan;
	public Double getAcresOfLand() {
		return acresOfLand;
	}
	public void setAcresOfLand(Double acresOfLand) {
		this.acresOfLand = acresOfLand;
	}
	public Double getLandValue() {
		return landValue;
	}
	public void setLandValue(Double landValue) {
		this.landValue = landValue;
	}
	public String getAppraisedBy() {
		return appraisedBy;
	}
	public void setAppraisedBy(String appraisedBy) {
		this.appraisedBy = appraisedBy;
	}
	public String getValuationDate() {
		return valuationDate;
	}
	public void setValuationDate(String valuationDate) {
		this.valuationDate = valuationDate;
	}
	public String getAddressOfProperty() {
		return addressOfProperty;
	}
	public void setAddressOfProperty(String addressOfProperty) {
		this.addressOfProperty = addressOfProperty;
	}
	public Double getSuggestedAmountOfLoan() {
		return suggestedAmountOfLoan;
	}
	public void setSuggestedAmountOfLoan(Double suggestedAmountOfLoan) {
		this.suggestedAmountOfLoan = suggestedAmountOfLoan;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acresOfLand == null) ? 0 : acresOfLand.hashCode());
		result = prime * result + ((addressOfProperty == null) ? 0 : addressOfProperty.hashCode());
		result = prime * result + ((appraisedBy == null) ? 0 : appraisedBy.hashCode());
		result = prime * result + ((landValue == null) ? 0 : landValue.hashCode());
		result = prime * result + ((suggestedAmountOfLoan == null) ? 0 : suggestedAmountOfLoan.hashCode());
		result = prime * result + ((valuationDate == null) ? 0 : valuationDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProcessingDto other = (ProcessingDto) obj;
		if (acresOfLand == null) {
			if (other.acresOfLand != null)
				return false;
		} else if (!acresOfLand.equals(other.acresOfLand))
			return false;
		if (addressOfProperty == null) {
			if (other.addressOfProperty != null)
				return false;
		} else if (!addressOfProperty.equals(other.addressOfProperty))
			return false;
		if (appraisedBy == null) {
			if (other.appraisedBy != null)
				return false;
		} else if (!appraisedBy.equals(other.appraisedBy))
			return false;
		if (landValue == null) {
			if (other.landValue != null)
				return false;
		} else if (!landValue.equals(other.landValue))
			return false;
		if (suggestedAmountOfLoan == null) {
			if (other.suggestedAmountOfLoan != null)
				return false;
		} else if (!suggestedAmountOfLoan.equals(other.suggestedAmountOfLoan))
			return false;
		if (valuationDate == null) {
			if (other.valuationDate != null)
				return false;
		} else if (!valuationDate.equals(other.valuationDate))
			return false;
		return true;
	}
	
	
}
