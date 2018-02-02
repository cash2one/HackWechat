package com.tencent.mm.plugin.mmsight.model;

import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import com.tencent.mm.compatible.d.m;
import com.tencent.mm.plugin.base.model.a;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class e$1 implements PreviewCallback {
    final /* synthetic */ e osA;

    e$1(e eVar) {
        this.osA = eVar;
    }

    public final void onPreviewFrame(byte[] bArr, Camera camera) {
        boolean z = false;
        if (!e.a(this.osA)) {
            x.i("MicroMsg.MMSightCamera", "onPreviewFrame: %s %s", new Object[]{bArr, e.b(this.osA)});
            e.c(this.osA);
        }
        if (bArr == null || bArr.length <= 0) {
            x.e("MicroMsg.MMSightCamera", "onPreviewFrame, frame data is null!!");
            e.d(this.osA);
            return;
        }
        byte[] bArr2;
        a e = e.e(this.osA);
        if (e.kuB == 0) {
            e.kuA++;
            e.kuz = bh.VI(m.ys());
        }
        e.kuB++;
        e.kuB = e.kuB >= 90 ? 0 : e.kuB;
        if (e.f(this.osA) || e.g(this.osA) == null || e.g(this.osA).size() <= 0) {
            bArr2 = bArr;
        } else if (e.h(this.osA) != null) {
            byte[] h = j.ouM.h(Integer.valueOf(((e.h(this.osA).x * e.h(this.osA).y) * 3) / 2));
            e.i(this.osA).dN(1);
            r4 = bh.Wq();
            SightVideoJNI.cropCameraData(bArr, h, e.j(this.osA).mlb, e.j(this.osA).mlc, e.h(this.osA).y);
            e.k(this.osA).dN(bh.bA(r4));
            if (!e.l(this.osA)) {
                r4 = bh.Wq();
                r0 = e.h(this.osA).x;
                int i = e.h(this.osA).y;
                if (this.osA.orV.fFy == 270 || this.osA.orV.fFy == 90) {
                    z = true;
                }
                SightVideoJNI.mirrorCameraData(h, r0, i, z);
                e.m(this.osA).dN(bh.bA(r4));
            }
            long j = r4;
            boolean a = e.a(this.osA, h);
            j = bh.bA(j);
            if (a) {
                e.n(this.osA).dN(j);
            }
            bArr2 = h;
        } else {
            r4 = bh.Wq();
            if (!e.l(this.osA)) {
                r0 = e.j(this.osA).mlb;
                int i2 = e.j(this.osA).mlc;
                if (this.osA.orV.fFy == 270 || this.osA.orV.fFy == 90) {
                    z = true;
                }
                SightVideoJNI.mirrorCameraData(bArr, r0, i2, z);
                e.m(this.osA).dN(bh.bA(r4));
            }
            if (!e.o(this.osA) || e.p(this.osA) == null) {
                bArr2 = bArr;
            } else {
                SightVideoJNI.paddingYuvData16(bArr, e.p(this.osA), e.q(this.osA).x, e.r(this.osA).y, e.q(this.osA).y);
                bArr2 = e.p(this.osA);
            }
            z = e.a(this.osA, bArr2);
            long bA = bh.bA(r4);
            if (z) {
                e.n(this.osA).dN(bA);
            }
            if ((!e.o(this.osA) || e.p(this.osA) == null) && z) {
                bArr = j.ouM.h(Integer.valueOf(bArr.length));
            }
            if (e.o(this.osA) && e.p(this.osA) != null) {
                byte[] h2;
                e eVar = this.osA;
                if (z) {
                    h2 = j.ouM.h(Integer.valueOf(e.p(this.osA).length));
                } else {
                    h2 = e.p(this.osA);
                }
                e.b(eVar, h2);
            }
        }
        e.c(this.osA, bArr2);
        if (e.s(this.osA) == e.a.osB) {
            e.t(this.osA).dN(1);
        } else if (e.s(this.osA) == e.a.osC) {
            e.u(this.osA).dN(1);
        }
        e.b(this.osA).addCallbackBuffer(bArr);
    }
}
