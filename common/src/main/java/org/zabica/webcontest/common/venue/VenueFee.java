package org.zabica.webcontest.common.venue;

import java.io.Serializable;
import java.math.BigDecimal;

public class VenueFee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4927301034359523604L;

	private String type;
	private BigDecimal price;
	private String description;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
