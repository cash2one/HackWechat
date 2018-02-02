package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.base.preference.Preference;

public final class HeadImgNewPreference extends Preference {
    private int height;
    public ImageView jMv;
    public OnClickListener tZZ;
    private View voQ;
    private TextView vtn;
    public String vto;
    public boolean vtp;
    private boolean vtq;

    public HeadImgNewPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HeadImgNewPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.height = -1;
        this.vtp = false;
        this.vtq = false;
        setLayoutResource(R.i.dnt);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        if (this.vtq) {
            View.inflate(this.mContext, R.i.dou, viewGroup2);
        } else {
            View.inflate(this.mContext, R.i.dnB, viewGroup2);
        }
        this.jMv = (ImageView) onCreateView.findViewById(R.h.cph);
        this.vtn = (TextView) onCreateView.findViewById(R.h.cAu);
        this.voQ = onCreateView.findViewById(R.h.cuX);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        if (this.jMv == null) {
            this.jMv = (ImageView) view.findViewById(R.h.cph);
        }
        if (this.vtn == null) {
            this.vtn = (TextView) view.findViewById(R.h.cAu);
        }
        if (this.voQ == null) {
            this.voQ = view.findViewById(R.h.cuX);
        }
        if (this.tZZ != null) {
            this.voQ.setOnClickListener(this.tZZ);
        }
        if (this.vto != null) {
            b.a(this.jMv, this.vto);
            this.vto = null;
        }
        if (this.vtp) {
            this.vtn.setVisibility(8);
            this.voQ.setVisibility(0);
        } else {
            this.voQ.setVisibility(8);
            this.vtn.setVisibility(0);
        }
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.h.cwo);
        if (this.height != -1) {
            relativeLayout.setMinimumHeight(this.height);
        }
    }
}
