package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;

public class IconSummaryPreference extends Preference {
    private Context context;
    private Drawable drawable;
    private int height;
    private ImageView olD;
    private String qhm;
    private int qhn;
    public int qho;
    LayoutParams yiB;
    public int yiJ;
    public TextView yiK;
    private int yiL;
    private int yik;
    private int yil;
    private ViewGroup yin;
    private Bitmap yiv;
    private int yiw;
    private int yix;
    private View yiz;

    public IconSummaryPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IconSummaryPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qhm = "";
        this.qhn = -1;
        this.qho = 8;
        this.yiv = null;
        this.yiw = -1;
        this.yix = 8;
        this.yik = 0;
        this.yil = 8;
        this.yiJ = 8;
        this.olD = null;
        this.yin = null;
        this.yiz = null;
        this.yiK = null;
        this.yiL = -1;
        this.height = -1;
        this.context = context;
        setLayoutResource(h.dnt);
    }

    protected View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(g.content);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, h.gXH, viewGroup2);
        return onCreateView;
    }

    public final void dh(String str, int i) {
        this.qhm = str;
        this.qhn = i;
    }

    public final void setSummary(CharSequence charSequence) {
        super.setSummary(charSequence);
        if (this.yiK != null && getSummary() != null && getSummary().length() > 0) {
            this.yiK.setText(getSummary());
        }
    }

    public final void setSummary(int i) {
        super.setSummary(i);
        if (this.yiK != null && getSummary() != null && getSummary().length() > 0) {
            this.yiK.setText(getSummary());
        }
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(g.cpk);
        if (imageView != null) {
            imageView.setVisibility(8);
            if (this.drawable != null) {
                imageView.setImageDrawable(this.drawable);
                imageView.setVisibility(0);
            } else if (this.jY != null) {
                imageView.setImageDrawable(this.jY);
                imageView.setVisibility(0);
            } else if (this.Kw != 0) {
                imageView.setImageResource(this.Kw);
                imageView.setVisibility(0);
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
        if (this.olD == null) {
            this.olD = (ImageView) view.findViewById(g.gVC);
        }
        if (this.yin == null) {
            this.yin = (ViewGroup) view.findViewById(g.gWh);
        }
        if (this.yiz == null) {
            this.yiz = view.findViewById(g.cIe);
        }
        this.yiz.setVisibility(this.yil);
        if (this.yiv != null) {
            this.olD.setImageBitmap(this.yiv);
        } else if (this.yiw != -1) {
            this.olD.setImageResource(this.yiw);
        }
        this.olD.setVisibility(this.yix);
        this.yin.setVisibility(this.yik);
        if (this.yiB != null) {
            this.olD.setLayoutParams(this.yiB);
        }
        this.yiK = (TextView) view.findViewById(g.gWi);
        if (!(this.yiK == null || getSummary() == null || getSummary().length() <= 0)) {
            this.yiK.setText(getSummary());
            this.yiK.setVisibility(this.yiJ);
        }
        if (this.yiK != null && this.yiL != -1) {
            this.yiK.setCompoundDrawablesWithIntrinsicBounds(this.yiL, 0, 0, 0);
            this.yiK.setCompoundDrawablePadding(b.b(this.mContext, 2.0f));
            this.yiK.setVisibility(this.yiJ);
        }
    }
}
