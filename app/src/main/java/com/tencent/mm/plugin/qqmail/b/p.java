package com.tencent.mm.plugin.qqmail.b;

import android.util.SparseArray;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.bv.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.qqmail.b.h.b;
import com.tencent.mm.plugin.qqmail.b.h.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public final class p {
    private static SparseArray<String> ppd = null;
    public j poY;
    public c poZ;
    private Map<String, String> poy = new HashMap();
    private e ppa;
    private Map<Long, d> ppb = new HashMap();
    private Map<Long, b> ppc = new HashMap();

    static /* synthetic */ int a(p pVar, d dVar) {
        if (dVar.ppm.ppl) {
            h$c com_tencent_mm_plugin_qqmail_b_h_c = dVar.ppo;
            if (dVar.ppp == null) {
                dVar.ppq.onError(-1002, "format error");
                return -1002;
            }
            int i = bh.getInt((String) dVar.ppp.get(".Response.error.code"), 0);
            if (i == 0) {
                dVar.ppq.onSuccess(com_tencent_mm_plugin_qqmail_b_h_c.content, dVar.ppp);
                return 0;
            }
            dVar.ppq.onError(i, ax(i, (String) dVar.ppp.get(".Response.error.message")));
            return i;
        }
        dVar.ppq.onSuccess(dVar.ppo.content, null);
        return 0;
    }

    static /* synthetic */ void a(p pVar, Map map) {
        if (pVar.poy != null && map != null) {
            for (String str : map.keySet()) {
                pVar.poy.put(str, map.get(str));
            }
        }
    }

    public p(int i, String str) {
        x.setHost("qqmail.weixin.qq.com:443");
        x.setUserAgent("weixin/" + str + "/0x" + Integer.toHexString(i));
        reset();
    }

    public final long a(String str, Map<String, String> map, c cVar, a aVar) {
        return a(str, 1, map, null, cVar, aVar);
    }

    public final long b(String str, Map<String, String> map, c cVar, a aVar) {
        return a(str, 0, map, null, cVar, aVar);
    }

    public static String bkn() {
        return "https://qqmail.weixin.qq.com:443";
    }

    public final long a(String str, int i, Map<String, String> map, d dVar, c cVar, a aVar) {
        if (map == null) {
            map = new HashMap();
        }
        map.put("appname", "qqmail_weixin");
        map.put("f", "xml");
        map.put("charset", ProtocolPackage.ServerEncoding);
        map.put("clientip", getLocalIp());
        d dVar2 = new d(this, str, new b(i, map, getCookie(), dVar), aVar);
        dVar2.ppm = cVar;
        ag.y(new 1(this, dVar2));
        return dVar2.id;
    }

    public final void cancel(long j) {
        b bVar = (b) this.ppc.get(Long.valueOf(j));
        if (bVar != null) {
            bVar.onCancelled();
            bVar.cancel(true);
        }
        this.ppc.remove(Long.valueOf(j));
        this.ppb.remove(Long.valueOf(j));
    }

    public final void reset() {
        x.HH(getDownloadPath());
        for (b cancel : this.ppc.values()) {
            cancel.cancel(true);
        }
        this.ppc.clear();
        this.ppb.clear();
        this.poy.clear();
        ar.Hg();
        String Fq = c.Fq();
        this.poY = new j(Fq + "addr/");
        this.poZ = new c(Fq + "draft/");
        this.ppa = new e(Fq + "http/", 0);
    }

    public static String getDownloadPath() {
        String str = e.gHs;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdir();
        }
        return str;
    }

    private static String getLocalIp() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
        } catch (Exception e2) {
        }
        return null;
    }

    public final Map<String, String> getCookie() {
        Object obj;
        ar.Hg();
        String str = (String) c.CU().get(-1535680990, null);
        Map map = this.poy;
        String str2 = "skey";
        if (str == null) {
            obj = "";
        } else {
            String str3 = str;
        }
        map.put(str2, obj);
        ar.Hg();
        this.poy.put(OpenSDKTool4Assistant.EXTRA_UIN, "o" + new o(bh.o(c.CU().get(9, null), 0)));
        x.d("MicroMsg.NormalMailAppService", "sKey:%b, uin:%d", new Object[]{Boolean.valueOf(bh.ov(str)), Integer.valueOf(r1)});
        return this.poy;
    }

    private static String uZ(int i) {
        if (ppd == null) {
            ppd = new SparseArray();
            for (Field field : HttpURLConnection.class.getDeclaredFields()) {
                int modifiers = field.getModifiers();
                String name = field.getName();
                if (name != null && name.startsWith("HTTP_") && Modifier.isPublic(modifiers) && Modifier.isFinal(modifiers) && Modifier.isStatic(modifiers)) {
                    try {
                        modifiers = field.getInt(Integer.valueOf(0));
                        StringBuilder stringBuilder = new StringBuilder();
                        String[] split = name.split("_");
                        if (split != null) {
                            for (int i2 = 1; i2 < split.length; i2++) {
                                stringBuilder.append(split[i2]).append(' ');
                            }
                            stringBuilder.append("error");
                        }
                        ppd.put(modifiers, stringBuilder.toString().toLowerCase());
                    } catch (Exception e) {
                    }
                }
            }
        }
        String str = (String) ppd.get(i);
        return str == null ? ax(i, "request error") : str;
    }

    private static String ax(int i, String str) {
        int i2 = 0;
        switch (i) {
            case -105:
            case -6:
                i2 = R.l.eAL;
                break;
            case -104:
                i2 = R.l.eAJ;
                break;
            case -103:
                i2 = R.l.eAI;
                break;
            case -102:
                i2 = R.l.eAH;
                break;
            case -7:
                i2 = R.l.eAM;
                break;
            case -4:
            case -3:
                i2 = R.l.eAK;
                break;
            case -1:
                i2 = R.l.eAF;
                break;
        }
        if (i2 == 0) {
            return str;
        }
        return a.ac(ac.getContext(), i2);
    }
}
