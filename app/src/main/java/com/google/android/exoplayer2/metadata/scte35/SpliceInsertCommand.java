package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.q;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceInsertCommand extends SpliceCommand {
    public static final Creator<SpliceInsertCommand> CREATOR = new 1();
    public final long aqY;
    public final boolean aqZ;
    public final boolean ara;
    public final boolean arb;
    public final boolean arc;
    public final long ard;
    public final long are;
    public final List<a> arf;
    public final boolean arg;
    public final long arh;
    public final int ari;
    public final int arj;
    public final int ark;

    private SpliceInsertCommand(long j, boolean z, boolean z2, boolean z3, boolean z4, long j2, long j3, List<a> list, boolean z5, long j4, int i, int i2, int i3) {
        this.aqY = j;
        this.aqZ = z;
        this.ara = z2;
        this.arb = z3;
        this.arc = z4;
        this.ard = j2;
        this.are = j3;
        this.arf = Collections.unmodifiableList(list);
        this.arg = z5;
        this.arh = j4;
        this.ari = i;
        this.arj = i2;
        this.ark = i3;
    }

    private SpliceInsertCommand(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.aqY = parcel.readLong();
        this.aqZ = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.ara = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.arb = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.arc = z;
        this.ard = parcel.readLong();
        this.are = parcel.readLong();
        int readInt = parcel.readInt();
        List arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(new a(parcel.readInt(), parcel.readLong(), parcel.readLong()));
        }
        this.arf = Collections.unmodifiableList(arrayList);
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.arg = z2;
        this.arh = parcel.readLong();
        this.ari = parcel.readInt();
        this.arj = parcel.readInt();
        this.ark = parcel.readInt();
    }

    static SpliceInsertCommand a(j jVar, long j, q qVar) {
        boolean z;
        long j2;
        boolean z2;
        long j3;
        boolean z3;
        long aK = jVar.aK();
        if ((jVar.readUnsignedByte() & FileUtils.S_IWUSR) != 0) {
            z = true;
        } else {
            z = false;
        }
        boolean z4 = false;
        boolean z5 = false;
        List emptyList = Collections.emptyList();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        if (z) {
            j2 = -9223372036854775807L;
            z2 = false;
            j3 = -9223372036854775807L;
            z3 = false;
        } else {
            long j4;
            long j5;
            boolean z6;
            long j6;
            int readUnsignedByte = jVar.readUnsignedByte();
            boolean z7 = (readUnsignedByte & FileUtils.S_IWUSR) != 0;
            boolean z8 = (readUnsignedByte & 64) != 0;
            Object obj = (readUnsignedByte & 32) != 0 ? 1 : null;
            z2 = (readUnsignedByte & 16) != 0;
            if (!z8 || z2) {
                j4 = -9223372036854775807L;
            } else {
                j4 = TimeSignalCommand.a(jVar, j);
            }
            if (!z8) {
                i3 = jVar.readUnsignedByte();
                emptyList = new ArrayList(i3);
                for (i = 0; i < i3; i++) {
                    int readUnsignedByte2 = jVar.readUnsignedByte();
                    j5 = -9223372036854775807L;
                    if (!z2) {
                        j5 = TimeSignalCommand.a(jVar, j);
                    }
                    emptyList.add(new a(readUnsignedByte2, j5, qVar.Q(j5), (byte) 0));
                }
            }
            if (obj != null) {
                j5 = (long) jVar.readUnsignedByte();
                long aK2 = ((j5 & 1) << 32) | jVar.aK();
                z6 = (128 & j5) != 0;
                j6 = aK2;
            } else {
                j6 = -9223372036854775807L;
                z6 = false;
            }
            i = jVar.readUnsignedShort();
            i2 = jVar.readUnsignedByte();
            i3 = jVar.readUnsignedByte();
            j3 = j4;
            z3 = z2;
            z5 = z8;
            z4 = z7;
            j2 = j6;
            z2 = z6;
        }
        return new SpliceInsertCommand(aK, z, z4, z5, z3, j3, qVar.Q(j3), emptyList, z2, j2, i, i2, i3);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeLong(this.aqY);
        parcel.writeByte((byte) (this.aqZ ? 1 : 0));
        if (this.ara) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (this.arb) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (this.arc) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeLong(this.ard);
        parcel.writeLong(this.are);
        int size = this.arf.size();
        parcel.writeInt(size);
        for (int i4 = 0; i4 < size; i4++) {
            a aVar = (a) this.arf.get(i4);
            parcel.writeInt(aVar.arl);
            parcel.writeLong(aVar.arm);
            parcel.writeLong(aVar.arn);
        }
        if (!this.arg) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeLong(this.arh);
        parcel.writeInt(this.ari);
        parcel.writeInt(this.arj);
        parcel.writeInt(this.ark);
    }
}
