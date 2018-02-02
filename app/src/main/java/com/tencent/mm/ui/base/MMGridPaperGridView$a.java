package com.tencent.mm.ui.base;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

class MMGridPaperGridView$a extends BaseAdapter {
    final /* synthetic */ MMGridPaperGridView ybt;

    private MMGridPaperGridView$a(MMGridPaperGridView mMGridPaperGridView) {
        this.ybt = mMGridPaperGridView;
    }

    public final boolean isEnabled(int i) {
        return MMGridPaperGridView.a(this.ybt) != null;
    }

    public final int getItemViewType(int i) {
        return 0;
    }

    public final int getViewTypeCount() {
        return 1;
    }

    public final int getCount() {
        return (MMGridPaperGridView.c(this.ybt) < 0 || MMGridPaperGridView.a(this.ybt) == null) ? 0 : MMGridPaperGridView.c(this.ybt);
    }

    public final Object getItem(int i) {
        return MMGridPaperGridView.a(this.ybt) == null ? null : MMGridPaperGridView.a(this.ybt).getItem(MMGridPaperGridView.b(this.ybt) + i);
    }

    public final long getItemId(int i) {
        return MMGridPaperGridView.a(this.ybt) == null ? 0 : MMGridPaperGridView.a(this.ybt).getItemId(MMGridPaperGridView.b(this.ybt) + i);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        boolean z;
        long Wq = bh.Wq();
        String str = "MicroMsg.MMGridPaperGridView";
        String str2 = "getView:index[%d], pos[%d], converrView is null[%B], parent is [%s], mClearMode[%B]";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(MMGridPaperGridView.d(this.ybt));
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Boolean.valueOf(view == null);
        objArr[3] = viewGroup.toString();
        objArr[4] = Boolean.valueOf(MMGridPaperGridView.e(this.ybt));
        x.v(str, str2, objArr);
        if (MMGridPaperGridView.e(this.ybt)) {
            view = null;
        }
        View d = MMGridPaperGridView.a(this.ybt) == null ? null : MMGridPaperGridView.a(this.ybt).d(MMGridPaperGridView.b(this.ybt) + i, view);
        if (d != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (-1 == MMGridPaperGridView.f(this.ybt) || MMGridPaperGridView.b(this.ybt) + i != MMGridPaperGridView.f(this.ybt)) {
            d.setVisibility(0);
        } else {
            d.setVisibility(4);
        }
        x.v("MicroMsg.MMGridPaperGridView", "get View ok: use %d ms, hidden index[%d], cur global index[%d]", new Object[]{Long.valueOf(bh.bA(Wq)), Integer.valueOf(MMGridPaperGridView.f(this.ybt)), Integer.valueOf(MMGridPaperGridView.b(this.ybt) + i)});
        return d;
    }
}
