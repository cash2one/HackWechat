package com.tencent.mm.plugin.facedetect.d;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.sdk.platformtools.x;

public interface b {

    public static class a {
        public String fnL;
        public int mhu;
        public int mhv;

        a(String str) {
            this.mhv = 7;
            this.fnL = str;
        }

        a() {
            this.mhu = 1;
        }
    }

    public static class b {
        public int errCode;
        public String fnL;

        public b(int i, String str) {
            this.errCode = i;
            this.fnL = str;
        }
    }

    public static class c {
        private static String TAG = "MicroMsg.IFaceMotion.Factory";

        public static b a(com.tencent.mm.plugin.facedetect.model.h.a aVar) {
            if (aVar == null) {
                return null;
            }
            if (aVar.type == 4) {
                x.i(TAG, "hy: is read number");
                return new d(aVar.mgr);
            }
            x.i(TAG, "hy: is normal");
            return new c(aVar.imS, aVar.mgo);
        }
    }

    void a(Context context, ViewGroup viewGroup, ViewGroup viewGroup2);

    boolean a(FaceCharacteristicsResult faceCharacteristicsResult);

    boolean aGU();

    boolean aGV();

    void aGW();

    b aGX();

    a aGY();

    boolean b(FaceCharacteristicsResult faceCharacteristicsResult);
}
