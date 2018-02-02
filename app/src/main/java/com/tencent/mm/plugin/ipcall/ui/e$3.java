package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class e$3 implements OnClickListener {
    final /* synthetic */ e nIr;

    e$3(e eVar) {
        this.nIr = eVar;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.nIr.nIk, IPCallDialUI.class);
        intent.putExtra("IPCallTalkUI_dialScene", 1);
        this.nIr.nIk.startActivityForResult(intent, 1001);
    }
}
