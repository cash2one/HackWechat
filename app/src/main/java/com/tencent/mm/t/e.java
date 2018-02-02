package com.tencent.mm.t;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextPaint;
import android.widget.TextView;
import com.tencent.mm.bj.a.c;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.ac;

public final class e extends c {
    private static final float gOb = ac.getResources().getDimension(c.vbg);
    private static final int gOc = ((int) ac.getResources().getDimension(c.vbm));
    private static final int gOd = ((int) ac.getResources().getDimension(c.vbn));
    private static TextPaint gu;
    public SpannableString gOe;
    public int su = -1;

    static {
        TextPaint textPaint = new TextPaint(1);
        gu = textPaint;
        textPaint.setStrokeCap(Cap.ROUND);
        gu.setStyle(Style.FILL);
        gu.setDither(true);
        gu.setTextSize(gOb);
    }

    public e(Context context, Matrix matrix, String str, Rect rect, SpannableString spannableString, int i) {
        super(context, matrix, str, rect);
        this.su = i;
        this.gOe = spannableString;
    }

    protected final Bitmap BK() {
        gu.setColor(this.su);
        if (this.gOe == null) {
            return null;
        }
        TextView textView = new TextView(this.mContext);
        textView.setTextSize((float) Math.round(gOb / this.mContext.getResources().getDisplayMetrics().density));
        textView.setText(i.b(this.mContext, this.gOe, gOb / 1.3f));
        textView.setSingleLine(false);
        textView.setMaxWidth((int) (((float) this.mContext.getResources().getDisplayMetrics().widthPixels) - (this.mContext.getResources().getDimension(c.vbf) * 2.0f)));
        textView.measure(0, 0);
        Bitmap createBitmap = Bitmap.createBitmap(textView.getMeasuredWidth(), textView.getMeasuredHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        textView.getLayout().getPaint().setColor(this.su);
        textView.getLayout().draw(canvas);
        return createBitmap;
    }

    public final void setSelected(boolean z) {
        super.setSelected(z);
        if (!z) {
            this.gNM = false;
        }
    }
}
