package com.tencent.mm.plugin.collect.ui;

import android.graphics.Bitmap;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.sdk.platformtools.x;

class CollectMainUI$11 implements a {
    final /* synthetic */ CollectMainUI lnh;

    CollectMainUI$11(CollectMainUI collectMainUI) {
        this.lnh = collectMainUI;
    }

    public final void l(String str, Bitmap bitmap) {
        if (str != null && CollectMainUI.a(this.lnh) != null && str.equals(CollectMainUI.a(this.lnh))) {
            x.i("MicroMsg.CollectMainUI", "cdnImageDownloadListener mchPhoto = %s notifyKey = %s", new Object[]{CollectMainUI.a(this.lnh), str});
            this.lnh.azs();
        }
    }
}
