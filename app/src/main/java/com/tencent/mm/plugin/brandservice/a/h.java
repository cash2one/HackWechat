package com.tencent.mm.plugin.brandservice.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ben;
import com.tencent.mm.protocal.c.beo;
import com.tencent.mm.protocal.c.je;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends k implements com.tencent.mm.network.k {
    private String fod;
    private e gJT;
    private String iRN;
    private b kEK;
    private beo kEL;
    private long kEM;
    private int offset;
    private int scene;

    public h(String str, long j, int i, int i2, String str2) {
        this.fod = str;
        this.kEM = j;
        this.offset = i;
        this.scene = i2;
        this.iRN = str2;
        x.i("MicroMsg.NetSceneSearchDetailPageNew", "Constructors: keyword = (%s) , LSB exist () , businessType is (%d) , offset is (%d) , scene is (%d), searchId(%s).", new Object[]{str, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str2});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneSearchDetailPageNew", "netId (%d) , errType (%d) , errCode (%d) , errMsg (%s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0 && this.kEK != null) {
            this.kEL = (beo) this.kEK.hmh.hmo;
        }
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1071;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        if (bh.ov(this.fod)) {
            x.e("MicroMsg.NetSceneSearchDetailPageNew", "keyword is unavailable.");
            return -1;
        }
        a aVar = new a();
        aVar.hmi = 1071;
        aVar.uri = "/cgi-bin/mmbiz-bin/bizsearch/detailpage";
        aVar.hmj = new ben();
        aVar.hmk = new beo();
        aVar.hml = 0;
        aVar.hmm = 0;
        this.kEK = aVar.JZ();
        ben com_tencent_mm_protocal_c_ben = (ben) this.kEK.hmg.hmo;
        com_tencent_mm_protocal_c_ben.wwI = c.Je();
        com_tencent_mm_protocal_c_ben.wkq = this.fod;
        com_tencent_mm_protocal_c_ben.vPp = this.kEM;
        com_tencent_mm_protocal_c_ben.vNW = this.offset;
        com_tencent_mm_protocal_c_ben.wKa = this.scene;
        com_tencent_mm_protocal_c_ben.vPs = this.iRN;
        return a(eVar, this.kEK, this);
    }

    public final je asl() {
        return this.kEL == null ? null : this.kEL.wKc;
    }
}
