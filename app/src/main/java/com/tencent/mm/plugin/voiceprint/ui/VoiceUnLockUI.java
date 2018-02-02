package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.voiceprint.model.d;
import com.tencent.mm.plugin.voiceprint.model.j;
import com.tencent.mm.plugin.voiceprint.model.q;
import com.tencent.mm.plugin.voiceprint.model.q.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public class VoiceUnLockUI extends BaseVoicePrintUI implements a {
    private q siC;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.siC = new q(this);
        x.d("MicroMsg.VoicePrintUnLockService", "getVoiceText");
        ar.CG().a(new d(73, ""), 0);
    }

    protected final void bFM() {
        x.d("MicroMsg.VoiceUnLockUI", "sendVoice, filename:%s", this.shv);
        if (!bh.ov(this.shv) && !bh.ov(this.siC.sgZ)) {
            k jVar = new j(this.shv, this.siC.sha);
            jVar.sgG = true;
            ar.CG().a(jVar, 0);
            this.shq.setEnabled(false);
            this.sht.bFV();
        }
    }

    protected final void aWr() {
        findViewById(R.h.cId).setVisibility(8);
        this.sht.bFV();
        this.sht.ys(R.l.eTA);
        this.sht.bFY();
        this.shq.setEnabled(false);
    }

    public final void MA(String str) {
        this.sgZ = str;
        this.sht.bFX();
        this.sht.MB(str);
        this.sht.bFW();
        this.shq.setEnabled(true);
    }

    public final void jc(boolean z) {
        this.sht.bFW();
        this.shq.setEnabled(true);
        if (z) {
            x.d("MicroMsg.VoiceUnLockUI", "unlock success");
            bFU();
            return;
        }
        this.sht.yt(R.l.eTz);
        this.sht.bFZ();
    }

    protected void bFU() {
        Intent intent = new Intent();
        intent.putExtra("kscene_type", 73);
        intent.setClass(this, VoicePrintFinishUI.class);
        startActivity(intent);
        finish();
    }

    public final void bFF() {
        bFL();
    }

    protected void onDestroy() {
        super.onDestroy();
        e eVar = this.siC;
        ar.CG().b(611, eVar);
        ar.CG().b(613, eVar);
        eVar.shp = null;
    }
}
