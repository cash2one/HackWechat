package com.tencent.mm.ui.gridviewheaders;

import android.database.DataSetObserver;

class c$1 extends DataSetObserver {
    final /* synthetic */ c zeG;

    c$1(c cVar) {
        this.zeG = cVar;
    }

    public final void onChanged() {
        int i = 0;
        c cVar = this.zeG;
        cVar.mCount = 0;
        int cxl = cVar.zeC.cxl();
        if (cxl == 0) {
            cVar.mCount = cVar.zeC.getCount();
        } else {
            while (i < cxl) {
                cVar.mCount += cVar.zeC.Gz(i) + cVar.mNumColumns;
                i++;
            }
        }
        this.zeG.notifyDataSetChanged();
    }

    public final void onInvalidated() {
        c.a(this.zeG).clear();
        this.zeG.notifyDataSetInvalidated();
    }
}
