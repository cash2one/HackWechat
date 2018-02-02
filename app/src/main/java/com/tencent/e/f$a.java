package com.tencent.e;

import com.tencent.e.b.c;
import java.util.HashMap;

class f$a {
    private final HashMap<String, Object> AmE = new HashMap();
    final /* synthetic */ f AmF;
    private final Object mLock = new Object();

    f$a(f fVar) {
        this.AmF = fVar;
    }

    final void ge(String str, String str2) {
        String str3 = str + str2;
        synchronized (this.mLock) {
            while (this.AmE.get(str3) != null) {
                try {
                    this.mLock.wait();
                } catch (InterruptedException e) {
                    throw new c("install fail,lock interrupted!");
                }
            }
            this.AmE.put(str3, str2);
        }
    }

    final void gf(String str, String str2) {
        String str3 = str + str2;
        synchronized (this.mLock) {
            this.AmE.remove(str3);
            this.mLock.notifyAll();
        }
    }
}
