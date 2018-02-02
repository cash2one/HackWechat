package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public final class a extends com.tencent.mm.plugin.backup.a.a {
    private static String END = "img";
    private static String knj = "icon_";
    private static String knk = "iphone";
    private static String knl = "android";
    private static String knm = "s60v3";
    private static String knn = "s60v5";
    private static a kqk;
    private Map<String, a> knp = null;

    public static a vB(String str) {
        if (kqk == null) {
            kqk = new a();
        }
        a aVar = kqk;
        if (aVar.knp == null) {
            aVar.apr();
        }
        for (a aVar2 : aVar.knp.values()) {
            if (aVar2.knr != null && aVar2.knr.equals(str)) {
                return aVar2;
            }
        }
        return null;
    }

    public static a vC(String str) {
        if (kqk == null) {
            com.tencent.mm.plugin.backup.a.a aVar = new a();
            kqk = aVar;
            a(aVar);
        }
        a aVar2 = kqk;
        if (aVar2.knp == null) {
            aVar2.apr();
        }
        return (a) aVar2.knp.get(str);
    }

    public final void aog() {
        kqk = null;
    }

    public a() {
        apr();
    }

    private void apr() {
        InputStream open;
        BufferedReader bufferedReader;
        int i;
        Throwable e;
        Throwable e2;
        this.knp = new HashMap();
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
                        x.d("MicroMsg.BakOldEmojiCovertMap", "emojiValue:%s", aVar.toString());
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
                    x.printErrStackTrace("MicroMsg.BakOldEmojiCovertMap", e, "", new Object[0]);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e5) {
                        }
                    }
                    if (open != null) {
                        open.close();
                    }
                    x.d("MicroMsg.BakOldEmojiCovertMap", "id " + i);
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
            x.printErrStackTrace("MicroMsg.BakOldEmojiCovertMap", e, "", new Object[0]);
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (open != null) {
                open.close();
            }
            x.d("MicroMsg.BakOldEmojiCovertMap", "id " + i);
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
        x.d("MicroMsg.BakOldEmojiCovertMap", "id " + i);
    }
}
