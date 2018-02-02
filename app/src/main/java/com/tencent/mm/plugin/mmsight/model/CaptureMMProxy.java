package com.tencent.mm.plugin.mmsight.model;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.e;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.io.Serializable;
import java.lang.reflect.Method;

public class CaptureMMProxy extends a {
    private static CaptureMMProxy ora;
    private static String orb = "";

    public static void createProxy(CaptureMMProxy captureMMProxy) {
        ora = captureMMProxy;
    }

    public static CaptureMMProxy getInstance() {
        return ora;
    }

    public CaptureMMProxy(d dVar) {
        super(dVar);
    }

    public String getAccVideoPath() {
        String str = (String) REMOTE_CALL("getAccVideoPathInMM", new Object[0]);
        x.i("MicroMsg.CaptureMMProxy", "getAccVideoPathInMM " + str + " accVideoPath: " + orb);
        if (!bh.ov(str)) {
            orb = str;
        }
        if (bh.ov(orb)) {
            return str;
        }
        return orb;
    }

    public String getSubCoreImageFullPath(String str) {
        String str2 = (String) REMOTE_CALL("getSubCoreImageFullPathInMM", str);
        x.i("MicroMsg.CaptureMMProxy", "getSubCoreImageFullPath " + str2);
        return str2;
    }

    public Object get(w.a aVar, Object obj) {
        x.i("MicroMsg.CaptureMMProxy", "get %s %s", new Object[]{aVar, obj});
        Object REMOTE_CALL = REMOTE_CALL("getConfigStorage", aVar, obj);
        x.i("MicroMsg.CaptureMMProxy", "get %s %s and get val %s", new Object[]{aVar, obj, REMOTE_CALL});
        return REMOTE_CALL == null ? obj : REMOTE_CALL;
    }

    public int getInt(w.a aVar, int i) {
        x.i("MicroMsg.CaptureMMProxy", "getInt %s %s", new Object[]{aVar, Integer.valueOf(i)});
        Object REMOTE_CALL = REMOTE_CALL("getConfigStorage", aVar, Integer.valueOf(i));
        x.i("MicroMsg.CaptureMMProxy", "getInt %s %s and get val %s", new Object[]{aVar, Integer.valueOf(i), REMOTE_CALL});
        return REMOTE_CALL == null ? i : bh.getInt(REMOTE_CALL.toString(), i);
    }

    public boolean getBoolean(w.a aVar, boolean z) {
        x.i("MicroMsg.CaptureMMProxy", "getBoolean %s %s", new Object[]{aVar, Boolean.valueOf(z)});
        Object REMOTE_CALL = REMOTE_CALL("getConfigStorage", aVar, Boolean.valueOf(z));
        x.i("MicroMsg.CaptureMMProxy", "getBoolean %s %s and get val %s", new Object[]{aVar, Boolean.valueOf(z), REMOTE_CALL});
        return REMOTE_CALL == null ? z : bh.getBoolean(REMOTE_CALL.toString(), z);
    }

    public boolean set(w.a aVar, Object obj) {
        Boolean bool = (Boolean) REMOTE_CALL("setConfigStorage", aVar, obj);
        x.d("MicroMsg.CaptureMMProxy", "setConfigStorage, %s %s", new Object[]{aVar, obj});
        return bool.booleanValue();
    }

    public VideoTransPara getSnsAlbumVideoTransPara() {
        Parcelable parcelable = (Parcelable) REMOTE_CALL("getSnsAlbumVideoTransParaInMM", new Object[0]);
        x.d("MicroMsg.CaptureMMProxy", "getSnsAlbumVideoTransPara() returned: " + parcelable);
        return (VideoTransPara) parcelable;
    }

    public String getDeviceInfoConfig() {
        x.i("MicroMsg.CaptureMMProxy", "getDeviceInfoConfig return: %s", new Object[]{(String) REMOTE_CALL("getDeviceInfoConfigInMM", new Object[0])});
        return (String) REMOTE_CALL("getDeviceInfoConfigInMM", new Object[0]);
    }

    public String getDynamicConfig(String str) {
        x.i("MicroMsg.CaptureMMProxy", "getDynamicConfig, key: %s, value: %s", new Object[]{str, (String) REMOTE_CALL("getDynamicConfigInMM", str)});
        return (String) REMOTE_CALL("getDynamicConfigInMM", str);
    }

    public byte[] getWeixinMeta() {
        x.i("MicroMsg.CaptureMMProxy", "getWeixinMeta result: %s", new Object[]{(byte[]) REMOTE_CALL("getWeixinMetaDataInMM", new Object[0])});
        return (byte[]) REMOTE_CALL("getWeixinMetaDataInMM", new Object[0]);
    }

