package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.w.a.e;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;

public class IconMsgPreference extends Preference {
    private Context context;
    private Drawable drawable;
    private int height;
    private String qhm;
    private int qhn;
    private int qho;
    private int yij;
    private int yik;
    private int yil;
    private ImageView yim;
    private ViewGroup yin;
    private TextView yio;
    private String yip;

    public IconMsgPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconMsgPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qhm = "";
        this.qhn = -1;
        this.qho = 8;
        this.yij = 8;
        this.yik = 0;
        this.yil = 8;
        this.yim = null;
        this.yin = null;
        this.height = -1;
        this.yip = "";
        this.context = context;
        setLayoutResource(h.dnt);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(g.content);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, h.gXM, viewGroup2);
        onCreateView.setMinimumHeight(onCreateView.getResources().getDimensionPixelSize(e.bvR));
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(g.cpk);
        if (imageView != null) {
            if (this.drawable != null) {
                imageView.setImageDrawable(this.drawable);
                imageView.setVisibility(0);
            } else if (this.Kw != 0) {
                imageView.setImageResource(this.Kw);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(g.cwo);
        if (this.height != -1) {
            linearLayout.setMinimumHeight(this.height);
        }
        TextView textView = (TextView) view.findViewById(g.cQE);
        if (textView != null) {
            textView.setVisibility(this.qho);
            textView.setText(this.qhm);
            if (this.qhn != -1) {
                textView.setBackgroundDrawable(a.b(this.context, this.qhn));
            }
        }
        this.yim = (ImageView) view.findViewById(g.gWw);
        this.yim.setVisibility(this.yij);
        this.yin = (ViewGroup) view.findViewById(g.gWh);
        this.yin.setVisibility(this.yik);
        this.yio = (TextView) view.findViewById(16908310);
        textView = (TextView) view.findViewById(g.gWx);
        if (bh.ov(this.yip)) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(this.yip);
    }
}
