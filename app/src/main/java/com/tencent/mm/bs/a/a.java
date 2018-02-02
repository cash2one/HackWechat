package com.tencent.mm.bs.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.DisplayMetrics;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qbar.QbarNative;
import com.tencent.smtt.sdk.WebView;
import java.util.Arrays;

public final class a {
    public static Bitmap a(Context context, Bitmap bitmap, byte[] bArr, int[] iArr, int i) {
        int i2;
        int width = bitmap.getWidth();
        int b = b.b(context, 197.0f);
        if (b < width) {
            b = width;
        }
        int i3 = (int) (((double) iArr[0]) * 0.1d);
        b /= iArr[0] + (i3 * 2);
        if (b == 0) {
            i2 = 1;
        } else {
            i2 = b;
        }
        int i4 = i3 * i2;
        int i5 = i2 * (iArr[0] + (i3 * 2));
        int i6 = (iArr[1] * i2) + (i3 * (i2 * 2));
        if (i5 < width) {
            i5 = width;
        }
        if (i6 < width) {
            i6 = width;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i5, i6, Config.ARGB_8888);
        int[] iArr2 = new int[(i5 * i6)];
        int i7 = (i5 - width) / 2;
        int i8 = 0;
        for (int i9 = i7; i9 < i5 - i7 && i8 < width; i9++) {
            int i10 = 0;
            int i11 = i7;
            while (i11 < i6 - i7 && i10 < width) {
                iArr2[(i9 * i5) + i11] = bitmap.getPixel(i10, i8);
                i11++;
                i10++;
            }
            i8++;
        }
        for (width = 0; width < iArr[1]; width++) {
            for (i10 = 0; i10 < iArr[0]; i10++) {
                if (bArr[(iArr[0] * width) + i10] == (byte) 1) {
                    for (i7 = 0; i7 < i2; i7++) {
                        for (i11 = 0; i11 < i2; i11++) {
                            if (iArr2[((((((width * i2) + i4) + i7) * i5) + (i10 * i2)) + i4) + i11] == 0) {
                                iArr2[((((((width * i2) + i4) + i7) * i5) + (i10 * i2)) + i4) + i11] = WebView.NIGHT_MODE_COLOR;
                            }
                        }
                    }
                } else {
                    for (i7 = 0; i7 < i2; i7++) {
                        for (i11 = 0; i11 < i2; i11++) {
                            if (iArr2[((((((width * i2) + i4) + i7) * i5) + (i10 * i2)) + i4) + i11] == 0) {
                                iArr2[((((((width * i2) + i4) + i7) * i5) + (i10 * i2)) + i4) + i11] = -1;
                            }
                        }
                    }
                }
            }
        }
        createBitmap.setPixels(iArr2, 0, i5, 0, 0, i5, i6);
        return createBitmap;
    }

    public static Bitmap b(Context context, String str, int i, int i2) {
        byte[] bArr = new byte[40000];
        int[] iArr = new int[2];
        int a = QbarNative.a(bArr, iArr, str, i, i2, "UTF-8");
        QbarNative.nativeRelease();
        if (a > 0) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            int i3 = displayMetrics.widthPixels;
            int i4 = displayMetrics.heightPixels;
            if (i3 >= i4) {
                i3 = i4;
            }
            int i5 = (int) (((double) i3) * 0.8d);
            int i6 = (int) (((double) iArr[0]) * 0.1d);
            i3 = 0;
            if (i == 0) {
                i3 = i5 / (iArr[0] + (i6 * 2));
                if (i3 == 0) {
                    i3 = 1;
                }
                i5 = i3;
            } else if (i == 5) {
                i3 = i5 / (iArr[0] + (i6 * 2));
                if (i3 == 0) {
                    i3 = 1;
                }
                i5 = i3;
                i3 = (iArr[0] * i3) / iArr[1];
            } else {
                i5 = 0;
            }
            int i7 = i6 * i5;
            i4 = (iArr[0] + (i6 * 2)) * i5;
            int i8 = (iArr[1] * i3) + (i6 * (i5 * 2));
            Bitmap createBitmap = Bitmap.createBitmap(i4, i8, Config.ARGB_8888);
            int[] iArr2 = new int[(i4 * i8)];
            Arrays.fill(iArr2, -1);
            for (i6 = 0; i6 < iArr[1]; i6++) {
                for (int i9 = 0; i9 < iArr[0]; i9++) {
                    int i10;
                    int i11;
                    if (bArr[(iArr[0] * i6) + i9] == (byte) 1) {
                        for (i10 = 0; i10 < i3; i10++) {
                            for (i11 = 0; i11 < i5; i11++) {
                                iArr2[((((((i6 * i3) + i7) + i10) * i4) + (i9 * i5)) + i7) + i11] = WebView.NIGHT_MODE_COLOR;
                            }
                        }
                    } else {
                        for (i10 = 0; i10 < i3; i10++) {
                            for (i11 = 0; i11 < i5; i11++) {
                                iArr2[((((((i6 * i3) + i7) + i10) * i4) + (i9 * i5)) + i7) + i11] = -1;
                            }
                        }
                    }
                }
            }
            createBitmap.setPixels(iArr2, 0, i4, 0, 0, i4, i8);
            if (createBitmap == null) {
                x.i("MicroMsg.QRCodeBitmapFactory", "createBitmap bm is error result %d %s", new Object[]{Integer.valueOf(a), bh.cgy().toString()});
            } else {
                x.i("MicroMsg.QRCodeBitmapFactory", "createBitmap %s", new Object[]{createBitmap});
            }
            return createBitmap;
        }
        x.i("MicroMsg.QRCodeBitmapFactory", "result %d %s", new Object[]{Integer.valueOf(a), bh.cgy().toString()});
        return null;
    }
}
