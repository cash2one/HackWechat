package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

public final class a extends View {
    private Paint fC;
    public int lee;
    private int mType = 2;
    private int tUA;
    private a tUB;
    private RectF tUu;
    private RectF tUv;
    private RectF tUw;
    private RectF tUx;
    public int tUy;
    private int tUz;
    private int tgF;

    public a(Context context, int i, int i2, int i3, int i4, a aVar) {
        super(context);
        this.mType = i;
        this.tUz = i2;
        this.tgF = i3;
        this.tUy = (this.tUz * 2) / 5;
        this.lee = this.tUy;
        this.tUA = (this.tUy * 3) / 4;
        this.fC = new Paint(1);
        this.fC.setColor(i4);
        this.tUB = aVar;
        this.tUu = new RectF((float) this.lee, (float) this.tUz, (float) (this.lee + (this.tUy * 2)), (float) (this.tUz + (this.tUy * 2)));
        this.tUv = new RectF((float) (this.tUA - this.tUy), (float) this.tUz, (float) (this.tUA + this.tUy), (float) (this.tUz + (this.tUy * 2)));
        this.tUw = new RectF((float) this.lee, (float) this.tUz, (float) (this.lee + (this.tUy * 2)), (float) (this.tUz + (this.tUy * 2)));
        this.tUx = new RectF((float) (this.lee + this.tgF), (float) this.tUz, (float) ((this.lee + this.tgF) + (this.tUy * 2)), (float) (this.tUz + (this.tUy * 2)));
    }

    public final int btt() {
        return (this.tUz + (this.tUy * 2)) + this.lee;
    }

    public final int bCH() {
        if (this.mType == 3 || this.mType == 4) {
            return (this.lee + this.tUy) + this.tUA;
        }
        return this.tgF + ((this.lee + this.tUy) * 2);
    }

    protected final void onDraw(Canvas canvas) {
        switch (this.mType) {
            case 2:
                canvas.drawRect((float) (this.lee + this.tUy), 0.0f, (float) ((this.lee + this.tUy) + this.tgF), (float) (this.tUz + (this.tUy * 2)), this.fC);
                canvas.drawArc(this.tUw, 90.0f, 180.0f, true, this.fC);
                canvas.drawArc(this.tUx, 270.0f, 180.0f, true, this.fC);
                return;
            case 3:
                canvas.drawRect((float) (((this.lee + this.tUy) + this.tUA) - this.tgF), 0.0f, (float) ((this.lee + this.tUy) + this.tUA), (float) this.tUz, this.fC);
                canvas.drawArc(this.tUu, 90.0f, 180.0f, true, this.fC);
                canvas.drawRect((float) (this.lee + this.tUy), (float) this.tUz, (float) ((this.lee + this.tUy) + this.tUA), (float) (this.tUz + (this.tUy * 2)), this.fC);
                return;
            case 4:
                canvas.drawRect(0.0f, 0.0f, (float) this.tgF, (float) this.tUz, this.fC);
                canvas.drawRect(0.0f, (float) this.tUz, (float) this.tUA, (float) (this.tUz + (this.tUy * 2)), this.fC);
                canvas.drawArc(this.tUv, 270.0f, 180.0f, true, this.fC);
                return;
            default:
                return;
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.tUB != null) {
            this.tUB.a(this.mType, motionEvent);
        }
        return true;
    }
}
