package com.tencent.mm.plugin.product.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.product.b.n;
import com.tencent.mm.sdk.platformtools.bh;

public final class m implements a {
    public TextView ihS;
    public ImageView jNs;
    public n.a pgE;

    public final void l(String str, Bitmap bitmap) {
        if (this.pgE != null && !bh.ov(this.pgE.iconUrl) && str.equals(this.pgE.iconUrl)) {
            this.jNs.post(new 1(this, bitmap));
        }
    }
}
