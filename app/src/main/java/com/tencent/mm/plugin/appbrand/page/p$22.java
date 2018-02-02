package com.tencent.mm.plugin.appbrand.page;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.plugin.appbrand.jsapi.m.c;
import com.tencent.mm.plugin.appbrand.p.j;
import com.tencent.mm.plugin.appbrand.widget.b.b;
import com.tencent.mm.plugin.appbrand.widget.b.f.a;
import com.tencent.mm.plugin.appbrand.widget.input.ad;
import com.tencent.mm.plugin.appbrand.widget.input.f;
import java.util.Iterator;

class p$22 implements OnTouchListener {
    final /* synthetic */ p jEg;
    final /* synthetic */ f jEn;
    final /* synthetic */ ad jEo;

    p$22(p pVar, f fVar, ad adVar) {
        this.jEg = pVar;
        this.jEn = fVar;
        this.jEo = adVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        if (motionEvent.getAction() != 0) {
            c.a(this.jEn, motionEvent);
        }
        ad adVar = this.jEo;
        if (motionEvent == null) {
            z = false;
        } else {
            r rVar;
            com.tencent.mm.plugin.appbrand.widget.b.f fVar = adVar.jZw.jWY;
            if (fVar.jWf.onFilterTouchEventForSecurity(motionEvent)) {
                Iterator cVar = motionEvent.getActionMasked() == 0 ? new com.tencent.mm.plugin.appbrand.widget.b.c(fVar.jWf) : fVar.jWg.iterator();
                fVar.jWh = motionEvent.getActionMasked() == 0 ? new a(motionEvent.getDownTime(), motionEvent.getEventTime(), (byte) 0) : null;
                z = false;
                while (cVar.hasNext()) {
                    boolean z2;
                    View view2 = (View) cVar.next();
                    int actionIndex = motionEvent.getActionIndex();
                    int pointerId = fVar.jWf.isMotionEventSplittingEnabled() ? 1 << motionEvent.getPointerId(actionIndex) : -1;
                    float x = motionEvent.getX(actionIndex);
                    float y = motionEvent.getY(actionIndex);
                    if (motionEvent.getActionMasked() == 0) {
                        Object obj = (view2.getVisibility() == 0 || view2.getAnimation() != null) ? 1 : null;
                        if (obj != null) {
                            Boolean bool = (Boolean) j.a("isTransformedTouchPointInView", fVar.jWf, new Class[]{Float.TYPE, Float.TYPE, View.class, PointF.class}, new Object[]{Float.valueOf(x), Float.valueOf(y), view2, null}, Boolean.valueOf(false));
                            obj = (bool == null || !bool.booleanValue()) ? null : 1;
                            if (obj != null) {
                                if (com.tencent.mm.plugin.appbrand.widget.b.a.bP(view2)) {
                                    if (com.tencent.mm.plugin.appbrand.widget.b.a.a(fVar.jWf, motionEvent, view2, pointerId)) {
                                        fVar.jWg.addLast(view2);
                                        z2 = z | 1;
                                    } else {
                                        z2 = z;
                                    }
                                    z = z2;
                                } else {
                                    z2 = z;
                                }
                            }
                        }
                    } else {
                        z2 = com.tencent.mm.plugin.appbrand.widget.b.a.a(fVar.jWf, motionEvent, view2, pointerId) | z;
                    }
                    z = z2;
                }
                switch (motionEvent.getActionMasked()) {
                    case 1:
                    case 3:
                        fVar.jWg.clear();
                        break;
                }
            }
            z = false;
            b.a("MicroMsg.AppBrand.InputTouchDuplicateDispatcher", "[textscroll] handled | " + z, motionEvent);
            if (2 == motionEvent.getActionMasked()) {
                if (z && !adVar.jZx) {
                    rVar = (r) adVar.jZB.cc(adVar.jZw);
                    if (rVar != null) {
                        adVar.jZy = !rVar.jEy;
                        rVar.dd(false);
                        rVar.requestDisallowInterceptTouchEvent(true);
                        adVar.jZx = true;
                    }
                }
                if (z) {
                    adVar.jZz = true;
                } else if (adVar.jZz) {
                    adVar.jZz = false;
                }
            }
            switch (motionEvent.getActionMasked()) {
                case 0:
                    break;
                case 1:
                case 3:
                    if (adVar.jZx) {
                        rVar = (r) adVar.jZB.cc(adVar.jZw);
                        if (rVar != null) {
                            rVar.dd(adVar.jZy);
                        }
                        adVar.jZx = false;
                        break;
                    }
                    break;
                default:
                    break;
            }
            z = false;
        }
        if (z) {
            return true;
        }
        return false;
    }
}
