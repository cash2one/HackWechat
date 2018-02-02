package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ag;

public class ExdeviceRankListHeaderView extends RelativeLayout {
    private TextView lXm;
    OnClickListener lXn;
    private Animation lXo;
    private Animation lXp;
    private Runnable lXq;
    boolean lXr;
    private Context mContext;

    static /* synthetic */ void b(ExdeviceRankListHeaderView exdeviceRankListHeaderView) {
        ag.K(exdeviceRankListHeaderView.lXq);
        if (exdeviceRankListHeaderView.lXm.getVisibility() == 4) {
            exdeviceRankListHeaderView.lXo.reset();
            exdeviceRankListHeaderView.lXm.startAnimation(exdeviceRankListHeaderView.lXo);
            return;
        }
        exdeviceRankListHeaderView.lXp.reset();
        exdeviceRankListHeaderView.lXm.startAnimation(exdeviceRankListHeaderView.lXp);
    }

    public ExdeviceRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.lXr = true;
        cd(context);
    }

    public ExdeviceRankListHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public ExdeviceRankListHeaderView(Context context) {
        super(context);
        this.lXr = true;
        cd(context);
    }

    private void cd(Context context) {
        this.mContext = context;
        this.lXm = (TextView) LayoutInflater.from(this.mContext).inflate(R.i.dhe, this, true).findViewById(R.h.bSA);
        this.lXm.setVisibility(4);
        this.lXo = AnimationUtils.loadAnimation(this.mContext, R.a.abc_fade_in);
        this.lXp = AnimationUtils.loadAnimation(this.mContext, R.a.abc_fade_out);
        this.lXq = new Runnable(this) {
            final /* synthetic */ ExdeviceRankListHeaderView lXs;

            {
                this.lXs = r1;
            }

            public final void run() {
                this.lXs.lXm.startAnimation(this.lXs.lXp);
            }
        };
        this.lXo.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ ExdeviceRankListHeaderView lXs;

            {
                this.lXs = r1;
            }

            public final void onAnimationStart(Animation animation) {
                this.lXs.lXm.setVisibility(0);
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                this.lXs.lXp.reset();
                ag.h(this.lXs.lXq, 4000);
            }
        });
        this.lXp.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ ExdeviceRankListHeaderView lXs;

            {
                this.lXs = r1;
            }

            public final void onAnimationStart(Animation animation) {
                this.lXs.lXm.setVisibility(0);
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                this.lXs.lXm.setVisibility(4);
            }
        });
        this.lXo.setFillAfter(true);
        this.lXo.setFillEnabled(true);
        this.lXp.setFillAfter(true);
        this.lXp.setFillAfter(true);
        setOnClickListener(new 1(this));
    }
}
