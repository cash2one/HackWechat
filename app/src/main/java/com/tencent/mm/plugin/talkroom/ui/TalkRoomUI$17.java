package com.tencent.mm.plugin.talkroom.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class TalkRoomUI$17 implements OnDismissListener {
    final /* synthetic */ TalkRoomUI scT;

    TalkRoomUI$17(TalkRoomUI talkRoomUI) {
        this.scT = talkRoomUI;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        ar.Hg();
        int a = bh.a((Integer) c.CU().get(144641, null), 0) + 1;
        ar.Hg();
        c.CU().set(144641, Integer.valueOf(a));
        this.scT.onBackPressed();
    }
}
