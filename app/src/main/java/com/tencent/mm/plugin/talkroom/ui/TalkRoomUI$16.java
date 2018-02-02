package com.tencent.mm.plugin.talkroom.ui;

import android.view.View;
import android.view.View.OnClickListener;

class TalkRoomUI$16 implements OnClickListener {
    final /* synthetic */ TalkRoomUI scT;

    TalkRoomUI$16(TalkRoomUI talkRoomUI) {
        this.scT = talkRoomUI;
    }

    public final void onClick(View view) {
        this.scT.onBackPressed();
    }
}
