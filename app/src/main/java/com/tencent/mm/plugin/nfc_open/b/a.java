package com.tencent.mm.plugin.nfc_open.b;

import android.content.ComponentName;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.nfc_open.a.b;
import com.tencent.mm.protocal.c.atk;
import com.tencent.mm.protocal.c.kf;
import com.tencent.mm.protocal.c.ok;
import com.tencent.mm.protocal.c.ph;
import com.tencent.mm.protocal.c.pi;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;

public final class a implements e {
    public atk oSh;

    public a() {
        init();
    }

    private void init() {
        this.oSh = new atk();
        ar.Hg();
        String valueOf = String.valueOf(c.CU().get(com.tencent.mm.storage.w.a.USERINFO_NFC_CPU_CARD_CONFIG_STRING, null));
        if (bh.ov(valueOf)) {
            this.oSh.vYo = new LinkedList();
            this.oSh.lastUpdateTime = 0;
            this.oSh.vYp = 86400;
            this.oSh.version = 0;
            return;
        }
        try {
            this.oSh.aF(valueOf.getBytes("ISO-8859-1"));
        } catch (Exception e) {
            x.w("MicroMsg.CpuCardConfigManager", "parseConfig exp, " + e.getLocalizedMessage());
            this.oSh.vYo = new LinkedList();
            this.oSh.lastUpdateTime = 0;
            this.oSh.vYp = 86400;
            this.oSh.version = 0;
        }
    }

    private void a(atk com_tencent_mm_protocal_c_atk) {
        if (!ar.Hj()) {
            x.i("MicroMsg.CpuCardConfigManager", "setConfig account not ready");
        } else if (com_tencent_mm_protocal_c_atk != null) {
            x.i("MicroMsg.CpuCardConfigManager", "setConfig config");
            this.oSh = com_tencent_mm_protocal_c_atk;
            try {
                Object str = new String(this.oSh.toByteArray(), "ISO-8859-1");
                ar.Hg();
                c.CU().a(com.tencent.mm.storage.w.a.USERINFO_NFC_CPU_CARD_CONFIG_STRING, str);
            } catch (UnsupportedEncodingException e) {
                x.w("MicroMsg.CpuCardConfigManager", "save config exp, " + e.getLocalizedMessage());
            } catch (IOException e2) {
                x.w("MicroMsg.CpuCardConfigManager", "save config exp, " + e2.getLocalizedMessage());
            }
        }
    }

    private atk bfy() {
        if (this.oSh == null) {
            init();
        }
        return this.oSh;
    }

    public final void a(int i, int i2, String str, k kVar) {
        ar.CG().b(1561, (e) this);
        if (kVar instanceof b) {
            atk bfy = bfy();
            bfy.lastUpdateTime = bh.Wo();
            if (i == 0 && i2 == 0) {
                ph phVar = (ph) ((b) kVar).gJQ.hmh.hmo;
                if (phVar != null) {
                    bfy.vYp = phVar.vYp;
                    bfy.vYq = phVar.vYq;
                    ar.Hg();
                    if (((Integer) c.CU().get(com.tencent.mm.storage.w.a.USERINFO_NFC_OPEN_SWITCH_INT_SYNC, Integer.valueOf(0))).intValue() == 0) {
                        if (phVar.vYq == 1) {
                            ac.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(ac.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
                        } else {
                            ac.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(ac.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
                        }
                    }
                    ar.Hg();
                    c.CU().a(com.tencent.mm.storage.w.a.USERINFO_NFC_OPEN_DEFAULT_SWITCH_INT_SYNC, Integer.valueOf(phVar.vYq));
                    ar.Hg();
                    c.CU().a(com.tencent.mm.storage.w.a.USERINFO_NFC_OPEN_SWITCH_WORDING_STRING_SYNC, phVar.sIT);
                    if (bfy.version == phVar.version) {
                        x.i("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd no config change return version = " + phVar.version);
                        a(bfy);
                        return;
                    }
                    bfy.version = phVar.version;
                    if (phVar.vYo == null || phVar.vYo.isEmpty()) {
                        bfy.vYo.clear();
                    } else {
                        if (bfy.vYo == null) {
                            bfy.vYo = new LinkedList();
                        } else {
                            bfy.vYo.clear();
                        }
                        for (int i3 = 0; i3 < phVar.vYo.size(); i3++) {
                            kf kfVar = new kf();
                            kfVar.vDi = ((kf) phVar.vYo.get(i3)).vDi;
                            kfVar.vQV = ((kf) phVar.vYo.get(i3)).vQV;
                            x.d("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd sflag=" + bh.e(Integer.valueOf(kfVar.vQV)) + ", url=" + bh.ou(kfVar.vDi));
                            if (kfVar.vQU == null) {
                                kfVar.vQU = new LinkedList();
                            } else {
                                kfVar.vQU.clear();
                            }
                            for (int i4 = 0; i4 < ((kf) phVar.vYo.get(i3)).vQU.size(); i4++) {
                                pi piVar = new pi();
                                if (piVar.vYr == null) {
                                    piVar.vYr = new LinkedList();
                                } else {
                                    piVar.vYr.clear();
                                }
                                for (int i5 = 0; i5 < ((pi) ((kf) phVar.vYo.get(i3)).vQU.get(i4)).vYr.size(); i5++) {
                                    ok okVar = new ok();
                                    okVar.vXo = ((ok) ((pi) ((kf) phVar.vYo.get(i3)).vQU.get(i4)).vYr.get(i5)).vXo;
                                    okVar.ocF = ((ok) ((pi) ((kf) phVar.vYo.get(i3)).vQU.get(i4)).vYr.get(i5)).ocF;
                                    x.d("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd cmd=" + bh.ou(okVar.vXo) + ", answer=" + bh.ou(okVar.ocF));
                                    piVar.vYr.add(okVar);
                                }
                                kfVar.vQU.add(piVar);
                            }
                            bfy.vYo.add(kfVar);
                        }
                    }
                }
            }
            a(bfy);
        }
    }
}
