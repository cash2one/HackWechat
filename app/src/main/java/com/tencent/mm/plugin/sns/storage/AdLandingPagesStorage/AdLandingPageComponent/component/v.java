package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class v extends a {
    private ImageView fvf;
    private int kDP;
    private int kDQ;
    ProgressBar lAk;
    boolean rgw;
    boolean rjb = true;
    private WindowManager rkK;

    public v(Context context, p pVar, ViewGroup viewGroup) {
        super(context, pVar, viewGroup);
    }

    protected final int bjK() {
        return g.qGS;
    }

    public final View bwW() {
        this.fvf = (ImageView) this.contentView.findViewById(f.qDS);
        this.lAk = (ProgressBar) this.contentView.findViewById(f.cEd);
        return this.contentView;
    }

    protected final void bxa() {
        if (this.contentView != null && this.fvf != null && this.lAk != null && ((p) this.rji) != null) {
            if (this.rkK == null) {
                this.rkK = (WindowManager) this.context.getSystemService("window");
                this.kDP = this.rkK.getDefaultDisplay().getWidth();
                this.kDQ = this.rkK.getDefaultDisplay().getHeight();
            }
            String str = ((p) this.rji).rgz;
            String str2 = ((p) this.rji).rgA;
            float f = ((p) this.rji).height;
            float f2 = ((p) this.rji).width;
            this.rgw = ((p) this.rji).rgw;
            if (f != 0.0f && f2 != 0.0f && !this.rgw) {
                this.fvf.setLayoutParams(new LayoutParams((int) f2, (int) f));
            } else if (!this.rgw || f == 0.0f || f2 == 0.0f) {
                this.fvf.setLayoutParams(new LayoutParams(this.kDP, this.kDQ));
            } else {
                this.fvf.setLayoutParams(new LayoutParams(this.kDP, this.kDQ));
            }
            if (str2 != null && str2.length() > 0) {
                try {
                    this.fvf.setBackgroundColor(Color.parseColor(str2));
                } catch (Exception e) {
                }
            }
            if (str == null || str.length() <= 0) {
                x.i("AdLandingPagePureImageComponet", "Pure image component fillItem without imageurl.");
                return;
            }
            Bitmap ek = d.ek("adId", str);
            if (ek == null || !I(ek)) {
                this.rjb = false;
                startLoading();
                d.a(str, ((p) this.rji).rgL, new 1(this));
                return;
            }
            x.i("AdLandingPagePureImageComponet", "loaded cached image with  " + str);
            this.rjb = true;
        }
    }

    public final void startLoading() {
        this.lAk.setVisibility(0);
    }

    public final boolean I(Bitmap bitmap) {
        if (bitmap == null) {
            x.e("AdLandingPagePureImageComponet", "when set image the bmp is null!");
            return false;
        } else if (this.fvf == null) {
            x.e("AdLandingPagePureImageComponet", "when set image the imageView is null!");
            return false;
        } else if (bitmap.getWidth() == 0) {
            x.e("AdLandingPagePureImageComponet", "when set image the bmp.getWidth is 0!");
            return false;
        } else {
            this.fvf.setImageBitmap(bitmap);
            this.lAk.setVisibility(8);
            return true;
        }
    }

    public final boolean S(JSONObject jSONObject) {
        if (!super.S(jSONObject)) {
            return false;
        }
        try {
            if (!this.rjb) {
                String UZ = ab.UZ(((p) this.rji).rgz);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("urlMd5", UZ);
                jSONObject2.put("needDownload", 1);
                jSONObject.put("imgUrlInfo", jSONObject2);
            }
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("AdLandingPagePureImageComponet", e, "", new Object[0]);
            return false;
        }
    }
}
