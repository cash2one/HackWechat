package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.ah.a.e;
import com.tencent.mm.plugin.ah.a.f;
import com.tencent.mm.plugin.ah.a.g;
import com.tencent.mm.sdk.platformtools.x;

public class SnsAdNativeLandingPagesVideoPlayerLoadingBar extends RelativeLayout implements a {
    private View contentView = null;
    public boolean fvG = false;
    private boolean kog = false;
    private int mPosition = 0;
    public b quk = null;
    private ImageView qul;
    private ImageView qum = null;
    private ImageView qun = null;
    private ImageView quo = null;
    private TextView qup;
    private TextView quq;
    public int qur = 0;
    private int qus = 0;
    private float quu = 0.0f;
    private int quv = -1;
    private int quw = -1;
    private int qux = -1;
    private int quy = -1;

    static /* synthetic */ int a(SnsAdNativeLandingPagesVideoPlayerLoadingBar snsAdNativeLandingPagesVideoPlayerLoadingBar, int i) {
        int width = ((snsAdNativeLandingPagesVideoPlayerLoadingBar.qun.getWidth() - snsAdNativeLandingPagesVideoPlayerLoadingBar.qun.getPaddingLeft()) - snsAdNativeLandingPagesVideoPlayerLoadingBar.qun.getPaddingRight()) / 2;
        LayoutParams layoutParams = (LayoutParams) snsAdNativeLandingPagesVideoPlayerLoadingBar.qum.getLayoutParams();
        if (i < (layoutParams.leftMargin - snsAdNativeLandingPagesVideoPlayerLoadingBar.qun.getPaddingLeft()) - width) {
            return (layoutParams.leftMargin - snsAdNativeLandingPagesVideoPlayerLoadingBar.qun.getPaddingLeft()) - width;
        }
        return i > snsAdNativeLandingPagesVideoPlayerLoadingBar.bsY() ? snsAdNativeLandingPagesVideoPlayerLoadingBar.bsY() - width : i - width;
    }

    static /* synthetic */ int d(SnsAdNativeLandingPagesVideoPlayerLoadingBar snsAdNativeLandingPagesVideoPlayerLoadingBar) {
        int paddingLeft = (int) (((((double) (((LayoutParams) snsAdNativeLandingPagesVideoPlayerLoadingBar.qun.getLayoutParams()).leftMargin - (((LayoutParams) snsAdNativeLandingPagesVideoPlayerLoadingBar.qum.getLayoutParams()).leftMargin - snsAdNativeLandingPagesVideoPlayerLoadingBar.qun.getPaddingLeft()))) * 1.0d) / ((double) snsAdNativeLandingPagesVideoPlayerLoadingBar.bsY())) * ((double) snsAdNativeLandingPagesVideoPlayerLoadingBar.qur));
        return paddingLeft < 0 ? 0 : paddingLeft;
    }

    public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context context) {
        super(context);
        init();
    }

    public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SnsAdNativeLandingPagesVideoPlayerLoadingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public final void a(b bVar) {
        this.quk = bVar;
    }

    private void init() {
        this.contentView = View.inflate(getContext(), f.sdz, this);
        this.qul = (ImageView) this.contentView.findViewById(e.pdA);
        this.qum = (ImageView) this.contentView.findViewById(e.pdz);
        this.qun = (ImageView) this.contentView.findViewById(e.pdB);
        this.quo = (ImageView) this.contentView.findViewById(e.cCD);
        this.qup = (TextView) this.contentView.findViewById(e.pdx);
        this.quq = (TextView) this.contentView.findViewById(e.pdy);
        this.qun.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ SnsAdNativeLandingPagesVideoPlayerLoadingBar quW;

            {
                this.quW = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    x.i("MicroMsg.SnsAdNativeLandingPagesVideoPlayerLoadingBar", "ontouch down");
                    this.quW.kog = false;
                    this.quW.quu = motionEvent.getX();
                    if (this.quW.quk != null) {
                        this.quW.quk.agX();
                    }
                } else if (motionEvent.getAction() == 2) {
                    float x = motionEvent.getX();
                    LayoutParams layoutParams = (LayoutParams) this.quW.qun.getLayoutParams();
                    layoutParams.leftMargin = SnsAdNativeLandingPagesVideoPlayerLoadingBar.a(this.quW, ((int) (x - this.quW.quu)) + layoutParams.leftMargin);
                    this.quW.qun.setLayoutParams(layoutParams);
                    int d = SnsAdNativeLandingPagesVideoPlayerLoadingBar.d(this.quW);
                    if (this.quW.qur > 0) {
                        layoutParams = (LayoutParams) this.quW.qul.getLayoutParams();
                        layoutParams.width = (int) (((((double) d) * 1.0d) / ((double) this.quW.qur)) * ((double) this.quW.bsY()));
                        this.quW.qul.setLayoutParams(layoutParams);
                    }
                    this.quW.qup.setText(SnsAdNativeLandingPagesVideoPlayerLoadingBar.kG(d / 60) + ":" + SnsAdNativeLandingPagesVideoPlayerLoadingBar.kG(d % 60));
                    this.quW.kog = true;
                } else if (this.quW.kog) {
                    int d2 = SnsAdNativeLandingPagesVideoPlayerLoadingBar.d(this.quW);
                    if (this.quW.quk != null) {
                        x.i("MicroMsg.SnsAdNativeLandingPagesVideoPlayerLoadingBar", "current time : " + d2);
                        this.quW.quk.kH(d2);
                    }
                    this.quW.kog = false;
                }
                return true;
            }
        });
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
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

    public final void db(boolean z) {
        this.fvG = z;
        if (z) {
            this.quo.setImageResource(g.pdE);
        } else {
            this.quo.setImageResource(g.pdF);
        }
    }

    public final void seek(int i) {
        this.mPosition = i;
        ahe();
    }

    public final int bsW() {
        return this.qur;
    }

    public final void wl(int i) {
        if (this.qun.isShown() && this.qun.getWidth() == 0) {
            post(new 2(this, i));
            return;
        }
        this.qur = i;
        this.mPosition = 0;
        this.quq.setText(kG(this.qur / 60) + ":" + kG(this.qur % 60));
        ahe();
    }

    private int bsY() {
        this.qus = this.qum.getWidth();
        return this.qus;
    }

    public final void bsZ() {
        this.qus = 0;
    }

    private void ahe() {
        if (this.qur != 0 && !this.kog && this.qun != null && bsY() != 0) {
            int width = ((this.qun.getWidth() - this.qun.getPaddingLeft()) - this.qun.getPaddingRight()) / 2;
            this.qup.setText(kG(this.mPosition / 60) + ":" + kG(this.mPosition % 60));
            LayoutParams layoutParams = (LayoutParams) this.qun.getLayoutParams();
            layoutParams.leftMargin = ((((LayoutParams) this.qum.getLayoutParams()).leftMargin - this.qun.getPaddingLeft()) + ((int) (((((double) this.mPosition) * 1.0d) / ((double) this.qur)) * ((double) bsY())))) - width;
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
