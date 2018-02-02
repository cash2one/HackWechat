package com.tencent.mm.ipcinvoker.wx_extension;

import android.os.Parcel;
import android.text.TextUtils;
import com.tencent.mm.ipcinvoker.extension.a;
import com.tencent.mm.sdk.platformtools.x;

public final class c implements a {
    public final boolean au(Object obj) {
        return obj instanceof com.tencent.mm.bq.a;
    }

    public final void a(Object obj, Parcel parcel) {
        if (obj == null) {
            parcel.writeString(null);
            return;
        }
        byte[] toByteArray;
        com.tencent.mm.bq.a aVar = (com.tencent.mm.bq.a) obj;
        parcel.writeString(aVar.getClass().getName());
        try {
            toByteArray = aVar.toByteArray();
        } catch (Exception e) {
            x.e("MicroMsg.XIPC.MMProtoBufTransfer", "writeToParcel, e = %s", new Object[]{e});
            toByteArray = new byte[0];
        }
        parcel.writeInt(toByteArray.length);
        parcel.writeByteArray(toByteArray);
    }

    public final Object d(Parcel parcel) {
        Object readString = parcel.readString();
        if (TextUtils.isEmpty(readString)) {
            return null;
        }
        com.tencent.mm.bq.a aVar;
        byte[] bArr = new byte[parcel.readInt()];
        parcel.readByteArray(bArr);
        try {
            aVar = (com.tencent.mm.bq.a) Class.forName(readString).newInstance();
            aVar.aF(bArr);
        } catch (Exception e) {
            x.e("MicroMsg.XIPC.MMProtoBufTransfer", "readFromParcel, e = %s", new Object[]{e});
            aVar = null;
        }
        return aVar;
    }
}
