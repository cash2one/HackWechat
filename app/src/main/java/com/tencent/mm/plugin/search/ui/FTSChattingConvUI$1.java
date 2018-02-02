package com.tencent.mm.plugin.search.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.RecyclerView.q;
import android.view.View;
import com.tencent.mm.R;

class FTSChattingConvUI$1 extends g {
    Paint iYm = new Paint(1);
    final int offset = ((int) this.qci.getResources().getDimension(R.f.bur));
    final /* synthetic */ FTSChattingConvUI qci;

    FTSChattingConvUI$1(FTSChattingConvUI fTSChattingConvUI) {
        this.qci = fTSChattingConvUI;
    }

    public final void a(Rect rect, View view, RecyclerView recyclerView, q qVar) {
        super.a(rect, view, recyclerView, qVar);
        rect.set(this.offset, this.offset, this.offset, this.offset);
    }

    public final void a(Canvas canvas, RecyclerView recyclerView, q qVar) {
        super.a(canvas, recyclerView, qVar);
        this.iYm.setColor(-2434342);
        this.iYm.setStrokeWidth(1.0f);
        this.iYm.setStyle(Style.FILL);
        int childCount = recyclerView.getChildCount();
        int i = 0;
        while (i < childCount) {
            if (i == 1 || i == 4) {
                View childAt = recyclerView.getChildAt(i);
                canvas.drawLine((float) (childAt.getLeft() - this.offset), (float) childAt.getTop(), (float) (childAt.getLeft() - this.offset), (float) childAt.getBottom(), this.iYm);
                canvas.drawLine((float) (childAt.getRight() + this.offset), (float) childAt.getTop(), (float) (childAt.getRight() + this.offset), (float) childAt.getBottom(), this.iYm);
            }
            i++;
        }
    }
}
