package com.tencent.magicbrush.handler.a;

import com.tencent.magicbrush.handler.a.d.b;
import java.util.LinkedList;
import java.util.Queue;

public class d$a {
    public Queue<b> bnH = new LinkedList();

    public final b sD() {
        b bVar = (b) this.bnH.poll();
        if (bVar == null) {
            return new b();
        }
        return bVar;
    }

    public final void a(b bVar) {
        this.bnH.offer(bVar);
    }
}
