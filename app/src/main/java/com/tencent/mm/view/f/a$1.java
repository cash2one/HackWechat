package com.tencent.mm.view.f;

import com.tencent.mm.g.a.qz;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class a$1 extends c<qz> {
    final /* synthetic */ a zGW;

    public a$1(a aVar) {
        this.zGW = aVar;
        this.xen = qz.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qz qzVar = (qz) bVar;
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "kv stat update click cell item");
        g.pQN.k(11076, "1," + qzVar.fIN.fqV);
        this.zGW.cBd();
        return true;
    }
}
