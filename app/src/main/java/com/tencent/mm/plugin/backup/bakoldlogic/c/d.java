package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.mm.a.e;
import com.tencent.mm.ae.f;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.h.ad;
import com.tencent.mm.plugin.backup.h.ae;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class d extends b {
    private static int progress;
    private int hlp;
    public String id;
    private byte[] key;
    private f krA = null;
    private ad krC = new ad();
    private ae krD = new ae();
    private String krE;
    private int offset = 0;
    private int start = 0;

    public d(String str, String str2, int i, int i2, f fVar, byte[] bArr) {
        if (i == 1) {
            this.krE = str + "backupItem/" + a.vn(str2);
        } else {
            this.krE = str + "backupMeida/" + a.vn(str2);
        }
        this.id = str2;
        this.krC.ktR = str2;
        this.krC.ktS = i;
        this.hlp = i2;
        x.i("MicroMsg.BakSceneRestoreData", "BakSceneRestoreData init, %s, type:%d, totalLen:%d", this.krC.ktR, Integer.valueOf(this.krC.ktS), Integer.valueOf(this.hlp));
        this.krA = fVar;
        this.key = bArr;
    }

    public final boolean apQ() {
        int i;
        long j = 524288;
        x.i("MicroMsg.BakSceneRestoreData", "doSecne");
        int i2 = this.hlp;
        if (this.krC.ktS == 2) {
            if (((long) (this.hlp - this.offset)) <= 524288) {
                j = (long) (this.hlp - this.offset);
            }
            i = (int) j;
        } else {
            i = i2;
        }
        this.start = this.offset;
        this.offset = i + this.start;
        this.krC.ktU = this.start;
        this.krC.ktV = this.offset;
        this.krC.ktX = progress;
        return super.apQ();
    }

    public static void setProgress(int i) {
        x.i("MicroMsg.BakSceneRestoreData", "setProgress %d", Integer.valueOf(i));
        progress = i;
    }

    public final com.tencent.mm.bq.a apH() {
        return this.krD;
    }

    public final com.tencent.mm.bq.a apI() {
        return this.krC;
    }

    public final void mL(int i) {
        x.i("MicroMsg.BakSceneRestoreData", "onSceneEnd id:%s, type:%d, s:%d, e:%d, status:%d", this.krD.ktR, Integer.valueOf(this.krD.ktS), Integer.valueOf(this.krD.ktU), Integer.valueOf(this.krD.ktV), Integer.valueOf(this.krD.ktm));
        if (this.krD.ktm != 0 && this.krD.ktm != 10) {
            f(4, this.krD.ktm, "error");
        } else if (this.krD.ktU == this.start && this.krD.ktV == this.offset) {
            byte[] aesCryptEcb;
            this.krA.a(this.krC.ktV - this.krC.ktU, this.hlp, this);
            byte[] bArr = this.krD.ksB.oz;
            if (this.key != null) {
                aesCryptEcb = AesEcb.aesCryptEcb(bArr, this.key, false, this.offset == this.hlp);
            } else {
                aesCryptEcb = bArr;
            }
            String str = this.krE;
            String str2 = this.id;
            File file = new File(str + str2);
            long length = file.exists() ? file.length() : 0;
            e.a(str, str2, aesCryptEcb);
            File file2 = new File(str + str2);
            if (length == (file2.exists() ? file2.length() : 0)) {
                x.e("MicroMsg.BakSceneRestoreData", "append failed and try again:%s", str + str2);
                e.a(str, str2, aesCryptEcb);
            }
            str = "MicroMsg.BakSceneRestoreData";
            String str3 = "onSceneEnd appendbuf len:%d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(aesCryptEcb == null ? 0 : aesCryptEcb.length);
            x.i(str, str3, objArr);
            if (this.offset == this.hlp) {
                x.i("MicroMsg.BakSceneRestoreData", "recover cmoplete:%s  %d", this.id, Integer.valueOf(this.hlp));
                f(0, 0, "success");
                return;
            }
            apQ();
        } else {
            x.e("MicroMsg.BakSceneRestoreData", "err local:%d, %d;   server:%d,%d", Integer.valueOf(this.start), Integer.valueOf(this.offset), Integer.valueOf(this.krD.ktU), Integer.valueOf(this.krD.ktV));
            f(3, -1, "error");
        }
    }

    public final int getType() {
        return 7;
    }
}
