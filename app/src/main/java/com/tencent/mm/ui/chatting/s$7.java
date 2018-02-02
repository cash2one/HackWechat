package com.tencent.mm.ui.chatting;

import com.tencent.mm.storage.au;
import java.util.Comparator;

class s$7 implements Comparator<au> {
    final /* synthetic */ s ytT;

    s$7(s sVar) {
        this.ytT = sVar;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        return (int) (((au) obj).field_createTime - ((au) obj2).field_createTime);
    }
}
