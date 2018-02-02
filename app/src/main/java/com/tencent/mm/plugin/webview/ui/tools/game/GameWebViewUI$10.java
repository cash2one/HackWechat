package com.tencent.mm.plugin.webview.ui.tools.game;

import android.annotation.TargetApi;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.xweb.o;

class GameWebViewUI$10 implements o {
    final /* synthetic */ GameWebViewUI tFJ;

    GameWebViewUI$10(GameWebViewUI gameWebViewUI) {
        this.tFJ = gameWebViewUI;
    }

    public final boolean z(MotionEvent motionEvent) {
        if (GameWebViewUI.S(this.tFJ) == null) {
            return false;
        }
        return GameWebViewUI.T(this.tFJ).O(motionEvent);
    }

    public final boolean a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        if (GameWebViewUI.U(this.tFJ) == null) {
            return false;
        }
        return GameWebViewUI.V(this.tFJ).b(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    public final void ahE() {
        if (GameWebViewUI.W(this.tFJ) != null) {
            GameWebViewUI.X(this.tFJ).cyX();
        }
    }

    @TargetApi(9)
    public final void b(int i, int i2, boolean z, boolean z2) {
        if (GameWebViewUI.Y(this.tFJ) != null) {
            GameWebViewUI.Z(this.tFJ).c(i, i2, z, z2);
        }
    }

    public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
        if (GameWebViewUI.aa(this.tFJ) != null) {
            GameWebViewUI.ab(this.tFJ).x(i, i2, i3, i4);
            if (!GameWebViewUI.ac(this.tFJ)) {
                return;
            }
            if (i2 >= GameWebViewUI.ad(this.tFJ)) {
                if (GameWebViewUI.ae(this.tFJ)) {
                    GameWebViewUI.af(this.tFJ);
                }
            } else if (i2 < GameWebViewUI.ad(this.tFJ)) {
                GameWebViewUI.a(this.tFJ, (int) ((((float) i2) / ((float) GameWebViewUI.ad(this.tFJ))) * 255.0f));
            }
        }
    }

    public final boolean A(MotionEvent motionEvent) {
        if (GameWebViewUI.ag(this.tFJ) == null) {
            return false;
        }
        return GameWebViewUI.ah(this.tFJ).P(motionEvent);
    }

    public final boolean B(MotionEvent motionEvent) {
        if (GameWebViewUI.ai(this.tFJ) == null) {
            return false;
        }
        return GameWebViewUI.aj(this.tFJ).Q(motionEvent);
    }
}
