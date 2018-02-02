package com.tencent.mm.ui.chatting.viewitems;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.viewitems.ai.4.1;
import com.tencent.mm.y.g.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;

class ai$4$1$1 implements e {
    final /* synthetic */ 1 yOe;

    ai$4$1$1(1 1) {
        this.yOe = 1;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + i + " errCode " + i2 + "  scene " + kVar.getType());
        if (i == 0 && i2 == 0) {
            a fT;
            String str2 = this.yOe.yOd.yNY.field_content;
            if (str2 != null) {
                fT = a.fT(str2);
            } else {
                fT = null;
            }
            if (fT != null) {
                l.fq(this.yOe.yOd.yNY.field_msgId);
            }
            ba.aK(this.yOe.yOd.yNY.field_msgId);
            Toast.makeText(this.yOe.yOd.yOa.yqa.getContext(), this.yOe.yOd.yOa.yqa.getString(R.l.dRx), 0).show();
        }
        ar.CG().b(331, this.yOe.yOd.yOa.hPs);
        this.yOe.yOd.yOa.hPs = null;
        if (this.yOe.yOd.yOa.qib != null) {
            this.yOe.yOd.yOa.qib.dismiss();
        }
    }
}