    public boolean checkUseMMVideoPlayer() {
        Object REMOTE_CALL = REMOTE_CALL("checkUseMMVideoPlayerInMM", new Object[0]);
        if (REMOTE_CALL == null) {
            return true;
        }
        x.i("MicroMsg.CaptureMMProxy", "checkUseMMVideoPlayer[%b]", new Object[]{REMOTE_CALL});
        return ((Boolean) REMOTE_CALL).booleanValue();
    }

    @f
    public VideoTransPara getSnsAlbumVideoTransParaInMM() {
        x.d("MicroMsg.CaptureMMProxy", "getSnsAlbumVideoTransParaInMM() called");
        VideoTransPara MX = com.tencent.mm.modelcontrol.d.MU().MX();
        x.d("MicroMsg.CaptureMMProxy", "getVideoTransParaInMM() returned: " + MX);
        return MX;
    }

    @f
    public boolean checkUseMMVideoPlayerInMM() {
        x.d("MicroMsg.CaptureMMProxy", "checkUseMMVideoPlayerInMM() called");
        com.tencent.mm.modelcontrol.d.MU();
        boolean Nb = com.tencent.mm.modelcontrol.d.Nb();
        x.d("MicroMsg.CaptureMMProxy", "checkUseMMVideoPlayerInMM() returned: " + Nb);
        return Nb;
    }

    @f
    public String getAccVideoPathInMM() {
        x.d("MicroMsg.CaptureMMProxy", "getAccVideoPathInMM");
        o.TT();
        return o.getAccVideoPath();
    }

    @f
    public String getSubCoreImageFullPathInMM(String str) {
        x.d("MicroMsg.CaptureMMProxy", "getSubCoreImageFullPathInMM, %s", new Object[]{str});
        return com.tencent.mm.aq.o.Pw().getFullPath(str);
    }

    @f
    public Object getConfigStorage(int i, Object obj) {
        x.i("MicroMsg.CaptureMMProxy", "getConfigStorage, %s %s", new Object[]{((w.a[]) w.a.class.getEnumConstants())[i], obj});
        g.Dk();
        return g.Dj().CU().get(((w.a[]) w.a.class.getEnumConstants())[i], obj);
    }

    @f
    public boolean setConfigStorage(int i, Object obj) {
        x.i("MicroMsg.CaptureMMProxy", "setConfigStorage, %s %s", new Object[]{((w.a[]) w.a.class.getEnumConstants())[i], obj});
        g.Dk();
        g.Dj().CU().a(r0, obj);
        return true;
    }

    @f
    public String getDeviceInfoConfigInMM() {
        g.Dk();
        return g.Dj().CV().cjU();
    }

    @f
    public String getDynamicConfigInMM(String str) {
        return ((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue(str);
    }

    @f
    public byte[] getWeixinMetaDataInMM() {
        return com.tencent.mm.modelcontrol.d.MU().getWeixinMeta();
    }

    protected final Bundle objectsToBundle(Object... objArr) {
        Bundle bundle = new Bundle();
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            if (objArr[i] instanceof Bundle) {
                bundle.putBundle(String.valueOf(i), (Bundle) objArr[i]);
            } else if (objArr[i] instanceof Parcelable) {
                bundle.putParcelable(String.valueOf(i), (Parcelable) objArr[i]);
            } else if (objArr[i] instanceof w.a) {
                x.i("MicroMsg.CaptureMMProxy", "objectsToBundle: %s", new Object[]{Integer.valueOf(((w.a) objArr[i]).ordinal())});
                bundle.putInt(String.valueOf(i), ((w.a) objArr[i]).ordinal());
            } else {
                bundle.putSerializable(String.valueOf(i), (Serializable) objArr[i]);
            }
        }
        return bundle;
    }

    public void onCallback(String str, Bundle bundle, boolean z) {
        x.i("MicroMsg.CaptureMMProxy", "class:%s, method:%s, clientCall:%B", new Object[]{getClass().getName(), str, Boolean.valueOf(z)});
        Method method = null;
        try {
            for (Method method2 : getClass().getMethods()) {
                if (method2.getName().equalsIgnoreCase(str)) {
                    method = method2;
                    break;
                }
            }
            if (method != null) {
                if (method.isAnnotationPresent(z ? e.class : f.class)) {
                    Object invoke = method.invoke(this, getArgs(bundle));
                    if (method.getReturnType() == Void.TYPE) {
                        return;
                    }
                    if (invoke instanceof Parcelable) {
                        bundle.putParcelable("result_key", (Parcelable) invoke);
                        return;
                    }
                    if ("getConfigStorage".equals(str)) {
                        x.i("MicroMsg.CaptureMMProxy", "put result as Serializable: %s", new Object[]{(Serializable) invoke});
                    }
                    bundle.putSerializable("result_key", (Serializable) invoke);
                }
            }
        } catch (Throwable e) {
            x.e("MicroMsg.CaptureMMProxy", "exception:%s", new Object[]{bh.i(e)});
        }
    }
}
