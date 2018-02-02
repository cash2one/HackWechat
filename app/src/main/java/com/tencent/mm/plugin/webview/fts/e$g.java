package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.a.e;
import com.tencent.mm.protocal.c.apy;
import com.tencent.mm.protocal.c.bxi;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.File;

class e$g {
    public String fwM;
    public int scene;
    public long suO;
    public long tmC;

    public e$g() {
        this.scene = 0;
        this.fwM = "";
        this.suO = 0;
        this.tmC = 0;
    }

    public e$g(bxi com_tencent_mm_protocal_c_bxi) {
        this.scene = 0;
        this.fwM = "";
        this.suO = 0;
        this.tmC = 0;
        this.scene = 201;
        this.fwM = com_tencent_mm_protocal_c_bxi.fwM;
        this.suO = (long) com_tencent_mm_protocal_c_bxi.hXU;
        this.tmC = System.currentTimeMillis() / 1000;
    }

    public static e$g zY(int i) {
        ar.Hg();
        File file = new File(c.Fn(), zZ(201));
        byte[] d = e.d(file.getAbsolutePath(), 0, (int) file.length());
        try {
            apy com_tencent_mm_protocal_c_apy = new apy();
            com_tencent_mm_protocal_c_apy.aF(d);
            e$g com_tencent_mm_plugin_webview_fts_e_g = new e$g();
            try {
                com_tencent_mm_plugin_webview_fts_e_g.scene = com_tencent_mm_protocal_c_apy.rYW;
                com_tencent_mm_plugin_webview_fts_e_g.fwM = com_tencent_mm_protocal_c_apy.vOe;
                com_tencent_mm_plugin_webview_fts_e_g.suO = com_tencent_mm_protocal_c_apy.wwG;
                com_tencent_mm_plugin_webview_fts_e_g.tmC = com_tencent_mm_protocal_c_apy.wwF;
                return com_tencent_mm_plugin_webview_fts_e_g;
            } catch (Exception e) {
                return com_tencent_mm_plugin_webview_fts_e_g;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    static String zZ(int i) {
        return "SearchGuide_" + i + "-" + w.eL(ac.getContext());
    }

    public final boolean bPi() {
        return this.tmC + this.suO <= System.currentTimeMillis() / 1000;
    }
}
