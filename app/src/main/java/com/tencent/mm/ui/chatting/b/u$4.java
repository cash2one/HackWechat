package com.tencent.mm.ui.chatting.b;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.s;

class u$4 implements OnItemClickListener {
    final /* synthetic */ u yAV;

    u$4(u uVar) {
        this.yAV = uVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, final int i, long j) {
        au auVar = (au) this.yAV.ytQ.getItem(i);
        if (auVar != null && !bh.ov(auVar.field_talker)) {
            this.yAV.ctV();
            if (this.yAV.fhr.csA() != null) {
                s csA = this.yAV.fhr.csA();
                if (auVar == null) {
                    x.w("MicroMsg.ChattingMoreBtnBarHelper", "perform search mode click msg item fail, msg is null");
                } else if (csA.yrX.fW(auVar.field_msgId)) {
                    csA.ytP.Fu(csA.yrX.ytp.size());
                    csA.ytP.setVisibility(0);
                    csA.lcZ.cxX();
                }
            }
            if (!this.yAV.yAM) {
                this.yAV.yAM = true;
                this.yAV.fhr.csz().mo(true);
                this.yAV.fhr.csx().setTranscriptMode(0);
            }
            this.yAV.fhr.csz().mm(false);
            this.yAV.fhr.csz().mn(false);
            final int r = this.yAV.fhr.csy().r(auVar.field_msgId, false);
            this.yAV.fhr.csy().a(null, null);
            this.yAV.fhr.csx().post(new Runnable(this) {
                final /* synthetic */ u$4 yAW;

                public final void run() {
                    x.i("MicroMsg.ChattingUI.SearchImp", "on search click, click position %d, set selection %d", new Object[]{Integer.valueOf(i), Integer.valueOf(r)});
                    t.a(this.yAW.yAV.fhr.csx(), r, false);
                }
            });
        }
    }
}
