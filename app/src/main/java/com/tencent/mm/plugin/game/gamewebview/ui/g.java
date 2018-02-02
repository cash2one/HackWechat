package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.plugin.game.gamewebview.ipc.CommonLogicTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.a;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.c;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.d;
import com.tencent.mm.protocal.c.ajq;
import com.tencent.mm.protocal.c.aqy;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g extends i {
    private Map<Integer, aqy> mZV = new HashMap();

    public g(b bVar) {
        super(bVar);
    }

    public final void aPz() {
        if (bh.ov(getBundle().getString("game_hv_menu_appid"))) {
            super.aPz();
            return;
        }
        d dVar = new d(this.mYx);
        dVar.a(new 1(this));
        dVar.tGf = new 2(this);
        if (this.mZP.isFullScreen()) {
            dVar.tGk = true;
            dVar.tGl = true;
        } else {
            dVar.tGk = false;
            dVar.tGl = false;
        }
        if (this.mZP.mWG.mYP.isShown()) {
            this.mZP.mWG.fy(false);
            ag.h(new 3(this, dVar), 100);
            return;
        }
        this.mYx.aWs();
        ag.h(new 4(this, dVar), 100);
    }

    private n aPA() {
        try {
            List list;
            List list2 = a.tFL;
            GWMainProcessTask commonLogicTask = new CommonLogicTask();
            commonLogicTask.type = 9;
            commonLogicTask.msB.putString("game_hv_menu_appid", getBundle().getString("game_hv_menu_appid"));
            GameWebViewMainProcessService.b(commonLogicTask);
            String string = commonLogicTask.msB.getString("game_hv_menu_pbcache");
            if (!bh.ov(string)) {
                byte[] bytes = string.getBytes("ISO-8859-1");
                ajq com_tencent_mm_protocal_c_ajq = new ajq();
                com_tencent_mm_protocal_c_ajq.aF(bytes);
                if (!bh.cA(com_tencent_mm_protocal_c_ajq.wqI)) {
                    LinkedList linkedList = com_tencent_mm_protocal_c_ajq.wqI;
                    x.i("MicroMsg.GameWebViewMenuHelp", "use net menu data");
                    list = linkedList;
                    this.mZV.clear();
                    for (aqy com_tencent_mm_protocal_c_aqy : r1) {
                        this.mZV.put(Integer.valueOf(com_tencent_mm_protocal_c_aqy.wyO), com_tencent_mm_protocal_c_aqy);
                    }
                    return c.bUj().i(r1, Vb());
                }
            }
            list = list2;
            this.mZV.clear();
            for (aqy com_tencent_mm_protocal_c_aqy2 : r1) {
                this.mZV.put(Integer.valueOf(com_tencent_mm_protocal_c_aqy2.wyO), com_tencent_mm_protocal_c_aqy2);
            }
            return c.bUj().i(r1, Vb());
        } catch (Exception e) {
            x.e("MicroMsg.GameWebViewMenuHelp", "get cache hv game menu fail! exception:%s", e.getMessage());
            return null;
        }
    }
}
