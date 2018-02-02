package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.a.k;
import com.tencent.mm.bq.b;
import com.tencent.mm.plugin.backup.a.c;
import com.tencent.mm.plugin.backup.h.v;
import com.tencent.mm.plugin.backup.h.w;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends b {
    public v koB = new v();
    public w koC = new w();
    final int koD;
    final String koE;
    final byte[] koF;
    final String koG;

    public a(String str, String str2, byte[] bArr, String str3, int i, int i2) {
        x.i("MicroMsg.BackupAuthScene", "BackupAuthScene init, backupType[%d], stack:%s", new Object[]{Integer.valueOf(i2), bh.cgy()});
        this.koB.ksB = new b(k.b(str.getBytes(), bArr));
        this.koB.ktL = 0;
        this.koB.ID = str3;
        this.koB.ktM = i;
        this.koE = str2;
        this.koG = str3;
        this.koF = bArr;
        this.koD = i2;
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
            x.e("MicroMsg.BackupAuthScene", "onSceneEnd errType[%d]", new Object[]{Integer.valueOf(this.koC.ktm)});
            f(4, this.koC.ktm, "onSceneEnd status failed");
        } else if (this.koG.equals(this.koC.ID)) {
            String str = new String(k.a(this.koC.ksB.oz, this.koF));
            x.i("MicroMsg.BackupAuthScene", "onSceneEnd check ok result[%b]", new Object[]{Boolean.valueOf(str.length() != this.koE.length() ? false : str.equals(this.koE))});
            if (str.length() != this.koE.length() ? false : str.equals(this.koE)) {
                f(0, 0, "onSceneEnd auth success");
                if (this.koD != 22 || this.koC.ktM >= c.kit) {
                    this.koB.ksB = new b(k.b(this.koE.getBytes(), this.koF));
                    this.koB.ktL = 1;
                    this.koB.ID = this.koG;
                    try {
                        x.i("MicroMsg.BackupAuthScene", "directSendAuthOk");
                        b.o(this.koB.toByteArray(), 1, i);
                        return;
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.BackupAuthScene", e, "directSendAuthOk req to bur err.", new Object[0]);
                        return;
                    }
                }
                return;
            }
            x.e("MicroMsg.BackupAuthScene", "onSceneEnd check ok failed");
            f(4, -3, "onSceneEnd check ok failed");
        } else {
            x.e("MicroMsg.BackupAuthScene", "onSceneEnd not the same id");
            f(4, -1, "onSceneEnd not the same id");
        }
    }

    public final void o(boolean z, boolean z2) {
        v vVar;
        if (z) {
            vVar = this.koB;
            vVar.ktO |= c.kix;
        }
        vVar = this.koB;
        vVar.ktO |= c.kiy;
        vVar = this.koB;
        vVar.ktO |= c.kiz;
        if (z2) {
            vVar = this.koB;
            vVar.ktO |= c.kiA;
        }
    }
}
