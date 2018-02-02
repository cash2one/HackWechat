package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Creator<SpliceScheduleCommand> CREATOR = new 1();
    public final List<b> aro;

    private SpliceScheduleCommand(List<b> list) {
        this.aro = Collections.unmodifiableList(list);
    }

    private SpliceScheduleCommand(Parcel parcel) {
        int readInt = parcel.readInt();
        List arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(new b(parcel));
        }
        this.aro = Collections.unmodifiableList(arrayList);
    }

    static SpliceScheduleCommand c(j jVar) {
        int readUnsignedByte = jVar.readUnsignedByte();
        List arrayList = new ArrayList(readUnsignedByte);
        for (int i = 0; i < readUnsignedByte; i++) {
            arrayList.add(b.d(jVar));
        }
        return new SpliceScheduleCommand(arrayList);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int size = this.aro.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            int i3;
            b bVar = (b) this.aro.get(i2);
            parcel.writeLong(bVar.aqY);
            parcel.writeByte((byte) (bVar.aqZ ? 1 : 0));
            parcel.writeByte((byte) (bVar.ara ? 1 : 0));
            parcel.writeByte((byte) (bVar.arb ? 1 : 0));
            int size2 = bVar.arf.size();
            parcel.writeInt(size2);
            for (int i4 = 0; i4 < size2; i4++) {
                a aVar = (a) bVar.arf.get(i4);
                parcel.writeInt(aVar.arl);
                parcel.writeLong(aVar.arp);
            }
            parcel.writeLong(bVar.arp);
            if (bVar.arg) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            parcel.writeByte((byte) i3);
            parcel.writeLong(bVar.arh);
            parcel.writeInt(bVar.ari);
            parcel.writeInt(bVar.arj);
            parcel.writeInt(bVar.ark);
        }
    }
}
