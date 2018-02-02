package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.g.m;
import com.tencent.mm.ui.tools.l;

class e$5 implements OnItemLongClickListener {
    final /* synthetic */ e nIr;

    e$5(e eVar) {
        this.nIr = eVar;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        h hVar = this.nIr.nIi;
        if (hVar.nLq == null) {
            hVar.nLq = m.aUh();
        }
        k rD = this.nIr.nIi.rD(i - ((ListView) adapterView).getHeaderViewsCount());
        e eVar = this.nIr;
        int headerViewsCount = i - ((ListView) adapterView).getHeaderViewsCount();
        if (rD != null) {
            l lVar = new l(eVar.nIk);
            lVar.rKC = new e$8(eVar);
            lVar.rKD = new e$9(eVar, rD, headerViewsCount);
            lVar.bBX();
        }
        return true;
    }
}
