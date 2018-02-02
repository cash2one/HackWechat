package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.ui.contact.a.a.b;
import com.tencent.mm.ui.contact.a.g.a;

public class g$b extends b {
    final /* synthetic */ g yVx;

    public g$b(g gVar) {
        this.yVx = gVar;
        super(gVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(f.qfB, viewGroup, false);
        a aVar = this.yVx.yVw;
        aVar.lgs = (TextView) inflate.findViewById(e.cox);
        inflate.setTag(aVar);
        return inflate;
    }

    public final void a(Context context, a.a aVar, a aVar2, boolean z, boolean z2) {
        com.tencent.mm.plugin.fts.d.e.a(((g) aVar2).mPH, ((a) aVar).lgs);
    }

    public final boolean WS() {
        return false;
    }
}
