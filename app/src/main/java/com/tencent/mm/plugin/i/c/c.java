package com.tencent.mm.plugin.i.c;

import android.database.Cursor;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.plugin.i.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;

public final class c implements Runnable {
    private int asN;
    public boolean isStop;
    private String kIb;
    private long kIc;
    private a kId;

    public c(String str, long j, int i, a aVar) {
        this.kIb = str;
        this.kIc = j;
        this.asN = i;
        this.kId = aVar;
        x.d("MicroMsg.ScanMsgTask", "%d scan msg[%d %d]", new Object[]{Integer.valueOf(hashCode()), Long.valueOf(this.kIc), Integer.valueOf(this.asN)});
    }

    public final void run() {
        int i = 0;
        if (!this.isStop) {
            long Wq = bh.Wq();
            Cursor cursor = null;
            try {
                ar.Hg();
                cursor = com.tencent.mm.z.c.Fa().d(this.kIb, this.kIc, this.asN);
                Wq = bh.bA(Wq);
                b.asG();
                b.p(this.asN, Wq);
                while (cursor.moveToNext()) {
                    i++;
                    cf auVar = new au();
                    auVar.b(cursor);
                    b.asG().H(auVar);
                    b.asG().bO(auVar.field_msgId);
                    if (this.isStop) {
                        if (cursor != null) {
                            cursor.close();
                            return;
                        }
                        return;
                    }
                }
                x.d("MicroMsg.ScanMsgTask", "%d scan msg count[%d] limit[%d]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(this.asN)});
                if (i < this.asN) {
                    b asG = b.asG();
                    b.asG();
                    asG.bO(b.asI());
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ScanMsgTask", e, "", new Object[0]);
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
            if (this.kId != null) {
                this.kId.finish();
            }
        }
    }
}
