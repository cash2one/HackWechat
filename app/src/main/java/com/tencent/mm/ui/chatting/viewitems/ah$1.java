package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.g.a.fi;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI.a;

class ah$1 implements Runnable {
    final /* synthetic */ au heR;
    final /* synthetic */ a yII;

    ah$1(a aVar, au auVar) {
        this.yII = aVar;
        this.heR = auVar;
    }

    public final void run() {
        a aVar = this.yII;
        cf cfVar = this.heR;
        if (aVar == null || aVar.yvJ == null) {
            x.e("MicroMsg.ChattingItemVoice", "alvinluo ui or ui.transformImp null");
            return;
        }
        int i = aVar.yvJ.gj(cfVar.field_msgId) ? 2 : aVar.yvJ.gg(cfVar.field_msgId) ? 3 : !bh.ov(aVar.yvJ.v(cfVar.field_msgId, cfVar.field_imgPath)) ? 5 : 1;
        x.i("MicroMsg.ChattingItemVoice", "alvinluo TransformText report clickScene: %d, msgId: %d", new Object[]{Integer.valueOf(i), Long.valueOf(cfVar.field_msgId)});
        b fiVar = new fi();
        fiVar.fuz.fuA = 1;
        fiVar.fuz.scene = i;
        fiVar.fuz.fileName = cfVar.field_imgPath;
        com.tencent.mm.sdk.b.a.xef.m(fiVar);
    }
}
