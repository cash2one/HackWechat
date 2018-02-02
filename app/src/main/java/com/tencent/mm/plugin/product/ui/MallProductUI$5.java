package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.product.b.n.a;
import com.tencent.mm.sdk.platformtools.x;

class MallProductUI$5 implements OnItemClickListener {
    final /* synthetic */ MallProductUI phb;

    MallProductUI$5(MallProductUI mallProductUI) {
        this.phb = mallProductUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        m mVar = (m) view.getTag();
        f e = MallProductUI.e(this.phb);
        if (mVar != null && mVar.pgE != null) {
            a aVar = mVar.pgE;
            x.i("MicroMsg.MallProductUI", "goProductUI type : " + aVar.type);
            Intent intent;
            switch (aVar.type) {
                case 0:
                    intent = new Intent();
                    intent.putExtra("rawUrl", aVar.url);
                    d.b(e.iQz, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                    return;
                case 1:
                    String replace = aVar.data.replace("product_id=", "");
                    intent = new Intent();
                    intent.putExtra("key_product_id", replace);
                    intent.putExtra("key_product_scene", 6);
                    d.b(e.iQz, "mall", ".product.ui.MallProductUI", intent);
                    e.iQz.finish();
                    return;
                default:
                    return;
            }
        }
    }
}
