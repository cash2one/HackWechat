package com.tencent.mm;

import android.content.Context;
import com.tencent.mm.api.b;
import com.tencent.mm.api.j;
import com.tencent.mm.api.k;
import com.tencent.mm.api.m;
import com.tencent.mm.api.m.c;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.cache.ArtistCacheManager.1;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bh;

public final class a extends m {
    private com.tencent.mm.view.a bpM;
    private k bpN;

    public final b ai(Context context) {
        if (this.bpM == null) {
            if (this.fdC.fdE == c.fdJ) {
                this.bpM = new com.tencent.mm.view.c(context, this.fdC);
            } else if (this.fdC.fdE == c.fdK) {
                this.bpM = new com.tencent.mm.view.b(context, this.fdC);
            }
        }
        return this.bpM;
    }

    public final void a(j jVar) {
        this.bpM.cAl().a(jVar, !sT().tf());
    }

    public final boolean sS() {
        return this.bpM.cAl().sS();
    }

    public final void a(com.tencent.mm.api.m.a aVar) {
        super.a(aVar);
        ArtistCacheManager xu = ArtistCacheManager.xu();
        String az = bh.az(this.fdC.path, "MicroMsg.MMPhotoEditorImpl");
        xu.gBq = az;
        if (!ArtistCacheManager.gBo.containsKey(az)) {
            ArtistCacheManager.gBo.put(az, new a(xu));
        }
    }

    public final void onDestroy() {
        if (!this.fdC.fdF) {
            ArtistCacheManager xu = ArtistCacheManager.xu();
            String az = bh.az(this.fdC.path, "MicroMsg.MMPhotoEditorImpl");
            xu.gBq = null;
            if (ArtistCacheManager.gBo.containsKey(az)) {
                ((a) ArtistCacheManager.gBo.get(az)).clearAll();
                ArtistCacheManager.gBo.remove(az);
            }
            e.cgR();
            e.post(new 1(xu), "MicroMsg.ArtistCacheManager[clearAllCache]");
        }
        if (this.bpM != null) {
            this.bpM.cAl().onDestroy();
        }
    }

    public final k sT() {
        if (this.bpN == null) {
            this.bpN = new com.tencent.mm.bt.a(this.bpM.cAl());
        }
        return this.bpN;
    }
}
