package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;

public final class a implements d {
    private static int jtJ;
    private static int jtK;
    private int Mg;
    private int Mq;
    private StaticLayout gTO;
    private SpannableString jtL;
    private int jtM;
    private int jtN;
    private int jtO = -1;
    private int jtP;
    private int jtQ;
    private float jtR;
    private Context mContext;
    private int yg = -1;

    public a(Context context, SpannableString spannableString, int i, int i2) {
        this.mContext = context;
        this.jtL = spannableString;
        this.jtP = b.x(this.mContext, b.jtS);
        this.yg = i;
        this.jtR = 3.0f;
        this.jtQ = i2;
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setColor(this.yg);
        textPaint.setTextSize((float) this.jtP);
        FontMetrics fontMetrics = textPaint.getFontMetrics();
        this.Mq = ((int) Math.ceil((double) (fontMetrics.descent - fontMetrics.top))) + 2;
        this.gTO = new StaticLayout(this.jtL, textPaint, ((int) Layout.getDesiredWidth(this.jtL, 0, this.jtL.length(), textPaint)) + 1, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.Mg = this.gTO.getWidth();
    }

    public final void b(Canvas canvas, boolean z) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (!(width == jtJ && height == jtK)) {
            jtJ = width;
            jtK = height;
        }
        canvas.save();
        canvas.translate((float) this.jtM, (float) this.jtN);
        this.gTO.draw(canvas);
        canvas.restore();
        if (!z) {
            this.jtM = (int) (((float) this.jtM) - (((float) b.ahr()) * this.jtR));
        }
    }

    public final void bJ(int i, int i2) {
        this.jtM = i;
        this.jtN = i2;
    }

    public final float aho() {
        return this.jtR;
    }

    public final boolean ahp() {
        return this.jtM < 0 && Math.abs(this.jtM) > this.Mg;
    }

    public final int getWidth() {
        return this.Mg;
    }

    public final int getCurrX() {
        return this.jtM;
    }

    public final int ahq() {
        return this.jtQ;
    }

    public final boolean kJ(int i) {
        if (i >= this.jtQ && i - this.jtQ <= b.jtT) {
            return true;
        }
        return false;
    }

    public final boolean kK(int i) {
        return i - this.jtQ > b.jtT;
    }

    public final boolean a(d dVar) {
        if (dVar.getWidth() + dVar.getCurrX() > jtJ) {
            return true;
        }
        if (this.jtO < 0) {
            this.jtO = b.x(this.mContext, 20);
        }
        if (dVar.aho() >= this.jtR) {
            if (dVar.aho() != this.jtR || ((float) (jtJ - (dVar.getCurrX() + dVar.getWidth()))) >= ((float) this.jtO)) {
                return false;
            }
            return true;
        } else if (((double) (((((float) (dVar.getCurrX() + dVar.getWidth())) / (dVar.aho() * ((float) b.ahr()))) * this.jtR) * ((float) b.ahr()))) <= ((double) jtJ) - (((double) this.jtO) * 1.5d)) {
            return false;
        } else {
            return true;
        }
    }
}
