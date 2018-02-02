package com.tencent.mm.ae;

import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.util.concurrent.ConcurrentHashMap;

public interface d {

    public static class a {
        public bw hmq;
        public boolean hmr = false;
        public boolean hms = false;
        public boolean hmt = false;

        public a(bw bwVar, boolean z, boolean z2, boolean z3) {
            this.hmq = bwVar;
            this.hmr = z;
            this.hms = z2;
            this.hmt = z3;
        }

        public final String toString() {
            return String.format("AddMsgInfo(%d), get[%b], fault[%b], up[%b]", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(this.hmr), Boolean.valueOf(this.hms), Boolean.valueOf(this.hmt)});
        }
    }

    public static class b {
        public au fnB;
        public boolean hmu;

        public b(au auVar, boolean z) {
            this.fnB = auVar;
            this.hmu = z;
        }
    }

    public static class c {
        private static ConcurrentHashMap<Object, d> hmv = new ConcurrentHashMap();

        public static void a(Object obj, d dVar) {
            x.i("MicroMsg.IMessageExtension.Factory", "registerExtensionFor %s, %s", obj, dVar);
            hmv.put(obj, dVar);
        }

        public static void b(Object obj, d dVar) {
            x.i("MicroMsg.IMessageExtension.Factory", "unregisterExtensionFor %s, %s", obj, dVar);
            hmv.remove(obj);
        }

        public static d aU(Object obj) {
            return (d) hmv.get(obj);
        }
    }

    b b(a aVar);

    void h(au auVar);
}
