package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;

public class VoipBigIconButton extends FrameLayout {
    private TextView kO;
    private ImageView lIo;
    private Drawable sqs = null;
    private Drawable sqt = null;
    private Drawable squ = null;
    private Drawable sqv = null;
    private OnTouchListener sqw = new OnTouchListener(this) {
        final /* synthetic */ VoipBigIconButton sqx;

        {
            this.sqx = r1;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.sqx.lIo.setBackgroundDrawable(this.sqx.sqt);
                    this.sqx.lIo.setImageDrawable(this.sqx.sqv);
                    this.sqx.kO.setTextColor(-855638017);
                    break;
                case 1:
                    this.sqx.lIo.setBackgroundDrawable(this.sqx.sqs);
                    this.sqx.lIo.setImageDrawable(this.sqx.squ);
                    this.sqx.kO.setTextColor(-1);
                    break;
            }
            return false;
        }
    };

    public VoipBigIconButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.i.dmz, this);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.n.faW, 0, 0);
        try {
            CharSequence string;
            this.sqs = obtainStyledAttributes.getDrawable(R.n.faX);
            this.sqt = obtainStyledAttributes.getDrawable(R.n.faY);
            this.squ = obtainStyledAttributes.getDrawable(R.n.faZ);
            this.sqv = obtainStyledAttributes.getDrawable(R.n.fba);
            int resourceId = obtainStyledAttributes.getResourceId(R.n.fbb, -1);
            int resourceId2 = obtainStyledAttributes.getResourceId(R.n.fbb, 0);
            if (resourceId2 != 0) {
                string = getContext().getString(resourceId2);
            } else {
                string = null;
            }
            obtainStyledAttributes.recycle();
            this.sqt = this.sqt == null ? this.sqs : this.sqt;
            this.sqv = this.sqv == null ? this.squ : this.sqv;
            this.lIo = (ImageView) findViewById(R.h.bMT);
            this.lIo.setBackgroundDrawable(this.sqs);
            this.lIo.setImageDrawable(this.squ);
            this.lIo.setOnTouchListener(this.sqw);
            this.lIo.setContentDescription(string);
            this.kO = (TextView) findViewById(R.h.bMW);
            if (resourceId != -1) {
                this.kO.setText(getContext().getString(resourceId));
            }
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    public void setEnabled(boolean z) {
        this.lIo.setEnabled(z);
        this.kO.setEnabled(z);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.lIo.setOnClickListener(onClickListener);
    }
}
