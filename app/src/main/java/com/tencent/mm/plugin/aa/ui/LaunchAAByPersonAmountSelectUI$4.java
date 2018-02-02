package com.tencent.mm.plugin.aa.ui;

import com.tencent.mm.plugin.aa.a.c.c.a;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.v;
import com.tencent.mm.vending.app.a.b;
import java.util.HashMap;

class LaunchAAByPersonAmountSelectUI$4 implements b<a> {
    final /* synthetic */ LaunchAAByPersonAmountSelectUI ijj;
    final /* synthetic */ HashMap ijl;

    LaunchAAByPersonAmountSelectUI$4(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI, HashMap hashMap) {
        this.ijj = launchAAByPersonAmountSelectUI;
        this.ijl = hashMap;
    }

    public final /* synthetic */ void aX(Object obj) {
        a aVar = (a) obj;
        String str = "MicroMsg.LaunchAAByPersonAmountSelectUI";
        String str2 = "get selectMembers: %s, list.size: %s";
        Object[] objArr = new Object[2];
        objArr[0] = aVar;
        objArr[1] = aVar != null ? Integer.valueOf(aVar.gIW.size()) : "0";
        x.i(str, str2, objArr);
        LaunchAAByPersonAmountSelectUI.f(this.ijj).addFooterView(v.fv(this.ijj).inflate(g.uAQ, null));
        LaunchAAByPersonAmountSelectUI.f(this.ijj).addHeaderView(v.fv(this.ijj).inflate(g.uAW, null));
        if (!(aVar == null || aVar.gIW == null || aVar.gIW.size() <= 0)) {
            LaunchAAByPersonAmountSelectUI.a(this.ijj, new LaunchAAByPersonAmountSelectUI.a(this.ijj, aVar.gIW, this.ijl));
            LaunchAAByPersonAmountSelectUI.f(this.ijj).setAdapter(LaunchAAByPersonAmountSelectUI.g(this.ijj));
        }
        LaunchAAByPersonAmountSelectUI.h(this.ijj).setVisibility(0);
        LaunchAAByPersonAmountSelectUI.j(this.ijj).post(LaunchAAByPersonAmountSelectUI.i(this.ijj));
    }
}
