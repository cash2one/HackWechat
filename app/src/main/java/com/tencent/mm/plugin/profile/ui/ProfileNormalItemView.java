package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.ProfileItemView;
import com.tencent.mm.sdk.platformtools.bh;

public class ProfileNormalItemView extends ProfileItemView {
    private TextView jJn;
    private String mTitle;
    TextView pfl;
    CharSequence pkW;
    OnClickListener pkX;

    public ProfileNormalItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.n.faQ);
        this.mTitle = obtainStyledAttributes.getString(R.n.faR);
        obtainStyledAttributes.recycle();
    }

    public ProfileNormalItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final int bjK() {
        return R.i.dpI;
    }

    public final void init() {
        this.jJn = (TextView) findViewById(R.h.bYn);
        this.pfl = (TextView) findViewById(R.h.bYm);
    }

    public final ProfileNormalItemView uS(int i) {
        this.mTitle = getContext().getString(i);
        return this;
    }

    public final ProfileNormalItemView uT(int i) {
        this.pkW = getContext().getString(i);
        return this;
    }

    public final ProfileNormalItemView uU(int i) {
        this.pfl.setTextColor(i);
        return this;
    }

    public final boolean bjL() {
        this.jJn.setText(this.mTitle);
        if (bh.M(this.pkW)) {
            setVisibility(8);
            return false;
        }
        setVisibility(0);
        this.pfl.setText(this.pkW);
        setOnClickListener(this.pkX);
        return true;
    }
}
