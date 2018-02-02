package com.tencent.mm.plugin.scanner.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.mm.plugin.licence.model.CardInfo;
import com.tencent.mm.plugin.licence.model.LibCardRecog;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Arrays;

public final class k extends b {
    private final Object lock = new Object();
    private final int qaR;
    private Bitmap qaS;
    public Bitmap qaT;
    private boolean[] qaj = new boolean[4];
    private boolean qak = false;
    private boolean qam = false;

    public k(a aVar, int i) {
        super(aVar);
        this.qaR = i;
    }

    public final boolean[] bpL() {
        boolean[] zArr;
        synchronized (this.lock) {
            zArr = this.qaj;
        }
        return zArr;
    }

    public final boolean a(byte[] bArr, Point point, Rect rect) {
        boolean z;
        x.d("MicroMsg.ScanLicenceDecoder", "smoothie, decode, resolution = %s, coverage = %s, data.length = %d", new Object[]{point, rect, Integer.valueOf(bArr.length)});
        synchronized (this.lock) {
            if (!(this.qaS == null || this.qaS.isRecycled())) {
                x.d("MicroMsg.ScanLicenceDecoder", "[smoothie] recycle last bitmap");
                this.qaS.recycle();
            }
            x.d("MicroMsg.ScanLicenceDecoder", "resolution:%s, coverage:%s", new Object[]{point, rect});
            if (this.qak) {
                x.d("MicroMsg.ScanLicenceDecoder", "recognize id succeed, no need more handle");
                z = false;
            } else {
                int i;
                for (i = 0; i < 4; i++) {
                    this.qaj[i] = false;
                }
                float min = Math.min(Math.min(((float) point.x) / ((float) rect.width()), ((float) point.y) / ((float) rect.height())), 1.0f);
                int width = rect.width();
                int height = rect.height();
                x.d("MicroMsg.ScanLicenceDecoder", "rate:%f, cropWidth:%d, cropHeight:%d", new Object[]{Float.valueOf(min), Integer.valueOf(width), Integer.valueOf(height)});
                if (!this.qam) {
                    x.d("MicroMsg.ScanLicenceDecoder", "init param:%d, %d, %d, %d", new Object[]{Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(rect.width()), Integer.valueOf(rect.height())});
                    try {
                        LibCardRecog.recognizeCardInit(width, height, this.qaR);
                        this.qam = true;
                    } catch (Exception e) {
                        x.e("MicroMsg.ScanLicenceDecoder", "lib init failed, exp = %s", new Object[]{e});
                        this.qam = false;
                        bpM();
                        z = false;
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                CardInfo cardInfo = new CardInfo(width, height);
                int i2 = rect.top;
                try {
                    i = LibCardRecog.recognizeCardProcess(bArr, point.y, point.x, rect.left, i2, height, width, cardInfo, this.qaj);
                    x.d("MicroMsg.ScanLicenceDecoder", "[smoothie] recognizeProcess, ret = %d", new Object[]{Integer.valueOf(i)});
                    x.d("MicroMsg.ScanLicenceDecoder", "focusedEngineProcess cost: " + (System.currentTimeMillis() - currentTimeMillis));
                    x.d("MicroMsg.ScanLicenceDecoder", "mRecogRectEdge: %s", new Object[]{Arrays.toString(this.qaj)});
                    if (i == 0) {
                        z = false;
                    } else if (1 != i) {
                        for (i = 0; i < 4; i++) {
                            this.qaj[i] = false;
                        }
                        x.d("MicroMsg.ScanLicenceDecoder", "image is not enough clear");
                        z = false;
                    } else {
                        for (i = 0; i < 4; i++) {
                            this.qaj[i] = true;
                        }
                        this.qaS = BitmapFactory.decodeByteArray(cardInfo.bitmapData, 0, cardInfo.bitmapLen);
                        this.qaT = this.qaS.copy(Config.ARGB_8888, true);
                        this.qak = true;
                        z = true;
                    }
                } catch (Exception e2) {
                    x.e("MicroMsg.ScanLicenceDecoder", "recognizeProcess failed, exp = %s", new Object[]{e2});
                    this.qak = false;
                    z = false;
                }
            }
        }
        return z;
    }

    public final void kL() {
        if (!(this.qaS == null || this.qaS.isRecycled())) {
            this.qaS.recycle();
        }
        bpM();
    }

    public final void bpv() {
        this.qak = false;
    }

    private static void bpM() {
        x.i("MicroMsg.ScanLicenceDecoder", "lib release");
        try {
            LibCardRecog.recognizeCardRelease();
        } catch (Exception e) {
            x.e("MicroMsg.ScanLicenceDecoder", "lib release, exp = %s", new Object[]{e});
        }
    }
}
