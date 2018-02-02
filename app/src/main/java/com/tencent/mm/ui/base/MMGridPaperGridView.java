package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.GridView;
import com.tencent.mm.sdk.platformtools.x;

public final class MMGridPaperGridView extends GridView {
    private int mCount;
    int mIndex;
    private OnItemClickListener rXE = new OnItemClickListener(this) {
        final /* synthetic */ MMGridPaperGridView ybt;

        {
            this.ybt = r1;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (this.ybt.ybr == null) {
                x.w("MicroMsg.MMGridPaperGridView", "on item click, but main adapter is null");
            }
        }
    };
    private int ybl;
    private int ybm;
    private int ybn;
    private int ybo = -1;
    private boolean ybp = false;
    a ybq;
    private l ybr;
    private OnItemLongClickListener ybs = new 2(this);

    public MMGridPaperGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MMGridPaperGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void a(int i, int i2, int i3, l lVar) {
        boolean z = true;
        String str = "MicroMsg.MMGridPaperGridView";
        String str2 = "index[%d], rows[%d], columns[%d], adapter is null[%B]";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(i3);
        if (lVar != null) {
            z = false;
        }
        objArr[3] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        this.mIndex = i;
        this.ybl = i2;
        this.ybm = i3;
        this.ybr = lVar;
        this.mCount = this.ybl * this.ybm;
        this.ybn = this.mIndex * this.mCount;
        if (this.ybr != null && this.ybr.getCount() - this.ybn < this.mCount) {
            this.mCount = this.ybr.getCount() - this.ybn;
        }
        if (getAdapter() == null) {
            x.w("MicroMsg.MMGridPaperGridView", "get adapter null, new one");
            this.ybq = new a(this, (byte) 0);
            setAdapter(this.ybq);
        }
        setNumColumns(this.ybm);
        setColumnWidth(3);
        setOnItemClickListener(this.rXE);
        setOnItemLongClickListener(this.ybs);
    }
}
