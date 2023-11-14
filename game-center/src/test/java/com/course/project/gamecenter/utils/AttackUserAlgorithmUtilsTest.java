package com.course.project.gamecenter.utils;

import com.course.project.gamecenter.enums.AttackEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

@Slf4j
@SpringBootTest
public class AttackUserAlgorithmUtilsTest {
    @Test
    public void testGetAttackMethodReturnsValidEnum() {
        AttackUserAlgorithmUtils utils = new AttackUserAlgorithmUtils();

        // Test multiple times to account for random behavior
        for (int i = 0; i < 100; i++) {
            AttackEnum result = utils.getAttackMethod(1L, 1, 100L, 200L, Collections.singletonList(1));
            assertNotNull(result);
            assertTrue(Arrays.asList(AttackEnum.values()).contains(result));
        }
    }
}