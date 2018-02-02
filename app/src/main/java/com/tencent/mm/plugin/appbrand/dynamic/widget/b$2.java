package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.dynamic.widget.b.a;
import com.tencent.mm.protocal.c.bec;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.k;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

class b$2 implements OnClickListener {
    final /* synthetic */ LinkedList iVD;
    final /* synthetic */ a iVE;
    final /* synthetic */ k iVF;
    final /* synthetic */ b iVG;

    b$2(b bVar, LinkedList linkedList, a aVar, k kVar) {
        this.iVG = bVar;
        this.iVD = linkedList;
        this.iVE = aVar;
        this.iVF = kVar;
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
        x.d("MicroMsg.AppBrandAuthorizeDialog", "stev rejectButton click!");
        Bundle bundle = new Bundle();
        bundle.putSerializable("key_scope", arrayList);
        this.iVE.d(2, bundle);
        this.iVF.dismiss();
    }
}
