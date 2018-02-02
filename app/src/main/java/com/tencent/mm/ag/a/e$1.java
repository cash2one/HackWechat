package com.tencent.mm.ag.a;

import com.tencent.mm.a.e;
import com.tencent.mm.ag.a.b$a.b;
import com.tencent.mm.ag.y;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ba.a;
import java.io.File;

class e$1 implements Runnable {
    final /* synthetic */ a hfb = null;
    final /* synthetic */ String hqS;
    final /* synthetic */ boolean hqT;

    e$1(String str, boolean z, a aVar) {
        this.hqS = str;
        this.hqT = z;
    }

    public final void run() {
        b Mi = y.Mi();
        String str = this.hqS;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("delete from BizChatConversation");
        stringBuilder.append(" where brandUserName = '").append(str).append("' ");
        x.i("MicroMsg.BizConversationStorage", "deleteByBrandUserName sql %s,%s", new Object[]{stringBuilder.toString(), Boolean.valueOf(Mi.gJP.fx("BizChatConversation", stringBuilder.toString()))});
        if (Mi.gJP.fx("BizChatConversation", stringBuilder.toString())) {
            a aVar = new a();
            b bVar = new b();
            bVar.hqF = -1;
            bVar.frn = str;
            bVar.hqE = b$a.a.hqB;
            bVar.hqG = aVar;
            Mi.hod.ca(bVar);
            Mi.hod.doNotify();
        }
        ((h) g.h(h.class)).Fd().WX(this.hqS);
        d Mh = y.Mh();
        str = this.hqS;
        stringBuilder = new StringBuilder();
        stringBuilder.append("delete from BizChatInfo");
        stringBuilder.append(" where brandUserName = '").append(str).append("' ");
        x.i("MicroMsg.BizChatInfoStorage", "deleteByBrandUserName sql %s,%s", new Object[]{stringBuilder.toString(), Boolean.valueOf(Mh.gJP.fx("BizChatInfo", stringBuilder.toString()))});
        if (Mh.gJP.fx("BizChatInfo", stringBuilder.toString())) {
            c cVar = new c();
            d.a.b bVar2 = new d.a.b();
            bVar2.hqF = -1;
            bVar2.frn = str;
            bVar2.hqP = d.a.a.hqM;
            bVar2.hqQ = cVar;
            Mh.hod.ca(bVar2);
            Mh.hod.doNotify();
        }
        e.g(new File(e.bZ(this.hqS)));
        if (this.hqT) {
            k Mj = y.Mj();
            str = this.hqS;
            stringBuilder = new StringBuilder();
            stringBuilder.append("delete from BizChatUserInfo");
            stringBuilder.append(" where brandUserName = '").append(str).append("' ");
            x.i("MicroMsg.BizChatUserInfoStorage", "deleteByBrandUserName sql %s,%s", new Object[]{stringBuilder.toString(), Boolean.valueOf(Mj.gJP.fx("BizChatUserInfo", stringBuilder.toString()))});
            if (Mj.gJP.fx("BizChatUserInfo", stringBuilder.toString())) {
                j jVar = new j();
                k.a.b bVar3 = new k.a.b();
                bVar3.hrr = k.a.a.hro;
                bVar3.hrs = jVar;
                Mj.hod.ca(bVar3);
                Mj.hod.doNotify();
            }
            y.Mk().kw(this.hqS);
            e.g(new File(e.ku(this.hqS)));
        }
        ag.y(new 1(this));
    }

    public final String toString() {
        return super.toString() + "|deleteMsgByTalkers";
    }
}
