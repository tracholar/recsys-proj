package com.tracholar.recommend.feature;

import org.junit.Test;

public class TestUtils {
    @Test
    public void test1(){
        int fid = Utils.getFid("profile");
        int id = Utils.getFid("age");
        long idx = Utils.getFid(fid, "age");
        int fid2 = Utils.getFieldId(idx);
        int id2 = Utils.getId(idx);

        System.out.println();
    }
}
