package com.tencent.mm.plugin.music.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class LyricView extends View {
    public static int oMZ = com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), 16);
    public static int oNa = com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), 10);
    private int height;
    private long hij;
    private GestureDetector lVX;
    private float nJk;
    com.tencent.mm.plugin.music.model.a oMT;
    TextPaint oMU;
    TextPaint oMV;
    private int oMW;
    private int oMX;
    private int oMY = -1;
    private int oNb = (oMZ + oNa);
    private int oNc = this.oNb;
    private boolean oNd;
    private boolean oNe;
    private int oNf;
    private float osI;
    private int width;

    private class a extends SimpleOnGestureListener {
        final /* synthetic */ LyricView oNg;

        private a(LyricView lyricView) {
            this.oNg = lyricView;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            CharSequence a = LyricView.a(this.oNg, motionEvent.getX(), motionEvent.getY());
            if (bh.ov(a)) {
                x.i("MicroMsg.Music.LyricView", "onLongPress not found sentence");
                return;
            }
            if (h.bdy().oJY == null) {
                h.bdy().oJY = (ClipboardManager) ac.getContext().getSystemService("clipboard");
            }
            h.bdy().oJY.setPrimaryClip(ClipData.newPlainText("MicroMsg.Music", a));
            Toast.makeText(this.oNg.getContext(), this.oNg.getContext().getString(R.l.ewN, new Object[]{a}), 0).show();
        }
    }

    static /* synthetic */ String a(LyricView lyricView, float f, float f2) {
        x.i("MicroMsg.Music.LyricView", "getSentenceByXY %f, %f", new Object[]{Float.valueOf(f), Float.valueOf(f2)});
        if (lyricView.oMT != null && lyricView.oMT.oJl.size() > 0) {
            int i = (lyricView.height / 2) - lyricView.oNc;
            int i2 = i - ((oMZ + oNa) / 2);
            i += (oMZ + oNa) / 2;
            if (f2 >= ((float) i2) && f2 <= ((float) i)) {
                return lyricView.oMT.tm(lyricView.oMY).content;
            }
            if (f2 < ((float) i2)) {
                i = (lyricView.oMY - (((int) (((float) i2) - f2)) / (oMZ + oNa))) - 1;
                if (i < lyricView.oMT.oJl.size() && i >= 0) {
                    return lyricView.oMT.tm(i).content;
                }
            } else if (f2 > ((float) i)) {
                i = ((((int) (f2 - ((float) i))) / (oMZ + oNa)) + lyricView.oMY) + 1;
                if (i < lyricView.oMT.oJl.size() && i >= 0) {
                    return lyricView.oMT.tm(i).content;
                }
            }
        }
        return "";
    }

    public final void dQ(long j) {
        if (this.hij != j) {
            this.hij = j;
            if (this.oMT != null && this.oMT.oJl.size() != 0) {
                int i = -1;
                int i2 = 0;
                while (i2 < this.oMT.oJl.size() && this.oMT.tm(i2).timestamp < j) {
                    if (!this.oMT.tm(i2).oJr) {
                        i = i2;
                    }
                    i2++;
                }
                if (!this.oNe && i != this.oMY) {
                    this.oMY = i;
                    this.oMW = (oMZ + oNa) * this.oMY;
                    this.oMX = (oMZ + oNa) * ((this.oMT.oJl.size() - this.oMY) - 1);
                    if (this.oNc == 0) {
                        this.oNc = -this.oNb;
                    }
                    this.oNd = true;
                    invalidate();
                }
            }
        }
    }

    public LyricView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public LyricView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        this.oMU = new TextPaint();
        this.oMU.setTextSize((float) oMZ);
        this.oMU.setColor(-1);
        this.oMU.setAntiAlias(true);
        this.oMU.setTextAlign(Align.CENTER);
        this.oMV = new TextPaint();
        this.oMV.setTextSize((float) oMZ);
        this.oMV.setColor(-1);
        this.oMV.setAlpha(127);
        this.oMV.setAntiAlias(true);
        this.oMV.setTextAlign(Align.CENTER);
        this.lVX = new GestureDetector(getContext(), new a());
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.oMT == null) {
            x.v("MicroMsg.Music.LyricView", "lyricObj is null");
            return;
        }
        if (this.height == 0 || this.width == 0) {
            this.height = getMeasuredHeight();
            this.width = getMeasuredWidth();
        }
        if (this.oMY >= 0) {
            int i = this.oNc;
            if (this.oMT != null && this.oMT.oJl.size() > this.oMY) {
                int i2;
                int i3 = (this.height / 2) - i;
                if (i3 < this.height && i3 > 0) {
                    canvas.drawText(this.oMT.tm(this.oMY).content, (float) (this.width / 2), (float) i3, this.oMU);
                }
                for (i = this.oMY - 1; i >= 0; i--) {
                    i2 = i3 - ((this.oMY - i) * (oMZ + oNa));
                    if (i2 > 0 && i2 < this.height) {
                        canvas.drawText(this.oMT.tm(i).content, (float) (this.width / 2), (float) i2, this.oMV);
                    }
                }
                for (i = this.oMY + 1; i < this.oMT.oJl.size(); i++) {
                    i2 = ((i - this.oMY) * (oMZ + oNa)) + i3;
                    if (i2 < this.height && i2 > 0) {
                        canvas.drawText(this.oMT.tm(i).content, (float) (this.width / 2), (float) i2, this.oMV);
                    }
                }
            }
            if (this.oNd) {
                if ((this.oNc != 0 ? 1 : null) != null) {
                    this.oNc = (int) (((float) this.oNc) * 0.9f);
                    invalidate();
                }
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.height = i2;
        this.width = i;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.lVX.onTouchEvent(motionEvent);
        switch (motionEvent.getAction()) {
            case 0:
                this.nJk = motionEvent.getY();
                this.osI = motionEvent.getX();
                this.oNf = this.oNc;
                this.oNe = true;
                this.oNd = false;
                break;
            case 1:
                this.oNe = false;
                break;
            case 2:
                int x = (int) (motionEvent.getX() - this.osI);
                int y = this.oNf - ((int) (motionEvent.getY() - this.nJk));
                if (y > 0) {
                    this.oNc = y > this.oMX ? this.oMX : y;
                } else {
                    this.oNc = y < (-this.oMW) ? -this.oMW : y;
                }
                invalidate();
                x.d("MicroMsg.Music.LyricView", "xDistance: %d yDisntance: %d tempYOffset: %d baseYOffset: %d", new Object[]{Integer.valueOf(x), Integer.valueOf(r3), Integer.valueOf(y), Integer.valueOf(this.oNf)});
                break;
        }
        return true;
    }
}
