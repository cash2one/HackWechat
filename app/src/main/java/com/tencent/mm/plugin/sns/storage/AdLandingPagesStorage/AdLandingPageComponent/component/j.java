package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.design.widget.c;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class j {
    public String gOP = "";
    public View kND;
    public String lRA = "";
    public Context mContext;
    public String mTitle = "";
    public c rjn;
    private int rjo = -1;
    private int rjp = -1;
    private boolean rjq = false;
    private boolean rjr = false;
    public a rjs;

    public j(Context context, i iVar, String str, String str2, String str3, boolean z, boolean z2) {
        this.gOP = str;
        this.mTitle = str2;
        this.lRA = str3;
        this.mContext = context;
        this.rjq = z;
        this.rjr = z2;
        if (iVar != null && iVar.getView() != null) {
            this.rjn = new c(context);
            this.rjn.setCanceledOnTouchOutside(true);
            this.kND = View.inflate(context, i$g.qGL, null);
            if (this.kND == null) {
                x.e("MicroMsg.AdLandingPageBottomSheet", "mRootView init fail!");
                return;
            }
            LinearLayout linearLayout = (LinearLayout) this.kND.findViewById(f.qBJ);
            View view = iVar.getView();
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.rjo = (int) iVar.bxe().rgQ;
            this.rjp = (int) iVar.bxe().rgR;
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            Object obj = (this.rjo == Integer.MAX_VALUE || this.rjp == Integer.MAX_VALUE) ? null : 1;
            if (obj != null) {
                layoutParams.width = this.rjo;
                layoutParams.height = this.rjp;
            }
            linearLayout.addView(view, layoutParams);
            ((TextView) this.kND.findViewById(f.qBw)).setText(str2);
            View findViewById = this.kND.findViewById(f.qBE);
            findViewById.setOnClickListener(new 1(this));
            View findViewById2 = this.kND.findViewById(f.qBv);
            findViewById2.setOnClickListener(new 2(this));
            if (!this.rjr) {
                findViewById2.setVisibility(8);
            }
            if (this.rjq) {
                findViewById.setVisibility(8);
            }
            ImageView imageView = (ImageView) this.kND.findViewById(f.mdz);
            imageView.setVisibility(8);
            if (!bh.ov(str3)) {
                Bitmap ek = d.ek("adId", str3);
                if (ek != null) {
                    imageView.setImageBitmap(ek);
                    imageView.setVisibility(0);
                    return;
                }
                d.a(str3, 0, new 3(this, imageView));
            }
        }
    }

    public final void bxh() {
        if (this.rjn != null) {
            this.rjn.dismiss();
        }
    }
}
