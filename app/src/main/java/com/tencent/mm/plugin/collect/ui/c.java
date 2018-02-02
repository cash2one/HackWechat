package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.l.a;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.z.ak;

public final class c extends Preference {
    String gAb = null;
    private TextView jJn = null;
    private ImageView lkk = null;
    private Context mContext = null;
    String mTitle = null;
    private View mView = null;

    public c(Context context) {
        super(context);
        this.mContext = context;
        setLayoutResource(g.uBD);
    }

    public c(Context context, int i) {
        super(context);
        this.mContext = context;
        setLayoutResource(i);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.jJn = (TextView) view.findViewById(16908310);
        this.lkk = (ImageView) view.findViewById(f.uiO);
        this.jJn.setText(i.b(this.mContext, this.mTitle, this.jJn.getTextSize()));
        if (bh.ov(this.gAb)) {
            this.lkk.setVisibility(8);
            return;
        }
        this.lkk.setVisibility(0);
        com.tencent.mm.kernel.g.Dk();
        a WN = ((h) com.tencent.mm.kernel.g.h(h.class)).EY().WN(this.gAb);
        if (WN == null || ((int) WN.gJd) <= 0) {
            x.d("MicroMsg.CollectPayInfoPreference", "Receiver in contactStg and try to get contact");
            ak.a.hfL.a(this.gAb, "", new 1(this, bh.Wp()));
            return;
        }
        b.a(this.lkk, this.gAb);
    }
}
