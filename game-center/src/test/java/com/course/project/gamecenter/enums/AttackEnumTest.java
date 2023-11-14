package com.course.project.gamecenter.enums;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@Slf4j
@SpringBootTest
public class AttackEnumTest {
    @Test
    public void testGetEnumById() {
        assertEquals(AttackEnum.DO_NOT_ATTACK, AttackEnum.getEnumById(0));
        assertEquals(AttackEnum.SHELTERING, AttackEnum.getEnumById(1));
        assertEquals(AttackEnum.ESCAPING, AttackEnum.getEnumById(2));
        assertEquals(AttackEnum.FIGHTING_BACK, AttackEnum.getEnumById(3));
        assertNull(AttackEnum.getEnumById(4)); // Assuming no such id exists
    }

    @Test
    public void testEnumValues() {
        assertEquals(Integer.valueOf(0), AttackEnum.DO_NOT_ATTACK.getId());
        assertEquals("DO_NOT_ATTACK", AttackEnum.DO_NOT_ATTACK.getDesc());

        assertEquals(Integer.valueOf(1), AttackEnum.SHELTERING.getId());
        assertEquals("SHELTERING", AttackEnum.SHELTERING.getDesc());

        assertEquals(Integer.valueOf(2), AttackEnum.ESCAPING.getId());
        assertEquals("ESCAPING", AttackEnum.ESCAPING.getDesc());

        assertEquals(Integer.valueOf(3), AttackEnum.FIGHTING_BACK.getId());
        assertEquals("FIGHTING_BACK", AttackEnum.FIGHTING_BACK.getDesc());
    }

    @Test
    public void testSettersAndGetters() {
        // Typically, enums do not have setters as they represent constant values.
        // However, testing here since setters are provided.
        AttackEnum attackEnum = AttackEnum.DO_NOT_ATTACK;
        attackEnum.setId(10);
        attackEnum.setDesc("TEST_DESC");

        assertEquals(Integer.valueOf(10), attackEnum.getId());
        assertEquals("TEST_DESC", attackEnum.getDesc());
    }
}