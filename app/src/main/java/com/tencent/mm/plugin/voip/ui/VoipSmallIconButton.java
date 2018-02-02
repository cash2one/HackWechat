package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;

public class VoipSmallIconButton extends FrameLayout {
    private TextView kO;
    private ImageView lIo;
    private Drawable squ = null;
    private Drawable sqv = null;
    private OnTouchListener sqw = new 1(this);

    public void setOnClickListener(OnClickListener onClickListener) {
        this.lIo.setOnClickListener(onClickListener);
    }

    public VoipSmallIconButton(Context context, AttributeSet attributeSet) {
        CharSequence charSequence = 0;
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.i.dmA, this);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.n.faW, 0, 0);
        try {
            this.squ = obtainStyledAttributes.getDrawable(R.n.faZ);
            this.sqv = obtainStyledAttributes.getDrawable(R.n.fba);
            charSequence = obtainStyledAttributes.getString(R.n.fbb);
            int resourceId = obtainStyledAttributes.getResourceId(R.n.fbb, -1);
            this.lIo = (ImageView) findViewById(R.h.cOJ);
            this.lIo.setImageDrawable(this.squ);
            this.lIo.setOnTouchListener(this.sqw);
            this.lIo.setContentDescription(charSequence);
            this.kO = (TextView) findViewById(R.h.cOL);
            if (resourceId != -1) {
                this.kO.setText(getContext().getString(resourceId));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void setEnabled(boolean z) {
        this.lIo.setEnabled(z);
        this.kO.setEnabled(z);
    }
}
