package com.tencent.mm.plugin.aj;

import android.content.ComponentName;
import android.content.Intent;
import com.tencent.mm.plugin.aj.a.g;
import com.tencent.mm.plugin.aj.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.e.h;
import com.tencent.xweb.WebView;
import java.util.HashMap;
import java.util.Map;

public class d {
    private static d tjz;
    private ag hOa;
    private boolean tju = false;
    private boolean tjv = false;
    private Boolean tjw;
    private a tjx = new a();
    private Map<Integer, e> tjy;

    private d() {
    }

    public static d bOL() {
        if (tjz == null) {
            synchronized (d.class) {
                if (tjz == null) {
                    tjz = new d();
                }
            }
        }
        return tjz;
    }

    public final a zF(int i) {
        if (i <= 0) {
            return this.tjx;
        }
        if (this.tjy == null) {
            this.tjy = new HashMap();
        }
        e eVar = (e) this.tjy.get(Integer.valueOf(i));
        if (eVar != null) {
            return eVar;
        }
        a eVar2 = new e(i);
        this.tjy.put(Integer.valueOf(i), eVar2);
        return eVar2;
    }

    public final void cu(String str, int i) {
        if (ac.cfy()) {
            zF(i).NR(str);
            return;
        }
        boolean bOM;
        if (this.hOa == null) {
            this.hOa = new ag();
        }
        this.hOa.F(new 1(this));
        switch (i) {
            case 1:
                bOM = bOM();
                break;
            case 2:
                bOM = bON();
                break;
            case 3:
                bOM = bOM();
                break;
            default:
                x.w("MicroMsg.WebViewPreLoadExport", "unknown preload biz %d", new Object[]{Integer.valueOf(i)});
                bOM = false;
                break;
        }
        if (bOM) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(h.xEp, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
            intent.putExtra("tools_param_preload_url", str);
            intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_PRELOAD_SEARCH");
            intent.putExtra("tools_param_preload_search_biz", i);
            ac.getContext().sendBroadcast(intent);
            return;
        }
        x.i("MicroMsg.WebViewPreLoadExport", "preload switch close , biz %d, url %s", new Object[]{Integer.valueOf(i), str});
    }

    public final void ke(boolean z) {
        this.tjw = Boolean.valueOf(z);
    }

    public final boolean bOM() {
        if (this.tjw != null) {
            x.i("MicroMsg.WebViewPreLoadExport", "openSearchPreload cmdPreloadSwitch %b", new Object[]{this.tjw});
            return this.tjw.booleanValue();
        } else if (WebView.getTbsCoreVersion(ac.getContext()) == 0) {
            x.i("MicroMsg.WebViewPreLoadExport", "openSearchPreload without x5");
            return false;
        } else if (!com.tencent.xweb.x5.sdk.d.canOpenWebPlus(ac.getContext())) {
            x.i("MicroMsg.WebViewPreLoadExport", "openSearchPreload can not OpenWebPlus");
            return false;
        } else if (g.zN(0) >= 80007181) {
            return this.tju;
        } else {
            x.e("MicroMsg.WebViewPreLoadExport", "current search template not support preload");
            return false;
        }
    }

    public final boolean bON() {
        if (this.tjw != null) {
            x.i("MicroMsg.WebViewPreLoadExport", "isOpenRecommendPreload cmdPreloadSwitch %b", new Object[]{this.tjw});
            return this.tjw.booleanValue();
        } else if (WebView.getTbsCoreVersion(ac.getContext()) == 0) {
            x.i("MicroMsg.WebViewPreLoadExport", "isOpenRecommendPreload without x5");
            return false;
        } else if (com.tencent.xweb.x5.sdk.d.canOpenWebPlus(ac.getContext())) {
            return this.tjv;
        } else {
            x.i("MicroMsg.WebViewPreLoadExport", "isOpenRecommendPreload can not OpenWebPlus");
            return false;
        }
    }
}
