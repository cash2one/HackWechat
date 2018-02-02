package com.tencent.mm.plugin.game.ui;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$LayoutParams;
import android.support.v7.widget.RecyclerView$g;
import android.support.v7.widget.RecyclerView.q;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;

public class GameIndexListView$a extends RecyclerView$g {
    private final Drawable RZ;
    private int hX;
    final /* synthetic */ GameIndexListView nrj;

    public GameIndexListView$a(GameIndexListView gameIndexListView, Resources resources, int i) {
        this.nrj = gameIndexListView;
        this.RZ = new ColorDrawable(resources.getColor(i));
        this.hX = resources.getDimensionPixelSize(R.f.bvd);
    }

    public final void a(Canvas canvas, RecyclerView recyclerView, q qVar) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount - 1; i++) {
            View childAt = recyclerView.getChildAt(i);
            View childAt2 = ((ViewGroup) childAt).getChildAt(0);
            if ((childAt2 instanceof GameBestSellingItemView) || (childAt2 instanceof GameBestSellingTitle) || (childAt2 instanceof GameFeedModuleTitle)) {
                super.a(canvas, recyclerView, qVar);
            } else {
                RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams) childAt.getLayoutParams();
                int bottom = recyclerView$LayoutParams.bottomMargin + childAt.getBottom();
                this.RZ.setBounds(paddingLeft, bottom, width, this.hX + bottom);
                this.RZ.draw(canvas);
            }
        }
    }

    public final void a(Rect rect, View view, RecyclerView recyclerView, q qVar) {
        rect.set(0, 0, 0, this.hX);
    }
}
