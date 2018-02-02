package com.tencent.mm.plugin.appbrand.widget.f;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.sdk.platformtools.af;

public final class a extends FrameLayout implements OnClickListener, c {
    private TextView jVY;
    private final Runnable keU = new 1(this);
    private ViewPropertyAnimator keV;
    ViewPropertyAnimator keW;
    private final af mHandler = new af(Looper.getMainLooper());

    public a(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(h.ixn, this, true);
        this.jVY = (TextView) findViewById(g.title);
        setOnClickListener(this);
    }

    public final void vh(String str) {
        this.jVY.setText(str);
        this.mHandler.removeCallbacks(this.keU);
        this.mHandler.postDelayed(this.keU, kfa);
        if (getAlpha() != 1.0f && this.keV == null) {
            setVisibility(0);
            animate().cancel();
            ViewPropertyAnimator animate = animate();
            this.keV = animate;
            animate.alpha(1.0f).setListener(new 2(this)).start();
            setVisibility(0);
        }
    }

    public final View getView() {
        return this;
    }

    public final void a(FrameLayout frameLayout) {
        frameLayout.addView(this, new LayoutParams(-2, -2, 17));
    }

    public final void onClick(View view) {
    }
}
