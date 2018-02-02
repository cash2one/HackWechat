package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Rect;
import android.graphics.YuvImage;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

class l$6 implements Runnable {
    final /* synthetic */ byte[] jri;
    final /* synthetic */ l ovs;

    l$6(l lVar, byte[] bArr) {
        this.ovs = lVar;
        this.jri = bArr;
    }

    public final void run() {
        l lVar = this.ovs;
        byte[] bArr = this.jri;
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    if (bh.ov(lVar.fvC)) {
                        x.e("MicroMsg.MMSightFFMpegRecorder", "saveVideoThumbImpl, thumbpath is null");
                        lVar.ovj = false;
                        return;
                    }
                    int width;
                    Bitmap b;
                    int i = (lVar.ovc == 0 || lVar.ovc == 180) ? lVar.ova : lVar.ovb;
                    int i2 = (lVar.ovc == 0 || lVar.ovc == 180) ? lVar.ovb : lVar.ova;
                    YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, null);
                    Rect rect = new Rect(0, 0, i, i2);
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    yuvImage.compressToJpeg(rect, 100, byteArrayOutputStream);
                    byte[] toByteArray = byteArrayOutputStream.toByteArray();
                    Bitmap decodeByteArray = MMBitmapFactory.decodeByteArray(toByteArray, 0, toByteArray.length);
                    if (lVar.oqJ != null && Math.min(decodeByteArray.getWidth(), decodeByteArray.getHeight()) > lVar.oqJ.hup) {
                        width = decodeByteArray.getWidth();
                        i = decodeByteArray.getHeight();
                        int i3 = lVar.oqJ.hup > 0 ? lVar.oqJ.hup : lVar.oqJ.width;
                        if (width < i) {
                            width = (int) (((float) i) / ((((float) width) * 1.0f) / ((float) i3)));
                        } else {
                            int i4 = i3;
                            i3 = (int) (((float) width) / ((((float) i) * 1.0f) / ((float) i3)));
                            width = i4;
                        }
                        decodeByteArray = Bitmap.createScaledBitmap(decodeByteArray, i3, width, true);
                    }
                    if (!lVar.ioU || lVar.ovn == 180) {
                        width = lVar.ovc;
                        if (lVar.ovn == 180) {
                            width += 180;
                            if (width > 360) {
                                width -= 360;
                            }
                        }
                        b = d.b(decodeByteArray, (float) width);
                    } else if (Math.abs(lVar.ovc - lVar.ovn) == 0) {
                        b = d.b(decodeByteArray, 180.0f);
                        decodeByteArray.recycle();
                    } else {
                        b = decodeByteArray;
                    }
                    d.a(b, 60, CompressFormat.JPEG, lVar.fvC, true);
                    x.i("MicroMsg.MMSightFFMpegRecorder", "saveVideoThumb to: %s, cameraOrientation: %s, width: %s, height: %s", new Object[]{lVar.fvC, Integer.valueOf(lVar.ovc), Integer.valueOf(b.getWidth()), Integer.valueOf(b.getHeight())});
                    return;
                }
            } catch (Exception e) {
                x.e("MicroMsg.MMSightFFMpegRecorder", "saveVideoThumb error: %s", new Object[]{e.getMessage()});
                lVar.ovj = false;
                return;
            }
        }
        x.e("MicroMsg.MMSightFFMpegRecorder", "saveVideoThumbImpl, data is null");
        lVar.ovj = false;
    }
}
