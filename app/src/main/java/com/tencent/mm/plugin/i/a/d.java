package com.tencent.mm.plugin.i.a;

import com.tencent.mm.aq.e;
import com.tencent.mm.aq.o;
import com.tencent.mm.plugin.i.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.util.ArrayList;
import java.util.List;

public final class d extends a {
    protected final List<a> J(au auVar) {
        if (auVar == null) {
            return null;
        }
        e n = o.Pw().n(auVar);
        if (n == null || n.hzP == 0) {
            x.w("MicroMsg.ImageMsgHandler", "%s can not get imgInfo", new Object[]{asP()});
            return null;
        }
        long j;
        a K;
        a K2;
        a K3;
        a K4;
        a K5;
        a K6;
        List<a> arrayList;
        String m = o.Pw().m(n.hzQ, "", "");
        long bN = (long) com.tencent.mm.a.e.bN(m);
        String m2 = o.Pw().m(n.hzS, "", "");
        long bN2 = (long) com.tencent.mm.a.e.bN(m2);
        String str = o.Pw().m(n.hzS, "", "") + "hd";
        long bN3 = (long) com.tencent.mm.a.e.bN(str);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        long j2 = 0;
        long j3 = 0;
        if (n.Pe()) {
            n = o.Pw().hQ(n.hzZ);
            if (n != null) {
                str2 = o.Pw().m(n.hzQ, "", "");
                if (!bh.fu(str2, m)) {
                    j2 = (long) com.tencent.mm.a.e.bN(str2);
                }
                str3 = o.Pw().m(n.hzS, "", "");
                if (!bh.fu(str3, m2)) {
                    j3 = (long) com.tencent.mm.a.e.bN(str3);
                }
                str4 = o.Pw().m(n.hzS, "", "") + "hd";
                if (!bh.fu(str4, str)) {
                    j = j2;
                    j2 = (long) com.tencent.mm.a.e.bN(str4);
                    K = a.K(auVar);
                    K.field_msgSubType = 20;
                    K.field_path = vS(m);
                    K.field_size = bN;
                    K2 = a.K(auVar);
                    K2.field_msgSubType = 21;
                    K2.field_path = vS(m2);
                    K2.field_size = bN2;
                    K3 = a.K(auVar);
                    K3.field_msgSubType = 22;
                    K3.field_path = vS(str);
                    K3.field_size = bN3;
                    K4 = a.K(auVar);
                    K4.field_msgSubType = 23;
                    K4.field_path = vS(str2);
                    K4.field_size = j;
                    K5 = a.K(auVar);
                    K5.field_msgSubType = 24;
                    K5.field_path = vS(str3);
                    K5.field_size = j3;
                    K6 = a.K(auVar);
                    K6.field_msgSubType = 25;
                    K6.field_path = vS(str4);
                    K6.field_size = j2;
                    x.i("MicroMsg.ImageMsgHandler", "%s create image wx file index bigItem[%s] thumb[%s][%s] hd[%s %s %s]", new Object[]{asP(), K, K2, K3, K4, K5, K6});
                    arrayList = new ArrayList();
                    arrayList.add(K);
                    arrayList.add(K2);
                    arrayList.add(K3);
                    arrayList.add(K4);
                    arrayList.add(K5);
                    arrayList.add(K6);
                    return arrayList;
                }
            }
        }
        j = j2;
        j2 = 0;
        K = a.K(auVar);
        K.field_msgSubType = 20;
        K.field_path = vS(m);
        K.field_size = bN;
        K2 = a.K(auVar);
        K2.field_msgSubType = 21;
        K2.field_path = vS(m2);
        K2.field_size = bN2;
        K3 = a.K(auVar);
        K3.field_msgSubType = 22;
        K3.field_path = vS(str);
        K3.field_size = bN3;
        K4 = a.K(auVar);
        K4.field_msgSubType = 23;
        K4.field_path = vS(str2);
        K4.field_size = j;
        K5 = a.K(auVar);
        K5.field_msgSubType = 24;
        K5.field_path = vS(str3);
        K5.field_size = j3;
        K6 = a.K(auVar);
        K6.field_msgSubType = 25;
        K6.field_path = vS(str4);
        K6.field_size = j2;
        x.i("MicroMsg.ImageMsgHandler", "%s create image wx file index bigItem[%s] thumb[%s][%s] hd[%s %s %s]", new Object[]{asP(), K, K2, K3, K4, K5, K6});
        arrayList = new ArrayList();
        arrayList.add(K);
        arrayList.add(K2);
        arrayList.add(K3);
        arrayList.add(K4);
        arrayList.add(K5);
        arrayList.add(K6);
        return arrayList;
    }

    protected final String asP() {
        return "image_" + hashCode();
    }
}
