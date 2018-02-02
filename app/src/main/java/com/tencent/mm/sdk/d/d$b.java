package com.tencent.mm.sdk.d;

import android.os.Message;
import com.tencent.mm.sdk.d.d.a;
import java.util.Vector;

class d$b {
    private int mCount;
    private Vector<a> xja;
    private int xjb;
    private int xjc;
    private boolean xjd;

    private d$b() {
        this.xja = new Vector();
        this.xjb = 20;
        this.xjc = 0;
        this.mCount = 0;
        this.xjd = false;
    }

    final synchronized boolean cgI() {
        return this.xjd;
    }

    final synchronized void cleanup() {
        this.xja.clear();
    }

    final synchronized void b(d dVar, Message message, String str, a aVar, a aVar2, a aVar3) {
        this.mCount++;
        if (this.xja.size() < this.xjb) {
            this.xja.add(new a(dVar, message, str, aVar, aVar2, aVar3));
        } else {
            a aVar4 = (a) this.xja.get(this.xjc);
            this.xjc++;
            if (this.xjc >= this.xjb) {
                this.xjc = 0;
            }
            aVar4.a(dVar, message, str, aVar, aVar2, aVar3);
        }
    }
}
