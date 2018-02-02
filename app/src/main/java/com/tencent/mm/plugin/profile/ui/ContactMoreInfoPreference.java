package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactMoreInfoPreference extends Preference {
    private TextView kTq;
    private ImageView phR;
    private ImageView phS;
    private ImageView phT;
    private ImageView phU;
    private ImageView phV;
    private ImageView phW;
    private int phX = 8;
    private int phY = 8;
    private int phZ = 8;
    private int pia = 8;
    private int pib = 8;
    private int pic = 8;

    public ContactMoreInfoPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ContactMoreInfoPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.dnt);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.dnF, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        this.phR = (ImageView) view.findViewById(R.h.cps);
        this.phS = (ImageView) view.findViewById(R.h.cpw);
        this.phT = (ImageView) view.findViewById(R.h.cpo);
        this.phU = (ImageView) view.findViewById(R.h.coX);
        this.phV = (ImageView) view.findViewById(R.h.cpg);
        this.phW = (ImageView) view.findViewById(R.h.cpB);
        this.kTq = (TextView) view.findViewById(R.h.title);
        au();
        super.onBindView(view);
    }

    public final void uL(int i) {
        this.phY = i;
        au();
    }

    public final void uM(int i) {
        this.phZ = i;
        au();
    }

    public final void uN(int i) {
        this.pib = i;
        au();
    }

    public final void uO(int i) {
        this.pic = i;
        au();
    }

    private void au() {
        if (this.phR != null) {
            this.phR.setVisibility(this.phX);
        }
        if (this.phS != null) {
            this.phS.setVisibility(this.phY);
        }
        if (this.phT != null) {
            this.phT.setVisibility(this.phZ);
        }
        if (this.phU != null) {
            this.phU.setVisibility(this.pia);
        }
        if (this.phV != null) {
            this.phV.setVisibility(this.pib);
        }
        if (this.kTq != null) {
            LayoutParams layoutParams = this.kTq.getLayoutParams();
            layoutParams.width = a.aa(this.mContext, R.f.bvb);
            this.kTq.setLayoutParams(layoutParams);
        }
        if (this.phW != null) {
            this.phW.setVisibility(this.pic);
        }
    }
}
