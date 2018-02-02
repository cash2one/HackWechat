package com.tencent.mm.plugin.appbrand.widget.c;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.widget.c.c.a;
import com.tencent.mm.protocal.c.bec;
import com.tencent.mm.sdk.platformtools.x;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

class c$1 implements OnClickListener {
    final /* synthetic */ LinkedList iVD;
    final /* synthetic */ a jWq;
    final /* synthetic */ b jWr;
    final /* synthetic */ c jWs;

    c$1(c cVar, LinkedList linkedList, a aVar, b bVar) {
        this.jWs = cVar;
        this.iVD = linkedList;
        this.jWq = aVar;
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
        x.i("MicroMsg.AppBrandAuthorizeDialog", "stev acceptButton click!");
        Bundle bundle = new Bundle();
        bundle.putSerializable("key_scope", arrayList);
        this.jWq.d(1, bundle);
        this.jWr.dismiss();
    }
}
