package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class q$13 implements OnClickListener {
    final /* synthetic */ q yLH;

    q$13(q qVar) {
        this.yLH = qVar;
    }

    public final void onClick(View view) {
        ar arVar = (ar) view.getTag();
        x.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) container click", new Object[]{arVar.userName});
        b qpVar = new qp();
        qpVar.fIi.userName = arVar.userName;
        qpVar.fIi.fIk = arVar.yOJ;
        Map y = bi.y(arVar.fEJ.field_content, "msg");
        String str = "";
        if (y != null && y.size() > 0) {
            qpVar.fIi.fIl = bh.getInt((String) y.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), 0);
            str = bh.ou((String) y.get(".msg.appmsg.template_id"));
        }
        qpVar.fIi.fIo = true;
        qpVar.fIi.scene = HardCoderJNI.FUNC_CANCEL_UNIFY_CPU_IO_THREAD_CORE;
        qpVar.fIi.fnp = arVar.fEJ.field_msgSvrId + ":" + arVar.userName + ":" + q.c(this.yLH).crz() + ":" + str;
        a.xef.m(qpVar);
        q.B(9, q.a(this.yLH), q.b(this.yLH));
        g.pQN.h(11608, new Object[]{q.b(this.yLH), arVar.userName, Integer.valueOf(0)});
    }
}
