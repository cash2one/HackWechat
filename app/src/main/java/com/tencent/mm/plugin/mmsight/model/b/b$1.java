package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.b.c.a;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.Buffer;
import java.nio.ByteBuffer;

class b$1 implements a {
    final /* synthetic */ b owK;

    b$1(b bVar) {
        this.owK = bVar;
    }

    public final void a(byte[] bArr, boolean z, long j) {
        if (b.a(this.owK) == null) {
            b.a(this.owK, c.baV());
        }
        if (b.b(this.owK) != null) {
            if (b.c(this.owK) == null) {
                if (b.d(this.owK) == 90 || b.d(this.owK) == 270) {
                    b.a(this.owK, d.b(b.b(this.owK), (float) (360 - b.d(this.owK))));
                }
                b.a(this.owK, Bitmap.createScaledBitmap(b.b(this.owK), b.a(this.owK).x, b.a(this.owK).y, true));
                Buffer allocateDirect = ByteBuffer.allocateDirect(b.b(this.owK).getRowBytes() * b.b(this.owK).getHeight());
                allocateDirect.position(0);
                b.b(this.owK).copyPixelsToBuffer(allocateDirect);
                b.a(this.owK, allocateDirect.array());
            }
            SightVideoJNI.blendYuvFrame(bArr, b.c(this.owK), b.a(this.owK).x, b.a(this.owK).y);
        }
        if (b.e(this.owK) != null) {
            e e = b.e(this.owK);
            int i = b.a(this.owK).x;
            int i2 = b.a(this.owK).y;
            if (bArr != null) {
                boolean z2 = (i == e.nUr && i2 == e.mvv) ? false : true;
                x.d("MicroMsg.MMSightRemuxX264Encoder", "writeData, needScale: %s, srcSize: [%s, %s], targetSize: [%s, %s], pts: %s", new Object[]{Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(e.nUr), Integer.valueOf(e.mvv), Long.valueOf(j)});
                MP4MuxerJNI.writeYuvDataForSegment(bArr, i, i2, e.nUr, e.mvv, 2, e.ioD, e.ioE);
                e.frameCount++;
            }
        }
        j.ouM.D(bArr);
        if (z && b.e(this.owK) != null) {
            e e2 = b.e(this.owK);
            if (e2.owV != null) {
                e2.owV.owX = true;
            }
        }
    }
}
