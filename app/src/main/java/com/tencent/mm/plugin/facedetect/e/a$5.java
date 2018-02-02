package com.tencent.mm.plugin.facedetect.e;

import com.tencent.mm.plugin.facedetect.e.a.a;
import com.tencent.mm.plugin.facedetect.model.FaceContextData;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.mmsight.model.a.d$a;
import com.tencent.mm.sdk.platformtools.x;

class a$5 implements d$a {
    final /* synthetic */ a mlr;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int kxT = 1;
        final /* synthetic */ a$5 mlx;

        AnonymousClass1(a$5 com_tencent_mm_plugin_facedetect_e_a_5, int i) {
            this.mlx = com_tencent_mm_plugin_facedetect_e_a_5;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            try {
                if (a.g(this.mlx.mlr) != null) {
                    a.g(this.mlx.mlr).reset();
                }
                a.d(this.mlx.mlr);
            } catch (Exception e) {
                x.e("MicroMsg.FaceVideoRecorder", "hy: onError, reset mediaRecorder error: %s", new Object[]{e.getMessage()});
            } catch (Throwable th) {
                a.d(this.mlx.mlr);
            }
            synchronized (a.a(this.mlx.mlr)) {
                a.e(this.mlx.mlr, a.mlA);
            }
            FaceDetectReporter.e(FaceContextData.aGt().mgb, 2, this.kxT);
        }
    }

    a$5(a aVar) {
        this.mlr = aVar;
    }

    public final void Yn() {
        x.e("MicroMsg.FaceVideoRecorder", "hy: video capture error: %d", new Object[]{Integer.valueOf(1)});
        a.s(this.mlr).F(new AnonymousClass1(this, 1));
    }
}
