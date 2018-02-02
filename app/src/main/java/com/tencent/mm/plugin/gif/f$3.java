package com.tencent.mm.plugin.gif;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class f$3 implements Runnable {
    final /* synthetic */ f nzv;

    f$3(f fVar) {
        this.nzv = fVar;
    }

    public final void run() {
        if (f.f(this.nzv)) {
            x.d("MicroMsg.GIF.MMWXGFDrawable", "Cpan Render Task is Running.");
        } else if (f.a(this.nzv)) {
            x.i("MicroMsg.GIF.MMWXGFDrawable", "Cpan This WXGF had been recycle.");
        } else if (f.g(this.nzv) == null || f.g(this.nzv).isRecycled()) {
            x.i("MicroMsg.GIF.MMWXGFDrawable", "Cpan This WXGF is null or had been recycle.");
        } else if (f.h(this.nzv) == 0) {
            x.i("MicroMsg.GIF.MMWXGFDrawable", "Cpan This WXGF JNIHandle is null.");
            g.pQN.a(401, 18, 1, false);
        } else {
            f.a(this.nzv, true);
            long currentTimeMillis = System.currentTimeMillis();
            int nativeDecodeBufferFrame = MMWXGFJNI.nativeDecodeBufferFrame(f.h(this.nzv), null, 0, f.g(this.nzv), f.i(this.nzv));
            if (nativeDecodeBufferFrame == -904) {
                x.i("MicroMsg.GIF.MMWXGFDrawable", "nativeDecodeBufferFrame failed. func is null.");
                g.pQN.a(401, 8, 1, false);
                return;
            }
            if (nativeDecodeBufferFrame == -909) {
                x.i("MicroMsg.GIF.MMWXGFDrawable", "nativeDecodeBufferFrame failed. frame is null.");
                g.pQN.a(401, 11, 1, false);
            } else if (nativeDecodeBufferFrame == -1) {
                x.i("MicroMsg.GIF.MMWXGFDrawable", "nativeDecodeBufferFrame failed.");
                return;
            }
            f.a(this.nzv, f.b(this.nzv) + 1);
            if (f.b(this.nzv) >= f.j(this.nzv) - 1 || nativeDecodeBufferFrame == 1) {
                f.a(this.nzv, -1);
                nativeDecodeBufferFrame = MMWXGFJNI.nativeRewindBuffer(f.h(this.nzv));
                if (nativeDecodeBufferFrame != 0) {
                    if (nativeDecodeBufferFrame == -905) {
                        g.pQN.a(711, 9, 1, false);
                    }
                    x.w("MicroMsg.GIF.MMWXGFDrawable", "Cpan Rewind buffer failed.");
                    return;
                }
            }
            f.b(this.nzv, System.currentTimeMillis() - currentTimeMillis);
            if (f.k(this.nzv) != 0) {
                f.c(this.nzv, (f.k(this.nzv) - f.l(this.nzv)) - f.m(this.nzv));
                if (f.e(this.nzv) < 0) {
                    x.d("MicroMsg.GIF.MMWXGFDrawable", "Render time:%d InvalidateUseTime:%d NextRealInvalidateTime:%d mNextFrameDuration:%d mCurrentFrameIndex:%d", new Object[]{Long.valueOf(f.l(this.nzv)), Long.valueOf(f.m(this.nzv)), Long.valueOf(f.e(this.nzv)), Long.valueOf(f.k(this.nzv)), Integer.valueOf(f.b(this.nzv))});
                    if (f.e(this.nzv) < -100) {
                        g.pQN.a(401, 16, 1, false);
                        g.pQN.a(401, 17, Math.abs(f.e(this.nzv)), false);
                    }
                }
            }
            f.a(this.nzv, f.d(this.nzv), f.e(this.nzv) > 0 ? f.e(this.nzv) : 0);
            f.d(this.nzv, (long) (f.i(this.nzv)[0] > 0 ? f.i(this.nzv)[0] : 100));
            f.a(this.nzv, false);
        }
    }
}
