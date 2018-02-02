package com.tencent.mm.k;

import android.util.SparseArray;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    public static final String gId = (w.gZK + "configlist/");
    public SparseArray<d> gIc = new SparseArray();

    public static String fP(int i) {
        return gId + "config_" + i + ".xml";
    }

    public final boolean b(File file, File file2) {
        Throwable e;
        InputStream inputStream = null;
        int i = 0;
        if (!file.exists()) {
            return false;
        }
        if (file.isDirectory()) {
            if (!file2.exists()) {
                file2.mkdir();
            }
            File[] listFiles = file.listFiles();
            boolean z = false;
            while (i < listFiles.length) {
                File file3 = listFiles[i];
                z = b(file3, new File(file2.getPath(), file3.getName()));
                if (z) {
                    file.delete();
                }
                i++;
            }
            return z;
        }
        OutputStream fileOutputStream;
        try {
            InputStream fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    file.delete();
                    try {
                        fileInputStream.close();
                    } catch (Throwable e2) {
                        x.e("MicroMsg.ConfigListDecoder", "exception:%s", bh.i(e2));
                    }
                    try {
                        fileOutputStream.close();
                    } catch (Throwable e22) {
                        x.e("MicroMsg.ConfigListDecoder", "exception:%s", bh.i(e22));
                    }
                    return true;
                } catch (Exception e3) {
                    e22 = e3;
                    inputStream = fileInputStream;
                    try {
                        x.e("MicroMsg.ConfigListDecoder", "exception:%s", bh.i(e22));
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e222) {
                                x.e("MicroMsg.ConfigListDecoder", "exception:%s", bh.i(e222));
                            }
                        }
                        if (fileOutputStream != null) {
                            return false;
                        }
                        try {
                            fileOutputStream.close();
                            return false;
                        } catch (Throwable e2222) {
                            x.e("MicroMsg.ConfigListDecoder", "exception:%s", bh.i(e2222));
                            return false;
                        }
                    } catch (Throwable th) {
                        e2222 = th;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable e4) {
                                x.e("MicroMsg.ConfigListDecoder", "exception:%s", bh.i(e4));
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable e5) {
                                x.e("MicroMsg.ConfigListDecoder", "exception:%s", bh.i(e5));
                            }
                        }
                        throw e2222;
                    }
                } catch (Throwable th2) {
                    e2222 = th2;
                    inputStream = fileInputStream;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw e2222;
                }
            } catch (Exception e6) {
                e2222 = e6;
                fileOutputStream = null;
                inputStream = fileInputStream;
                x.e("MicroMsg.ConfigListDecoder", "exception:%s", bh.i(e2222));
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream != null) {
                    return false;
                }
                fileOutputStream.close();
                return false;
            } catch (Throwable th3) {
                e2222 = th3;
                fileOutputStream = null;
                inputStream = fileInputStream;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e2222;
            }
        } catch (Exception e7) {
            e2222 = e7;
            fileOutputStream = null;
            x.e("MicroMsg.ConfigListDecoder", "exception:%s", bh.i(e2222));
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileOutputStream != null) {
                return false;
            }
            fileOutputStream.close();
            return false;
        } catch (Throwable th4) {
            e2222 = th4;
            fileOutputStream = null;
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw e2222;
        }
    }

    public final void init() {
        for (int load : d.gIe) {
            load(load);
        }
    }

    public final void p(int i, String str) {
        d dVar = new d(i);
        dVar.gIg = bi.y(str, "ConfigList");
        if (dVar.gIg.containsKey(".ConfigList.$version")) {
            dVar.version = Integer.valueOf((String) dVar.gIg.get(".ConfigList.$version")).intValue();
        }
        int i2 = 0;
        while (true) {
            String str2 = ".ConfigList.Config" + (i2 == 0 ? "" : Integer.valueOf(i2));
            if (dVar.gIg.get(str2 + ".$name") != null) {
                String str3 = (String) dVar.gIg.get(str2 + ".$name");
                if (!str3.equalsIgnoreCase("JDWebViewMenu")) {
                    int i3 = 0;
                    while (true) {
                        String str4 = str2 + ".Item" + (i3 == 0 ? "" : Integer.valueOf(i3));
                        String str5 = str2 + ".Item" + (i3 == 0 ? "" : Integer.valueOf(i3)) + ".$key";
                        String str6 = str2 + ".Item" + (i3 == 0 ? "" : Integer.valueOf(i3)) + ".$lang";
                        if (!dVar.gIg.containsKey(str4)) {
                            break;
                        }
                        String str7 = (String) dVar.gIg.get(str5);
                        str4 = (String) dVar.gIg.get(str4);
                        str5 = (String) dVar.gIg.get(str6);
                        x.d("MicroMsg.ConfigListInfo", "itemKey " + str7 + " itemValue " + str4 + " itemLang " + str5);
                        if (str5 == null || d.eP(str5)) {
                            if (!dVar.gIf.containsKey(str3)) {
                                dVar.gIf.put(str3, new HashMap());
                            }
                            ((HashMap) dVar.gIf.get(str3)).put(str7, str4);
                        }
                        i3++;
                    }
                }
                i2++;
            } else {
                this.gIc.put(Integer.valueOf(i).intValue(), dVar);
                return;
            }
        }
    }

    public final String F(String str, String str2) {
        d fQ = fQ(1);
        if (fQ != null && fQ.gIf.containsKey(str)) {
            return (String) ((HashMap) fQ.gIf.get(str)).get(str2);
        }
        return null;
    }

    public final d fQ(int i) {
        if (this.gIc.get(1) == null) {
            load(1);
        }
        return (d) this.gIc.get(1);
    }

    private void load(int i) {
        InputStream fileInputStream;
        Throwable e;
        try {
            File file = new File(fP(i));
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    Reader inputStreamReader = new InputStreamReader(fileInputStream, ProtocolPackage.ServerEncoding);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    }
                    p(i, stringBuffer.toString());
                    inputStreamReader.close();
                    bufferedReader.close();
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.e("MicroMsg.ConfigListDecoder", "exception:%s", bh.i(e));
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable e3) {
                                x.e("MicroMsg.ConfigListDecoder", "exception:%s", bh.i(e3));
                                return;
                            }
                        }
                    } catch (Throwable th) {
                        e3 = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable e4) {
                                x.e("MicroMsg.ConfigListDecoder", "exception:%s", bh.i(e4));
                            }
                        }
                        throw e3;
                    }
                }
            }
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Throwable e32) {
                    x.e("MicroMsg.ConfigListDecoder", "exception:%s", bh.i(e32));
                }
            }
        } catch (Exception e5) {
            e32 = e5;
            fileInputStream = null;
            x.e("MicroMsg.ConfigListDecoder", "exception:%s", bh.i(e32));
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        } catch (Throwable th2) {
            e32 = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e32;
        }
    }

    public static int zJ() {
        int i;
        String value = ((a) g.h(a.class)).zY().getValue("VoiceVOIPSwitch");
        x.d("MicroMsg.ConfigListDecoder", "voip is " + value);
        try {
            i = bh.getInt(value, 0);
        } catch (Throwable e) {
            x.e("MicroMsg.ConfigListDecoder", "exception:%s", bh.i(e));
            i = 0;
        }
        x.d("MicroMsg.ConfigListDecoder", "showVoiceVoipEntrance is " + i);
        return i;
    }

    public final boolean zK() {
        boolean z = true;
        if (bh.getInt(F("WebViewConfig", "disableWePkg"), 0) != 1) {
            z = false;
        }
        x.d("MicroMsg.ConfigListDecoder", "disableWePkg : " + z);
        return z;
    }

    public final String zL() {
        x.d("MicroMsg.ConfigListDecoder", "get check url for free wifi : %s", F("FreeWiFiConfig", "CheckURL"));
        return F("FreeWiFiConfig", "CheckURL");
    }

    public final boolean zM() {
        boolean z = true;
        if (bh.getInt(F("ShowConfig", "showRecvTmpMsgBtn"), 0) != 1) {
            z = false;
        }
        x.d("MicroMsg.ConfigListDecoder", "isShowRecvTmpMsgBtn : " + z);
        return z;
    }

    public final List<String> zN() {
        List<String> list = null;
        String F = F("IBeacon", "Content");
        if (!bh.ov(F)) {
            list = new ArrayList();
            try {
                Iterator keys = new JSONObject(F.replace(",}", "}")).keys();
                while (keys.hasNext()) {
                    Object next = keys.next();
                    if (next != null) {
                        list.add(next.toString());
                    }
                }
            } catch (JSONException e) {
                x.e("MicroMsg.ConfigListDecoder", "[oneliang] json parse exception: " + e.getMessage());
            }
        }
        return list;
    }

    public final String zO() {
        return F("MailApp", "MailAppRedirectUrAndroid");
    }

    public final String getMailAppEnterUlAndroid() {
        return F("MailApp", "MailAppEnterMailAppUrlAndroid");
    }
}
