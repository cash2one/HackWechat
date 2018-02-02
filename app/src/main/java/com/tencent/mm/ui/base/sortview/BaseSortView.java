package com.tencent.mm.ui.base.sortview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseSortView extends LinearLayout implements a {
    private OnItemSelectedListener Gu;
    public OnItemClickListener XC;
    private ListView kHk;
    public int mMode;
    private VerticalScrollBar yjX;
    private View yjY;
    public c yjZ = new c(asy());
    public OnItemLongClickListener yka;
    private List<d> ykb = new ArrayList();
    public boolean ykc;
    public boolean ykd;
    public a yke;

    public abstract boolean a(String str, d dVar);

    public abstract VerticalScrollBar asw();

    public abstract View asx();

    public abstract c$a asy();

    public abstract ListView getListView();

    public abstract View inflate();

    public BaseSortView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        inflate();
        this.yjX = asw();
        this.kHk = getListView();
        this.yjY = asx();
        this.ykc = true;
        my(true);
        this.kHk.setAdapter(this.yjZ);
        if (this.yjX != null) {
            this.yjX.yhE = this;
        }
        this.yjZ.registerDataSetObserver(new 1(this));
        this.kHk.setOnItemClickListener(new 2(this));
        this.kHk.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ BaseSortView ykf;

            {
                this.ykf = r1;
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.ykf.yka != null) {
                    return this.ykf.yka.onItemLongClick(adapterView, view, i, j);
                }
                return false;
            }
        });
        this.kHk.setOnItemSelectedListener(new 4(this));
    }

    public void refresh() {
        ag.y(this.yjZ.yki);
    }

    public final void cZ(List<d> list) {
        if (this.mMode == 0 && this.ykb != list) {
            this.ykb.clear();
            if (list != null) {
                this.ykb.addAll(list);
            }
        }
        this.yjZ.cZ(list);
    }

    public final void YR(String str) {
        boolean z = true;
        if (this.mMode != 1) {
            x.w("MicroMsg.BaseSortView", "Can't doFilter successfully out of the search mode.");
            return;
        }
        boolean z2;
        boolean z3;
        List arrayList = new ArrayList();
        if (bh.ov(str)) {
            z2 = false;
        } else {
            arrayList.clear();
            for (d dVar : this.ykb) {
                if (a(str, dVar)) {
                    arrayList.add(dVar);
                }
            }
            z2 = true;
        }
        View view = this.kHk;
        if (!z2 || arrayList.size() <= 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        n(view, z3);
        View view2 = this.yjY;
        if (!z2 || arrayList.size() > 0) {
            z = false;
        }
        n(view2, z);
        cZ(arrayList);
    }

    public final void xh(String str) {
        int YS = this.yjZ.YS(str);
        if (YS >= 0) {
            this.kHk.setSelection(YS);
        }
    }

    public final void cqr() {
        this.mMode = 1;
        YR("");
    }

    public static void n(View view, boolean z) {
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public final void my(boolean z) {
        this.ykd = z;
        if (this.yjX != null) {
            this.yjX.setVisibility(z ? 0 : 8);
        }
    }

    public final void cqs() {
        this.ykc = false;
        ag.y(this.yjZ.yki);
    }
}
