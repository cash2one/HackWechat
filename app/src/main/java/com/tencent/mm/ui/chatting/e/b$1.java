package com.tencent.mm.ui.chatting.e;

import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.RecyclerView.q;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.a.b.b;

class b$1 extends g {
    int hX = ((int) this.yHl.mContext.getResources().getDimension(R.f.buo));
    int yHj = this.yHl.mContext.getResources().getColor(R.e.bsl);
    ColorDrawable yHk = new ColorDrawable(this.yHj);
    final /* synthetic */ b yHl;

    b$1(b bVar) {
        this.yHl = bVar;
    }

    public final void a(Canvas canvas, RecyclerView recyclerView, q qVar) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            if (childAt.getTag() != null) {
                b FD = this.yHl.FD(((Integer) childAt.getTag()).intValue() + 1);
                if (FD == null || FD.getType() != Integer.MAX_VALUE) {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    int bottom = layoutParams.bottomMargin + childAt.getBottom();
                    this.yHk.setBounds(paddingLeft, bottom, width, this.hX + bottom);
                    this.yHk.draw(canvas);
                }
            }
        }
    }
}
