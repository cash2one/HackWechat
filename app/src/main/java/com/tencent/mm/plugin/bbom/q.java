package com.tencent.mm.plugin.bbom;

import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.am;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class q implements r {
    private static List<am> kvI = new ArrayList();
    private boolean kvJ;
    private boolean kvK;
    private List<au> kvL;

    public static void a(am amVar) {
        synchronized (kvI) {
            if (!kvI.contains(amVar)) {
                kvI.add(amVar);
            }
        }
    }

    public static void b(am amVar) {
        synchronized (kvI) {
            kvI.remove(amVar);
        }
    }

    public q() {
        this(false);
    }

    public q(boolean z) {
        this.kvJ = false;
        this.kvK = false;
        this.kvL = new LinkedList();
        this.kvJ = z;
        this.kvK = false;
        this.kvL = new LinkedList();
    }

    public final void are() {
        List linkedList = new LinkedList();
        linkedList.addAll(this.kvL);
        this.kvL.clear();
        if (linkedList.size() != 0) {
            List<am> arrayList = new ArrayList();
            synchronized (kvI) {
                for (am add : kvI) {
                    arrayList.add(add);
                }
            }
            for (am add2 : arrayList) {
                new af(add2.getLooper()).post(new 1(this, add2, linkedList));
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(final au auVar, final bw bwVar) {
        if (this.kvJ) {
            x.i("MicroMsg.SyncMessageNotifier", "mDummy is true, do nothing and return.");
            return;
        }
        synchronized (kvI) {
            if (kvI.isEmpty()) {
                x.i("MicroMsg.SyncMessageNotifier", "no notifiers, ignore");
            }
        }
    }
}
