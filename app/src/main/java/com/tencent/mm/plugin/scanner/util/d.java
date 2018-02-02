package com.tencent.mm.plugin.scanner.util;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.mm.plugin.scanner.a.l;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qbar.QbarNative;
import f.a;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class d extends b {
    private static QbarNative pZO = new QbarNative();
    private Object hpF = new Object();
    public volatile boolean mQt = false;
    public boolean otW = true;
    public boolean pWI = false;
    public boolean pZN = false;
    public int pZP;
    private byte[] pZQ;
    private byte[] pZR;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ byte[] ibn;
        final /* synthetic */ Point pZS;
        final /* synthetic */ d pZT;

        public AnonymousClass1(d dVar, byte[] bArr, Point point) {
            this.pZT = dVar;
            this.ibn = bArr;
            this.pZS = point;
        }

        public final void run() {
            if (this.pZT.a(this.ibn, this.pZS)) {
                ag.y(new 1(this));
            } else {
                ag.y(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 pZU;

                    {
                        this.pZU = r1;
                    }

                    public final void run() {
                        if (this.pZU.pZT.pZD != null) {
                            this.pZU.pZT.pZD.boH();
                        }
                    }
                });
            }
        }
    }

    public d(b$a com_tencent_mm_plugin_scanner_util_b_a, int i, boolean z) {
        super(com_tencent_mm_plugin_scanner_util_b_a);
        this.pZP = i;
        this.otW = z;
    }

    private synchronized byte[] a(byte[] bArr, Point point, Rect rect, Point point2) {
        byte[] bArr2;
        if (bArr != null) {
            if (bArr.length > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                Rect rect2 = new Rect();
                int width;
                int height;
                if (com.tencent.mm.compatible.d.d.yl() || this.otW) {
                    width = rect.width() % 4;
                    height = rect.height() % 4;
                    rect2.left = rect.left;
                    rect2.right = rect.right - width;
                    rect2.top = rect.top;
                    rect2.bottom = rect.bottom - height;
                    if (rect2.right <= rect2.left || rect2.bottom <= rect2.top) {
                        bArr2 = null;
                    }
                } else {
                    rect2.left = (point.x / 2) - rect.height();
                    rect2.right = (point.x / 2) + rect.height();
                    rect2.top = (point.y / 2) - (rect.width() / 2);
                    rect2.bottom = (point.y / 2) + (rect.width() / 2);
                    if (rect2.left < 0) {
                        rect2.left = 0;
                    }
                    if (rect2.right > point.x - 1) {
                        rect2.right = point.x - 1;
                    }
                    if (rect2.top < 0) {
                        rect2.top = 0;
                    }
                    if (rect2.bottom > point.y - 1) {
                        rect2.bottom = point.y - 1;
                    }
                    width = rect2.width() % 4;
                    height = rect2.height() % 4;
                    if (width != 0) {
                        rect2.right -= width;
                    }
                    if (height != 0) {
                        rect2.bottom -= height;
                    }
                    if (rect2.right <= rect2.left || rect2.bottom <= rect2.top) {
                        bArr2 = null;
                    }
                }
                c cVar = new c(bArr, point.x, point.y, rect2);
                point2.x = cVar.width;
                point2.y = cVar.height;
                int i = 0;
                if (!com.tencent.mm.compatible.d.d.yl()) {
                    i = 90;
                    point2.x = cVar.height;
                    point2.y = cVar.width;
                }
                x.d("MicroMsg.scanner.QBarDecoder", "rotate angle: " + i);
                if (this.pZQ == null) {
                    this.pZQ = new byte[(((cVar.width * cVar.height) * 3) / 2)];
                    this.pZR = new byte[(cVar.width * cVar.height)];
                    x.d("MicroMsg.scanner.QBarDecoder", "tempOutBytes = null, new byte[%s]", new Object[]{Integer.valueOf(((cVar.width * cVar.height) * 3) / 2)});
                } else if (this.pZQ.length != ((cVar.width * cVar.height) * 3) / 2) {
                    this.pZQ = null;
                    this.pZQ = new byte[(((cVar.width * cVar.height) * 3) / 2)];
                    this.pZR = null;
                    this.pZR = new byte[(cVar.width * cVar.height)];
                    x.d("MicroMsg.scanner.QBarDecoder", "tempOutBytes size change, new byte[%s]", new Object[]{Integer.valueOf(((cVar.width * cVar.height) * 3) / 2)});
                }
                if (QbarNative.a(this.pZQ, new int[]{point2.x, point2.y}, bArr, point.x, point.y, cVar.left, cVar.top, cVar.width, cVar.height, i) != 1) {
                    x.e("MicroMsg.scanner.QBarDecoder", "decode pro_result %s", new Object[]{Integer.valueOf(QbarNative.a(this.pZQ, new int[]{point2.x, point2.y}, bArr, point.x, point.y, cVar.left, cVar.top, cVar.width, cVar.height, i))});
                    bArr2 = null;
                } else {
                    System.arraycopy(this.pZQ, 0, this.pZR, 0, this.pZR.length);
                    x.d("MicroMsg.scanner.QBarDecoder", "decode, rotate and gray, cost:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    bArr2 = this.pZR;
                }
            }
        }
        x.w("MicroMsg.scanner.QBarDecoder", "prepareGrayData , data is null");
        bArr2 = null;
        return bArr2;
    }

    public final boolean a(byte[] bArr, Point point, Rect rect) {
        Point point2 = new Point();
        byte[] a = a(bArr, point, rect, point2);
        if (a == null || a.length <= 0) {
            return false;
        }
        return a(a, point2);
    }

    public final synchronized byte[] a(byte[] bArr, Point point, int i, Rect rect, Point point2) {
        if (270 == i) {
            byte[] bArr2 = new byte[bArr.length];
            QbarNative.a(bArr2, bArr, point.x, point.y);
            bArr = new byte[bArr.length];
            QbarNative.a(bArr, bArr2, point.y, point.x);
            QbarNative.nativeRelease();
        }
        return a(bArr, point, rect, point2);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(byte[] bArr, Point point) {
        long currentTimeMillis = System.currentTimeMillis();
        x.i("MicroMsg.scanner.QBarDecoder", "decode() start");
        if (this.mQt) {
            x.e("MicroMsg.scanner.QBarDecoder", "is decoding, return false");
            return false;
        } else if (this.pWI) {
            x.w("MicroMsg.scanner.QBarDecoder", "isReleasing, return false 1");
            return false;
        } else if (bArr == null) {
            x.e("MicroMsg.scanner.QBarDecoder", "wrong args");
            return false;
        } else {
            synchronized (this.hpF) {
                this.mQt = true;
                this.pZG = null;
                this.fqc = 0;
                this.fqb = 0;
                l.pST.boF();
                try {
                    if (do(this.pZP, 0)) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        x.i("MicroMsg.scanner.QBarDecoder", "data len %d, image size %s", new Object[]{Integer.valueOf(bArr.length), point});
                        int t = pZO.t(bArr, point.x, point.y);
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                        QbarNative qbarNative = pZO;
                        boolean z = (qbarNative.GetPossibleInfo(QbarNative.zQF, qbarNative.zQK) != 0 ? QbarNative.zQF.hasQrcode : 0) != 0;
                        qbarNative = pZO;
                        float f = qbarNative.GetPossibleInfo(QbarNative.zQF, qbarNative.zQK) != 0 ? QbarNative.zQF.qrcodeAreaRatio : 0.0f;
                        x.i("MicroMsg.scanner.QBarDecoder", "after scanImage, result:%d,hasCode: %s, areaRatio: %f", new Object[]{Integer.valueOf(t), Boolean.valueOf(z), Float.valueOf(f)});
                        if (t <= 0 && z && this.pZD != null && f < 0.1f) {
                            Bundle bundle = new Bundle();
                            bundle.putInt("zoom_action", 6);
                            bundle.putInt("zoom_type", 1);
                            bundle.putInt("zoom_scale", (int) (100.0d * Math.sqrt((double) (0.1f / f))));
                            this.pZD.D(bundle);
                        }
                        l.pST.dk(point.x, point.y);
                        l.pST.boG();
                        currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        l.pST.ee(currentTimeMillis3);
                        x.d("MicroMsg.scanner.QBarDecoder", "decode ScanImage %s, cost:%d", new Object[]{Integer.valueOf(t), Long.valueOf(currentTimeMillis2)});
                        if (t != 1) {
                            this.mQt = false;
                            return false;
                        }
                        l.pST.boE();
                        l.pST.ef(currentTimeMillis3);
                        bpz();
                        this.mQt = false;
                        x.i("MicroMsg.scanner.QBarDecoder", "decode() finish, resultText = [%s], cost:%d", new Object[]{this.pZG, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        boolean z2;
                        if (bh.ov(this.pZG)) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                    } else {
                        kL();
                        this.mQt = false;
                        return false;
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.scanner.QBarDecoder", e, "decodeInternal error", new Object[0]);
                }
            }
        }
    }

    public static Set<Integer> dn(int i, int i2) {
        Set<Integer> hashSet = new HashSet();
        if (i == 1) {
            if (i2 != 1) {
                hashSet.add(Integer.valueOf(2));
                hashSet.add(Integer.valueOf(3));
                hashSet.add(Integer.valueOf(4));
                hashSet.add(Integer.valueOf(5));
            } else {
                hashSet.add(Integer.valueOf(2));
                hashSet.add(Integer.valueOf(3));
                hashSet.add(Integer.valueOf(5));
            }
        } else if (i == 2) {
            if (i2 != 1) {
                hashSet.add(Integer.valueOf(0));
                hashSet.add(Integer.valueOf(3));
                hashSet.add(Integer.valueOf(4));
            } else {
                hashSet.add(Integer.valueOf(0));
                hashSet.add(Integer.valueOf(3));
            }
        } else if (i == 0) {
            if (i2 != 1) {
                hashSet.add(Integer.valueOf(2));
                hashSet.add(Integer.valueOf(0));
                hashSet.add(Integer.valueOf(3));
                hashSet.add(Integer.valueOf(4));
                hashSet.add(Integer.valueOf(5));
            } else {
                hashSet.add(Integer.valueOf(2));
                hashSet.add(Integer.valueOf(0));
                hashSet.add(Integer.valueOf(3));
                hashSet.add(Integer.valueOf(5));
            }
        } else if (i == 3 && i2 != 1) {
            hashSet.add(Integer.valueOf(2));
            hashSet.add(Integer.valueOf(5));
        }
        return hashSet;
    }

    private boolean do(int i, int i2) {
        if (this.pZN) {
            return this.pZN;
        }
        return a(i2, dn(i, i2));
    }

    public final int f(Set<Integer> set) {
        int i = 0;
        if (!(set == null || set.isEmpty())) {
            int[] iArr = new int[set.size()];
            int i2 = 0;
            for (Integer num : set) {
                if (num != null) {
                    int i3 = i2 + 1;
                    iArr[i2] = num.intValue();
                    i2 = i3;
                }
            }
            x.i("MicroMsg.scanner.QBarDecoder", "QBarNative.SetReaders, readers:%s", new Object[]{Arrays.toString(iArr)});
            synchronized (this.hpF) {
                QbarNative qbarNative = pZO;
                i = qbarNative.SetReaders(iArr, iArr.length, qbarNative.zQK);
            }
        }
        return i;
    }

    private boolean a(int i, Set<Integer> set) {
        if (!(this.pZN || set == null || set.isEmpty())) {
            QbarNative qbarNative = pZO;
            String str = "ANY";
            String str2 = "UTF-8";
            if (qbarNative.zQK < 0) {
                qbarNative.zQK = qbarNative.Init(2, 0, i, str, str2);
            }
            int i2 = qbarNative.zQK < 0 ? -1 : 1;
            l.pST.pTh = set.contains(Integer.valueOf(5));
            x.i("MicroMsg.scanner.QBarDecoder", "QbarNative.Init = [%s], SetReaders = [%s], version = [%s]", new Object[]{Integer.valueOf(i2), Integer.valueOf(f(set)), QbarNative.getVersion()});
            if (i2 <= 0 || r3 <= 0) {
                x.e("MicroMsg.scanner.QBarDecoder", "QbarNative failed, releaseDecoder 1");
                return false;
            }
            this.pZN = true;
        }
        return this.pZN;
    }

    private void bpz() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        StringBuilder stringBuilder3 = new StringBuilder();
        StringBuilder stringBuilder4 = new StringBuilder();
        int[] iArr = new int[2];
        if (pZO.a(stringBuilder, stringBuilder2, stringBuilder3, stringBuilder4, iArr) == 1) {
            x.d("MicroMsg.scanner.QBarDecoder", "decode type:%s, sCharset: %s, sBinaryMethod: %s, data:%s, gResult:%s", new Object[]{stringBuilder.toString(), stringBuilder3.toString(), stringBuilder4.toString(), stringBuilder2.toString(), Integer.valueOf(pZO.a(stringBuilder, stringBuilder2, stringBuilder3, stringBuilder4, iArr))});
            if (!bh.ov(stringBuilder2.toString())) {
                String stringBuilder5 = stringBuilder.toString();
                if (stringBuilder5.equals("QR_CODE") || stringBuilder5.equals("WX_CODE")) {
                    this.pZG = stringBuilder2.toString();
                    pZH = 1;
                } else {
                    this.pZG = stringBuilder5 + "," + stringBuilder2;
                    pZH = 2;
                }
            }
            this.fqb = p.IN(stringBuilder.toString());
            this.fqc = iArr[0];
        }
        l lVar = l.pST;
        String stringBuilder6 = stringBuilder.toString();
        String str = this.pZG;
        String stringBuilder7 = stringBuilder3.toString();
        int i = iArr[0];
        int i2 = iArr[1];
        x.i("MicroMsg.QBarEngineReporter", "setDecodeResult, decodeTypeName: %s, dataContent: %s, dataCharSet: %s, qrCodeVersion: %s, pyramidLv: %s, binarizerMethod: %s", new Object[]{stringBuilder6, str, stringBuilder7, Integer.valueOf(i), Integer.valueOf(i2), stringBuilder4.toString()});
        lVar.pSZ = stringBuilder6;
        lVar.pTa = str;
        lVar.pTb = stringBuilder7;
        lVar.pTc = i;
        lVar.pTd = i2;
        lVar.pTe = r4;
    }

    public final void kL() {
        x.d("MicroMsg.scanner.QBarDecoder", "releaseDecoder() start, hasInitQBar = %s", new Object[]{Boolean.valueOf(this.pZN)});
        this.pWI = true;
        synchronized (this.hpF) {
            if (this.pZN) {
                this.pZN = false;
                x.d("MicroMsg.scanner.QBarDecoder", "QbarNative.Release() = [%s]", new Object[]{Integer.valueOf(0)});
                x.d("MicroMsg.scanner.QBarDecoder", "ImgProcessScan.Release() = [%s]", new Object[]{Integer.valueOf(0)});
            }
        }
        c.bpw();
    }

    public final void bpv() {
        if (this.pZN) {
            kL();
            this.pZN = false;
        }
        this.pWI = false;
        this.mQt = false;
    }

    public final com.tencent.mm.plugin.ac.a.d a(a aVar, Set<Integer> set) {
        com.tencent.mm.plugin.ac.a.d dVar = new com.tencent.mm.plugin.ac.a.d();
        synchronized (this.hpF) {
            try {
                this.pZG = null;
                if (set != null && !set.isEmpty() && !a(0, (Set) set)) {
                    kL();
                    this.mQt = false;
                    dVar = null;
                } else if (do(0, 1)) {
                    int i;
                    x.d("MicroMsg.scanner.QBarDecoder", "directScanQRCodeImg, lumSrc==null:%b", new Object[]{Boolean.valueOf(false)});
                    if (aVar.bpy() != null) {
                        x.i("MicroMsg.scanner.QBarDecoder", "directScanQRCodeImg, lumSrc.getMatrix.length: %d, lumSrc.getWidth: %d, lumSrc.getHeight: %d", new Object[]{Integer.valueOf(aVar.bpy().length), Integer.valueOf(aVar.width), Integer.valueOf(aVar.height)});
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (aVar.bpy() == null || aVar.width * aVar.height != aVar.bpy().length) {
                        i = -1;
                    } else {
                        l.pST.dk(aVar.width, aVar.height);
                        i = pZO.t(aVar.bpy(), aVar.width, aVar.height);
                    }
                    long currentTimeMillis2 = System.currentTimeMillis();
                    x.d("MicroMsg.scanner.QBarDecoder", "directScanQRCodeImg decode ScanImage %s, cost: %s", new Object[]{Integer.valueOf(i), Long.valueOf(currentTimeMillis2 - currentTimeMillis)});
                    l.pST.ee(currentTimeMillis2 - currentTimeMillis);
                    l.pST.boF();
                    if (i != 1) {
                        this.mQt = false;
                        dVar = null;
                    } else {
                        l.pST.boE();
                        l.pST.ef(currentTimeMillis2 - currentTimeMillis);
                        bpz();
                        dVar.result = this.pZG;
                        dVar.fqb = this.fqb;
                        dVar.fqc = this.fqc;
                    }
                } else {
                    kL();
                    this.mQt = false;
                    dVar = null;
                }
            } catch (Throwable e) {
                x.e("MicroMsg.scanner.QBarDecoder", " Exception in directScanQRCodeImg() " + e.getMessage());
                x.printErrStackTrace("MicroMsg.scanner.QBarDecoder", e, "", new Object[0]);
            }
        }
        return dVar;
    }
}
