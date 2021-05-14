package com.tracholar.temp;

import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author zuoyuan
 * @version 1.0
 * @date 2019/11/21 下午1:21
 */
public class TestNothing {
    @Test
    public void test() throws Exception{
        /* 测试其他jar包加载
        */
        String clsName = "com.sankuai.nlpml.airec.copywriting.common.AutoLoadUtil";
        File file = new File(
                "/Users/zuoyuan/Documents/code/copywriting-service/target/copywriting-service-0.0.1-SNAPSHOT.jar");
        ClassLoader classLoader =
                new URLClassLoader(
                        new URL[] {
                                    file.toURI().toURL()
                        });

        Object obj = classLoader.loadClass("com.sankuai.nlpml.airec.copywriting.render.params.Cat1NameParam").newInstance();
        System.out.println(obj);



        classLoader.loadClass(clsName).newInstance();
    }
}
