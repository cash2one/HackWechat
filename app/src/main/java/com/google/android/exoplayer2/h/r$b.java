package com.google.android.exoplayer2.h;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.h.r.a;
import com.google.android.exoplayer2.h.r.c;
import com.google.android.exoplayer2.h.r.f;
import com.google.android.exoplayer2.i.r;
import java.io.IOException;

@SuppressLint({"HandlerLeak"})
final class r$b<T extends c> extends Handler implements Runnable {
    private final T aBJ;
    private final a<T> aBK;
    public final int aBL;
    private final long aBM;
    IOException aBN;
    int aBO;
    private volatile Thread aBP;
    final /* synthetic */ r aBQ;
    private volatile boolean released;

    public r$b(r rVar, Looper looper, T t, a<T> aVar, int i, long j) {
        this.aBQ = rVar;
        super(looper);
        this.aBJ = t;
        this.aBK = aVar;
        this.aBL = i;
        this.aBM = j;
    }

    public final void start(long j) {
        com.google.android.exoplayer2.i.a.an(this.aBQ.aBI == null);
        this.aBQ.aBI = this;
        if (j > 0) {
            sendEmptyMessageDelayed(0, j);
        } else {
            execute();
        }
    }

    public final void al(boolean z) {
        this.released = z;
        this.aBN = null;
        if (hasMessages(0)) {
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            this.aBJ.kq();
            if (this.aBP != null) {
                this.aBP.interrupt();
            }
        }
        if (z) {
            finish();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.aBK.a(this.aBJ, elapsedRealtime, elapsedRealtime - this.aBM, true);
        }
    }

    public final void run() {
        try {
            this.aBP = Thread.currentThread();
            if (!this.aBJ.kr()) {
                r.beginSection("load:" + this.aBJ.getClass().getSimpleName());
                this.aBJ.ks();
                r.endSection();
            }
            if (!this.released) {
                sendEmptyMessage(2);
            }
        } catch (IOException e) {
            if (!this.released) {
                obtainMessage(3, e).sendToTarget();
            }
        } catch (InterruptedException e2) {
            com.google.android.exoplayer2.i.a.an(this.aBJ.kr());
            if (!this.released) {
                sendEmptyMessage(2);
            }
        } catch (Throwable e3) {
            if (!this.released) {
                obtainMessage(3, new f(e3)).sendToTarget();
            }
        } catch (Throwable e32) {
            if (!this.released) {
                obtainMessage(3, new f(e32)).sendToTarget();
            }
        } catch (Error e4) {
            if (!this.released) {
                obtainMessage(4, e4).sendToTarget();
            }
            throw e4;
        } catch (Throwable th) {
            r.endSection();
        }
    }

    public final void handleMessage(Message message) {
        if (!this.released) {
            if (message.what == 0) {
                execute();
            } else if (message.what == 4) {
                throw ((Error) message.obj);
            } else {
                finish();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j = elapsedRealtime - this.aBM;
                if (this.aBJ.kr()) {
                    this.aBK.a(this.aBJ, elapsedRealtime, j, false);
                    return;
                }
                switch (message.what) {
                    case 1:
                        this.aBK.a(this.aBJ, elapsedRealtime, j, false);
                        return;
                    case 2:
                        this.aBK.a(this.aBJ, elapsedRealtime, j);
                        return;
                    case 3:
                        this.aBN = (IOException) message.obj;
                        int a = this.aBK.a(this.aBJ, elapsedRealtime, j, this.aBN);
                        if (a == 3) {
                            this.aBQ.atf = this.aBN;
                            return;
                        } else if (a != 2) {
                            if (a == 1) {
                                a = 1;
                            } else {
                                a = this.aBO + 1;
                            }
                            this.aBO = a;
                            start((long) Math.min((this.aBO - 1) * 1000, 5000));
                            return;
                        } else {
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    private void execute() {
        this.aBN = null;
        this.aBQ.aBH.execute(this.aBQ.aBI);
    }

    private void finish() {
        this.aBQ.aBI = null;
    }
}
