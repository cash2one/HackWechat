package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.aq.o;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.ui.contact.a.a.b;

public class a$b extends b {
    final /* synthetic */ a ynm;

    public a$b(a aVar) {
        this.ynm = aVar;
        super(aVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate;
        if (a.ey(context)) {
            inflate = LayoutInflater.from(context).inflate(f.qfz, viewGroup, false);
        } else {
            inflate = LayoutInflater.from(context).inflate(f.qfy, viewGroup, false);
        }
        a.a aVar = this.ynm.ynl;
        aVar.iip = (ImageView) inflate.findViewById(e.bLL);
        aVar.kBH = (TextView) inflate.findViewById(e.cSu);
        aVar.iir = (TextView) inflate.findViewById(e.caS);
        aVar.iir.setVisibility(8);
        inflate.setTag(aVar);
        return inflate;
    }

    public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, com.tencent.mm.ui.contact.a.a aVar2, boolean z, boolean z2) {
        a aVar3 = (a) aVar2;
        a.a aVar4 = (a.a) aVar;
        com.tencent.mm.plugin.fts.d.e.a(aVar3.iil, aVar4.kBH);
        o.PA().a(aVar3.yni, aVar4.iip, a.YV(aVar3.username));
    }

    public final boolean WS() {
        return false;
    }
}
