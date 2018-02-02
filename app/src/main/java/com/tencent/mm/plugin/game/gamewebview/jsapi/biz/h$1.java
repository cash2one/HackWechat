package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Intent;
import com.tencent.mm.plugin.game.gamewebview.ui.GameWebViewUI;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

class h$1 implements a {
    final /* synthetic */ int gOK;
    final /* synthetic */ GameWebViewUI mWD;
    final /* synthetic */ h mWE;
    final /* synthetic */ d mWr;

    h$1(h hVar, d dVar, int i, GameWebViewUI gameWebViewUI) {
        this.mWE = hVar;
        this.mWr = dVar;
        this.gOK = i;
        this.mWD = gameWebViewUI;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(int i, int i2, Intent intent) {
        if (i == 14) {
            boolean z;
            if (intent == null) {
                z = false;
            } else {
                z = intent.getBooleanExtra("key_pick_local_media_show_memory_warning", false);
            }
            x.i("MicroMsg.GameJsApiChooseImage", "request to open file chooser, result code = %d, hasShowMemoryWarning = %b", new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)});
            Map hashMap = new HashMap();
            if (z) {
                hashMap.put("memoryWarning", Boolean.valueOf(true));
            }
            switch (i2) {
                case -1:
                    String stringExtra = intent != null ? intent.getStringExtra("key_pick_local_pic_callback_local_ids") : null;
                    if (!bh.ov(stringExtra)) {
                        x.i("MicroMsg.GameJsApiChooseImage", "localIds = %s", new Object[]{stringExtra});
                        hashMap.put("localIds", stringExtra);
                        stringExtra = intent.getStringExtra("key_pick_local_pic_source_type");
                        if (stringExtra != null) {
                            hashMap.put("sourceType", stringExtra);
                        }
                        this.mWr.E(this.gOK, h.e("chooseImage:ok", hashMap));
                        break;
                    }
                case 0:
                    this.mWr.E(this.gOK, h.e("chooseImage:cancel", hashMap));
                    break;
                default:
                    this.mWr.E(this.gOK, h.e("chooseImage:fail", hashMap));
                    break;
            }
            this.mWD.jwN = null;
        }
    }
}
