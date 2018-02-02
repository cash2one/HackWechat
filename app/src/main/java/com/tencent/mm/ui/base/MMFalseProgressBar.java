package com.tencent.mm.ui.base;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;

public class MMFalseProgressBar extends ProgressBar {
    private af mHandler;
    private boolean xZZ;
    private float yaa;
    private float yab;
    private float yac;
    private float yad;
    private float yae;
    public boolean yaf;

    static /* synthetic */ void a(MMFalseProgressBar mMFalseProgressBar) {
        mMFalseProgressBar.setVisibility(0);
        mMFalseProgressBar.setAlpha(1.0f);
    }

    static /* synthetic */ void b(MMFalseProgressBar mMFalseProgressBar) {
        if (mMFalseProgressBar.yaa < 600.0f) {
            mMFalseProgressBar.yaa += mMFalseProgressBar.yab;
        } else if (mMFalseProgressBar.yaa >= 600.0f && mMFalseProgressBar.yaa < 800.0f) {
            mMFalseProgressBar.yaa += mMFalseProgressBar.yac;
        } else if (mMFalseProgressBar.yaa >= 800.0f && mMFalseProgressBar.yaa < 920.0f) {
            mMFalseProgressBar.yaa += mMFalseProgressBar.yad;
        }
        if (mMFalseProgressBar.mHandler != null) {
            if (mMFalseProgressBar.yaa < 920.0f) {
                mMFalseProgressBar.mHandler.sendEmptyMessageDelayed(1001, 10);
            } else {
                mMFalseProgressBar.mHandler.removeMessages(1001);
            }
        }
        mMFalseProgressBar.setProgress((int) mMFalseProgressBar.yaa);
    }

    static /* synthetic */ void c(MMFalseProgressBar mMFalseProgressBar) {
        float f = 950.0f;
        if (mMFalseProgressBar.xZZ) {
            Float valueOf;
            if (mMFalseProgressBar.yaa < 950.0f) {
                mMFalseProgressBar.yaa += mMFalseProgressBar.yae;
                if (mMFalseProgressBar.yaa <= 950.0f) {
                    f = mMFalseProgressBar.yaa;
                }
                mMFalseProgressBar.yaa = f;
                valueOf = Float.valueOf(1.0f);
            } else {
                mMFalseProgressBar.yaa += 1.0f;
                valueOf = Float.valueOf(((1000.0f - mMFalseProgressBar.yaa) * 0.01f) + 0.3f);
            }
            if (mMFalseProgressBar.mHandler != null) {
                if (mMFalseProgressBar.yaa < 1000.0f) {
                    mMFalseProgressBar.mHandler.sendEmptyMessageDelayed(1002, 10);
                } else {
                    mMFalseProgressBar.yaa = 1000.0f;
                    mMFalseProgressBar.mHandler.removeMessages(1002);
                    mMFalseProgressBar.mHandler.sendEmptyMessageDelayed(1003, 10);
                }
            }
            mMFalseProgressBar.setAlpha(valueOf.floatValue());
            mMFalseProgressBar.setProgress((int) mMFalseProgressBar.yaa);
        }
    }

    static /* synthetic */ void d(MMFalseProgressBar mMFalseProgressBar) {
        mMFalseProgressBar.yaa = 0.0f;
        mMFalseProgressBar.xZZ = false;
        mMFalseProgressBar.postInvalidateDelayed(200);
        mMFalseProgressBar.setVisibility(8);
    }

    public MMFalseProgressBar(Context context) {
        this(context, null);
        coX();
    }

    public MMFalseProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMFalseProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.xZZ = false;
        this.yaa = 0.0f;
        this.yaf = true;
        this.mHandler = new 1(this, Looper.getMainLooper());
        setMax(1000);
        coX();
    }

    public final void start() {
        x.d("MicroMsg.MMFalseProgressBar", "[cpan] start");
        if (this.yaf && !this.xZZ) {
            this.xZZ = true;
            coX();
            if (this.mHandler != null) {
                this.mHandler.sendEmptyMessage(1000);
                this.mHandler.sendEmptyMessage(1001);
            }
        }
    }

    public final void finish() {
        x.d("MicroMsg.MMFalseProgressBar", "[cpan] finish");
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(1002);
        }
    }

    private void coX() {
        if (an.eS(ac.getContext())) {
            this.yab = 4.0f;
            this.yac = 1.0f;
            this.yad = 0.3f;
            this.yae = 50.0f;
            return;
        }
        this.yab = 2.0f;
        this.yac = 0.5f;
        this.yad = 0.15f;
        this.yae = 50.0f;
    }
}
