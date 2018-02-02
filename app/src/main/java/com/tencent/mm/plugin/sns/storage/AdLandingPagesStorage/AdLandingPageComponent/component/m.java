package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.CircularImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends a {
    CircularImageView rjy;

    public m(Context context, p pVar, ViewGroup viewGroup) {
        super(context, pVar, viewGroup);
    }

    protected final View bxb() {
        return new CircularImageView(this.context);
    }

    public final View bwW() {
        this.rjy = (CircularImageView) this.contentView;
        return this.contentView;
    }

    protected final void bxa() {
        if (this.contentView != null && this.rjy != null) {
            p pVar = (p) this.rji;
            if (pVar != null) {
                d.a(pVar.rgz, pVar.rgL, new a(this) {
                    final /* synthetic */ m rjz;

                    {
                        this.rjz = r1;
                    }

                    public final void bxc() {
                    }

                    public final void bxd() {
                    }

                    public final void KY(String str) {
                        try {
                            Bitmap decodeFile = BitmapFactory.decodeFile(str);
                            m mVar = this.rjz;
                            if (decodeFile == null) {
                                x.e("AdLandingPageCircleImgComp", "when set image the bmp is null!");
                            } else if (mVar.rjy == null) {
                                x.e("AdLandingPageCircleImgComp", "when set image the img is null!");
                            } else if (decodeFile.getWidth() == 0) {
                                x.e("AdLandingPageCircleImgComp", "when set image the bmp.getWidth is 0!");
                            } else {
                                mVar.rjy.setImageBitmap(decodeFile);
                            }
                        } catch (Throwable e) {
                            x.e("AdLandingPageCircleImgComp", "%s" + bh.i(e));
                        }
                    }
                });
            }
        }
    }
}
