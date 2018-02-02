package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.database.Cursor;
import com.tencent.mm.a.g;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.f;
import com.tencent.mm.ae.k;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.backup.bakoldlogic.c.c;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class d implements f {
    private boolean fvI = false;
    private Random gLH = new Random();
    private boolean hnr = false;
    List<String> kqI = new LinkedList();
    HashSet<String> kqJ = new HashSet();
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.d kqK;
    e kqL;
    boolean kqM = false;
    private long kqN;
    private long kqO;
    int kqP;
    int kqQ = 0;
    Object lock = new Object();

    public final void pause() {
        x.i("MicroMsg.BakPCServer", "pause");
        this.fvI = true;
    }

    public final void resume() {
        x.i("MicroMsg.BakPCServer", "resume");
        this.fvI = false;
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
    }

    public final void cancel() {
        x.i("MicroMsg.BakPCServer", "cancel");
        this.hnr = true;
        b.b(5, this.kqL);
        this.kqK = null;
        this.kqM = false;
        this.kqP = 0;
        synchronized (this.lock) {
            this.lock.notifyAll();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean l(String str, String str2, int i) {
        PLong pLong = new PLong();
        Cursor EG = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aqJ().aqK().Fa().EG(str);
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        if (EG.moveToFirst()) {
            LinkedList linkedList3 = linkedList;
            int i2 = i;
            while (!EG.isAfterLast()) {
                synchronized (this.lock) {
                    if (this.kqJ.size() > 10) {
                        try {
                            this.lock.wait();
                        } catch (InterruptedException e) {
                        }
                    }
                    if (this.fvI && !this.hnr) {
                        try {
                            this.lock.wait();
                        } catch (Throwable e2) {
                            x.printErrStackTrace("MicroMsg.BakPCServer", e2, "", new Object[0]);
                        }
                    }
                    if (this.hnr) {
                        x.i("MicroMsg.BakPCServer", "backupImp cancel");
                        EG.close();
                        return false;
                    }
                }
            }
            linkedList = linkedList3;
        }
        if (pLong.value > 0) {
            String a = a(this.gLH);
            c cVar = new c(a, 1, linkedList, "", this, a.aql().kiH);
            synchronized (this.lock) {
                cVar.apQ();
                this.kqJ.add(a);
                x.i("MicroMsg.BakPCServer", "backupChatMsg now: size:%d", new Object[]{Integer.valueOf(this.kqJ.size())});
            }
            pLong.value = 0;
            LinkedList linkedList4 = new LinkedList();
        }
        EG.close();
        return true;
        if (r3 != null) {
            linkedList3.add(r3);
        }
        Iterator it = linkedList2.iterator();
        while (it.hasNext()) {
            u uVar = (u) it.next();
            c cVar2 = new c(uVar.mediaId, 2, null, uVar.path, this, a.aql().kiH);
            synchronized (this.lock) {
                cVar2.apQ();
                this.kqJ.add(uVar.mediaId);
                x.i("MicroMsg.BakPCServer", "backupChatMsg now: size:%d", new Object[]{Integer.valueOf(this.kqJ.size())});
            }
        }
        linkedList2.clear();
        if (pLong.value > HardCoderJNI.ACTION_NET_TX) {
            x.d("MicroMsg.BakPCServer", "limitSize " + pLong.value);
            String a2 = a(this.gLH);
            cVar2 = new c(a2, 1, linkedList3, "", this, a.aql().kiH);
            synchronized (this.lock) {
                cVar2.apQ();
                this.kqJ.add(a2);
                x.i("MicroMsg.BakPCServer", "backupChatMsg now: size:%d", new Object[]{Integer.valueOf(this.kqJ.size())});
            }
            linkedList3 = new LinkedList();
            pLong.value = 0;
        }
        EG.moveToNext();
        i2 = r4;
    }

    final void aqs() {
        if (this.kqM && !this.hnr) {
            synchronized (this.lock) {
                if (this.kqJ.isEmpty()) {
                    a.aql().aqm().krc = 4;
                    a.aql().aqm().krd = 3;
                    b.b(5, this.kqL);
                    new com.tencent.mm.plugin.backup.bakoldlogic.c.b(5).apQ();
                    c aqn = a.aql().aqn();
                    aqn.kqE++;
                    if (this.kqK != null) {
                        this.kqK.aqz();
                    } else {
                        x.i("MicroMsg.BakPCServer", "operatorCallback is null");
                    }
                    cancel();
                    x.i("MicroMsg.BakPCServer", "send backup finish cmd");
                }
            }
        }
    }

    private static String a(Random random) {
        return g.s((bh.Wq() + random.nextDouble()).getBytes());
    }

    public final void a(int i, int i2, k kVar) {
        this.kqO += (long) i;
        int i3 = this.kqN == 0 ? 0 : (int) ((this.kqO * 100) / this.kqN);
        if (i3 > this.kqP) {
            this.kqP = i3;
            c.setProgress(this.kqP);
            if (!this.fvI && !this.hnr && this.kqK != null && this.kqP >= 0 && this.kqP <= 100) {
                this.kqK.mW(this.kqP);
            }
        }
    }
}
