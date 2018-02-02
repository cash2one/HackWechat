package com.tencent.mm.plugin.sns.ui.b;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.data.b;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.plugin.sns.storage.a$b.a;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.sdk.platformtools.x;

class b$24 implements OnItemClickListener {
    final /* synthetic */ b rPY;

    b$24(b bVar) {
        this.rPY = bVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view.getTag() != null && (view.getTag() instanceof b)) {
            b bVar = (b) view.getTag();
            if (i < bVar.qQI.rMn.ref.bws().size() && !bVar.qQI.rMn.rej) {
                a aVar = (a) bVar.qQI.rMn.ref.bws().get(i);
                x.i("MicroMsg.TimelineClickListener", "unlike item click, reason=%s, id=%s", new Object[]{aVar.rep, Integer.valueOf(aVar.res)});
                m Lm = ae.bvv().Lm(bVar.frH);
                if (Lm != null) {
                    aVar.qQK = bVar.qQK;
                    aVar.reu = System.currentTimeMillis();
                    k qVar = new q(Lm.field_snsId, 8, aVar);
                    g.Dk();
                    g.Di().gPJ.a(qVar, 0);
                    this.rPY.cG(view);
                }
            }
        }
    }
}
