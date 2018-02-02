package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.plugin.selectcontact.a.d;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.ui.contact.a.a.a;
import com.tencent.mm.ui.contact.a.j.b;

public class j$a extends a$b {
    final /* synthetic */ j yVF;

    public j$a(j jVar) {
        this.yVF = jVar;
        super(jVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(f.qfE, viewGroup, false);
        b bVar = this.yVF.yVE;
        bVar.iiq = (TextView) inflate.findViewById(e.cSu);
        bVar.contentView = inflate.findViewById(e.cKR);
        bVar.iis = (CheckBox) inflate.findViewById(e.cKI);
        inflate.setTag(bVar);
        return inflate;
    }

    public final void a(Context context, a aVar, a aVar2, boolean z, boolean z2) {
        b bVar = (b) aVar;
        bVar.iiq.setText(h.qfO);
        bVar.iis.setBackgroundResource(d.qfm);
        bVar.iis.setChecked(z2);
        bVar.iis.setEnabled(true);
        bVar.iis.setVisibility(0);
        bVar.contentView.setBackgroundResource(d.bBy);
    }

    public final boolean WS() {
        return false;
    }
}
