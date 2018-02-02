package com.google.android.exoplayer2.metadata;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.k;
import java.util.Arrays;

public final class e extends com.google.android.exoplayer2.a implements Callback {
    private boolean apW;
    private final k apw;
    private final c aqq;
    private final a aqr;
    private final Handler aqs;
    private final d aqt;
    private final Metadata[] aqu;
    private final long[] aqv;
    private int aqw;
    private int aqx;
    private a aqy;

    public interface a {
        void a(Metadata metadata);
    }

    public e(a aVar, Looper looper) {
        this(aVar, looper, c.aqp);
    }

    private e(a aVar, Looper looper, c cVar) {
        super(4);
        this.aqr = (a) com.google.android.exoplayer2.i.a.Y(aVar);
        this.aqs = looper == null ? null : new Handler(looper, this);
        this.aqq = (c) com.google.android.exoplayer2.i.a.Y(cVar);
        this.apw = new k();
        this.aqt = new d();
        this.aqu = new Metadata[5];
        this.aqv = new long[5];
    }

    public final int b(Format format) {
        return this.aqq.g(format) ? 4 : 0;
    }

    protected final void a(Format[] formatArr, long j) {
        this.aqy = this.aqq.h(formatArr[0]);
    }

    protected final void a(long j, boolean z) {
        jT();
        this.apW = false;
    }

    public final void c(long j, long j2) {
        if (!this.apW && this.aqx < 5) {
            this.aqt.clear();
            if (a(this.apw, this.aqt, false) == -4) {
                if (this.aqt.iY()) {
                    this.apW = true;
                } else if (!this.aqt.iX()) {
                    this.aqt.aej = this.apw.aeo.aej;
                    this.aqt.je();
                    try {
                        int i = (this.aqw + this.aqx) % 5;
                        this.aqu[i] = this.aqy.a(this.aqt);
                        this.aqv[i] = this.aqt.aig;
                        this.aqx++;
                    } catch (Exception e) {
                        throw com.google.android.exoplayer2.e.a(e, this.index);
                    }
                }
            }
        }
        if (this.aqx > 0 && this.aqv[this.aqw] <= j) {
            Metadata metadata = this.aqu[this.aqw];
            if (this.aqs != null) {
                this.aqs.obtainMessage(0, metadata).sendToTarget();
            } else {
                b(metadata);
            }
            this.aqu[this.aqw] = null;
            this.aqw = (this.aqw + 1) % 5;
            this.aqx--;
        }
    }

    protected final void hW() {
        jT();
        this.aqy = null;
    }

    public final boolean it() {
        return this.apW;
    }

    public final boolean is() {
        return true;
    }

    private void jT() {
        Arrays.fill(this.aqu, null);
        this.aqw = 0;
        this.aqx = 0;
    }

    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                b((Metadata) message.obj);
                return true;
            default:
                throw new IllegalStateException();
        }
    }

    private void b(Metadata metadata) {
        this.aqr.a(metadata);
    }
}
