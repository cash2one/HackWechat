package com.tencent.mm.plugin.profile.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ak;

class c$a extends BitmapDrawable implements a {
    private String url;

    public c$a(Resources resources, String str) {
        boolean z = true;
        Bitmap b = ak.a.hfN != null ? b.b(ak.a.hfN.gO(16), 2.0f) : null;
        String str2 = "MicroMsg.ContactWidgetBizInfo";
        String str3 = "verify bmp is null ? %B";
        Object[] objArr = new Object[1];
        if (b != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.i(str2, str3, objArr);
        super(resources, b);
        this.url = str;
        j.a(this);
    }

    public final void draw(Canvas canvas) {
        Bitmap a = j.a(new 1(this));
        if (a == null || a.isRecycled()) {
            a = null;
        }
        Rect bounds = getBounds();
        if (a != null) {
            canvas.drawBitmap(a, null, bounds, null);
        }
    }

    public final void l(String str, Bitmap bitmap) {
        if (this.url.equals(str)) {
            invalidateSelf();
        }
    }
}
