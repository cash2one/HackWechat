package com.tencent.mm.plugin.music.model;

import com.tencent.mm.g.a.fv;
import com.tencent.mm.g.a.jr;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

class e$a implements Runnable {
    final /* synthetic */ e oJL;

    private e$a(e eVar) {
        this.oJL = eVar;
    }

    public final void run() {
        List list;
        long currentTimeMillis = System.currentTimeMillis();
        this.oJL.oJJ = true;
        asv bdp = this.oJL.bdp();
        List arrayList = new ArrayList();
        x.i("MicroMsg.Music.MusicPlayerManager", "musicWrapper.MusicType:%d", new Object[]{Integer.valueOf(bdp.wAi)});
        b jrVar;
        switch (bdp.wAi) {
            case 1:
                jrVar = new jr();
                jrVar.fAt.action = -5;
                a.xef.m(jrVar);
                list = jrVar.fAu.fvF;
                break;
            case 4:
                jrVar = new jr();
                jrVar.fAt.action = -4;
                a.xef.m(jrVar);
                list = jrVar.fAu.fvF;
                break;
            case 6:
                jrVar = new fv();
                jrVar.fvq.type = 18;
                a.xef.m(jrVar);
                list = jrVar.fvr.fvF;
                break;
            case 8:
                jrVar = new jr();
                jrVar.fAt.action = -6;
                jrVar.fAt.fAv = bdp;
                a.xef.m(jrVar);
                list = jrVar.fAu.fvF;
                break;
            default:
                list = null;
                break;
        }
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                asv com_tencent_mm_protocal_c_asv = (asv) list.get(i);
                if (com_tencent_mm_protocal_c_asv == null) {
                    x.e("MicroMsg.Music.MusicPlayerManager", "wrapper is null, continue");
                } else {
                    h.bdA().x(com_tencent_mm_protocal_c_asv);
                    arrayList.add(g.i(com_tencent_mm_protocal_c_asv));
                }
            }
        }
        x.i("MicroMsg.Music.MusicPlayerManager", "GetMusicWrapperListTask run time %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        this.oJL.oJJ = false;
        Runnable com_tencent_mm_plugin_music_model_e_b = new e$b(this.oJL);
        com_tencent_mm_plugin_music_model_e_b.oJM = arrayList;
        ag.y(com_tencent_mm_plugin_music_model_e_b);
    }
}
