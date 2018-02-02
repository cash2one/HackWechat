package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.ab.a.a;
import com.tencent.mm.plugin.ab.a.b;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.x;

public class VideoPlayerSeekBar extends AdVideoPlayerLoadingBar implements g {
    public boolean fvG = false;
    private int tqE = -1;
    private int tqF = -1;
    private int tqG = -1;
    private PInt vyc = new PInt();

    static /* synthetic */ int a(VideoPlayerSeekBar videoPlayerSeekBar, int i, PInt pInt) {
        int ccG = ((LayoutParams) videoPlayerSeekBar.qum.getLayoutParams()).leftMargin - videoPlayerSeekBar.ccG();
        pInt.value = (int) (((((double) (i - ccG)) * 1.0d) / ((double) videoPlayerSeekBar.bsY())) * ((double) videoPlayerSeekBar.qur));
        if (pInt.value <= 0) {
            pInt.value = 0;
            return i - ccG > ccG ? i - ccG : ccG;
        } else if (pInt.value < videoPlayerSeekBar.qur) {
            return i - ccG;
        } else {
            pInt.value = videoPlayerSeekBar.qur;
            return videoPlayerSeekBar.bsY() - (((videoPlayerSeekBar.bta() - videoPlayerSeekBar.ccG()) - videoPlayerSeekBar.ccH()) / 2);
        }
    }

    public VideoPlayerSeekBar(Context context) {
        super(context);
    }

    public VideoPlayerSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VideoPlayerSeekBar(Context context, AttributeSet attributeSet, int i) {
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
    }

    protected final int bta() {
        if (this.tqE == -1) {
            this.tqE = this.qun.getWidth();
        }
        return this.tqE;
    }

    private int ccG() {
        if (this.tqF == -1) {
            this.tqF = this.qun.getPaddingLeft();
        }
        return this.tqF;
    }

    private int ccH() {
        if (this.tqG == -1) {
            this.tqG = this.qun.getPaddingRight();
        }
        return this.tqG;
    }

    public final int eC(int i, int i2) {
        if (i <= 0) {
            this.qum.getLayoutParams();
            return 0;
        } else if (i >= this.qur) {
            return i2 - (((bta() - ccG()) - ccH()) / 2);
        } else {
            return (int) (((((double) i) * 1.0d) / ((double) this.qur)) * ((double) i2));
        }
    }

    public int getLayoutId() {
        return b.cVi;
    }

    public final void seek(int i) {
        x.d("MicroMsg.VideoPlayerSeekBar", "seek position : " + i);
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

    public void ahe() {
        if (this.qur != 0 && !this.kog && this.qun != null && bsY() != 0) {
            this.qup.setText(kG(this.mPosition / 60) + ":" + kG(this.mPosition % 60));
            LayoutParams layoutParams = (LayoutParams) this.qun.getLayoutParams();
            int bsY = bsY();
            layoutParams.leftMargin = eC(this.mPosition, bsY);
            this.qun.setLayoutParams(layoutParams);
            layoutParams = (LayoutParams) this.qul.getLayoutParams();
            layoutParams.width = (int) (((((double) this.mPosition) * 1.0d) / ((double) this.qur)) * ((double) bsY));
            this.qul.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    public final void n(OnClickListener onClickListener) {
        if (this.quo != null) {
            this.quo.setOnClickListener(onClickListener);
        }
    }

    public void db(boolean z) {
        this.fvG = z;
        super.db(z);
    }

    public final void wZ(int i) {
        seek(i);
    }

    public final void kj(boolean z) {
        db(z);
    }
}
