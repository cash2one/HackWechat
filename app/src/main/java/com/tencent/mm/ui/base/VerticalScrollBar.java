package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.w.a.f;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.k;

public abstract class VerticalScrollBar extends View {
    private int atq;
    private float gUh;
    private Paint iYm;
    public float nJg;
    public int nJh;
    public String[] nJi;
    private float nJj = 0.0f;
    private float nJk;
    private q nJl;
    private TextView nJm;
    private int nJn;
    public a yhE;

    public abstract int aUq();

    public abstract void axX();

    public VerticalScrollBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        axX();
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.nJn = b.b(context, 3.0f);
        View inflate = inflate(context, aUq(), null);
        int b = b.b(context, (float) this.nJh);
        this.nJl = new q(inflate, b, b);
        this.nJm = (TextView) inflate.findViewById(g.cOh);
        this.iYm = new Paint();
        this.iYm.setAntiAlias(true);
        this.iYm.setColor(-11119018);
        this.iYm.setTextAlign(Align.CENTER);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        this.gUh = ((float) measuredHeight) / (((float) this.nJi.length) * this.nJg);
        this.iYm.setTextSize(this.gUh);
        if (this.nJj != this.gUh) {
            this.nJj = this.gUh;
            post(new 1(this, measuredWidth, measuredHeight));
        }
        for (measuredHeight = 0; measuredHeight < this.nJi.length; measuredHeight++) {
            canvas.drawText(this.nJi[measuredHeight], ((float) measuredWidth) / 2.0f, this.gUh + ((((float) measuredHeight) * this.gUh) * this.nJg), this.iYm);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
            this.nJk = motionEvent.getY();
            if (this.nJk < 0.0f) {
                this.nJk = 0.0f;
            }
            if (this.nJk > ((float) getMeasuredHeight())) {
                this.nJk = (float) getMeasuredHeight();
            }
            setBackgroundDrawable(a.b(getContext(), f.bFG));
            int i = (int) (this.nJk / (this.gUh * this.nJg));
            if (i >= this.nJi.length) {
                i = this.nJi.length - 1;
            }
            this.atq = i;
            if (this.atq == -1) {
                this.nJm.setText(k.eIq);
            } else {
                this.nJm.setText(this.nJi[this.atq]);
            }
            this.nJl.showAtLocation(this, 17, 0, 0);
            if (this.yhE != null) {
                if (this.atq == -1) {
                    this.yhE.xh(a.ac(getContext(), k.eIq));
                } else {
                    this.yhE.xh(this.nJi[this.atq]);
                }
            }
            invalidate();
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            setBackgroundResource(0);
            this.nJl.dismiss();
        }
        return true;
    }
}
