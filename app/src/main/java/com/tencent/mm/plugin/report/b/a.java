package com.tencent.mm.plugin.report.b;

import com.tencent.mm.a.e;
import com.tencent.mm.protocal.c.akd;
import com.tencent.mm.protocal.c.aso;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.util.Iterator;

public final class a {
    private static String filename = "heavy_user_id_mapping.dat";
    private static Object lock = new Object();
    private a pPO;
    private int pPP;
    private int pPQ;
    private int pPR;
    private int pPS;

    public interface a {
    }

    public a() {
        this.pPO = null;
        this.pPP = 0;
        this.pPQ = 1;
        this.pPR = 2;
        this.pPS = 3;
        this.pPO = null;
    }

    private static void a(akd com_tencent_mm_protocal_c_akd, boolean z) {
        Iterator it;
        if (z) {
            x.i("MicroMsg.HeavyUserIDMappingStg", "################################# svr heavy user strategy #############################");
            x.i("MicroMsg.HeavyUserIDMappingStg", "svr_version:" + com_tencent_mm_protocal_c_akd.wrm + ", ret:" + com_tencent_mm_protocal_c_akd.wro);
            it = com_tencent_mm_protocal_c_akd.wrn.iterator();
            while (it.hasNext()) {
                aso com_tencent_mm_protocal_c_aso = (aso) it.next();
                x.i("MicroMsg.HeavyUserIDMappingStg", "origin:" + com_tencent_mm_protocal_c_aso.wAe + ", userid:" + com_tencent_mm_protocal_c_aso.wAf);
            }
            x.i("MicroMsg.HeavyUserIDMappingStg", "#################################  End ################################################");
            return;
        }
        x.d("MicroMsg.HeavyUserIDMappingStg", "################################# Local heavy user strategy #############################");
        x.d("MicroMsg.HeavyUserIDMappingStg", "svr_version:" + com_tencent_mm_protocal_c_akd.wrm + ", ret:" + com_tencent_mm_protocal_c_akd.wro);
        it = com_tencent_mm_protocal_c_akd.wrn.iterator();
        while (it.hasNext()) {
            com_tencent_mm_protocal_c_aso = (aso) it.next();
            x.d("MicroMsg.HeavyUserIDMappingStg", "origin:" + com_tencent_mm_protocal_c_aso.wAe + ", userid:" + com_tencent_mm_protocal_c_aso.wAf);
        }
        x.d("MicroMsg.HeavyUserIDMappingStg", "#################################  End ################################################");
    }

    public final void a(akd com_tencent_mm_protocal_c_akd, int i) {
        x.i("MicroMsg.HeavyUserIDMappingStg", "saveIDMapping, channel:" + i);
        if (com_tencent_mm_protocal_c_akd == null) {
            x.w("MicroMsg.HeavyUserIDMappingStg", "HeavyUserRespInfo is null");
        } else if (this.pPP != com_tencent_mm_protocal_c_akd.wro) {
            String str = "MicroMsg.HeavyUserIDMappingStg";
            StringBuilder stringBuilder = new StringBuilder("heavyUserRespInfo.RespType Unnormal, type:");
            r0 = com_tencent_mm_protocal_c_akd.wro;
            String str2 = this.pPQ == r0 ? "服务器过载" : this.pPR == r0 ? "服务器没有配置表" : this.pPS == r0 ? "服务器配置表错误" : "非法的错误类型";
            x.e(str, stringBuilder.append(str2).append(",version:").append(com_tencent_mm_protocal_c_akd.wrm).toString());
        } else {
            r0 = vx(i);
            int i2 = com_tencent_mm_protocal_c_akd.wrm;
            if (r0 == i2) {
                x.d("MicroMsg.HeavyUserIDMappingStg", "client has same version with Srv, version:" + i2);
                return;
            }
            x.i("MicroMsg.HeavyUserIDMappingStg", "version changed, client:" + vx(i) + ", svr:" + i2);
            a(com_tencent_mm_protocal_c_akd, true);
            try {
                byte[] toByteArray = com_tencent_mm_protocal_c_akd.toByteArray();
                synchronized (lock) {
                    x.i("MicroMsg.HeavyUserIDMappingStg", "new version:" + com_tencent_mm_protocal_c_akd.wrm);
                    e.a(w.gZK, filename, toByteArray);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.HeavyUserIDMappingStg", e, "", new Object[0]);
            }
        }
    }

    public static akd bob() {
        x.d("MicroMsg.HeavyUserIDMappingStg", "getIDMappingObj");
        synchronized (lock) {
            byte[] e = e.e(w.gZK + filename, 0, -1);
        }
        if (e == null) {
            x.w("MicroMsg.HeavyUserIDMappingStg", "get file content fail, filename" + filename);
            return null;
        }
        akd com_tencent_mm_protocal_c_akd = new akd();
        try {
            com_tencent_mm_protocal_c_akd.aF(e);
            a(com_tencent_mm_protocal_c_akd, false);
            return com_tencent_mm_protocal_c_akd;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.HeavyUserIDMappingStg", e2, "", new Object[0]);
            return null;
        }
    }

    public final int vx(int i) {
        x.d("MicroMsg.HeavyUserIDMappingStg", "getIDMappingVersion,chanel:" + i);
        akd bob = bob();
        if (bob == null) {
            return 0;
        }
        int i2 = bob.wrm;
        x.i("MicroMsg.HeavyUserIDMappingStg", "version:" + i2);
        return i2;
    }
}
