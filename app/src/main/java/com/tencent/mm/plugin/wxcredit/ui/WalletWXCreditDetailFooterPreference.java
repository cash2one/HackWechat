package com.tencent.mm.plugin.wxcredit.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.base.preference.Preference;

public class WalletWXCreditDetailFooterPreference extends Preference implements OnClickListener {
    private LayoutInflater DF;
    private TextView tZX;
    private TextView tZY;
    OnClickListener tZZ;

    public WalletWXCreditDetailFooterPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WalletWXCreditDetailFooterPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.DF = (LayoutInflater) context.getSystemService("layout_inflater");
        setLayoutResource(g.dnt);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(f.content);
        viewGroup2.removeAllViews();
        this.DF.inflate(g.uGd, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        super.onBindView(view);
        this.tZX = (TextView) view.findViewById(f.uAx);
        this.tZY = (TextView) view.findViewById(f.uAv);
        this.tZX.setOnClickListener(this);
        this.tZY.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (this.tZZ != null) {
            this.tZZ.onClick(view);
        }
    }
}
