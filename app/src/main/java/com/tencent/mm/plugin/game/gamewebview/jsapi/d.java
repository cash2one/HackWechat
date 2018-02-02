package com.tencent.mm.plugin.game.gamewebview.jsapi;

import android.os.Handler;
import android.os.HandlerThread;
import android.webkit.JavascriptInterface;
import com.tencent.mm.plugin.game.gamewebview.a.b;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONObject;

public final class d {
    public Handler iTB;
    private Map<String, c> jbN;
    protected com.tencent.mm.plugin.game.gamewebview.ui.d mWh;
    public JSONObject mWi;
    public HashSet<String> mWj = new HashSet();

    public d(com.tencent.mm.plugin.game.gamewebview.ui.d dVar) {
        this.mWh = dVar;
        this.jbN = e.aOM();
        HandlerThread handlerThread = new HandlerThread("GameWebviewAsyncJSThread");
        handlerThread.start();
        this.iTB = new Handler(handlerThread.getLooper());
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final String invokeHandler(String str, String str2, int i, long j) {
        x.i("MicroMsg.GameJsApiInterface", "api: %s, time: %d", new Object[]{str, Long.valueOf(System.currentTimeMillis() - j)});
        int Bz = b.Bz(str);
        if (Bz > 0) {
            g.pQN.a(157, (long) Bz, 1, false);
        }
        String str3 = "";
        try {
            String t;
            boolean z = this.jbN.get(str) instanceof f;
            if (z) {
                t = t(str, str2, i);
            } else {
                this.iTB.post(new 1(this, str, str2, i));
                t = str3;
            }
            String str4 = "MicroMsg.GameJsApiInterface";
            String str5 = "invokeHandler, api: %s, data size: %d, sync: %b, time: %d";
            Object[] objArr = new Object[4];
            objArr[0] = str;
            if (str2 == null) {
                Bz = 0;
            } else {
                Bz = str2.length();
            }
            objArr[1] = Integer.valueOf(Bz);
            objArr[2] = Boolean.valueOf(z);
            objArr[3] = Long.valueOf(System.currentTimeMillis() - r10);
            x.i(str4, str5, objArr);
            return t;
        } catch (Exception e) {
            x.e("MicroMsg.GameJsApiInterface", "Invoke Error: %s, %s\n%s", new Object[]{str, e.getMessage(), e.getStackTrace()});
            throw e;
        }
    }

    final String t(String str, String str2, int i) {
        if (this.mWh == null || this.mWh.aPh() == null) {
            x.e("MicroMsg.GameJsApiInterface", "activity is null");
            return "";
        }
        String BF;
        c cVar = (c) this.jbN.get(str);
        boolean z = cVar instanceof f;
        JSONObject sc = sc(str2);
        if (cVar == null) {
            BF = BF("system:function_not_exist");
        } else {
            boolean z2;
            if (this.mWj.contains(cVar.getName())) {
                this.mWj.remove(cVar.getName());
                z2 = true;
            } else {
                z2 = this.mWh.bq(cVar.getName(), cVar.aOI());
            }
            if (z2) {
                try {
                    if (this.mWi != null) {
                        if (!bh.ov(this.mWi.optString("srcUsername"))) {
                            sc.put("src_username", this.mWi.optString("srcUsername"));
                        }
                        if (!bh.ov(this.mWi.optString("srcDisplayname"))) {
                            sc.put("src_displayname", this.mWi.optString("srcDisplayname"));
                        }
                        if (!bh.ov(this.mWi.optString("KTemplateId"))) {
                            sc.put("tempalate_id", this.mWi.optString("KTemplateId"));
                        }
                        sc.put("message_id", this.mWi.optLong("message_id"));
                        sc.put("message_index", this.mWi.optInt("message_index"));
                        sc.put("webview_scene", this.mWi.optInt("scene"));
                        sc.put("stastic_scene", this.mWi.optInt("stastic_scene"));
                    }
                    sc.put("current_url", this.mWh.aPk());
                    sc.put("current_appid", this.mWh.aPl());
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.GameJsApiInterface", e, "", new Object[0]);
                }
                if (z) {
                    BF = "";
                } else {
                    a aVar = (a) cVar;
                    if (aVar.aOK() == 2) {
                        GameJsApiActivityTask gameJsApiActivityTask = new GameJsApiActivityTask(this.mWh.aPh());
                        gameJsApiActivityTask.mWb = this.mWh;
                        gameJsApiActivityTask.jcN = i;
                        gameJsApiActivityTask.mWe = aVar.getName();
                        gameJsApiActivityTask.jfl = sc.toString();
                        gameJsApiActivityTask.aKE();
                        BF = null;
                    } else if (aVar.aOK() == 1) {
                        GWMainProcessTask gameJsApiMMTask = new GameJsApiMMTask();
                        gameJsApiMMTask.mWb = this.mWh;
                        gameJsApiMMTask.jcN = i;
                        gameJsApiMMTask.mWe = aVar.getName();
                        gameJsApiMMTask.jfl = sc.toString();
                        gameJsApiMMTask.afi();
                        GameWebViewMainProcessService.a(gameJsApiMMTask);
                        BF = null;
                    } else {
                        aVar.a(this.mWh, sc, i);
                        BF = null;
                    }
                }
            } else {
                BF = BF("system:access_denied");
            }
        }
        if (z) {
            return BF;
        }
        if (BF != null) {
            this.mWh.E(i, BF);
        }
        return "";
    }

    private static String BF(String str) {
        Map hashMap = new HashMap();
        hashMap.put("err_msg", str);
        return new JSONObject(hashMap).toString();
    }

    private static JSONObject sc(String str) {
        try {
            if (bh.ov(str)) {
                str = "{}";
            }
            return new JSONObject(str);
        } catch (Exception e) {
            x.e("MicroMsg.GameJsApiInterface", e.getMessage());
            return new JSONObject();
        }
    }
}
