package com.tencent.mm.plugin.sight.decode.a;

import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.decode.a.b.i;
import com.tencent.mm.sdk.platformtools.x;

class b$b implements Runnable {
    volatile boolean otH;
    final /* synthetic */ b qtU;
    b$c qtZ;

    private b$b(b bVar) {
        this.qtU = bVar;
        this.otH = false;
    }

    public final void run() {
        if (!(b.q(this.qtU) == null || b.q(this.qtU).bsS() == null || b.q(this.qtU).bsS().getVisibility() != 0)) {
            b.g(this.qtU).post(new 1(this));
        }
        if (b.e(this.qtU) < 0) {
            x.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id, path %s", new Object[]{Integer.valueOf(this.qtU.hashCode()), Integer.valueOf(hashCode()), b.a(this.qtU)});
        } else if (this.otH) {
            x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at beg", new Object[]{Integer.valueOf(this.qtU.hashCode()), Integer.valueOf(hashCode())});
        } else {
            float f;
            double bsU;
            if (b.r(this.qtU) == 0) {
                if (b.s(this.qtU) != null) {
                    b.s(this.qtU).type = 1;
                    b.s(this.qtU).run();
                }
                b.a(this.qtU, System.currentTimeMillis());
            }
            Object obj = null;
            if (b.t(this.qtU) != -1.0d) {
                if (this.qtU.qtH) {
                    if (b.s(this.qtU) != null) {
                        b.s(this.qtU).type = 4;
                        b.s(this.qtU).qtN = b.t(this.qtU);
                        b.s(this.qtU).run();
                        b.g(this.qtU).postDelayed(new 2(this), 100);
                    } else if (SightVideoJNI.seekStream(b.t(this.qtU), b.e(this.qtU)) > 0) {
                        if (b.s(this.qtU) == null) {
                            b.a(this.qtU, new i(this.qtU, (byte) 0));
                        }
                        b.s(this.qtU).type = 4;
                        b.s(this.qtU).qtN = b.t(this.qtU);
                        b.s(this.qtU).run();
                        obj = 1;
                    }
                } else if (SightVideoJNI.seekStream(b.t(this.qtU), b.e(this.qtU)) > 0) {
                    if (b.s(this.qtU) == null) {
                        b.a(this.qtU, new i(this.qtU, (byte) 0));
                    }
                    b.s(this.qtU).type = 4;
                    b.s(this.qtU).qtN = b.t(this.qtU);
                    b.s(this.qtU).run();
                    obj = 1;
                }
            }
            float currentTimeMillis = (float) (System.currentTimeMillis() - b.r(this.qtU));
            if (obj != null) {
                f = 0.0f;
            } else {
                f = (currentTimeMillis / ((float) this.qtU.qto)) + 0.5f;
            }
            if (this.qtU.qtH && b.u(this.qtU)) {
                b.a(this.qtU, false);
                if (b.s(this.qtU) != null) {
                    bsU = b.s(this.qtU).bsU() / 1000.0d;
                    if (SightVideoJNI.seekStream(bsU, b.e(this.qtU)) > 0) {
                        f = 0.0f;
                        x.i("MicroMsg.SightPlayController", "seek to " + bsU + " modify time : 0.0");
                    }
                }
            }
            float f2 = f;
            if (b.v(this.qtU)) {
                x.i("MicroMsg.SightPlayController", "#0x%x video %d id passedTime:  %s  seek  %s", new Object[]{Integer.valueOf(this.qtU.hashCode()), Integer.valueOf(b.e(this.qtU)), Float.valueOf(currentTimeMillis), Float.valueOf(f2)});
            }
            b.a(this.qtU, System.currentTimeMillis());
            if (f2 >= 2.0f) {
                b.w(this.qtU);
            } else {
                b.c(this.qtU, Math.max(0, b.x(this.qtU) - 1));
            }
            if (b.c(this.qtU)) {
                x.e("MicroMsg.SightPlayController", "match tolerate bad seek times %d", new Object[]{Integer.valueOf(b.x(this.qtU))});
                this.qtU.clear();
                return;
            }
            int i;
            Object obj2 = null;
            int i2 = 0;
            if (1 == b.d(this.qtU)) {
                Object obj3;
                if (b.m(this.qtU) == null || b.m(this.qtU).isValid()) {
                    i2 = SightVideoJNI.drawSurfaceFrame(b.e(this.qtU), b.m(this.qtU), (int) f2, b.o(this.qtU), b.y(this.qtU));
                    if (b.z(this.qtU) != null) {
                        bsU = SightVideoJNI.getVideoPlayTime(b.e(this.qtU));
                        i = (int) bsU;
                        if (i != ((int) this.qtU.qtK)) {
                            b.z(this.qtU).b(this.qtU, (long) i);
                        }
                        this.qtU.qtK = bsU;
                    }
                    if (i2 == 0) {
                        b.a(this.qtU, -1.0d);
                        obj3 = null;
                    } else if (1 == i2) {
                        b.a(this.qtU, -1.0d);
                        obj3 = 1;
                        b.a(this.qtU, 0);
                        b.A(this.qtU);
                    } else if (-7 == i2) {
                        x.w("MicroMsg.SightPlayController", "surface is null, continue");
                        obj3 = null;
                    } else {
                        x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error:%d", new Object[]{Integer.valueOf(this.qtU.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2)});
                        this.otH = true;
                        if (this.qtZ != null) {
                            this.qtZ.otH = true;
                        }
                        this.qtU.C(null);
                        if (b.b(this.qtU) != null) {
                            b.b(this.qtU).d(this.qtU, -1);
                        }
                        obj3 = null;
                    }
                } else {
                    x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error, surface is not valid", new Object[]{Integer.valueOf(this.qtU.hashCode()), Integer.valueOf(hashCode())});
                    this.otH = true;
                    if (this.qtZ != null) {
                        this.qtZ.otH = true;
                        obj3 = null;
                    }
                    obj3 = null;
                }
                if (b.s(this.qtU) != null) {
                    x.d("MicroMsg.SightPlayController", "voice time is" + (b.s(this.qtU).bsU() / 1000.0d));
                    obj2 = obj3;
                } else {
                    obj2 = obj3;
                }
            } else {
                i2 = SightVideoJNI.drawFrame(b.e(this.qtU), b.B(this.qtU), (int) f2, null, false, b.y(this.qtU));
                if (b.z(this.qtU) != null) {
                    bsU = SightVideoJNI.getVideoPlayTime(b.e(this.qtU));
                    i = (int) bsU;
                    if (i != ((int) this.qtU.qtK)) {
                        b.z(this.qtU).b(this.qtU, (long) i);
                    }
                    this.qtU.qtK = bsU;
                    if (b.v(this.qtU)) {
                        x.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", new Object[]{Integer.valueOf(this.qtU.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2), Double.valueOf(bsU)});
                    }
                } else if (b.v(this.qtU)) {
                    bsU = SightVideoJNI.getVideoPlayTime(b.e(this.qtU));
                    if (b.v(this.qtU)) {
                        x.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", new Object[]{Integer.valueOf(this.qtU.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2), Double.valueOf(bsU)});
                    }
                } else if (b.v(this.qtU)) {
                    x.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d", new Object[]{Integer.valueOf(this.qtU.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2)});
                }
                if (i2 == 0) {
                    b.a(this.qtU, -1.0d);
                } else if (1 == i2) {
                    b.a(this.qtU, -1.0d);
                    obj2 = 1;
                    b.a(this.qtU, 0);
                    b.A(this.qtU);
                } else {
                    b.a(this.qtU, -1.0d);
                    x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw bitmap match error:%d", new Object[]{Integer.valueOf(this.qtU.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2)});
                    this.otH = true;
                    if (this.qtZ != null) {
                        this.qtZ.otH = true;
                    }
                    b.g(this.qtU).post(new Runnable(this) {
                        final /* synthetic */ b$b qub;

                        {
                            this.qub = r1;
                        }

                        public final void run() {
                            this.qub.qtU.D(null);
                        }
                    });
                    if (b.b(this.qtU) != null) {
                        b.b(this.qtU).d(this.qtU, -1);
                    }
                }
            }
            if (1 == i2) {
                b.g(this.qtU).post(new 4(this));
            }
            if (this.otH) {
                x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at end", new Object[]{Integer.valueOf(this.qtU.hashCode()), Integer.valueOf(hashCode())});
                if (b.s(this.qtU) != null) {
                    b.s(this.qtU).type = 0;
                    b.s(this.qtU).run();
                    return;
                }
                return;
            }
            if (1 == b.d(this.qtU)) {
                long currentTimeMillis2 = ((long) this.qtU.qto) - (System.currentTimeMillis() - b.r(this.qtU));
                if (b.r(this.qtU) == 0) {
                    o.c(this, (long) (this.qtU.qto * 5));
                } else if (currentTimeMillis2 > 0) {
                    o.c(this, currentTimeMillis2);
                } else {
                    o.c(this, 0);
                }
            } else if (obj2 == null || b.q(this.qtU) == null) {
                this.qtZ.quc = i2;
                b.g(this.qtU).post(this.qtZ);
            } else {
                i = b.q(this.qtU).bsR();
                b.g(this.qtU).post(new 5(this));
                this.qtZ.quc = i2;
                b.g(this.qtU).postDelayed(this.qtZ, (long) i);
            }
            if (b.s(this.qtU) != null) {
                x.d("MicroMsg.SightPlayController", "voice time is" + (b.s(this.qtU).bsU() / 1000.0d));
            }
        }
    }
}
