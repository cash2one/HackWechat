package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.e.b;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;

class SightCaptureUI$5 implements b {
    final /* synthetic */ SightCaptureUI oDb;

    SightCaptureUI$5(SightCaptureUI sightCaptureUI) {
        this.oDb = sightCaptureUI;
    }

    public final void a(byte[] bArr, int i, int i2, int i3, int i4) {
        int i5 = 180;
        if (bArr == null || i < 0 || i2 < 0 || i3 < 0) {
            x.e("MicroMsg.SightCaptureUI", "onPictureYuvTaken, data is null!!");
            SightCaptureUI.y(this.oDb);
            return;
        }
        x.i("MicroMsg.SightCaptureUI", "data frameWidth %s frameHeight %s rotate %s deviceDegree %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        SightCaptureUI.z(this.oDb);
        SightCaptureUI.A(this.oDb);
        SightCaptureUI.b(this.oDb, i);
        SightCaptureUI.c(this.oDb, i2);
        SightCaptureUI.d(this.oDb, i3);
        SightCaptureUI.e(this.oDb, i4);
        if (SightCaptureUI.B(this.oDb) != null) {
            j.ouM.D(SightCaptureUI.B(this.oDb));
            SightCaptureUI.a(this.oDb, null);
        }
        SightCaptureUI.a(this.oDb, j.ouM.h(Integer.valueOf(bArr.length)));
        System.arraycopy(bArr, 0, SightCaptureUI.B(this.oDb), 0, bArr.length);
        SightCaptureUI.a(this.oDb, e.b(new 1(this), "SightCaptureUI_saveCaptureBitmap"));
        SightCaptureUI.D(this.oDb).start();
        k.d(true, d.Fh("TIME_RECODER_2_PLAY"));
        if (SightCaptureUI.E(this.oDb)) {
            if (Math.abs(i3 - i4) != 0) {
                i5 = 0;
            }
            bArr = d.b(bArr, i, i2, i5 % 360);
            SightCaptureUI.c(this.oDb).a(bArr, true, 0);
        } else {
            if (i4 == 180) {
                i5 = i3 + i4;
            } else {
                i5 = i3;
            }
            if (i5 > 360) {
                i5 -= 360;
            }
            SightCaptureUI.c(this.oDb).a(bArr, false, i5);
        }
        SightCaptureUI.b(this.oDb, bArr);
        SightCaptureUI.f(this.oDb, i5);
        SightCaptureUI.g(this.oDb, 3);
        SightCaptureUI.G(this.oDb).post(new Runnable(this) {
            final /* synthetic */ SightCaptureUI$5 oDc;

            {
                this.oDc = r1;
            }

            public final void run() {
                SightCaptureUI.F(this.oDc.oDb);
            }
        });
        if (SightCaptureUI.a(this.oDb).scene == 1 || SightCaptureUI.a(this.oDb).scene == 2) {
            g.pQN.h(13819, new Object[]{Integer.valueOf(1), Integer.valueOf(SightCaptureUI.a(this.oDb).scene)});
        }
    }
}
