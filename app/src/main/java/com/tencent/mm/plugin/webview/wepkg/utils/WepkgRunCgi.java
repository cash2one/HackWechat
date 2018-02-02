package com.tencent.mm.plugin.webview.wepkg.utils;

import android.os.Parcel;
import com.tencent.mm.ae.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class WepkgRunCgi {

    public interface a {
        void a(int i, int i2, String str, b bVar);
    }

    static /* synthetic */ void a(b bVar, Parcel parcel) {
        parcel.writeString(bVar.hmg.hmo.getClass().getName());
        byte[] bArr = new byte[0];
        try {
            bArr = bVar.hmg.hmo.toByteArray();
        } catch (Exception e) {
        }
        parcel.writeInt(bArr.length);
        parcel.writeByteArray(bArr);
        parcel.writeString(bVar.hmh.hmo.getClass().getName());
        bArr = new byte[0];
        try {
            bArr = bVar.hmh.hmo.toByteArray();
        } catch (Exception e2) {
        }
        parcel.writeInt(bArr.length);
        parcel.writeByteArray(bArr);
        parcel.writeString(bVar.uri);
        parcel.writeInt(bVar.hmi);
        parcel.writeInt(bVar.hmg.cmdId);
        parcel.writeInt(bVar.hmh.cmdId);
    }

    static b k(Parcel parcel) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        String readString = parcel.readString();
        byte[] bArr = new byte[parcel.readInt()];
        parcel.readByteArray(bArr);
        try {
            aVar.hmj = ((com.tencent.mm.bq.a) Class.forName(readString).newInstance()).aF(bArr);
        } catch (Exception e) {
        }
        String readString2 = parcel.readString();
        byte[] bArr2 = new byte[parcel.readInt()];
        parcel.readByteArray(bArr2);
        try {
            aVar.hmk = ((com.tencent.mm.bq.a) Class.forName(readString2).newInstance()).aF(bArr2);
        } catch (Exception e2) {
            if (e2 instanceof e.a.a.b) {
                try {
                    aVar.hmk = (com.tencent.mm.bq.a) Class.forName(readString2).newInstance();
                } catch (Throwable e3) {
                    x.e("MicroMsg.Wepkg.WepkgRunCgi", "readCommReqRespFromParcel, resp fields not ready, re-create one but exp = %s", new Object[]{bh.i(e3)});
                }
            }
        }
        aVar.uri = parcel.readString();
        aVar.hmi = parcel.readInt();
        aVar.hml = parcel.readInt();
        aVar.hmm = parcel.readInt();
        return aVar.JZ();
    }
}
