package com.tencent.mm.plugin.talkroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class TalkRoomUI$7 implements OnClickListener {
    final /* synthetic */ TalkRoomUI scT;

    TalkRoomUI$7(TalkRoomUI talkRoomUI) {
        this.scT = talkRoomUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.scT.finish();
    }
}
