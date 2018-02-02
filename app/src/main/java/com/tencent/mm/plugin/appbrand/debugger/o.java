package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.mm.bq.a;
import com.tencent.mm.bq.b;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.plugin.appbrand.debugger.p.8;
import com.tencent.mm.protocal.c.bvi;
import com.tencent.mm.protocal.c.bvm;
import com.tencent.mm.protocal.c.bvn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.v.g;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.json.JSONObject;

public final class o {
    public static h rj(String str) {
        x.i("MicroMsg.RemoteDebugUtil", "parseRemoteDebugInfo extInfo=%s", new Object[]{str});
        h hVar = new h();
        if (!bh.ov(str)) {
            try {
                JSONObject fy = g.fy(str);
                hVar.iQr = fy.optBoolean("open_remote", false);
                hVar.iQs = fy.optString("room_id");
                hVar.iQt = fy.optString("wxpkg_info");
                hVar.iQu = fy.optString("qrcode_id");
                hVar.iQv = fy.optInt("remote_network_type", 1);
                hVar.iOl = fy.optBoolean("disable_url_check", true);
                hVar.iQw = fy.optInt("remote_proxy_port", 9976);
            } catch (Exception e) {
                x.e("MicroMsg.RemoteDebugUtil", "parseRemoteDebugInfo %s", new Object[]{e});
            }
        }
        return hVar;
    }

    public static ByteBuffer c(a aVar) {
        try {
            return ByteBuffer.wrap(aVar.toByteArray());
        } catch (IOException e) {
            x.w("MicroMsg.RemoteDebugUtil", e.getMessage());
            return ByteBuffer.allocate(0);
        }
    }

    private static b d(a aVar) {
        try {
            return b.bc(aVar.toByteArray());
        } catch (IOException e) {
            x.w("MicroMsg.RemoteDebugUtil", e.getMessage());
            return b.bc(new byte[0]);
        }
    }

    public static j a(a aVar, g gVar, String str) {
        bvn com_tencent_mm_protocal_c_bvn = new bvn();
        try {
            com_tencent_mm_protocal_c_bvn.vZC = b.bc(aVar.toByteArray());
        } catch (IOException e) {
            x.e("MicroMsg.RemoteDebugUtil", "parseDebugMessageToSend %s", new Object[]{e});
        }
        com_tencent_mm_protocal_c_bvn.hOH = gVar.iQa.incrementAndGet();
        if (gVar.iQc == 0) {
            com_tencent_mm_protocal_c_bvn.wWO = 0;
        } else {
            com_tencent_mm_protocal_c_bvn.wWO = (int) (System.currentTimeMillis() - gVar.iQc);
        }
        gVar.iQc = System.currentTimeMillis();
        com_tencent_mm_protocal_c_bvn.category = str;
        x.d("MicroMsg.RemoteDebugUtil", "parseDebugMessageToSend seq %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_bvn.hOH)});
        j jVar = new j();
        jVar.iPS = System.currentTimeMillis();
        jVar.iQH = com_tencent_mm_protocal_c_bvn.vZC.oz.length;
        jVar.iQG = com_tencent_mm_protocal_c_bvn;
        return jVar;
    }

    public static bvm a(int i, a aVar) {
        bvm com_tencent_mm_protocal_c_bvm = new bvm();
        com_tencent_mm_protocal_c_bvm.pK = i;
        com_tencent_mm_protocal_c_bvm.ned = q.getDeviceID(ac.getContext()) + "-" + System.currentTimeMillis();
        com_tencent_mm_protocal_c_bvm.vZC = d(aVar);
        return com_tencent_mm_protocal_c_bvm;
    }

    public static boolean a(g gVar, int i, bvi com_tencent_mm_protocal_c_bvi, p pVar, k kVar) {
        if (com_tencent_mm_protocal_c_bvi == null) {
            x.w("MicroMsg.RemoteDebugUtil", "handleError cmd id: %d resp is null", new Object[]{Integer.valueOf(i)});
            return false;
        }
        x.d("MicroMsg.RemoteDebugUtil", "handleError cmd id: %d, errorCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(com_tencent_mm_protocal_c_bvi.fts), com_tencent_mm_protocal_c_bvi.ftt});
        if (i == 1006) {
            if (-50011 == com_tencent_mm_protocal_c_bvi.fts) {
                gVar.cu(true);
            } else {
                boolean isBusy = gVar.isBusy();
                gVar.cu(false);
                if (isBusy) {
                    kVar.acq();
                }
            }
        }
        if (com_tencent_mm_protocal_c_bvi.fts == 0) {
            return true;
        }
        if (!(-50001 == com_tencent_mm_protocal_c_bvi.fts || -50002 == com_tencent_mm_protocal_c_bvi.fts || -50003 == com_tencent_mm_protocal_c_bvi.fts || -50004 == com_tencent_mm_protocal_c_bvi.fts || -50005 == com_tencent_mm_protocal_c_bvi.fts || -50006 == com_tencent_mm_protocal_c_bvi.fts || -50010 == com_tencent_mm_protocal_c_bvi.fts)) {
            int i2 = com_tencent_mm_protocal_c_bvi.fts;
        }
        ag.y(new 8(pVar, i, com_tencent_mm_protocal_c_bvi));
        return false;
    }
}
