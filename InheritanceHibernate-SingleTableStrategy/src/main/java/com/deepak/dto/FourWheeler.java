/**
 * 
 */
package com.deepak.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Deepak.Kumar
 *
 */
@Entity
@DiscriminatorValue("CAR")                                                  // this gives the userdefined name to the Discriminator in DTYPE Column
public class FourWheeler extends Vehicle {
	
	private String steeringWheel;

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}
}
