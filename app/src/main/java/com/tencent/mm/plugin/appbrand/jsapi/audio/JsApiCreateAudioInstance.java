package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.ac.b;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.c$c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import org.json.JSONObject;

public final class JsApiCreateAudioInstance extends l {
    public static final int CTRL_INDEX = 291;
    public static final String NAME = "createAudioInstance";
    private static Vector<String> jev = new Vector();
    public static boolean jew = true;

    public JsApiCreateAudioInstance() {
        jew = true;
    }

    public final String a(final j jVar, JSONObject jSONObject) {
        final String str = jVar.mAppId;
        x.i("MicroMsg.Audio.JsApiCreateAudioInstance", "createAudioInstance appId:%s", new Object[]{str});
        String Jx = b.Jx();
        Map hashMap = new HashMap();
        hashMap.put("audioId", Jx);
        x.i("MicroMsg.Audio.JsApiCreateAudioInstance", "createAudioInstance ok audioId:%s", new Object[]{Jx});
        MainProcessTask createAudioTask = new CreateAudioTask(this, jVar);
        CreateAudioTask.a(createAudioTask, Jx);
        createAudioTask.fDt = 0;
        CreateAudioTask.b(createAudioTask, str);
        AppBrandMainProcessService.a(createAudioTask);
        c.b anonymousClass1 = new c.b(this) {
            final /* synthetic */ JsApiCreateAudioInstance jex;

            public final void onCreate() {
                JsApiCreateAudioInstance.jew = true;
            }

            public final void onResume() {
                JsApiCreateAudioInstance.jew = true;
            }

            public final void a(c$c com_tencent_mm_plugin_appbrand_c_c) {
                x.i("MicroMsg.Audio.JsApiCreateAudioInstance", "onPause, appId:%s", new Object[]{str});
                JsApiCreateAudioInstance.jew = false;
                MainProcessTask createAudioTask = new CreateAudioTask();
                createAudioTask.fDt = 1;
                CreateAudioTask.b(createAudioTask, str);
                createAudioTask.jcM = jVar;
                AppBrandMainProcessService.a(createAudioTask);
            }

            public final void onDestroy() {
                x.i("MicroMsg.Audio.JsApiCreateAudioInstance", "onDestroy, appId:%s", new Object[]{str});
                JsApiCreateAudioInstance.jew = false;
                MainProcessTask createAudioTask = new CreateAudioTask();
                createAudioTask.fDt = 2;
                CreateAudioTask.b(createAudioTask, str);
                createAudioTask.jcM = jVar;
                AppBrandMainProcessService.b(createAudioTask);
                c.b(str, this);
                JsApiCreateAudioInstance.jev.remove(str);
            }
        };
        if (!jev.contains(str)) {
            c.a(str, anonymousClass1);
            jev.add(str);
        }
        return e("ok", hashMap);
    }
}
