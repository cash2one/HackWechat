package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class PLTextView extends StaticTextView {
    private static long gTl = 0;
    private static int gTm = 0;
    private static long gTn = -2147483648L;
    private static long gTo = 0;
    private static int gTp = 0;
    private static long gTq = -2147483648L;
    private static long gTr = 0;
    private static int gTs = 0;
    private static long gTt = -2147483648L;
    private static boolean gTu = false;

    public PLTextView(Context context) {
        super(context);
    }

    public PLTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PLTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void setText(CharSequence charSequence) {
        long j = 0;
        if (!bh.M(charSequence)) {
            long currentTimeMillis;
            boolean z;
            if (h.DEBUG) {
                currentTimeMillis = System.currentTimeMillis();
            } else {
                currentTimeMillis = 0;
            }
            if (Ei() != null && Ei().gTL) {
                c.gTj.a(Ee(), Ei());
            }
            f a = c.gTj.a(Ee(), charSequence);
            if (a != null) {
                p(charSequence);
                b(a);
                z = true;
            } else {
                o(charSequence);
                z = false;
            }
            if (h.DEBUG) {
                j = System.currentTimeMillis();
                x.d("MicroMsg.PLTextView", "setText used %fms, hitCache: %b, hashCode: %d, text: %s hitCache %s", new Object[]{Double.valueOf(((double) (j - currentTimeMillis)) / 1000000.0d), Boolean.valueOf(z), Integer.valueOf(hashCode()), charSequence, Boolean.valueOf(z)});
            }
            if (gTu) {
                currentTimeMillis = j - currentTimeMillis;
                gTl += currentTimeMillis;
                gTm++;
                if (currentTimeMillis > gTn) {
                    gTn = currentTimeMillis;
                }
            }
        } else if (h.DEBUG) {
            x.d("MicroMsg.PLTextView", "set null text");
        }
    }

    public void onMeasure(int i, int i2) {
        long j = 0;
        if (gTu) {
            j = System.currentTimeMillis();
        }
        super.onMeasure(i, i2);
        if (gTu) {
            j = System.currentTimeMillis() - j;
            gTo += j;
            gTp++;
            if (j > gTq) {
                gTq = j;
            }
        }
    }

    protected void onDraw(Canvas canvas) {
        long j = 0;
        if (gTu) {
            j = System.currentTimeMillis();
        }
        super.onDraw(canvas);
        if (gTu) {
            j = System.currentTimeMillis() - j;
            gTr += j;
            gTs++;
            if (j > gTt) {
                gTt = j;
            }
        }
    }

    public void o(CharSequence charSequence) {
        super.setText(charSequence, false);
    }

    public void p(CharSequence charSequence) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (Ei() != null) {
            Ei().gTL = false;
        }
    }
}
