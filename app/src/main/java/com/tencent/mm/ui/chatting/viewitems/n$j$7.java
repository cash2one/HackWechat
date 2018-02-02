package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.viewitems.n.j;
import com.tencent.mm.y.m;

class n$j$7 implements OnClickListener {
    final /* synthetic */ j yLl;
    final /* synthetic */ m yrK;

    n$j$7(j jVar, m mVar) {
        this.yLl = jVar;
        this.yrK = mVar;
    }

    public final void onClick(View view) {
        ar arVar = (ar) view.getTag();
        x.i("MicroMsg.ChattingItemBizFrom", "on app brand(%s) button1 click", new Object[]{this.yrK.hei});
        b qpVar = new qp();
        qpVar.fIi.userName = this.yrK.hei;
        qpVar.fIi.fIk = this.yrK.hej;
        qpVar.fIi.fIl = this.yrK.hel;
        qpVar.fIi.fIm = this.yrK.hek;
        qpVar.fIi.fIo = true;
        qpVar.fIi.scene = 1076;
        qpVar.fIi.fnp = j.a(this.yLl).crz() + ":" + arVar.fEJ.field_msgSvrId + ":" + arVar.ttg;
        a.xef.m(qpVar);
    }
}
