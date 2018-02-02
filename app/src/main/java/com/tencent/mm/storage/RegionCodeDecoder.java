package com.tencent.mm.storage;

import com.tencent.mm.a.g;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public final class RegionCodeDecoder {
    private static RegionCodeDecoder xzQ = null;
    public static final String xzR = (e.gZJ + "MicroMsg/regioncode/");
    public String xzS = "";
    private String xzT = "";

    private static class DecoderJni {
        public static native void buildFromFile(String str);

        public static native Region[] getCities(String str, String str2, String str3);

        public static native Region[] getCountries(String str);

        public static native String getLocName(String str);

        public static native Region[] getProvinces(String str, String str2);

        public static native void release();

        private DecoderJni() {
        }
    }

    public static class Region {
        private String code;
        private String countryCode;
        private boolean hasChildren = false;
        private boolean isCity = false;
        private boolean isCountry = false;
        private boolean isProvince = false;
        private String name;
        private Region parent = null;

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String getCode() {
            return this.code;
        }

        public void setCode(String str) {
            this.code = str;
        }

        public boolean hasChildren() {
            return this.hasChildren;
        }

        public void setHasChildren(boolean z) {
            this.hasChildren = z;
        }

        public void setParent(Region region) {
            this.parent = region;
        }

        public Region getParent() {
            return this.parent;
        }

        public void setCountryCode(String str) {
            this.countryCode = str;
        }

        public String getCountryCode() {
            return this.countryCode;
        }

        public boolean isCountry() {
            return this.isCountry;
        }

        public void setCountry(boolean z) {
            this.isCountry = z;
        }

        public boolean isProvince() {
            return this.isProvince;
        }

        public void setProvince(boolean z) {
            this.isProvince = z;
        }

        public boolean isCity() {
            return this.isCity;
        }

        public void setCity(boolean z) {
            this.isCity = z;
        }
    }

    public static RegionCodeDecoder cjP() {
        if (xzQ == null) {
            xzQ = new RegionCodeDecoder();
        }
        RegionCodeDecoder regionCodeDecoder = xzQ;
        if (!w.cfi().equals(regionCodeDecoder.xzS)) {
            regionCodeDecoder.chP();
        }
        return xzQ;
    }

    public final void chP() {
        File file = new File(xzR);
        if (!file.exists()) {
            file.mkdir();
            I(file);
        }
        String[] list = file.list();
        if (list == null || list.length == 0) {
            I(file);
        }
        this.xzS = w.cfi();
        String cjQ = cjQ();
        if (bh.ov(cjQ)) {
            x.e("MicroMsg.RegionCodeDecoder", "buildMap error, no codeFile found, curLang: " + this.xzS);
            return;
        }
        String str = xzR + cjQ;
        File file2 = new File(str);
        cjQ = G(file2);
        if (bh.ov(cjQ) ? false : cjQ.equals(H(file2))) {
            cjQ = str;
        } else {
            File file3;
            if (k.A(ac.getContext(), "regioncode/" + file2.getName(), str)) {
                cjQ = str;
            } else {
                file3 = new File(file2.getParentFile(), "mmregioncode_en.txt");
                cjQ = file3.getAbsolutePath();
                if (!k.A(ac.getContext(), "regioncode/mmregioncode_en.txt", file3.getAbsolutePath())) {
                    cjQ = null;
                }
            }
            file3 = new File(cjQ);
            f(file3, file3.getParentFile());
            x.w("MicroMsg.RegionCodeDecoder", "Verifying codeFile: %s failed, after fallback, %s will be used.", file2.getName(), file3.getName());
        }
        if (bh.ov(cjQ)) {
            x.e("MicroMsg.RegionCodeDecoder", "buildMap error, no codeFile found after verify, curLang: " + this.xzS);
        } else if (bh.ov(this.xzT) || !this.xzT.equals(str) || !str.equals(cjQ)) {
            x.w("MicroMsg.RegionCodeDecoder", "buildMap, after verify, codeFile %s is used. curLang: %s", new File(cjQ).getName(), this.xzS);
            this.xzT = cjQ;
            DecoderJni.buildFromFile(this.xzT);
        }
    }

    private static String G(File file) {
        Throwable th;
        Throwable th2;
        String str = null;
        File file2 = new File(file.getAbsolutePath() + ".hash");
        if (file2.exists()) {
            BufferedReader bufferedReader;
            try {
                bufferedReader = new BufferedReader(new FileReader(file2));
                try {
                    str = bufferedReader.readLine();
                    try {
                        bufferedReader.close();
                    } catch (Throwable th3) {
                    }
                } catch (Throwable th4) {
                    th = th4;
                    try {
                        x.printErrStackTrace("MicroMsg.RegionCodeDecoder", th, "Failed to read saved hash from hash file: %s", file2.getName());
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable th5) {
                            }
                        }
                        return str;
                    } catch (Throwable th6) {
                        th2 = th6;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable th7) {
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th8) {
                bufferedReader = str;
                th2 = th8;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th2;
            }
        }
        return str;
    }

    public static void f(File file, File file2) {
        PrintWriter printWriter;
        Throwable th;
        x.i("MicroMsg.RegionCodeDecoder", "Generating hash file for: %s", file.getName());
        File file3 = new File(file2, file.getName() + ".hash");
        String H = H(file);
        if (!bh.ov(H)) {
            if (!file3.exists()) {
                file3.getParentFile().mkdirs();
            }
            try {
                printWriter = new PrintWriter(file3);
                try {
                    printWriter.print(H);
                    try {
                        printWriter.close();
                    } catch (Throwable th2) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        x.printErrStackTrace("MicroMsg.RegionCodeDecoder", th, "Failed to save hash file of %s", file.getName());
                        if (printWriter != null) {
                            try {
                                printWriter.close();
                            } catch (Throwable th4) {
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        if (printWriter != null) {
                            try {
                                printWriter.close();
                            } catch (Throwable th6) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                printWriter = null;
                if (printWriter != null) {
                    printWriter.close();
                }
                throw th;
            }
        }
    }

    private static String H(File file) {
        String i = g.i(file);
        if (!bh.ov(i)) {
            return ab.UZ(i + "#" + file.lastModified() + "#" + q.yE());
        }
        x.e("MicroMsg.RegionCodeDecoder", "Failed to calculate hash for file %s", file.getName());
        return null;
    }

    private synchronized void I(File file) {
        synchronized (this) {
            String[] strArr = null;
            if (file.exists()) {
                strArr = file.list();
            }
            if (!file.exists() || r1 == null || r1.length == 0) {
                try {
                    for (String str : ac.getContext().getAssets().list("regioncode")) {
                        x.i("MicroMsg.RegionCodeDecoder", "from:%s,  to:%s", "regioncode/" + str, file.getPath() + "/" + str);
                        String str2 = file.getPath() + "/" + str;
                        k.A(ac.getContext(), "regioncode/" + str, str2);
                        f(new File(str2), file);
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.RegionCodeDecoder", e, "", new Object[0]);
                }
            }
        }
    }

    public final String cjQ() {
        String str = "mmregioncode_" + (this.xzS.equalsIgnoreCase("zh_HK") ? "zh_TW" : this.xzS) + ".txt";
        String str2 = "mmregioncode_en.txt";
        File file = new File(xzR);
        if (file.exists()) {
            String[] list = file.list();
            if (list == null || list.length == 0) {
                return null;
            }
            Object obj = null;
            for (String str3 : list) {
                if (str3.equals(str)) {
                    return str3;
                }
                if (obj == null && str3.equals(str2)) {
                    obj = 1;
                }
            }
            return obj != null ? str2 : null;
        } else {
            file.mkdir();
            return null;
        }
    }

    public static final String ah(String str, String str2, String str3) {
        StringBuffer stringBuffer = new StringBuffer();
        if (!bh.ov(str)) {
            stringBuffer.append(str);
            if (!bh.ov(str2)) {
                stringBuffer.append('_');
                stringBuffer.append(str2);
                if (!bh.ov(str3)) {
                    stringBuffer.append('_');
                    stringBuffer.append(str3);
                }
            }
        }
        return stringBuffer.toString();
    }

    public static String XD(String str) {
        if (bh.ov(str) || !w.UW(str)) {
            x.e("MicroMsg.RegionCodeDecoder", "unsupported language:" + str);
            return null;
        }
        if (str.equalsIgnoreCase("zh_HK")) {
            str = "zh_TW";
        }
        return xzR + "mmregioncode_" + str + ".txt";
    }

    public static final boolean XE(String str) {
        if (bh.ov(str)) {
            return false;
        }
        return str.equalsIgnoreCase("cn");
    }

    public static String getLocName(String str) {
        if (bh.ov(str)) {
            return null;
        }
        return DecoderJni.getLocName(str);
    }

    public final String XF(String str) {
        String locName = getLocName(str);
        return bh.ov(locName) ? bh.ou(str) : locName;
    }

    public final String fE(String str, String str2) {
        String str3 = null;
        if (!(bh.ov(str) || bh.ov(str2))) {
            str3 = getLocName(ah(str, str2, null));
        }
        return bh.ov(str3) ? bh.ou(str2) : str3;
    }

    public final String ai(String str, String str2, String str3) {
        String locName = (bh.ov(str) || bh.ov(str2) || bh.ov(str3)) ? null : getLocName(ah(str, str2, str3));
        return bh.ov(locName) ? bh.ou(str3) : locName;
    }

    public final Region[] cjR() {
        if (bh.ov(this.xzT)) {
            return null;
        }
        return DecoderJni.getCountries(this.xzT);
    }

    public final Region[] XG(String str) {
        if (bh.ov(this.xzT) || bh.ov(str)) {
            return null;
        }
        return DecoderJni.getProvinces(this.xzT, str);
    }

    public final Region[] fF(String str, String str2) {
        if (bh.ov(this.xzT) || bh.ov(str) || bh.ov(str2)) {
            return null;
        }
        return DecoderJni.getCities(this.xzT, str, str2);
    }
}
