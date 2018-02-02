package com.tencent.mm.network;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public final class b {
    static a hZx;

    public interface a {
        e CK();
    }

    public static class b {
        public String hZA;
        public boolean hZB = false;
        private boolean hZC = false;
        public int hZy = 0;
        private ArrayList<String> hZz = new ArrayList();
        public String host = null;
        public String ip = "";
        URL url = null;

        public b(String str) {
            this.hZA = str;
            try {
                this.url = new URL(str);
                this.host = this.url.getHost();
                ArrayList arrayList = new ArrayList();
                String str2;
                if (b.hZx == null || b.hZx.CK() == null) {
                    String str3 = "MicroMsg.GprsSetting";
                    String str4 = "UrlRedirct ERR:AUTOAUTH NULL:%s  [%s]";
                    Object[] objArr = new Object[2];
                    if (b.hZx == null) {
                        str2 = "-1";
                    } else {
                        str2 = b.hZx.CK();
                    }
                    objArr[0] = str2;
                    objArr[1] = bh.cgy();
                    x.e(str3, str4, objArr);
                    return;
                }
                this.hZy = b.hZx.CK().getHostByName(this.host, arrayList);
                x.d("MicroMsg.GprsSetting", "[Arth.302] dnsType:%d  host:%s url:%s", Integer.valueOf(this.hZy), this.host, str);
                if (arrayList.size() <= 0) {
                    this.hZy = 0;
                } else if (1 == this.hZy) {
                    str2 = (String) arrayList.get((int) (bh.Wp() % ((long) arrayList.size())));
                    this.ip = str2;
                    this.url = new URL(str.replaceFirst(this.host, str2));
                }
            } catch (Throwable e) {
                x.e("MicroMsg.GprsSetting", "exception:%s", bh.i(e));
            }
        }

        public b(String str, boolean z) {
            this.hZB = z;
            this.hZA = str;
            try {
                this.url = new URL(str);
                this.host = this.url.getHost();
                if (b.hZx == null || b.hZx.CK() == null) {
                    String str2;
                    String str3 = "MicroMsg.GprsSetting";
                    String str4 = "UrlRedirct ERR:AUTOAUTH NULL:%s  [%s]";
                    Object[] objArr = new Object[2];
                    if (b.hZx == null) {
                        str2 = "-1";
                    } else {
                        str2 = b.hZx.CK();
                    }
                    objArr[0] = str2;
                    objArr[1] = bh.cgy();
                    x.e(str3, str4, objArr);
                    return;
                }
                this.hZy = b.hZx.CK().a(this.host, z, this.hZz);
                Random random = new Random();
                random.setSeed(bh.Wp());
                Collections.shuffle(this.hZz, random);
                x.d("MicroMsg.GprsSetting", "[Arth.302] dnsType:%d  host:%s url:%s ips:%s", Integer.valueOf(this.hZy), this.host, str, this.hZz);
                if (this.hZz.size() <= 0) {
                    this.hZy = 0;
                } else if (1 == this.hZy) {
                    this.ip = (String) this.hZz.remove(0);
                    this.url = new URL(str.replaceFirst(this.host, this.ip));
                }
            } catch (Throwable e) {
                x.e("MicroMsg.GprsSetting", "exception:%s", bh.i(e));
            }
        }
    }

    public static void a(a aVar) {
        x.i("MicroMsg.GprsSetting", "sethostimpl %b, [%s]", Boolean.valueOf(false), bh.cgy());
        hZx = aVar;
    }

    public static int a(boolean z, List<String> list, String str) {
        int i = -1;
        if (hZx != null) {
            try {
                i = hZx.CK().a(str, z, list);
            } catch (Throwable e) {
                x.e("MicroMsg.GprsSetting", "exception:%s", bh.i(e));
            }
        }
        return i;
    }

    public static int a(String str, boolean z, List<String> list) {
        if (hZx == null || hZx.CK() == null) {
            return -1;
        }
        return hZx.CK().a(str, z, list);
    }

    public static void reportFailIp(String str) {
        if (hZx != null && hZx.CK() != null) {
            hZx.CK().reportFailIp(str);
        }
    }

    public static InputStream l(String str, int i, int i2) {
        u a = a(str, null);
        a.setConnectTimeout(i);
        a.setReadTimeout(i2);
        a.setRequestMethod("GET");
        if (a(a) != 0) {
            return null;
        }
        return a.getInputStream();
    }

    public static u a(String str, b bVar) {
        if (bVar == null) {
            bVar = new b(str);
        }
        x.i("MicroMsg.GprsSetting", "hy: url redirect host: %s, url: %s, ip: %s, dns_type: %d", bVar.host, bVar.url, bVar.ip, Integer.valueOf(bVar.hZy));
        u uVar = new u(bVar.url, bVar.hZy);
        uVar.iav = bVar.ip;
        if (1 == bVar.hZy) {
            uVar.setRequestProperty("Host", bVar.host);
            uVar.setRequestProperty("X-Online-Host", bVar.host);
        }
        return uVar;
    }

    public static int a(u uVar) {
        try {
            if (uVar.getResponseCode() != 200) {
                return -1;
            }
            return 0;
        } catch (Throwable e) {
            x.e("MicroMsg.GprsSetting", "exception:%s", bh.i(e));
            return -3;
        }
    }

    public static v oh(String str) {
        return new v(str);
    }
}
