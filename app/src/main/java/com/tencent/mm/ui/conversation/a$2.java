package com.tencent.mm.ui.conversation;

import com.tencent.mm.pluginsdk.ui.b.b;
import java.util.Comparator;

class a$2 implements Comparator<b> {
    final /* synthetic */ a yVT;

    a$2(a aVar) {
        this.yVT = aVar;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((b) obj2).getOrder() - ((b) obj).getOrder();
    }
}
