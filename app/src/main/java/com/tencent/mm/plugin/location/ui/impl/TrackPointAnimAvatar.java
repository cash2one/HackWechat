package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mm.R;

public class TrackPointAnimAvatar extends RelativeLayout {
    private ImageView hvY;
    private Context mContext;
    private LinearLayout nYt;
    private Animation nYu;
    private Animation nYv;

    public TrackPointAnimAvatar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    public TrackPointAnimAvatar(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        View inflate = View.inflate(this.mContext, R.i.dti, this);
        this.nYt = (LinearLayout) inflate.findViewById(R.h.bKj);
        this.hvY = (ImageView) inflate.findViewById(R.h.bKi);
        this.nYu = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -0.5f);
        this.nYu.setDuration(500);
        this.nYu.setFillAfter(true);
        this.nYv = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -0.5f, 1, 0.0f);
        this.nYv.setDuration(500);
        this.nYv.setFillAfter(true);
        this.nYu.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ TrackPointAnimAvatar nYw;

            {
                this.nYw = r1;
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                this.nYw.bringToFront();
                this.nYw.nYt.startAnimation(this.nYw.nYv);
            }
        });
        this.nYv.setAnimationListener(new 2(this));
    }
}
