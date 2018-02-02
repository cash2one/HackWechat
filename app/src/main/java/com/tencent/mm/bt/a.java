package com.tencent.mm.bt;

import com.tencent.mm.api.d;
import com.tencent.mm.api.k;
import com.tencent.mm.bo.b;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.cache.c;
import com.tencent.mm.cache.g;
import com.tencent.mm.t.e;
import java.util.Iterator;
import java.util.Stack;

public final class a implements k {
    private b fhY;

    public a(b bVar) {
        this.fhY = bVar;
    }

    public final int sX() {
        c cVar = (c) ArtistCacheManager.xu().a(com.tencent.mm.d.a.EMOJI_AND_TEXT);
        if (cVar == null) {
            return 0;
        }
        return cVar.xB()[1];
    }

    public final int sY() {
        c cVar = (c) ArtistCacheManager.xu().a(com.tencent.mm.d.a.EMOJI_AND_TEXT);
        if (cVar == null) {
            return 0;
        }
        return cVar.xB()[0];
    }

    public final int sZ() {
        g gVar = (g) ArtistCacheManager.xu().a(com.tencent.mm.d.a.MOSAIC);
        if (gVar == null) {
            return 0;
        }
        return gVar.aZ(false);
    }

    public final int ta() {
        com.tencent.mm.cache.b bVar = (com.tencent.mm.cache.b) ArtistCacheManager.xu().a(com.tencent.mm.d.a.DOODLE);
        if (bVar == null) {
            return 0;
        }
        return bVar.aZ(false);
    }

    public final int tb() {
        int i = 0;
        com.tencent.mm.cache.b bVar = (com.tencent.mm.cache.b) ArtistCacheManager.xu().a(com.tencent.mm.d.a.DOODLE);
        if (bVar != null) {
            i = bVar.gBx + 0;
        }
        g gVar = (g) ArtistCacheManager.xu().a(com.tencent.mm.d.a.MOSAIC);
        if (gVar != null) {
            return i + gVar.gBx;
        }
        return i;
    }

    public final boolean tc() {
        com.tencent.mm.cache.a aVar = (com.tencent.mm.cache.a) ArtistCacheManager.xu().a(com.tencent.mm.d.a.CROP_PHOTO);
        if (aVar == null) {
            return false;
        }
        return aVar.aZ(false) > 0;
    }

    public final boolean td() {
        com.tencent.mm.d.b b = this.fhY.b(d.CROP_PHOTO);
        if (b == null || b.uG() != com.tencent.mm.d.a.CROP_PHOTO) {
            return false;
        }
        boolean z;
        if (((com.tencent.mm.d.c) b).fiM > 0) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public final int getTextColor() {
        c cVar = (c) ArtistCacheManager.xu().a(com.tencent.mm.d.a.EMOJI_AND_TEXT);
        if (cVar == null) {
            return 0;
        }
        int i;
        Stack stack = cVar.gBv;
        if (stack != null) {
            Iterator it = stack.iterator();
            i = 0;
            while (it.hasNext()) {
                com.tencent.mm.t.c cVar2 = (com.tencent.mm.t.c) it.next();
                if (cVar2 instanceof e) {
                    e eVar = (e) cVar2;
                    int[] iArr = com.tencent.mm.view.footer.a.zFl;
                    for (int i2 = 0; i2 < iArr.length; i2++) {
                        if (eVar.su == iArr[i2]) {
                            i = (1 << i2) | i;
                            break;
                        }
                    }
                }
            }
        } else {
            i = 0;
        }
        return i;
    }

    public final int te() {
        com.tencent.mm.cache.b bVar = (com.tencent.mm.cache.b) ArtistCacheManager.xu().a(com.tencent.mm.d.a.DOODLE);
        if (bVar == null) {
            return 0;
        }
        int i;
        Stack stack = bVar.gBv;
        if (stack != null) {
            Iterator it = stack.iterator();
            i = 0;
            while (it.hasNext()) {
                com.tencent.mm.t.b bVar2 = (com.tencent.mm.t.b) it.next();
                int[] iArr = com.tencent.mm.view.footer.a.zFl;
                for (int i2 = 0; i2 < iArr.length; i2++) {
                    if (bVar2.su == iArr[i2]) {
                        i = (1 << i2) | i;
                        break;
                    }
                }
            }
        } else {
            i = 0;
        }
        return i;
    }

    public final boolean tf() {
        com.tencent.mm.cache.b bVar = (com.tencent.mm.cache.b) ArtistCacheManager.xu().a(com.tencent.mm.d.a.DOODLE);
        g gVar = (g) ArtistCacheManager.xu().a(com.tencent.mm.d.a.MOSAIC);
        com.tencent.mm.cache.a aVar = (com.tencent.mm.cache.a) ArtistCacheManager.xu().a(com.tencent.mm.d.a.CROP_PHOTO);
        c cVar = (c) ArtistCacheManager.xu().a(com.tencent.mm.d.a.EMOJI_AND_TEXT);
        if ((bVar == null || bVar.aZ(true) <= 0) && ((gVar == null || gVar.aZ(true) <= 0) && ((cVar == null || cVar.aZ(true) <= 0) && (aVar == null || aVar.aZ(true) <= 0)))) {
            return false;
        }
        return true;
    }
}
