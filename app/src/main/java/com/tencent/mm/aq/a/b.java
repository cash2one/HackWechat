package com.tencent.mm.aq.a;

import android.graphics.Bitmap;
import com.tencent.mm.aq.a.c.h;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public final class b {
    public com.tencent.mm.aq.a.a.b hCV;
    h hCW;
    Executor hCX;
    public final Map<Integer, String> hCY = Collections.synchronizedMap(new HashMap());
    public HashMap<Integer, com.tencent.mm.aq.a.f.b> hCZ = new HashMap();

    public b(com.tencent.mm.aq.a.a.b bVar) {
        this.hCV = bVar;
        this.hCW = bVar.hDv;
        this.hCX = bVar.hDw;
        this.hCV.hDp.a(this.hCV.hDr);
    }

    public final Bitmap lz(String str) {
        if (this.hCV != null) {
            return this.hCV.hDo.iG(str);
        }
        return null;
    }

    public final void a(c cVar) {
        this.hCY.remove(Integer.valueOf(cVar.PI()));
        x.d("MicroMsg.imageloader.ImageLoaderManager", "[cpan] remove image weak holder size:%d viewcode:%s", new Object[]{Integer.valueOf(this.hCY.size()), Integer.valueOf(cVar.PI())});
    }
}
