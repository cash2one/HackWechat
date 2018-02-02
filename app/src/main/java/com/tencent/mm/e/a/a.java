package com.tencent.mm.e.a;

import android.content.Context;
import com.tencent.mm.ae.g;
import com.tencent.mm.ae.g.b;
import com.tencent.mm.ae.g.c;
import com.tencent.mm.ae.g.d;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.compatible.util.b$a;
import com.tencent.mm.e.b.g$b;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvoice.i;
import com.tencent.mm.modelvoice.j;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public final class a implements g, com.tencent.mm.compatible.b.f.a {
    private static String fjD = null;
    private Context context;
    private c fjA;
    private d fjB;
    private String fjC;
    private b$a fjE;
    public b fjF;
    public com.tencent.mm.ae.g.a fjG;
    private com.tencent.mm.modelvoice.d fjs;
    private boolean fjt;
    private boolean fju;
    private boolean fjv;
    private int fjw;
    private boolean fjx;
    private boolean fjy;
    private boolean fjz;

    public a(Context context) {
        this(context, 0);
    }

    public a(Context context, int i) {
        this.fjs = null;
        this.context = null;
        this.fjt = false;
        this.fju = false;
        this.fjv = false;
        this.fjw = 0;
        this.fjx = false;
        this.fjy = false;
        this.fjz = true;
        this.fjC = null;
        this.fjE = new 1(this);
        this.fjF = null;
        this.context = context;
        this.fjw = i;
        g$b com_tencent_mm_e_b_g_b = new g$b();
    }

    public final boolean isPlaying() {
        if (this.fjs == null) {
            return false;
        }
        return this.fjs.isPlaying();
    }

    public final boolean a(String str, boolean z, boolean z2, int i) {
        x.i("MicroMsg.SceneVoicePlayer", "start file name:[%s] speakerOn:[%b], isFullPath: %s, type: %s, userType: %s", str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(this.fjw));
        Assert.assertTrue(str.length() > 0);
        fjD = this.fjC;
        this.fjC = str;
        String str2;
        if (FileOp.bO(z2 ? str : q.getFullPath(str))) {
            if (i == -1) {
                i = o.e(str, this.fjw, z2);
            }
            if (i == 0) {
                if (this.context != null) {
                    this.fjs = new s(this.context);
                } else {
                    this.fjs = new s();
                }
            } else if (i == 1) {
                if (this.context != null) {
                    this.fjs = new j(this.context);
                } else {
                    this.fjs = new j();
                }
            } else if (i == 2) {
                if (this.context != null) {
                    this.fjs = new i(this.context);
                } else {
                    this.fjs = new i();
                }
            }
            if (this.fjs != null) {
                this.fjs.b(this.fjE);
            }
            this.fjt = z;
            this.fjx = z;
            if (f.xG().xR() || f.xG().xL()) {
                x.i("MicroMsg.SceneVoicePlayer", "headset plugged: %b, bluetoothon: %b", Boolean.valueOf(f.xG().xR()), Boolean.valueOf(f.xG().xL()));
                this.fjt = false;
            }
            f.xG().h(this.fjt, false);
            ve();
            setError();
            str2 = null;
            if (z2) {
                str2 = str;
            } else if (this.fjw == 0) {
                str2 = q.getFullPath(str);
            }
            f.xG().a((com.tencent.mm.compatible.b.f.a) this);
            if (!f.xG().xR()) {
                f.xG().xI();
                this.fjy = true;
            }
            if (this.fjs.K(str2, this.fjt)) {
                return true;
            }
            x.i("MicroMsg.SceneVoicePlayer", "start play error fileName[" + str + "], [" + z + "]");
            f.xG().xJ();
            this.fjy = false;
            return false;
        }
        str2 = "MicroMsg.SceneVoicePlayer";
        String str3 = "start, file %s not exist!, fullPath: %s";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (!z2) {
            str = q.getFullPath(str);
        }
        objArr[1] = str;
        x.e(str2, str3, objArr);
        return false;
    }

    public final boolean a(String str, boolean z, int i, int i2) {
        x.i("MicroMsg.SceneVoicePlayer", "start file name:[%s] speakerOn:[%b], isFullPath: %s, type: %s, userType: %s", str, Boolean.valueOf(z), Boolean.valueOf(true), Integer.valueOf(i), Integer.valueOf(this.fjw));
        Assert.assertTrue(str.length() > 0);
        if (FileOp.bO(str)) {
            if (i == -1) {
                i = o.e(str, this.fjw, true);
            }
            if (i == 0) {
                if (this.context != null) {
                    this.fjs = new s(this.context);
                } else {
                    this.fjs = new s();
                }
            } else if (i == 1) {
                if (this.context != null) {
                    this.fjs = new j(this.context);
                } else {
                    this.fjs = new j();
                }
            } else if (i == 2) {
                if (this.context != null) {
                    this.fjs = new i(this.context);
                } else {
                    this.fjs = new i();
                }
            }
            if (this.fjs != null) {
                this.fjs.b(this.fjE);
            }
            this.fjt = z;
            this.fjx = z;
            if (f.xG().xR() || f.xG().xL()) {
                x.i("MicroMsg.SceneVoicePlayer", "headset plugged: %b, bluetoothon: %b", Boolean.valueOf(f.xG().xR()), Boolean.valueOf(f.xG().xL()));
                this.fjt = false;
            }
            f.xG().h(this.fjt, false);
            ve();
            setError();
            f.xG().a((com.tencent.mm.compatible.b.f.a) this);
            if (!f.xG().xR()) {
                f.xG().xI();
                this.fjy = true;
            }
            if (this.fjs.c(str, this.fjt, i2)) {
                return true;
            }
            x.i("MicroMsg.SceneVoicePlayer", "start play fileName[" + str + "], [" + z + "]");
            f.xG().xJ();
            this.fjy = false;
            return false;
        }
        x.e("MicroMsg.SceneVoicePlayer", "start, file %s not exist!, fullPath: %s", str, str);
        return false;
    }

    public final boolean pause() {
        return aK(true);
    }

    public final boolean aK(boolean z) {
        if (this.fjs == null) {
            return false;
        }
        boolean aK;
        x.i("MicroMsg.SceneVoicePlayer", "pause");
        if (this.fjs.isPlaying()) {
            aK = this.fjs.aK(z);
        } else {
            aK = false;
        }
        if (aK) {
            if (this.fjy) {
                f.xG().xJ();
                this.fjy = false;
            }
            if (this.fjA != null) {
                this.fjA.bB(z);
            }
        }
        f.xG().setMode(0);
        return aK;
    }

    public final boolean vc() {
        if (this.fjs == null) {
            return false;
        }
        x.i("MicroMsg.SceneVoicePlayer", "resume");
        boolean vc = this.fjs.vc();
        if (vc) {
            f.xG().xI();
            this.fjy = true;
            if (f.xG().xL()) {
                this.fjt = false;
            }
            f.xG().h(this.fjt, false);
        }
        return vc;
    }

    public final boolean k(String str, boolean z) {
        return a(str, z, false, -1);
    }

    public final boolean vd() {
        return this.fju;
    }

    public final void stop() {
        aL(false);
    }

    public final void aL(boolean z) {
        if (this.fjs != null) {
            x.i("MicroMsg.SceneVoicePlayer", "stop, isRequestStartBluetooth: %b, player.isPlaying: %b, fromStart: %b", Boolean.valueOf(this.fjy), Boolean.valueOf(this.fjs.isPlaying()), Boolean.valueOf(z));
            this.fjs.vo();
            f.xG().b((com.tencent.mm.compatible.b.f.a) this);
            if (this.fjy && !z) {
                f.xG().xJ();
                this.fjy = false;
            }
            if (!(z || this.fjB == null)) {
                this.fjB.onStop();
            }
            f.xG().setMode(0);
        }
    }

    public final void aM(boolean z) {
        if (this.fjt != z) {
            this.fjt = z;
            if (this.fjs != null && this.fjs.isPlaying()) {
                this.fjs.aM(z);
            }
            f.xG().h(z, false);
        }
    }

    public final void a(b bVar) {
        this.fjF = bVar;
    }

    public final void a(c cVar) {
        this.fjA = cVar;
    }

    public final void a(d dVar) {
        this.fjB = dVar;
    }

    private void setError() {
        com.tencent.mm.modelvoice.d.b 2 = new 2(this);
        if (this.fjs != null) {
            this.fjs.a(2);
        }
    }

    public final void a(com.tencent.mm.ae.g.a aVar) {
        this.fjG = aVar;
    }

    private void ve() {
        com.tencent.mm.modelvoice.d.a 3 = new 3(this);
        if (this.fjs != null) {
            this.fjs.a(3);
        }
    }

    public final double vf() {
        if (this.fjs == null) {
            return 0.0d;
        }
        return this.fjs.vf();
    }

    public final void aN(boolean z) {
        x.i("MicroMsg.SceneVoicePlayer", "setContinuousPlay() continuousPlay:%s", Boolean.valueOf(z));
        this.fjv = z;
    }

    public final boolean vg() {
        if (this.fjs != null && this.fjs.getStatus() == 2) {
            return true;
        }
        return false;
    }

    public final void er(int i) {
        x.i("MicroMsg.SceneVoicePlayer", "onBluetoothHeadsetStateChange, status: %d, currentSpeaker: %b, bluetoothResumeSpeaker: %b, isRequestStartBluetooth: %b", Integer.valueOf(i), Boolean.valueOf(this.fjt), Boolean.valueOf(this.fjx), Boolean.valueOf(this.fjy));
        switch (i) {
            case 1:
                aM(false);
                return;
            case 2:
            case 4:
                aM(this.fjx);
                if (this.fjy) {
                    f.xG().xJ();
                    this.fjy = false;
                    return;
                }
                return;
            case 6:
                aM(this.fjx);
                if (this.fjs != null && this.fjs.isPlaying()) {
                    f.xG().xI();
                    this.fjy = true;
                    return;
                }
                return;
            case 7:
                if (this.fjs != null && this.fjs.isPlaying()) {
                    f.xG().xI();
                    this.fjy = true;
                    return;
                }
                return;
            default:
                return;
        }
    }
}
