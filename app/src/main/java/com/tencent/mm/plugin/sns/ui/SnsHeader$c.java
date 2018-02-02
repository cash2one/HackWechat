package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.storage.m;
import java.util.Comparator;

class SnsHeader$c implements Comparator<m> {
    final /* synthetic */ SnsHeader rBL;

    SnsHeader$c(SnsHeader snsHeader) {
        this.rBL = snsHeader;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        m mVar = (m) obj;
        m mVar2 = (m) obj2;
        if (mVar.field_createTime == mVar2.field_createTime) {
            return 0;
        }
        return mVar.field_createTime > mVar2.field_createTime ? -1 : 1;
    }
}
