package com.tencent.mm.plugin.clean.c.a;

import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public final class b implements c {
    public HashMap<Long, af> lfN;
    private HashSet<Long> lfO;

    public b() {
        this((byte) 0);
    }

    private b(byte b) {
        this.lfO = new HashSet(5);
        this.lfN = new HashMap(5);
        for (int i = 0; i <= 5; i++) {
            e.d(new 1(this), "ThreadController_handler", 1).start();
        }
    }

    public final synchronized boolean b(a aVar) {
        boolean z;
        aVar.lfM = this;
        x.d("MicroMsg.ThreadController", "running threads %s", new Object[]{this.lfO.toString()});
        for (Entry entry : this.lfN.entrySet()) {
            if (!this.lfO.contains(entry.getKey())) {
                ((af) entry.getValue()).post(aVar);
                this.lfO.add(entry.getKey());
                z = true;
                break;
            }
        }
        z = false;
        return z;
    }

    private synchronized void e(Long l) {
        if (this.lfO.remove(l)) {
            x.d("MicroMsg.ThreadController", "thread is idle, id=%d", new Object[]{l});
        }
    }

    public final void f(Long l) {
        e(l);
    }
}
