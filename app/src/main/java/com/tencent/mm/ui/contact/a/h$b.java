package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.selectcontact.a$f;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.ui.contact.a.a.b;
import com.tencent.mm.ui.contact.a.h.a;

public class h$b extends b {
    final /* synthetic */ h yVA;

    public h$b(h hVar) {
        this.yVA = hVar;
        super(hVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(a$f.qfC, viewGroup, false);
        a aVar = (a) this.yVA.yVz;
        aVar.mPP = (TextView) inflate.findViewById(e.cpO);
        inflate.setTag(aVar);
        return inflate;
    }

    public final void a(Context context, a.a aVar, a aVar2, boolean z, boolean z2) {
        com.tencent.mm.plugin.fts.d.e.a(h.a(this.yVA), ((a) aVar).mPP);
    }

    public final boolean WS() {
        return false;
    }
}
