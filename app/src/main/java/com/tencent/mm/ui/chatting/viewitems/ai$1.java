package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;

class ai$1 implements OnClickListener {
    final /* synthetic */ au yNY;
    final /* synthetic */ int yNZ;
    final /* synthetic */ ai yOa;

    ai$1(ai aiVar, au auVar, int i) {
        this.yOa = aiVar;
        this.yNY = auVar;
        this.yNZ = i;
    }

    public final void onClick(View view) {
        if (t.ov(this.yNY.field_imgPath)) {
            x.d("MicroMsg.ChattingItemVoiceRemindConfirm", "filename is null");
        } else {
            ai.a(this.yOa).ysf.ysR.b(this.yNZ, this.yNY);
        }
    }
}
