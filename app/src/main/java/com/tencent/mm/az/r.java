package com.tencent.mm.az;

import com.tencent.mm.by.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.p;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class r implements ap {
    private static HashMap<Integer, d> gwY;
    private n hJM;
    private b hJN;
    private o hJO = new o();
    private p hJP = new p();
    private q hJQ = new q();
    private l hJR = null;
    c hJS = new 3(this);

    private static r QG() {
        return (r) p.s(r.class);
    }

    public static n QH() {
        g.Dh().Ct();
        if (QG().hJM == null) {
            QG().hJM = new n(g.Dj().gQj);
        }
        return QG().hJM;
    }

    public static b QI() {
        g.Dh().Ct();
        if (QG().hJN == null) {
            QG().hJN = new b(g.Dj().gQj);
        }
        return QG().hJN;
    }

    public final void onAccountRelease() {
        a.xef.c(this.hJO);
        a.xef.c(this.hJP);
        a.xef.c(this.hJQ);
        a.xef.c(this.hJR.hJI);
        a.xef.c(this.hJR.hJJ);
        a.xef.c(this.hJS);
    }

    public final void bq(boolean z) {
        a.xef.b(this.hJO);
        a.xef.b(this.hJP);
        a.xef.b(this.hJQ);
        a.xef.b(this.hJS);
        if (this.hJR != null) {
            this.hJR.hJH.clear();
        } else {
            this.hJR = new l();
        }
        a.xef.b(this.hJR.hJI);
        a.xef.b(this.hJR.hJJ);
    }

    static {
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("PACKAGE_INFO_TABLE".hashCode()), new 1());
        gwY.put(Integer.valueOf("CHATTINGBGINFO_TABLE".hashCode()), new d() {
            public final String[] wg() {
                return b.gJN;
            }
        });
    }

    public final HashMap<Integer, d> Bn() {
        return gwY;
    }

    public final void gd(int i) {
    }

    public final void br(boolean z) {
    }

    private boolean lN(String str) {
        InputStream fileInputStream;
        BufferedWriter bufferedWriter;
        Throwable e;
        InputStream inputStream;
        Throwable th;
        String str2 = null;
        File file = new File(str);
        if (file.exists()) {
            Map hashMap = new HashMap();
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    File file2;
                    Reader inputStreamReader = new InputStreamReader(fileInputStream, ProtocolPackage.ServerEncoding);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String[] split = readLine.trim().split("\\|");
                        if (split.length < 2 || bh.ov(split[0]) || bh.ov(split[1])) {
                            x.e("MicroMsg.SubCorePacakge", "dispatch regioncode, error line = " + readLine);
                        } else {
                            bufferedWriter = (BufferedWriter) hashMap.get(split[0]);
                            if (bufferedWriter == null) {
                                RegionCodeDecoder.cjP();
                                str2 = RegionCodeDecoder.XD(split[0]);
                                if (bh.ov(str2)) {
                                    x.e("MicroMsg.SubCorePacakge", "dispatch regioncode, output language unsupported");
                                } else {
                                    file2 = new File(str2);
                                    if (!file2.exists()) {
                                        file2.createNewFile();
                                    }
                                    bufferedWriter = new BufferedWriter(new FileWriter(file2));
                                    hashMap.put(split[0], bufferedWriter);
                                }
                            }
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append(split[1]);
                            stringBuffer.append('|');
                            stringBuffer.append(split[2]);
                            stringBuffer.append('\n');
                            bufferedWriter.write(stringBuffer.toString());
                        }
                    }
                    for (BufferedWriter bufferedWriter2 : hashMap.values()) {
                        if (bufferedWriter2 != null) {
                            bufferedWriter2.flush();
                        }
                    }
                    if (!bh.ov(str2)) {
                        for (File file22 : new File(str2).getParentFile().listFiles(new 4(this))) {
                            RegionCodeDecoder.cjP();
                            RegionCodeDecoder.f(file22, file22.getParentFile());
                        }
                        RegionCodeDecoder.cjP().chP();
                    }
                    bufferedReader.close();
                    inputStreamReader.close();
                    file.delete();
                    try {
                        fileInputStream.close();
                        for (BufferedWriter bufferedWriter22 : hashMap.values()) {
                            if (bufferedWriter22 != null) {
                                bufferedWriter22.close();
                            }
                        }
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.SubCorePacakge", e2, "", new Object[0]);
                    }
                    return true;
                } catch (Exception e3) {
                    e2 = e3;
                    inputStream = fileInputStream;
                } catch (Throwable e22) {
                    th = e22;
                }
            } catch (Exception e4) {
                e22 = e4;
                inputStream = null;
                try {
                    x.printErrStackTrace("MicroMsg.SubCorePacakge", e22, "", new Object[0]);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e222) {
                            x.printErrStackTrace("MicroMsg.SubCorePacakge", e222, "", new Object[0]);
                            return false;
                        }
                    }
                    for (BufferedWriter bufferedWriter222 : hashMap.values()) {
                        if (bufferedWriter222 != null) {
                            bufferedWriter222.close();
                        }
                    }
                    return false;
                } catch (Throwable e2222) {
                    fileInputStream = inputStream;
                    th = e2222;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e22222) {
                            x.printErrStackTrace("MicroMsg.SubCorePacakge", e22222, "", new Object[0]);
                            throw th;
                        }
                    }
                    for (BufferedWriter bufferedWriter2222 : hashMap.values()) {
                        if (bufferedWriter2222 != null) {
                            bufferedWriter2222.close();
                        }
                    }
                    throw th;
                }
            } catch (Throwable e222222) {
                th = e222222;
                fileInputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                for (BufferedWriter bufferedWriter22222 : hashMap.values()) {
                    if (bufferedWriter22222 != null) {
                        bufferedWriter22222.close();
                    }
                }
                throw th;
            }
        }
        x.e("MicroMsg.SubCorePacakge", "update regioncode failed, file not exist, packagePath:" + str);
        return false;
    }
}
