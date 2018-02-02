package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import java.util.List;

public class QTextView extends View {
    private static HashMap<String, a> rwh = new HashMap();
    private Context context;
    private TextPaint gu;
    private String jUJ = "";
    int nxD;
    private int rwa;
    String rwb;
    String rwc;
    private boolean rwd;
    private int rwe;
    private boolean rwf;
    boolean rwg;
    private a rwi;
    private a rwj;
    int rwk = 0;
    private int textSize = -1;

    public QTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    public QTextView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    private void init() {
        this.rwg = false;
        this.rwd = true;
        this.rwf = false;
        this.nxD = -1;
        this.rwb = "...";
        this.rwc = "";
        this.rwe = -16776961;
        this.rwi = new a();
        this.rwj = new a();
        this.gu = new TextPaint();
        this.gu.setAntiAlias(true);
        if (this.textSize == -1) {
            this.textSize = b.b(this.context, 12.0f);
            this.gu.setTextSize((float) this.textSize);
        } else {
            this.gu.setTextSize(13.0f);
        }
        this.gu.setColor(WebView.NIGHT_MODE_COLOR);
        this.gu.setTextAlign(Align.LEFT);
    }

    public final void setText(String str) {
        if (bh.ov(this.jUJ)) {
            this.jUJ = "";
        }
        this.jUJ = str;
        a.a(this.rwi, "");
        a.a(this.rwj, "");
        requestLayout();
        invalidate();
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            xz(size);
        } else if (mode == Integer.MIN_VALUE) {
            size = Math.min(xz(size), size);
        } else {
            xz(size);
            size = 0;
        }
        int mode2 = MeasureSpec.getMode(i2);
        mode = MeasureSpec.getSize(i2);
        this.rwa = (int) this.gu.ascent();
        if (mode2 == 1073741824) {
            i3 = mode;
        } else {
            i3 = (((this.rwg ? this.rwi.rwm.size() : this.rwj.rwm.size()) * ((int) (((float) (-this.rwa)) + this.gu.descent()))) + getPaddingTop()) + getPaddingBottom();
            if (mode2 == Integer.MIN_VALUE) {
                i3 = Math.min(i3, mode);
            }
        }
        setMeasuredDimension(size, i3);
    }

    protected void onDraw(Canvas canvas) {
        a aVar;
        super.onDraw(canvas);
        if (this.rwg) {
            aVar = this.rwi;
            List list = this.rwi.rwm;
        } else {
            aVar = this.rwj;
            Object obj = this.rwj.rwm;
        }
        float paddingLeft = (float) getPaddingLeft();
        float paddingTop = (float) (getPaddingTop() + (-this.rwa));
        int i = 0;
        while (i < list.size()) {
            int[] iArr = (int[]) list.get(i);
            canvas.drawText(this.jUJ, iArr[0], iArr[1] + 1, paddingLeft, paddingTop, this.gu);
            if (i == list.size() - 1 && aVar.rwl) {
                canvas.drawText(this.rwb, aVar.rwn + paddingLeft, paddingTop, this.gu);
                if (this.rwd) {
                    int color = this.gu.getColor();
                    this.gu.setColor(this.rwe);
                    if (this.rwf) {
                        canvas.drawText(this.rwc, ((float) canvas.getWidth()) - ((aVar.rwp + ((float) getPaddingRight())) + ((float) getPaddingLeft())), paddingTop, this.gu);
                    } else {
                        canvas.drawText(this.rwc, (aVar.rwn + aVar.rwo) + paddingLeft, paddingTop, this.gu);
                    }
                    this.gu.setColor(color);
                }
            }
            paddingTop += ((float) (-this.rwa)) + this.gu.descent();
            if (paddingTop <= ((float) canvas.getHeight())) {
                i++;
            } else {
                return;
            }
        }
    }

    private int xz(int i) {
        if (this.rwg) {
            if (bh.ov(a.a(this.rwi))) {
                this.rwk = this.rwi.a(this.jUJ, null, null, -1, (i - getPaddingLeft()) - getPaddingRight(), this.gu);
            }
        } else if (bh.ov(a.a(this.rwj))) {
            this.rwk = this.rwj.a(this.jUJ, this.rwb, this.rwc, this.nxD, (i - getPaddingLeft()) - getPaddingRight(), this.gu);
        }
        return (this.rwk + getPaddingLeft()) + getPaddingRight();
    }
}
