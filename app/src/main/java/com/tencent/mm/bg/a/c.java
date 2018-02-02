package com.tencent.mm.bg.a;

import android.content.SharedPreferences;
import android.os.Looper;
import com.qq.wx.voice.vad.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Locale;

public class c {
    private static final String TAG = c.class.getSimpleName();
    public static SharedPreferences gZO = ac.cft();
    private boolean hYW;
    private int hYX;
    private boolean hYY;
    private boolean hYZ;
    private long hZa;
    private int hZb;
    private boolean hZc;
    private a hZd;
    private a hZe;
    public a hZf;
    private short[] hZg;
    private af handler;

    public static String Va() {
        return String.format(Locale.CHINA, "%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s", new Object[]{"sil_time", Integer.valueOf(gZO.getInt("sil_time", 500)), "s_n_ration", Float.valueOf(gZO.getFloat("s_n_ration", 2.5f)), "s_window", Integer.valueOf(gZO.getInt("s_window", 500)), "s_length", Integer.valueOf(gZO.getInt("s_length", 350)), "s_delay_time", Integer.valueOf(gZO.getInt("s_delay_time", 550))});
    }

    public c() {
        this(3500, 16000, gZO.getInt("sil_time", 1000), gZO.getFloat("s_n_ration", 2.5f), gZO.getInt("s_window", 500), gZO.getInt("s_length", 350), gZO.getInt("s_delay_time", 550), true, true);
    }

    public c(int i, int i2, int i3, float f, int i4, int i5, int i6, boolean z, boolean z2) {
        this.hYW = true;
        this.hYX = 3;
        this.hYY = false;
        this.hYZ = false;
        this.hZa = 0;
        this.hZb = 3500;
        this.hZc = false;
        this.handler = new 1(this, Looper.getMainLooper());
        this.hZd = null;
        this.hZe = null;
        this.hZb = i;
        this.hZe = new a();
        int i7 = 0;
        if (ac.cfw()) {
            com.tencent.mm.storage.c fn = com.tencent.mm.z.c.c.IF().fn("100235");
            if (fn.isValid()) {
                i7 = bh.getInt((String) fn.chI().get("MMVoipVadOn"), 0);
            }
        }
        x.i(TAG, "VoiceSilentDetectAPI: abTestFlag = [%s]", new Object[]{Integer.valueOf(i7)});
        if (i7 == 0) {
            a.av(false);
        } else {
            a.av(true);
        }
        a aVar = this.hZe;
        if (a.bgz) {
            aVar.bgw = aVar.bgy.Init(16000, i3, f, i4, i5);
        } else {
            aVar.bgw = aVar.bgx.Init(16000, i3, f, i4, i5);
        }
        if (a.DEBUG) {
            System.out.println("EVad Init handle = " + aVar.bgw);
        }
        if ((aVar.bgw == 0 ? 1 : 0) != 1) {
            a aVar2 = this.hZe;
            if (aVar2.bgw == 0) {
                i7 = 1;
            } else {
                if (a.DEBUG) {
                    System.out.println("EVad Reset handle = " + aVar2.bgw);
                }
                i7 = a.bgz ? aVar2.bgy.Reset(aVar2.bgw) : aVar2.bgx.Reset(aVar2.bgw);
            }
            if (i7 != 1) {
                this.hZd = new a(i6 * 16);
                this.hZg = new short[4000];
                this.handler.removeMessages(0);
                this.handler.sendEmptyMessageDelayed(0, (long) i);
                this.hYY = z;
                this.hYZ = z2;
                return;
            }
        }
        throw new b("Init ERROR");
    }

