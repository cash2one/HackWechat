package com.tencent.mm.z;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.a.e;
import com.tencent.mm.a.o;
import com.tencent.mm.ay.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.l.a;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.w;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

public final class q {
    public static boolean gr(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        String FS = FS();
        if (FS != null && FS.length() > 0) {
            return FS.equals(str);
        }
        x.e("MicroMsg.ConfigStorageLogic", "get userinfo fail");
        return false;
    }

    public static int FR() {
        g.Dk();
        Integer num = (Integer) g.Dj().CU().get(9, null);
        return num == null ? 0 : num.intValue();
    }

    public static String getUserBindEmail() {
        g.Dk();
        return bh.ou((String) g.Dj().CU().get(5, null));
    }

    public static String FS() {
        g.Dk();
        return (String) g.Dj().CU().get(2, null);
    }

    public static String FT() {
        g.Dk();
        return (String) g.Dj().CU().get(42, null);
    }

    public static String FU() {
        g.Dk();
        return (String) g.Dj().CU().get(4, null);
    }

    public static String FV() {
        String FT = FT();
        return !bh.ov(FT) ? FT : FS();
    }

    public static int FW() {
        g.Dk();
        Integer num = (Integer) g.Dj().CU().get(7, null);
        return num == null ? 0 : num.intValue();
    }

    public static long FX() {
        g.Dk();
        Long l = (Long) g.Dj().CU().get(147457, null);
        return l == null ? 0 : l.longValue();
    }

    public static int FY() {
        g.Dk();
        Integer num = (Integer) g.Dj().CU().get(40, null);
        return num == null ? 0 : num.intValue();
    }

    public static int FZ() {
        g.Dk();
        Integer num = (Integer) g.Dj().CU().get(339975, null);
        return num == null ? 0 : num.intValue();
    }

    public static boolean gL(int i) {
        return (i & 8192) != 0;
    }

    public static boolean Ga() {
        return (FY() & 16384) != 0;
    }

