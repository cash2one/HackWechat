package com.tencent.mm.plugin.backup.e;

import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public final class k extends com.tencent.mm.plugin.backup.a.a {
    private static String END = "img";
    private static String knj = "icon_";
    private static String knk = "iphone";
    private static String knl = "android";
    private static String knm = "s60v3";
    private static String knn = "s60v5";
    private static k kno;
    private Map<String, a> knp = null;

    public static class a {
        public String knq = "";
        public String knr = "";
        public String kns = "";
        public String knt = "";

        public a(String str, String str2, String str3, String str4) {
            this.knq = str;
            this.knr = str2;
            this.kns = str3;
            this.knt = str4;
        }

        public final String toString() {
            return this.knq + " " + this.knr + " " + this.kns + " " + this.knt;
        }
    }

    public static a vv(String str) {
        if (kno == null) {
            kno = new k();
        }
        k kVar = kno;
        if (kVar.knp == null) {
            kVar.apr();
        }
        for (a aVar : kVar.knp.values()) {
            if (aVar.knr != null && aVar.knr.equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    public static a vw(String str) {
        if (kno == null) {
            com.tencent.mm.plugin.backup.a.a kVar = new k();
            kno = kVar;
            a(kVar);
        }
        k kVar2 = kno;
        if (kVar2.knp == null) {
            kVar2.apr();
        }
        return (a) kVar2.knp.get(str);
    }

    public final void aog() {
        kno = null;
    }

    public k() {
        apr();
    }

    private void apr() {
        InputStream open;
        int i;
        Throwable e;
        Throwable e2;
        this.knp = new HashMap();
        BufferedReader bufferedReader;
        try {
            open = ac.getContext().getAssets().open("emojiconf");
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(open, ProtocolPackage.ServerEncoding));
                i = 0;
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        try {
                            break;
                        } catch (Exception e3) {
                        }
                    } else if (readLine.contains(knj)) {
                        a aVar = new a();
                        while (true) {
                            String readLine2 = bufferedReader.readLine();
                            if (readLine2 != null && !readLine2.contains(END)) {
                                int indexOf = readLine2.indexOf("=");
                                if (indexOf + 1 >= readLine2.length()) {
                                    break;
                                }
                                String substring = readLine2.substring(indexOf + 1);
                                if (readLine2.startsWith(knk)) {
                                    aVar.knr = substring;
                                } else if (readLine2.startsWith(knl)) {
                                    aVar.knq = substring;
                                } else {
                                    try {
                                        if (readLine2.startsWith(knm)) {
                                            aVar.kns = substring;
                                        } else if (readLine2.startsWith(knn)) {
                                            aVar.knt = substring;
                                        }
                                    } catch (IOException e4) {
                                        e = e4;
                                    }
                                }
                                this.knp.put(aVar.knq, aVar);
                            } else {
                                break;
                            }
                        }
                        x.d("MicroMsg.EmojiCovertMap", "emojiValue:%s", aVar.toString());
                        i++;
                    }
                }
                bufferedReader.close();
                if (open != null) {
                    open.close();
                }
            } catch (Throwable e22) {
                bufferedReader = null;
                e = e22;
                i = 0;
                try {
                    x.printErrStackTrace("MicroMsg.EmojiCovertMap", e, "", new Object[0]);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e5) {
                        }
                    }
                    if (open != null) {
                        open.close();
                    }
                    x.d("MicroMsg.EmojiCovertMap", "id " + i);
                } catch (Throwable th) {
                    e22 = th;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e6) {
                            throw e22;
                        }
                    }
                    if (open != null) {
                        open.close();
                    }
                    throw e22;
                }
            } catch (Throwable th2) {
                e22 = th2;
                bufferedReader = null;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (open != null) {
                    open.close();
                }
                throw e22;
            }
        } catch (Throwable e222) {
            bufferedReader = null;
            open = null;
            e = e222;
            i = 0;
            x.printErrStackTrace("MicroMsg.EmojiCovertMap", e, "", new Object[0]);
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (open != null) {
                open.close();
            }
            x.d("MicroMsg.EmojiCovertMap", "id " + i);
        } catch (Throwable th3) {
            e222 = th3;
            bufferedReader = null;
            open = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (open != null) {
                open.close();
            }
            throw e222;
        }
        x.d("MicroMsg.EmojiCovertMap", "id " + i);
    }
}
