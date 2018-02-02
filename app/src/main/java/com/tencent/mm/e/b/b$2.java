package com.tencent.mm.e.b;

import android.os.Looper;
import com.tencent.mm.be.d;
import com.tencent.mm.compatible.b.b;
import com.tencent.mm.e.b.b.c;
import com.tencent.mm.e.b.c.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class b$2 implements a {
    final /* synthetic */ b fkh;

    b$2(b bVar) {
        this.fkh = bVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void q(byte[] bArr, int i) {
        boolean z = false;
        x.i("MicroMsg.MMAudioRecorder", "onRecPcmDataReady, markStop: %s", new Object[]{Boolean.valueOf(b.c(this.fkh))});
        if (b.d(this.fkh) != c.fkn || b.c(this.fkh)) {
            boolean z2;
            synchronized (b.vp()) {
                if (b.c(this.fkh)) {
                    if (b.e(this.fkh) != null) {
                        x.i("MicroMsg.MMAudioRecorder", "do stop pcm recorder, last frame data: %s, read: %s", new Object[]{bArr, Integer.valueOf(i)});
                        b.e(this.fkh).vi();
                        b.e(this.fkh).fkK = null;
                        b.f(this.fkh);
                        z = true;
                    } else {
                        x.i("MicroMsg.MMAudioRecorder", "stop now, but recorder is null");
                    }
                    b.g(this.fkh);
                }
                z2 = z;
            }
            long bz = bh.bz(b.h(this.fkh));
            if (b.i(this.fkh) <= 0 || bz <= b.i(this.fkh)) {
                x.d("MicroMsg.MMAudioRecorder", "read :" + i + " time: " + b.j(this.fkh).zi() + " dataReadedCnt: " + b.k(this.fkh));
                if (i >= 0) {
                    b.a(this.fkh, b.k(this.fkh) + i);
                    synchronized (b.l(this.fkh)) {
                        com.tencent.mm.be.c m;
                        if (b.m(this.fkh) == null && ((b.n(this.fkh) == b.a.gBW || b.n(this.fkh) == b.a.gBY) && b.o(this.fkh) != null && b.p(this.fkh))) {
                            b.a(this.fkh, new com.tencent.mm.be.c());
                            m = b.m(this.fkh);
                            int q = b.q(this.fkh);
                            x.i("MicroMsg.SpeexEncoderWorker", "init ");
                            m.hPa.clear();
                            d.b bVar = new d.b();
                            bVar.hMi = d.getPrefix();
                            bVar.sampleRate = q;
                            bVar.hOV = 1;
                            bVar.hOW = 16;
                            m.mFileName = String.format("%s%d_%d_%d_%d", new Object[]{bVar.hMi, Integer.valueOf(bVar.sampleRate), Integer.valueOf(bVar.hOV), Integer.valueOf(bVar.hOW), Long.valueOf(System.currentTimeMillis())});
                        }
                        if (b.m(this.fkh) != null) {
                            m = b.m(this.fkh);
                            x.d("MicroMsg.SpeexEncoderWorker", "push into queue queueLen:" + m.hPa.size());
                            if (bArr != null && bArr.length > 0) {
                                m.hPa.add(new g.a(bArr, bArr.length));
                            }
                        }
                        if (b.n(this.fkh) == b.a.gBY) {
                            if (b.r(this.fkh) == null) {
                                b.a(this.fkh, new com.tencent.mm.e.c.c(b.q(this.fkh), b.s(this.fkh)));
                                try {
                                    b.r(this.fkh).a(b.t(this.fkh), new b.a(this.fkh, b.t(this.fkh)));
                                } catch (Throwable e) {
                                    x.printErrStackTrace("MicroMsg.MMAudioRecorder", e, "", new Object[0]);
                                }
                            }
                            s(bArr, i);
                            com.tencent.mm.e.c.c r = b.r(this.fkh);
                            String str = "MicroMsg.SilkWriter";
                            String str2 = "pushBuf queueLen:%d bufLen:%d len:%d, lastFrame: %s";
                            Object[] objArr = new Object[4];
                            objArr[0] = Integer.valueOf(r.fmm == null ? -1 : r.fmm.size());
                            objArr[1] = Integer.valueOf(bArr == null ? -1 : bArr.length);
                            objArr[2] = Integer.valueOf(i);
                            objArr[3] = Boolean.valueOf(z2);
                            x.d(str, str2, objArr);
                            if (i > 0) {
                                synchronized (r) {
                                    if (r.fmn) {
                                        x.e("MicroMsg.SilkWriter", "already stop");
                                    } else {
                                        if (r.fmt == null) {
                                            r.fmt = new com.tencent.mm.e.c.c.a(r, (byte) 0);
                                            e.post(r.fmt, "SilkWriter_run");
                                        }
                                        if (r.fmm != null) {
                                            r.fmm.add(new g.a(bArr, i, z2));
                                        }
                                    }
                                }
                            }
                            return;
                        }
                    }
                } else if (b.d(this.fkh) == c.fkn) {
                    x.w("MicroMsg.MMAudioRecorder", "recorder has been stopped");
                    return;
                } else {
                    new af(Looper.getMainLooper()).post(new Runnable(this) {
                        final /* synthetic */ b$2 fki;

                        {
                            this.fki = r1;
                        }

                        public final void run() {
                            this.fki.fkh.vo();
                            if (b.a(this.fki.fkh) != null) {
                                b.a(this.fki.fkh).onError();
                            }
                        }
                    });
                    return;
                }
            }
            x.w("MicroMsg.MMAudioRecorder", "Stop now ! expire duration ms:" + bz);
            new af(Looper.getMainLooper()).post(new 1(this));
            return;
        }
        x.w("MicroMsg.MMAudioRecorder", "recorder has been stopped");
    }

    private static byte[] r(byte[] bArr, int i) {
        int i2 = i % 4;
        if (i2 != 0) {
            i -= i2;
        }
        if (i <= 0) {
            return null;
        }
        byte[] bArr2 = new byte[(i / 2)];
        for (i2 = 0; i2 < i / 2; i2 += 2) {
            bArr2[i2] = bArr[i2 * 2];
            bArr2[i2 + 1] = bArr[(i2 * 2) + 1];
        }
        return bArr2;
    }

    private void s(byte[] bArr, int i) {
        for (int i2 = 0; i2 < i / 2; i2++) {
            short s = (short) ((bArr[i2 * 2] & 255) | (bArr[(i2 * 2) + 1] << 8));
            if (s > b.u(this.fkh)) {
                b.b(this.fkh, s);
            }
        }
    }

    public final void aK(int i, int i2) {
    }
}
