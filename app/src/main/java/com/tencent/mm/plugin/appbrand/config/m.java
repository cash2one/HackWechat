package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.ae.u;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.protocal.c.xu;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.xw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class m {

    public static class a {
        private static String ap(String str, int i) {
            return String.format("%s_%s_local_version", new Object[]{str, Integer.valueOf(i)});
        }

        public static String aq(String str, int i) {
            return String.format("%s_%s_server_version", new Object[]{str, Integer.valueOf(i)});
        }

        private static String ar(String str, int i) {
            return String.format("%s_%s_config", new Object[]{str, Integer.valueOf(i)});
        }

        public static void w(String str, int i, int i2) {
            if (f.Zl() != null) {
                f.Zl().aV(ap(str, i), String.valueOf(i2));
            }
        }

        public static void x(String str, int i, int i2) {
            if (f.Zl() != null) {
                f.Zl().aV(aq(str, i), String.valueOf(i2));
            }
        }

        public static void g(String str, int i, String str2) {
            if (f.Zl() != null) {
                f.Zl().aV(ar(str, i), str2);
            }
        }

        public static int as(String str, int i) {
            if (f.Zl() == null) {
                return 0;
            }
            return bh.getInt(f.Zl().get(ap(str, i), "0"), 0);
        }

        public static String at(String str, int i) {
            if (f.Zl() == null) {
                return "";
            }
            return f.Zl().get(ar(str, i), "");
        }
    }

    public interface b {
        void a(int i, int i2, String str, com.tencent.mm.ae.b bVar);
    }

    public interface c {
        void pL(String str);
    }

    public static void a(String str, LinkedList<bsu> linkedList) {
        a(str, linkedList, true);
    }

    public static void a(String str, LinkedList<bsu> linkedList, boolean z) {
        if (bh.ov(str)) {
            x.e("MicroMsg.CommonConfigManager", "setVersion, app_id is null");
        } else if (linkedList == null || linkedList.size() == 0) {
            x.e("MicroMsg.CommonConfigManager", "setVersion, versionItems is empty");
        } else {
            LinkedList linkedList2 = new LinkedList();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                bsu com_tencent_mm_protocal_c_bsu = (bsu) it.next();
                x.d("MicroMsg.CommonConfigManager", "versionItem.version:%d,version.type:%d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bsu.version), Integer.valueOf(com_tencent_mm_protocal_c_bsu.type)});
                int as = a.as(str, com_tencent_mm_protocal_c_bsu.type);
                int i = com_tencent_mm_protocal_c_bsu.version;
                a.x(str, com_tencent_mm_protocal_c_bsu.type, i);
                if (i != 0) {
                    if (i > as) {
                        linkedList2.add(v(str, com_tencent_mm_protocal_c_bsu.type, com_tencent_mm_protocal_c_bsu.version));
                    } else if (i != as) {
                        x.i("MicroMsg.CommonConfigManager", "local_version:%d, server_version:%d", new Object[]{Integer.valueOf(as), Integer.valueOf(i)});
                        if (bh.ov(a.at(str, com_tencent_mm_protocal_c_bsu.type))) {
                            linkedList2.add(v(str, com_tencent_mm_protocal_c_bsu.type, com_tencent_mm_protocal_c_bsu.version));
                        }
                    } else if (bh.ov(a.at(str, com_tencent_mm_protocal_c_bsu.type))) {
                        linkedList2.add(v(str, com_tencent_mm_protocal_c_bsu.type, com_tencent_mm_protocal_c_bsu.version));
                    }
                }
            }
            x.i("MicroMsg.CommonConfigManager", "setVersion appid:%s,versionItems.size:%d,getAppConfigItems.size:%d", new Object[]{str, Integer.valueOf(linkedList.size()), Integer.valueOf(linkedList2.size())});
            if (z && linkedList2.size() != 0) {
                x.d("MicroMsg.CommonConfigManager", "setVersion appid:%s, need sync from server", new Object[]{str});
                a(linkedList2, new 1(str));
            }
        }
    }

    private static xu v(String str, int i, int i2) {
        xu xuVar = new xu();
        xuVar.ngo = str;
        xuVar.ktN = i;
        xuVar.vHI = i2;
        return xuVar;
    }

    public static String a(String str, int i, int i2, c cVar, boolean z) {
        if (f.Zl() == null) {
            return "";
        }
        boolean z2;
        int as = a.as(str, i);
        int i3 = f.Zl() == null ? 0 : bh.getInt(f.Zl().get(a.aq(str, i), "0"), 0);
        String at = a.at(str, i);
        if (i3 == 0 || (!bh.ov(at) && i3 <= as)) {
            z2 = false;
        } else {
            z2 = true;
        }
        x.i("MicroMsg.CommonConfigManager", "getConfig the server_version is %d ,the local_version is %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(as)});
        x.i("MicroMsg.CommonConfigManager", "the config is \n %s \n isShouldSyncFromServer:%b", new Object[]{at, Boolean.valueOf(z2)});
        if (z2) {
            b 2 = new 2(cVar, str);
            LinkedList linkedList = new LinkedList();
            xu xuVar = new xu();
            xuVar.ngo = str;
            xuVar.ktN = i;
            xuVar.vHI = i3;
            xuVar.wiq = i2;
            linkedList.add(xuVar);
            a(linkedList, 2);
        } else {
            cVar.pL(at);
        }
        return at;
    }

    private static void a(LinkedList<xu> linkedList, b bVar) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmi = 1138;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getappconfig";
        aVar.hmk = new xw();
        aVar.hml = 0;
        aVar.hmm = 0;
        com.tencent.mm.bq.a xvVar = new xv();
        xvVar.wir = linkedList;
        aVar.hmj = xvVar;
        u.a(aVar.JZ(), new 3(bVar), true);
    }
}
