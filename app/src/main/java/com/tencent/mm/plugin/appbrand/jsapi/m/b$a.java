package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.support.v4.view.z;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.jsapi.m.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.m.c.d;
import com.tencent.mm.plugin.appbrand.jsapi.m.c.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u$b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b$a implements OnTouchListener {
    private static volatile View juq;
    private u$b gON;
    private f juA;
    private f juB;
    private Map<Integer, f> jur = new HashMap();
    private boolean jus;
    private boolean jut;
    private f juu;
    private Runnable juv;
    private int juw;
    private float jux;
    private MotionEvent juy;
    private MotionEvent juz;
    private String mAppId;
    private View mView;

    static /* synthetic */ void a(b$a com_tencent_mm_plugin_appbrand_jsapi_m_b_a, View view, MotionEvent motionEvent) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == null || !(parent instanceof ViewGroup)) {
                view.dispatchTouchEvent(motionEvent);
            } else {
                ViewGroup viewGroup = (ViewGroup) parent;
                motionEvent.offsetLocation(-(((float) viewGroup.getScrollX()) - view.getX()), -(((float) viewGroup.getScrollY()) - view.getY()));
                view = (View) parent;
            }
        }
        view.dispatchTouchEvent(motionEvent);
    }

    public b$a(p pVar, u$b com_tencent_mm_z_u_b) {
        Assert.assertNotNull(pVar);
        Assert.assertNotNull(com_tencent_mm_z_u_b);
        this.gON = com_tencent_mm_z_u_b;
        this.mAppId = pVar.mAppId;
        this.juw = pVar.hashCode();
        this.jux = (float) ViewConfiguration.get(pVar.mContext).getScaledTouchSlop();
        this.juA = new f();
        this.juB = new f();
        this.juv = new 1(this);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (juq == null || juq.equals(view)) {
            this.juz = motionEvent;
            int actionMasked = motionEvent.getActionMasked();
            int actionIndex = motionEvent.getActionIndex();
            motionEvent.getPointerCount();
            int pointerId = motionEvent.getPointerId(actionIndex);
            float x = motionEvent.getX(actionIndex);
            float y = motionEvent.getY(actionIndex);
            if (actionMasked != 0 && !this.gON.hA("isTouching") && !z.ak(view) && actionMasked != 3) {
                return false;
            }
            String string = this.gON.getString(SlookAirButtonFrequentContactAdapter.DATA, "");
            boolean z = this.gON.getBoolean("disableScroll", false);
            boolean z2 = this.gON.getBoolean("fakeDownEvent", false);
            boolean z3 = this.gON.getBoolean("onLongClick", false);
            this.jut = this.gON.getBoolean("enableLongClick", false);
            this.juB.a(pointerId, x, y);
            boolean z4 = z | z3;
            boolean z5;
            JSONObject jSONObject;
            JSONArray jSONArray;
            f[] y2;
            switch (actionMasked) {
                case 0:
                    if (this.juy == null || motionEvent.getDownTime() == this.juy.getDownTime()) {
                        z5 = z2;
                    } else {
                        this.gON.u("fakeDownEvent", false);
                        x.v("MicroMsg.OnTouchListenerImpl", "try to handle fake event failed");
                        z5 = false;
                    }
                    if (z || z5) {
                        view.getParent().requestDisallowInterceptTouchEvent(true);
                        view.setDuplicateParentStateEnabled(false);
                        x.i("MicroMsg.OnTouchListenerImpl", "onLongClick fake down event.");
                    } else {
                        view.setDuplicateParentStateEnabled(true);
                    }
                    if (z5) {
                        z2 = true;
                        z3 = true;
                        this.gON.u("fakeDownEvent", false);
                        this.gON.u("onLongClick", true);
                    } else {
                        juq = view;
                        this.juu = c.bI(view);
                        this.juA.a(pointerId, x, y);
                        z2 = z3;
                        z3 = z4;
                    }
                    this.gON.u("isTouching", true);
                    if (!(!this.jut || r3 || this.jur.containsKey(Integer.valueOf(pointerId)))) {
                        view.postDelayed(this.juv, (long) ViewConfiguration.getLongPressTimeout());
                    }
                    z4 = z3;
                    break;
                case 1:
                    if (z || z3) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    } else {
                        view.setDuplicateParentStateEnabled(false);
                    }
                    juq = null;
                    this.gON.u("isTouching", false);
                    if (this.gON.containsKey("disableScroll-nextState")) {
                        this.gON.u("disableScroll", this.gON.getBoolean("disableScroll-nextState", z));
                        break;
                    }
                    break;
                case 2:
                    Object obj;
                    int i = 0;
                    while (i < motionEvent.getPointerCount()) {
                        float x2 = motionEvent.getX(i);
                        float y3 = motionEvent.getY(i);
                        f fVar = (f) this.jur.get(Integer.valueOf(motionEvent.getPointerId(i)));
                        if (fVar == null || (x2 == fVar.x && y3 == fVar.y)) {
                            i++;
                        } else {
                            obj = 1;
                            if (obj != null) {
                                return z4;
                            }
                            if (this.jur.size() == 1 && this.jus && (Math.abs(this.juA.x - this.juB.x) > this.jux || Math.abs(this.juA.y - this.juB.y) > this.jux)) {
                                f(view, false);
                            }
                            jSONObject = new JSONObject();
                            jSONArray = new JSONArray();
                            try {
                                jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, string);
                                jSONObject.put("touches", jSONArray);
                            } catch (JSONException e) {
                            }
                            y2 = y(motionEvent);
                            if (y2.length > 0) {
                                for (f sN : y2) {
                                    jSONArray.put(sN.sN());
                                }
                            }
                            if (this.jur.size() != 0) {
                                return z4;
                            }
                            a(new d(), jSONObject.toString());
                            return z4;
                        }
                    }
                    obj = null;
                    if (obj != null) {
                        return z4;
                    }
                    f(view, false);
                    jSONObject = new JSONObject();
                    jSONArray = new JSONArray();
                    jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, string);
                    jSONObject.put("touches", jSONArray);
                    y2 = y(motionEvent);
                    if (y2.length > 0) {
                        while (actionIndex < y2.length) {
                            jSONArray.put(sN.sN());
                        }
                    }
                    if (this.jur.size() != 0) {
                        return z4;
                    }
                    a(new d(), jSONObject.toString());
                    return z4;
                case 3:
                    juq = null;
                    f(view, false);
                    if (z || z3) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    } else {
                        view.setDuplicateParentStateEnabled(false);
                    }
                    this.gON.u("isTouching", false);
                    if (this.gON.containsKey("disableScroll-nextState")) {
                        this.gON.u("disableScroll", this.gON.getBoolean("disableScroll-nextState", z));
                    }
                    if (z.ak(view)) {
                        jSONObject = new JSONObject();
                        jSONArray = new JSONArray();
                        try {
                            jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, string);
                            jSONObject.put("touches", jSONArray);
                        } catch (JSONException e2) {
                        }
                        y2 = y(motionEvent);
                        for (f sN2 : y2) {
                            jSONArray.put(sN2.sN());
                        }
                        a(new b(), jSONObject.toString());
                    }
                    this.jur.clear();
                    return z4;
                case 5:
                    z5 = z2;
                    z2 = z3;
                    break;
                case 6:
                    break;
                default:
                    return z4;
            }
        }
        x.v("MicroMsg.OnTouchListenerImpl", "onTouch, not current motion view");
        return false;
    }

    private void f(View view, boolean z) {
        this.mView = view;
        this.jus = z;
        if (!z) {
            this.gON.u("fakeDownEvent", false);
            this.gON.u("onLongClick", false);
            this.mView.removeCallbacks(this.juv);
            this.juA.a(-1, 0.0f, 0.0f);
            this.juy = null;
        }
    }

    private void a(f fVar, com.tencent.mm.plugin.appbrand.jsapi.f fVar2, String str) {
        if (fVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, str);
                jSONObject.put("touch", fVar.sN());
            } catch (JSONException e) {
            }
            a(fVar2, jSONObject.toString());
        }
    }

    private void a(com.tencent.mm.plugin.appbrand.jsapi.f fVar, String str) {
        com.tencent.mm.plugin.appbrand.jsapi.f az = fVar.az(this.mAppId, this.juw);
        az.mData = str;
        az.afs();
    }

    private f[] y(MotionEvent motionEvent) {
        int i = 0;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < motionEvent.getPointerCount(); i2++) {
            f fVar = (f) this.jur.get(Integer.valueOf(motionEvent.getPointerId(i2)));
            if (fVar != null) {
                fVar.x = motionEvent.getX(i2);
                fVar.y = motionEvent.getY(i2);
                arrayList.add(fVar);
            }
        }
        f[] fVarArr = new f[arrayList.size()];
        while (i < arrayList.size()) {
            fVarArr[i] = (f) arrayList.get(i);
            i++;
        }
        return fVarArr;
    }
}
