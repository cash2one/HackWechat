package com.tencent.mm.view;

import android.content.Context;
import com.tencent.mm.api.d;
import com.tencent.mm.api.m.a;

public final class b extends a {
    public b(Context context, a aVar) {
        super(context, aVar);
    }

    protected final com.tencent.mm.view.b.a cAc() {
        return new com.tencent.mm.view.b.b(getContext(), cAl());
    }

    protected final com.tencent.mm.view.footer.a cAd() {
        return new com.tencent.mm.view.footer.b(getContext(), cAl());
    }

    public final d[] cde() {
        if (this.zDb == null) {
            this.zDb = new d[]{d.DOODLE, d.EMOJI, d.TEXT, d.MOSAIC, d.CROP_PHOTO};
        }
        return this.zDb;
    }
}
