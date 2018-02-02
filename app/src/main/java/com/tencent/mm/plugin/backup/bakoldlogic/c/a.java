package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.mm.a.k;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.h.v;
import com.tencent.mm.plugin.backup.h.w;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends b {
    final byte[] key;
    final int kiF;
    private v koB = new v();
    private w koC = new w();
    final String krv;
    final String krw;
    private boolean krx = false;

    public a(String str, String str2, byte[] bArr, String str3) {
        x.i("MicroMsg.BakOldAuthScene", "summerbak init id:%s,  hello:%s, ok:%s, stack[%s]", new Object[]{str3, str, str2, bh.cgy()});
        this.koB.ksB = new com.tencent.mm.bq.b(k.b(str.getBytes(), bArr));
        this.koB.ktL = 0;
        this.koB.ID = str3;
        this.koB.ktM = 0;
        this.krv = str2;
        this.krw = str3;
        this.key = bArr;
        this.kiF = -1;
    }

    public final int getType() {
        return 1;
    }

    public final com.tencent.mm.bq.a apH() {
        return this.koC;
    }

    public final com.tencent.mm.bq.a apI() {
        return this.koB;
    }

    public final void mL(int i) {
        if (this.koC.ktm != 0) {
            x.e("MicroMsg.BakOldAuthScene", "errType %d", new Object[]{Integer.valueOf(this.koC.ktm)});
            f(4, this.koC.ktm, "not not success");
        } else if (this.krw.equals(this.koC.ID)) {
            String str = new String(k.a(this.koC.ksB.oz, this.key));
            this.krx = str.length() != this.krv.length() ? false : str.equals(this.krv);
            x.i("MicroMsg.BakOldAuthScene", "check ok result:%b", new Object[]{Boolean.valueOf(this.krx)});
            if (this.krx) {
                f(0, 0, "auth ok");
                this.koB.ksB = new com.tencent.mm.bq.b(k.b(this.krv.getBytes(), this.key));
                this.koB.ktL = 1;
                this.koB.ID = this.krw;
                try {
                    x.i("MicroMsg.BakOldAuthScene", "directSendAuthOk");
                    b.o(this.koB.toByteArray(), 1, i);
                    return;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.BakOldAuthScene", e, "directSendAuthOk req to bur err.", new Object[0]);
                    return;
                }
            }
            x.e("MicroMsg.BakOldAuthScene", "check ok failed");
            f(4, 1, "not ok packet");
        } else {
            x.e("MicroMsg.BakOldAuthScene", "not the same id");
            f(4, -1, "not the same id");
        }
    }
}
