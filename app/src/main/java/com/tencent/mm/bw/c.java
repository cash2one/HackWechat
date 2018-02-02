package com.tencent.mm.bw;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.svg.b.b;

public final class c {
    com.tencent.mm.svg.a.a xbB = new com.tencent.mm.svg.a.a();

    public static class a implements com.tencent.mm.compatible.f.a.a {
        com.tencent.mm.svg.a.a xbB = new com.tencent.mm.svg.a.a();

        public final Bitmap decodeResource(Resources resources, int i, Options options) {
            if (!this.xbB.d(resources, i)) {
                return null;
            }
            float f = 0.0f;
            if (options != null) {
                f = ((float) options.inDensity) / 160.0f;
            }
            return com.tencent.mm.svg.a.a.b(resources, i, f);
        }
    }

    static {
        com.tencent.mm.compatible.f.a.a(new a());
        b.lK(ac.getContext().getSharedPreferences("wechat_svg_debug", 4).getBoolean("open_tag", false));
    }

    public final Drawable c(Resources resources, int i) {
        if (this.xbB.d(resources, i)) {
            return com.tencent.mm.svg.a.a.c(resources, i);
        }
        return null;
    }

    public static void lu(boolean z) {
        ac.getContext().getSharedPreferences("wechat_svg_debug", 4).edit().putBoolean("open_tag", z).commit();
        b.lK(z);
    }
}
