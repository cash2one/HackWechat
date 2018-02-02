package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class aj$2 implements OnClickListener {
    final /* synthetic */ au yNY;
    final /* synthetic */ int yNZ;
    final /* synthetic */ aj yOg;

    aj$2(aj ajVar, au auVar, int i) {
        this.yOg = ajVar;
        this.yNY = auVar;
        this.yNZ = i;
    }

    public final void onClick(View view) {
        if (bh.ov(this.yNY.field_imgPath)) {
            x.d("MicroMsg.ChattingItemVoiceRemindRemind", "filename is null");
            return;
        }
        d dVar = aj.c(this.yOg).ysf.ysR;
        int i = this.yNZ;
        cf cfVar = this.yNY;
        if (cfVar != null) {
            dVar.crc();
            ar.Hg();
            Boolean bool = (Boolean) c.CU().get(4115, null);
            if (bool == null || !bool.booleanValue()) {
                ar.Hg();
                c.CU().set(4115, Boolean.valueOf(true));
                dVar.cri();
                dVar.yqq = u.a(dVar.yqo.thisActivity(), dVar.yqo.getString(R.l.dSj), 4000);
            }
            if (dVar.mql.isPlaying() && cfVar.field_msgId == dVar.yqm) {
                dVar.crh();
                return;
            }
            dVar.ah(cfVar);
            if (cfVar.field_isSend == 0 && !q.C(cfVar)) {
                dVar.Fo(i + 1);
            }
            dVar.bdr();
        }
    }
}
