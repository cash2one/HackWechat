package com.tencent.mm.plugin.appbrand.ui.banner;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b$h;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.m.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;

public final class d extends b implements OnClickListener, f {
    private static boolean jOp = false;
    private View jOj;
    private TextView jOk;
    private ImageView jOl;
    private String jOm;
    private final Runnable jOn;
    private final b$h jOo;

    public final int getLayoutId() {
        return R.i.dcU;
    }

    public final boolean alg() {
        if (!jOp) {
            ((e) g.h(e.class)).b(this);
            ((e) g.h(e.class)).ald();
            ((e) g.h(e.class)).a(this);
            jOp = true;
        }
        BannerModel alm = BannerModel.alm();
        if (alm == null || bh.ov(alm.appId)) {
            setVisibility(8);
            return false;
        }
        CharSequence charSequence = alm.appName;
        String str = alm.jOF;
        String str2 = alm.iKm;
        if (!bh.ov(str)) {
            Object obj = str;
        }
        if (bh.ov(charSequence)) {
            return false;
        }
        setVisibility(0);
        if (this.jOk != null) {
            this.jOk.setText(charSequence);
        }
        if (!bh.ov(str2)) {
            Bitmap bitmap = null;
            if (!bh.ov(this.jOm)) {
                bitmap = com.tencent.mm.modelappbrand.a.b.Jj().iC(this.jOm);
            }
            if (bitmap == null || bitmap.isRecycled()) {
                this.jOm = com.tencent.mm.modelappbrand.a.b.Jj().a(this.jOo, str2, f.hkr);
            } else {
                this.jOo.j(bitmap);
            }
        }
        return true;
    }

    public final void setVisibility(int i) {
        if (this.jOj != null) {
            this.jOj.setVisibility(i);
        }
    }

    public final void destroy() {
        if (this.jOj != null) {
            ((ViewGroup) this.jOj).removeAllViews();
            this.jOj.setVisibility(8);
        }
        this.jOj = null;
        this.jOk = null;
        this.jOl = null;
        ((e) g.h(e.class)).b(this);
    }

    public final void onClick(View view) {
        BannerModel alm = BannerModel.alm();
        if (alm != null) {
            String str = alm.appId;
            int i = alm.iKd;
            if (bh.ov(str)) {
                alg();
                return;
            }
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1022;
            ((c) g.h(c.class)).a(view.getContext(), null, str, i, -1, null, appBrandStatObject);
        }
    }

    public static void alh() {
        jOp = false;
    }

    public final void ak(String str, int i) {
        ag.y(this.jOn);
    }
}
