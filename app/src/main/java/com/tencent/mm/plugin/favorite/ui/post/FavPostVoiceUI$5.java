package com.tencent.mm.plugin.favorite.ui.post;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.x;

class FavPostVoiceUI$5 implements OnTouchListener {
    final /* synthetic */ FavPostVoiceUI myN;

    FavPostVoiceUI$5(FavPostVoiceUI favPostVoiceUI) {
        this.myN = favPostVoiceUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == FavPostVoiceUI.g(this.myN)) {
            int rawY = (int) motionEvent.getRawY();
            int[] iArr = new int[2];
            FavPostVoiceUI.a(this.myN, this.myN.getResources().getDisplayMetrics().heightPixels);
            FavPostVoiceUI.g(this.myN).getLocationOnScreen(iArr);
            int i = iArr[1];
            switch (motionEvent.getAction()) {
                case 0:
                    if (!FavPostVoiceUI.h(this.myN)) {
                        FavPostVoiceUI.i(this.myN);
                        FavPostVoiceUI.j(this.myN);
                        break;
                    }
                    break;
                case 1:
                    if (FavPostVoiceUI.h(this.myN)) {
                        if (FavPostVoiceUI.m(this.myN).getVisibility() != 0) {
                            if (!FavPostVoiceUI.o(this.myN)) {
                                FavPostVoiceUI.p(this.myN);
                                break;
                            }
                        }
                        x.w("MicroMsg.FavPostVoiceUI", "action up -> cancel");
                        FavPostVoiceUI.n(this.myN);
                        break;
                    }
                    break;
                case 2:
                    if (rawY <= FavPostVoiceUI.k(this.myN) - b.b(this.myN, 60.0f) && rawY < i) {
                        FavPostVoiceUI.l(this.myN).setVisibility(8);
                        FavPostVoiceUI.m(this.myN).setVisibility(0);
                        break;
                    }
                    FavPostVoiceUI.l(this.myN).setVisibility(0);
                    FavPostVoiceUI.m(this.myN).setVisibility(8);
                    break;
                case 3:
                    x.w("MicroMsg.FavPostVoiceUI", "action cancel");
                    FavPostVoiceUI.n(this.myN);
                    break;
                default:
                    break;
            }
        }
        return false;
    }
}
