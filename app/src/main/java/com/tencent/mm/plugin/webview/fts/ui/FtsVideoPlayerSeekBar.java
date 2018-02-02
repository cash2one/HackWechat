package com.tencent.mm.plugin.webview.fts.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.ab.a$b;
import com.tencent.mm.plugin.ab.a.a;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.sdk.platformtools.x;

public class FtsVideoPlayerSeekBar extends AdVideoPlayerLoadingBar implements g {
    protected boolean fvG = false;
    private float iQK;
    private int tqE = -1;
    private int tqF = -1;
    private int tqG = -1;

    public FtsVideoPlayerSeekBar(Context context) {
        super(context);
    }

    public FtsVideoPlayerSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FtsVideoPlayerSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init() {
        this.contentView = View.inflate(getContext(), getLayoutId(), this);
        this.qul = (ImageView) this.contentView.findViewById(a.pdA);
        this.qum = (ImageView) this.contentView.findViewById(a.pdz);
        this.qun = (ImageView) this.contentView.findViewById(a.pdB);
        this.quo = (ImageView) this.contentView.findViewById(a.cCD);
        this.qup = (TextView) this.contentView.findViewById(a.pdx);
        this.quq = (TextView) this.contentView.findViewById(a.pdy);
        this.qun.setOnTouchListener(new 1(this));
        this.qun.addOnLayoutChangeListener(new 2(this));
        this.qum.addOnLayoutChangeListener(new 3(this));
    }

    protected int bta() {
        if (this.tqE == -1) {
            this.tqE = this.qun.getWidth();
        }
        return this.tqE;
    }

    public final int bsY() {
        return this.qum.getWidth();
    }

    public int getLayoutId() {
        return a$b.cVi;
    }

    public final void seek(int i) {
        x.d("MicroMsg.FtsVideoPlayerSeekBar", "seek position : " + i);
        if (i < 0) {
            i = 0;
        }
        if (i >= this.qur) {
            i = this.qur;
        }
        if (this.mPosition != i) {
            this.mPosition = i;
            ahe();
        }
    }

    public final void wl(int i) {
        this.qur = i;
        this.mPosition = 0;
        this.quq.setText(kG(this.qur / 60) + ":" + kG(this.qur % 60));
        ahe();
    }

    public final void ahe() {
        if (this.qur != 0 && !this.kog && this.qun != null && this.qum.getWidth() != 0) {
            if (this.mPosition == this.qur) {
                x.i("MicroMsg.FtsVideoPlayerSeekBar", "test");
            }
            this.qup.setText(kG(this.mPosition / 60) + ":" + kG(this.mPosition % 60));
            int i = this.mPosition;
            i = i <= 0 ? 0 : i >= this.qur ? this.qum.getWidth() : (int) (((((double) i) * 1.0d) / ((double) this.qur)) * ((double) this.qum.getWidth()));
            Af(i);
        }
    }

    public void Af(int i) {
        int width;
        if (i > this.qum.getWidth()) {
            i = this.qum.getWidth();
        } else if (i < 0) {
            i = 0;
        }
        LayoutParams layoutParams = (LayoutParams) this.qun.getLayoutParams();
        if (i > this.qum.getWidth()) {
            width = this.qum.getWidth();
        } else {
            width = i;
        }
        layoutParams.leftMargin = (((LayoutParams) this.qum.getLayoutParams()).leftMargin + width) - (bta() >>> 1);
        this.qun.setLayoutParams(layoutParams);
        layoutParams = (LayoutParams) this.qul.getLayoutParams();
        layoutParams.width = i;
        this.qul.setLayoutParams(layoutParams);
        this.qun.requestLayout();
        this.qul.requestLayout();
    }

    public void db(boolean z) {
        this.fvG = z;
        super.db(z);
    }

    public void wZ(int i) {
        seek(i);
    }

    public final void kj(boolean z) {
        db(z);
    }
}
