package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.booter.z;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.b.w;
import com.tencent.mm.z.ar;

class ChattingUI$a$11 implements OnClickListener {
    final /* synthetic */ int hvX;
    final /* synthetic */ a ywR;
    final /* synthetic */ ae ywT;

    ChattingUI$a$11(a aVar, ae aeVar, int i) {
        this.ywR = aVar;
        this.ywT = aeVar;
        this.hvX = i;
    }

    public final void onClick(View view) {
        z zVar = z.gyU;
        if (zVar.gyY != null) {
            zVar.gyY.gzq = 2;
        }
        if (this.ywT == null || this.ywT.field_UnDeliverCount <= 0) {
            a.b(this.ywR, this.hvX);
            return;
        }
        w wVar = this.ywR.yvO;
        aj ajVar = this.ywT;
        int l = a.l(this.ywR);
        int i = this.hvX;
        x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr mGoBackToHistryMsgLayout Unread[%d] UnDeliver[%d] pos[%d]", new Object[]{Integer.valueOf(l), Integer.valueOf(ajVar.field_UnDeliverCount), Integer.valueOf(i)});
        if (ajVar.field_UnDeliverCount <= 0) {
            x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr mGoBackToHistryMsgLayout undeliverCount[%d] less then one scene do normal", new Object[]{Integer.valueOf(r4)});
        } else {
            l = (int) ajVar.field_firstUnDeliverSeq;
            x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr mGoBackToHistryMsgLayout undeliverCount[%d] need get firstSeq[%d]", new Object[]{Integer.valueOf(r4), Integer.valueOf(l)});
            if (l > 0) {
                ar.Dm().F(new w$8(wVar, l, ajVar, i));
                return;
            }
        }
        wVar.fhr.af(i, false);
    }
}
