package com.tencent.mm.ui.chatting.g;

import android.view.View;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.ui.chatting.g.a.b;
import java.util.LinkedList;

class c$1 extends a {
    final /* synthetic */ LinkedList qgy;
    final /* synthetic */ c yHZ;

    c$1(c cVar, LinkedList linkedList) {
        this.yHZ = cVar;
        this.qgy = linkedList;
        super(1, null);
    }

    public final void bJ(View view) {
        a aVar = this.yHZ;
        LinkedList linkedList = this.qgy;
        if (aVar.yHV != null && aVar.yHV.get() != null) {
            ((b) aVar.yHV.get()).aA(linkedList);
        }
    }
}
