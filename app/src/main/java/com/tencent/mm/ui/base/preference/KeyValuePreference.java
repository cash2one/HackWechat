package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.w.a.e;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import java.util.LinkedList;
import java.util.List;

public class KeyValuePreference extends Preference {
    private TextView pjN;
    public String xID;
    private Drawable yiS;
    public boolean yiT;
    private boolean yiU;
    private boolean yiV;
    public boolean yiW;
    private int yiX;
    public int yiY;
    public int yiZ;
    private ImageView yja;
    public Drawable yjb;
    public List<View> yjc;

    public KeyValuePreference(Context context) {
        this(context, null);
    }

    public KeyValuePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KeyValuePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.yiS = null;
        this.yiT = true;
        this.yiU = false;
        this.xID = null;
        this.yiV = false;
        this.yiW = false;
        this.yiX = 17;
        this.yiY = 17;
        this.yiZ = 0;
        this.yja = null;
        this.yjb = null;
        this.yjc = new LinkedList();
        setLayoutResource(h.dnt);
    }

    public View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(g.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(h.gXI, viewGroup2);
        return onCreateView;
    }

    public void onBindView(View view) {
        super.onBindView(view);
        this.pjN = (TextView) view.findViewById(16908304);
        this.pjN.setSingleLine(this.yiT);
        if (this.yiU) {
            setWidgetLayoutResource(h.dod);
        }
        if (this.yiW) {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(g.bYF);
            LayoutParams layoutParams = (LayoutParams) linearLayout.getLayoutParams();
            layoutParams.width = -1;
            linearLayout.setLayoutParams(layoutParams);
            linearLayout = (LinearLayout) view.findViewById(g.gWq);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.getChildAt(0).setLayoutParams(layoutParams);
            this.pjN.setGravity(this.yiY);
        }
        TextView textView = (TextView) view.findViewById(16908310);
        if (!bh.ov(this.xID)) {
            textView.setText(this.xID);
        }
        if (textView != null) {
            ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
            layoutParams2.width = a.aa(this.mContext, e.bvb);
            textView.setLayoutParams(layoutParams2);
        }
        if (this.yiS != null) {
            ((ImageView) view.findViewById(g.gVB)).setImageDrawable(this.yiS);
        }
        this.yja = (ImageView) view.findViewById(g.cpk);
        if (this.yjb != null) {
            this.yja.setVisibility(this.yiZ);
            this.yja.setImageDrawable(this.yjb);
        } else {
            this.yja.setVisibility(8);
        }
        if (this.yiV) {
            linearLayout = (LinearLayout) view.findViewById(g.bYF);
            if (linearLayout != null) {
                linearLayout.setGravity(this.yiX);
            }
        }
        if (this.yjc.size() > 0) {
            linearLayout = (LinearLayout) view.findViewById(g.gWq);
            linearLayout.removeAllViews();
            for (View view2 : this.yjc) {
                ViewGroup viewGroup = (ViewGroup) view2.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(view2);
                }
                linearLayout.addView(view2);
            }
        }
    }

    public final void mx(boolean z) {
        this.yiU = z;
        if (this.yiU) {
            setWidgetLayoutResource(h.dod);
        }
    }

    public final void cqo() {
        this.yiV = true;
        this.yiX = 49;
    }
}
