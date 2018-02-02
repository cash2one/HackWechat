package com.tencent.mm.plugin.facedetect.views;

import com.tencent.mm.plugin.facedetect.a$h;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.sdk.platformtools.x;

class FaceDetectView$1 implements b {
    final /* synthetic */ FaceDetectView mmK;

    FaceDetectView$1(FaceDetectView faceDetectView) {
        this.mmK = faceDetectView;
    }

    public final void b(int i, CharSequence charSequence) {
        x.e("MicroMsg.FaceDetectView", "hy: onDetectError: %d, %s", Integer.valueOf(i), charSequence);
        if (FaceDetectView.a(this.mmK) || FaceDetectView.b(this.mmK)) {
            x.w("MicroMsg.FaceDetectView", "hy: already end or paused");
        } else if (FaceDetectView.c(this.mmK) == null || !FaceDetectView.c(this.mmK).aGV()) {
            this.mmK.eV(false);
            FaceDetectView.a(this.mmK, true);
            FaceDetectView.a(this.mmK, charSequence != null ? charSequence.toString() : this.mmK.getContext().getString(a$h.mdO));
            if (FaceDetectView.d(this.mmK) != null) {
                FaceDetectView.d(this.mmK).K(i, charSequence != null ? charSequence.toString() : this.mmK.getContext().getString(a$h.mdO));
            }
        } else {
            x.e("MicroMsg.FaceDetectView", "hy: motion eat result");
            FaceDetectView.a(this.mmK, FaceDetectView.c(this.mmK).aGY());
        }
    }

    public final void c(FaceCharacteristicsResult faceCharacteristicsResult) {
        int i = faceCharacteristicsResult.errCode;
        String str = faceCharacteristicsResult.fnL;
        x.v("MicroMsg.FaceDetectView", "hy: onDetectHelp: %d, %s", Integer.valueOf(i), str);
        if (FaceDetectView.a(this.mmK) || FaceDetectView.b(this.mmK)) {
            x.w("MicroMsg.FaceDetectView", "hy: already end");
        } else if (FaceDetectView.c(this.mmK) == null || !FaceDetectView.c(this.mmK).a(faceCharacteristicsResult)) {
            FaceDetectView.e(this.mmK);
            if (!FaceDetectView.f(this.mmK)) {
                return;
            }
            if (FaceDetectView.g(this.mmK) || !(faceCharacteristicsResult.errCode == 10 || faceCharacteristicsResult.errCode == 11)) {
                FaceDetectView.a(this.mmK, FaceCharacteristicsResult.pq(i));
                FaceDetectView faceDetectView = this.mmK;
                if (str == null) {
                    str = "";
                }
                FaceDetectView.a(faceDetectView, str);
            }
        } else {
            x.e("MicroMsg.FaceDetectView", "hy: motion eat result");
            FaceDetectView.a(this.mmK, FaceDetectView.c(this.mmK).aGY());
        }
    }

    public final void d(FaceCharacteristicsResult faceCharacteristicsResult) {
        x.d("MicroMsg.FaceDetectView", "hy: onDetectSucceed: %s", faceCharacteristicsResult.toString());
        if (FaceDetectView.a(this.mmK) || FaceDetectView.b(this.mmK)) {
            x.w("MicroMsg.FaceDetectView", "hy: already end pr paused");
        } else if (FaceDetectView.c(this.mmK) == null || !FaceDetectView.c(this.mmK).b(faceCharacteristicsResult)) {
            FaceDetectView.a(this.mmK, false);
            if ((FaceDetectView.c(this.mmK) != null && FaceDetectView.c(this.mmK).aGU()) || FaceDetectView.f(this.mmK)) {
                FaceDetectView.h(this.mmK);
                FaceDetectView.e(this.mmK);
            }
        } else {
            x.e("MicroMsg.FaceDetectView", "hy: motion eat result");
            FaceDetectView.a(this.mmK, FaceDetectView.c(this.mmK).aGY());
        }
    }
}
