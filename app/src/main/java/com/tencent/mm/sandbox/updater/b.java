package com.tencent.mm.sandbox.updater;

import com.tencent.mm.compatible.d.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.protocal.c.agx;
import com.tencent.mm.protocal.c.bcv;
import com.tencent.mm.protocal.c.fd;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sandbox.b.a;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends c {
    private String[] fpM;
    private byte[] hZs;
    private byte[] hZu;
    private byte[] hnJ;
    private int uin;
    private int xcu = 0;
    private final int xcv = 5;
    private int xcw = 0;
    private a xcx;
    private a xcy = null;
    private a xcz = new 1(this);

    static /* synthetic */ int a(b bVar) {
        int i = bVar.xcw + 1;
        bVar.xcw = i;
        return i;
    }

    public b(int i, String str, int i2, int i3, byte[] bArr, byte[] bArr2, String[] strArr, boolean z) {
        super(i, str, i2, z);
        this.fpM = strArr;
        if (strArr == null || strArr.length == 0) {
            this.fpM = new String[]{"short.weixin.qq.com"};
        }
        this.uin = i3;
        this.hZs = bArr;
        this.hnJ = bArr2;
    }

    public final void a(a aVar) {
        this.xcx = aVar;
        int i = this.xcu + 1;
        this.xcu = i;
        if (i > 1000) {
            x.d("MicroMsg.NetSceneGetUpdatePack", "doSceneCnt > DOSCENE_LIMIT, return");
            this.xcx.a(-1, -1, null);
        } else if (f.aC((long) this.xcc)) {
            bcv com_tencent_mm_protocal_c_agx = new agx();
            fd fdVar = new fd();
            fdVar.vLa = d.vAz;
            fdVar.rYW = 0;
            fdVar.lOd = this.uin;
            fdVar.vKZ = com.tencent.mm.bq.b.bc(q.yF().getBytes());
            if (fdVar.vKZ.oz.length >= 16) {
                fdVar.vKZ = fdVar.vKZ.CD(16);
            }
            fdVar.vLb = com.tencent.mm.bq.b.bc(d.DEVICE_TYPE.getBytes());
            if (fdVar.vLb.oz.length >= 132) {
                fdVar.vLb = fdVar.vLb.CD(132);
            }
            fdVar.vKY = com.tencent.mm.bq.b.bc(this.hZs);
            if (fdVar.vKY.oz.length >= 36) {
                fdVar.vKY = fdVar.vKY.CD(36);
            }
            com_tencent_mm_protocal_c_agx.wIV = fdVar;
            com_tencent_mm_protocal_c_agx.wof = this.xcb;
            com_tencent_mm_protocal_c_agx.vIC = this.xcd;
            com_tencent_mm_protocal_c_agx.vIB = this.xcc;
            a aVar2 = new a(this, this.fpM[this.xcw / 5], this.xcz);
            this.xcy = aVar2;
            aVar2.execute(new agx[]{com_tencent_mm_protocal_c_agx});
        } else {
            x.e("MicroMsg.NetSceneGetUpdatePack", "SDCard full, packSize=[%s]", new Object[]{Integer.valueOf(this.xcc)});
            aVar.a(-1, -1, null);
        }
    }

    public final void cancel() {
        x.i("MicroMsg.NetSceneGetUpdatePack", "do cancel, updateType = " + this.xcb);
        if (this.xcy != null && !this.xcy.isCancelled()) {
            this.xcy.cancel(true);
        }
    }
}
