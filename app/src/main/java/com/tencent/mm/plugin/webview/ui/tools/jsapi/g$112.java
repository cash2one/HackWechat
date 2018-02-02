package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.modeltools.d.a;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class g$112 implements a {
    final /* synthetic */ i tIF;
    final /* synthetic */ g tIj;

    g$112(g gVar, i iVar) {
        this.tIj = gVar;
        this.tIF = iVar;
    }

    public final void a(String str, JSONObject jSONObject, Bitmap bitmap) {
        if (bitmap == null) {
            g.a(this.tIj, this.tIF, "chooseIdCard:fail", null);
            return;
        }
        try {
            String str2 = e.gZK + "tmpScanLicense/";
            x.d("MicroMsg.MsgHandler", "tmpSaveCardBitmapDir: %s", new Object[]{str2});
            if (FileOp.bO(str2)) {
                FileOp.G(str2, true);
            }
            FileOp.mh(str2);
            FileOp.mj(str2);
            str2 = str2 + System.currentTimeMillis() + ".jpg";
            x.d("MicroMsg.MsgHandler", "tmpSaveCardBitmapPath: %s", new Object[]{str2});
            d.a(bitmap, 100, CompressFormat.JPEG, str2, true);
            WebViewJSSDKFileItem Ol = WebViewJSSDKFileItem.Ol(str2);
            f.bRB().b(Ol);
            Map hashMap = new HashMap();
            hashMap.put("sourceType", "scan");
            hashMap.put("localId", Ol.fus);
            g.a(this.tIj, this.tIF, "chooseIdCard:ok", hashMap);
        } catch (Exception e) {
            x.e("MicroMsg.MsgHandler", "save scan license error: %s", new Object[]{e.getMessage()});
            g.a(this.tIj, this.tIF, "chooseIdCard:fail", null);
        }
    }

    public final void OH(String str) {
        g.a(this.tIj, this.tIF, "chooseIdCard:cancel", null);
    }

    public final void KZ(String str) {
        g.a(this.tIj, this.tIF, "chooseIdCard:fail", null);
    }
}
