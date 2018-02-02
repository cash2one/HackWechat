package com.tencent.mm.plugin.wallet_core.model.mall;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class c {
    private static c sQK = null;
    public Map<String, MallNews> sQL = new HashMap();

    public static c bMe() {
        if (sQK == null) {
            sQK = new c();
        }
        return sQK;
    }

    private c() {
        WT();
    }

    public final void WT() {
        this.sQL.clear();
        g.Dk();
        String str = (String) g.Dj().CU().get(270339, "");
        x.d("MicroMsg.MallNewsManager", "data : " + str);
        for (String str2 : bh.F(str2.split(";"))) {
            MallNews Nc = Nc(str2);
            if (Nc != null) {
                this.sQL.put(Nc.sQB, Nc);
            }
        }
    }

    public final List<String> bMf() {
        List<String> arrayList = new ArrayList();
        for (MallNews mallNews : this.sQL.values()) {
            if (!bh.ov(mallNews.frP)) {
                arrayList.add(mallNews.frP);
            }
        }
        x.d("MicroMsg.MallNewsManager", "tickets.size : " + arrayList.size());
        return arrayList;
    }

    public static boolean a(MallNews mallNews) {
        g.Dk();
        List F = bh.F(((String) g.Dj().CU().get(a.xtL, "")).split(","));
        x.i("MicroMsg.MallNewsManager", "tryCheckOutOfDateRedDot markedString %s", new Object[]{r0});
        if (mallNews == null) {
            return false;
        }
        if (bh.ov(mallNews.rVK)) {
            return false;
        }
        if (F.contains(mallNews.rVK)) {
            return true;
        }
        return false;
    }

    public static void c(MallFunction mallFunction) {
        try {
            if (!bh.ov(mallFunction.sQt.rVK)) {
                g.Dk();
                List F = bh.F(((String) g.Dj().CU().get(a.xtL, "")).split(","));
                while (F.size() > 20) {
                    F.remove(0);
                }
                if (!F.contains(mallFunction.sQt.rVK)) {
                    F.add(mallFunction.sQt.rVK);
                    x.i("MicroMsg.MallNewsManager", "doSelectFunction %s, markedString %s", new Object[]{mallFunction.sQt.rVK, bh.d(F, ",")});
                    g.Dk();
                    g.Dj().CU().a(a.xtL, r0);
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MallNewsManager", e, "error in markedFunction", new Object[0]);
        }
    }

    public static void MZ(String str) {
        if (!bh.ov(str)) {
            Map y = bi.y(str, "sysmsg");
            if (y != null) {
                int i = bh.getInt((String) y.get(".sysmsg.paymsg.PayMsgType"), -1);
                String str2;
                int i2;
                if (i == 31) {
                    str2 = (String) y.get(".sysmsg.paymsg.WalletRedDotWording");
                    i2 = bh.getInt((String) y.get(".sysmsg.paymsg.WalletRedDot"), -1);
                    x.i("MicroMsg.MallNewsManager", "walletEntryWording: %s, balanceRedDot: %s, lqtRedDot: %s", new Object[]{str2, Integer.valueOf(bh.getInt((String) y.get(".sysmsg.paymsg.BalanceRedDot"), -1)), Integer.valueOf(bh.getInt((String) y.get(".sysmsg.paymsg.LQTRedDot"), -1))});
                    g.Dk();
                    g.Dj().CU().a(a.xvQ, str2);
                    g.Dk();
                    g.Dj().CU().a(a.xvR, Integer.valueOf(i2));
                    g.Dk();
                    g.Dj().CU().a(a.xvS, Integer.valueOf(r4));
                    g.Dk();
                    g.Dj().CU().a(a.xvT, Integer.valueOf(r1));
                    bMh();
                } else if (i == 34) {
                    Set<String> keySet = y.keySet();
                    x.i("MicroMsg.MallNewsManager", "receive menu ui reddot msg: %s, keys: %s", new Object[]{str, keySet.toString()});
                    if (keySet.size() > 0) {
                        JSONObject jSONObject = new JSONObject();
                        for (String str22 : keySet) {
                            if (str22.startsWith(".sysmsg.paymsg.reddot.item")) {
                                str22 = (String) y.get(str22);
                                if (!bh.ov(str22)) {
                                    x.i("MicroMsg.MallNewsManager", "mall menu ui, %s has reddot", new Object[]{str22});
                                    if ("mainentry_me".equals(str22)) {
                                        com.tencent.mm.s.c.Bq().p(262156, true);
                                    } else if ("entry_wxpay_wallet".equals(str22)) {
                                        com.tencent.mm.s.c.Bq().p(262156, true);
                                    } else if ("entry_wxpay_paycenter".equals(str22)) {
                                        g.Dk();
                                        g.Dj().CU().a(a.xxq, Boolean.valueOf(true));
                                    } else {
                                        try {
                                            jSONObject.put(str22, 1);
                                        } catch (Throwable e) {
                                            x.printErrStackTrace("MicroMsg.MallNewsManager", e, "put redDotConfig json failed: %s", new Object[]{e.getMessage()});
                                        }
                                    }
                                }
                            }
                        }
                        x.i("MicroMsg.MallNewsManager", "redDotConfig: %s", new Object[]{jSONObject.toString()});
                        if (jSONObject.length() > 0) {
                            g.Dk();
                            g.Dj().CU().a(a.xxp, jSONObject.toString());
                            g.Dk();
                            g.Dj().CU().a(a.xxq, Boolean.valueOf(true));
                        }
                    }
                } else if (i == 36) {
                    x.i("MicroMsg.MallNewsManager", "walletEntryWording: %s, walletRedDot: %s, lqbRedDot: %s", new Object[]{(String) y.get(".sysmsg.paymsg.WalletRedDotWording"), Integer.valueOf(bh.getInt((String) y.get(".sysmsg.paymsg.WalletRedDot"), -1)), Integer.valueOf(bh.getInt((String) y.get(".sysmsg.paymsg.LQBRedDot"), -1))});
                    g.Dk();
                    g.Dj().CU().a(a.xvQ, str22);
                    g.Dk();
                    g.Dj().CU().a(a.xvR, Integer.valueOf(i2));
                    g.Dk();
                    g.Dj().CU().a(a.xvU, Integer.valueOf(r1));
                    bMh();
                }
            }
        }
    }

    public static void bMg() {
        g.Dk();
        g.Dj().CU().a(a.xvQ, "");
        g.Dk();
        g.Dj().CU().a(a.xvR, Integer.valueOf(-1));
    }

    public static void bMh() {
        x.d("MicroMsg.MallNewsManager", "clearMallNew ");
        com.tencent.mm.s.c.Bq().aS(262156, 266248);
    }

    public final boolean bjh() {
        x.d("MicroMsg.MallNewsManager", "notifyNewsMap.size : " + this.sQL.size());
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : this.sQL.keySet()) {
            if (!bh.ov(str)) {
                MallNews mallNews = (MallNews) this.sQL.get(str);
                stringBuffer.append(mallNews.sQI.replace("</mallactivity></sysmsg>", "").replaceAll("<showflag>([^<]*)</showflag>", "").replaceAll("<newsTipFlag>([^<]*)</newsTipFlag>", "") + "<showflag>" + mallNews.sQz + "</showflag><newsTipFlag>" + mallNews.sQA + "</newsTipFlag></mallactivity></sysmsg>;");
            }
        }
        x.d("MicroMsg.MallNewsManager", "save data  : " + stringBuffer.toString());
        g.Dk();
        g.Dj().CU().set(270339, stringBuffer.toString());
        return true;
    }

    public final String Na(String str) {
        MallNews mallNews = (MallNews) this.sQL.get(str);
        if (mallNews == null || bh.ov(mallNews.frP)) {
            return null;
        }
        return mallNews.frP;
    }

    public final MallNews Nb(String str) {
        x.d("MicroMsg.MallNewsManager", "removeNewsInIndexUI : " + str);
        if (bh.ov(str) || !this.sQL.containsKey(str)) {
            return null;
        }
        MallNews mallNews = (MallNews) this.sQL.get(str);
        if (!"0".equals(mallNews.sQz)) {
            return mallNews;
        }
        mallNews.sQz = "1";
        bjh();
        return mallNews;
    }

    public static MallNews Nc(String str) {
        if (bh.ov(str)) {
            return null;
        }
        Map y = bi.y(str, "sysmsg");
        if (y == null) {
            return null;
        }
        try {
            MallNews mallNews = new MallNews((String) y.get(".sysmsg.mallactivity.functionid"));
            mallNews.rVK = (String) y.get(".sysmsg.mallactivity.activityid");
            mallNews.frP = (String) y.get(".sysmsg.mallactivity.ticket");
            mallNews.type = (String) y.get(".sysmsg.mallactivity.type");
            mallNews.showType = bh.getInt((String) y.get(".sysmsg.mallactivity.showtype"), 0);
            if (y.containsKey(".sysmsg.mallactivity.showflag")) {
                mallNews.sQz = (String) y.get(".sysmsg.mallactivity.showflag");
            } else {
                mallNews.sQz = "0";
            }
            if (y.containsKey(".sysmsg.mallactivity.newsTipFlag")) {
                mallNews.sQA = (String) y.get(".sysmsg.mallactivity.newsTipFlag");
            } else {
                mallNews.sQA = "0";
            }
            mallNews.sQI = str;
            if (bh.ov(mallNews.sQB)) {
                return null;
            }
            return mallNews;
        } catch (Exception e) {
            x.e("MicroMsg.MallNewsManager", "cmdid error");
            return null;
        }
    }

    public final void S(ArrayList<MallFunction> arrayList) {
        if (arrayList != null) {
            Set<String> hashSet = new HashSet(this.sQL.keySet());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                hashSet.remove(((MallFunction) it.next()).pBK);
            }
            for (String remove : hashSet) {
                this.sQL.remove(remove);
            }
            bjh();
        }
    }
}
