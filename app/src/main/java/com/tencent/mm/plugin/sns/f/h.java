package com.tencent.mm.plugin.sns.f;

import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class h {
    public boolean frp = true;
    public String nQA = "";
    public String qZP = "";
    public String qZQ = "";
    public String raE = "";
    public int[] raF;
    public int rar = 0;
    public List<a> ras = new ArrayList();

    public final boolean bwp() {
        return this.frp && this.ras != null && this.ras.size() > 0;
    }

    public final boolean d(String str, String str2, Map<String, String> map) {
        this.qZQ = str;
        this.qZP = str2;
        if (map != null) {
            try {
                this.ras.clear();
                this.nQA = bh.az((String) map.get(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE), "");
                this.raE = bh.az((String) map.get("first_step_order"), "");
                String[] split = this.raE.split("\\|");
                this.raF = new int[split.length];
                if (this.raF.length == 0) {
                    this.frp = false;
                }
                int i = 0;
                while (i < split.length) {
                    this.raF[i] = bh.VI(split[i]);
                    if (this.raF[i] <= 0 || this.raF[i] > 3) {
                        this.frp = false;
                    }
                    i++;
                }
                int VI = bh.VI((String) map.get("wording_count"));
                int VI2 = bh.VI((String) map.get("expertype"));
                for (int i2 = 0; i2 < VI; i2++) {
                    a aVar = new a();
                    aVar.qZi = bh.VI((String) map.get(String.format("wording_%d_id", new Object[]{Integer.valueOf(i2 + 1)})));
                    aVar.qZj = bh.az((String) map.get(String.format("wording_%d_zh_CN", new Object[]{Integer.valueOf(i2 + 1)})), "");
                    aVar.qZk = bh.az((String) map.get(String.format("wording_%d_zh_TW", new Object[]{Integer.valueOf(i2 + 1)})), "");
                    aVar.qZl = bh.az((String) map.get(String.format("wording_%d_en", new Object[]{Integer.valueOf(i2 + 1)})), "");
                    aVar.qZm = bh.VI((String) map.get(String.format("wording_%d_action_type", new Object[]{Integer.valueOf(i2 + 1)})));
                    this.ras.add(aVar);
                }
                x.i("MicroMsg.SnsAdAbTestInfo", "expertType " + VI2 + " " + str + " " + this.raE);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SnsAdAbTestInfo", e, "feed xml error ", new Object[0]);
            }
        }
        return false;
    }
}
