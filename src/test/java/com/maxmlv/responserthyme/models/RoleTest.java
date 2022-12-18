package com.maxmlv.responserthyme.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RoleTest {
    /**
     * Method under test: {@link Role#getAuthority()}
     */
    @Test
    void testGetAuthority() {
        assertEquals("USER", Role.USER.getAuthority());
    }
}

