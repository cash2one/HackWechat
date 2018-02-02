package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.storage.m;
import java.util.Comparator;

class au$1 implements Comparator<m> {
    final /* synthetic */ au rFT;

    au$1(au auVar) {
        this.rFT = auVar;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        m mVar = (m) obj;
        m mVar2 = (m) obj2;
        if (mVar.roJ == -1) {
            return -1;
        }
        if (mVar2.roJ == -1) {
            return 1;
        }
        if (mVar.field_head != mVar2.field_head) {
            return mVar2.field_head - mVar.field_head;
        }
        return mVar.field_createTime != mVar2.field_createTime ? mVar2.field_createTime - mVar.field_createTime : 0;
    }
}
