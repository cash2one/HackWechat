package com.tencent.mm.modelvoice;

import android.os.Process;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qqpinyin.voicerecoapi.a;
import com.tencent.qqpinyin.voicerecoapi.b;
import java.io.FileInputStream;

class j$3 implements Runnable {
    final /* synthetic */ j hXs;

    j$3(j jVar) {
        this.hXs = jVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        Process.setThreadPriority(-16);
        this.hXs.hXq = new FileInputStream(this.hXs.fileName);
        while (true) {
            if (this.hXs.status != 1 && this.hXs.status != 2) {
                break;
            }
            this.hXs.hXp = this.hXs.hXq.read(this.hXs.hXo);
            int length;
            if (this.hXs.hXp != -1) {
                a aVar = this.hXs.hXk;
                byte[] bArr = this.hXs.hXo;
                int i = this.hXs.hXp;
                if (aVar.zQO != 0) {
                    if (bArr == null) {
                        break;
                    } else if (bArr.length == 0) {
                        break;
                    } else {
                        int nativeTRSpeexDecode = aVar.zQP.nativeTRSpeexDecode(aVar.zQO, bArr, 0, i, aVar.zQM);
                        if (nativeTRSpeexDecode < 0) {
                            throw new b(nativeTRSpeexDecode);
                        }
                        if (nativeTRSpeexDecode == 0) {
                            bArr = null;
                        } else {
                            Object obj = new byte[nativeTRSpeexDecode];
                            System.arraycopy(aVar.zQM, 0, obj, 0, nativeTRSpeexDecode);
                            Object obj2 = obj;
                        }
                        if (bArr == null || nativeTRSpeexDecode == 0) {
                            this.hXs.status = 0;
                        } else {
                            length = bArr.length;
                            nativeTRSpeexDecode = 0;
                            while (length >= this.hXs.hXr && this.hXs.status == 1) {
                                if (this.hXs.hXn) {
                                    Thread.sleep(20);
                                } else if (!(this.hXs.afZ == null || this.hXs.hXn)) {
                                    this.hXs.afZ.write(bArr, nativeTRSpeexDecode, this.hXs.hXr);
                                    nativeTRSpeexDecode += this.hXs.hXr;
                                    length -= this.hXs.hXr;
                                }
                            }
                            if (length < this.hXs.hXr && length > 0 && this.hXs.afZ != null) {
                                this.hXs.afZ.write(bArr, nativeTRSpeexDecode, length);
                            }
                        }
                    }
                } else {
                    throw new b(-102);
                }
            }
            this.hXs.status = 0;
            if (this.hXs.status == 2) {
                synchronized (this.hXs.hWR) {
                    try {
                        x.v("MicroMsg.SpeexPlayer", "before mOk.notify");
                        this.hXs.hWR.notify();
                        x.v("MicroMsg.SpeexPlayer", "after mOk.notify");
                    } catch (Throwable e) {
                        x.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[]{bh.i(e)});
                    }
                }
                synchronized (this.hXs.hWQ) {
                    try {
                        x.v("MicroMsg.SpeexPlayer", "before mpause.wait");
                        this.hXs.hWQ.wait();
                        x.v("MicroMsg.SpeexPlayer", "after mpause.wait");
                    } catch (Throwable e2) {
                        x.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[]{bh.i(e2)});
                    }
                }
            } else {
                try {
                    synchronized (this.hXs.hWR) {
                        try {
                            this.hXs.hWR.notify();
                        } catch (Throwable e22) {
                            x.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[]{bh.i(e22)});
                        }
                    }
                } catch (Throwable e222) {
                    x.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[]{bh.i(e222)});
                    if (this.hXs.hXb != null) {
                        this.hXs.hXb.onError(null, 0, 0);
                    }
                    this.hXs.status = 0;
                }
            }
        }
        throw new b(-104);
        if (length == 0) {
            x.e("MicroMsg.SpeexPlayer", "res: " + length);
        }
        this.hXs.hXq = null;
        a aVar2 = this.hXs.hXk;
        if (aVar2.zQO != 0) {
            length = -102;
        } else {
            aVar2.zQM = null;
            length = aVar2.zQP.nativeTRSpeexDecodeRelease(aVar2.zQO);
            aVar2.zQO = 0;
        }
        if (this.hXs.status == 3) {
            if (this.hXs.hXe != null) {
                this.hXs.hXe.vh();
            }
            if (this.hXs.hXa != null) {
                this.hXs.hXa.onCompletion(null);
            }
        } else {
            try {
                this.hXs.UB();
            } catch (Exception e3) {
            }
        }
        if (length == 0) {
            x.e("MicroMsg.SpeexPlayer", "res: " + length);
        }
        if (this.hXs.hXq != null) {
            try {
                this.hXs.hXq.close();
            } catch (Throwable e2222) {
                x.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[]{bh.i(e2222)});
            }
            this.hXs.hXq = null;
        }
        a aVar22 = this.hXs.hXk;
        if (aVar22.zQO != 0) {
            aVar22.zQM = null;
            length = aVar22.zQP.nativeTRSpeexDecodeRelease(aVar22.zQO);
            aVar22.zQO = 0;
        } else {
            length = -102;
        }
        if (this.hXs.status == 3) {
            this.hXs.UB();
        } else {
            if (this.hXs.hXe != null) {
                this.hXs.hXe.vh();
            }
            if (this.hXs.hXa != null) {
                this.hXs.hXa.onCompletion(null);
            }
        }
        if (length == 0) {
            x.e("MicroMsg.SpeexPlayer", "res: " + length);
        }
    }
}
