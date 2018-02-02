package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.as.a;
import com.tencent.mm.sdk.platformtools.x;

class e$6 implements a {
    final /* synthetic */ String jql;
    private Bitmap mTJ = null;
    final /* synthetic */ e yEz;

    e$6(e eVar, String str) {
        this.yEz = eVar;
        this.jql = str;
    }

    public final boolean JC() {
        int intValue;
        e.d(this.yEz);
        if (e.e(this.yEz).containsKey(this.jql)) {
            intValue = ((Integer) e.e(this.yEz).get(this.jql)).intValue();
            if (e.f(this.yEz)) {
                e.a(this.yEz, intValue, this.mTJ);
            } else {
                e.g(this.yEz).put(intValue, this.mTJ);
            }
        }
        this.yEz.u(this.jql, this.mTJ);
        String str = "MicroMsg.ImageGalleryLazyLoader";
        String str2 = "bmp size : %s";
        Object[] objArr = new Object[1];
        Bitmap bitmap = this.mTJ;
        if (bitmap == null || bitmap.isRecycled()) {
            intValue = 0;
        } else {
            intValue = VERSION.SDK_INT >= 12 ? bitmap.getByteCount() : bitmap.getRowBytes() * bitmap.getHeight();
            if (intValue < 0) {
                throw new IllegalStateException("Negative size: " + bitmap);
            }
        }
        objArr[0] = Integer.valueOf(intValue);
        x.i(str, str2, objArr);
        this.mTJ = null;
        e.h(this.yEz);
        return false;
    }

    public final boolean JB() {
        if (e.b(this.yEz) == null || TextUtils.isEmpty(this.jql)) {
            return false;
        }
        try {
            this.mTJ = e.b(this.yEz).Zn(this.jql);
            return true;
        } catch (Exception e) {
            x.w("MicroMsg.ImageGalleryLazyLoader", "try to load Bmp fail: %s", new Object[]{e.getMessage()});
            this.mTJ = null;
            return false;
        }
    }
}
