package com.tencent.mm.plugin.luckymoney.particles;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.tencent.mm.plugin.luckymoney.particles.a.b;
import com.tencent.mm.plugin.wxpay.a.d;
import java.util.List;

public class ConfettiView extends View implements OnLayoutChangeListener {
    List<b> odZ;
    private boolean oeI;
    private b oeJ;
    boolean terminated;

    public static ConfettiView da(Context context) {
        ConfettiView confettiView = new ConfettiView(context, null);
        confettiView.setLayoutParams(new LayoutParams(-1, -1));
        if (VERSION.SDK_INT >= 21) {
            confettiView.setElevation((float) context.getResources().getDimensionPixelOffset(d.ubQ));
        }
        return confettiView;
    }

    public ConfettiView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void aXn() {
        if (!this.terminated) {
            this.terminated = true;
            getParent().requestLayout();
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewGroup viewGroup = (ViewGroup) getParent();
        viewGroup.removeOnLayoutChangeListener(this);
        viewGroup.addOnLayoutChangeListener(this);
        if (this.odZ == null) {
            aXn();
        }
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (this.terminated) {
            ViewParent parent = getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) parent;
                viewGroup.removeViewInLayout(this);
                viewGroup.removeOnLayoutChangeListener(this);
                viewGroup.invalidate();
            }
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.terminated) {
            canvas.save();
            for (b bVar : this.odZ) {
                if (bVar.ofg) {
                    bVar.a(canvas, bVar.ofi + bVar.ofk, bVar.ofj + bVar.ofl, bVar.ofe);
                } else if (bVar.off && !bVar.terminated) {
                    bVar.a(canvas, bVar.ofc, bVar.ofd, bVar.ofe);
                }
            }
            canvas.restore();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.oeI) {
            b bVar;
            switch (motionEvent.getAction()) {
                case 0:
                    for (b bVar2 : this.odZ) {
                        boolean z2;
                        float x = motionEvent.getX();
                        float y = motionEvent.getY();
                        if (bVar2.ofc > x || x > bVar2.ofc + ((float) bVar2.getWidth()) || bVar2.ofd > y || y > bVar2.ofd + ((float) bVar2.getHeight())) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                            bVar2.ofg = true;
                            bVar2.ofi = x;
                            bVar2.ofj = y;
                            bVar2.ofk = bVar2.ofc - x;
                            bVar2.ofl = bVar2.ofd - y;
                            bVar2.ofh = VelocityTracker.obtain();
                            bVar2.ofh.addMovement(motionEvent);
                            z2 = true;
                            continue;
                        } else {
                            z2 = false;
                            continue;
                        }
                        if (z2) {
                            this.oeJ = bVar2;
                            z = true;
                            break;
                        }
                    }
                    z = false;
                    break;
                case 1:
                case 3:
                    if (this.oeJ != null) {
                        bVar2 = this.oeJ;
                        bVar2.ofh.addMovement(motionEvent);
                        bVar2.ofh.computeCurrentVelocity(1);
                        bVar2.oeQ = -1;
                        bVar2.oeR = motionEvent.getX() + bVar2.ofk;
                        bVar2.oeS = motionEvent.getY() + bVar2.ofl;
                        bVar2.oeT = bVar2.ofh.getXVelocity();
                        bVar2.oeU = bVar2.ofh.getYVelocity();
                        bVar2.oeX = bVar2.ofe;
                        bVar2.ofh.recycle();
                        bVar2.g(bVar2.oeg);
                        bVar2.ofg = false;
                        this.oeJ = null;
                        z = true;
                        break;
                    }
                case 2:
                    if (this.oeJ != null) {
                        bVar2 = this.oeJ;
                        bVar2.ofi = motionEvent.getX();
                        bVar2.ofj = motionEvent.getY();
                        bVar2.ofh.addMovement(motionEvent);
                        z = true;
                        break;
                    }
            }
        }
        z = false;
        if (z || super.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }
}
