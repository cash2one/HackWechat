package com.tencent.mm.plugin.facedetect.d;

import com.tencent.mm.e.b.c.a;
import com.tencent.mm.e.b.g;
import com.tencent.mm.sdk.platformtools.x;

class a$2 implements a {
    short[] hYC;
    final /* synthetic */ a mhs;

    a$2(a aVar) {
        this.mhs = aVar;
    }

    public final void q(byte[] bArr, int i) {
        int i2;
        x.d("MicroMsg.FaceVoiceRecordLogic", "OnRecPcmDataReady len: %d", new Object[]{Integer.valueOf(i)});
        if (this.hYC == null || this.hYC.length < i / 2) {
            this.hYC = new short[(i / 2)];
        }
        for (i2 = 0; i2 < i / 2; i2++) {
            this.hYC[i2] = (short) ((bArr[i2 * 2] & 255) | (bArr[(i2 * 2) + 1] << 8));
        }
        a.a(this.mhs, this.hYC, i / 2);
        if (a.g(this.mhs) != null) {
            a.g(this.mhs).c(this.hYC, i / 2);
            if (a.d(this.mhs) != null) {
                i2 = a.d(this.mhs).a(new g.a(bArr, i), 0);
            } else {
                i2 = -1;
            }
            if (-1 == i2 && a.e(this.mhs) != null) {
                a.e(this.mhs).onError(3);
                this.mhs.aGS();
                x.e("MicroMsg.FaceVoiceRecordLogic", "write to file failed");
                return;
            }
            return;
        }
        if (a.e(this.mhs) != null) {
            a.e(this.mhs).onError(1);
            this.mhs.aGS();
        }
        x.e("MicroMsg.FaceVoiceRecordLogic", "mVoiceSilentDetectAPI is null");
    }

    public final void aK(int i, int i2) {
        x.e("MicroMsg.FaceVoiceRecordLogic", "onRecError state = " + i + " detailState = " + i2);
        this.mhs.aGS();
        if (a.e(this.mhs) != null) {
            a.e(this.mhs).onError(2);
        }
    }
}
