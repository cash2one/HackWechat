package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import com.tencent.mm.w.a.m;

public final class PluginTextPreference extends Preference {
    private TextView lbS;
    private ImageView pjO;
    private String text;
    private int textColor;
    public int visibility;
    public int yjA;

    public PluginTextPreference(Context context) {
        this(context, null);
    }

    public PluginTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PluginTextPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pjO = null;
        this.lbS = null;
        setLayoutResource(h.gXJ);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.faO);
        this.yjA = obtainStyledAttributes.getResourceId(m.gZm, 0);
        this.text = obtainStyledAttributes.getString(m.gZn);
        this.textColor = obtainStyledAttributes.getColor(m.gZo, -7039852);
        obtainStyledAttributes.recycle();
    }

    public final void Fg(int i) {
        this.text = this.mContext.getString(i);
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.pjO = (ImageView) view.findViewById(g.cpk);
        this.pjO.setImageResource(this.yjA);
        this.pjO.setVisibility(this.visibility);
        this.lbS = (TextView) view.findViewById(g.cQD);
        this.lbS.setText(this.text);
        this.lbS.setTextColor(this.textColor);
    }
}
