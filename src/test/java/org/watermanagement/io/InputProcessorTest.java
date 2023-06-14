package org.watermanagement.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.watermanagement.io.utils.WaterManagementFeature;

import java.io.IOException;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class InputProcessorTest {

    @Mock
    WaterManagementFeature waterManagementFeature;

    @Test
    void shouldReadInputFromFileAndRunAllCommand() throws IOException {
        InputProcessor inputProcessor = new InputProcessor(waterManagementFeature);
        inputProcessor
                .parse("src/test/resources/input.txt")
                .forEach(Runnable::run);

        verify(waterManagementFeature, times(1)).allocateWater("ALLOT_WATER 3 2:1");
        verify(waterManagementFeature, times(1)).addGuests("ADD_GUESTS 4");
        verify(waterManagementFeature, times(1)).addGuests("ADD_GUESTS 1");
        verify(waterManagementFeature, times(1)).calculateBill("BILL");
    }
}