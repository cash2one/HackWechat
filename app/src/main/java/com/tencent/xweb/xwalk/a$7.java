package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.xweb.k;

class a$7 implements OnClickListener {
    final /* synthetic */ a Asx;
    final /* synthetic */ Button Asz;

    a$7(a aVar, Button button) {
        this.Asx = aVar;
        this.Asz = button;
    }

    public final void onClick(View view) {
        k.cIo().oc(!k.cIo().Aql);
        this.Asz.setText(k.cIo().Aql ? "使用正式版config" : "使用测试config");
    }
}
