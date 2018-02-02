package com.tencent.mm.plugin.api.recordView;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.YuvImage;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e;
import com.tencent.mm.plugin.mmsight.model.e.b;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

class f$5 implements b {
    final /* synthetic */ f ipN;
    final /* synthetic */ e ipP;
    final /* synthetic */ boolean ipQ;

    f$5(f fVar, boolean z, e eVar) {
        this.ipN = fVar;
        this.ipQ = z;
        this.ipP = eVar;
    }

    public final void a(byte[] bArr, int i, int i2, int i3, int i4) {
        if (this.ipQ) {
            this.ipN.ips.bad();
        }
        if (bArr == null || i < 0 || i2 < 0 || i3 < 0) {
            x.e("MicroMsg.MMSightRecordViewImpl", "onPictureYuvTaken, data is null!!");
            this.ipP.agg();
            return;
        }
        try {
            byte[] bArr2;
            int i5;
            int i6;
            YuvImage yuvImage;
            OutputStream byteArrayOutputStream;
            byte[] toByteArray;
            Bitmap decodeByteArray;
            Bitmap b;
            if (this.ipN.ipC) {
                this.ipN.Yh();
                if (this.ipN.ips.osu) {
                    if (this.ipN.ipE.y < i) {
                        bArr2 = new byte[(((this.ipN.ipE.x * this.ipN.ipE.y) * 3) >> 1)];
                        SightVideoJNI.cropCameraDataLongEdge(bArr, bArr2, i, this.ipN.ipE.y, i2);
                        i = this.ipN.ipE.y;
                        i5 = this.ipN.ipE.x;
                        i6 = i;
                        yuvImage = new YuvImage(bArr2, 17, i6, i5, null);
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        yuvImage.compressToJpeg(new Rect(0, 0, i6, i5), 100, byteArrayOutputStream);
                        toByteArray = byteArrayOutputStream.toByteArray();
                        decodeByteArray = MMBitmapFactory.decodeByteArray(toByteArray, 0, toByteArray.length);
                        if (i4 == 180) {
                            i3 += 180;
                            if (i3 > 360) {
                                i3 -= 360;
                            }
                        }
                        b = d.b(decodeByteArray, (float) i3);
                        decodeByteArray.recycle();
                        this.ipP.r(b);
                    }
                } else if (this.ipN.ipE.x < i2) {
                    bArr2 = new byte[(((this.ipN.ipE.x * this.ipN.ipE.y) * 3) >> 1)];
                    SightVideoJNI.cropCameraData(bArr, bArr2, i, i2, this.ipN.ipE.x);
                    i5 = this.ipN.ipE.x;
                    i6 = this.ipN.ipE.y;
                    yuvImage = new YuvImage(bArr2, 17, i6, i5, null);
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    yuvImage.compressToJpeg(new Rect(0, 0, i6, i5), 100, byteArrayOutputStream);
                    toByteArray = byteArrayOutputStream.toByteArray();
                    decodeByteArray = MMBitmapFactory.decodeByteArray(toByteArray, 0, toByteArray.length);
                    if (i4 == 180) {
                        i3 += 180;
                        if (i3 > 360) {
                            i3 -= 360;
                        }
                    }
                    b = d.b(decodeByteArray, (float) i3);
                    decodeByteArray.recycle();
                    this.ipP.r(b);
                }
            }
            i5 = i2;
            i6 = i;
            bArr2 = bArr;
            yuvImage = new YuvImage(bArr2, 17, i6, i5, null);
            byteArrayOutputStream = new ByteArrayOutputStream();
            yuvImage.compressToJpeg(new Rect(0, 0, i6, i5), 100, byteArrayOutputStream);
            toByteArray = byteArrayOutputStream.toByteArray();
            decodeByteArray = MMBitmapFactory.decodeByteArray(toByteArray, 0, toByteArray.length);
            if (i4 == 180) {
                i3 += 180;
                if (i3 > 360) {
                    i3 -= 360;
                }
            }
            b = d.b(decodeByteArray, (float) i3);
            decodeByteArray.recycle();
            this.ipP.r(b);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMSightRecordViewImpl", e, "saveCaptureYuvDataToBitmap error: %s", new Object[]{e.getMessage()});
            this.ipP.agg();
        }
    }
}
