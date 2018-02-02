package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class a$2 implements OnClickListener {
    final /* synthetic */ String hpU;
    final /* synthetic */ a lVf;

    a$2(a aVar, String str) {
        this.lVf = aVar;
        this.hpU = str;
    }

    public final void onClick(View view) {
        Context b = a.b(this.lVf);
        Intent intent = new Intent(b, ExdeviceProfileUI.class);
        intent.putExtra("username", this.hpU);
        b.startActivity(intent);
    }
}
