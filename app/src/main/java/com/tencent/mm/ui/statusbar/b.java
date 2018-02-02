package com.tencent.mm.ui.statusbar;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Build.VERSION;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.mm.ui.statusbar.c.a;

public class b extends FrameLayout implements a {
    public static final boolean zfW = c.zga;
    private final Paint fC;
    private int jNd;
    public final Activity mActivity;
    private int zfX;
    private int zfY;
    private boolean zfZ = false;

    public final void lA(int i) {
        GH(i);
    }

    public final void nn(boolean z) {
        this.zfZ = z;
        GH(this.jNd);
    }

    public b(Context context) {
        super(context);
        if (zfW) {
            this.mActivity = d.cg(context);
            c.ac(this.mActivity).a(this);
            this.fC = new Paint(1);
            this.fC.setStyle(Style.FILL);
            setWillNotDraw(false);
            return;
        }
        this.mActivity = null;
        this.fC = null;
    }

    private void GH(int i) {
        this.jNd = Math.max(0, i);
        setPadding(0, this.zfZ ? 0 : this.jNd, 0, 0);
        postInvalidate();
    }

    public final void ak(int i, boolean z) {
        this.zfX = i;
        if (zfW) {
            int argb;
            b bVar;
            b bVar2;
            Window window = this.mActivity.getWindow();
            d.a(window);
            if (VERSION.SDK_INT < 23 || !d.a(window, z)) {
                if (VERSION.SDK_INT >= 21) {
                    if (z) {
                        i = d.GI(i);
                    }
                    this.zfX = i;
                    if (z) {
                        argb = Color.argb(51, 0, 0, 0);
                        bVar = this;
                        bVar.zfY = argb;
                    } else {
                        bVar2 = this;
                    }
                }
                postInvalidate();
            }
            this.zfX = i;
            bVar2 = this;
            bVar = bVar2;
            argb = 0;
            bVar.zfY = argb;
            postInvalidate();
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        if (this.jNd > 0 && zfW && !this.zfZ) {
            this.fC.setColor(this.zfX);
            canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) this.jNd, this.fC);
        }
        super.dispatchDraw(canvas);
        if (this.jNd > 0 && zfW && this.zfZ) {
            this.fC.setColor(this.zfY);
            canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) this.jNd, this.fC);
        }
    }
}
