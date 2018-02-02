package com.tencent.mm.plugin.collect.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qbar.QbarNative;

public final class b {
    public static Bitmap a(Context context, String str, String str2, int i, String str3, boolean z, int i2, a aVar) {
        int i3 = (int) (((float) i2) * 0.26f);
        int i4 = (int) (((float) i2) * 0.22f);
        int i5 = (int) (((float) i2) * 0.076f);
        try {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            x.i("MicroMsg.CollectBitmapFactory", "createCollectQrcode size avatarSize %s dpCanvas %s", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3)});
            Bitmap createBitmap = Bitmap.createBitmap(i3, i3, Config.ARGB_8888);
            Bitmap bitmap = null;
            if (i == 1 && !bh.ov(str3)) {
                bitmap = j.a(new c(str3));
                j.b(aVar);
            }
            if (bitmap == null) {
                bitmap = com.tencent.mm.ad.b.c(str2, i4, i4, (int) (((float) i4) * 0.06f));
            }
            if (bitmap == null) {
                bitmap = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(ac.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bv.a.getDensity(null));
                bitmap = d.a(bitmap, false, 0.06f * ((float) bitmap.getWidth()));
            }
            Canvas canvas = new Canvas(createBitmap);
            i4 = (i3 - i4) / 2;
            canvas.drawBitmap(bitmap, null, new Rect(i4, i4, i3 - i4, i3 - i4), paint);
            if (z) {
                canvas.drawBitmap(MMBitmapFactory.decodeStream(context.getResources().openRawResource(e.ucz)), null, new Rect(i3 - i5, i3 - i5, i3, i3), paint);
            }
            byte[] bArr = new byte[40000];
            int[] iArr = new int[2];
            i4 = QbarNative.a(bArr, iArr, str, 0, 3, "UTF-8");
            QbarNative.nativeRelease();
            if (i4 > 0) {
                bitmap = com.tencent.mm.bs.a.a.a(context, createBitmap, bArr, iArr, 0);
                if (bitmap == null) {
                    x.i("MicroMsg.QRCodeBitmapFactory", "createBitmap bm is error result %d %s", new Object[]{Integer.valueOf(i4), bh.cgy().toString()});
                } else {
                    x.i("MicroMsg.QRCodeBitmapFactory", "createBitmap %s", new Object[]{bitmap});
                }
            } else {
                x.i("MicroMsg.QRCodeBitmapFactory", "result %d %s", new Object[]{Integer.valueOf(i4), bh.cgy().toString()});
                bitmap = null;
            }
            createBitmap.recycle();
            return bitmap;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CollectBitmapFactory", e, "", new Object[0]);
            return null;
        }
    }
}
