package com.tencent.mm.plugin.exdevice.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.g.a.dl;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import org.json.JSONObject;

public final class ExdeviceWCLanSDKUtil {
    BroadcastReceiver jhN;
    private int lMC;
    private int lMD;
    a lME;
    a lMF;
    HashMap<String, String> lMG;
    boolean lMH;
    boolean lMI;
    boolean lMJ;
    int lMK;
    HashMap<String, byte[]> lMj;
    HashMap<String, Boolean> lMl;
    a lMm;
    a lMo;
    Context mContext;

    public ExdeviceWCLanSDKUtil() {
        this.lMC = 0;
        this.lMD = 0;
        this.lMj = new HashMap();
        this.lMl = new HashMap();
        this.lMG = new HashMap();
        this.mContext = null;
        this.lMH = false;
        this.lMI = false;
        this.lMJ = false;
        this.lMH = true;
        this.lMI = true;
        this.lMj.clear();
        this.lMl.clear();
        this.lMG.clear();
        this.mContext = ac.getContext();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        if (this.jhN == null) {
            this.jhN = new LanStateChangeReceiver(this);
        }
        this.mContext.registerReceiver(this.jhN, intentFilter);
        this.lME = new 1(this);
        this.lMm = new 2(this);
        this.lMo = new 3(this);
        this.lMF = new 4(this);
    }

    public final boolean f(boolean z, String str) {
        if (str == null || !this.lMj.containsKey(str)) {
            x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "mDevClassInfo is null in openOrCloseDevice");
            return false;
        }
        byte[] bArr = (byte[]) this.lMj.get(str);
        try {
            JSONObject jSONObject = new JSONObject();
            if (z) {
                x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "open device!");
                jSONObject.put("cmd", "open");
            } else {
                x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "close device!");
                jSONObject.put("cmd", "close");
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("wxmsg_jsapi", jSONObject);
            jSONObject = new JSONObject();
            jSONObject.put("services", jSONObject2);
            this.lMD = Java2CExDevice.useWCLanDeviceService(bArr, jSONObject.toString().getBytes());
            if (this.lMD != 0) {
                x.d("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "get openOrCloseDevice mCallBackCmdId =" + this.lMD);
            } else {
                x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "openOrCloseDevice error!");
            }
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
            x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON encode failed in openOrCloseDevice");
            return false;
        }
    }

    public final boolean ae(String str, boolean z) {
        if (str == null || !this.lMj.containsKey(str)) {
            x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "mDevClassInfo is null in connectWCLanDevice");
            return false;
        }
        byte[] bArr = (byte[]) this.lMj.get(str);
        this.lMJ = true;
        if (z) {
            try {
                String string = new JSONObject(new String(bArr)).getString("deviceType");
                x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "connectWCLanDevice deviceId: " + str);
                if (Java2CExDevice.connectWCLanDevice(bArr, false) != 0) {
                    x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "connectWCLanDevice error!");
                    return false;
                }
                b dlVar = new dl();
                dlVar.fsf.ffq = str;
                dlVar.fsf.fsg = 1;
                dlVar.fsf.frn = string;
                com.tencent.mm.sdk.b.a.xef.m(dlVar);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
                x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in connectWCLanDevice!");
                return false;
            }
        }
        f(false, str);
        x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "disconnectWCLanDevice...");
        Java2CExDevice.disconnectWCLanDevice(bArr);
        return true;
    }

    public final boolean cn(String str, String str2) {
        if (!yT(str)) {
            x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceId " + str + " not connected!");
            return false;
        } else if (str == null || !this.lMj.containsKey(str)) {
            x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "mDevClassInfo is null in useWCLanDeviceService");
            return false;
        } else {
            byte[] bArr = (byte[]) this.lMj.get(str);
            this.lMC = 0;
            try {
                boolean z;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, str2);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("wxmsg_jsapi", jSONObject);
                jSONObject = new JSONObject();
                jSONObject.put("services", jSONObject2);
                this.lMC = Java2CExDevice.useWCLanDeviceService(bArr, jSONObject.toString().getBytes());
                if (this.lMC != 0) {
                    z = true;
                    x.d("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "get useWCLanDeviceService mCallBackCmdId =" + this.lMC);
                } else {
                    x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "useWCLanDeviceService error!");
                    z = false;
                }
                return z;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
                x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON encode failed in useWCLanDeviceService");
                return false;
            }
        }
    }

    public final boolean yT(String str) {
        if (str == null || !this.lMl.containsKey(str)) {
            return false;
        }
        return ((Boolean) this.lMl.get(str)).booleanValue();
    }
}
