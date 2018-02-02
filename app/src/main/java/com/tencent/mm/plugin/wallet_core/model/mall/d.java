package com.tencent.mm.plugin.wallet_core.model.mall;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class d {
    private static d sQM = null;
    public Map<String, MallNews> sQL = new HashMap();

    public static d bMi() {
        if (sQM == null) {
            sQM = new d();
        }
        return sQM;
    }

    private d() {
        WT();
    }

    public final void WT() {
        this.sQL.clear();
        g.Dk();
        String str = (String) g.Dj().CU().get(270341, "");
        x.d("MicroMsg.MallNewsManagerNewVersion", "data : " + str);
        for (String str2 : bh.F(str2.split(";"))) {
            MallNews Nc = Nc(str2);
            if (Nc != null) {
                this.sQL.put(Nc.sQB, Nc);
            }
        }
    }

    public final boolean bjh() {
        x.d("MicroMsg.MallNewsManagerNewVersion", "notifyNewsMap.size : " + this.sQL.size());
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : this.sQL.keySet()) {
            if (!bh.ov(str)) {
                MallNews mallNews = (MallNews) this.sQL.get(str);
                stringBuffer.append(mallNews.sQI.replace("</mallactivitynew></sysmsg>;", "").replaceAll("<activityid>([^<]*)</activityid>", "").replaceAll("<type>([^<]*)</type>", "").replaceAll("<showflag>([^<]*)</showflag>", "").replaceAll("<newsTipFlag>([^<]*)</newsTipFlag>", "") + "<activityid>" + mallNews.rVK + "</activityid><type>" + mallNews.type + "</type><showflag>" + mallNews.sQz + "</showflag><newsTipFlag>" + mallNews.sQA + "</newsTipFlag></mallactivitynew></sysmsg>;");
            }
        }
        x.d("MicroMsg.MallNewsManagerNewVersion", "save data  : " + stringBuffer.toString());
        g.Dk();
        g.Dj().CU().set(270341, stringBuffer.toString());
        return true;
    }

    public final MallNews Nd(String str) {
        return (MallNews) this.sQL.get(str);
    }

    public final MallNews Nb(String str) {
        x.d("MicroMsg.MallNewsManagerNewVersion", "removeNewsInIndexUI : " + str);
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

    private static MallNews Nc(String str) {
        if (bh.ov(str)) {
            return null;
        }
        Map y = bi.y(str, "sysmsg");
        if (y == null) {
            return null;
        }
        try {
            MallNews mallNews = new MallNews((String) y.get(".sysmsg.mallactivitynew.functionid"));
            mallNews.rVK = (String) y.get(".sysmsg.mallactivitynew.activityid");
            mallNews.type = (String) y.get(".sysmsg.mallactivitynew.type");
            mallNews.showType = bh.getInt((String) y.get(".sysmsg.mallactivitynew.showtype"), 0);
            if (y.containsKey(".sysmsg.mallactivitynew.showflag")) {
                mallNews.sQz = (String) y.get(".sysmsg.mallactivitynew.showflag");
            } else {
                mallNews.sQz = "0";
            }
            if (y.containsKey(".sysmsg.mallactivitynew.newsTipFlag")) {
                mallNews.sQA = (String) y.get(".sysmsg.mallactivitynew.newsTipFlag");
            } else {
                mallNews.sQA = "0";
            }
            mallNews.sQI = str;
            if (bh.ov(mallNews.sQB)) {
                return null;
            }
            return mallNews;
        } catch (Exception e) {
            x.e("MicroMsg.MallNewsManagerNewVersion", "cmdid error");
            return null;
        }
    }
}
