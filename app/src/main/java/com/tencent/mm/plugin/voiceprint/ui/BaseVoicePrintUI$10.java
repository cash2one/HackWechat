package com.tencent.mm.plugin.voiceprint.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class BaseVoicePrintUI$10 implements OnTouchListener {
    private long nVh = 0;
    final /* synthetic */ BaseVoicePrintUI shC;
    private boolean shE = false;

    BaseVoicePrintUI$10(BaseVoicePrintUI baseVoicePrintUI) {
        this.shC = baseVoicePrintUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                BaseVoicePrintUI.a(this.shC, false);
                if (!bh.ov(this.shC.sgZ)) {
                    this.nVh = System.currentTimeMillis();
                    BaseVoicePrintUI.f(this.shC).setPressed(true);
                    BaseVoicePrintUI.l(this.shC);
                    this.shC.bFK();
                    BaseVoicePrintUI.m(this.shC).sendEmptyMessageDelayed(1, 300);
                    x.i("MicroMsg.BaseVoicePrintUI", "mic press down");
                    break;
                }
                break;
            case 1:
            case 3:
                BaseVoicePrintUI.f(this.shC).setPressed(false);
                BaseVoicePrintUI.m(this.shC).removeMessages(1);
                if (System.currentTimeMillis() - this.nVh < 300) {
                    x.d("MicroMsg.BaseVoicePrintUI", "just little touch the button, set touchDown to false");
                    BaseVoicePrintUI.a(this.shC, false);
                } else {
                    BaseVoicePrintUI.a(this.shC, true);
                }
                x.i("MicroMsg.BaseVoicePrintUI", "mic press up %d, hasTouchDown:%b", new Object[]{Integer.valueOf(motionEvent.getAction()), Boolean.valueOf(BaseVoicePrintUI.n(this.shC))});
                BaseVoicePrintUI.g(this.shC).stop();
                BaseVoicePrintUI.e(this.shC).TG();
                BaseVoicePrintUI.a(this.shC).vo();
                if (!BaseVoicePrintUI.n(this.shC)) {
                    BaseVoicePrintUI.c(this.shC).yt(R.l.eTB);
                    BaseVoicePrintUI.c(this.shC).bFZ();
                    break;
                }
                BaseVoicePrintUI baseVoicePrintUI = this.shC;
                x.d("MicroMsg.BaseVoicePrintUI", "releaseMic");
                if (!baseVoicePrintUI.shu.shk) {
                    baseVoicePrintUI.shA.TG();
                    baseVoicePrintUI.sht.yt(R.l.eTB);
                    baseVoicePrintUI.sht.bFZ();
                    baseVoicePrintUI.shv = null;
                }
                baseVoicePrintUI.shr.setVisibility(8);
                baseVoicePrintUI.sht.bFX();
                baseVoicePrintUI.sht.MB(baseVoicePrintUI.sgZ);
                x.d("MicroMsg.BaseVoicePrintUI", "localMsgFileName %s", new Object[]{BaseVoicePrintUI.d(this.shC)});
                if (!bh.ov(BaseVoicePrintUI.d(this.shC))) {
                    this.shC.bFM();
                }
                this.nVh = 0;
                this.shE = false;
                BaseVoicePrintUI.a(this.shC, false);
                break;
        }
        return false;
    }
}
