package com.tencent.mm.ipcinvoker.wx_extension;

import android.os.Parcel;
import com.tencent.mm.ae.b;
import com.tencent.mm.ipcinvoker.extension.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

public final class a implements com.tencent.mm.ipcinvoker.extension.a {
    public final boolean au(Object obj) {
        return obj instanceof b;
    }

    public final void a(Object obj, Parcel parcel) {
        b bVar = (b) obj;
        c.a(bVar.hmg.hmo, parcel);
        if (ac.cfw()) {
            c.a(bVar.hmh.hmo, parcel);
        } else {
            parcel.writeString(bVar.hmh.hmo.getClass().getName());
        }
        parcel.writeString(bVar.uri);
        parcel.writeInt(bVar.hmi);
        parcel.writeInt(bVar.hmg.cmdId);
        parcel.writeInt(bVar.hmh.cmdId);
    }

    public final Object d(Parcel parcel) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = (com.tencent.mm.bq.a) c.a(c.class.getName(), parcel);
        if (ac.cfw()) {
            try {
                aVar.hmk = (com.tencent.mm.bq.a) Class.forName(parcel.readString()).newInstance();
            } catch (Exception e) {
                x.e("MicroMsg.XIPC.CommReqRespTransfer", "readFromParcel, mm process initiate resp e = %s", new Object[]{e});
                aVar.hmk = new com.tencent.mm.bq.a();
            }
        } else {
            com.tencent.mm.bq.a aVar2 = (com.tencent.mm.bq.a) c.a(c.class.getName(), parcel);
            if (aVar2 == null) {
                aVar2 = new com.tencent.mm.bq.a();
            }
            aVar.hmk = aVar2;
        }
        aVar.uri = parcel.readString();
        aVar.hmi = parcel.readInt();
        aVar.hml = parcel.readInt();
        aVar.hmm = parcel.readInt();
        return aVar.JZ();
    }
}
