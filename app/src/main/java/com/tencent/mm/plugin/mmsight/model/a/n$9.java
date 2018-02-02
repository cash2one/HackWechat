package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Rect;
import android.graphics.YuvImage;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

class n$9 implements Runnable {
    final /* synthetic */ byte[] jri;
    final /* synthetic */ n ovP;

    n$9(n nVar, byte[] bArr) {
        this.ovP = nVar;
        this.jri = bArr;
    }

    public final void run() {
        n nVar = this.ovP;
        byte[] bArr = this.jri;
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    if (bh.ov(nVar.fvC)) {
                        x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "saveVideoThumbImpl, thumbpath is null");
                        nVar.ovj = false;
                        return;
                    }
                    int width;
                    Bitmap b;
                    int i = (nVar.ovc == 0 || nVar.ovc == 180) ? nVar.ova : nVar.ovb;
                    int i2 = (nVar.ovc == 0 || nVar.ovc == 180) ? nVar.ovb : nVar.ova;
                    YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, null);
                    Rect rect = new Rect(0, 0, i, i2);
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    yuvImage.compressToJpeg(rect, 100, byteArrayOutputStream);
                    byte[] toByteArray = byteArrayOutputStream.toByteArray();
                    Bitmap decodeByteArray = MMBitmapFactory.decodeByteArray(toByteArray, 0, toByteArray.length);
                    if (nVar.oqJ != null && Math.min(decodeByteArray.getWidth(), decodeByteArray.getHeight()) > nVar.oqJ.hup) {
                        width = decodeByteArray.getWidth();
                        i = decodeByteArray.getHeight();
                        int i3 = nVar.oqJ.hup > 0 ? nVar.oqJ.hup : nVar.oqJ.width;
                        if (width < i) {
                            width = (int) (((float) i) / ((((float) width) * 1.0f) / ((float) i3)));
                        } else {
                            int i4 = i3;
                            i3 = (int) (((float) width) / ((((float) i) * 1.0f) / ((float) i3)));
                            width = i4;
                        }
                        decodeByteArray = Bitmap.createScaledBitmap(decodeByteArray, i3, width, true);
                    }
                    if (!nVar.ioU || nVar.ovn == 180) {
                        width = nVar.ovc;
                        if (nVar.ovn == 180) {
                            width += 180;
                            if (width > 360) {
                                width -= 360;
                            }
                        }
                        b = d.b(decodeByteArray, (float) width);
                    } else if (Math.abs(nVar.ovc - nVar.ovn) == 0) {
                        b = d.b(decodeByteArray, 180.0f);
                        decodeByteArray.recycle();
                    } else {
                        b = decodeByteArray;
                    }
                    d.a(b, 60, CompressFormat.JPEG, nVar.fvC, true);
                    x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "saveVideoThumb to: %s, cameraOrientation: %s, width: %s, height: %s %s", new Object[]{nVar.fvC, Integer.valueOf(nVar.ovc), Integer.valueOf(b.getWidth()), Integer.valueOf(b.getHeight()), Long.valueOf(FileOp.me(nVar.fvC))});
                    return;
                }
            } catch (Exception e) {
                x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "saveVideoThumb error: %s", new Object[]{e.getMessage()});
                nVar.ovj = false;
                return;
            }
        }
        x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "saveVideoThumbImpl, data is null");
        nVar.ovj = false;
    }
}
