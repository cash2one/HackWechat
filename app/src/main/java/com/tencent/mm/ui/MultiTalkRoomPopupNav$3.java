package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.q.a;
import com.tencent.mm.sdk.platformtools.x;

class MultiTalkRoomPopupNav$3 implements OnClickListener {
    final /* synthetic */ String oGL;
    final /* synthetic */ MultiTalkRoomPopupNav xLr;

    MultiTalkRoomPopupNav$3(MultiTalkRoomPopupNav multiTalkRoomPopupNav, String str) {
        this.xLr = multiTalkRoomPopupNav;
        this.oGL = str;
    }

    public final void onClick(View view) {
        int i = 1;
        x.i("MicroMsg.MultiTalkRoomPopupNav", "click cancel button..");
        if (MultiTalkRoomPopupNav.d(this.xLr) == MultiTalkRoomPopupNav$b.xLt) {
            x.i("MicroMsg.MultiTalkRoomPopupNav", "reject multiTalk!");
            boolean Fw = a.vcx.Fw(this.oGL);
            a.vcx.Fx(this.oGL);
            g gVar = g.pQN;
            Object[] objArr = new Object[7];
            objArr[0] = Integer.valueOf(3);
            objArr[1] = Integer.valueOf(1);
            objArr[2] = Integer.valueOf(0);
            if (Fw) {
                i = 0;
            }
            objArr[3] = Integer.valueOf(i);
            objArr[4] = MultiTalkRoomPopupNav.b(this.xLr);
            objArr[5] = Integer.valueOf(MultiTalkRoomPopupNav.c(this.xLr).field_roomId);
            objArr[6] = Long.valueOf(MultiTalkRoomPopupNav.c(this.xLr).field_roomKey);
            gVar.h(13945, objArr);
        } else {
            g.pQN.h(13945, new Object[]{Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), MultiTalkRoomPopupNav.b(this.xLr), Integer.valueOf(MultiTalkRoomPopupNav.c(this.xLr).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(this.xLr).field_roomKey)});
        }
        MultiTalkRoomPopupNav.e(this.xLr).xLs.setVisibility(8);
        MultiTalkRoomPopupNav.f(this.xLr).setVisibility(0);
        MultiTalkRoomPopupNav.g(this.xLr).setVisibility(0);
        MultiTalkRoomPopupNav.h(this.xLr).setVisibility(8);
    }
}
