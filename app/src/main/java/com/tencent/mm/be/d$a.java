package com.tencent.mm.be;

import com.tencent.mm.a.e;
import com.tencent.mm.az.n;
import com.tencent.mm.az.r;
import com.tencent.mm.g.b.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class d$a {
    public int fWf = 0;
    public String hPe = "BeiJing;GuangZhou;ShangHai;";
    public int hPf = 0;
    public int hPg = 2;
    public int hPh = 2;
    public int hPi = 2;
    public int hPj = 10240;
    public int hPk = 10240000;
    public int hPl = 100;
    public int hPm = 100;
    public int hPn = 100;
    public Random hPo = new Random();
    public List<String> hPp = null;

    public final boolean SH() {
        af Gy = q.Gy();
        x.d("upload", new StringBuilder("  getRegionCode ").append(Gy).toString() != null ? Gy.fWv : "");
        String str = Gy.fWv;
        if (str == null || str.length() <= 0 || this.hPp == null || this.hPp.size() <= 0) {
            return false;
        }
        String[] split = str.split("_");
        if (split == null || split.length <= 0) {
            return false;
        }
        int i = 0;
        while (i < split.length) {
            if (split[i] != null && split[i].length() > 0) {
                for (String str2 : this.hPp) {
                    if (str2.trim().toLowerCase().equals(split[i].trim().toLowerCase())) {
                        x.d("upload", "isInRegion");
                        return true;
                    }
                }
                continue;
            }
            i++;
        }
        return false;
    }

    public final int SI() {
        switch (d.chatType) {
            case 0:
                return this.hPg;
            case 1:
                return this.hPh;
            case 2:
                return this.hPi;
            default:
                return this.hPg;
        }
    }

    public final int SJ() {
        switch (d.chatType) {
            case 0:
                return this.hPl;
            case 1:
                return this.hPm;
            case 2:
                return this.hPn;
            default:
                return this.hPl;
        }
    }

    public static d$a SK() {
        x.d("upload", "parseFromFile");
        String str = n.QE() + r.QH().bg(1, 9);
        int bN = e.bN(str);
        if (bN == -1) {
            x.e("upload", "read file failed " + bN + str);
            return null;
        }
        byte[] d = e.d(str, 0, bN);
        if (d == null) {
            x.e("upload", "read file failed " + bN + str);
            return null;
        }
        str = new String(d);
        if (bh.ov(str)) {
            return null;
        }
        String substring;
        bN = str.indexOf(60);
        if (bN > 0) {
            substring = str.substring(bN);
        } else {
            substring = str;
        }
        int hashCode = substring.hashCode();
        d$a com_tencent_mm_be_d_a = (d$a) d.SG().get(Integer.valueOf(hashCode));
        if (com_tencent_mm_be_d_a != null) {
            return com_tencent_mm_be_d_a;
        }
        Map y = bi.y(substring, "Config");
        if (y == null) {
            x.e("upload", "parse msg failed");
            return null;
        }
        try {
            d$a com_tencent_mm_be_d_a2 = new d$a();
            int i = 0;
            while (true) {
                str = (String) y.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i)) + ".$key");
                x.d("upload", "key " + str);
                if (str != null) {
                    if (str.equals("region")) {
                        com_tencent_mm_be_d_a2.hPe = (String) y.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i)));
                        if (com_tencent_mm_be_d_a2.hPe != null && com_tencent_mm_be_d_a2.hPe.length() > 0) {
                            String[] split = com_tencent_mm_be_d_a2.hPe.split(";");
                            com_tencent_mm_be_d_a2.hPp = new ArrayList();
                            if (split != null && split.length > 0) {
                                int i2 = 0;
                                while (i2 < split.length) {
                                    if (split[i2] != null && split[i2].length() > 0) {
                                        com_tencent_mm_be_d_a2.hPp.add(split[i2]);
                                    }
                                    i2++;
                                }
                            }
                        }
                    } else if (str.equals("sex")) {
                        r7 = new StringBuilder(".Config.Item");
                        if (i == 0) {
                            r0 = "";
                        } else {
                            r0 = Integer.valueOf(i);
                        }
                        com_tencent_mm_be_d_a2.fWf = bh.getInt((String) y.get(r7.append(r0).toString()), 0);
                    } else if (str.equals("rate")) {
                        r7 = new StringBuilder(".Config.Item");
                        if (i == 0) {
                            r0 = "";
                        } else {
                            r0 = Integer.valueOf(i);
                        }
                        com_tencent_mm_be_d_a2.hPf = bh.getInt((String) y.get(r7.append(r0).toString()), 0);
                    } else if (str.equals("minsize")) {
                        com_tencent_mm_be_d_a2.hPj = bh.getInt((String) y.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                    } else if (str.equals("maxsize")) {
                        com_tencent_mm_be_d_a2.hPk = bh.getInt((String) y.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                    } else if (str.equals("daycount_single")) {
                        com_tencent_mm_be_d_a2.hPl = bh.getInt((String) y.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                    } else if (str.equals("daycount_chatroom")) {
                        com_tencent_mm_be_d_a2.hPm = bh.getInt((String) y.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                    } else if (str.equals("daycount_app")) {
                        com_tencent_mm_be_d_a2.hPn = bh.getInt((String) y.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                    } else if (str.equals("rate_single")) {
                        com_tencent_mm_be_d_a2.hPg = bh.getInt((String) y.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                    } else if (str.equals("rate_chatroom")) {
                        com_tencent_mm_be_d_a2.hPh = bh.getInt((String) y.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                    } else if (str.equals("rate_app")) {
                        com_tencent_mm_be_d_a2.hPi = bh.getInt((String) y.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                    }
                    i++;
                } else {
                    x.d("upload", "sex " + com_tencent_mm_be_d_a2.fWf);
                    x.d("upload", "rate_single " + com_tencent_mm_be_d_a2.hPg);
                    x.d("upload", "rate_chatroom " + com_tencent_mm_be_d_a2.hPh);
                    x.d("upload", "rate_app " + com_tencent_mm_be_d_a2.hPi);
                    x.d("upload", "rate " + com_tencent_mm_be_d_a2.hPf);
                    x.d("upload", "minsize " + com_tencent_mm_be_d_a2.hPj);
                    x.d("upload", "maxsize " + com_tencent_mm_be_d_a2.hPk);
                    x.d("upload", "daycount_single " + com_tencent_mm_be_d_a2.hPl);
                    x.d("upload", "daycount_chatroom " + com_tencent_mm_be_d_a2.hPm);
                    x.d("upload", "daycount_app " + com_tencent_mm_be_d_a2.hPn);
                    x.d("upload", "region " + com_tencent_mm_be_d_a2.hPe);
                    d.SG().l(Integer.valueOf(hashCode), com_tencent_mm_be_d_a2);
                    return com_tencent_mm_be_d_a2;
                }
            }
        } catch (Throwable e) {
            x.e("upload", "exception:%s", new Object[]{bh.i(e)});
            return null;
        }
    }
}
