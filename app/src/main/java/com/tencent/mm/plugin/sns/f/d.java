package com.tencent.mm.plugin.sns.f;

import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class d {
    public boolean frp = true;
    public String nQA = "";
    public String qZP = "";
    public String qZQ = "";
    public int rar = 0;
    public List<b> ras = new ArrayList();

    static class b {
        public List<a> iPw = new ArrayList();
        public int raw;
        public int showType;
        public String title;

        b() {
        }
    }

    public final boolean d(String str, String str2, Map<String, String> map) {
        this.qZQ = str;
        this.qZP = str2;
        if (map != null) {
            try {
                this.ras.clear();
                this.nQA = bh.az((String) map.get(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE), "");
                if (!this.nQA.equals("zh_cn")) {
                    this.frp = false;
                }
                int VI = bh.VI((String) map.get("tipcount"));
                int VI2 = bh.VI((String) map.get("expertype"));
                for (int i = 0; i < VI; i++) {
                    b bVar = new b();
                    bVar.title = bh.az((String) map.get(String.format("tip_%d_basetextformat", new Object[]{Integer.valueOf(i)})), "");
                    bVar.raw = bh.VI((String) map.get(String.format("tip_%d_id", new Object[]{Integer.valueOf(i)})));
                    bVar.showType = bh.VI((String) map.get(String.format("tip_%d_showtype", new Object[]{Integer.valueOf(i)})));
                    int VI3 = bh.VI((String) map.get(String.format("tip_%d_button_count", new Object[]{Integer.valueOf(i)})));
                    if (bVar.showType >= 6) {
                        this.frp = false;
                    }
                    for (int i2 = 0; i2 < VI3; i2++) {
                        a aVar = new a();
                        aVar.index = bh.VI((String) map.get(String.format("tip_%d_button_%d_index", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})));
                        aVar.actionType = bh.VI((String) map.get(String.format("tip_%d_button_%d_actiontype", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})));
                        aVar.rat = bh.az((String) map.get(String.format("tip_%d_button_%d_basetextformat", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})), "");
                        aVar.jumpUrl = bh.az((String) map.get(String.format("tip_%d_button_%d_jumpurl", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})), "");
                        aVar.rau = bh.az((String) map.get(String.format("tip_%d_button_%d_priortextformat", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})), "");
                        aVar.rav = bh.VI((String) map.get(String.format("tip_%d_button_%d_nexttipviewid", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)})));
                        if (aVar.actionType >= 9) {
                            this.frp = false;
                        }
                        bVar.iPw.add(aVar);
                    }
                    this.ras.add(bVar);
                }
                x.i("Micromsg.SnsABTestInfo", "expertType " + VI2 + " " + str);
            } catch (Throwable e) {
                x.printErrStackTrace("Micromsg.SnsABTestInfo", e, "feed xml error ", new Object[0]);
            }
        }
        return false;
    }
}
