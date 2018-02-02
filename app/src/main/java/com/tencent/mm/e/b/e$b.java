package com.tencent.mm.e.b;

import android.os.Process;
import com.tencent.mm.compatible.b.a;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Arrays;

final class e$b implements Runnable {
    final /* synthetic */ e fll;

    e$b(e eVar) {
        this.fll = eVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        x.i("MicroMsg.RecordModeAsyncRead", "RecordThread started. frameSize:%d", new Object[]{Integer.valueOf(this.fll.fkV)});
        if (-123456789 != this.fll.fkz) {
            x.i("MicroMsg.RecordModeAsyncRead", "set priority to " + this.fll.fkz);
            Process.setThreadPriority(this.fll.fkz);
        }
        synchronized (this.fll.fle) {
            if (1 != this.fll.mStatus) {
                x.e("MicroMsg.RecordModeAsyncRead", "status is not inited, now status: " + this.fll.mStatus);
                return;
            }
            this.fll.mStatus = 2;
        }
        int read;
        a aVar;
        byte[] bArr;
        int i;
        if (2 != this.fll.mStatus) {
            x.i("MicroMsg.RecordModeAsyncRead", "RecordThread exited.");
            return;
        }
        if (this.fll.fkJ == null) {
            x.i("MicroMsg.RecordModeAsyncRead", "mAudioRecord is null, so stop record.");
            synchronized (this.fll.fle) {
                this.fll.mStatus = 3;
            }
        } else {
            if (this.fll.fkv) {
                bArr = new byte[this.fll.fkV];
            }
            this.fll.flm++;
            g.a aVar2 = new g.a();
            read = this.fll.fkJ.read(bArr, 0, this.fll.fkV);
            if (2 == this.fll.mStatus) {
                if (this.fll.fkR != null) {
                    this.fll.fkR.c(read, bArr);
                }
                if (this.fll.fkV != read) {
                    x.i("MicroMsg.RecordModeAsyncRead", "read len " + read);
                }
                if (read < this.fll.fkV) {
                    x.i("MicroMsg.RecordModeAsyncRead", "read too fast? sleep 10 ms");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                    }
                }
                if (this.fll.flb != null && read > 0) {
                    if (read > bArr.length) {
                        read = bArr.length;
                    }
                    if (this.fll.fla != null) {
                        if (this.fll.mIsMute) {
                            Arrays.fill(bArr, 0, read, (byte) 0);
                        }
                        aVar = this.fll.fla;
                        if (read > 0) {
                            if (aVar.gBU) {
                                aVar.gBV.lock();
                            }
                            if (aVar.gBS == aVar.gBT) {
                                i = aVar.gBP;
                            } else if ((aVar.gBT + 1) % aVar.gBP != aVar.gBS) {
                                i = 0;
                            } else {
                                if (aVar.gBS < aVar.gBT) {
                                    aVar.gBQ = aVar.gBT - aVar.gBS;
                                } else if (aVar.gBS > aVar.gBT) {
                                    aVar.gBQ = (aVar.gBT + aVar.gBP) - aVar.gBS;
                                }
                                if (aVar.gBU) {
                                    aVar.gBV.unlock();
                                }
                                i = aVar.gBP - aVar.gBQ;
                            }
                            if (read <= i) {
                                if ((aVar.gBT + read) % aVar.gBP != aVar.gBS) {
                                    read = -1;
                                } else {
                                    if (aVar.gBU) {
                                        aVar.gBV.lock();
                                    }
                                    if (aVar.gBS < aVar.gBT || read <= aVar.gBP - aVar.gBT) {
                                        System.arraycopy(bArr, 0, aVar.gBR, aVar.gBT, read);
                                        aVar.gBT = (read + aVar.gBT) % aVar.gBP;
                                    } else {
                                        System.arraycopy(bArr, 0, aVar.gBR, aVar.gBT, aVar.gBP - aVar.gBT);
                                        System.arraycopy(bArr, aVar.gBP - aVar.gBT, aVar.gBR, 0, read - (aVar.gBP - aVar.gBT));
                                        aVar.gBT = read - (aVar.gBP - aVar.gBT);
                                        aVar.gBT %= aVar.gBP;
                                    }
                                    if (aVar.gBU) {
                                        aVar.gBV.unlock();
                                    }
                                    read = 0;
                                }
                                if (read == 0) {
                                    x.e("MicroMsg.RecordModeAsyncRead", "WriteToBuffer Failed, ret:%d AudioBuffer length: %d", new Object[]{Integer.valueOf(read), Integer.valueOf(this.fll.fla.xE())});
                                }
                            }
                        }
                        read = -1;
                        if (read == 0) {
                            x.e("MicroMsg.RecordModeAsyncRead", "WriteToBuffer Failed, ret:%d AudioBuffer length: %d", new Object[]{Integer.valueOf(read), Integer.valueOf(this.fll.fla.xE())});
                        }
                    } else if (this.fll.flb == null) {
                        if (this.fll.mIsMute) {
                            Arrays.fill(bArr, 0, read, (byte) 0);
                        }
                        this.fll.flb.q(bArr, read);
                    }
                }
            }
        }
        x.i("MicroMsg.RecordModeAsyncRead", "RecordThread exited.");
        return;
        if (read > bArr.length) {
            read = bArr.length;
        }
        if (this.fll.fla != null) {
            if (this.fll.mIsMute) {
                Arrays.fill(bArr, 0, read, (byte) 0);
            }
            aVar = this.fll.fla;
            if (read > 0) {
                if (aVar.gBU) {
                    aVar.gBV.lock();
                }
                if (aVar.gBS == aVar.gBT) {
                    i = aVar.gBP;
                } else if ((aVar.gBT + 1) % aVar.gBP != aVar.gBS) {
                    if (aVar.gBS < aVar.gBT) {
                        aVar.gBQ = aVar.gBT - aVar.gBS;
                    } else if (aVar.gBS > aVar.gBT) {
                        aVar.gBQ = (aVar.gBT + aVar.gBP) - aVar.gBS;
                    }
                    if (aVar.gBU) {
                        aVar.gBV.unlock();
                    }
                    i = aVar.gBP - aVar.gBQ;
                } else {
                    i = 0;
                }
                if (read <= i) {
                    if ((aVar.gBT + read) % aVar.gBP != aVar.gBS) {
                        if (aVar.gBU) {
                            aVar.gBV.lock();
                        }
                        if (aVar.gBS < aVar.gBT) {
                        }
                        System.arraycopy(bArr, 0, aVar.gBR, aVar.gBT, read);
                        aVar.gBT = (read + aVar.gBT) % aVar.gBP;
                        if (aVar.gBU) {
                            aVar.gBV.unlock();
                        }
                        read = 0;
                    } else {
                        read = -1;
                    }
                    if (read == 0) {
                        x.e("MicroMsg.RecordModeAsyncRead", "WriteToBuffer Failed, ret:%d AudioBuffer length: %d", new Object[]{Integer.valueOf(read), Integer.valueOf(this.fll.fla.xE())});
                    }
                }
            }
            read = -1;
            if (read == 0) {
                x.e("MicroMsg.RecordModeAsyncRead", "WriteToBuffer Failed, ret:%d AudioBuffer length: %d", new Object[]{Integer.valueOf(read), Integer.valueOf(this.fll.fla.xE())});
            }
        } else if (this.fll.flb == null) {
            if (this.fll.mIsMute) {
                Arrays.fill(bArr, 0, read, (byte) 0);
            }
            this.fll.flb.q(bArr, read);
        }
    }
}
