package com.tencent.mm.aq.a.b;

import com.tencent.mm.a.g;
import com.tencent.mm.aq.a.c.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class d implements f {
    public final String lB(String str) {
        if (bh.ov(str)) {
            return null;
        }
        x.d("MicroMsg.imageloader.DefaultImageFileNameCreater", "[cpan] create image file name :%s", new Object[]{g.s(str.getBytes())});
        return g.s(str.getBytes());
    }
}
