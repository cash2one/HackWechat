package com.tencent.mm.e.b;

import android.media.AudioRecord;
import android.media.AudioRecord.OnRecordPositionUpdateListener;
import android.os.HandlerThread;
import com.tencent.mm.e.b.c.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends f {
    AudioRecord fkJ;
    a fkK;
    byte[] fkT = null;
    private int fkU;
    int fkV;
    private OnRecordPositionUpdateListener fkW = new 1(this);
    boolean fkv;
    private HandlerThread mHandlerThread = null;
    boolean mIsMute;

    public d(AudioRecord audioRecord, a aVar, boolean z, int i, int i2) {
        this.fkJ = audioRecord;
        this.fkK = aVar;
        this.fkv = z;
        this.fkU = i;
        this.fkV = i2;
    }

    public final boolean vr() {
        if (this.mHandlerThread != null) {
            x.e("MicroMsg.RecordModeAsyncCallback", "alreay started record");
            return false;
        }
        this.mHandlerThread = e.cZ("RecordModeAsyncCallback_handlerThread", 10);
        this.mHandlerThread.start();
        this.fkJ.setRecordPositionUpdateListener(this.fkW, af.fetchFreeHandler(this.mHandlerThread.getLooper()));
        this.fkJ.setPositionNotificationPeriod(this.fkU);
        if (this.fkv || this.fkT == null) {
            this.fkT = new byte[this.fkV];
        }
        int read = this.fkJ.read(this.fkT, 0, this.fkV);
        x.d("MicroMsg.RecordModeAsyncCallback", "startRecord, read ret: " + read);
        if (this.fkK != null && read > 0) {
            this.fkK.q(this.fkT, read);
        }
        return true;
    }

    public final void uE() {
        this.fkJ.setRecordPositionUpdateListener(null);
        this.fkJ = null;
        this.mHandlerThread.quit();
        this.mHandlerThread = null;
    }

    public final void aQ(boolean z) {
        this.mIsMute = z;
    }
}
