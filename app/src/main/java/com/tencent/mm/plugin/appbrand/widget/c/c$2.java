package com.tencent.mm.plugin.appbrand.widget.c;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.protocal.c.bec;
import com.tencent.mm.sdk.platformtools.x;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

class c$2 implements OnClickListener {
    final /* synthetic */ LinkedList iVD;
    final /* synthetic */ c$a jWq;
    final /* synthetic */ b jWr;
    final /* synthetic */ c jWs;

    c$2(c cVar, LinkedList linkedList, c$a com_tencent_mm_plugin_appbrand_widget_c_c_a, b bVar) {
        this.jWs = cVar;
        this.iVD = linkedList;
        this.jWq = com_tencent_mm_plugin_appbrand_widget_c_c_a;
        this.jWr = bVar;
    }

    public final void onClick(View view) {
        Serializable arrayList = new ArrayList();
        int i = 0;
        while (i < this.iVD.size()) {
            if (((bec) this.iVD.get(i)).wJQ == 2 || ((bec) this.iVD.get(i)).wJQ == 3) {
                arrayList.add(((bec) this.iVD.get(i)).vOl);
            }
            i++;
        }
        x.i("MicroMsg.AppBrandAuthorizeDialog", "stev rejectButton click!");
        Bundle bundle = new Bundle();
        bundle.putSerializable("key_scope", arrayList);
        this.jWq.d(2, bundle);
        this.jWr.dismiss();
    }
}
