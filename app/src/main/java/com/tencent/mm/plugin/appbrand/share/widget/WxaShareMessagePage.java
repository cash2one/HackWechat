package com.tencent.mm.plugin.appbrand.share.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b$h;
import com.tencent.mm.plugin.appbrand.compat.a.a;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.appbrand.p.f;
import com.tencent.mm.plugin.appbrand.p.k;
import com.tencent.mm.plugin.appbrand.q$g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public class WxaShareMessagePage extends LinearLayout implements b$h {
    public TextView jJn;
    public ImageView jJo;
    public IPCDynamicPageView jJp;
    public ThreeDotsLoadingView jJq;
    public ImageView jsu;

    public WxaShareMessagePage(Context context) {
        super(context);
        init(context);
    }

    public WxaShareMessagePage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public WxaShareMessagePage(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        View inflate = View.inflate(context, h.ixO, this);
        this.jsu = (ImageView) inflate.findViewById(q$g.bZs);
        this.jJo = (ImageView) inflate.findViewById(q$g.ceM);
        this.jJp = (IPCDynamicPageView) inflate.findViewById(q$g.iwE);
        this.jJn = (TextView) inflate.findViewById(q$g.cSu);
        this.jJq = (ThreeDotsLoadingView) inflate.findViewById(q$g.ctD);
        ((ViewGroup) inflate.findViewById(q$g.bYF)).addView(((a) g.h(a.class)).c(context, (ViewGroup) inflate));
        setGravity(17);
    }

    public final void Jm() {
    }

    public final void j(Bitmap bitmap) {
        this.jJq.setVisibility(4);
        this.jJq.ajm();
        if (bitmap == null || bitmap.isRecycled()) {
            this.jsu.setImageBitmap(null);
            this.jJo.setVisibility(0);
            return;
        }
        this.jsu.setImageBitmap(bitmap);
        this.jJo.setVisibility(4);
    }

    public final void Jn() {
        this.jJq.setVisibility(4);
        this.jJq.ajm();
        this.jsu.setImageBitmap(null);
        this.jJo.setVisibility(0);
    }

    public final String Jo() {
        return k.bi(this);
    }

    public final void ue(String str) {
        this.jJq.setVisibility(0);
        this.jJq.cze();
        this.jJo.setVisibility(4);
        this.jsu.setVisibility(0);
        b.Jj().a(this, str, null, ((com.tencent.mm.modelappbrand.g) g.h(com.tencent.mm.modelappbrand.g.class)).aZ(MMGIFException.D_GIF_ERR_IMAGE_DEFECT, 90));
    }

    public final void s(Bitmap bitmap) {
        this.jsu.setVisibility(0);
        this.jJq.setVisibility(4);
        this.jJo.setVisibility(4);
        if (bitmap == null || bitmap.isRecycled()) {
            this.jsu.setImageBitmap(null);
            return;
        }
        this.jsu.setImageBitmap(((com.tencent.mm.modelappbrand.g) g.h(com.tencent.mm.modelappbrand.g.class)).IY().k(bitmap));
    }

    public static int akf() {
        return f.lI(224);
    }

    public static int akg() {
        return f.lI(180);
    }
}
