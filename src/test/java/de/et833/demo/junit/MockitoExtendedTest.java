package de.et833.demo.junit;

import static org.mockito.ArgumentMatchers.anyString;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import de.et833.demo.model.Storage;

/**
 * http://www.baeldung.com/mockito-junit-5-extension
 */
@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
public class MockitoExtendedTest {

    @Mock
    private Storage storageService;

    @BeforeEach
    public void init() {
        Mockito.doThrow(new IllegalStateException())
                .when(storageService)
                .write(anyString());
    }

    @Test
    public void test_storage_throwException_onWrite() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            storageService.write("Hell Yeah!");
        });
    }
}
