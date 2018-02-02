package com.tencent.mm.plugin.wxcredit.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.base.preference.Preference;

public class WalletWXCreditDetailHeaderPreference extends Preference {
    private LayoutInflater DF;
    TextView ihU;
    TextView uaa;

    public WalletWXCreditDetailHeaderPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WalletWXCreditDetailHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.DF = (LayoutInflater) context.getSystemService("layout_inflater");
        setLayoutResource(g.dnt);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(f.content);
        viewGroup2.removeAllViews();
        this.DF.inflate(g.uGe, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        super.onBindView(view);
        this.ihU = (TextView) view.findViewById(f.uAw);
        this.uaa = (TextView) view.findViewById(f.uAD);
    }
}
