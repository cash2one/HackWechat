package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.mmsight.ui.SightSettingsUI.a;
import com.tencent.mm.plugin.mmsight.ui.SightSettingsUI.b;
import com.tencent.mm.plugin.mmsight.ui.SightSettingsUI.b.1;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;

class SightSettingsUI$a$1 implements OnClickListener {
    final /* synthetic */ b oDn;
    final /* synthetic */ a oDo;

    SightSettingsUI$a$1(a aVar, b bVar) {
        this.oDo = aVar;
        this.oDn = bVar;
    }

    public final void onClick(View view) {
        b bVar = this.oDn;
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        for (int i = 0; i < bVar.oDq.length; i++) {
            linkedList.add(bVar.oDq[i]);
            linkedList2.add(Integer.valueOf(i));
        }
        h.a(bVar.oDm, "", linkedList, linkedList2, "", new 1(bVar));
    }
}
