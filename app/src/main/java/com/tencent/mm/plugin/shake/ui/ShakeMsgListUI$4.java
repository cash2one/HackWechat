package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.b.f;
import com.tencent.mm.sdk.platformtools.bh;

class ShakeMsgListUI$4 implements OnItemClickListener {
    final /* synthetic */ ShakeMsgListUI qqQ;

    ShakeMsgListUI$4(ShakeMsgListUI shakeMsgListUI) {
        this.qqQ = shakeMsgListUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        f fVar = (f) ShakeMsgListUI.b(this.qqQ).getItem(i);
        if (!bh.ov(fVar.field_tag)) {
            g.pQN.k(11316, ShakeMsgListUI.g(this.qqQ) + "," + fVar.field_tag);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", fVar.field_tag);
            d.b(this.qqQ.mController.xIM, "webview", ".ui.tools.WebViewUI", intent);
        }
    }
}
