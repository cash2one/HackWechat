package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voiceprint.model.e;
import com.tencent.mm.plugin.voiceprint.model.h;
import com.tencent.mm.plugin.voiceprint.model.n;
import com.tencent.mm.plugin.voiceprint.model.n.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public class VoiceLoginUI extends BaseVoicePrintUI implements a {
    private String jKk = null;
    private n shV = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.pQN.h(11557, new Object[]{Integer.valueOf(1)});
        this.jKk = bh.az(getIntent().getStringExtra("Kusername"), null);
        String az = bh.az(getIntent().getStringExtra("Kvertify_key"), null);
        x.d("MicroMsg.VoiceLoginUI", "summerauth onCreate, username:%s loginTicket==null:%b", new Object[]{this.jKk, Boolean.valueOf(bh.ov(az))});
        if (bh.ov(this.jKk) && bh.ov(az)) {
            x.e("MicroMsg.VoiceLoginUI", "onCreate error, username and ticket are both null");
            return;
        }
        this.shV = new n();
        this.shV.jKk = this.jKk;
        this.shV.iPV = az;
        this.shV.shc = this;
        n nVar = this.shV;
        if (bh.ov(nVar.iPV)) {
            ar.CG().a(new e(nVar.jKk), 0);
        } else {
            nVar.bFG();
        }
        boolean a = com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 80, "", "");
        x.i("MicroMsg.VoiceLoginUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a), bh.cgy(), this});
        setBackBtn(new 1(this));
    }

    protected final void bFM() {
        x.d("MicroMsg.VoiceLoginUI", "sendVoice, filename:%s", new Object[]{this.shv});
        if (!bh.ov(this.shv) && !bh.ov(this.sgZ)) {
            n nVar = this.shV;
            k hVar = new h(this.shv, nVar.sha, nVar.iPV);
            hVar.sgG = true;
            ar.CG().a(hVar, 0);
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

    private void goBack() {
        setResult(0);
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    public final void MA(String str) {
        x.d("MicroMsg.VoiceLoginUI", "onGetText");
        this.sgZ = str;
        this.sht.bFX();
        this.sht.MB(str);
        this.sht.bFW();
        this.shq.setEnabled(true);
    }

    public final void jb(boolean z) {
        this.sht.bFW();
        this.shq.setEnabled(true);
        if (z) {
            x.i("MicroMsg.VoiceLoginUI", "login success[%s]", new Object[]{bh.VT(this.shV.sgP)});
            Intent intent = new Intent();
            intent.putExtra("VoiceLoginAuthPwd", this.shV.sgP);
            setResult(-1, intent);
            finish();
            return;
        }
        x.i("MicroMsg.VoiceLoginUI", "login failed");
        this.sht.yt(R.l.eTz);
        this.sht.bFZ();
    }

    public final void bFF() {
        yr(R.l.eTD);
    }

    public final void bFH() {
        this.shq.setEnabled(false);
        this.shq.setVisibility(4);
        this.sht.bFW();
        this.sht.yt(R.l.eTC);
        this.sht.bFZ();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.shV != null) {
            Object obj = this.shV;
            ar.CG().b(618, obj);
            ar.CG().b(616, obj);
            ar.CG().b(617, obj);
            obj.shc = null;
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.VoiceLoginUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 80:
                if (iArr[0] == 0) {
                    bFJ();
                    return;
                } else {
                    com.tencent.mm.ui.base.h.a(this, getString(R.l.ezQ), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new 2(this), new 3(this));
                    return;
                }
            default:
                return;
        }
    }
}
