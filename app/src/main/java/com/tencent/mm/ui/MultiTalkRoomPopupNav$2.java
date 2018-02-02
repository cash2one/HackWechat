package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.q.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MultiTalkRoomPopupNav.b;
import com.tencent.mm.ui.base.h;
import java.util.List;

class MultiTalkRoomPopupNav$2 implements OnClickListener {
    final /* synthetic */ String oGL;
    final /* synthetic */ MultiTalkRoomPopupNav xLr;

    MultiTalkRoomPopupNav$2(MultiTalkRoomPopupNav multiTalkRoomPopupNav, String str) {
        this.xLr = multiTalkRoomPopupNav;
        this.oGL = str;
    }

    public final void onClick(View view) {
        int i = 0;
        x.i("MicroMsg.MultiTalkRoomPopupNav", "click enter button..");
        if (this.oGL != null) {
            if (a.vcx.bcI()) {
                x.e("MicroMsg.MultiTalkRoomPopupNav", "now is in other voip..");
                h.b(this.xLr.getContext(), ac.getContext().getString(R.l.ews), null, true);
                return;
            }
            List Fu = a.vcx.Fu(MultiTalkRoomPopupNav.b(this.xLr));
            if (Fu.size() == 1) {
                MultiTalkRoomPopupNav.Yr(this.oGL);
                g.pQN.h(13945, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), MultiTalkRoomPopupNav.b(this.xLr), Integer.valueOf(MultiTalkRoomPopupNav.c(this.xLr).field_roomId), Long.valueOf(MultiTalkRoomPopupNav.c(this.xLr).field_roomKey)});
            } else if (Fu.size() >= 9) {
                x.e("MicroMsg.MultiTalkRoomPopupNav", "now is up to the limit,memberList size:" + Fu.size());
                h.b(this.xLr.getContext(), ac.getContext().getString(R.l.ewu, new Object[]{Integer.valueOf(9)}), null, true);
                g gVar = g.pQN;
                Object[] objArr = new Object[7];
                objArr[0] = Integer.valueOf(1);
                if (MultiTalkRoomPopupNav.d(this.xLr) == b.xLt) {
                    i = 1;
                }
                objArr[1] = Integer.valueOf(i);
                objArr[2] = Integer.valueOf(1);
                objArr[3] = Integer.valueOf(1);
                objArr[4] = MultiTalkRoomPopupNav.b(this.xLr);
                objArr[5] = Integer.valueOf(MultiTalkRoomPopupNav.c(this.xLr).field_roomId);
                objArr[6] = Long.valueOf(MultiTalkRoomPopupNav.c(this.xLr).field_roomKey);
                gVar.h(13945, objArr);
                return;
            } else if (a.vcx.bcH()) {
                x.e("MicroMsg.MultiTalkRoomPopupNav", "now is inviting other people voip..");
                h.b(this.xLr.getContext(), ac.getContext().getString(R.l.ewr), null, true);
                g gVar2 = g.pQN;
                Object[] objArr2 = new Object[7];
                objArr2[0] = Integer.valueOf(1);
                objArr2[1] = Integer.valueOf(MultiTalkRoomPopupNav.d(this.xLr) == b.xLt ? 1 : 0);
                objArr2[2] = Integer.valueOf(0);
                objArr2[3] = Integer.valueOf(1);
                objArr2[4] = MultiTalkRoomPopupNav.b(this.xLr);
                objArr2[5] = Integer.valueOf(MultiTalkRoomPopupNav.c(this.xLr).field_roomId);
                objArr2[6] = Long.valueOf(MultiTalkRoomPopupNav.c(this.xLr).field_roomKey);
                gVar2.h(13945, objArr2);
                return;
            } else {
                MultiTalkRoomPopupNav.a(this.xLr, this.oGL);
            }
        }
        MultiTalkRoomPopupNav.a.a(MultiTalkRoomPopupNav.e(this.xLr));
        MultiTalkRoomPopupNav.f(this.xLr).setVisibility(0);
        MultiTalkRoomPopupNav.g(this.xLr).setVisibility(0);
        MultiTalkRoomPopupNav.h(this.xLr).setVisibility(8);
    }
}
