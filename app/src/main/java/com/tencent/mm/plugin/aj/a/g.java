package com.tencent.mm.plugin.aj.a;

import android.content.res.AssetManager;
import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.a.o;
import com.tencent.mm.kernel.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.protocal.c.aoh;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public final class g {
    private static Map<Integer, k> tkl = new HashMap();
    private static Map<Integer, c> tkm = new HashMap();

    public static Properties o(File file) {
        InputStream fileInputStream;
        Throwable e;
        Properties properties = new Properties();
        if (file != null && file.isFile()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    properties.load(fileInputStream);
                    e.c(fileInputStream);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e, "", new Object[0]);
                        e.c(fileInputStream);
                        return properties;
                    } catch (Throwable th) {
                        e = th;
                        e.c(fileInputStream);
                        throw e;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileInputStream = null;
                x.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e, "", new Object[0]);
                e.c(fileInputStream);
                return properties;
            } catch (Throwable th2) {
                e = th2;
                fileInputStream = null;
                e.c(fileInputStream);
                throw e;
            }
        }
        return properties;
    }

    public static final String zH(int i) {
        StringBuilder append = new StringBuilder().append(i).append("_");
        com.tencent.mm.kernel.g.Dh();
        return append.append(o.getString(a.Cg())).append("_").append(System.currentTimeMillis()).toString();
    }

    static {
        tkl.put(Integer.valueOf(1), new k("fts_browse/res", "wrd_template.zip", "browse"));
        tkl.put(Integer.valueOf(0), new k("fts/res", "fts_template.zip", ""));
        Map map = tkm;
        Integer valueOf = Integer.valueOf(0);
        zJ(0);
        map.put(valueOf, j.bOW());
        map = tkm;
        valueOf = Integer.valueOf(1);
        zJ(1);
        map.put(valueOf, j.bOW());
    }

    public static k zI(int i) {
        return (k) tkl.get(Integer.valueOf(i));
    }

    private static String zJ(int i) {
        return ((k) tkl.get(Integer.valueOf(i))).Rh() + File.separator + "app.html";
    }

    public static String bOR() {
        tkl.get(Integer.valueOf(1));
        return "app.html";
    }

    public static String bOS() {
        tkl.get(Integer.valueOf(1));
        return "config.conf";
    }

    public static void bOT() {
        Iterator it = tkm.values().iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public static void zK(int i) {
        ((c) tkm.get(Integer.valueOf(i))).bOP();
    }

    public static int zL(int i) {
        k kVar = (k) tkl.get(Integer.valueOf(i));
        String str = TextUtils.isEmpty(kVar.tkA) ? "config.conf" : kVar.tkA + File.separator + "config.conf";
        AssetManager assets = ac.getContext().getAssets();
        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = assets.open(str);
            properties.load(inputStream);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e, e.getMessage(), new Object[0]);
        } finally {
            e.c(inputStream);
        }
        return Integer.valueOf(properties.getProperty("version", "1")).intValue();
    }

    public static boolean zM(int i) {
        x.i("MicroMsg.WebSearch.WebSearchApiLogic", "isFTSH5TemplateAvail exportType:%d, use search default.", new Object[]{Integer.valueOf(i)});
        return ((k) tkl.get(Integer.valueOf(i))).Nj() > 1;
    }

    public static int zN(int i) {
        return ((k) tkl.get(Integer.valueOf(i))).Nj();
    }

    public static boolean zO(int i) {
        OutputStream outputStream = null;
        AssetManager assets = ac.getContext().getAssets();
        String bOZ = ((k) tkl.get(Integer.valueOf(i))).bOZ();
        k kVar = (k) tkl.get(Integer.valueOf(i));
        String str = TextUtils.isEmpty(kVar.tkA) ? kVar.tkz : kVar.tkA + File.separator + kVar.tkz;
        if (bh.ov(bOZ) || bh.ov(str)) {
            x.w("MicroMsg.WebSearch.WebSearchApiLogic", "copyTemplateFromAsset no dstPath or template path!");
            return false;
        }
        InputStream open;
        try {
            open = assets.open(str);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e, "", new Object[0]);
            open = null;
        }
        if (open == null) {
            x.e("MicroMsg.WebSearch.WebSearchApiLogic", "file inputStream not found");
            return false;
        }
        File file = new File(bOZ);
        if (file.exists()) {
            file.delete();
        }
        file.getParentFile().mkdirs();
        try {
            outputStream = new FileOutputStream(file);
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e2, "", new Object[0]);
        }
        if (outputStream != null) {
            try {
                d(open, outputStream);
                return true;
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.WebSearch.WebSearchApiLogic", e22, "", new Object[0]);
                return false;
            } finally {
                e.c(open);
                e.a(outputStream);
            }
        } else {
            e.c(open);
            return false;
        }
    }

    private static void d(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static String zP(int i) {
        return ((k) tkl.get(Integer.valueOf(i))).bOZ();
    }

    public static int zQ(int i) {
        return ((k) tkl.get(Integer.valueOf(i))).bOX();
    }

    public static String zR(int i) {
        return ((k) tkl.get(Integer.valueOf(i))).Rh();
    }

    public static String zS(int i) {
        return ((k) tkl.get(Integer.valueOf(zV(i)))).Rh();
    }

    public static String zT(int i) {
        return ((k) tkl.get(Integer.valueOf(zV(i)))).tkz;
    }

    public static int zU(int i) {
        return ((k) tkl.get(Integer.valueOf(zV(i)))).Nj();
    }

    private static int zV(int i) {
        switch (i) {
            case 1:
                return 0;
            case 2:
                return 1;
            default:
                return -1;
        }
    }

    public static String bOU() {
        return o(new File(((k) tkl.get(Integer.valueOf(1))).Rh(), "config_data.conf")).getProperty("kv_set", "");
    }

    public static String bfF() {
        if (an.isWifi(ac.getContext())) {
            return "wifi";
        }
        if (an.is4G(ac.getContext())) {
            return "4g";
        }
        if (an.is3G(ac.getContext())) {
            return "3g";
        }
        if (an.is2G(ac.getContext())) {
            return "2g";
        }
        if (an.isConnected(ac.getContext())) {
            return "";
        }
        return "fail";
    }

    public static aoh Je() {
        try {
            String str = (String) com.tencent.mm.kernel.g.Dj().CU().get(67591, null);
            if (str != null) {
                aoh com_tencent_mm_protocal_c_aoh = new aoh();
                String[] split = str.split(",");
                com_tencent_mm_protocal_c_aoh.wcr = Integer.valueOf(split[0]).intValue();
                com_tencent_mm_protocal_c_aoh.wcu = Integer.valueOf(split[1]).intValue();
                com_tencent_mm_protocal_c_aoh.vQu = ((float) Integer.valueOf(split[2]).intValue()) / 1000000.0f;
                com_tencent_mm_protocal_c_aoh.vQt = ((float) Integer.valueOf(split[3]).intValue()) / 1000000.0f;
                x.i("MicroMsg.WebSearch.WebSearchApiLogic", "lbs location is not null, %f, %f", new Object[]{Float.valueOf(com_tencent_mm_protocal_c_aoh.vQu), Float.valueOf(com_tencent_mm_protocal_c_aoh.vQt)});
                return com_tencent_mm_protocal_c_aoh;
            }
            x.i("MicroMsg.WebSearch.WebSearchApiLogic", "lbs location is null, lbsContent is null!");
            return null;
        } catch (Exception e) {
            x.i("MicroMsg.WebSearch.WebSearchApiLogic", "lbs location is null, reason %s", new Object[]{e.getMessage()});
            return null;
        }
    }
}
