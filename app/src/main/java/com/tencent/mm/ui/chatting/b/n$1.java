package com.tencent.mm.ui.chatting.b;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.d;
import com.tencent.mm.sdk.platformtools.x;

class n$1 implements d {
    private Animation yAm;
    private Animation yAn;
    final /* synthetic */ n yAo;

    n$1(n nVar) {
        this.yAo = nVar;
    }

    public final boolean ln(boolean z) {
        if (this.yAm == null) {
            this.yAm = AnimationUtils.loadAnimation(this.yAo.fhr.csq().getContext(), R.a.bqo);
            this.yAn = AnimationUtils.loadAnimation(this.yAo.fhr.csq().getContext(), R.a.bqm);
        }
        if (z) {
            x.i("MicroMsg.ChattingUI.FootMgr", "switchFooterToInput customFooter is %s", new Object[]{this.yAo.yAd});
            if (this.yAo.yAd != null) {
                this.yAo.yAd.startAnimation(this.yAn);
            }
            this.yAo.ctJ();
            this.yAo.one.startAnimation(this.yAm);
            this.yAo.one.postInvalidateDelayed(this.yAm.getDuration());
        } else {
            this.yAo.fhr.csq().hideVKB();
            this.yAo.one.startAnimation(this.yAn);
            this.yAo.ctI();
            if (this.yAo.yAd != null) {
                this.yAo.yAd.startAnimation(this.yAm);
                this.yAo.yAd.postInvalidateDelayed(this.yAm.getDuration());
            }
        }
        return false;
    }
}
