package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Set;

public final class f {
    private Object lock = new Object();
    private Set<String> ock = new HashSet();

    public final boolean DT(String str) {
        boolean z = false;
        synchronized (this.lock) {
            if (this.ock.contains(str)) {
                x.i("MicroMsg.LuckyMoneyMsg", "has contains msg, %s", new Object[]{str});
            } else {
                z = this.ock.add(str);
            }
        }
        return z;
    }

    public final void DU(String str) {
        synchronized (this.lock) {
            this.ock.remove(str);
        }
    }
}
