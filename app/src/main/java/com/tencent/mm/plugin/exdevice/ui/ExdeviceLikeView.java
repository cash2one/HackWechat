package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;

public class ExdeviceLikeView extends RelativeLayout {
    int lUF;
    a lUG;
    private int lUH;
    TextView lUI;
    private ImageView lUJ;
    private ProgressBar lUK;
    private Context mContext;

    static /* synthetic */ void c(ExdeviceLikeView exdeviceLikeView) {
        Animation loadAnimation = AnimationUtils.loadAnimation(exdeviceLikeView.mContext, R.a.bqf);
        loadAnimation.setFillAfter(false);
        exdeviceLikeView.lUJ.startAnimation(loadAnimation);
    }

    static /* synthetic */ int pl(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 0;
            case 2:
                return 2;
            default:
                x.w("MicroMsg.ExdeviceLikeView", "hy: state error");
                return 2;
        }
    }

    public ExdeviceLikeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.lUH = 2;
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(R.i.dgO, this, true);
        this.lUI = (TextView) inflate.findViewById(R.h.cfb);
        this.lUJ = (ImageView) inflate.findViewById(R.h.cfa);
        this.lUK = (ProgressBar) inflate.findViewById(R.h.cfe);
        setOnClickListener(new 1(this));
    }

    public ExdeviceLikeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final void pk(int i) {
        this.lUH = i;
        if (this.lUH == 1) {
            this.lUK.setVisibility(8);
            this.lUI.setVisibility(0);
            this.lUJ.setVisibility(0);
            this.lUJ.setImageResource(R.k.dyq);
        } else if (this.lUH == 0) {
            this.lUK.setVisibility(8);
            this.lUI.setVisibility(0);
            this.lUJ.setVisibility(0);
            this.lUJ.setImageResource(R.k.dyr);
        } else if (this.lUH == 2) {
            this.lUI.setVisibility(8);
            this.lUK.setVisibility(0);
            this.lUJ.setVisibility(8);
        } else {
            x.w("MicroMsg.ExdeviceLikeView", "hy: error state");
        }
    }
}
