package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.R;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.protocal.c.vk;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;

public final class b {

    public static final class a {
        public String desc;
        public String fFm;
        public String fGG;
        public String thumbUrl;
        public String title;
        public String url;
    }

    public static boolean a(cf cfVar, a aVar) {
        if (!bh.ov(aVar.url)) {
            ve veVar = new ve();
            vk vkVar = new vk();
            uq uqVar = new uq();
            uqVar.Tw(aVar.url);
            uqVar.Tq(aVar.title);
            uqVar.Tr(aVar.desc);
            uqVar.Tz(aVar.thumbUrl);
            uqVar.TO(aVar.fGG);
            uqVar.ls(true);
            uqVar.lt(true);
            uqVar.CJ(5);
            vt vtVar = new vt();
            vtVar.Uy(aVar.thumbUrl);
            veVar.b(vtVar);
            vkVar.Ui(q.FS());
            vkVar.Uj(q.FS());
            vkVar.CS(3);
            vkVar.fC(bh.Wp());
            vkVar.Uo(aVar.fFm);
            vkVar.Up(aVar.url);
            cfVar.fqp.title = uqVar.title;
            cfVar.fqp.fqr = veVar;
            cfVar.fqp.type = 5;
            veVar.a(vkVar);
            veVar.weU.add(uqVar);
            return true;
        }
        x.w("MicroMsg.GetFavDataSource", "fill favorite event fail, event is null or wrapper is invalid");
        cfVar.fqp.fqv = R.l.efh;
        return false;
    }
}
