package com.tencent.mm.plugin.welab.ui;

import com.tencent.mm.plugin.welab.c.a.a;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.Comparator;

class WelabMainUI$3 implements Comparator<a> {
    final /* synthetic */ WelabMainUI tQc;

    WelabMainUI$3(WelabMainUI welabMainUI) {
        this.tQc = welabMainUI;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        a aVar = (a) obj;
        a aVar2 = (a) obj2;
        if (aVar == aVar2) {
            return 0;
        }
        if (aVar != null) {
            if (aVar2 == null) {
                return 1;
            }
            if (aVar.field_Pos == aVar2.field_Pos) {
                int VI = bh.VI(aVar.field_expId);
                int VI2 = bh.VI(aVar2.field_expId);
                if (VI != VI2) {
                    return VI2 > VI ? 1 : -1;
                } else {
                    return 0;
                }
            } else if (aVar.field_Pos > aVar2.field_Pos) {
                return 1;
            }
        }
        return -1;
    }
}
