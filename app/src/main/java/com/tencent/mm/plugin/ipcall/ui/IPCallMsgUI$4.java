package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.ipcall.a.g.g;
import com.tencent.mm.sdk.platformtools.bh;

class IPCallMsgUI$4 implements OnItemClickListener {
    final /* synthetic */ IPCallMsgUI nKK;

    IPCallMsgUI$4(IPCallMsgUI iPCallMsgUI) {
        this.nKK = iPCallMsgUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        g gVar = (g) IPCallMsgUI.b(this.nKK).getItem(i);
        if (!bh.ov(gVar.field_descUrl)) {
            int i2 = gVar.field_msgType;
            com.tencent.mm.plugin.report.service.g.pQN.h(13780, new Object[]{Integer.valueOf(i2)});
            Intent intent = new Intent();
            intent.putExtra("rawUrl", gVar.field_descUrl);
            intent.putExtra("showShare", false);
            d.b(this.nKK, "webview", ".ui.tools.WebViewUI", intent);
        }
    }
}
