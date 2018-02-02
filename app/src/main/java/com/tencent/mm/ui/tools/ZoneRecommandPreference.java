package com.tencent.mm.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.storage.RegionCodeDecoder.Region;
import com.tencent.mm.ui.base.preference.Preference;

public class ZoneRecommandPreference extends Preference {
    private TextView ihV;
    int status;
    Region znB;
    Region znC;
    Region znD;
    private TextView znE;
    private ImageView znF;

    public ZoneRecommandPreference(Context context) {
        this(context, null);
    }

    public ZoneRecommandPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZoneRecommandPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.status = 0;
        setLayoutResource(R.i.dnt);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.dnQ, viewGroup2);
        this.znE = (TextView) onCreateView.findViewById(R.h.cZV);
        this.ihV = (TextView) onCreateView.findViewById(R.h.status);
        this.znF = (ImageView) onCreateView.findViewById(R.h.cPq);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        cye();
    }

    final void cye() {
        if (this.znE != null && this.ihV != null) {
            switch (this.status) {
                case 0:
                    this.znE.setVisibility(8);
                    this.ihV.setVisibility(0);
                    this.ihV.setText(R.l.eKH);
                    this.znF.setImageResource(R.k.dyL);
                    setEnabled(false);
                    setSelectable(false);
                    return;
                case 1:
                    this.znE.setVisibility(0);
                    this.ihV.setVisibility(8);
                    this.znF.setImageResource(R.k.dyL);
                    CharSequence charSequence = "";
                    if (!(this.znB == null || t.ov(this.znB.getName()))) {
                        charSequence = charSequence + this.znB.getName();
                    }
                    if (!(this.znC == null || t.ov(this.znC.getName()))) {
                        charSequence = charSequence + " " + this.znC.getName();
                    }
                    if (!(this.znD == null || t.ov(this.znD.getName()))) {
                        charSequence = charSequence + " " + this.znD.getName();
                    }
                    this.znE.setText(charSequence);
                    setEnabled(true);
                    setSelectable(true);
                    return;
                case 2:
                    this.znE.setVisibility(8);
                    this.ihV.setVisibility(0);
                    this.ihV.setText(R.l.eKE);
                    this.znF.setImageResource(R.k.dyK);
                    setEnabled(false);
                    setSelectable(false);
                    return;
                default:
                    return;
            }
        }
    }

    public final void cyf() {
        this.status = 2;
        cye();
    }
}
