package com.tencent.mm.by;

import android.content.ContentValues;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class i {
    private ak fhK = new ak(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ak.a(this) {
        final /* synthetic */ i xBD;

        {
            this.xBD = r1;
        }

        public final boolean uF() {
            if (this.xBD.xBi.isOpen()) {
                this.xBD.ckW();
            }
            return false;
        }
    }, false);
    private BlockingQueue<a> xBC = new LinkedBlockingQueue();
    h xBi;
    private String xjD = null;

    public static class a {
        public ContentValues values;
        public String xBE;
        public String[] xBF;
        public int xhD;
        public String xjB;
        public String xjz;

        public final void J(String[] strArr) {
            if (strArr != null && strArr.length > 0) {
                this.xBF = new String[strArr.length];
                for (int i = 0; i < strArr.length; i++) {
                    this.xBF[i] = new String(strArr[i]);
                }
            }
        }
    }

    public i(h hVar, String str) {
        this.xBi = hVar;
        this.xjD = str;
    }

    public final int ckW() {
        x.d("MicroMsg.MemoryStorage.Holder", "appendAllToDisk table:%s trans:%b queue:%d", this.xjD, Boolean.valueOf(this.xBi.inTransaction()), Integer.valueOf(this.xBC.size()));
        if (!this.xBC.isEmpty()) {
            long j;
            if (this.xBi.inTransaction()) {
                j = 0;
            } else {
                j = this.xBi.dz(Thread.currentThread().getId());
            }
            while (!this.xBC.isEmpty()) {
                a aVar = (a) this.xBC.poll();
                if (aVar == null) {
                    x.w("MicroMsg.MemoryStorage.Holder", "appendToDisk Holder == null. table:%s", this.xjD);
                } else if (this.xBi == null || !this.xBi.isOpen()) {
                    x.e("MicroMsg.MemoryStorage.Holder", "appendToDisk diskDB already close. table:%s", this.xjD);
                } else if (aVar.xhD == 2) {
                    this.xBi.insert(this.xjD, aVar.xjz, aVar.values);
                } else if (aVar.xhD == 5) {
                    this.xBi.delete(this.xjD, aVar.xBE, aVar.xBF);
                } else if (aVar.xhD == 1) {
                    this.xBi.fx(this.xjD, aVar.xjB);
                } else if (aVar.xhD == 4) {
                    this.xBi.replace(this.xjD, aVar.xjz, aVar.values);
                } else if (aVar.xhD == 3) {
                    this.xBi.update(this.xjD, aVar.values, aVar.xBE, aVar.xBF);
                }
            }
            if (j > 0) {
                this.xBi.fS(j);
            }
        }
        return 0;
    }

    final int a(a aVar) {
        this.xBC.add(aVar);
        if (this.xBC.size() >= 40) {
            ckW();
        }
        if (this.fhK.cfK()) {
            this.fhK.J(60000, 60000);
        }
        return 0;
    }
}
