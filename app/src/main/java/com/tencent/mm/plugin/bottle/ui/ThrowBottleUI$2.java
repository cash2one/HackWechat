package com.tencent.mm.plugin.bottle.ui;

import android.graphics.drawable.AnimationDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.bottle.a.h;
import com.tencent.mm.plugin.bottle.a.h.d;
import com.tencent.mm.pluginsdk.g.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class ThrowBottleUI$2 implements OnTouchListener {
    final /* synthetic */ ThrowBottleUI kEz;

    ThrowBottleUI$2(ThrowBottleUI throwBottleUI) {
        this.kEz = throwBottleUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == ThrowBottleUI.f(this.kEz)) {
            switch (motionEvent.getAction()) {
                case 0:
                    if (!ThrowBottleUI.g(this.kEz)) {
                        x.i("MM.Bottle.ThrowBottleUI", "summerper checkPermission checkMicrophone[%b]", new Object[]{Boolean.valueOf(a.a(ThrowBottleUI.h(this.kEz), "android.permission.RECORD_AUDIO", 80, null, null))});
                        if (a.a(ThrowBottleUI.h(this.kEz), "android.permission.RECORD_AUDIO", 80, null, null)) {
                            ThrowBottleUI throwBottleUI = this.kEz;
                            throwBottleUI.kEo = true;
                            throwBottleUI.kEl.setBackgroundDrawable(com.tencent.mm.bv.a.b(throwBottleUI.kCH, R.g.bFh));
                            throwBottleUI.kEl.setText(throwBottleUI.kDT ? R.l.dMX : R.l.dMV);
                            if (throwBottleUI.kDT) {
                                if (!com.tencent.mm.p.a.aW(throwBottleUI.getContext()) && !com.tencent.mm.p.a.aU(throwBottleUI.kCH)) {
                                    ar.Hg();
                                    if (!c.isSDCardAvailable()) {
                                        u.fI(throwBottleUI.kCH);
                                        break;
                                    }
                                    throwBottleUI.kEw = true;
                                    x.v("MM.Bottle.ThrowBottleUI", "record start");
                                    if (throwBottleUI.kDZ != null) {
                                        throwBottleUI.kDZ.kAP = null;
                                        throwBottleUI.kDZ = null;
                                    }
                                    throwBottleUI.kDZ = new d(throwBottleUI.getContext(), throwBottleUI);
                                    throwBottleUI.kEu.J(100, 100);
                                    throwBottleUI.kEg.setVisibility(0);
                                    throwBottleUI.kEh.setVisibility(0);
                                    throwBottleUI.kEf = (AnimationDrawable) throwBottleUI.kEh.getBackground();
                                    throwBottleUI.kEf.start();
                                    throwBottleUI.kEi.setVisibility(8);
                                    if (throwBottleUI.kDZ != null) {
                                        ae.Vc("keep_app_silent");
                                        throwBottleUI.kDZ.cJ("_USER_FOR_THROWBOTTLE_");
                                        throwBottleUI.kEp = false;
                                        throwBottleUI.kEv.J(200, 200);
                                        throwBottleUI.kEa.startTone(24);
                                        throwBottleUI.handler.postDelayed(new ThrowBottleUI$7(throwBottleUI), 200);
                                        throwBottleUI.kEd.vibrate(50);
                                        throwBottleUI.kDZ.a(throwBottleUI.kEy);
                                    }
                                    throwBottleUI.kCH.getWindow().getDecorView().setKeepScreenOn(true);
                                    break;
                                }
                                x.d("MM.Bottle.ThrowBottleUI", "voip is running, can't record voice");
                                break;
                            }
                        }
                    }
                    break;
                case 1:
                    ThrowBottleUI.i(this.kEz);
                    ThrowBottleUI.f(this.kEz).setBackgroundDrawable(com.tencent.mm.bv.a.b(ThrowBottleUI.h(this.kEz), R.g.bFg));
                    ThrowBottleUI.f(this.kEz).setText(ThrowBottleUI.j(this.kEz) ? R.l.dMY : R.l.dMV);
                    if (!ThrowBottleUI.j(this.kEz)) {
                        ThrowBottleUI.l(this.kEz);
                        String trim = ThrowBottleUI.m(this.kEz).getText().toString().trim();
                        if (trim.length() < 5) {
                            ThrowBottleUI.h(this.kEz).nl(R.l.dMW);
                            break;
                        }
                        ThrowBottleUI.m(this.kEz).setText("");
                        h.c cVar = new h.c(trim, this.kEz);
                        ThrowBottleUI.n(this.kEz);
                    } else if (!ThrowBottleUI.k(this.kEz)) {
                        this.kEz.asf();
                    }
                    ThrowBottleUI.o(this.kEz);
                    break;
                default:
                    break;
            }
        }
        return false;
    }
}
