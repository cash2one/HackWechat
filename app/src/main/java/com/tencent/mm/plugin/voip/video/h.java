package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Looper;
import android.os.Vibrator;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.R;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.k.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class h {
    public boolean fdc = false;
    private AudioManager gHn;
    private b hXN;
    af hae = new af(Looper.getMainLooper());
    private Vibrator lmg;
    public Context mContext;
    public MediaPlayer suE;
    public int suF = 65536;
    public long suG;
    public long suH;
    a suI;

    public h(Context context) {
        this.mContext = context;
        if (this.mContext != null) {
            this.gHn = ar.Hh().gCe;
            if (this.gHn == null) {
                this.gHn = (AudioManager) this.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            }
            this.lmg = (Vibrator) this.mContext.getSystemService("vibrator");
        }
        this.hXN = new b(ac.getContext());
    }

    public final void jp(boolean z) {
        int i = 0;
        x.i("MicroMsg.RingPlayer", "setSpeakerStatus, isSpeakerOn: %b", new Object[]{Boolean.valueOf(z)});
        if (!z) {
            if (d.fM(21)) {
                i = 3;
            } else {
                i = 2;
            }
        }
        if (z && q.gFV.gDp >= 0) {
            i = q.gFV.gDp;
        } else if (!z && q.gFV.gDn >= 0) {
            i = q.gFV.gDn;
        }
        if (i != this.gHn.getMode()) {
            this.gHn.setMode(i);
        }
        if (z != this.gHn.isSpeakerphoneOn()) {
            this.gHn.setSpeakerphoneOn(z);
        }
    }

    public final void jq(boolean z) {
        if (!this.fdc) {
            x.i("MicroMsg.RingPlayer", "now we start play ");
            try {
                this.suE = j.a(this.mContext, RingtoneManager.getActualDefaultRingtoneUri(this.mContext, 1));
                if (this.suE != null) {
                    this.suE.stop();
                    this.suE.prepare();
                    this.suE.setLooping(true);
                    jp(true);
                    if (z) {
                        this.suE.setVolume(0.6f, 0.6f);
                    } else {
                        bIG();
                    }
                    switch (this.gHn.getRingerMode()) {
                        case 2:
                            if (this.suE != null) {
                                this.suE.start();
                                break;
                            }
                            break;
                    }
                    this.fdc = true;
                }
            } catch (Exception e) {
                x.e("ex", e.getMessage());
            }
        }
    }

    public final void stop() {
        x.d("MicroMsg.RingPlayer", "stop, isStarted: %b", new Object[]{Boolean.valueOf(this.fdc)});
        if (this.lmg != null) {
            this.lmg.cancel();
            this.lmg = null;
        }
        if (this.suE != null && this.fdc) {
            try {
                this.suE.stop();
                this.suE.release();
                if (this.suI != null) {
                    this.hae.removeCallbacks(this.suI);
                }
                this.fdc = false;
                ar.Hh().setMode(0);
            } catch (Exception e) {
                x.e("MicroMsg.RingPlayer", e.toString());
            }
        }
    }

    public final boolean aip() {
        return !this.fdc;
    }

    public final void l(int i, int i2, boolean z) {
        boolean booleanValue;
        Exception e;
        boolean z2;
        boolean xR;
        int i3;
        int i4;
        int streamMaxVolume;
        if (i2 == 0) {
            try {
                ar.Hg();
                booleanValue = ((Boolean) c.CU().get(73217, Boolean.valueOf(true))).booleanValue();
            } catch (Exception e2) {
                e = e2;
                booleanValue = true;
                x.e("MicroMsg.RingPlayer", "get voip sound failed: " + e.getMessage());
                z2 = true;
                if (!!booleanValue) {
                }
                if (!booleanValue) {
                    try {
                        this.suG = System.currentTimeMillis();
                        this.suE = new j();
                        try {
                            boolean xL;
                            this.suE.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + "/" + i));
                            this.suE.setOnCompletionListener(new 1(this));
                            this.suE.setOnErrorListener(new 2(this));
                            xL = ar.Hh().xL();
                            xR = ar.Hh().xR();
                            x.d("MicroMsg.RingPlayer", "isBluetoothOn: %b, isHeadsetPlugged: %b", new Object[]{Boolean.valueOf(xL), Boolean.valueOf(xR)});
                            if (xL) {
                                if (!z) {
                                }
                                if (q.gFV.gDm >= 0) {
                                    i3 = 0;
                                } else {
                                    i3 = q.gFV.gDm;
                                }
                                if (!xR) {
                                }
                                jp(false);
                                i4 = i3;
                            } else {
                                i3 = ar.Hh().xX();
                                jp(false);
                                i4 = i3;
                            }
                            this.suE.setAudioStreamType(i4);
                            if (!xR) {
                            }
                            streamMaxVolume = this.gHn.getStreamMaxVolume(i4);
                            i3 = this.gHn.getStreamVolume(i4);
                            if (i3 > streamMaxVolume / 2) {
                                i3 = streamMaxVolume / 2;
                            }
                            this.gHn.setStreamVolume(i4, i3, 0);
                            this.suE.setLooping(true);
                            this.suE.prepare();
                            this.suE.start();
                            if (System.currentTimeMillis() - this.suG > 2000) {
                                this.suF = 3;
                            }
                        } catch (Throwable th) {
                            x.e("MicroMsg.RingPlayer", "startPlayCustomRing failed, " + th.getMessage());
                            this.suF = 2;
                            try {
                                this.suE = j.a(this.mContext, RingtoneManager.getActualDefaultRingtoneUri(this.mContext, 1));
                                if (this.suE != null) {
                                    this.suE.stop();
                                    this.suE.prepare();
                                    this.suE.setLooping(true);
                                    if (z) {
                                        this.suE.setVolume(0.6f, 0.6f);
                                    } else if (z2) {
                                        bIG();
                                    }
                                    this.suE.start();
                                    this.suF = 0;
                                } else {
                                    return;
                                }
                            } catch (Exception e3) {
                                x.e("ex", e3.getMessage());
                                this.suF = 2;
                            }
                        }
                        this.fdc = true;
                    } catch (Exception e32) {
                        x.e("MicroMsg.RingPlayer", "new MediaPlayer failed, " + e32.toString());
                        return;
                    }
                } else if (z2) {
                } else {
                    return;
                }
            }
        } else if (i2 == 1 || i2 == 2) {
            ar.Hg();
            booleanValue = ((Boolean) c.CU().get(73218, Boolean.valueOf(true))).booleanValue();
        } else {
            booleanValue = true;
        }
        try {
            x.i("MicroMsg.RingPlayer", "startPlayCustomRing, voipSound: %s, msgSound: %s, msgShake: %s", new Object[]{Boolean.valueOf(booleanValue), Boolean.valueOf(a.zr()), Boolean.valueOf(a.zt())});
            booleanValue = a.zr();
            z2 = a.zt();
        } catch (Exception e4) {
            e32 = e4;
            x.e("MicroMsg.RingPlayer", "get voip sound failed: " + e32.getMessage());
            z2 = true;
            if (!booleanValue) {
            }
            if (!booleanValue) {
                this.suG = System.currentTimeMillis();
                this.suE = new j();
                this.suE.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + "/" + i));
                this.suE.setOnCompletionListener(new 1(this));
                this.suE.setOnErrorListener(new 2(this));
                xL = ar.Hh().xL();
                xR = ar.Hh().xR();
                x.d("MicroMsg.RingPlayer", "isBluetoothOn: %b, isHeadsetPlugged: %b", new Object[]{Boolean.valueOf(xL), Boolean.valueOf(xR)});
                if (xL) {
                    i3 = ar.Hh().xX();
                    jp(false);
                    i4 = i3;
                } else {
                    if (z) {
                    }
                    if (q.gFV.gDm >= 0) {
                        i3 = q.gFV.gDm;
                    } else {
                        i3 = 0;
                    }
                    if (xR) {
                    }
                    jp(false);
                    i4 = i3;
                }
                this.suE.setAudioStreamType(i4);
                if (xR) {
                }
                streamMaxVolume = this.gHn.getStreamMaxVolume(i4);
                i3 = this.gHn.getStreamVolume(i4);
                if (i3 > streamMaxVolume / 2) {
                    i3 = streamMaxVolume / 2;
                }
                this.gHn.setStreamVolume(i4, i3, 0);
                this.suE.setLooping(true);
                this.suE.prepare();
                this.suE.start();
                if (System.currentTimeMillis() - this.suG > 2000) {
                    this.suF = 3;
                }
                this.fdc = true;
            } else if (z2) {
                return;
            }
        }
        if ((!booleanValue && !z2) || this.fdc) {
            return;
        }
        if (!booleanValue) {
            this.suG = System.currentTimeMillis();
            this.suE = new j();
            this.suE.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + "/" + i));
            this.suE.setOnCompletionListener(new 1(this));
            this.suE.setOnErrorListener(new 2(this));
            xL = ar.Hh().xL();
            xR = ar.Hh().xR();
            x.d("MicroMsg.RingPlayer", "isBluetoothOn: %b, isHeadsetPlugged: %b", new Object[]{Boolean.valueOf(xL), Boolean.valueOf(xR)});
            if (xL) {
                i3 = ar.Hh().xX();
                jp(false);
                i4 = i3;
            } else if (z || xR) {
                if (q.gFV.gDm >= 0) {
                    i3 = q.gFV.gDm;
                } else {
                    i3 = 0;
                }
                if (xR || i2 == 1) {
                    jp(false);
                    i4 = i3;
                } else {
                    if (q.gFV.gDj >= 0) {
                        i3 = q.gFV.gDj;
                    } else {
                        i3 = 3;
                    }
                    jp(true);
                    i4 = i3;
                }
            } else {
                if (ar.Hh().xL() || q.gFV.gDo < 0) {
                    i3 = 2;
                } else {
                    i3 = q.gFV.gDo;
                }
                jp(true);
                i4 = i3;
            }
            this.suE.setAudioStreamType(i4);
            if (xR || xL) {
                streamMaxVolume = this.gHn.getStreamMaxVolume(i4);
                i3 = this.gHn.getStreamVolume(i4);
                if (i3 > streamMaxVolume / 2) {
                    i3 = streamMaxVolume / 2;
                }
                this.gHn.setStreamVolume(i4, i3, 0);
            } else if (z) {
                this.suE.setVolume(0.6f, 0.6f);
            } else if (z2) {
                bIG();
            }
            this.suE.setLooping(true);
            this.suE.prepare();
            this.suE.start();
            if (System.currentTimeMillis() - this.suG > 2000) {
                this.suF = 3;
            }
            this.fdc = true;
        } else if (z2 && !z) {
            bIG();
        }
    }

    public final void a(int i, long j, boolean z, int i2) {
        this.suG = System.currentTimeMillis();
        this.suE = new j();
        try {
            this.suE.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + "/" + i));
            this.suE.setOnCompletionListener(new 3(this, i, j, z, i2));
            this.suE.setOnErrorListener(new 4(this));
            this.suE.setAudioStreamType(i2);
            if (z) {
                this.suE.setVolume(0.6f, 0.6f);
            } else {
                bIG();
            }
            this.suE.setLooping(false);
            this.suE.prepare();
            this.suE.start();
            if (System.currentTimeMillis() - this.suG > 2000) {
                this.suF = 3;
            }
        } catch (Exception e) {
            x.e("MicroMsg.RingPlayer", "new MediaPlayer failed, " + e.toString());
        }
    }

    private void bIG() {
        if (this.mContext.getSharedPreferences(ac.cfs(), 0).getBoolean("settings_shake", true)) {
            int ringerMode = this.gHn.getRingerMode();
            if (ringerMode == 1 || ringerMode == 2) {
                this.lmg = (Vibrator) this.mContext.getSystemService("vibrator");
                if (this.lmg != null) {
                    this.lmg.vibrate(new long[]{1000, 1000, 1000, 1000}, 0);
                }
            }
        }
    }

    public final void m(int i, int i2, boolean z) {
        this.suF = 0;
        if (i == 0) {
            jq(z);
        } else {
            l(i, i2, z);
        }
    }

    public final void b(int i, boolean z, int i2, boolean z2) {
        Exception e;
        MediaPlayer jVar;
        if (i != R.k.dAl || ar.Hh().xL() || ar.Hh().xR() || !(this.gHn.getRingerMode() == 0 || this.gHn.getRingerMode() == 1)) {
            boolean booleanValue;
            boolean z3 = this.mContext.getSharedPreferences(ac.cfs(), 0).getBoolean("settings_shake", true);
            if (z) {
                bh.m(this.mContext, z3);
            }
            if (i2 == 0) {
                try {
                    ar.Hg();
                    booleanValue = ((Boolean) c.CU().get(73217, Boolean.valueOf(true))).booleanValue();
                } catch (Exception e2) {
                    e = e2;
                    booleanValue = true;
                    x.e("MicroMsg.RingPlayer", "get voip sound failed: " + e.getMessage());
                    if (!booleanValue) {
                        this.suH = System.currentTimeMillis();
                        jVar = new j();
                        try {
                            jVar.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + "/" + i));
                            jVar.setOnCompletionListener(new 5(this));
                            jVar.setOnErrorListener(new 6(this));
                            if (z2) {
                                jVar.setAudioStreamType(ar.Hh().xL() ? ar.Hh().xX() : 0);
                            }
                            jVar.setVolume(0.5f, 0.5f);
                            jVar.prepare();
                            jVar.setLooping(false);
                            jVar.start();
                            if (System.currentTimeMillis() - this.suH <= 2000) {
                                this.suF = 7;
                            }
                        } catch (Throwable th) {
                            x.w("MicroMsg.RingPlayer", "playSound Failed Throwable t = ", new Object[]{th});
                            this.suF = 6;
                            return;
                        }
                    }
                }
            } else if (i2 == 1) {
                ar.Hg();
                booleanValue = ((Boolean) c.CU().get(73218, Boolean.valueOf(true))).booleanValue();
            } else {
                booleanValue = true;
            }
            try {
                x.i("MicroMsg.RingPlayer", "playSound, voipSound: %s, msgSound: %s", new Object[]{Boolean.valueOf(booleanValue), Boolean.valueOf(a.zr())});
                booleanValue = a.zr();
            } catch (Exception e3) {
                e = e3;
                x.e("MicroMsg.RingPlayer", "get voip sound failed: " + e.getMessage());
                if (!booleanValue) {
                    this.suH = System.currentTimeMillis();
                    jVar = new j();
                    jVar.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + "/" + i));
                    jVar.setOnCompletionListener(new 5(this));
                    jVar.setOnErrorListener(new 6(this));
                    if (z2) {
                        if (ar.Hh().xL()) {
                        }
                        jVar.setAudioStreamType(ar.Hh().xL() ? ar.Hh().xX() : 0);
                    }
                    jVar.setVolume(0.5f, 0.5f);
                    jVar.prepare();
                    jVar.setLooping(false);
                    jVar.start();
                    if (System.currentTimeMillis() - this.suH <= 2000) {
                        this.suF = 7;
                    }
                }
            }
            if (!booleanValue) {
                this.suH = System.currentTimeMillis();
                jVar = new j();
                jVar.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + "/" + i));
                jVar.setOnCompletionListener(new 5(this));
                jVar.setOnErrorListener(new 6(this));
                if (z2) {
                    if (ar.Hh().xL()) {
                    }
                    jVar.setAudioStreamType(ar.Hh().xL() ? ar.Hh().xX() : 0);
                }
                if (i == R.k.dAl && (ar.Hh().xL() || ar.Hh().xR())) {
                    jVar.setVolume(0.5f, 0.5f);
                }
                jVar.prepare();
                jVar.setLooping(false);
                jVar.start();
                if (System.currentTimeMillis() - this.suH <= 2000) {
                    this.suF = 7;
                }
            }
        }
    }

    public final void e(int i, boolean z, int i2) {
        b(i, false, i2, true);
    }

    public final int bIH() {
        x.d("MicroMsg.RingPlayer", "RingPlayer  mRingPlayerErrState:" + this.suF);
        return this.suF;
    }
}
