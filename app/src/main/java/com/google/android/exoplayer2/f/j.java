package com.google.android.exoplayer2.f;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.a;
import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.k;
import java.util.Collections;
import java.util.List;

public final class j extends a implements Callback {
    private boolean apW;
    private boolean apX;
    private final k apw;
    private final Handler aqs;
    private final a awe;
    private final g awf;
    private int awg;
    private Format awh;
    private e awi;
    private h awj;
    private i awk;
    private i awl;
    private int awm;

    public j(a aVar, Looper looper) {
        this(aVar, looper, g.awc);
    }

    private j(a aVar, Looper looper, g gVar) {
        super(3);
        this.awe = (a) com.google.android.exoplayer2.i.a.Y(aVar);
        this.aqs = looper == null ? null : new Handler(looper, this);
        this.awf = gVar;
        this.apw = new k();
    }

    public final int b(Format format) {
        if (this.awf.g(format)) {
            return 4;
        }
        return g.ab(format.adV) ? 1 : 0;
    }

    protected final void a(Format[] formatArr, long j) {
        this.awh = formatArr[0];
        if (this.awi != null) {
            this.awg = 1;
        } else {
            this.awi = this.awf.k(this.awh);
        }
    }

    protected final void a(long j, boolean z) {
        m(Collections.emptyList());
        this.apW = false;
        this.apX = false;
        if (this.awg != 0) {
            kM();
            return;
        }
        kK();
        this.awi.flush();
    }

    public final void c(long j, long j2) {
        if (!this.apX) {
            if (this.awl == null) {
                this.awi.K(j);
                try {
                    this.awl = (i) this.awi.jb();
                } catch (Exception e) {
                    throw e.a(e, this.index);
                }
            }
            if (this.state == 2) {
                boolean z;
                if (this.awk != null) {
                    long kN = kN();
                    z = false;
                    while (kN <= j) {
                        this.awm++;
                        kN = kN();
                        z = true;
                    }
                } else {
                    z = false;
                }
                if (this.awl != null) {
                    if (this.awl.iY()) {
                        if (!z && kN() == Long.MAX_VALUE) {
                            if (this.awg == 2) {
                                kM();
                            } else {
                                kK();
                                this.apX = true;
                            }
                        }
                    } else if (this.awl.aig <= j) {
                        if (this.awk != null) {
                            this.awk.release();
                        }
                        this.awk = this.awl;
                        this.awl = null;
                        this.awm = this.awk.L(j);
                        z = true;
                    }
                }
                if (z) {
                    m(this.awk.M(j));
                }
                if (this.awg != 2) {
                    while (!this.apW) {
                        if (this.awj == null) {
                            this.awj = (h) this.awi.ja();
                            if (this.awj == null) {
                                return;
                            }
                        }
                        if (this.awg == 1) {
                            this.awj.flags = 4;
                            this.awi.V(this.awj);
                            this.awj = null;
                            this.awg = 2;
                            return;
                        }
                        try {
                            int a = a(this.apw, this.awj, false);
                            if (a == -4) {
                                if (this.awj.iY()) {
                                    this.apW = true;
                                } else {
                                    this.awj.aej = this.apw.aeo.aej;
                                    this.awj.je();
                                }
                                this.awi.V(this.awj);
                                this.awj = null;
                            } else if (a == -3) {
                                return;
                            }
                        } catch (Exception e2) {
                            throw e.a(e2, this.index);
                        }
                    }
                }
            }
        }
    }

    protected final void hW() {
        this.awh = null;
        m(Collections.emptyList());
        kL();
    }

    public final boolean it() {
        return this.apX;
    }

    public final boolean is() {
        return true;
    }

    private void kK() {
        this.awj = null;
        this.awm = -1;
        if (this.awk != null) {
            this.awk.release();
            this.awk = null;
        }
        if (this.awl != null) {
            this.awl.release();
            this.awl = null;
        }
    }

    private void kL() {
        kK();
        this.awi.release();
        this.awi = null;
        this.awg = 0;
    }

    private void kM() {
        kL();
        this.awi = this.awf.k(this.awh);
    }

    private long kN() {
        if (this.awm == -1 || this.awm >= this.awk.kJ()) {
            return Long.MAX_VALUE;
        }
        return this.awk.cH(this.awm);
    }

    private void m(List<a> list) {
        if (this.aqs != null) {
            this.aqs.obtainMessage(0, list).sendToTarget();
        } else {
            n(list);
        }
    }

    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                n((List) message.obj);
                return true;
            default:
                throw new IllegalStateException();
        }
    }

    private void n(List<a> list) {
        this.awe.i(list);
    }
}
