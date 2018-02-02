package com.tencent.mm.plugin.facedetect;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Keep;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.facedetect.model.n;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import org.json.JSONArray;

public class FaceProNative {
    public static final int ROTFLIPHOR = 3;
    public static final int ROTFLIPLEFT = 4;
    public static final int ROTFLIPRIGHT = 5;
    public static final int ROTLEFT = 1;
    public static final int ROTRIGHT = 2;
    public static final int ROTSTABLE = 0;
    private static final String TAG = "MicroMsg.FaceProNative";
    private static final long TIMEOUT_CHECKER = 3600000;
    private static String[] cachedStr = null;
    public static boolean hasDetectInit = false;
    private static long lastCheckTime = -1;
    private long nativePtr;

    public static class FaceResult implements Parcelable {
        public static final Creator<FaceResult> CREATOR = new 1();
        public byte[] data;
        public int result;
        public byte[] sidedata;

        protected FaceResult(Parcel parcel) {
            this.result = parcel.readInt();
            this.data = parcel.createByteArray();
            this.sidedata = parcel.createByteArray();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.result);
            parcel.writeByteArray(this.data);
            parcel.writeByteArray(this.sidedata);
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            int i = 0;
            StringBuilder append = new StringBuilder("FaceResult{result=").append(this.result).append(", sidedataLen=").append(this.sidedata == null ? 0 : this.sidedata.length).append(", dataLen=");
            if (this.data != null) {
                i = this.data.length;
            }
            return append.append(i).append('}').toString();
        }
    }

    private native void NativeConstructor();

    private native void NativeDestructor();

    public static native int engineVersion();

    public static native int nativeFacedetectInitBin(byte[] bArr);

    public static native void nativeFacedetectRelease();

    public static native int nativeFacedetectWithBitmap(Object obj);

    public static native boolean nativeInit();

    public native FaceStatus engineFaceProcess(byte[] bArr, int i, int i2, int i3, int i4, int i5);

    public native int[] engineGetAllMotions();

    public native int engineGetCurrMotion();

    public native String engineGetCurrMotionData();

    public native int engineGroupChange();

    public native int engineInit(String str, byte[] bArr, String str2, String str3);

    public native int engineNextMotion();

    public native int engineRelease();

    public native int engineReleaseCurrMotion();

    public native FaceResult engineReleaseOut();

    public native int engineSetVoiceData(byte[] bArr);

    public native int engineStartRecord();

    public FaceProNative() {
        NativeConstructor();
    }

    public void destroy() {
        NativeDestructor();
    }

    protected void finalize() {
        super.finalize();
        NativeDestructor();
    }

    static {
        k.b("FacePro", FaceProNative.class.getClassLoader());
        k.b("wechatvoicereco", FaceProNative.class.getClassLoader());
        k.b("wechatxlog", FaceProNative.class.getClassLoader());
        nativeInit();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int detectFaceCnt(String str) {
        synchronized (FaceProNative.class) {
            if (!hasDetectInit) {
                if (nativeFacedetectInitBin(FileOp.d(n.aGQ(), 0, -1)) == -1) {
                    x.w(TAG, "detectFaceCnt init failed: %s", new Object[]{n.aGQ()});
                    return 0;
                }
                x.i(TAG, "detectFaceCnt init:%d, %s", new Object[]{Integer.valueOf(nativeFacedetectInitBin(FileOp.d(n.aGQ(), 0, -1))), n.aGQ()});
                hasDetectInit = true;
            }
        }
    }

    @Keep
    public static String[] getDynamicValue(String str) {
        if (System.currentTimeMillis() - lastCheckTime >= TIMEOUT_CHECKER) {
            lastCheckTime = System.currentTimeMillis();
            String value = ((a) g.h(a.class)).zY().getValue(str);
            if (!bh.ov(value)) {
                try {
                    JSONArray jSONArray = new JSONArray(value);
                    ArrayList arrayList = new ArrayList(5);
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        arrayList.add(jSONArray.getString(i));
                    }
                    cachedStr = new String[length];
                    arrayList.toArray(cachedStr);
                } catch (Throwable e) {
                    x.printErrStackTrace(TAG, e, "hy: array resolve failed", new Object[0]);
                }
            }
        }
        return cachedStr;
    }
}
