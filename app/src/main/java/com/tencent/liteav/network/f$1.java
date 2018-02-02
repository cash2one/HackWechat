package com.tencent.liteav.network;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.network.f.a;
import java.util.Iterator;
import java.util.Vector;

class f$1 implements a {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ a e;
    final /* synthetic */ f f;

    f$1(f fVar, String str, String str2, String str3, String str4, a aVar) {
        this.f = fVar;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = aVar;
    }

    public void a(int i, String str, Vector<d> vector) {
        f.a(this.f, this.a);
        f.b(this.f, this.b);
        f.a(this.f, i);
        f.c(this.f, str);
        if (vector != null && !vector.isEmpty()) {
            d dVar;
            Vector vector2 = new Vector();
            Iterator it = vector.iterator();
            while (it.hasNext()) {
                dVar = (d) it.next();
                String str2 = dVar.a;
                if (str2.indexOf("?") != -1) {
                    str2 = str2.substring(0, str2.indexOf("?"));
                }
                vector2.add(new d(str2 + "?txSecret=" + this.c + "&txTime=" + this.d + "&bizid=" + this.b, dVar.b));
            }
            if (this.e != null) {
                Iterator it2 = vector2.iterator();
                while (it2.hasNext()) {
                    dVar = (d) it2.next();
                    TXCLog.e("TXRTMPAccUrlFetcher", "accurl = " + dVar.a + " quic = " + dVar.b);
                }
                this.e.a(i, str, vector2);
            }
        } else if (this.e != null) {
            this.e.a(i, str, null);
        }
    }
}
