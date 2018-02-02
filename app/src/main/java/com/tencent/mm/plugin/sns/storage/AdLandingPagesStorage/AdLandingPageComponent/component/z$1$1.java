package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.Html.ImageGetter;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z.1;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class z$1$1 implements ImageGetter {
    final /* synthetic */ 1 rlA;

    z$1$1(1 1) {
        this.rlA = 1;
    }

    public final Drawable getDrawable(String str) {
        String ei = d.ei("adId", str);
        if (bh.ov(ei) || !FileOp.bO(ei)) {
            d.a("adId", str, false, 0, 0, new a(this) {
                final /* synthetic */ z$1$1 rlB;

                {
                    this.rlB = r1;
                }

                public final void bxc() {
                }

                public final void bxd() {
                }

                public final void KY(String str) {
                    try {
                        ag.y(new 2(this, Html.fromHtml(this.rlB.rlA.rly, new 1(this), null)));
                    } catch (Exception e) {
                        x.e("MicroMsg.Sns.AdLandingPageTextComponent", "the backgroundCoverUrl is set error ,because " + e.toString());
                    }
                }
            });
            return null;
        }
        Drawable createFromPath = Drawable.createFromPath(ei);
        if (createFromPath == null) {
            return createFromPath;
        }
        int intrinsicWidth;
        int i;
        if (createFromPath.getIntrinsicHeight() != 0) {
            intrinsicWidth = (createFromPath.getIntrinsicWidth() * ((int) z.a(this.rlA.rlz).gUh)) / createFromPath.getIntrinsicHeight();
        } else {
            intrinsicWidth = createFromPath.getIntrinsicWidth();
        }
        if (createFromPath.getIntrinsicHeight() != 0) {
            i = (int) z.a(this.rlA.rlz).gUh;
        } else {
            i = createFromPath.getIntrinsicHeight();
        }
        createFromPath.setBounds(0, 0, intrinsicWidth, i);
        return createFromPath;
    }
}