    public static boolean Gb() {
        return (FY() & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0;
    }

    public static void Gc() {
        int FY = FY() | WXMediaMessage.THUMB_LENGTH_LIMIT;
        g.Dk();
        g.Dj().CU().set(40, Integer.valueOf(FY));
    }

    public static int Gd() {
        g.Dk();
        Integer num = (Integer) g.Dj().CU().get(34, null);
        return num == null ? 0 : num.intValue();
    }

    public static boolean Ge() {
        boolean z;
        if ((FW() & 262144) != 0) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.ConfigStorageLogic", "isGooglePay: %s  User Status: %d", Boolean.valueOf(z), Integer.valueOf(FW()));
        return z;
    }

    public static boolean Gf() {
        g.Dk();
        g.Dj().CU().lH(true);
        if (FZ() == 1) {
            return true;
        }
        return false;
    }

    public static boolean Gg() {
        g.Dk();
        g.Dj().CU().lH(true);
        if (FZ() == 2) {
            return true;
        }
        return false;
    }

    public static boolean Gh() {
        g.Dk();
        g.Dj().CU().lH(true);
        if (FZ() == 4) {
            return true;
        }
        return false;
    }

    public static boolean Gi() {
        return (Gd() & 32) == 0;
    }

    public static boolean Gj() {
        return (FW() & Downloads.RECV_BUFFER_SIZE) != 0;
    }

    public static boolean Gk() {
        bc EY = ((h) g.h(h.class)).Fg().EY("@t.qq.com");
        return EY != null && EY.isEnable();
    }

    public static boolean Gl() {
        return (Gd() & 2) == 0;
    }

    public static boolean Gm() {
        return (Gd() & 16) == 0;
    }

    public static boolean Gn() {
        return (Gd() & FileUtils.S_IWUSR) == 0;
    }

    public static boolean Go() {
        g.Dk();
        return bh.c((Boolean) g.Dj().CU().get(8200, null));
    }

    public static boolean Gp() {
        return (Gd() & SQLiteGlobal.journalSizeLimit) == 0;
    }

    public static boolean Gq() {
        return (Gd() & 262144) == 0;
    }

    public static boolean Gr() {
        return (Gd() & 8192) == 0;
    }

    public static boolean Gs() {
        return (Gd() & 65536) == 0;
    }

    public static boolean Gt() {
        g.Dk();
        String str = (String) g.Dj().CU().get(65825, null);
        if (bh.ov(str)) {
            return false;
        }
        if (str.equals("0")) {
            return false;
        }
        try {
            if (bh.c(Long.valueOf(bh.getLong(str, 0))) == 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean Gu() {
        return (Gd() & 1) == 0;
    }

    public static boolean Gv() {
        return (FW() & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0;
    }

    public static int Gw() {
        g.Dk();
        return bh.a((Integer) g.Dj().CU().get(8201, null), 22);
    }

    public static int Gx() {
        g.Dk();
        return bh.a((Integer) g.Dj().CU().get(8208, null), 8);
    }

    public static com.tencent.mm.storage.x Gy() {
        a WO = ((h) g.h(h.class)).EY().WO(FS());
        if (WO != null && ((int) WO.gJd) > 0) {
            return WO;
        }
        com.tencent.mm.storage.x xVar = new com.tencent.mm.storage.x();
        g.Dk();
        String str = (String) g.Dj().CU().get(2, null);
        g.Dk();
        String str2 = (String) g.Dj().CU().get(4, null);
        xVar.setUsername(str);
        xVar.dc(str2);
        ((h) g.h(h.class)).EY().R(xVar);
        return ((h) g.h(h.class)).EY().WO(str);
    }

    public static b q(int i, String str) {
        b mVar;
        switch (i) {
            case 2:
                mVar = new m(str, 1);
                break;
            case 18:
                mVar = new m(str, 2);
                break;
            default:
                mVar = null;
                break;
        }
        ((h) g.h(h.class)).EX().b(mVar);
        return mVar;
    }

    public static boolean Gz() {
        g.Dk();
        return new o(bh.e((Integer) g.Dj().CU().get(9, null))).longValue() != 0;
    }

    public static boolean a(String str, String str2, boolean z) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.ConfigStorageLogic", "canSendRawImage, invalid argument");
            return false;
        } else if (str2 != null && str2.length() > 0 && (com.tencent.mm.storage.x.Wx(str2) || com.tencent.mm.storage.x.Wz(str2))) {
            return false;
        } else {
            boolean z2;
            double d;
            double d2;
            Options options = new Options();
            if (str == null || str.length() == 0) {
                x.e("MicroMsg.ConfigStorageLogic", "isSmallImg, invalid argument");
            } else {
                if (e.bN(str) < 65536) {
                    z2 = true;
                } else {
                    options.inJustDecodeBounds = true;
                    MMBitmapFactory.decodeFile(str, options, null, 0, new int[0]);
                    d = (double) options.outWidth;
                    double d3 = (double) options.outHeight;
                    if (d < 100.0d && d3 < 100.0d) {
                        x.i("MicroMsg.ConfigStorageLogic", "isSmallImg : true, width = " + d + ", height = " + d3);
                        z2 = true;
                    }
                }
                if (z2) {
                    d = (double) options.outWidth;
                    d2 = (double) options.outHeight;
                    if (d / d2 < 2.5d || d2 / d >= 2.5d) {
                        if (e.bN(str) >= 26214400) {
                            x.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : true, width height ratio > %s, imgSize:[%s]", Double.valueOf(2.5d), Integer.valueOf(e.bN(str)));
                            return true;
                        }
                        x.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : false, width height ratio > %s, imgSize:[%s]", Double.valueOf(2.5d), Integer.valueOf(e.bN(str)));
                        return false;
                    } else if (z) {
                        return false;
                    } else {
                        return true;
                    }
                }
                x.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : true. isSmallImg");
                return true;
            }
            z2 = false;
            if (z2) {
                d = (double) options.outWidth;
                d2 = (double) options.outHeight;
                if (d / d2 < 2.5d) {
                }
                if (e.bN(str) >= 26214400) {
                    x.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : false, width height ratio > %s, imgSize:[%s]", Double.valueOf(2.5d), Integer.valueOf(e.bN(str)));
                    return false;
                }
                x.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : true, width height ratio > %s, imgSize:[%s]", Double.valueOf(2.5d), Integer.valueOf(e.bN(str)));
                return true;
            }
            x.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : true. isSmallImg");
            return true;
        }
    }

    public static void a(int i, Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            stringBuilder.append(String.format(Locale.US, "%s\n%s\n", new Object[]{entry.getKey(), entry.getValue()}));
        }
        g.Dk();
        if (g.Dj() != null) {
            g.Dk();
            if (g.Dj().CU() != null) {
                g.Dk();
                g.Dj().CU().set(327682, stringBuilder.toString());
            }
        }
    }

    public static void b(int i, Map<String, String> map) {
        map.clear();
        g.Dk();
        if (g.Dj() != null) {
            g.Dk();
            if (g.Dj().CU() != null) {
                g.Dk();
                String str = (String) g.Dj().CU().get(327682, null);
                if (str != null) {
                    String[] split = str.split("\n");
                    if (split.length % 2 != 0) {
                        x.e("MicroMsg.ConfigStorageLogic", "key and value not match, len: " + String.valueOf(split.length));
                        return;
                    }
                    for (int i2 = 0; i2 < split.length; i2 += 2) {
                        map.put(split[i2], split[i2 + 1]);
                    }
                    return;
                }
                return;
            }
        }
        x.d("MicroMsg.ConfigStorageLogic", "acc stg is null");
    }

    public static Boolean GA() {
        if (g.Dh().Cy()) {
            g.Dk();
            String str = (String) g.Dj().CU().get(6, null);
            g.Dk();
            if (!Boolean.valueOf(bh.c((Boolean) g.Dj().CU().get(340241, null))).booleanValue() || bh.ov(str)) {
                return Boolean.valueOf(false);
            }
            String str2 = "86";
            if (str.startsWith("+")) {
                str = ao.De(str);
            } else {
                str = str2;
            }
            if (str == "86") {
                return Boolean.valueOf(false);
            }
            return Boolean.valueOf(true);
        }
        x.e("MicroMsg.ConfigStorageLogic", "mmcore has not ready");
        return Boolean.valueOf(false);
    }

    public static Map<String, String> GB() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("login_weixin_username", FS());
        g.Dk();
        hashMap.put("login_user_name", (String) g.Dj().CU().get(w.a.USERINFO_LAST_LOGIN_USERNAME_STRING, null));
        g.Dk();
        hashMap.put("last_avatar_path", (String) g.Dj().CU().get(w.a.USERINFO_LAST_LOGIN_AVATAR_PATH_STRING, null));
        g.Dk();
        hashMap.put("last_login_bind_mobile", (String) g.Dj().CU().get(6, null));
        g.Dk();
        hashMap.put("last_login_bind_email", (String) g.Dj().CU().get(5, null));
        g.Dk();
        hashMap.put("last_login_bind_qq", String.valueOf(g.Dj().CU().get(9, null)));
        g.Dk();
        hashMap.put("last_login_use_voice", String.valueOf(g.Dj().CU().get(40, null)));
        return hashMap;
    }
}
