package com.tencent.mm.g.b;

import com.tencent.mm.by.h;
import com.tencent.mm.by.h.d;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import junit.framework.Assert;

public final class em extends h {
    private static em gwX = null;
    private static HashMap<Integer, d> gwY;

    static {
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("FavItemInfo".hashCode()), new 1());
        gwY.put(Integer.valueOf("FavSearchInfo".hashCode()), new 2());
        gwY.put(Integer.valueOf("FavEditInfo".hashCode()), new 3());
        gwY.put(Integer.valueOf("FavCdnInfo".hashCode()), new 4());
        gwY.put(Integer.valueOf("FavConfigInfo".hashCode()), new 5());
    }

    private em() {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        g.Dh();
        if (a.Cg() != 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        x.d("MicroMsg.FavoriteDataBase", "db path", g.Dj().cachePath + "enFavorite.db");
        g.Dh();
        if (a("", g.Dj().cachePath + "enFavorite.db", (long) a.Cg(), q.yE(), gwY)) {
            String str = this.xBq;
            if (!bh.ov(str)) {
                x.e("MicroMsg.FavoriteDataBase", "dbinit failed :" + str);
                b.z("init db Favorite Failed: [ " + str + "]", "DBinit");
            }
            x.d("MicroMsg.FavoriteDataBase", "init db Favorite time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            return;
        }
        throw new com.tencent.mm.z.b((byte) 0);
    }

    public static em wf() {
        if (gwX == null) {
            gwX = new em();
        }
        return gwX;
    }

    public final void eb(String str) {
        super.eb(str);
        gwX = null;
    }
}
