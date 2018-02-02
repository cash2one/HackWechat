package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.c;
import com.tencent.mm.sdk.platformtools.x;

class a$b implements Runnable {
    volatile boolean otH;
    final /* synthetic */ a rmk;
    c rml;

    private a$b(a aVar) {
        this.rmk = aVar;
        this.otH = false;
    }

    public final void run() {
        if (!(a.q(this.rmk) == null || a.q(this.rmk).bsS() == null || a.q(this.rmk).bsS().getVisibility() != 0)) {
            a.g(this.rmk).post(new 1(this));
        }
        if (a.e(this.rmk) < 0) {
            x.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id, path %s", new Object[]{Integer.valueOf(this.rmk.hashCode()), Integer.valueOf(hashCode()), a.a(this.rmk)});
        } else if (this.otH) {
            x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at beg", new Object[]{Integer.valueOf(this.rmk.hashCode()), Integer.valueOf(hashCode())});
        } else {
            float f;
            double bsU;
            if (a.r(this.rmk) == 0) {
                if (a.s(this.rmk) != null) {
                    a.s(this.rmk).type = 1;
                    a.s(this.rmk).run();
                }
                a.a(this.rmk, System.currentTimeMillis());
            }
            Object obj = null;
            if (a.t(this.rmk) != -1.0d) {
                if (this.rmk.qtH) {
                    if (a.s(this.rmk) != null) {
                        a.s(this.rmk).type = 4;
                        a.s(this.rmk).qtN = a.t(this.rmk);
                        a.s(this.rmk).run();
                        a.g(this.rmk).postDelayed(new 2(this), 100);
                    } else if (SightVideoJNI.seekStream(a.t(this.rmk), a.e(this.rmk)) > 0) {
                        if (a.s(this.rmk) == null) {
                            a.a(this.rmk, new a$i(this.rmk));
                        }
                        a.s(this.rmk).type = 4;
                        a.s(this.rmk).qtN = a.t(this.rmk);
                        a.s(this.rmk).run();
                        obj = 1;
                    }
                } else if (SightVideoJNI.seekStream(a.t(this.rmk), a.e(this.rmk)) > 0) {
                    if (a.s(this.rmk) == null) {
                        a.a(this.rmk, new a$i(this.rmk));
                    }
                    a.s(this.rmk).type = 4;
                    a.s(this.rmk).qtN = a.t(this.rmk);
                    a.s(this.rmk).run();
                    obj = 1;
                }
            }
            float currentTimeMillis = (float) (System.currentTimeMillis() - a.r(this.rmk));
            if (obj != null) {
                f = 0.0f;
            } else {
                f = (currentTimeMillis / ((float) this.rmk.qto)) + 0.5f;
            }
            if (this.rmk.qtH && a.u(this.rmk)) {
                a.a(this.rmk, false);
                if (a.s(this.rmk) != null) {
                    bsU = a.s(this.rmk).bsU() / 1000.0d;
                    if (SightVideoJNI.seekStream(bsU, a.e(this.rmk)) > 0) {
                        f = 0.0f;
                        x.i("MicroMsg.SightPlayController", "seek to " + bsU + " modify time : 0.0");
                    }
                }
            }
            float f2 = f;
            if (a.v(this.rmk)) {
                x.i("MicroMsg.SightPlayController", "#0x%x video %d id passedTime:  %s  seek  %s", new Object[]{Integer.valueOf(this.rmk.hashCode()), Integer.valueOf(a.e(this.rmk)), Float.valueOf(currentTimeMillis), Float.valueOf(f2)});
            }
            a.a(this.rmk, System.currentTimeMillis());
            if (f2 >= 2.0f) {
                a.w(this.rmk);
            } else {
                a.c(this.rmk, Math.max(0, a.x(this.rmk) - 1));
            }
            if (a.c(this.rmk)) {
                x.e("MicroMsg.SightPlayController", "match tolerate bad seek times %d", new Object[]{Integer.valueOf(a.x(this.rmk))});
                this.rmk.clear();
                return;
            }
            int i;
            Object obj2 = null;
            int i2 = 0;
            if (1 == a.d(this.rmk)) {
                Object obj3;
                if (a.m(this.rmk) == null || a.m(this.rmk).isValid()) {
                    i2 = SightVideoJNI.drawSurfaceFrame(a.e(this.rmk), a.m(this.rmk), (int) f2, a.o(this.rmk), a.y(this.rmk));
                    if (a.z(this.rmk) != null) {
                        bsU = SightVideoJNI.getVideoPlayTime(a.e(this.rmk));
                        i = (int) bsU;
                        if (i != ((int) this.rmk.qtK)) {
                            a.z(this.rmk).eJ((long) i);
                        }
                        this.rmk.qtK = bsU;
                    }
                    if (i2 == 0) {
                        a.a(this.rmk, -1.0d);
                        obj3 = null;
                    } else if (1 == i2) {
                        a.a(this.rmk, -1.0d);
                        obj3 = 1;
                        a.a(this.rmk, 0);
                        a.A(this.rmk);
                    } else if (-7 == i2) {
                        x.w("MicroMsg.SightPlayController", "surface is null, continue");
                        obj3 = null;
                    } else {
                        x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error:%d", new Object[]{Integer.valueOf(this.rmk.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2)});
                        this.otH = true;
                        if (this.rml != null) {
                            this.rml.otH = true;
                        }
                        this.rmk.bxx();
                        if (a.b(this.rmk) != null) {
                            a.b(this.rmk).xb(-1);
                        }
                        obj3 = null;
                    }
                } else {
                    x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error, surface is not valid", new Object[]{Integer.valueOf(this.rmk.hashCode()), Integer.valueOf(hashCode())});
                    this.otH = true;
                    if (this.rml != null) {
                        this.rml.otH = true;
                        obj3 = null;
                    }
                    obj3 = null;
                }
                if (a.s(this.rmk) != null) {
                    x.d("MicroMsg.SightPlayController", "voice time is" + (a.s(this.rmk).bsU() / 1000.0d));
                    obj2 = obj3;
                } else {
                    obj2 = obj3;
                }
            } else {
                i2 = SightVideoJNI.drawFrame(a.e(this.rmk), a.B(this.rmk), (int) f2, null, false, a.y(this.rmk));
                if (a.z(this.rmk) != null) {
                    bsU = SightVideoJNI.getVideoPlayTime(a.e(this.rmk));
                    i = (int) bsU;
                    if (i != ((int) this.rmk.qtK)) {
                        a.z(this.rmk).eJ((long) i);
                    }
                    this.rmk.qtK = bsU;
                    if (a.v(this.rmk)) {
                        x.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", new Object[]{Integer.valueOf(this.rmk.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2), Double.valueOf(bsU)});
                    }
                } else if (a.v(this.rmk)) {
                    bsU = SightVideoJNI.getVideoPlayTime(a.e(this.rmk));
                    if (a.v(this.rmk)) {
                        x.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", new Object[]{Integer.valueOf(this.rmk.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2), Double.valueOf(bsU)});
                    }
                } else if (a.v(this.rmk)) {
                    x.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d", new Object[]{Integer.valueOf(this.rmk.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2)});
                }
                if (i2 == 0) {
                    a.a(this.rmk, -1.0d);
                } else if (1 == i2) {
                    a.a(this.rmk, -1.0d);
                    obj2 = 1;
                    a.a(this.rmk, 0);
                    a.A(this.rmk);
                } else {
                    a.a(this.rmk, -1.0d);
                    x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw bitmap match error:%d", new Object[]{Integer.valueOf(this.rmk.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2)});
                    this.otH = true;
                    if (this.rml != null) {
                        this.rml.otH = true;
                    }
                    a.g(this.rmk).post(new 3(this));
                    if (a.b(this.rmk) != null) {
                        a.b(this.rmk).xb(-1);
                    }
                }
            }
            if (1 == i2) {
                a.g(this.rmk).post(new 4(this));
            }
            if (this.otH) {
                x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at end", new Object[]{Integer.valueOf(this.rmk.hashCode()), Integer.valueOf(hashCode())});
                if (a.s(this.rmk) != null) {
                    a.s(this.rmk).type = 0;
                    a.s(this.rmk).run();
                    return;
                }
                return;
            }
            if (1 == a.d(this.rmk)) {
                long currentTimeMillis2 = ((long) this.rmk.qto) - (System.currentTimeMillis() - a.r(this.rmk));
                if (a.r(this.rmk) == 0) {
                    o.c(this, (long) (this.rmk.qto * 5));
                } else if (currentTimeMillis2 > 0) {
                    o.c(this, currentTimeMillis2);
                } else {
                    o.c(this, 0);
                }
            } else if (obj2 == null || a.q(this.rmk) == null) {
                this.rml.quc = i2;
                a.g(this.rmk).post(this.rml);
            } else {
                i = a.q(this.rmk).bsR();
                a.g(this.rmk).post(new Runnable(this) {
                    final /* synthetic */ a$b rmm;

                    {
                        this.rmm = r1;
                    }

                    public final void run() {
                        if (a.q(this.rmm.rmk) != null) {
                            View bsS = a.q(this.rmm.rmk).bsS();
                            if (bsS != null) {
                                if (!(a.C(this.rmm.rmk) != null || a.q(this.rmm.rmk).bsT() == -1 || a.k(this.rmm.rmk).get() == null)) {
                                    a.a(this.rmm.rmk, AnimationUtils.loadAnimation(((View) a.k(this.rmm.rmk).get()).getContext(), a.q(this.rmm.rmk).bsT()));
                                }
                                if (a.C(this.rmm.rmk) != null) {
                                    bsS.startAnimation(a.C(this.rmm.rmk));
                                }
                                bsS.setVisibility(0);
                            }
                        }
                    }
                });
                this.rml.quc = i2;
                a.g(this.rmk).postDelayed(this.rml, (long) i);
            }
            if (a.s(this.rmk) != null) {
                x.d("MicroMsg.SightPlayController", "voice time is" + (a.s(this.rmk).bsU() / 1000.0d));
            }
        }
    }
}
