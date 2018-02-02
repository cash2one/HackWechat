package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.plugin.bottle.a.h$b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.k;

public class PickBottleUI extends FrameLayout implements OnClickListener, OnTouchListener {
    float density;
    af handler = new af();
    private boolean hasInit = false;
    float iQK;
    float iQL;
    BottleBeachUI kCH;
    SprayLayout kDc;
    PickedBottleImageView kDd;
    ImageView kDe;
    private h$b kDf;
    Runnable kDg = new 1(this);
    Runnable kDh = new Runnable(this) {
        final /* synthetic */ PickBottleUI kDi;

        {
            this.kDi = r1;
        }

        public final void run() {
            if (this.kDi.kDd != null && this.kDi.kDd.isShown()) {
                this.kDi.kCH.nm(0);
            }
        }
    };

    public PickBottleUI(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kCH = (BottleBeachUI) context;
    }

    public PickBottleUI(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kCH = (BottleBeachUI) context;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        initView();
    }

    public final void initView() {
        if (!this.hasInit) {
            this.kDd = (PickedBottleImageView) findViewById(R.h.bOw);
            this.kDc = (SprayLayout) this.kCH.findViewById(R.h.bOz);
            this.kDe = (ImageView) this.kCH.findViewById(R.h.bOb);
            this.kDd.setOnClickListener(this);
            if (!bh.cgq()) {
                setBackgroundResource(R.g.bzQ);
            }
            setOnClickListener(this);
            setOnTouchListener(this);
            this.hasInit = true;
        }
    }

    public void setVisibility(int i) {
        this.kDc.setVisibility(i);
        this.kDd.setVisibility(8);
        super.setVisibility(i);
    }

    public void onClick(View view) {
        if (R.h.bOw == view.getId()) {
            if (this.kDd.kCR != null) {
                ar.Hg();
                c.Fd().Xa(this.kDd.kCR);
                ar.Hg();
                aj WY = c.Fd().WY("floatbottle");
                if (!(WY == null || bh.ov(WY.field_username))) {
                    WY.eO(k.FO());
                    ar.Hg();
                    c.Fd().a(WY, WY.field_username);
                }
            }
            this.kCH.onClick(view);
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.iQK = motionEvent.getX();
            this.iQL = motionEvent.getY();
        } else if (action == 1) {
            boolean z;
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            action = getHeight();
            int width = getWidth();
            action = (action * 550) / 800;
            int i = (width - ((width * 120) / 480)) / 2;
            width -= i;
            if (y > ((float) action)) {
                z = true;
            } else if (x < ((float) i) - ((((float) i) * y) / ((float) action))) {
                z = true;
            } else {
                z = x > ((((float) i) * y) / ((float) action)) + ((float) width);
            }
            if (z) {
                if (!this.kDd.isShown()) {
                    if (this.kDf != null) {
                        Object obj = this.kDf;
                        ar.CG().b(155, obj);
                        ar.CG().b(156, obj);
                        ar.CG().c(obj.kAR);
                        this.kDf = null;
                    }
                    this.handler.removeCallbacks(this.kDg);
                    this.handler.removeCallbacks(this.kDh);
                    this.kCH.nm(0);
                } else if (this.kDd.kCR == null) {
                    this.kCH.nm(0);
                }
            } else if (t(x, y) && t(this.iQK, this.iQL)) {
                if (this.kDd.kCR != null) {
                    ar.Hg();
                    c.Fd().Xa(this.kDd.kCR);
                    ar.Hg();
                    aj WY = c.Fd().WY("floatbottle");
                    if (!(WY == null || bh.ov(WY.field_username))) {
                        WY.eO(k.FO());
                        ar.Hg();
                        c.Fd().a(WY, WY.field_username);
                    }
                }
                this.kCH.onClick(this.kDd);
            }
        }
        return true;
    }

    private boolean t(float f, float f2) {
        int height = getHeight();
        int width = getWidth();
        int i = (width * 180) / 480;
        int i2 = (height * 75) / 800;
        float f3 = f - ((float) ((width * 240) / 480));
        float f4 = f2 - ((float) ((height * 495) / 800));
        if (((f4 * f4) / ((float) (i2 * i2))) + ((f3 * f3) / ((float) (i * i))) <= 1.0f) {
            return true;
        }
        return false;
    }
}
