package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.a;

public class TalkRoomPopupNav extends LinearLayout {
    public View myK;
    public LinearLayout xLd;
    private Animation yhA;
    public AlphaAnimation yhB;
    public AlphaAnimation yhC;
    public a yhq;
    public LinearLayout yhr;
    private LinearLayout yhs;
    private ImageView yht;
    public ImageView yhu;
    public ScaleAnimation yhv;
    public Animation yhw;
    public int yhx = 0;
    public int yhy = 0;
    private ScaleAnimation yhz;

    static /* synthetic */ void b(TalkRoomPopupNav talkRoomPopupNav) {
        if (talkRoomPopupNav.yhz == null) {
            talkRoomPopupNav.yhz = new ScaleAnimation(1.0f, 1.0f, (((float) talkRoomPopupNav.yhy) * 1.0f) / ((float) talkRoomPopupNav.yhx), 1.0f);
            talkRoomPopupNav.yhz.setDuration(300);
            talkRoomPopupNav.yhz.setAnimationListener(new 6(talkRoomPopupNav));
        }
        if (talkRoomPopupNav.yhA == null) {
            talkRoomPopupNav.yhA = AnimationUtils.loadAnimation(talkRoomPopupNav.getContext(), R.a.bqa);
            talkRoomPopupNav.yhA.setFillAfter(true);
            talkRoomPopupNav.yhA.setAnimationListener(new 7(talkRoomPopupNav));
        }
        LayoutParams layoutParams = talkRoomPopupNav.myK.getLayoutParams();
        layoutParams.height = talkRoomPopupNav.yhx;
        talkRoomPopupNav.myK.setLayoutParams(layoutParams);
        talkRoomPopupNav.myK.startAnimation(talkRoomPopupNav.yhz);
        talkRoomPopupNav.yhr.startAnimation(talkRoomPopupNav.yhA);
        talkRoomPopupNav.xLd.startAnimation(AnimationUtils.loadAnimation(talkRoomPopupNav.getContext(), R.a.bpZ));
        talkRoomPopupNav.xLd.setVisibility(0);
    }

    @TargetApi(11)
    public TalkRoomPopupNav(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    public TalkRoomPopupNav(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public final void YM(String str) {
        ((TextView) findViewById(R.h.cTo)).setText(str);
    }

    public final void EU(int i) {
        if (this.myK != null) {
            this.myK.setBackgroundResource(i);
        }
    }

    public final void EV(int i) {
        if (this.yht != null) {
            this.yht.setImageResource(i);
        }
    }

    public final void EW(int i) {
        if (i < 0) {
            if (this.yhu != null) {
                this.yhu.setVisibility(8);
            }
        } else if (this.yhu != null) {
            this.yhu.setImageResource(i);
            this.yhu.setVisibility(0);
        }
    }

    private void initView() {
        inflate(getContext(), R.i.cQh, this);
        this.xLd = (LinearLayout) findViewById(R.h.cyI);
        this.yhr = (LinearLayout) findViewById(R.h.ccb);
        this.yhs = (LinearLayout) findViewById(R.h.cbW);
        this.myK = findViewById(R.h.cyE);
        this.yht = (ImageView) findViewById(R.h.cQi);
        this.yhu = (ImageView) findViewById(R.h.cQj);
        this.yhu.setVisibility(8);
        this.xLd.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ TalkRoomPopupNav yhD;

            {
                this.yhD = r1;
            }

            public final void onClick(View view) {
                if (this.yhD.yhq != null) {
                    this.yhD.yhq.cqj();
                }
            }
        });
        ((Button) findViewById(R.h.bPd)).setOnClickListener(new 2(this));
        ((Button) findViewById(R.h.bPe)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ TalkRoomPopupNav yhD;

            {
                this.yhD = r1;
            }

            public final void onClick(View view) {
                TalkRoomPopupNav.b(this.yhD);
                if (this.yhD.yhq != null) {
                    this.yhD.yhq.cqk();
                }
            }
        });
        this.yhx = this.myK.getLayoutParams().height;
        this.yhy = this.yhr.getLayoutParams().height;
    }

    public final void stop() {
        if (this.yhB != null && this.yhC != null) {
            a.c(this.yhu, this.yhB);
            a.c(this.yhu, this.yhC);
            this.yhu.clearAnimation();
            this.yhB = null;
            this.yhC = null;
        }
    }
}
