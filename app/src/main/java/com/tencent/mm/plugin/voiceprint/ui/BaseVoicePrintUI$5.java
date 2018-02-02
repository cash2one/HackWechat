package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.plugin.voiceprint.model.p;
import com.tencent.mm.plugin.voiceprint.ui.VoiceTipInfoView.3;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af.a;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.x;

class BaseVoicePrintUI$5 implements a {
    final /* synthetic */ BaseVoicePrintUI shC;

    BaseVoicePrintUI$5(BaseVoicePrintUI baseVoicePrintUI) {
        this.shC = baseVoicePrintUI;
    }

    public final boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        x.d("MicroMsg.BaseVoicePrintUI", "start record");
        ar.b(ac.getContext(), R.l.eQT, new 1(this));
        BaseVoicePrintUI.a(this.shC, "voice_pt_voice_print_record.rec");
        p a = BaseVoicePrintUI.a(this.shC);
        String d = BaseVoicePrintUI.d(this.shC);
        Context context = this.shC;
        a.fileName = d;
        x.d("MicroMsg.VoicePrintRecoder", "start filename %s", new Object[]{a.fileName});
        com.tencent.mm.z.ar.Hh().a(a);
        int xI = com.tencent.mm.z.ar.Hh().xI();
        a.rWz = false;
        a.hXN = new b(context);
        if (xI != 0) {
            a.er(100);
        } else {
            new p$1(a).sendEmptyMessageDelayed(0, 50);
        }
        BaseVoicePrintUI.e(this.shC).J(100, 100);
        BaseVoicePrintUI baseVoicePrintUI = this.shC;
        baseVoicePrintUI.sht.bGa();
        VoiceTipInfoView voiceTipInfoView = baseVoicePrintUI.sht;
        x.d("MicroMsg.VoiceTipInfoView", "hideTitle, titleTv.getVisibility:%d, mAnimingTitle:%b", new Object[]{Integer.valueOf(voiceTipInfoView.jJn.getVisibility()), Boolean.valueOf(voiceTipInfoView.siw)});
        if (voiceTipInfoView.jJn.getVisibility() != 0 || voiceTipInfoView.siw) {
            x.d("MicroMsg.VoiceTipInfoView", "hideTitle, directly set to INVISIBLE");
            voiceTipInfoView.jJn.clearAnimation();
            voiceTipInfoView.jJn.setVisibility(4);
            voiceTipInfoView.jJn.invalidate();
        } else {
            voiceTipInfoView.jJn.clearAnimation();
            voiceTipInfoView.siw = true;
            a.a(voiceTipInfoView.jJn, voiceTipInfoView.getContext(), new 3(voiceTipInfoView));
        }
        baseVoicePrintUI.sht.MB(baseVoicePrintUI.sgZ);
        baseVoicePrintUI.shA.TG();
        baseVoicePrintUI.shA.J(500, 500);
        baseVoicePrintUI.shr.setVisibility(0);
        VoicePrintVolumeMeter voicePrintVolumeMeter = baseVoicePrintUI.shs;
        voicePrintVolumeMeter.reset();
        voicePrintVolumeMeter.mIsPlaying = true;
        long j = (long) VoicePrintVolumeMeter.nVA;
        voicePrintVolumeMeter.sif.J(j, j);
        voicePrintVolumeMeter.bFT();
        return true;
    }
}
