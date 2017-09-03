package com.lxs.mms.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */
public class ObjectIdTest {
    @Test
    public void testGen() {
        ObjectId id = new ObjectId();
        Assert.assertNotNull(id);
    }
}
