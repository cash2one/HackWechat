package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.view.MotionEvent;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.jsapi.m.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.m.c.f;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

class b$a$1 implements Runnable {
    final /* synthetic */ a juC;

    b$a$1(a aVar) {
        this.juC = aVar;
    }

    public final void run() {
        if (a.a(this.juC)) {
            f bI = c.bI(a.b(this.juC));
            if (Math.abs(a.c(this.juC).x - bI.x) > 1.0f || Math.abs(a.c(this.juC).y - bI.y) > 1.0f) {
                x.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but view has moved.");
                return;
            } else if (a.d(this.juC).size() != 1) {
                x.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but more then one point.");
                return;
            } else if (Math.abs(a.e(this.juC).x - a.f(this.juC).x) > a.g(this.juC) || Math.abs(a.e(this.juC).y - a.f(this.juC).y) > a.g(this.juC)) {
                x.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but point has moved(%s, %s, %s, %s).", new Object[]{Float.valueOf(a.e(this.juC).x), Float.valueOf(a.f(this.juC).x), Float.valueOf(a.e(this.juC).y), Float.valueOf(a.f(this.juC).y)});
                return;
            } else {
                x.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, publish event(%s, %s, %s, %s).", new Object[]{Float.valueOf(a.e(this.juC).x), Float.valueOf(a.f(this.juC).x), Float.valueOf(a.e(this.juC).y), Float.valueOf(a.f(this.juC).y)});
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, a.h(this.juC).getString(SlookAirButtonFrequentContactAdapter.DATA, ""));
                    jSONObject.put("touch", a.e(this.juC).sN());
                } catch (JSONException e) {
                }
                if (!a.h(this.juC).getBoolean("disableScroll", false)) {
                    a.a(this.juC, MotionEvent.obtain(a.i(this.juC)));
                    a.j(this.juC).setAction(0);
                    a.h(this.juC).u("fakeDownEvent", true);
                    a.b(this.juC).getParent().requestDisallowInterceptTouchEvent(true);
                    a.b(this.juC).setDuplicateParentStateEnabled(false);
                    a.a(this.juC, a.b(this.juC), MotionEvent.obtain(a.j(this.juC)));
                }
                a.a(this.juC, new c.a(), jSONObject.toString());
                return;
            }
        }
        x.v("MicroMsg.OnTouchListenerImpl", "check long press timeout, but pressed is false or pointer is null.");
    }
}
