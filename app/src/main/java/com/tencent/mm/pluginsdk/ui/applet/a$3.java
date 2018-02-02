package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ae.k;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.protocal.c.bsm;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

class a$3 implements OnClickListener {
    final /* synthetic */ k flZ;
    final /* synthetic */ a vmY;

    a$3(a aVar, k kVar) {
        this.vmY = aVar;
        this.flZ = kVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.d("MicroMsg.AddContact", "dealwith verify relation out of date");
        o oVar = (o) this.flZ;
        LinkedList linkedList = (oVar.gJQ == null || oVar.gJQ.Kb() == null) ? null : ((bsm) oVar.gJQ.hmg.hmo).wTO;
        List list = ((o) this.flZ).vdy;
        if (list != null && list.size() > 0) {
            this.vmY.c((String) list.get(0), linkedList);
        }
    }
}
