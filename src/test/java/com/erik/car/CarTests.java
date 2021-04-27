package com.erik.car;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CarTests {
	@Test
	void isLicensePlateSwedishStandardTest() {
		
		Car car = new Car();

		// Normal skylt i svensk standard
		car.setLicensePlate("ABC123");		
		assertThat(car.getIsLicensePlateSwedishStandard()).isEqualTo(true);

		// Felakta skyltar
		car.setLicensePlate("123ABC");		
		assertThat(car.getIsLicensePlateSwedishStandard()).isEqualTo(false);

		car.setLicensePlate("AB0123");		
		assertThat(car.getIsLicensePlateSwedishStandard()).isEqualTo(false);

		car.setLicensePlate("ABCD2");		
		assertThat(car.getIsLicensePlateSwedishStandard()).isEqualTo(false);

		car.setLicensePlate("ABC1234");		
		assertThat(car.getIsLicensePlateSwedishStandard()).isEqualTo(false);

		car.setLicensePlate("MYRIDE");		
		assertThat(car.getIsLicensePlateSwedishStandard()).isEqualTo(false);



	}
    
}
