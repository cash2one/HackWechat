package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.appbrand.jsapi.i.c.1;
import java.util.HashMap;
import java.util.Map;

class c$1$2 implements OnClickListener {
    final /* synthetic */ 1 jqd;

    c$1$2(1 1) {
        this.jqd = 1;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Map hashMap = new HashMap();
        hashMap.put("confirm", Boolean.valueOf(false));
        hashMap.put("cancel", Boolean.valueOf(true));
        dialogInterface.dismiss();
        this.jqd.iZy.E(this.jqd.gOK, this.jqd.jqc.e("ok", hashMap));
    }
}
