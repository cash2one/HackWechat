package com.tencent.mm.plugin.sns.lucky.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.Color;
import com.tencent.mm.memory.n;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public static n dX(String str, String str2) {
        int argb = Color.argb(51, 255, 255, 255);
        n JK = i.JK(str);
        if (JK != null) {
            return a(JK.EC(), str2, argb, 55);
        }
        x.e("MicroMsg.BlurHelper", "returnBitmap error1 ");
        return null;
    }

    public static n a(Bitmap bitmap, String str, int i, int i2) {
        n i3 = n.i(d.c(bitmap, i2));
        if (i3 == null) {
            x.e("MicroMsg.BlurHelper", "returnBitmap error2 ");
        }
        if (i3 != null) {
            new Canvas(i3.EC()).drawColor(i);
        }
        try {
            d.a(i3.EC(), 70, CompressFormat.JPEG, str, false);
        } catch (Throwable e) {
            x.e("MicroMsg.BlurHelper", "error for exception " + e.getMessage());
            x.printErrStackTrace("MicroMsg.BlurHelper", e, "", new Object[0]);
        }
        x.i("MicroMsg.BlurHelper", "blur done bitmap  " + i3);
        return i3;
    }
}
