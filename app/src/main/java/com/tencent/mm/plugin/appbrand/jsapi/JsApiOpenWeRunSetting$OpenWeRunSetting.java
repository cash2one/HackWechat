package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.bm.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.sport.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

class JsApiOpenWeRunSetting$OpenWeRunSetting extends MainProcessTask {
    public static final Creator<JsApiOpenWeRunSetting$OpenWeRunSetting> CREATOR = new 3();
    private boolean fJL = false;
    private e jcL;
    private j jcM;
    private int jcN;
    private boolean jdE = false;
    private boolean jdF;

    public JsApiOpenWeRunSetting$OpenWeRunSetting(e eVar, j jVar, int i, boolean z) {
        x.i("MicroMsg.JsApiOpenWeRunSetting", "OpenWeRunSetting");
        this.jcL = eVar;
        this.jcM = jVar;
        this.jcN = i;
        this.jdF = z;
    }

    public JsApiOpenWeRunSetting$OpenWeRunSetting(Parcel parcel) {
        f(parcel);
    }

    public final void Yr() {
        this.jdE = ((b) g.h(b.class)).dz(ac.getContext());
        if (!this.jdF || this.jdE) {
            afv();
        } else {
            ((a) g.h(a.class)).a(new a.a(this) {
                final /* synthetic */ JsApiOpenWeRunSetting$OpenWeRunSetting jdG;

                {
                    this.jdG = r1;
                }

                public final void m(boolean z, boolean z2) {
                    boolean z3;
                    JsApiOpenWeRunSetting$OpenWeRunSetting jsApiOpenWeRunSetting$OpenWeRunSetting = this.jdG;
                    if (z && z2) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    jsApiOpenWeRunSetting$OpenWeRunSetting.jdE = z3;
                    x.i("MicroMsg.JsApiOpenWeRunSetting", "After getUserState requestOk %b, hasStep %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
                    this.jdG.afv();
                }
            });
        }
    }

    private void afv() {
        if (!this.jdF || this.jdE) {
            this.fJL = ((b) g.h(b.class)).bDd();
            if (this.jdF && this.fJL) {
                ((b) g.h(b.class)).bDc();
            }
        }
        afp();
    }

    public final void Ys() {
        if (this.jdF && !this.jdE) {
            this.jcM.E(this.jcN, this.jcL.e("fail device not support", null));
            afj();
        } else if (this.fJL) {
            this.jcM.E(this.jcN, this.jcL.e("ok", null));
            afj();
        } else {
            Context a = this.jcL.a(this.jcM);
            if (a == null) {
                this.jcM.E(this.jcN, this.jcL.e("fail", null));
                afj();
                return;
            }
            AppBrandSysConfig appBrandSysConfig = this.jcM.irP.iqx;
            if (appBrandSysConfig == null || bh.ov(appBrandSysConfig.frn)) {
                this.jcM.E(this.jcN, this.jcL.e("fail", null));
                afj();
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("OpenWeRunSettingName", appBrandSysConfig.frn);
            a.jwN = new MMActivity.a(this) {
                final /* synthetic */ JsApiOpenWeRunSetting$OpenWeRunSetting jdG;

                {
                    this.jdG = r1;
                }

                public final void b(int i, int i2, Intent intent) {
                    if (i != (this.jdG.hashCode() & 65535)) {
                        this.jdG.afj();
                    } else if (i2 == -1) {
                        this.jdG.jcM.E(this.jdG.jcN, this.jdG.jcL.e("ok", null));
                        this.jdG.afj();
                    } else if (i2 == 0) {
                        this.jdG.jcM.E(this.jdG.jcN, this.jdG.jcL.e("cancel", null));
                        this.jdG.afj();
                    } else {
                        this.jdG.jcM.E(this.jdG.jcN, this.jdG.jcL.e("fail", null));
                        this.jdG.afj();
                    }
                }
            };
            d.a(a, "appbrand", ".ui.AppBrandOpenWeRunSettingUI", intent, hashCode() & 65535, false);
            afj();
        }
    }

    public final void f(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.jdE = z;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.fJL = z;
        if (parcel.readByte() == (byte) 0) {
            z2 = false;
        }
        this.jdF = z2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        byte b;
        byte b2 = (byte) 1;
        if (this.jdE) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (this.fJL) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (!this.jdF) {
            b2 = (byte) 0;
        }
        parcel.writeByte(b2);
    }
}
