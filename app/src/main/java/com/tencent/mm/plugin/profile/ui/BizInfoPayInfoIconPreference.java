package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.List;

public class BizInfoPayInfoIconPreference extends Preference {
    private LayoutInflater DF;
    private LinearLayout phu;
    private List<String> phv;
    private int phw;

    public BizInfoPayInfoIconPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BizInfoPayInfoIconPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.phw = -1;
        this.DF = (LayoutInflater) context.getSystemService("layout_inflater");
        setLayoutResource(R.i.dnt);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        this.DF.inflate(R.i.deN, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        super.onBindView(view);
        this.phu = (LinearLayout) view.findViewById(R.h.summary);
        au();
    }

    public final void uJ(int i) {
        if (i != this.phw) {
            this.phw = i;
            au();
        }
    }

    public final void bo(List<String> list) {
        this.phv = list;
        au();
    }

    private void au() {
        if (this.phu != null) {
            this.phu.removeAllViews();
            if (this.phw >= 0) {
                int i = this.phw;
                for (int i2 = 0; i2 < 5; i2++) {
                    if (i <= 0) {
                        uK(R.k.dwh);
                    } else if (i <= 10) {
                        uK(R.k.dwf);
                        i -= 20;
                    } else {
                        uK(R.k.dwg);
                        i -= 20;
                    }
                }
            } else if (this.phv != null) {
                for (String str : this.phv) {
                    View cdnImageView = new CdnImageView(this.mContext);
                    cdnImageView.setUrl(str);
                    LayoutParams layoutParams = new LinearLayout.LayoutParams(a.fromDPToPix(this.mContext, 20), a.fromDPToPix(this.mContext, 20));
                    layoutParams.rightMargin = a.fromDPToPix(this.mContext, 6);
                    this.phu.addView(cdnImageView, layoutParams);
                }
            }
        }
    }

    private void uK(int i) {
        ImageView imageView = (ImageView) this.DF.inflate(R.i.deK, null);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(a.fromDPToPix(this.mContext, 20), a.fromDPToPix(this.mContext, 20));
        layoutParams.rightMargin = a.fromDPToPix(this.mContext, 6);
        imageView.setImageResource(i);
        this.phu.addView(imageView, layoutParams);
    }
}
