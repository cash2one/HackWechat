package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import com.tencent.mm.g.a.ql;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.ui.SnsUploadUI.3;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.aoy;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.a.c.a;

class SnsUploadUI$3$1 implements a {
    final /* synthetic */ 3 rLT;

    SnsUploadUI$3$1(3 3) {
        this.rLT = 3;
    }

    public final void uY(String str) {
        int bCd = SnsUploadUI.l(this.rLT.rLR).bCd();
        g.Dk();
        g.Dj().CU().set(68404, Integer.valueOf(bCd));
        SnsUploadUI.a(this.rLT.rLR, SnsUploadUI.a(this.rLT.rLR).getText().toString());
        int i = SnsUploadUI.a(this.rLT.rLR).rBy;
        int bCc = SnsUploadUI.l(this.rLT.rLR).bCc();
        int bCd2 = SnsUploadUI.l(this.rLT.rLR).bCd();
        SnsUploadUI.m(this.rLT.rLR);
        if (SnsUploadUI.n(this.rLT.rLR)) {
            this.rLT.rLR.setResult(-1, new Intent());
        }
        if (SnsUploadUI.f(this.rLT.rLR) instanceof ah) {
            ah ahVar = (ah) SnsUploadUI.f(this.rLT.rLR);
            LocationWidget o = SnsUploadUI.o(this.rLT.rLR);
            aoy com_tencent_mm_protocal_c_aoy = new aoy();
            com_tencent_mm_protocal_c_aoy.vQu = o.ruh;
            com_tencent_mm_protocal_c_aoy.vQt = o.oQh;
            com_tencent_mm_protocal_c_aoy.biF = o.biF;
            com_tencent_mm_protocal_c_aoy.rui = o.rui;
            ahVar.rvJ = com_tencent_mm_protocal_c_aoy;
        }
        if (SnsUploadUI.f(this.rLT.rLR) instanceof ae) {
            SnsUploadUI.a(this.rLT.rLR).setText("");
        }
        PInt pInt = new PInt();
        SnsUploadUI.f(this.rLT.rLR).a(bCc, bCd2, SnsUploadUI.l(this.rLT.rLR).rLC.zpV, SnsUploadUI.p(this.rLT.rLR), SnsUploadUI.q(this.rLT.rLR).byY(), SnsUploadUI.o(this.rLT.rLR).bzA(), i, SnsUploadUI.r(this.rLT.rLR), SnsUploadUI.s(this.rLT.rLR), pInt, SnsUploadUI.t(this.rLT.rLR), SnsUploadUI.u(this.rLT.rLR), SnsUploadUI.v(this.rLT.rLR));
        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
        Object[] objArr = new Object[4];
        objArr[0] = Long.valueOf(SnsUploadUI.w(this.rLT.rLR));
        objArr[1] = Long.valueOf(bh.Wo());
        objArr[2] = Integer.valueOf(SnsUploadUI.x(this.rLT.rLR) ? 0 : 1);
        objArr[3] = Integer.valueOf(pInt.value);
        gVar.h(13303, objArr);
        String str2 = "MicroMsg.SnsUploadUI";
        String str3 = "reprot timelinePostAction(13303), %d, %d, %d, %d";
        objArr = new Object[4];
        objArr[0] = Long.valueOf(SnsUploadUI.w(this.rLT.rLR));
        objArr[1] = Long.valueOf(bh.Wo());
        objArr[2] = Integer.valueOf(SnsUploadUI.x(this.rLT.rLR) ? 0 : 1);
        objArr[3] = Integer.valueOf(pInt.value);
        x.d(str2, str3, objArr);
        com.tencent.mm.plugin.report.service.g.pQN.k(10910, "1");
        if (!bh.ov(SnsUploadUI.y(this.rLT.rLR))) {
            if (SnsUploadUI.r(this.rLT.rLR)) {
                com.tencent.mm.plugin.report.service.g.pQN.h(11455, new Object[]{"", SnsUploadUI.y(this.rLT.rLR), Integer.valueOf(-1), Integer.valueOf(-1)});
            } else {
                com.tencent.mm.plugin.report.service.g.pQN.h(11455, new Object[]{SnsUploadUI.y(this.rLT.rLR), "", Integer.valueOf(-1), Integer.valueOf(-1)});
            }
        }
        if (SnsUploadUI.h(this.rLT.rLR) != null) {
            SnsUploadUI.h(this.rLT.rLR).it(9);
        }
        if (SnsUploadUI.z(this.rLT.rLR)) {
            Intent intent = new Intent(this.rLT.rLR, SnsTimeLineUI.class);
            intent.putExtra("sns_resume_state", false);
            intent.putExtra("sns_timeline_NeedFirstLoadint", true);
            intent.addFlags(67108864);
            this.rLT.rLR.startActivity(intent);
        }
        com.tencent.mm.sdk.b.a.xef.m(new ql());
    }

    public final void amI() {
    }

    public final void aem() {
        h.h(this.rLT.rLR, j.qMH, j.qMI);
    }
}
