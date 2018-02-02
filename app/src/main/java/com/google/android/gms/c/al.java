package com.google.android.gms.c;

import android.text.TextUtils;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import java.util.HashMap;
import java.util.Map;

public final class al extends af<al> {
    public String aYF;
    public int aYG;
    public int aYH;
    public int aYI;
    public int aYJ;
    public int aYK;

    public final /* synthetic */ void a(af afVar) {
        al alVar = (al) afVar;
        if (this.aYG != 0) {
            alVar.aYG = this.aYG;
        }
        if (this.aYH != 0) {
            alVar.aYH = this.aYH;
        }
        if (this.aYI != 0) {
            alVar.aYI = this.aYI;
        }
        if (this.aYJ != 0) {
            alVar.aYJ = this.aYJ;
        }
        if (this.aYK != 0) {
            alVar.aYK = this.aYK;
        }
        if (!TextUtils.isEmpty(this.aYF)) {
            alVar.aYF = this.aYF;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, this.aYF);
        hashMap.put("screenColors", Integer.valueOf(this.aYG));
        hashMap.put("screenWidth", Integer.valueOf(this.aYH));
        hashMap.put("screenHeight", Integer.valueOf(this.aYI));
        hashMap.put("viewportWidth", Integer.valueOf(this.aYJ));
        hashMap.put("viewportHeight", Integer.valueOf(this.aYK));
        return aj(hashMap);
    }
}
