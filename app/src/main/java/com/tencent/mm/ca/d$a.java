package com.tencent.mm.ca;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class d$a {
    String className;
    int fJn;
    String savePath;
    int xDl;
    int xDm;

    public d$a(String str, int i, int i2, int i3) {
        this.className = str;
        this.fJn = i;
        this.xDl = i2;
        this.xDm = i3;
        StringBuilder stringBuilder = new StringBuilder();
        if (bh.ov(str)) {
            stringBuilder.append(d.xDf).append("WEIXIN_").append(System.currentTimeMillis()).append(".trace");
        } else {
            StringBuilder append = stringBuilder.append(d.xDf).append(str).append("_");
            String str2 = "";
            switch (i) {
                case 1:
                    str2 = "onResume";
                    break;
                case 2:
                    str2 = "onPause";
                    break;
                case 3:
                    str2 = "onCreate";
                    break;
                case 4:
                    str2 = "onScrool";
                    break;
                case 5:
                    str2 = "all";
                    break;
            }
            append.append(str2).append(".trace");
        }
        x.i("MicroMsg.TraceDebugManager", "TRACE startMethod path %s traceSize : %d", new Object[]{stringBuilder.toString(), Integer.valueOf(i2)});
        this.savePath = stringBuilder.toString();
    }
}
