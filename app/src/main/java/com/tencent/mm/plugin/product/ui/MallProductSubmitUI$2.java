package com.tencent.mm.plugin.product.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.product.b.m;
import java.util.ArrayList;
import java.util.Iterator;

class MallProductSubmitUI$2 implements OnItemClickListener {
    final /* synthetic */ MallProductSubmitUI pgR;

    MallProductSubmitUI$2(MallProductSubmitUI mallProductSubmitUI) {
        this.pgR = mallProductSubmitUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        b bVar = (b) view.getTag();
        switch (bVar.type) {
            case 1:
                if (bVar.pfo instanceof String) {
                    MallProductSubmitUI.b(this.pgR).pdT = (String) bVar.pfo;
                    break;
                }
                break;
            case 2:
                m mVar = MallProductSubmitUI.b(this.pgR).pdK;
                if (mVar.peo.peC != null && mVar.peo.peC.size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = mVar.peo.peC.iterator();
                    while (it.hasNext()) {
                        arrayList.add((String) it.next());
                    }
                    bVar.pfo = arrayList;
                    break;
                }
        }
        MallProductSubmitUI.c(this.pgR).a(this.pgR, view, i);
    }
}
