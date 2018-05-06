package de.et833.demo.junit;

import static org.mockito.ArgumentMatchers.anyString;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import de.et833.demo.model.Storage;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    @Mock
    private Storage storageService;

    @Before
    public void init() {
        Mockito.doThrow(new IllegalStateException())
                .when(storageService)
                .write(anyString());
    }

    @Test(expected = IllegalStateException.class)
    public void test_storage_throwException_onWrite() {
        storageService.write("Hell Yeah!");
    }
}
