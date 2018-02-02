package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ae.a;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u;
import com.tencent.mm.protocal.c.bdf;
import com.tencent.mm.protocal.c.bpt;
import com.tencent.mm.protocal.c.bpu;
import com.tencent.mm.sdk.platformtools.x;

public final class q extends a<bpu> {
    private final bpt iKj;
    private final b iKk;
    public volatile u.a iKl;
    private final String irG;

    protected final /* synthetic */ void a(int i, int i2, String str, bdf com_tencent_mm_protocal_c_bdf, k kVar) {
        bpu com_tencent_mm_protocal_c_bpu = (bpu) com_tencent_mm_protocal_c_bdf;
        x.i("MicroMsg.AppBrand.CgiUpdateWxaUsageRecord", "onCgiBack, req [scene %d, background %b, versionType %d, recordType %d, op %d, username %s]resp [errType %d, errCode %d, errMsg %s, resp %s]", new Object[]{Integer.valueOf(this.iKj.scene), Integer.valueOf(this.iKj.wRz), Integer.valueOf(this.iKj.vOu), Integer.valueOf(this.iKj.wRA), Integer.valueOf(this.iKj.wRB), this.iKj.username, Integer.valueOf(i), Integer.valueOf(i2), str, com_tencent_mm_protocal_c_bpu});
        if (this.iKl != null) {
            this.iKl.a(i, i2, str, this.iKk, kVar);
        }
    }

    public q(int i, boolean z, int i2, int i3, int i4, String str, int i5, String str2) {
        this.irG = str2;
        b.a aVar = new b.a();
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_bpt = new bpt();
        if (i == 0) {
            i = 1000;
        }
        com_tencent_mm_protocal_c_bpt.scene = i;
        com_tencent_mm_protocal_c_bpt.wRz = z ? 1 : 0;
        com_tencent_mm_protocal_c_bpt.vOu = i2;
        com_tencent_mm_protocal_c_bpt.wRA = i3;
        com_tencent_mm_protocal_c_bpt.wRB = i4;
        com_tencent_mm_protocal_c_bpt.username = str;
        com_tencent_mm_protocal_c_bpt.aAk = i5;
        com_tencent_mm_protocal_c_bpt.wRC = str2;
        this.iKj = com_tencent_mm_protocal_c_bpt;
        aVar.hmj = com_tencent_mm_protocal_c_bpt;
        aVar.hmk = new bpu();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/updatewxausagerecord";
        aVar.hmi = 1149;
        b JZ = aVar.JZ();
        this.iKk = JZ;
        this.gJQ = JZ;
    }
}
