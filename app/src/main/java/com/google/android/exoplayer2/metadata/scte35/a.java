package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.q;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.d;
import java.nio.ByteBuffer;

public final class a implements com.google.android.exoplayer2.metadata.a {
    private q alA;
    private final j aoI = new j();
    private final i aqX = new i();

    public final Metadata a(d dVar) {
        if (this.alA == null || dVar.aej != this.alA.lQ()) {
            this.alA = new q(dVar.aig);
            this.alA.R(dVar.aig - dVar.aej);
        }
        ByteBuffer byteBuffer = dVar.aif;
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.aoI.l(array, limit);
        this.aqX.l(array, limit);
        this.aqX.cS(39);
        long cT = ((long) this.aqX.cT(32)) | (((long) this.aqX.cT(1)) << 32);
        this.aqX.cS(20);
        int cT2 = this.aqX.cT(12);
        int cT3 = this.aqX.cT(8);
        this.aoI.cV(14);
        Object spliceNullCommand;
        switch (cT3) {
            case 0:
                spliceNullCommand = new SpliceNullCommand();
                break;
            case 4:
                spliceNullCommand = SpliceScheduleCommand.c(this.aoI);
                break;
            case 5:
                spliceNullCommand = SpliceInsertCommand.a(this.aoI, cT, this.alA);
                break;
            case 6:
                spliceNullCommand = TimeSignalCommand.b(this.aoI, cT, this.alA);
                break;
            case 255:
                spliceNullCommand = PrivateCommand.a(this.aoI, cT2, cT);
                break;
            default:
                Entry entry = null;
                break;
        }
        if (entry == null) {
            return new Metadata(new Entry[0]);
        }
        return new Metadata(entry);
    }
}
