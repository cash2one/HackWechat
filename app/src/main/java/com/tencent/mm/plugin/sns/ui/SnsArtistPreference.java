package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public final class SnsArtistPreference extends Preference {
    private MMActivity fmM;
    private String mTitle;
    private String qhm;
    private int qhn;
    private int qho;
    private TextView ryQ;
    String ryR;

    public SnsArtistPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.fmM = (MMActivity) context;
    }

    public SnsArtistPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qhm = "";
        this.mTitle = "";
        this.qhn = -1;
        this.qho = 8;
        this.ryQ = null;
        this.ryR = "";
        this.fmM = (MMActivity) context;
        setLayoutResource(g.dnt);
        setWidgetLayoutResource(g.dod);
    }

    public final void bAu() {
        if (this.ryQ != null && this.ryR != null && !this.ryR.equals("") && this.fmM != null) {
            this.ryQ.setText(this.fmM.getString(j.qJN, new Object[]{this.ryR}));
        }
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(f.content);
        viewGroup2.removeAllViews();
        this.mTitle = this.fmM.getString(j.qJO);
        layoutInflater.inflate(g.qGz, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.ryQ = (TextView) view.findViewById(f.qBo);
        ((TextView) view.findViewById(f.bJV)).setText(this.mTitle);
        TextView textView = (TextView) view.findViewById(f.cQE);
        if (textView != null) {
            textView.setVisibility(this.qho);
            textView.setText(this.qhm);
            if (this.qhn != -1) {
                textView.setBackgroundDrawable(a.b(this.fmM, this.qhn));
            }
        }
        bAu();
    }
}
