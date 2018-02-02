package com.tencent.mm.plugin.game.model;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;

class e$1 extends af {
    e$1(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message message) {
        e$a com_tencent_mm_plugin_game_model_e_a = (e$a) message.obj;
        switch (message.what) {
            case 1:
                int netType = an.getNetType(ac.getContext());
                if (com_tencent_mm_plugin_game_model_e_a != null && netType == 0) {
                    boolean ca = f.aAd().ca(com_tencent_mm_plugin_game_model_e_a.fmZ);
                    if (!ca) {
                        f.aAd().bX(com_tencent_mm_plugin_game_model_e_a.fmZ);
                        if (com_tencent_mm_plugin_game_model_e_a.nbq != null) {
                            e.c(com_tencent_mm_plugin_game_model_e_a.nbq);
                        }
                    }
                    x.i("MicroMsg.GameAutoDownloader", "resumeTask, ret = " + ca);
                    return;
                }
                return;
            case 2:
                if (com_tencent_mm_plugin_game_model_e_a != null) {
                    f.aAd().bX(com_tencent_mm_plugin_game_model_e_a.fmZ);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
