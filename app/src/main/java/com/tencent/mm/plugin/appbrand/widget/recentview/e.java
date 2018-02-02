package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.k;
import android.support.v7.widget.RecyclerView.p;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends k {
    RecyclerView Va;
    p Vb;
    private int kaS = 0;
    int kfL;
    private int kfM;
    p kfN;
    int kfO;
    private int kfP = 0;
    private boolean kfQ = false;
    boolean kfR = false;

    public final void c(RecyclerView recyclerView, int i, int i2) {
        super.c(recyclerView, i, i2);
        this.kfL += i;
    }

    public final void e(RecyclerView recyclerView, int i) {
        super.e(recyclerView, i);
        if (i == 0 && this.kfP != 2) {
            int mt = mt(this.kfL);
            if (this.Va != null && this.kfR) {
                this.Vb.Vv = mt;
                this.Va.TV.a(this.Vb);
            }
            this.kfQ = true;
        } else if (!this.kfQ && i == 2) {
            this.kfQ = true;
        } else if (i == 0) {
            this.kfM = this.kfL;
            this.kfQ = false;
            this.kfR = false;
            this.kaS = ((LinearLayoutManager) this.Va.TV).eZ() / this.kfO;
        } else if (i == 1) {
            x.i("ViewPagerHelper", "SCROLL_STATE_DRAGGING");
            this.kfR = true;
        }
        this.kfP = i;
    }

    final int mt(int i) {
        float width = (float) this.Va.getWidth();
        if (((float) (i - this.kfM)) >= width / 2.0f) {
            this.kaS = ((LinearLayoutManager) this.Va.TV).fa() / this.kfO;
        } else if (((float) (i - this.kfM)) <= (-width) / 2.0f) {
            this.kaS = ((LinearLayoutManager) this.Va.TV).eZ() / this.kfO;
        }
        int itemCount = this.Va.fm().getItemCount() / this.kfO;
        if (this.Va.fm().getItemCount() % this.kfO != 0) {
            itemCount++;
        }
        this.kaS = Math.max(Math.min(this.kaS, itemCount - 1), -1);
        x.i("ViewPagerHelper", "[getOffsetToPosition] mCurPage:%s pos:%s", new Object[]{Integer.valueOf(this.kaS), Integer.valueOf(this.kaS * this.kfO)});
        return this.kaS * this.kfO;
    }
}
