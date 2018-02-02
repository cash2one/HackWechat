package com.tencent.mm.plugin.favorite.ui.post;

import com.tencent.mm.e.b.j;
import com.tencent.mm.sdk.platformtools.ak.a;

class FavPostVoiceUI$1 implements a {
    final /* synthetic */ FavPostVoiceUI myN;

    FavPostVoiceUI$1(FavPostVoiceUI favPostVoiceUI) {
        this.myN = favPostVoiceUI;
    }

    public final boolean uF() {
        int maxAmplitude;
        int i = 0;
        j a = FavPostVoiceUI.a(this.myN);
        if (a.status == 1) {
            maxAmplitude = a.fmf.getMaxAmplitude();
            if (maxAmplitude > j.fmh) {
                j.fmh = maxAmplitude;
            }
            maxAmplitude = (maxAmplitude * 100) / j.fmh;
        } else {
            maxAmplitude = 0;
        }
        while (i < FavPostVoiceUI.Bo().length) {
            if (maxAmplitude >= FavPostVoiceUI.aJR()[i] && maxAmplitude < FavPostVoiceUI.aJR()[i + 1]) {
                FavPostVoiceUI.b(this.myN).setBackgroundResource(FavPostVoiceUI.Bo()[i]);
                break;
            }
            i++;
        }
        return true;
    }
}
