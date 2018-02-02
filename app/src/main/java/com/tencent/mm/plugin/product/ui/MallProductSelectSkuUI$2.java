package com.tencent.mm.plugin.product.ui;

import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.plugin.product.b.e;
import com.tencent.mm.sdk.platformtools.x;

class MallProductSelectSkuUI$2 implements OnItemClickListener {
    final /* synthetic */ MallProductSelectSkuUI pgr;

    MallProductSelectSkuUI$2(MallProductSelectSkuUI mallProductSelectSkuUI) {
        this.pgr = mallProductSelectSkuUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        e eVar = null;
        Pair pair = (Pair) view.getTag();
        MallProductSelectSkuUI mallProductSelectSkuUI = this.pgr;
        c b = MallProductSelectSkuUI.b(this.pgr);
        String str = (String) pair.first;
        String str2 = (String) pair.second;
        x.d("MicroMsg.MallProductManager", "selectSkuInfo (" + str + " , " + str2 + ")");
        if (b.pdW.containsKey(str) && ((String) b.pdW.get(str)).equals(str2)) {
            b.pdW.remove(str);
            b.pdO = c.L(b.pdW);
            b.pdZ = b.pdV != null ? (e) b.pdV.get(b.pdO) : null;
        } else {
            b.pdW.put(str, str2);
            b.pdO = c.L(b.pdW);
            x.d("MicroMsg.MallProductManager", "getSkuInfoId (" + b.pdO + ")");
            if (b.pdV != null) {
                b.pdZ = (e) b.pdV.get(b.pdO);
            }
            MallProductSelectSkuUI.a(mallProductSelectSkuUI, eVar);
            MallProductSelectSkuUI.a(this.pgr);
        }
        b.bje();
        eVar = b.pdZ;
        MallProductSelectSkuUI.a(mallProductSelectSkuUI, eVar);
        MallProductSelectSkuUI.a(this.pgr);
    }
}
