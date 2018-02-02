package com.tencent.mm.plugin.appbrand.permission;

import android.util.SparseIntArray;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.ap;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.contact.b;
import com.tencent.mm.plugin.appbrand.jsapi.g.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.jsapi.share.c;
import com.tencent.mm.plugin.appbrand.jsapi.share.d;
import com.tencent.mm.plugin.appbrand.menu.h$a;
import com.tencent.mm.plugin.appbrand.menu.i$a;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashSet;
import java.util.Set;

final class a {
    private static final SparseIntArray jGk = new SparseIntArray() {
        public final int get(int i) {
            return super.get(i, j.izM);
        }
    };
    private static final Set<String> jGl = new HashSet();

    static {
        jGk.put(e.NAME.hashCode(), j.izI);
        jGk.put(JsApiStartPlayVoice.NAME.hashCode(), j.izJ);
        jGk.put(JsApiOperateMusicPlayer.NAME.hashCode(), j.izJ);
        jGk.put(c.NAME.hashCode(), j.izK);
        jGk.put(h$a.NAME.hashCode(), j.izK);
        jGk.put(d.NAME.hashCode(), j.izK);
        jGk.put("shareTimeline".hashCode(), j.izK);
        jGk.put(i$a.NAME.hashCode(), j.izK);
        jGk.put("launchMiniProgram".hashCode(), j.izH);
        jGl.add(e.NAME);
        jGl.add(JsApiStartPlayVoice.NAME);
        jGl.add(JsApiOperateMusicPlayer.NAME);
        jGl.add(c.NAME);
        jGl.add(h$a.NAME);
        jGl.add(d.NAME);
        jGl.add("shareTimeline");
        jGl.add(i$a.NAME);
        jGl.add("launchMiniProgram");
        jGl.add(JsApiMakeVoIPCall.NAME);
        jGl.add(o.NAME);
        jGl.add(b.NAME);
        jGl.add(am.NAME);
        jGl.add(ap.NAME);
    }

    static void a(com.tencent.mm.plugin.appbrand.e eVar, com.tencent.mm.plugin.appbrand.jsapi.b bVar) {
        if (eVar != null && bVar != null && jGl.contains(bVar.getName())) {
            String string = ac.getResources().getString(jGk.get(bVar.getName().hashCode()));
            com.tencent.mm.plugin.appbrand.q.c.runOnUiThread(new 2(eVar, ac.getResources().getString(j.izL, new Object[]{string})));
        }
    }
}
