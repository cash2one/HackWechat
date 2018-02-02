package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

class MyGameInfoView$2 implements Runnable {
    final /* synthetic */ LinkedList nsG;
    final /* synthetic */ MyGameInfoView nwj;

    MyGameInfoView$2(MyGameInfoView myGameInfoView, LinkedList linkedList) {
        this.nwj = myGameInfoView;
        this.nsG = linkedList;
    }

    public final void run() {
        try {
            Iterator it = this.nsG.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (!MyGameInfoView.c(this.nwj).containsKey(dVar.field_appId)) {
                    MyGameInfoView.a(this.nwj, dVar);
                }
            }
        } catch (Exception e) {
            x.i("MicroMsg.MyGameInfoView", e.getMessage());
        }
    }
}
