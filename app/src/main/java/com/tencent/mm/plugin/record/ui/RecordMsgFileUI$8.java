package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;

class RecordMsgFileUI$8 implements OnClickListener {
    final /* synthetic */ String mws;
    final /* synthetic */ RecordMsgFileUI pGq;

    RecordMsgFileUI$8(RecordMsgFileUI recordMsgFileUI, String str) {
        this.pGq = recordMsgFileUI;
        this.mws = str;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.mws);
        d.b(this.pGq.mController.xIM, "webview", ".ui.tools.WebViewUI", intent);
    }
}
