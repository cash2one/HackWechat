package com.tencent.mm.plugin.hardwareopt.c;

import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.aka;
import com.tencent.mm.protocal.c.arc;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.vending.c.a;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b implements a<Boolean, aka> {
    private boolean nAl = false;

    public final /* synthetic */ Object call(Object obj) {
        aka com_tencent_mm_protocal_c_aka = (aka) obj;
        long longValue = ((Long) g.Dj().CU().get(w.a.xwx, Long.valueOf(-1))).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        x.i("MicroMsg.TaskReportHardwareInfo", "hy: last ticks: %d, current ticks: %d, interval: %d", new Object[]{Long.valueOf(longValue), Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis - longValue)});
        if (!this.nAl && currentTimeMillis - longValue < 86400000) {
            x.d("MicroMsg.TaskReportHardwareInfo", "hy: should not upload. too small interval");
            return Boolean.valueOf(false);
        } else if (!this.nAl && (com_tencent_mm_protocal_c_aka == null || com_tencent_mm_protocal_c_aka.wrd == null)) {
            x.w("MicroMsg.TaskReportHardwareInfo", "hy: error when finding hardware");
            com.tencent.mm.plugin.report.service.g.pQN.a(661, 1, 1, false);
            return Boolean.valueOf(false);
        } else if (this.nAl || !bh.ov(com_tencent_mm_protocal_c_aka.wrd.imei)) {
            x.i("MicroMsg.TaskReportHardwareInfo", "hy: found hardware infos. start report");
            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
            Object[] objArr = new Object[40];
            objArr[0] = com_tencent_mm_protocal_c_aka.wrd.imei;
            objArr[1] = com_tencent_mm_protocal_c_aka.wrd.vKV;
            objArr[2] = com_tencent_mm_protocal_c_aka.wrd.vKW;
            objArr[3] = com_tencent_mm_protocal_c_aka.wrd.vKX;
            objArr[4] = com_tencent_mm_protocal_c_aka.wre.vQH;
            objArr[5] = com_tencent_mm_protocal_c_aka.wre.vQF;
            objArr[6] = com_tencent_mm_protocal_c_aka.wre.vKW;
            objArr[7] = com_tencent_mm_protocal_c_aka.wre.vQI;
            objArr[8] = Integer.valueOf(com_tencent_mm_protocal_c_aka.wre.vQG);
            objArr[9] = Integer.valueOf(com_tencent_mm_protocal_c_aka.wrf.wyK);
            objArr[10] = Integer.valueOf(com_tencent_mm_protocal_c_aka.wrf.wyL);
            objArr[11] = Integer.valueOf(com_tencent_mm_protocal_c_aka.wrg.wPH);
            objArr[12] = Integer.valueOf(com_tencent_mm_protocal_c_aka.wrg.wPI ? 1 : 0);
            objArr[13] = Integer.valueOf(com_tencent_mm_protocal_c_aka.wrk.wgN ? 1 : 0);
            objArr[14] = Integer.valueOf(com_tencent_mm_protocal_c_aka.wrk.wgO ? 1 : 0);
            objArr[15] = com_tencent_mm_protocal_c_aka.wrh.wJR;
            objArr[16] = Integer.valueOf(com_tencent_mm_protocal_c_aka.wrh.density);
            objArr[17] = com_tencent_mm_protocal_c_aka.wri.vXr;
            objArr[18] = Integer.valueOf(com_tencent_mm_protocal_c_aka.wrj.wfX ? 1 : 0);
            objArr[19] = Integer.valueOf(com_tencent_mm_protocal_c_aka.wrj.wfY ? 1 : 0);
            objArr[20] = Integer.valueOf(com_tencent_mm_protocal_c_aka.wrj.wfZ ? 1 : 0);
            objArr[21] = Integer.valueOf(com_tencent_mm_protocal_c_aka.wrj.wga ? 1 : 0);
            objArr[22] = Integer.valueOf(com_tencent_mm_protocal_c_aka.wrj.wgb ? 1 : 0);
            objArr[23] = Integer.valueOf(com_tencent_mm_protocal_c_aka.wrj.wgc ? 1 : 0);
            objArr[24] = Integer.valueOf(com_tencent_mm_protocal_c_aka.wrj.wgd ? 1 : 0);
            objArr[25] = Integer.valueOf(com_tencent_mm_protocal_c_aka.wrj.wgo ? 1 : 0);
            objArr[26] = Integer.valueOf(com_tencent_mm_protocal_c_aka.wrj.wge ? 1 : 0);
            objArr[27] = Integer.valueOf(com_tencent_mm_protocal_c_aka.wrj.wgf ? 1 : 0);
            objArr[28] = Integer.valueOf(com_tencent_mm_protocal_c_aka.wrj.wgg ? 1 : 0);
            objArr[29] = Integer.valueOf(com_tencent_mm_protocal_c_aka.wrj.wgh ? 1 : 0);
            objArr[30] = Integer.valueOf(com_tencent_mm_protocal_c_aka.wrj.wgi ? 1 : 0);
            objArr[31] = Integer.valueOf(com_tencent_mm_protocal_c_aka.wrj.wgj ? 1 : 0);
            objArr[32] = Integer.valueOf(com_tencent_mm_protocal_c_aka.wrj.wgk ? 1 : 0);
            objArr[33] = Integer.valueOf(com_tencent_mm_protocal_c_aka.wrj.wgl ? 1 : 0);
            objArr[34] = Integer.valueOf(com_tencent_mm_protocal_c_aka.wrj.wgm ? 1 : 0);
            objArr[35] = Integer.valueOf(com_tencent_mm_protocal_c_aka.wrj.wgn ? 1 : 0);
            objArr[36] = Integer.valueOf(com_tencent_mm_protocal_c_aka.wrf.wyN);
            objArr[37] = Integer.valueOf(com_tencent_mm_protocal_c_aka.wrf.wyM);
            objArr[38] = com_tencent_mm_protocal_c_aka.wri.vXs;
            objArr[39] = V(com_tencent_mm_protocal_c_aka.wri.vXt);
            gVar.h(14552, objArr);
            g.Dj().CU().a(w.a.xwx, Long.valueOf(currentTimeMillis));
            com.tencent.mm.plugin.report.service.g.pQN.a(661, 0, 1, false);
            return Boolean.valueOf(true);
        } else {
            x.w("MicroMsg.TaskReportHardwareInfo", "hy: no imei detected. maybe not grant permission. ignore");
            com.tencent.mm.plugin.report.service.g.pQN.a(661, 2, 1, false);
            return Boolean.valueOf(false);
        }
    }

    public b(boolean z) {
        this.nAl = z;
    }

    private static String V(LinkedList<arc> linkedList) {
        JSONArray jSONArray = new JSONArray();
        if (linkedList != null) {
            try {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    arc com_tencent_mm_protocal_c_arc = (arc) it.next();
                    if (!(com_tencent_mm_protocal_c_arc == null || bh.ov(com_tencent_mm_protocal_c_arc.opJ))) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("mimeName", com_tencent_mm_protocal_c_arc.opJ);
                        JSONArray jSONArray2 = new JSONArray();
                        if (com_tencent_mm_protocal_c_arc.wyW != null) {
                            Iterator it2 = com_tencent_mm_protocal_c_arc.wyW.iterator();
                            while (it2.hasNext()) {
                                jSONArray2.put((String) it2.next());
                            }
                        }
                        jSONObject.put("codecName", jSONArray2);
                        jSONArray.put(jSONObject);
                    }
                }
                return jSONArray.toString();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.TaskReportHardwareInfo", e, "hy: error when build up json", new Object[0]);
                return "";
            }
        }
        x.w("MicroMsg.TaskReportHardwareInfo", "hy: no mime info retrieved!");
        return "";
    }
}
