package com.tencent.mm.plugin.appbrand.game.c;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

class a$a extends Drawable {
    Paint iYm;
    RectF iYn;
    final /* synthetic */ a iYo;

    private a$a(a aVar) {
        this.iYo = aVar;
        this.iYm = new Paint(1);
        this.iYn = new RectF();
        this.iYm.setColor(-12748166);
        this.iYm.setStyle(Style.FILL);
    }

    public final void draw(Canvas canvas) {
        float height = ((float) canvas.getHeight()) / 2.0f;
        RectF rectF = this.iYn;
        this.iYn.top = 0.0f;
        rectF.left = 0.0f;
        rectF = this.iYn;
        float f = height * 2.0f;
        this.iYn.bottom = f;
        rectF.right = f;
        canvas.drawArc(this.iYn, 90.0f, 180.0f, false, this.iYm);
        this.iYn.left = ((float) canvas.getWidth()) - (height * 2.0f);
        this.iYn.top = 0.0f;
        this.iYn.right = (float) canvas.getWidth();
        this.iYn.bottom = (float) canvas.getHeight();
        canvas.drawArc(this.iYn, -90.0f, 180.0f, false, this.iYm);
        canvas.drawRect(height - 1.0f, 0.0f, (((float) this.iYo.getWidth()) - height) + 1.0f, (float) this.iYo.getHeight(), this.iYm);
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getOpacity() {
        return -1;
    }
}
