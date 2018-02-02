package com.tencent.mm.plugin.hp.b;

import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.g.a.hz;
import com.tencent.mm.protocal.b.a.a;
import com.tencent.mm.sdk.b.b;
import java.util.LinkedList;

class i$1 implements Runnable {
    final /* synthetic */ String icx;
    final /* synthetic */ String nAR;
    final /* synthetic */ String nAS;
    final /* synthetic */ String nAT;
    final /* synthetic */ OnClickListener nAU;
    final /* synthetic */ OnClickListener nAV;

    i$1(String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2) {
        this.icx = str;
        this.nAR = str2;
        this.nAS = str3;
        this.nAT = str4;
        this.nAU = onClickListener;
        this.nAV = onClickListener2;
    }

    public final void run() {
        b hzVar = new hz();
        com.tencent.mm.protocal.b.a.b bVar = new com.tencent.mm.protocal.b.a.b();
        bVar.title = this.icx;
        bVar.fpb = this.nAR;
        bVar.vCS = new LinkedList();
        a aVar = new a();
        aVar.vCQ = this.nAS;
        bVar.vCS.add(aVar);
        aVar = new a();
        aVar.vCQ = this.nAT;
        bVar.vCS.add(aVar);
        hzVar.fyu.type = 1;
        hzVar.fyu.fyv = bVar;
        hzVar.fyu.fyw = this.nAU;
        hzVar.fyu.fyx = this.nAV;
        com.tencent.mm.sdk.b.a.xef.m(hzVar);
    }
}
