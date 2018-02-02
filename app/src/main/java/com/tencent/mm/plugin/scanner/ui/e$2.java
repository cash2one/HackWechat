package com.tencent.mm.plugin.scanner.ui;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mm.sdk.platformtools.x;

class e$2 implements OnGlobalLayoutListener {
    final /* synthetic */ e pVm;

    e$2(e eVar) {
        this.pVm = eVar;
    }

    public final void onGlobalLayout() {
        x.d("MicroMsg.scanner.PlainTextPreference", "summaryTv.getHeight() = " + e.b(this.pVm).getHeight() + ", summaryTv.getLineHeight() = " + e.b(this.pVm).getLineHeight());
        if (e.b(this.pVm).getText() != null && e.b(this.pVm).getHeight() > 0 && e.b(this.pVm).getLineHeight() > 0 && e.d(this.pVm) == null) {
            if (!(e.b(this.pVm).getHeight() / e.b(this.pVm).getLineHeight() <= 5 || this.pVm.pVi || this.pVm.pVh)) {
                e.a(this.pVm).setVisibility(0);
                e.b(this.pVm).setMaxLines(5);
                this.pVm.pVi = true;
                if (e.c(this.pVm) != null && e.c(this.pVm).ID(this.pVm.ibD) == null) {
                    e.c(this.pVm).a(this.pVm.ibD, Boolean.valueOf(false));
                    e.c(this.pVm).bpf();
                }
            }
            x.d("MicroMsg.scanner.PlainTextPreference", "summaryTv.getHeight() / summaryTv.getLineHeight() = " + (e.b(this.pVm).getHeight() / e.b(this.pVm).getLineHeight()));
        }
        e.b(this.pVm).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
}
