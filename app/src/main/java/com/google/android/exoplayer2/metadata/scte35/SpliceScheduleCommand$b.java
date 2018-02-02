package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import com.google.android.exoplayer2.i.j;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceScheduleCommand$b {
    public final long aqY;
    public final boolean aqZ;
    public final boolean ara;
    public final boolean arb;
    public final List<SpliceScheduleCommand$a> arf;
    public final boolean arg;
    public final long arh;
    public final int ari;
    public final int arj;
    public final int ark;
    public final long arp;

    private SpliceScheduleCommand$b(long j, boolean z, boolean z2, boolean z3, List<SpliceScheduleCommand$a> list, long j2, boolean z4, long j3, int i, int i2, int i3) {
        this.aqY = j;
        this.aqZ = z;
        this.ara = z2;
        this.arb = z3;
        this.arf = Collections.unmodifiableList(list);
        this.arp = j2;
        this.arg = z4;
        this.arh = j3;
        this.ari = i;
        this.arj = i2;
        this.ark = i3;
    }

    SpliceScheduleCommand$b(Parcel parcel) {
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
        int readInt = parcel.readInt();
        List arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(new SpliceScheduleCommand$a(parcel.readInt(), parcel.readLong()));
        }
        this.arf = Collections.unmodifiableList(arrayList);
        this.arp = parcel.readLong();
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.arg = z2;
        this.arh = parcel.readLong();
        this.ari = parcel.readInt();
        this.arj = parcel.readInt();
        this.ark = parcel.readInt();
    }

    static SpliceScheduleCommand$b d(j jVar) {
        long j;
        boolean z;
        long aK = jVar.aK();
        boolean z2 = (jVar.readUnsignedByte() & FileUtils.S_IWUSR) != 0;
        boolean z3 = false;
        long j2 = -9223372036854775807L;
        List arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z4 = false;
        long j3 = -9223372036854775807L;
        if (z2) {
            j = -9223372036854775807L;
            z4 = false;
            z = false;
        } else {
            Object obj;
            long aK2;
            ArrayList arrayList2;
            int readUnsignedByte = jVar.readUnsignedByte();
            boolean z5 = (readUnsignedByte & FileUtils.S_IWUSR) != 0;
            boolean z6 = (readUnsignedByte & 64) != 0;
            if ((readUnsignedByte & 32) != 0) {
                obj = 1;
            } else {
                obj = null;
            }
            if (z6) {
                aK2 = jVar.aK();
            } else {
                aK2 = -9223372036854775807L;
            }
            if (z6) {
                arrayList2 = arrayList;
            } else {
                int readUnsignedByte2 = jVar.readUnsignedByte();
                arrayList2 = new ArrayList(readUnsignedByte2);
                for (readUnsignedByte = 0; readUnsignedByte < readUnsignedByte2; readUnsignedByte++) {
                    arrayList2.add(new SpliceScheduleCommand$a(jVar.readUnsignedByte(), jVar.aK()));
                }
            }
            if (obj != null) {
                long readUnsignedByte3 = (long) jVar.readUnsignedByte();
                z4 = (128 & readUnsignedByte3) != 0;
                j3 = ((readUnsignedByte3 & 1) << 32) | jVar.aK();
            }
            i = jVar.readUnsignedShort();
            i2 = jVar.readUnsignedByte();
            i3 = jVar.readUnsignedByte();
            arrayList = arrayList2;
            z3 = z6;
            j2 = aK2;
            j = j3;
            z = z4;
            z4 = z5;
        }
        return new SpliceScheduleCommand$b(aK, z2, z4, z3, arrayList, j2, z, j, i, i2, i3);
    }
}
