package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.config.k.a;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.protocal.c.cax;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

enum l {
    ;

    static void a(int i, Bundle bundle, LinkedList<cax> linkedList) {
        a aVar;
        Collection hashSet = new HashSet();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            cax com_tencent_mm_protocal_c_cax = (cax) it.next();
            if (!bh.ov(com_tencent_mm_protocal_c_cax.username)) {
                hashSet.add(com_tencent_mm_protocal_c_cax.username);
            }
        }
        List arrayList = new ArrayList(hashSet.size());
        arrayList.addAll(hashSet);
        if (i != 3) {
            aVar = a.iOO;
        } else if (bundle == null || bundle.getInt("launcher_ui_enter_scene") != 13) {
            aVar = a.iOP;
        } else {
            aVar = a.iOR;
        }
        r.a(arrayList, aVar);
    }
}
