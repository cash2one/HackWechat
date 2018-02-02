package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.protocal.c.bec;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.k;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

class h$1 implements OnClickListener {
    final /* synthetic */ LinkedList iVD;
    final /* synthetic */ k iVF;
    final /* synthetic */ h$a tKH;
    final /* synthetic */ h tKI;

    h$1(h hVar, LinkedList linkedList, h$a com_tencent_mm_plugin_webview_ui_tools_widget_h_a, k kVar) {
        this.tKI = hVar;
        this.iVD = linkedList;
        this.tKH = com_tencent_mm_plugin_webview_ui_tools_widget_h_a;
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
        x.d("MicroMsg.AppBrandAuthorizeDialog", "stev acceptButton click!");
        Bundle bundle = new Bundle();
        bundle.putSerializable("key_scope", arrayList);
        this.tKH.d(1, bundle);
        this.iVF.dismiss();
    }
}
