package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class j$3 implements a {
    final /* synthetic */ j rjt;
    final /* synthetic */ ImageView rju;

    j$3(j jVar, ImageView imageView) {
        this.rjt = jVar;
        this.rju = imageView;
    }

    public final void bxc() {
    }

    public final void bxd() {
    }

    public final void KY(String str) {
        try {
            this.rju.setImageBitmap(BitmapFactory.decodeFile(str));
            this.rju.setVisibility(0);
        } catch (Throwable e) {
            x.e("MicroMsg.AdLandingPageBottomSheet", "%s" + bh.i(e));
        }
    }
}
