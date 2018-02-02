package com.tencent.mm.plugin.mmsight.ui;

import android.widget.Toast;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.e;
import com.tencent.mm.plugin.u.a.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ae;

class SightCaptureUI$21 implements MMSightRecordButton$b {
    final /* synthetic */ SightCaptureUI oDb;

    SightCaptureUI$21(SightCaptureUI sightCaptureUI) {
        this.oDb = sightCaptureUI;
    }

    public final void bbv() {
        x.i("MicroMsg.SightCaptureUI", "onPressDown, currentStatus: %s", new Object[]{Integer.valueOf(SightCaptureUI.e(this.oDb))});
        if (SightCaptureUI.e(this.oDb) != 0 && SightCaptureUI.h(this.oDb) != null && SightCaptureUI.h(this.oDb).orS) {
            int[] iArr = new int[2];
            SightCaptureUI.i(this.oDb).getLocationOnScreen(iArr);
            e h = SightCaptureUI.h(this.oDb);
            int i = iArr[1];
            if (h.orO <= 0) {
                int i2 = ae.fz(ac.getContext()).y;
                x.i("MicroMsg.MMSightCamera", "calcScrollZoomStep, recordButtonTopLocation: %s, screenSize: %s", new Object[]{Integer.valueOf(i), r2});
                if (i2 / 2 < i) {
                    try {
                        if (h.gEB != null) {
                            h.orO = ((int) (((double) h.gEB.getParameters().getMaxZoom()) / ((((double) i) / 3.0d) / 10.0d))) + 1;
                            x.i("MicroMsg.MMSightCamera", "scrollSmallZoomStep: %s, maxZoom: %s", new Object[]{Integer.valueOf(h.orO), Integer.valueOf(r2)});
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.MMSightCamera", "calcScrollZoomStep error: %s", new Object[]{e.getMessage()});
                    }
                }
            }
            if (SightCaptureUI.j(this.oDb) == 0) {
                SightCaptureUI.a(this.oDb, SightCaptureUI.k(this.oDb));
            }
        }
    }

    public final void bbw() {
        if (SightCaptureUI.e(this.oDb) != 0 && SightCaptureUI.h(this.oDb) != null && SightCaptureUI.h(this.oDb).orS) {
            SightCaptureUI.l(this.oDb);
            x.i("MicroMsg.TestCaptureUiEvent", "onLongPress %s", new Object[]{bh.cgy().toString()});
            SightCaptureUI.m(this.oDb);
        }
    }

    public final void bbx() {
        String str = "MicroMsg.TestCaptureUiEvent";
        String str2 = "onLongPressFinish %s, recorder: %s, recordTime: %s";
        Object[] objArr = new Object[3];
        objArr[0] = bh.cgy().toString();
        objArr[1] = SightCaptureUI.n(this.oDb);
        objArr[2] = Long.valueOf(SightCaptureUI.n(this.oDb) != null ? SightCaptureUI.n(this.oDb).bax() : 0);
        x.i(str, str2, objArr);
        if (SightCaptureUI.j(this.oDb) == 0) {
            if (SightCaptureUI.n(this.oDb) == null || SightCaptureUI.n(this.oDb).bax() > 1000 || SightCaptureUI.n(this.oDb).baz() != c.oua) {
                SightCaptureUI.p(this.oDb);
                return;
            }
            x.i("MicroMsg.SightCaptureUI", "video record too short, cancel and convert to takepicture");
            SightCaptureUI.n(this.oDb).cancel();
            if (SightCaptureUI.j(this.oDb) == 0) {
                SightCaptureUI.o(this.oDb);
            }
        } else if (SightCaptureUI.j(this.oDb) != 1) {
        } else {
            if ((SightCaptureUI.n(this.oDb) == null || SightCaptureUI.n(this.oDb).bax() > 1000) && SightCaptureUI.n(this.oDb) != null) {
                SightCaptureUI.p(this.oDb);
                return;
            }
            x.i("MicroMsg.SightCaptureUI", "video record too short");
            Toast.makeText(this.oDb, f.oFi, 1).show();
            SightCaptureUI.q(this.oDb);
        }
    }
}
