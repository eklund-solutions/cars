package com.erik.car;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CarTests {
	@Test
	void isLicensePlateSwedishStandardTest() {
		
		Car Car = new Car();

		// Normal skylt i svensk standard
		Car.setLicensePlate("ABC123");		
		assertThat(Car.getIsLicensePlateSwedishStandard()).isEqualTo(true);

		// Felakta skyltar
		Car.setLicensePlate("123ABC");		
		assertThat(Car.getIsLicensePlateSwedishStandard()).isEqualTo(false);

		Car.setLicensePlate("AB0123");		
		assertThat(Car.getIsLicensePlateSwedishStandard()).isEqualTo(false);

		Car.setLicensePlate("ABCD2");		
		assertThat(Car.getIsLicensePlateSwedishStandard()).isEqualTo(false);

		Car.setLicensePlate("ABC1234");		
		assertThat(Car.getIsLicensePlateSwedishStandard()).isEqualTo(false);

		Car.setLicensePlate("MYRIDE");		
		assertThat(Car.getIsLicensePlateSwedishStandard()).isEqualTo(false);



	}
    
}
