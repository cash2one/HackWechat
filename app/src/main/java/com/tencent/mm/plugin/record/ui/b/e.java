package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.record.b.m;
import com.tencent.mm.plugin.record.ui.RecordVoiceBaseView;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class e implements b {
    private m pGC = new m();
    RecordVoiceBaseView pGU;

    public final View dp(Context context) {
        View inflate = View.inflate(context, R.i.dqx, null);
        RecordVoiceBaseView recordVoiceBaseView = (RecordVoiceBaseView) inflate.findViewById(R.h.cWx);
        recordVoiceBaseView.pGC = this.pGC;
        m mVar = recordVoiceBaseView.pGC;
        for (Object obj : mVar.gxL) {
            if (recordVoiceBaseView == obj) {
                break;
            }
        }
        mVar.gxL.add(recordVoiceBaseView);
        return inflate;
    }

    public final void a(View view, int i, com.tencent.mm.plugin.record.ui.a.b bVar) {
        View findViewById = view.findViewById(R.h.cew);
        this.pGU = (RecordVoiceBaseView) view.findViewById(R.h.cWx);
        if (bVar.bjS == 0) {
            this.pGU.setVisibility(8);
            findViewById.setVisibility(0);
        } else if (bVar.bjS == 1) {
            findViewById.setVisibility(8);
            this.pGU.setVisibility(0);
            String a = com.tencent.mm.plugin.record.b.b.a(bVar);
            com.tencent.mm.sdk.b.b fvVar = new fv();
            fvVar.fvq.type = 17;
            fvVar.fvq.fvs = bVar.fve;
            a.xef.m(fvVar);
            int i2 = fvVar.fvr.ret;
            if (!com.tencent.mm.a.e.bO(a)) {
                if (bh.ov(bVar.fve.wcJ)) {
                    findViewById.setVisibility(0);
                    this.pGU.setVisibility(8);
                } else {
                    x.d("MicroMsg.VoiceViewWrapper", "restart voice %s, url %s", new Object[]{Long.valueOf(bVar.pFG.field_localId), bVar.fve.wcJ});
                    com.tencent.mm.sdk.b.b fvVar2 = new fv();
                    fvVar2.fvq.type = 16;
                    fvVar2.fvq.fqk = bVar.pFG.field_localId;
                    a.xef.m(fvVar2);
                }
            }
            RecordVoiceBaseView recordVoiceBaseView = this.pGU;
            int i3 = bVar.fve.duration;
            recordVoiceBaseView.path = bh.az(a, "");
            recordVoiceBaseView.fvx = i2;
            if (recordVoiceBaseView.duration != i3) {
                recordVoiceBaseView.duration = i3;
                recordVoiceBaseView.setText(((int) q.bv((long) i3)) + "''");
            }
        }
    }

    public final void destroy() {
        m mVar = this.pGC;
        mVar.stopPlay();
        mVar.arT();
        m.kCP = null;
        mVar.gxL.clear();
    }

    public final void pause() {
        if (this.pGC != null && this.pGC.gxL.size() > 0) {
            for (m.a onFinish : this.pGC.gxL) {
                onFinish.onFinish();
            }
        }
    }
}
