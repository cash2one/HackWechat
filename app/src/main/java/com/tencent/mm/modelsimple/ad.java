package com.tencent.mm.modelsimple;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bfp;
import com.tencent.mm.protocal.z.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.wcdb.FileUtils;
import junit.framework.Assert;

public final class ad extends k implements com.tencent.mm.network.k {
    private e gJT;
    private final q hnp;

    public ad(int i, String str) {
        this(i, str, "");
    }

    public ad(int i, String str, String str2) {
        this.hnp = new e();
        a aVar = (a) this.hnp.Kb();
        aVar.vBU.ksU = com.tencent.mm.z.q.FS();
        bfp com_tencent_mm_protocal_c_bfp = aVar.vBU;
        StringBuilder stringBuilder = new StringBuilder();
        if (i == 0) {
            i = 64;
        }
        stringBuilder = stringBuilder.append(i).append(";");
        if (str == null) {
            str = "";
        }
        com_tencent_mm_protocal_c_bfp.nje = stringBuilder.append(str).toString();
        x.d("MicroMsg.NetSceneSendCard", "content:" + aVar.vBU.nje);
        Assert.assertTrue("empty sendcard", true);
        aVar.vBU.wBg = 64;
        if (str2 != null && str2.length() > 0) {
            aVar.vBU.wKB = str2;
        }
    }

    public ad(String str) {
        this.hnp = new e();
        a aVar = (a) this.hnp.Kb();
        aVar.vBU.ksU = com.tencent.mm.z.q.FS();
        aVar.vBU.nje = str;
        x.d("MicroMsg.NetSceneSendCard", "content:" + str);
        bfp com_tencent_mm_protocal_c_bfp = aVar.vBU;
        ar.Hg();
        com_tencent_mm_protocal_c_bfp.wmY = bh.e((Integer) c.CU().get(66561, null));
        Assert.assertTrue("empty sendcard", true);
        aVar.vBU.wBg = FileUtils.S_IWUSR;
    }

    public ad(String str, boolean z, boolean z2) {
        int i;
        this.hnp = new e();
        a aVar = (a) this.hnp.Kb();
        aVar.vBU.ksU = com.tencent.mm.z.q.FS();
        aVar.vBU.nje = str;
        x.d("MicroMsg.NetSceneSendCard", "content:" + str);
        bfp com_tencent_mm_protocal_c_bfp = aVar.vBU;
        ar.Hg();
        com_tencent_mm_protocal_c_bfp.wmY = bh.e((Integer) c.CU().get(66561, null));
        int i2 = ((z ? 1 : 0) | 0) | 0;
        if (z2) {
            i = 4;
        } else {
            i = 0;
        }
        i = (i | i2) | 8;
        Assert.assertTrue("empty sendcard", true);
        aVar.vBU.wBg = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hnp, this);
    }

    public final int getType() {
        return 26;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.gJT.a(i2, i3, qVar.Hp().vBr, this);
    }
}
