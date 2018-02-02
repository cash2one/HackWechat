package com.tencent.mm.plugin.product.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.product.b.m;
import java.util.ArrayList;
import java.util.Iterator;

class MallProductUI$3 implements OnItemClickListener {
    final /* synthetic */ MallProductUI phb;

    MallProductUI$3(MallProductUI mallProductUI) {
        this.phb = mallProductUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        b bVar = (b) view.getTag();
        switch (bVar.type) {
            case 2:
                m mVar = this.phb.pfH.pdK;
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
        MallProductUI.f(this.phb).a(this.phb, view, i);
    }
}
