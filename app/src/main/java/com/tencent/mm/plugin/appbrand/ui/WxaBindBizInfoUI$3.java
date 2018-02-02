package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.u;
import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView$a;
import com.tencent.mm.protocal.c.aiq;
import com.tencent.mm.protocal.c.air;

class WxaBindBizInfoUI$3 implements LoadMoreRecyclerView$a {
    final /* synthetic */ WxaBindBizInfoUI jNo;

    WxaBindBizInfoUI$3(WxaBindBizInfoUI wxaBindBizInfoUI) {
        this.jNo = wxaBindBizInfoUI;
    }

    public final void akW() {
        a com_tencent_mm_protocal_c_aiq = new aiq();
        com_tencent_mm_protocal_c_aiq.fFm = WxaBindBizInfoUI.a(this.jNo);
        com_tencent_mm_protocal_c_aiq.wqe = WxaBindBizInfoUI.b(this.jNo);
        b.a aVar = new b.a();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getwxabindbizinfo";
        aVar.hmi = 1823;
        aVar.hmj = com_tencent_mm_protocal_c_aiq;
        aVar.hmk = new air();
        u.a(aVar.JZ(), new 1(this), false);
    }
}
