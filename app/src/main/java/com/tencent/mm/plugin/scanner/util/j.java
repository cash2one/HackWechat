package com.tencent.mm.plugin.scanner.util;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.mm.compatible.d.d;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.appbrand.jsapi.map.b;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qbar.QbarNative;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public final class j extends b {
    private Object hpF = new Object();
    private boolean mQt = false;
    public boolean otW = true;
    private int outHeight;
    private int outWidth;
    private boolean pWI = false;
    private float pXP = 1.0f;
    private byte[] pZQ;
    private final int qaI = 25;
    private boolean qaJ = false;
    private final int qaK = 1;
    private int qaL = 0;
    private boolean qaM;
    private volatile boolean qaN;
    public volatile boolean qaO;
    private long qaP;
    private int quality = 50;

    public j(a aVar, int i, float f, boolean z, boolean z2) {
        super(aVar);
        this.quality = i;
        this.pXP = f;
        this.otW = z2;
        this.qaM = z;
        x.i("MicroMsg.scanner.ScanImageDecoder", "quality = [%s], scaleRate = [%s], needRotate = [%s], ocrMode=[%s]", new Object[]{Integer.valueOf(i), Float.valueOf(f), Boolean.valueOf(z2), Boolean.valueOf(z)});
    }

    @TargetApi(8)
    public final boolean a(byte[] bArr, Point point, Rect rect) {
        if (this.mQt) {
            x.e("MicroMsg.scanner.ScanImageDecoder", "decode() is decoding, return false");
            return false;
        }
        this.mQt = true;
        if (bArr == null || point == null || rect == null) {
            boolean z;
            String str = "MicroMsg.scanner.ScanImageDecoder";
            String str2 = "decode() data null:[%s], resolution null:[%s], coverage null:[%s]";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(bArr == null);
            if (point == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            if (rect == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[2] = Boolean.valueOf(z);
            x.e(str, str2, objArr);
            this.mQt = false;
            return false;
        }
        try {
            if (this.qaL <= 0) {
                this.qaL++;
                this.mQt = false;
                return false;
            }
            synchronized (this.hpF) {
                int width;
                Rect rect2 = new Rect();
                int height;
                if (d.yl() || this.otW) {
                    width = rect.width() % 4;
                    height = rect.height() % 4;
                    rect2.left = rect.left;
                    rect2.right = rect.right - width;
                    rect2.top = rect.top;
                    rect2.bottom = rect.bottom - height;
                    if (rect2.right <= rect2.left || rect2.bottom <= rect2.top) {
                        this.mQt = false;
                        return false;
                    }
                }
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
                    this.mQt = false;
                    return false;
                }
                f.a cVar = new c(bArr, point.x, point.y, rect2);
                if (cVar.height == 0 || cVar.width == 0) {
                    this.mQt = false;
                    return false;
                } else if (this.pWI) {
                    x.w("MicroMsg.scanner.ScanImageDecoder", "isReleasing, return false 1");
                    return false;
                } else {
                    byte[] bpx = cVar.bpx();
                    if (bpx == null) {
                        this.mQt = false;
                        return false;
                    }
                    if (!this.qaJ) {
                        if (d.yl()) {
                            width = b(rect2.width(), rect2.height(), this.qaM, vO(q.gFU.gEi));
                            x.d("MicroMsg.scanner.ScanImageDecoder", "Focus init Landscape params1=[%s] params2=[%s] params3=[%s], focusThreshold=[%s]", new Object[]{Integer.valueOf(rect2.width()), Integer.valueOf(rect2.height()), Boolean.valueOf(this.qaM), Integer.valueOf(q.gFU.gEi)});
                        } else {
                            width = b(rect2.height(), rect2.width(), this.qaM, vO(q.gFU.gEi));
                            x.d("MicroMsg.scanner.ScanImageDecoder", "Focus init params1=[%s] params2=[%s] params3=[%s], focusThreshold=[%s]", new Object[]{Integer.valueOf(rect2.height()), Integer.valueOf(rect2.width()), Boolean.valueOf(this.qaM), Integer.valueOf(q.gFU.gEi)});
                        }
                        if (width == -1) {
                            x.e("MicroMsg.scanner.ScanImageDecoder", "error in Focus init = [%s]", new Object[]{Integer.valueOf(width)});
                            return false;
                        }
                        this.qaJ = true;
                    }
                    boolean[] zArr = new boolean[2];
                    long Wq = bh.Wq();
                    QbarNative.FocusPro(bpx, d.yl(), zArr);
                    x.d("MicroMsg.scanner.ScanImageDecoder", "is best:%s, need focus:%s, cost:%s", new Object[]{Boolean.valueOf(zArr[0]), Boolean.valueOf(zArr[1]), Long.valueOf(bh.bA(Wq))});
                    this.qaN = zArr[0];
                    this.qaO = zArr[1];
                    if (this.qaP == 0) {
                        this.qaP = System.currentTimeMillis();
                    }
                    if (!this.qaO && System.currentTimeMillis() - this.qaP > 9000) {
                        x.d("MicroMsg.scanner.ScanImageDecoder", "reach focus interfal");
                        this.qaO = true;
                        this.qaP = System.currentTimeMillis();
                    }
                    if (this.qaN) {
                        if (this.pWI) {
                            x.w("MicroMsg.scanner.ScanImageDecoder", "isReleasing, return false 2");
                            return false;
                        }
                        this.outWidth = cVar.width;
                        this.outHeight = cVar.height;
                        int i = 0;
                        width = 0;
                        if (!d.yl()) {
                            i = 1;
                            this.outWidth = cVar.height;
                            this.outHeight = cVar.width;
                        }
                        if (((double) this.pXP) < 0.9d) {
                            width = 1;
                            this.outWidth /= 2;
                            this.outHeight /= 2;
                        }
                        if (this.pZQ == null) {
                            this.pZQ = new byte[(((this.outWidth * this.outHeight) * 3) / 2)];
                            x.v("MicroMsg.scanner.ScanImageDecoder", "tempOutBytes = null, new byte[%s]", new Object[]{Integer.valueOf(((this.outWidth * this.outHeight) * 3) / 2)});
                        } else if (this.pZQ.length != ((this.outWidth * this.outHeight) * 3) / 2) {
                            this.pZQ = null;
                            this.pZQ = new byte[(((this.outWidth * this.outHeight) * 3) / 2)];
                            x.v("MicroMsg.scanner.ScanImageDecoder", "tempOutBytes size change, new byte[%s]", new Object[]{Integer.valueOf(((this.outWidth * this.outHeight) * 3) / 2)});
                        }
                        x.d("MicroMsg.scanner.ScanImageDecoder", "decode() imgRet = [%s], outWidth = [%s], outHeight = [%s], imgRotate=[%s], imgScale=[%s]", new Object[]{Integer.valueOf(QbarNative.a(this.pZQ, bpx, this.outWidth, this.outHeight, width)), Integer.valueOf(this.outWidth), Integer.valueOf(this.outHeight), Integer.valueOf(i), Integer.valueOf(width)});
                        if (QbarNative.a(this.pZQ, bpx, this.outWidth, this.outHeight, width) != 1) {
                            this.pZF = null;
                            this.mQt = false;
                            return false;
                        } else if (this.pWI) {
                            x.w("MicroMsg.scanner.ScanImageDecoder", "isReleasing, return false 3");
                            return false;
                        } else {
                            if (f.fM(8)) {
                                com.tencent.mm.compatible.a.a.a(8, new 1(this));
                            } else {
                                x.d("MicroMsg.scanner.ScanImageDecoder", "decode() compress jpeg by PlanarYUVLuminanceSource");
                                c cVar2 = new c(this.pZQ, this.outWidth, this.outHeight, new Rect(0, 0, this.outWidth, this.outHeight));
                                int[] iArr = new int[(cVar2.width * cVar2.height)];
                                QbarNative.a(cVar2.fFw, iArr, cVar2.pZL, cVar2.pZM, cVar2.left, cVar2.top, cVar2.width, cVar2.height);
                                QbarNative.nativeRelease();
                                Bitmap createBitmap = Bitmap.createBitmap(cVar2.width, cVar2.height, Config.ARGB_8888);
                                createBitmap.setPixels(iArr, 0, cVar2.width, 0, 0, cVar2.width, cVar2.height);
                                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                createBitmap.compress(CompressFormat.JPEG, this.quality, byteArrayOutputStream);
                                this.pZF = byteArrayOutputStream.toByteArray();
                                byteArrayOutputStream.close();
                                if (r.idh) {
                                    com.tencent.mm.sdk.platformtools.d.a(createBitmap, this.quality, CompressFormat.JPEG, h.getExternalStorageDirectory().getAbsolutePath() + "/_scanImage_.JPEG", false);
                                }
                                createBitmap.recycle();
                            }
                            x.i("MicroMsg.scanner.ScanImageDecoder", "decode() finish greyData.length = [%s]", new Object[]{Integer.valueOf(this.pZF.length)});
                            this.mQt = false;
                            return true;
                        }
                    }
                }
            }
        } catch (Throwable e) {
            x.e("MicroMsg.scanner.ScanImageDecoder", " Exception in decode(): [%s]", new Object[]{e.toString()});
            x.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", e, "", new Object[0]);
        }
        this.pZF = null;
        this.mQt = false;
        return false;
    }

    public final void kL() {
        x.d("MicroMsg.scanner.ScanImageDecoder", "releaseDecoder start");
        this.pWI = true;
        if (this.hpF != null) {
            synchronized (this.hpF) {
                if (this.qaJ) {
                    x.d("sizepara", "ImgProcessScan.FocusRelease() = [%s]", new Object[]{Integer.valueOf(0)});
                    this.qaJ = false;
                    x.d("MicroMsg.scanner.ScanImageDecoder", "ImgProcessScan.Release() = [%s]", new Object[]{Integer.valueOf(QbarNative.FocusRelease())});
                }
            }
        }
        this.pZQ = null;
        c.bpw();
        x.d("MicroMsg.scanner.ScanImageDecoder", "releaseDecoder done");
    }

    public final void bpv() {
        if (this.qaJ) {
            kL();
        }
        this.mQt = false;
        this.pWI = false;
        this.qaJ = false;
    }

    private static int b(int i, int i2, boolean z, int i3) {
        if (i <= 0 || i2 <= 0) {
            return -1;
        }
        if (i3 == 1) {
            return QbarNative.FocusInit(i, i2, z, 6, b.CTRL_INDEX);
        }
        if (i3 == 2) {
            return QbarNative.FocusInit(i, i2, z, 8, 120);
        }
        if (i3 == 4) {
            return QbarNative.FocusInit(i, i2, z, 13, 80);
        }
        if (i3 == 5) {
            return QbarNative.FocusInit(i, i2, z, 15, 65);
        }
        return QbarNative.FocusInit(i, i2, z, 10, 100);
    }

    private static int vO(int i) {
        if (i <= 0 || i > 5) {
            return 3;
        }
        return i;
    }
}
