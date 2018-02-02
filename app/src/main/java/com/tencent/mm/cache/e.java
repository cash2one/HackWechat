package com.tencent.mm.cache;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public interface e {

    public static class a {
        private static Map<String, e> gBy = new HashMap();

        public static void a(String str, e eVar) {
            gBy.put(str, eVar);
        }

        private static e eD(String str) {
            return (e) gBy.get(str);
        }

        public static <T> T D(String str, String str2) {
            return a(eD(str), str2, null);
        }

        public static <T> void a(String str, String str2, T t) {
            e eD = eD(str);
            if (eD == null) {
                x.e("MicroMsg.ICacheService.Factory", "null service");
            } else {
                eD.n(str2, t);
            }
        }

        public static <T> void E(String str, String str2) {
            a(eD(str), str2);
        }

        private static <T> T a(e eVar, String str, T t) {
            T t2 = null;
            if (eVar == null) {
                x.e("MicroMsg.ICacheService.Factory", "null service");
            } else {
                try {
                    t2 = eVar.get(str);
                } catch (Throwable e) {
                    x.e("MicroMsg.ICacheService.Factory", "cast failed, different type ?");
                    x.e("MicroMsg.ICacheService.Factory", "exception:%s", bh.i(e));
                }
            }
            return t2;
        }

        private static <T> T a(e eVar, String str) {
            T t = null;
            if (eVar == null) {
                x.e("MicroMsg.ICacheService.Factory", "null service");
            } else {
                try {
                    t = eVar.remove(str);
                } catch (Throwable e) {
                    x.e("MicroMsg.ICacheService.Factory", "cast failed, different type ?");
                    x.e("MicroMsg.ICacheService.Factory", "exception:%s", bh.i(e));
                }
            }
            return t;
        }
    }

    Object get(Object obj);

    void n(Object obj, Object obj2);

    Object remove(Object obj);
}
