package com.tencent.mm.booter.cache;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mm.a.f;
import com.tencent.mm.cache.MCacheItem;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends com.tencent.mm.cache.f.a {
    public static a gzt;
    private final f<String, Bitmap> gzu;

    private a() {
        Context context = ac.getContext();
        String str = "BACKGROUND_BITMAP_CACHE_LIMIT";
        if (com.tencent.mm.platformtools.a.a.values == null) {
            try {
                com.tencent.mm.platformtools.a.a.values = r.UU(bh.convertStreamToString(context.getAssets().open("profile.ini")));
            } catch (Throwable e) {
                x.e("MicroMsg.ProfileUtil", "exception:%s", new Object[]{bh.i(e)});
            }
        }
        this.gzu = new f(bh.getInt(com.tencent.mm.platformtools.a.a.values == null ? null : (String) com.tencent.mm.platformtools.a.a.values.get(str), MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN));
    }

    public static void prepare() {
        if (gzt == null) {
            gzt = new a();
        }
    }

    public static void destroy() {
        if (gzt != null) {
            gzt.gzu.clear();
        }
    }

    public final Bitmap getBitmap(String str) {
        x.v("MicroMsg.MMCacheImpl", "getting bitmap: %s", new Object[]{str});
        return (Bitmap) this.gzu.get(str);
    }

    public final MCacheItem em(String str) {
        x.v("MicroMsg.MMCacheImpl", "getting cache item: %s", new Object[]{str});
        return null;
    }

    public final void b(String str, Bitmap bitmap) {
        x.v("MicroMsg.MMCacheImpl", "setting bitmap: %s", new Object[]{str});
        this.gzu.l(str, bitmap);
    }

    public final void en(String str) {
        x.v("MicroMsg.MMCacheImpl", "setting cache item: %s", new Object[]{str});
    }
}
