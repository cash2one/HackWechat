package com.tencent.mm.plugin.welab.ui;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.plugin.welab.a.c;
import com.tencent.mm.plugin.welab.ui.WelabAppInfoUI.b;
import java.util.List;

class WelabAppInfoUI$a extends a<b> {
    public List<String> lli;
    final /* synthetic */ WelabAppInfoUI tPR;

    public final /* synthetic */ t a(ViewGroup viewGroup, int i) {
        View inflate = this.tPR.getLayoutInflater().inflate(c.tPn, viewGroup, false);
        t bVar = new b(this.tPR, inflate);
        bVar.tPS = (ImageView) inflate.findViewById(com.tencent.mm.plugin.welab.a.b.tPc);
        bVar.tPS.setOnClickListener(WelabAppInfoUI.d(this.tPR));
        return bVar;
    }

    public final /* synthetic */ void a(t tVar, int i) {
        b bVar = (b) tVar;
        bVar.tPS.setTag(this.lli.get(i));
        com.tencent.mm.aq.a.a.PH().a((String) this.lli.get(i), bVar.tPS, com.tencent.mm.plugin.welab.b.bVu().tlo);
    }

    public WelabAppInfoUI$a(WelabAppInfoUI welabAppInfoUI) {
        this.tPR = welabAppInfoUI;
    }

    public final int getItemCount() {
        return this.lli.size();
    }
}
