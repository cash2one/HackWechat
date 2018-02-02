package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.f;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.m.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class q$14 implements OnClickListener {
    final /* synthetic */ q yLH;

    q$14(q qVar) {
        this.yLH = qVar;
    }

    public final void onClick(View view) {
        ar arVar = (ar) view.getTag();
        Map y = bi.y(arVar.fEJ.field_content, "msg");
        if (y == null) {
            x.i("MicroMsg.ChattingItemDyeingTemplate", "values map is null.");
            return;
        }
        int i = bh.getInt((String) y.get(".msg.appmsg.mmreader.category.item.template_op_type"), -1);
        String ou;
        if (i == 1) {
            String str = (String) y.get(".msg.appmsg.mmreader.category.item.weapp_username");
            String str2 = (String) y.get(".msg.appmsg.mmreader.category.item.weapp_path");
            int i2 = bh.getInt((String) y.get(".msg.appmsg.mmreader.category.item.weapp_version"), 0);
            int i3 = bh.getInt((String) y.get(".msg.appmsg.mmreader.category.item.weapp_state"), 0);
            ou = bh.ou((String) y.get(".msg.appmsg.template_id"));
            x.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) container click", str);
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.fnp = arVar.fEJ.field_msgSvrId + ":" + arVar.userName + ":" + q.c(this.yLH).crz() + ":" + ou;
            if (((a) g.h(a.class)).fV(arVar.userName)) {
                appBrandStatObject.scene = HardCoderJNI.FUNC_CANCEL_UNIFY_CPU_IO_THREAD_CORE;
                ((c) g.h(c.class)).a(q.c(this.yLH).getContext(), str, null, i3, i2, str2, appBrandStatObject);
            } else {
                appBrandStatObject.scene = 1043;
                d jS = f.jS(arVar.userName);
                ((c) g.h(c.class)).a(q.c(this.yLH).getContext(), str, null, i3, i2, str2, appBrandStatObject, jS == null ? null : jS.field_appId);
            }
            q.B(9, q.a(this.yLH), q.b(this.yLH));
            com.tencent.mm.plugin.report.service.g.pQN.h(11608, q.b(this.yLH), arVar.userName, Integer.valueOf(0));
        } else if (i == 2) {
            q.b(view.getContext(), (String) y.get(".msg.appmsg.mmreader.category.item.schedule_username"), bh.getLong((String) y.get(".msg.appmsg.mmreader.category.item.schedule_messvrid"), -1));
            x.i("MicroMsg.ChattingItemDyeingTemplate", "[onClick] Remind! username:%s svrMsgId:%s", ou, Long.valueOf(r2));
        }
    }
}
