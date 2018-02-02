package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class e$2 implements OnClickListener {
    final /* synthetic */ e nIr;

    e$2(e eVar) {
        this.nIr = eVar;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this.nIr.nIk, IPCallContactUI.class);
        this.nIr.nIk.startActivity(intent);
    }
}
