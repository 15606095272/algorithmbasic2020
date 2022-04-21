package com.mashibing.jvm.chapter_02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linshijin
 * @date 2022/4/20 17:19
 * VM Args: -Xms20m -Xmx20m -XX: HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {

    public static class OOMObject {
        private int a;
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
