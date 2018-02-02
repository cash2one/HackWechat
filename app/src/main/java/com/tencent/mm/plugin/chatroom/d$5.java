package com.tencent.mm.plugin.chatroom;

import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.jv;
import com.tencent.mm.plugin.chatroom.d.f;
import com.tencent.mm.pluginsdk.d.c;
import com.tencent.mm.sdk.b.b;

class d$5 extends c<jv> {
    final /* synthetic */ d kYZ;

    d$5(d dVar) {
        this.kYZ = dVar;
    }

    public final /* bridge */ /* synthetic */ b a(int i, k kVar, b bVar) {
        jv jvVar = (jv) bVar;
        f fVar = (f) kVar;
        jvVar.fAL.fAO = fVar.fAO;
        jvVar.fAL.fAP = fVar.fAP;
        jvVar.fAL.fAQ = fVar.fAQ;
        jvVar.fAL.fAR = fVar.kZm;
        jvVar.fAL.fAU = fVar.fAU;
        jvVar.fAL.fAS = fVar.fAS;
        jvVar.fAL.fAT = fVar.fAT;
        return jvVar;
    }

    public final /* synthetic */ boolean a(b bVar) {
        jv jvVar = (jv) bVar;
        if (jvVar.fAK.fAJ) {
            c.k(jvVar);
        } else {
            l(jvVar);
        }
        return false;
    }

    public final /* synthetic */ k b(b bVar) {
        jv jvVar = (jv) bVar;
        return new f(jvVar.fAK.fAM, jvVar.fAK.fAN);
    }

    public final int axw() {
        return 119;
    }
}
