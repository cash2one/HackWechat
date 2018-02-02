package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.compatible.util.g;
import com.tencent.mm.e.b.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.av;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qafpapi.QAFPNative;

class a$1 implements a {
    final /* synthetic */ a qpB;

    a$1(a aVar) {
        this.qpB = aVar;
    }

    public final void q(byte[] bArr, int i) {
        int QAFPProcessTV;
        g.a aVar = new g.a();
        synchronized (this.qpB.kIX) {
            if (this.qpB.qpq == av.CTRL_INDEX) {
                x.v("MicroMsg.MusicFingerPrintRecorder", "shake tv branch, QAFPProcessTV");
                QAFPProcessTV = QAFPNative.QAFPProcessTV(bArr, i);
            } else {
                QAFPProcessTV = QAFPNative.QAFPProcess(bArr, i);
            }
        }
        long Wp = bh.Wp() - this.qpB.qpz;
        x.d("MicroMsg.MusicFingerPrintRecorder", "QAFPProcess clientid:%d pcm:%d ret:%d dur:%d usetime:%d", new Object[]{Integer.valueOf(this.qpB.qpw), Integer.valueOf(i), Integer.valueOf(QAFPProcessTV), Long.valueOf(Wp), Long.valueOf(aVar.zi())});
        if (Wp > ((long) ((this.qpB.qpA * 3000) + 4000))) {
            Object obj = new byte[10240];
            g.a aVar2 = new g.a();
            if (this.qpB.qpq == av.CTRL_INDEX) {
                x.v("MicroMsg.MusicFingerPrintRecorder", "shake tv branch, QAFPGetAudioFingerPrintTV");
                QAFPProcessTV = QAFPNative.QAFPGetAudioFingerPrintTV(obj);
            } else {
                QAFPProcessTV = QAFPNative.QAFPGetAudioFingerPrint(obj);
            }
            x.d("MicroMsg.MusicFingerPrintRecorder", "QAFPGetAudioFingerPrint clientid:%d outLen:%d time:%d", new Object[]{Integer.valueOf(this.qpB.qpw), Integer.valueOf(QAFPProcessTV), Long.valueOf(aVar2.zi())});
            if (QAFPProcessTV >= 10240 || QAFPProcessTV <= 0) {
                x.e("MicroMsg.MusicFingerPrintRecorder", "QAFPGetAudioFingerPrint clientid:%d  out ret:%d  !stop record now", new Object[]{Integer.valueOf(this.qpB.qpw), Integer.valueOf(QAFPProcessTV)});
                this.qpB.reset();
                return;
            }
            synchronized (this.qpB.qpm) {
                System.arraycopy(obj, 0, this.qpB.qpm, 0, QAFPProcessTV);
                this.qpB.qpn = QAFPProcessTV;
                this.qpB.qpv = this.qpB.qpA >= 3;
                this.qpB.qpo = (int) (Wp / 1000);
            }
            this.qpB.OW();
            a aVar3 = this.qpB;
            aVar3.qpA++;
        }
        if (this.qpB.qpv) {
            x.w("MicroMsg.MusicFingerPrintRecorder", "client:%d stop now! duration:%d  ", new Object[]{Integer.valueOf(this.qpB.qpw), Long.valueOf(Wp)});
            this.qpB.reset();
        }
    }

    public final void aK(int i, int i2) {
    }
}
