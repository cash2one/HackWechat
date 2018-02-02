package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.WifiConfiguration;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.reflect.Proxy;

public final class a {
    private com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a jvH;
    public Context jvI;
    a jvJ = null;
    b jvK = null;
    public WifiConfiguration jvL = null;
    ConnectivityManager jvM;
    private int jvN = 0;
    private final int jvO = 13000;
    public boolean jvt = false;
    public BroadcastReceiver jvu = null;
    public String jvx;
    public String jvy;
    public Handler mHandler = null;

    private static Object a(a aVar, String str) {
        return Proxy.newProxyInstance(Class.forName(str).getClassLoader(), new Class[]{r0}, aVar);
    }

    public a(com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a aVar, Context context) {
        this.jvH = aVar;
        this.jvI = context;
        try {
            this.jvM = (ConnectivityManager) this.jvI.getSystemService("connectivity");
        } catch (Exception e) {
        }
        this.mHandler = new Handler(this, context.getMainLooper()) {
            final /* synthetic */ a jvP;

            public final void handleMessage(Message message) {
                if (message != null) {
                    switch (message.what) {
                        case 1:
                            if (!this.jvP.ahK()) {
                                this.jvP.sV("fail to connect wifi:time out");
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }
        };
    }

    public final boolean a(WifiConfiguration wifiConfiguration) {
        if (wifiConfiguration == null || wifiConfiguration.networkId == d.jvR || this.jvM == null) {
            return false;
        }
        try {
            Class cls = Class.forName("android.net.wifi.WifiManager");
            if (VERSION.SDK_INT < 16) {
                cls.getMethod("asyncConnect", new Class[]{Context.class, Handler.class}).invoke(c.bgP, new Object[]{this.jvI, this.mHandler});
                cls.getMethod("connectNetwork", new Class[]{Integer.TYPE}).invoke(c.bgP, new Object[]{Integer.valueOf(wifiConfiguration.networkId)});
                return true;
            } else if (VERSION.SDK_INT == 16) {
                r2 = "android.net.wifi.WifiManager$ChannelListener";
                if (this.jvK == null) {
                    this.jvK = new b(this);
                }
                r3 = a(this.jvJ, r2);
                r2 = Class.forName(r2);
                Object invoke = cls.getMethod("initialize", new Class[]{Context.class, Looper.class, r2}).invoke(c.bgP, new Object[]{this.jvI, this.jvI.getMainLooper(), r3});
                String str = "android.net.wifi.WifiManager$ActionListener";
                if (this.jvJ == null) {
                    this.jvJ = new a(this);
                }
                Object a = a(this.jvJ, str);
                Class cls2 = Class.forName(str);
                cls.getMethod("connect", new Class[]{Class.forName("android.net.wifi.WifiManager$Channel"), Integer.TYPE, cls2}).invoke(c.bgP, new Object[]{invoke, Integer.valueOf(wifiConfiguration.networkId), a});
                return true;
            } else {
                if (this.jvJ == null) {
                    this.jvJ = new a(this);
                }
                r2 = "android.net.wifi.WifiManager$ActionListener";
                r3 = a(this.jvJ, r2);
                r2 = Class.forName(r2);
                cls.getMethod("connect", new Class[]{Integer.TYPE, r2}).invoke(c.bgP, new Object[]{Integer.valueOf(wifiConfiguration.networkId), r3});
                return true;
            }
        } catch (Exception e) {
            return c.kN(wifiConfiguration.networkId);
        }
    }

    public final boolean ahK() {
        return this.jvN == 3 || this.jvN == 2;
    }

    public final void sV(String str) {
        if (this.jvL != null) {
            b.kM(this.jvL.networkId);
            e(false, str);
            new StringBuilder("cancelConnect, ").append(d.sW(this.jvL.SSID)).append(" networkId:").append(this.jvL.networkId);
        }
    }

    public final void kL(int i) {
        if (this.jvN != i) {
            String str;
            this.jvN = i;
            StringBuilder stringBuilder = new StringBuilder("switchState:");
            switch (this.jvN) {
                case 0:
                    str = "STATE_NONE";
                    break;
                case 1:
                    str = "STATE_CONNECTING";
                    break;
                case 2:
                    str = "STATE_CONNECTED";
                    break;
                case 3:
                    str = "STATE_FAIL";
                    break;
                default:
                    str = "UnknowState";
                    break;
            }
            stringBuilder.append(str);
        }
    }

    public final void e(boolean z, String str) {
        if (!ahK()) {
            if (this.jvH != null) {
                com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a aVar = this.jvH;
                if (z) {
                    str = "ok";
                }
                aVar.sU(str);
            }
            this.mHandler.removeMessages(1);
            if (this.jvt) {
                this.jvI.unregisterReceiver(this.jvu);
                this.jvt = false;
            }
            kL(z ? 2 : 3);
            if (!z && this.jvL != null) {
                b.kM(this.jvL.networkId);
            }
        }
    }
}
