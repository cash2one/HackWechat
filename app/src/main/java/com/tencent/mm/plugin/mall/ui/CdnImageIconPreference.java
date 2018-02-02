package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.w.a.g;

public class CdnImageIconPreference extends IconPreference {
    String iconUrl;
    private CdnImageView old;

    public CdnImageIconPreference(Context context) {
        super(context);
    }

    public CdnImageIconPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CdnImageIconPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(g.content);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, a.g.uBo, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.old = (CdnImageView) view.findViewById(a$f.cpk);
        if (!bh.ov(this.iconUrl)) {
            this.old.vng = true;
            this.old.setUrl(this.iconUrl);
            this.old.setVisibility(0);
        }
    }
}
