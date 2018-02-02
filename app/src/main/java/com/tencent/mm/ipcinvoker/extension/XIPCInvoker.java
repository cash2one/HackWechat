package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.sdk.platformtools.x;

public final class XIPCInvoker {

    private static class WrapperParcelable implements Parcelable {
        public static final Creator<WrapperParcelable> CREATOR = new 1();
        Object gMY;
        String gNa;

        private WrapperParcelable() {
        }

        public WrapperParcelable(String str, Object obj) {
            this.gNa = str;
            this.gMY = obj;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.gNa);
            if (this.gMY != null) {
                a av = c.av(this.gMY);
                if (av != null) {
                    parcel.writeInt(1);
                    parcel.writeString(av.getClass().getName());
                    av.a(this.gMY, parcel);
                    return;
                }
            }
            parcel.writeInt(0);
        }
    }

    public static <T extends h<InputType, ResultType>, InputType, ResultType> void a(String str, InputType inputType, Class<T> cls, i<ResultType> iVar) {
        f.a(str, new WrapperParcelable(cls.getName(), inputType), a.class, new 1(iVar));
    }

    public static <T extends j<InputType, ResultType>, InputType, ResultType> ResultType a(String str, InputType inputType, Class<T> cls) {
        WrapperParcelable wrapperParcelable = (WrapperParcelable) f.a(str, new WrapperParcelable(cls.getName(), inputType), b.class);
        if (wrapperParcelable != null) {
            return wrapperParcelable.gMY;
        }
        x.w("IPC.XIPCInvoker", "sync invoke error, wrapper parcelable data is null!");
        return null;
    }
}
