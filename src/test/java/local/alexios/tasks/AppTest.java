package local.alexios.tasks;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AppTest {
    App app = new App();

    @Test
    void decryptData_ShouldReturnIllegalArgumentException_WhenArrayPriceIsEmpty() {
        //Given
        int[] price = {};
        int discount = 40;
        int offset = 2;
        int readLength = 3;
        //Then
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            app.decryptData(price, discount, offset, readLength);
        });
        assertEquals("Array of prices is null or empty", thrown.getMessage());
    }

    @Test
    void decryptData_ShouldReturnIllegalArgumentException_WhenArrayPriceIsNull() {
        //Given
        int[] price = null;
        int discount = 40;
        int offset = 2;
        int readLength = 3;
        //Then
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            app.decryptData(price, discount, offset, readLength);
        });
        assertEquals("Array of prices is null or empty", thrown.getMessage());
    }

    @Test
    void decryptData_ShouldReturnIllegalArgumentException_WhenArrayPriceHasNegativeNumber() {
        //Given
        int[] price = {10, 20, 5, 100, 65, -1};
        int discount = 40;
        int offset = 2;
        int readLength = 3;
        //Then
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            app.decryptData(price, discount, offset, readLength);
        });
        assertEquals("Some number in an array is less than zero. Price can't be less than zero", thrown.getMessage());
    }

    @Test
    void decryptData_ShouldReturnIllegalArgumentException_WhenInputIntegersIsNegativeNumber() {
//Given
        int[] price = {10, 20, 5, 100, 65};
        int discount = -10000;
        int offset = 2;
        int readLength = 3;
        //Then
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            app.decryptData(price, discount, offset, readLength);
        });
        assertEquals("Integer can't be less than zero", thrown.getMessage());
    }

    @Test
    void decryptData_ShouldReturnIllegalArgumentException_WhenInputIntegersIsZero() {
        //Given
        int[] price = {10, 20, 5, 100, 65};
        int discount = 0;
        int offset = 2;
        int readLength = 0;
        //Then
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            app.decryptData(price, discount, offset, readLength);
        });
        assertEquals("This integer can't be less than one", thrown.getMessage());
    }

    @Test
    void decryptData_ShouldReturnIllegalArgumentException_WhenRequestedRangeIsMoreThanArrayLength() {
        //Given
        int[] price = {10, 20, 5, 100, 65};
        int discount = 40;
        int offset = 2;
        int readLength = 500;
        //Then
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            app.decryptData(price, discount, offset, readLength);
        });
        assertEquals("Quantity of position is more than array's length", thrown.getMessage());
    }

    @Test
    void decryptData_ShouldReturnLegalArray_WhenInputIsLegal() {
        //Given
        int[] price = {10, 20, 5, 100, 65};
        int discount = 40;
        int offset = 1;
        int readLength = 3;
        //When
        int[] expected = {12, 3, 60};
        int[] discounted = app.decryptData(price, discount, offset, readLength);
        //Then
        assertEquals(true, Arrays.equals(expected, discounted));
    }
}