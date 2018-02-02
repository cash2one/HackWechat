package com.tencent.mm.plugin.readerapp.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.plugin.readerapp.b.g;
import com.tencent.mm.pluginsdk.model.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p$d;
import com.tencent.mm.y.g.a;
import com.tencent.mm.z.bf;
import com.tencent.mm.z.bg;
import com.tencent.mm.z.u;
import com.tencent.mm.z.u.b;
import java.util.List;

class ReaderAppUI$3 implements p$d {
    final /* synthetic */ ReaderAppUI pAY;

    ReaderAppUI$3(ReaderAppUI readerAppUI) {
        this.pAY = readerAppUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        int groupId = menuItem.getGroupId();
        bf bfVar;
        long longValue;
        switch (menuItem.getItemId()) {
            case 0:
                if (ReaderAppUI.a(this.pAY) == 20) {
                    List b = g.bmp().b(((Long) ReaderAppUI.b(this.pAY).getItem(groupId)).longValue(), ReaderAppUI.a(this.pAY));
                    if (b.size() > 0) {
                        bfVar = (bf) b.get(0);
                        a aVar = new a();
                        aVar.title = bfVar.getTitle();
                        aVar.description = bfVar.HM();
                        aVar.action = "view";
                        aVar.type = 5;
                        aVar.url = bfVar.getUrl();
                        String a = a.a(aVar, null, null);
                        Intent intent = new Intent();
                        intent.putExtra("Retr_Msg_content", a);
                        intent.putExtra("Retr_Msg_Type", 2);
                        intent.putExtra("Retr_Msg_thumb_path", t.v(bfVar.HL(), bfVar.type, "@T"));
                        intent.putExtra("Retr_Msg_Id", 7377812);
                        a = u.hz(bfVar.hhm);
                        intent.putExtra("reportSessionId", a);
                        b t = u.GK().t(a, true);
                        t.o("prePublishId", "msg_" + bfVar.hhm);
                        t.o("preUsername", "newsapp");
                        t.o("preChatName", "newsapp");
                        t.o("preMsgIndex", Integer.valueOf(0));
                        t.o("sendAppMsgScene", Integer.valueOf(1));
                        com.tencent.mm.plugin.readerapp.a.a.ifs.l(intent, this.pAY);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                if (ReaderAppUI.a(this.pAY) == 20) {
                    List b2 = g.bmp().b(((Long) ReaderAppUI.b(this.pAY).getItem(groupId)).longValue(), ReaderAppUI.a(this.pAY));
                    if (!b2.isEmpty()) {
                        x.i("MicroMsg.ReaderAppUI", "fav time %d, index %d, size %d", new Object[]{Long.valueOf(longValue), Integer.valueOf(ReaderAppUI.c(this.pAY)), Integer.valueOf(b2.size())});
                        if (ReaderAppUI.c(this.pAY) >= b2.size()) {
                            ReaderAppUI.a(this.pAY, 0);
                        }
                        bfVar = (bf) b2.get(ReaderAppUI.c(this.pAY));
                        com.tencent.mm.sdk.b.b cfVar = new cf();
                        String hz = u.hz(bfVar.hhm);
                        b t2 = u.GK().t(hz, true);
                        t2.o("prePublishId", "msg_" + bfVar.hhm);
                        t2.o("preUsername", "newsapp");
                        t2.o("preChatName", "newsapp");
                        t2.o("preMsgIndex", Integer.valueOf(0));
                        t2.o("sendAppMsgScene", Integer.valueOf(1));
                        cfVar.fqp.fqu = hz;
                        com.tencent.mm.plugin.readerapp.b.b.a(cfVar, bfVar, ReaderAppUI.c(this.pAY));
                        cfVar.fqp.fqw = 7;
                        cfVar.fqp.activity = this.pAY;
                        com.tencent.mm.sdk.b.a.xef.m(cfVar);
                        return;
                    }
                    return;
                }
                return;
            case 2:
                longValue = ((Long) ReaderAppUI.b(this.pAY).getItem(groupId)).longValue();
                if (longValue != 0) {
                    g.u(longValue, ReaderAppUI.a(this.pAY));
                    bg bmp = g.bmp();
                    int a2 = ReaderAppUI.a(this.pAY);
                    x.d("MicroMsg.ReaderAppInfoStorage", "deleteGroup:%s", new Object[]{"delete from " + bg.gU(a2) + " where time = " + longValue});
                    if (bmp.hhp.fx(bg.gU(a2), "delete from " + bg.gU(a2) + " where time = " + longValue)) {
                        bmp.gX(a2);
                        bmp.doNotify();
                    }
                }
                this.pAY.refresh();
                return;
            default:
                return;
        }
    }
}
