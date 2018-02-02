package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.ui.base.preference.Preference;

public class DividerPreference extends Preference {
    private boolean kej;
    private View mView;
    private boolean pdd;
    private boolean pde;

    public DividerPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mView = null;
        this.pdd = false;
        this.pde = false;
        this.kej = true;
        setLayoutResource(g.uBG);
    }

    public DividerPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    protected final void onBindView(View view) {
        int i;
        super.onBindView(view);
        View findViewById = view.findViewById(f.ujJ);
        LayoutParams layoutParams = (LayoutParams) findViewById.getLayoutParams();
        int b = b.b(this.mContext, 10.0f);
        if (this.pdd) {
            i = b;
        } else {
            i = 0;
        }
        if (!this.pde) {
            b = 0;
        }
        layoutParams.setMargins(0, i, 0, b);
        findViewById.setLayoutParams(layoutParams);
        if (this.kej) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(4);
        }
    }
}
