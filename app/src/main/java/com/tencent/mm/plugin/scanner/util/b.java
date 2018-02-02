package com.tencent.mm.plugin.scanner.util;

import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qbar.QbarNative;

public abstract class b {
    protected static int pZH = 0;
    protected int fqb;
    protected int fqc;
    protected a pZD = null;
    protected byte[] pZE = null;
    protected byte[] pZF = null;
    public String pZG;
    public boolean[] pZI = null;

    public abstract boolean a(byte[] bArr, Point point, Rect rect);

    public abstract void bpv();

    public abstract void kL();

    public b(a aVar) {
        this.pZD = aVar;
    }

    public final void a(byte[] bArr, Point point, int i, Rect rect) {
        x.d("MicroMsg.scanner.BaseDecoder", "decode task reach");
        final byte[] bArr2 = bArr;
        final int i2 = i;
        final Point point2 = point;
        final Rect rect2 = rect;
        e.b(new Runnable(this) {
            final /* synthetic */ b pZJ;

            public final void run() {
                byte[] bArr = bArr2;
                if (270 == i2) {
                    byte[] bArr2 = new byte[bArr2.length];
                    QbarNative.a(bArr2, bArr2, point2.x, point2.y);
                    bArr = new byte[bArr2.length];
                    QbarNative.a(bArr, bArr2, point2.y, point2.x);
                    QbarNative.nativeRelease();
                }
                x.d("MicroMsg.scanner.BaseDecoder", "asyncDecode() resolution:%s, coverage:%s", point2.toString(), rect2.toString());
                if (bArr == null || !this.pZJ.a(bArr, point2, rect2)) {
                    ag.y(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 pZK;

                        {
                            this.pZK = r1;
                        }

                        public final void run() {
                            if (this.pZK.pZJ.pZD != null) {
                                x.d("MicroMsg.scanner.BaseDecoder", "failed in asyncDecode() resolution:%s, coverage:%s", point2.toString(), rect2.toString());
                                this.pZK.pZJ.pZD.boH();
                            }
                        }
                    });
                } else {
                    ag.y(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 pZK;

                        {
                            this.pZK = r1;
                        }

                        public final void run() {
                            if (this.pZK.pZJ.pZD != null) {
                                this.pZK.pZJ.pZD.a(b.pZH, this.pZK.pZJ.pZG, this.pZK.pZJ.pZF, this.pZK.pZJ.fqb, this.pZK.pZJ.fqc);
                            }
                        }
                    });
                }
            }
        }, "scan_decode", 10);
    }
}
