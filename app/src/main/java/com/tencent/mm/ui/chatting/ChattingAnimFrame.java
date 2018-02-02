package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.az.d;
import com.tencent.mm.bv.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public class ChattingAnimFrame extends FrameLayout {
    private static String lvM = "";
    private int keI;
    private int keJ;
    private int mScreenHeight = a.eB(getContext());
    private int xjb = 40;
    List<MMAnimateView> yrh = new ArrayList();
    private int yri = 30;
    private int yrj = 30;
    private boolean yrk = false;
    private int yrl = 0;
    private ArrayList<Integer> yrm = new ArrayList();

    static /* synthetic */ long Fr(int i) {
        switch (i) {
            case 2:
                return 1200;
            case 3:
                return 1500;
            default:
                return (long) ((int) s(4000.0f, 6000.0f));
        }
    }

    public ChattingAnimFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.keJ = getMeasuredHeight();
        this.keI = getMeasuredWidth();
        x.d("MicroMsg.ChattingAnimFrame", "onFinishInflate width:%d height:%d", new Object[]{Integer.valueOf(this.keI), Integer.valueOf(this.keJ)});
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.keJ = i4 - i2;
        this.keI = i3 - i;
        if (this.keJ < this.mScreenHeight) {
            this.yrk = true;
            this.yrl = this.mScreenHeight - this.keJ;
        } else {
            this.yrk = false;
            this.yrl = 0;
        }
        x.d("MicroMsg.ChattingAnimFrame", "onLayout width:%d height:%d isKeyBordUp:%b keyBordHeight:%d", new Object[]{Integer.valueOf(this.keI), Integer.valueOf(this.keJ), Boolean.valueOf(this.yrk), Integer.valueOf(this.yrl)});
    }

    public final void a(d dVar) {
        stop();
        if (dVar == null) {
            x.w("MicroMsg.ChattingAnimFrame", "egg info is null. ignore.");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (bh.ov(lvM)) {
            lvM = e.gZL.replace("/data/user/0", "/data/data");
            lvM += "/emoji";
        }
        String stringBuilder2 = stringBuilder.append(lvM).append("/egg/").append(dVar.hJu).toString();
        if (com.tencent.mm.a.e.bO(stringBuilder2)) {
            setVisibility(0);
            if (dVar.hJw > 0) {
                this.yri = dVar.hJw;
                if (this.yri > 60) {
                    this.yri = 60;
                }
            } else {
                this.yri = 30;
            }
            if (dVar.hJx > 0) {
                this.yrj = dVar.hJx;
            } else {
                this.yrj = 30;
            }
            if (dVar.maxSize > 0) {
                this.xjb = dVar.maxSize;
            } else {
                this.xjb = 40;
            }
            x.i("MicroMsg.ChattingAnimFrame", "Egg viewCount:%d minSize:%d maxSize:%d AnimType:%d reportType:%d", new Object[]{Integer.valueOf(this.yri), Integer.valueOf(this.yrj), Integer.valueOf(this.xjb), Integer.valueOf(dVar.hJv), Integer.valueOf(dVar.hJq)});
            long j = 0;
            Fq(this.yri);
            int i = 0;
            while (i < this.yri) {
                int fromDPToPix = a.fromDPToPix(getContext(), (int) s((float) this.yrj, (float) this.xjb));
                int i2 = dVar.hJv;
                boolean z = this.yrm != null && this.yrm.contains(Integer.valueOf(i));
                Animation cVar = new c(this, i2, fromDPToPix, j, z);
                View mMAnimateView = new MMAnimateView(getContext());
                mMAnimateView.Cq(stringBuilder2);
                mMAnimateView.setAnimation(cVar);
                mMAnimateView.setLayerType(2, null);
                cVar.yrw = mMAnimateView;
                mMAnimateView.setLayoutParams(new LayoutParams(cVar.hX, cVar.hX));
                this.yrh.add(mMAnimateView);
                addView(mMAnimateView);
                int i3 = dVar.hJv;
                int i4 = this.yri;
                switch (i3) {
                    case 2:
                        j = i < 2 ? 800 + j : ((long) (((Math.abs((((double) i) - (((double) i4) * 0.5d)) - 5.0d) / ((double) (i4 * 3))) + 0.01d) * 1000.0d)) + j;
                        break;
                    case 3:
                        j += (long) (((Math.abs((((double) i) - (((double) i4) * 0.5d)) - 5.0d) / ((double) (i4 * 6))) + 0.06d) * 1000.0d);
                        break;
                    default:
                        j = (long) ((int) (s(0.0f, 4.0f) * 1000.0f));
                        break;
                }
                i++;
            }
            if (this.yrh != null) {
                for (View view : this.yrh) {
                    if (view != null && (view.getAnimation() instanceof c)) {
                        c.a((c) view.getAnimation());
                    }
                }
                return;
            }
            return;
        }
        x.w("MicroMsg.ChattingAnimFrame", "egg file isn't exist. ignore");
    }

    private void Fq(int i) {
        if (i <= 0) {
            x.w("MicroMsg.ChattingAnimFrame", "count is zero.");
            return;
        }
        int i2 = (int) (((double) i) * 0.1d);
        if (this.yrm != null) {
            this.yrm.clear();
        } else {
            this.yrm = new ArrayList();
        }
        while (this.yrm.size() < i2) {
            int s = (int) s(0.0f, (float) i);
            if (!this.yrm.contains(Integer.valueOf(s))) {
                this.yrm.add(Integer.valueOf(s));
            }
        }
    }

    public final void stop() {
        for (MMAnimateView mMAnimateView : this.yrh) {
            mMAnimateView.clearAnimation();
            mMAnimateView.recycle();
        }
        removeAllViews();
    }

    static float s(float f, float f2) {
        return (((float) Math.random()) * (f2 - f)) + f;
    }
}
