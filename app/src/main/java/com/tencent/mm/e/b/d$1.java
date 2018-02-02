package com.tencent.mm.e.b;

import android.media.AudioRecord;
import android.media.AudioRecord.OnRecordPositionUpdateListener;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Arrays;

class d$1 implements OnRecordPositionUpdateListener {
    final /* synthetic */ d fkX;

    d$1(d dVar) {
        this.fkX = dVar;
    }

    public final void onMarkerReached(AudioRecord audioRecord) {
    }

    public final void onPeriodicNotification(AudioRecord audioRecord) {
        if (!this.fkX.mIsPause && this.fkX.fkJ != null) {
            if (this.fkX.fkv || this.fkX.fkT == null) {
                this.fkX.fkT = new byte[this.fkX.fkV];
            }
            int read = this.fkX.fkJ.read(this.fkX.fkT, 0, this.fkX.fkV);
            x.d("MicroMsg.RecordModeAsyncCallback", "OnRecordPositionUpdateListener, read ret: " + read);
            if (this.fkX.fkR != null) {
                this.fkX.fkR.c(read, this.fkX.fkT);
            }
            if (read > this.fkX.fkT.length) {
                read = this.fkX.fkT.length;
            }
            if (this.fkX.mIsMute && read > 0) {
                Arrays.fill(this.fkX.fkT, 0, read, (byte) 0);
            }
            if (this.fkX.fkK != null && read > 0) {
                this.fkX.fkK.q(this.fkX.fkT, read);
            }
        }
    }
}
