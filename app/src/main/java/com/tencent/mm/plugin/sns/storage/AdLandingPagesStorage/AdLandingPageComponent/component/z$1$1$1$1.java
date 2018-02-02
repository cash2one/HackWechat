package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.graphics.drawable.Drawable;
import android.text.Html.ImageGetter;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z.1.1.1;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.sdk.platformtools.bh;

class z$1$1$1$1 implements ImageGetter {
    final /* synthetic */ 1 rlC;

    z$1$1$1$1(1 1) {
        this.rlC = 1;
    }

    public final Drawable getDrawable(String str) {
        String ei = d.ei("adId", str);
        if (bh.ov(ei) || !FileOp.bO(ei)) {
            return null;
        }
        Drawable createFromPath = Drawable.createFromPath(ei);
        if (createFromPath != null) {
            createFromPath.setBounds(0, 0, createFromPath.getIntrinsicHeight() != 0 ? (createFromPath.getIntrinsicWidth() * ((int) z.a(this.rlC.rlB.rlA.rlz).gUh)) / createFromPath.getIntrinsicHeight() : createFromPath.getIntrinsicWidth(), createFromPath.getIntrinsicHeight() != 0 ? (int) z.a(this.rlC.rlB.rlA.rlz).gUh : createFromPath.getIntrinsicHeight());
        }
        return createFromPath;
    }
}
