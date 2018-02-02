package com.tencent.mm.plugin.ext.c;

import com.tencent.mm.a.e;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ext.c.b.b;
import com.tencent.mm.plugin.ext.c.e.a;
import com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi;
import com.tencent.mm.pluginsdk.i.a.b.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.io.File;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class c {
    private static com.tencent.mm.sdk.b.c ikK = new 1();
    private static HashSet<String> mbf = new HashSet();
    private static HashSet<String> mbg = new HashSet();
    private static ArrayList<a> mbh = new ArrayList();
    private static HashMap<String, a> mbi = new HashMap();

    private static String aFS() {
        String str;
        if (ExtControlProviderOpenApi.lZP) {
            str = h.getExternalStorageDirectory().getAbsolutePath() + File.separator + "extqbar";
        } else {
            str = ac.getContext().getFilesDir().getParent() + File.separator + "extqbar";
        }
        File file = new File(str);
        if (!file.exists()) {
            x.i("MicroMsg.ExtQbarDataManager", "hy: face dir not exist. mk dir");
            file.mkdirs();
        }
        return str + File.separator + "ext_qbar_config.csv";
    }

    private static void aFT() {
        if (e.bO(aFS())) {
            try {
                String bT = e.bT(aFS());
                x.i("MicroMsg.ExtQbarDataManager", "hy: found qrcode config");
                x.v("MicroMsg.ExtQbarDataManager", "hy: qrcode config is %s", new Object[]{bT});
                if (bh.ov(bT)) {
                    x.w("MicroMsg.ExtQbarDataManager", "hy: no preset black/white config");
                }
                BufferedReader bufferedReader = new BufferedReader(new StringReader(bT));
                long Wq = bh.Wq();
                while (true) {
                    try {
                        bT = bufferedReader.readLine();
                        if (bT == null) {
                            break;
                        }
                        x.d("MicroMsg.ExtQbarDataManager", "hy: retrieving line");
                        String[] split = bT.split(",");
                        if (split.length < 3) {
                            x.w("MicroMsg.ExtQbarDataManager", "hy: line %s not qualified length!", new Object[]{bT});
                        } else {
                            int i;
                            a aVar = new a();
                            aVar.url = split[2].toUpperCase();
                            if ("white".equalsIgnoreCase(split[0])) {
                                aVar.maW = b.mbc;
                                if ("prefix".equalsIgnoreCase(split[1])) {
                                    aVar.maV = b.a.maX;
                                    i = 1;
                                } else if ("subdomain".equalsIgnoreCase(split[1])) {
                                    aVar.maV = b.a.maY;
                                    i = 1;
                                } else if ("domain".equalsIgnoreCase(split[1])) {
                                    aVar.maV = b.a.maZ;
                                    i = 1;
                                } else {
                                    x.w("MicroMsg.ExtQbarDataManager", "hy: [white] 2nd not qualified! %s", new Object[]{split[1]});
                                    i = 0;
                                }
                            } else if ("black".equalsIgnoreCase(split[0])) {
                                aVar.maW = b.mbb;
                                if ("prefix".equalsIgnoreCase(split[1])) {
                                    aVar.maV = b.a.maX;
                                    i = 1;
                                } else if ("subdomain".equalsIgnoreCase(split[1])) {
                                    aVar.maV = b.a.maY;
                                    i = 1;
                                } else if ("domain".equalsIgnoreCase(split[1])) {
                                    aVar.maV = b.a.maZ;
                                    i = 1;
                                } else {
                                    x.w("MicroMsg.ExtQbarDataManager", "hy: [black] 2nd not qualified! %s", new Object[]{split[1]});
                                    i = 0;
                                }
                            } else {
                                x.w("MicroMsg.ExtQbarDataManager", "hy: 1st not qualified! %s", new Object[]{split[0]});
                                i = 0;
                            }
                            if (i != 0) {
                                mbh.add(aVar);
                            }
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.ExtQbarDataManager", e, "hy: exception when parse config!", new Object[0]);
                    }
                }
                x.i("MicroMsg.ExtQbarDataManager", "hy: qrcode config retrieved using %d ms", new Object[]{Long.valueOf(bh.bA(Wq))});
                return;
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.ExtQbarDataManager", e2, "hy: read config file failed!", new Object[0]);
                return;
            }
        }
        x.w("MicroMsg.ExtQbarDataManager", "hy: not found csv file");
        g.CG().a(new m(46), 0);
    }

    public static void aFU() {
        aFT();
        com.tencent.mm.sdk.b.a.xef.b(ikK);
    }

    public static void aFV() {
        com.tencent.mm.sdk.b.a.xef.c(ikK);
    }

    public static void zA(String str) {
        mbf.add(str);
    }

    public static void zB(String str) {
        mbg.add(str);
    }

    public static void a(String str, a aVar) {
        mbi.put(str, aVar);
    }

    public static a zC(String str) {
        return (a) mbi.get(str);
    }

    public static void clearCache() {
        mbi.clear();
    }

    public static boolean zD(String str) {
        if (bh.ov(str)) {
            x.w("MicroMsg.ExtQbarDataManager", "hy: null in fastJudgeInWhitelist");
            return false;
        } else if (!mbf.contains(str)) {
            return false;
        } else {
            x.i("MicroMsg.ExtQbarDataManager", "hy: %s already in whitelist", new Object[]{str});
            return true;
        }
    }

    public static boolean zE(String str) {
        if (bh.ov(str)) {
            x.w("MicroMsg.ExtQbarDataManager", "hy: null in fastJudgeInBlacklist");
            return false;
        } else if (!mbg.contains(str)) {
            return false;
        } else {
            x.i("MicroMsg.ExtQbarDataManager", "hy: %s already in blacklist", new Object[]{str});
            return true;
        }
    }

    public static b zF(String str) {
        if (bh.ov(str)) {
            x.w("MicroMsg.ExtQbarDataManager", "hy: url is null when get config");
            return b.mbd;
        }
        Iterator it = mbh.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.maV != b.a.maX) {
                try {
                    String host = new URL(str).getHost();
                    x.d("MicroMsg.ExtQbarDataManager", "hy: host is %s", new Object[]{host});
                    if (bh.G(new String[0])) {
                        x.w("MicroMsg.ExtQbarDataManager", "hy: no valid host");
                    } else if (aVar.maV == b.a.maZ) {
                        if (aVar.url.equals(host)) {
                            x.i("MicroMsg.ExtQbarDataManager", "hy: match domain: %s", new Object[]{aVar.maV});
                            return aVar.maW;
                        }
                    } else if (aVar.maV == b.a.maY) {
                        String[] split = aVar.url.split("\\.");
                        String[] split2 = host.split("\\.");
                        if (split.length > 0 && split2.length > 0 && split.length <= split2.length) {
                            int length = split.length - 1;
                            int length2 = split2.length - 1;
                            int i = 1;
                            while (length >= 0 && length2 >= 0) {
                                if (!split[length].equals(split2[length2])) {
                                    i = 0;
                                }
                                length--;
                                length2--;
                            }
                            if (i != 0) {
                                x.i("MicroMsg.ExtQbarDataManager", "hy: match %s subdomain: %s", new Object[]{str, aVar.url});
                                return aVar.maW;
                            }
                        }
                    } else {
                        x.e("MicroMsg.ExtQbarDataManager", "hy: damn it impossible!");
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.ExtQbarDataManager", e, "hy: error in url convert: %s", new Object[]{str});
                }
            } else if (str.startsWith(aVar.url)) {
                x.i("MicroMsg.ExtQbarDataManager", "hy: match prefix: %s", new Object[]{aVar.url});
                return aVar.maW;
            }
        }
        return b.mbd;
    }
}
