package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class LuckyAvatarParticleView extends View {
    private Paint iYm = new Paint();
    private List<Rect> nZs = new ArrayList();
    private List<Integer> nZt = new ArrayList();
    private List<Integer> nZu = new ArrayList();

    public LuckyAvatarParticleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < this.nZs.size(); i++) {
            canvas.drawRect((Rect) this.nZs.get(i), this.iYm);
        }
    }
}
