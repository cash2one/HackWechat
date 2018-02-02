package com.tencent.mm.plugin.location.model;

import android.graphics.Bitmap;
import com.tencent.mm.br.a.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.z;

public final class m implements a {
    private Bitmap kHs = null;
    z<String, Bitmap> nRG = new z(20);

    public m() {
        try {
            this.kHs = b.a(ac.getContext().getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bv.a.getDensity(null));
            this.kHs = d.a(this.kHs, false, (float) (this.kHs.getWidth() >> 1));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TrackAvatarCacheService", e, "", new Object[0]);
        }
    }

    public final Bitmap Dy(String str) {
        if (bh.ov(str)) {
            return null;
        }
        x.d("MicroMsg.TrackAvatarCacheService", "getAvatar, tag = %s, cacheSize = %d", new Object[]{str, Integer.valueOf(this.nRG.size())});
        Bitmap bitmap = (Bitmap) this.nRG.get(str);
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public final void p(String str, Bitmap bitmap) {
        if (this.nRG.get(str) != null) {
            Bitmap bitmap2 = (Bitmap) this.nRG.get(str);
            if (!bitmap2.isRecycled()) {
                bitmap2.recycle();
            }
            this.nRG.remove(str);
        }
        this.nRG.put(str, bitmap);
        x.d("MicroMsg.TrackAvatarCacheService", "updateCache, tag = %s, cacheSize = %d", new Object[]{str, Integer.valueOf(this.nRG.size())});
    }
}
