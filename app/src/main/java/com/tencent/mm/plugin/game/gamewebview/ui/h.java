package com.tencent.mm.plugin.game.gamewebview.ui;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.webkit.WebView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.e.b;
import com.tencent.mm.plugin.game.gamewebview.ipc.CommonActivityTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.CommonLogicTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.plugin.webview.modeltools.g.c;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.l;
import com.tencent.xweb.WebView.a;

public final class h implements OnCreateContextMenuListener {
    private MMActivity iqt;
    public l juS;
    String juT;
    public int juU;
    public int juV;
    public g juW;
    a juX;
    a juY;
    private c jvc = new 1(this);
    private b mYN;
    private e mYW;

    static /* synthetic */ void a(h hVar, String str) {
        CommonActivityTask commonActivityTask = new CommonActivityTask(hVar.iqt);
        commonActivityTask.type = 2;
        commonActivityTask.msB.putString("img_path", str);
        commonActivityTask.aKE();
    }

    static /* synthetic */ void b(h hVar, String str) {
        GWMainProcessTask commonLogicTask = new CommonLogicTask();
        commonLogicTask.type = 7;
        commonLogicTask.msB.putString("image_path", str);
        GameWebViewMainProcessService.b(commonLogicTask);
        com.tencent.mm.pluginsdk.model.c.a(commonLogicTask.msB.getInt("fav_simple_img_result"), 34, hVar.iqt, i.nah);
    }

    static /* synthetic */ String c(h hVar) {
        return hVar.mYN != null ? hVar.mYN.getUrl() : "";
    }

    public h(MMActivity mMActivity, b bVar, e eVar) {
        this.iqt = mMActivity;
        this.mYN = bVar;
        this.mYW = eVar;
        this.juS = new l(mMActivity);
        this.juS.a(this.mYN, this, null);
        this.juS.e(new 2(this));
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        x.d("MicroMsg.GameWebViewMenuListHelper", "onCreateContextMenu");
        a hitTestResult;
        if (view instanceof WebView) {
            hitTestResult = this.mYN.getHitTestResult();
            if (hitTestResult != null) {
                if (hitTestResult.mType == 5 || hitTestResult.mType == 8) {
                    b(contextMenu, hitTestResult);
                    return;
                }
                return;
            }
            return;
        }
        hitTestResult = this.mYN.getHitTestResult();
        if (hitTestResult == null) {
            return;
        }
        if (hitTestResult.mType == 5 || hitTestResult.mType == 8) {
            a(contextMenu, hitTestResult);
        }
    }

    private boolean a(ContextMenu contextMenu, String str) {
        if (f.ze()) {
            boolean aOD = d.aOD();
            contextMenu.setHeaderTitle(R.l.eYq);
            x.i("MicroMsg.GameWebViewMenuListHelper", "hasSetAcc = %b", Boolean.valueOf(aOD));
            if (aOD) {
                contextMenu.add(0, 0, 0, this.iqt.getString(R.l.eBK)).setOnMenuItemClickListener(new 4(this, str));
            }
            contextMenu.add(0, 0, 0, this.iqt.getString(R.l.eHg)).setOnMenuItemClickListener(new 5(this, str));
            if (aOD) {
                contextMenu.add(0, 0, 0, this.iqt.getString(R.l.eAd)).setOnMenuItemClickListener(new 6(this, str));
            }
            if (this.juT == null) {
                return false;
            }
            CharSequence string;
            String str2 = this.juT;
            if (this.juU == 22) {
                string = this.iqt.getString(R.l.eCr);
            } else {
                string = this.iqt.getString(R.l.eCq);
            }
            contextMenu.add(0, 0, 0, string).setOnMenuItemClickListener(new 7(this, str2));
            this.juT = null;
            return true;
        }
        x.e("MicroMsg.GameWebViewMenuListHelper", "SD card unavailable");
        return true;
    }

    final void a(ContextMenu contextMenu, a aVar) {
        if (!a(contextMenu, aVar.mExtra) && this.mYW.bSt().cdB() && aPB()) {
            this.juY = aVar;
            this.juW = new g();
            this.juW.a(this.mYN, this.jvc);
        }
    }

    final void b(ContextMenu contextMenu, a aVar) {
        if (!a(contextMenu, aVar.mExtra) && this.mYW.bSt().cdB() && aPB()) {
            this.juX = aVar;
            this.juW = new g();
            this.juW.a(this.mYN, this.jvc);
        }
    }

    private static boolean aPB() {
        GWMainProcessTask commonLogicTask = new CommonLogicTask();
        commonLogicTask.type = 5;
        GameWebViewMainProcessService.b(commonLogicTask);
        return commonLogicTask.msB.getBoolean("allow_webview_scan", false);
    }
}