    public final void c(short[] sArr, int i) {
        x.d(TAG, "input() called with: voice = [%s], length = [%s]", new Object[]{sArr, Integer.valueOf(i)});
        if (sArr != null && sArr.length != 0 && i > 0 && i <= sArr.length) {
            if (this.hZc) {
                x.i(TAG, "VoiceSilentDetectAPI is released.");
                return;
            }
            int i2;
            int length;
            int i3;
            a aVar = this.hZe;
            if (aVar.bgw == 0) {
                i2 = 1;
            } else {
                if (a.DEBUG) {
                    System.out.println("EVad AddData handle = " + aVar.bgw);
                }
                i2 = a.bgz ? aVar.bgy.AddData(aVar.bgw, sArr, i) : aVar.bgx.AddData(aVar.bgw, sArr, i);
            }
            x.d(TAG, "currState = %s,prevState = %s,directFirstStart = %s,directTempState = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(this.hYX), Boolean.valueOf(this.hYY), Boolean.valueOf(this.hYZ)});
            long currentTimeMillis;
            int i4;
            if (this.hYY) {
                if (this.hYZ) {
                    currentTimeMillis = System.currentTimeMillis();
                    if (this.hZf != null) {
                        this.hZf.UW();
                    }
                    this.hZa = currentTimeMillis;
                    if (!this.hZc) {
                        i4 = this.hZd.hYU;
                        length = this.hZg.length;
                        while (i4 > 0) {
                            if (length > i4) {
                                i3 = i4;
                            } else {
                                i3 = length;
                            }
                            this.hZd.b(this.hZg, i3);
                            i4 -= i3;
                            if (this.hZf != null) {
                                this.hZf.a(this.hZg, i3);
                            }
                        }
                        this.hYZ = false;
                        this.handler.removeMessages(0);
                        this.handler.sendEmptyMessageDelayed(0, (long) this.hZb);
                    } else {
                        return;
                    }
                }
                if (this.hYX == 3 && i2 == 2) {
                    this.hYY = false;
                }
                if (!(this.hYX == 3 && i2 == 3)) {
                    this.handler.removeMessages(0);
                    this.handler.sendEmptyMessageDelayed(0, (long) this.hZb);
                }
                this.hYW = false;
                this.hYX = i2;
            } else if (this.hYX == 3 && i2 == 2) {
                this.hYX = i2;
                this.handler.removeMessages(0);
                this.handler.sendEmptyMessageDelayed(0, (long) this.hZb);
                currentTimeMillis = System.currentTimeMillis();
                if (this.hZf != null) {
                    this.hZf.UW();
                }
                this.hZa = currentTimeMillis;
                if (!this.hZc) {
                    i3 = this.hZd.hYU;
                    i4 = this.hZg.length;
                    while (i3 > 0) {
                        if (i4 > i3) {
                            i2 = i3;
                        } else {
                            i2 = i4;
                        }
                        this.hZd.b(this.hZg, i2);
                        i3 -= i2;
                        if (this.hZf != null) {
                            this.hZf.a(this.hZg, i2);
                        }
                    }
                    this.hYW = false;
                } else {
                    return;
                }
            } else if (this.hYX == 2 && i2 == 3) {
                this.hYX = i2;
                this.hYW = true;
                this.handler.removeMessages(0);
                this.handler.sendEmptyMessageDelayed(0, (long) this.hZb);
                currentTimeMillis = System.currentTimeMillis();
                if (this.hZf != null) {
                    this.hZf.UV();
                }
                this.hZa = currentTimeMillis;
                if (this.hZc) {
                    return;
                }
            } else if (this.hYX == 3 && i2 == 3) {
                this.hYW = true;
            } else if (this.hYX == 2 && i2 == 2) {
                this.hYW = false;
                this.handler.removeMessages(0);
                this.handler.sendEmptyMessageDelayed(0, (long) this.hZb);
            }
            if (!this.hZc) {
                a aVar2 = this.hZd;
                if (sArr.length >= 0) {
                    i3 = i > sArr.length + 0 ? sArr.length + 0 : i;
                    if (i3 != 0) {
                        i2 = aVar2.hYV.length - aVar2.hYU;
                        if (i3 > i2) {
                            i2 = i3 - i2;
                            if (i2 != 0) {
                                if (i2 >= aVar2.hYU) {
                                    i2 = aVar2.hYU;
                                }
                                if (i2 <= aVar2.hYV.length - aVar2.hYS) {
                                    aVar2.hYS += i2;
                                    if (aVar2.hYS >= aVar2.hYV.length) {
                                        aVar2.hYS = 0;
                                    }
                                } else {
                                    aVar2.hYS = i2 - (aVar2.hYV.length - aVar2.hYS);
                                }
                                aVar2.hYU -= i2;
                            }
                        }
                        if (i3 > aVar2.hYV.length) {
                            i3 = (i3 - aVar2.hYV.length) + 0;
                            i2 = aVar2.hYV.length;
                        } else {
                            i2 = i3;
                            i3 = 0;
                        }
                        if (i2 <= aVar2.hYV.length - aVar2.hYT) {
                            System.arraycopy(sArr, i3, aVar2.hYV, aVar2.hYT, i2);
                            aVar2.hYT += i2;
                            if (aVar2.hYT >= aVar2.hYV.length) {
                                aVar2.hYT = 0;
                            }
                        } else {
                            length = aVar2.hYV.length - aVar2.hYT;
                            System.arraycopy(sArr, i3, aVar2.hYV, aVar2.hYT, length);
                            int i5 = i2 - length;
                            System.arraycopy(sArr, i3 + length, aVar2.hYV, 0, i5);
                            aVar2.hYT = i5;
                        }
                        aVar2.hYU = i2 + aVar2.hYU;
                    }
                }
                x.d(TAG, "isSilent %s", new Object[]{Boolean.valueOf(this.hYW)});
                if (!this.hYW && this.hZf != null) {
                    this.hZf.a(sArr, i);
                }
            }
        }
    }

    public final void release() {
        x.d(TAG, "released");
        this.hZc = true;
        this.hYY = false;
        this.hYZ = false;
        if (this.hZe != null) {
            int i;
            a aVar = this.hZe;
            if (aVar.bgw == 0) {
                i = 1;
            } else {
                if (a.DEBUG) {
                    System.out.println("EVad Release handle = " + aVar.bgw);
                }
                i = a.bgz ? aVar.bgy.Release(aVar.bgw) : aVar.bgx.Release(aVar.bgw);
            }
            if (i == 1) {
                throw new b();
            }
            this.hZe = null;
        }
        this.hZd = null;
        this.hZg = null;
        if (this.handler != null) {
            this.handler.removeMessages(0);
            this.handler = null;
        }
        this.hZf = null;
    }
}
