package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bh;

public class IPCallFuncButton extends LinearLayout {
    private boolean kKd = false;
    private boolean mAK = true;
    private Drawable nKA;
    private Drawable nKB;
    private boolean nKC;
    a nKD;
    private OnTouchListener nKE = new 1(this);
    private ImageView nKx;
    private TextView nKy;
    private Drawable nKz;
    private String text;

    public interface a {
        void gf(boolean z);
    }

    public IPCallFuncButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(R.i.dmc, this);
        this.nKx = (ImageView) findViewById(R.h.button);
        this.nKy = (TextView) findViewById(R.h.text);
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.n.fah, 0, 0);
        this.nKz = obtainStyledAttributes.getDrawable(R.n.fai);
        this.nKA = obtainStyledAttributes.getDrawable(R.n.faj);
        this.nKC = obtainStyledAttributes.getBoolean(R.n.fam, false);
        this.nKB = obtainStyledAttributes.getDrawable(R.n.fak);
        int resourceId = obtainStyledAttributes.getResourceId(R.n.fal, 0);
        if (resourceId != 0) {
            this.text = getContext().getString(resourceId);
        }
        obtainStyledAttributes.recycle();
        if (bh.ov(this.text)) {
            this.nKy.setVisibility(8);
        } else {
            this.nKy.setText(this.text);
        }
        if (this.nKz != null) {
            this.nKx.setImageDrawable(this.nKz);
        }
        this.nKx.setClickable(true);
        this.nKx.setOnTouchListener(this.nKE);
    }

    public final boolean isChecked() {
        if (this.nKC) {
            return this.kKd;
        }
        return false;
    }

    public final void ge(boolean z) {
        if (z != this.mAK) {
            this.mAK = z;
            if (this.mAK || this.nKB == null) {
                this.nKx.setImageDrawable(this.nKz);
            } else {
                this.nKx.setImageDrawable(this.nKB);
            }
            this.kKd = false;
        }
    }

    public final void setChecked(boolean z) {
        if (z != this.kKd && this.nKC) {
            this.kKd = z;
            if (this.kKd) {
                this.nKx.setImageDrawable(this.nKA);
            } else {
                this.nKx.setImageDrawable(this.nKz);
            }
        }
    }
}
