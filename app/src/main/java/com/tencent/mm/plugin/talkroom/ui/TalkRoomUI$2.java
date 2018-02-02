package com.tencent.mm.plugin.talkroom.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.base.k;

class TalkRoomUI$2 implements OnClickListener {
    final /* synthetic */ k iVF;
    final /* synthetic */ TalkRoomUI scT;

    TalkRoomUI$2(TalkRoomUI talkRoomUI, k kVar) {
        this.scT = talkRoomUI;
        this.iVF = kVar;
    }

    public final void onClick(View view) {
        this.iVF.dismiss();
    }
}
