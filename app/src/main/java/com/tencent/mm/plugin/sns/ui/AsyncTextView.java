package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.d.n;
import com.tencent.mm.pluginsdk.ui.d.n.a;

public class AsyncTextView extends TextView implements Runnable {
    private Context context;
    public int kTK;
    public String rre;
    public boolean rrf;
    public String rrg;
    public a rrh;
    public boolean rri;
    public String userName;

    public AsyncTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
    }

    public AsyncTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public void run() {
        if (getTag() instanceof String) {
            String str = (String) getTag();
            if (str != null && str.equals(this.userName)) {
                return;
            }
        }
        int i = this.kTK == 11 ? 3 : 2;
        n nVar = new n(new com.tencent.mm.plugin.sns.data.a(this.rrf, this.userName, this.rrg, 1), this.rrh, i);
        Context context = getContext();
        CharSequence charSequence = this.rre;
        getTextSize();
        CharSequence jVar = new j(i.d(context, charSequence, i));
        jVar.f(nVar, this.rre);
        setText(jVar, BufferType.SPANNABLE);
        setTag(this.userName);
    }

    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (Throwable th) {
        }
    }

    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Throwable th) {
        }
    }

    public int getBaseline() {
        try {
            return super.getBaseline();
        } catch (Throwable th) {
            return -1;
        }
    }

    public boolean onPreDraw() {
        try {
            return super.onPreDraw();
        } catch (Throwable th) {
            return true;
        }
    }
}
