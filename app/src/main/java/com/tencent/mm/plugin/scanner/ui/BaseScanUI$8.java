package com.tencent.mm.plugin.scanner.ui;

import android.animation.ValueAnimator;
import com.tencent.mm.g.a.ok;
import com.tencent.mm.plugin.scanner.a.l;
import com.tencent.mm.plugin.scanner.ui.ScannerFlashSwitcher.1;
import com.tencent.mm.plugin.scanner.ui.ScannerFlashSwitcher.2;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class BaseScanUI$8 extends c<ok> {
    final /* synthetic */ BaseScanUI pUR;

    BaseScanUI$8(BaseScanUI baseScanUI) {
        this.pUR = baseScanUI;
        this.xen = ok.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ok okVar = (ok) bVar;
        if (BaseScanUI.f(this.pUR) != null && BaseScanUI.f(this.pUR).mgX && BaseScanUI.b(this.pUR)) {
            if (okVar.fGo.fGp) {
                String focusMode = BaseScanUI.f(this.pUR).getFocusMode();
                if (!bh.ov(focusMode) && focusMode.equals("continuous-video")) {
                    BaseScanUI.D(this.pUR);
                    if (BaseScanUI.E(this.pUR) >= 2) {
                        BaseScanUI.F(this.pUR);
                    }
                }
                if (!(BaseScanUI.g(this.pUR) == null || BaseScanUI.g(this.pUR).isShown())) {
                    ScannerFlashSwitcher g = BaseScanUI.g(this.pUR);
                    x.i("MicroMsg.ScannerFlashSwitcher", "show, isFirstShow: %s", new Object[]{Boolean.valueOf(g.pYL)});
                    if (g.pYL) {
                        g.pYJ.setAlpha(0.0f);
                        g.pYK.setAlpha(0.0f);
                        g.setVisibility(0);
                        g.pYK.animate().alpha(1.0f).setListener(null).setDuration(500);
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                        ofFloat.addUpdateListener(new 1(g));
                        ofFloat.setRepeatCount(3);
                        ofFloat.setRepeatMode(2);
                        ofFloat.setDuration(500);
                        ofFloat.addListener(new 2(g));
                        ofFloat.start();
                        g.pYL = false;
                    } else {
                        g.setVisibility(0);
                        g.pYK.animate().alpha(1.0f).setDuration(500).setListener(null).start();
                        g.pYJ.animate().alpha(1.0f).setDuration(500).setListener(null).start();
                    }
                    g.setEnabled(true);
                    l.pST.vF(1);
                    if (BaseScanUI.h(this.pUR) != null) {
                        BaseScanUI.h(this.pUR).hK(false);
                    }
                }
            } else {
                BaseScanUI.F(this.pUR);
                if (!(BaseScanUI.g(this.pUR) == null || BaseScanUI.f(this.pUR).osh)) {
                    BaseScanUI.g(this.pUR).hide();
                    if (BaseScanUI.h(this.pUR) != null) {
                        BaseScanUI.h(this.pUR).hK(true);
                    }
                }
            }
        }
        return false;
    }
}
