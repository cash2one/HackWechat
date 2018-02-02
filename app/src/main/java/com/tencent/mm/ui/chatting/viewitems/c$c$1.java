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

class c$c$1 implements OnClickListener {
    final /* synthetic */ long fhh;
    final /* synthetic */ au heR;
    final /* synthetic */ String uS;
    final /* synthetic */ Boolean yJy;
    final /* synthetic */ String yJz;

    c$c$1(Boolean bool, long j, String str, String str2, au auVar) {
        this.yJy = bool;
        this.fhh = j;
        this.uS = str;
        this.yJz = str2;
        this.heR = auVar;
    }

    public final void onClick(View view) {
        String str;
        c fo;
        if (this.yJy.booleanValue()) {
            long j = this.fhh;
            str = this.yJz;
            fo = an.aqd().fo(j);
            if (fo == null) {
                x.e("MicroMsg.AppMsgLogic", "ERR:" + g.zh() + " getinfo failed: " + str);
                return;
            } else if (fo.field_status != 101) {
                x.e("MicroMsg.AppMsgLogic", "ERR:" + g.zh() + " get status failed: " + str + " status:" + fo.field_status);
                return;
            } else {
                fo.field_status = 102;
                fo.field_lastModifyTime = bh.Wo();
                an.aqd().c(fo, new String[0]);
                return;
            }
        }
        j = this.fhh;
        str = this.yJz;
        fo = an.aqd().fo(j);
        if (fo == null) {
            x.e("MicroMsg.AppMsgLogic", "ERR:" + g.zh() + " getinfo failed: " + str);
        } else if (fo.field_status != 101) {
            x.e("MicroMsg.AppMsgLogic", "ERR:" + g.zh() + " get status failed: " + str + " status:" + fo.field_status);
        } else {
            if (!bh.ov(fo.field_clientAppDataId) || bh.ov(fo.field_mediaSvrId)) {
                fo.field_status = 105;
            } else {
                fo.field_status = 102;
            }
            fo.field_lastModifyTime = bh.Wo();
            an.aqd().c(fo, new String[0]);
        }
        this.heR.eQ(5);
        ar.Hg();
        com.tencent.mm.z.c.Fa().dH(this.fhh);
    }
}
