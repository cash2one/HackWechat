package com.tencent.mm.plugin.record.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.p.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.u;

class RecordVoiceBaseView$1 implements OnClickListener {
    final /* synthetic */ RecordVoiceBaseView pGD;

    RecordVoiceBaseView$1(RecordVoiceBaseView recordVoiceBaseView) {
        this.pGD = recordVoiceBaseView;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.RecordVoiceBaseView", "clicked path %s, isPlay %s", new Object[]{RecordVoiceBaseView.a(this.pGD), Boolean.valueOf(RecordVoiceBaseView.b(this.pGD).aIA())});
        if (!a.aW(RecordVoiceBaseView.c(this.pGD)) && !a.aU(RecordVoiceBaseView.c(this.pGD))) {
            if (!f.ze() && !bh.ov(RecordVoiceBaseView.a(this.pGD))) {
                u.fI(view.getContext());
            } else if (!bh.az(RecordVoiceBaseView.a(this.pGD), "").equals(RecordVoiceBaseView.b(this.pGD).path)) {
                RecordVoiceBaseView.d(this.pGD);
            } else if (RecordVoiceBaseView.b(this.pGD).aIA()) {
                this.pGD.stopPlay();
            } else if (!RecordVoiceBaseView.e(this.pGD)) {
                RecordVoiceBaseView.d(this.pGD);
            }
        }
    }
}
