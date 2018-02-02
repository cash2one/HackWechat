package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.ab.a.a;
import com.tencent.mm.plugin.ab.a.b;
import com.tencent.mm.plugin.ab.a.c;

public class AdVideoPlayerLoadingBar extends RelativeLayout implements a {
    public View contentView = null;
    public boolean kog = false;
    public int mPosition = 0;
    public b quk = null;
    public ImageView qul;
    public ImageView qum = null;
    public ImageView qun = null;
    public ImageView quo = null;
    public TextView qup;
    public TextView quq;
    public int qur = 0;
    private int qus = 0;
    private int qut = 0;
    public float quu = 0.0f;
    private int quv = -1;
    private int quw = -1;
    private int qux = -1;
    private int quy = -1;

    static /* synthetic */ int a(AdVideoPlayerLoadingBar adVideoPlayerLoadingBar, int i) {
        int bta = ((adVideoPlayerLoadingBar.bta() - adVideoPlayerLoadingBar.qun.getPaddingLeft()) - adVideoPlayerLoadingBar.qun.getPaddingRight()) / 2;
        LayoutParams layoutParams = (LayoutParams) adVideoPlayerLoadingBar.qum.getLayoutParams();
        if (i < (layoutParams.leftMargin - adVideoPlayerLoadingBar.qun.getPaddingLeft()) - bta) {
            return (layoutParams.leftMargin - adVideoPlayerLoadingBar.qun.getPaddingLeft()) - bta;
        }
        if (i <= ((adVideoPlayerLoadingBar.bsY() + layoutParams.leftMargin) - bta) - adVideoPlayerLoadingBar.qun.getPaddingLeft()) {
            return i;
        }
        return ((layoutParams.leftMargin + adVideoPlayerLoadingBar.bsY()) - bta) - adVideoPlayerLoadingBar.qun.getPaddingLeft();
    }

    public AdVideoPlayerLoadingBar(Context context) {
        super(context);
        init();
    }

    public AdVideoPlayerLoadingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public AdVideoPlayerLoadingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public int getLayoutId() {
        return b.pdD;
    }

    public final void a(b bVar) {
        this.quk = bVar;
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
        this.qun.post(new 2(this));
        LayoutParams layoutParams = (LayoutParams) this.qul.getLayoutParams();
        layoutParams.width = 0;
        this.qul.setLayoutParams(layoutParams);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.qus = 0;
        if (!(i == this.quv && i2 == this.quw && i3 == this.qux && i4 == this.quy)) {
            ahe();
        }
        this.quv = i;
        this.quw = i2;
        this.qux = i3;
        this.quy = i4;
    }

    public final void i(OnClickListener onClickListener) {
        this.quo.setOnClickListener(onClickListener);
    }

    public void db(boolean z) {
        if (z) {
            this.quo.setImageResource(c.pdE);
        } else {
            this.quo.setImageResource(c.pdF);
        }
    }

    protected final int bsV() {
        return Math.max(0, (int) (((((double) ((((LayoutParams) this.qun.getLayoutParams()).leftMargin - (((LayoutParams) this.qum.getLayoutParams()).leftMargin - this.qun.getPaddingLeft())) + (((bta() - this.qun.getPaddingLeft()) - this.qun.getPaddingRight()) / 2))) * 1.0d) / ((double) bsY())) * ((double) this.qur)));
    }

    public void seek(int i) {
        this.mPosition = i;
        ahe();
    }

    public final int bsW() {
        return this.qur;
    }

    public void wl(int i) {
        this.qur = i;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            post(new 3(this));
        } else {
            bsX();
        }
    }

    public final void bsX() {
        this.quq.setText(kG(this.qur / 60) + ":" + kG(this.qur % 60));
        ahe();
    }

    public int bsY() {
        if (this.qus <= 0) {
            this.qus = this.qum.getWidth();
        }
        return this.qus;
    }

    public final void bsZ() {
        this.qus = 0;
    }

    public int bta() {
        if (this.qut <= 0) {
            this.qut = this.qun.getWidth();
        }
        return this.qut;
    }

    public void ahe() {
        if (this.qur != 0 && !this.kog && this.qun != null && bsY() != 0) {
            int bta = ((bta() - this.qun.getPaddingLeft()) - this.qun.getPaddingRight()) / 2;
            this.qup.setText(kG(this.mPosition / 60) + ":" + kG(this.mPosition % 60));
            LayoutParams layoutParams = (LayoutParams) this.qun.getLayoutParams();
            layoutParams.leftMargin = ((((LayoutParams) this.qum.getLayoutParams()).leftMargin - this.qun.getPaddingLeft()) + ((int) (((((double) this.mPosition) * 1.0d) / ((double) this.qur)) * ((double) bsY())))) - bta;
            this.qun.setLayoutParams(layoutParams);
            layoutParams = (LayoutParams) this.qul.getLayoutParams();
            layoutParams.width = (int) (((((double) this.mPosition) * 1.0d) / ((double) this.qur)) * ((double) bsY()));
            this.qul.setLayoutParams(layoutParams);
        }
    }

    public static String kG(int i) {
        if (i < 10) {
            return "0" + i;
        }
        return String.valueOf(i);
    }
}
