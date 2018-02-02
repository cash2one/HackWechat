package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class f extends i {
    ImageView fvf;
    ProgressBar lAk;
    boolean rjb;

    public f(Context context, ViewGroup viewGroup) {
        this(context, viewGroup, (byte) 0);
    }

    private f(Context context, ViewGroup viewGroup, byte b) {
        super(context, null, viewGroup);
        this.rjb = true;
    }

    public final View bwW() {
        View view = this.contentView;
        this.fvf = (ImageView) view.findViewById(com.tencent.mm.plugin.sns.i.f.qDS);
        this.lAk = (ProgressBar) view.findViewById(com.tencent.mm.plugin.sns.i.f.cEd);
        return view;
    }

    protected final int bjK() {
        return i$g.qGO;
    }

    protected final void bxa() {
        if (this.contentView != null && this.fvf != null && this.lAk != null && ((p) this.rji) != null) {
            float f = ((p) this.rji).rgM;
            float f2 = ((p) this.rji).rgN;
            float f3 = ((p) this.rji).rgO;
            float f4 = ((p) this.rji).rgP;
            String str = ((p) this.rji).rgz;
            float f5 = ((p) this.rji).height;
            LayoutParams layoutParams = (LayoutParams) this.fvf.getLayoutParams();
            layoutParams.width = (int) ((p) this.rji).width;
            layoutParams.height = (int) f5;
            this.fvf.setLayoutParams(layoutParams);
            this.rjb = false;
            startLoading();
            d.a(str, ((p) this.rji).rgL, new a(this) {
                final /* synthetic */ f rjc;

                {
                    this.rjc = r1;
                }

                public final void bxc() {
                    this.rjc.startLoading();
                }

                public final void bxd() {
                    this.rjc.lAk.setVisibility(8);
                }

                public final void KY(String str) {
                    try {
                        Bitmap decodeFile = BitmapFactory.decodeFile(str);
                        f fVar = this.rjc;
                        if (decodeFile == null) {
                            x.e("AdLandingImageComp", "when set image the bmp is null!");
                        } else if (fVar.fvf == null) {
                            x.e("AdLandingImageComp", "when set image the imageView is null!");
                        } else if (decodeFile.getWidth() == 0) {
                            x.e("AdLandingImageComp", "when set image the bmp.getWidth is 0!");
                        } else {
                            fVar.fvf.setImageBitmap(decodeFile);
                            fVar.lAk.setVisibility(8);
                        }
                    } catch (Throwable e) {
                        x.e("AdLandingImageComp", "%s" + bh.i(e));
                    }
                }
            });
            this.contentView.setPadding((int) f3, (int) f, (int) f4, (int) f2);
            iC(false);
        }
    }

    public final void startLoading() {
        this.lAk.setVisibility(0);
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
            x.printErrStackTrace("AdLandingImageComp", e, "", new Object[0]);
            return false;
        }
    }
}
