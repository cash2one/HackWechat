package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;

class c$c$2 implements OnClickListener {
    final /* synthetic */ long fhh;
    final /* synthetic */ au heR;
    final /* synthetic */ Boolean yJy;
    final /* synthetic */ String yJz;

    c$c$2(Boolean bool, long j, String str, au auVar) {
        this.yJy = bool;
        this.fhh = j;
        this.yJz = str;
        this.heR = auVar;
    }

    public final void onClick(View view) {
        if (!this.yJy.booleanValue()) {
            long j = this.fhh;
            String str = this.yJz;
            c fo = an.aqd().fo(j);
            if (fo == null) {
                x.e("MicroMsg.AppMsgLogic", "ERR:" + g.zh() + " getinfo failed: " + str);
            } else if (fo.field_status != 105) {
                x.e("MicroMsg.AppMsgLogic", "ERR:" + g.zh() + " get status failed: " + str + " status:" + fo.field_status);
            } else {
                fo.field_status = 101;
                fo.field_lastModifyTime = bh.Wo();
                an.aqd().c(fo, new String[0]);
                an.bYU().run();
            }
            this.heR.eQ(1);
            ar.Hg();
            com.tencent.mm.z.c.Fa().dH(this.fhh);
        }
    }
}
