package com.iiht.training.eloan.model;

public class SanctionDto {
	private Double loanAmountSanctioned;
	private Double termOfLoan;
	private String paymentStartDate;
	public Double getLoanAmountSanctioned() {
		return loanAmountSanctioned;
	}
	public void setLoanAmountSanctioned(Double loanAmountSanctioned) {
		this.loanAmountSanctioned = loanAmountSanctioned;
	}
	public Double getTermOfLoan() {
		return termOfLoan;
	}
	public void setTermOfLoan(Double termOfLoan) {
		this.termOfLoan = termOfLoan;
	}
	public String getPaymentStartDate() {
		return paymentStartDate;
	}
	public void setPaymentStartDate(String paymentStartDate) {
		this.paymentStartDate = paymentStartDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((loanAmountSanctioned == null) ? 0 : loanAmountSanctioned.hashCode());
		result = prime * result + ((paymentStartDate == null) ? 0 : paymentStartDate.hashCode());
		result = prime * result + ((termOfLoan == null) ? 0 : termOfLoan.hashCode());
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
		SanctionDto other = (SanctionDto) obj;
		if (loanAmountSanctioned == null) {
			if (other.loanAmountSanctioned != null)
				return false;
		} else if (!loanAmountSanctioned.equals(other.loanAmountSanctioned))
			return false;
		if (paymentStartDate == null) {
			if (other.paymentStartDate != null)
				return false;
		} else if (!paymentStartDate.equals(other.paymentStartDate))
			return false;
		if (termOfLoan == null) {
			if (other.termOfLoan != null)
				return false;
		} else if (!termOfLoan.equals(other.termOfLoan))
			return false;
		return true;
	}
	
	
}
