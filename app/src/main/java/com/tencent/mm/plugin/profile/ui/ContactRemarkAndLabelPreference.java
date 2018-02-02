package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactRemarkAndLabelPreference extends Preference {
    private TextView jJn;
    private Context mContext;
    private String mkE;
    private TextView pit;
    private TextView piu;
    private boolean piv = false;
    private String piw;
    private String pix;

    public ContactRemarkAndLabelPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public ContactRemarkAndLabelPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        setLayoutResource(R.i.dnt);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.dnK, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        int i;
        this.jJn = (TextView) view.findViewById(R.h.title);
        this.pit = (TextView) view.findViewById(R.h.cHA);
        this.piu = (TextView) view.findViewById(R.h.label);
        if (!(this.jJn == null || bh.ov(this.mkE))) {
            this.jJn.setVisibility(0);
            this.jJn.setText(this.mkE);
            LayoutParams layoutParams = (LayoutParams) this.jJn.getLayoutParams();
            layoutParams.width = a.aa(this.mContext, R.f.bvb);
            this.jJn.setLayoutParams(layoutParams);
        }
        if (this.pit != null) {
            if (this.piv) {
                this.pit.setVisibility(0);
                this.pit.setCompoundDrawablesWithIntrinsicBounds(R.k.dxm, 0, 0, 0);
                i = 1;
            } else {
                this.pit.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                i = 0;
            }
            if (!bh.ov(this.piw)) {
                this.pit.setVisibility(0);
                this.pit.setText(i.b(this.mContext, bh.ou(this.piw), this.pit.getTextSize()));
                i = 1;
            }
        } else {
            i = 0;
        }
        if (!(this.piu == null || bh.ov(this.pix))) {
            i |= 2;
            this.piu.setVisibility(0);
            this.piu.setText(this.pix);
        }
        int i2 = i;
        if (i2 == 1) {
            ((LayoutParams) this.pit.getLayoutParams()).addRule(15);
        }
        if (i2 == 2) {
            layoutParams = (LayoutParams) this.piu.getLayoutParams();
            layoutParams.addRule(3, 0);
            layoutParams.addRule(15);
        }
        super.onBindView(view);
    }
}
