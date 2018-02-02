package com.tencent.magicbrush.handler.a;

import java.util.LinkedList;
import java.util.Queue;

class g$a {
    Queue<k> bnW = new LinkedList();

    g$a() {
    }

    final k sE() {
        k kVar = (k) this.bnW.poll();
        if (kVar == null) {
            return new k();
        }
        return kVar;
    }
}
