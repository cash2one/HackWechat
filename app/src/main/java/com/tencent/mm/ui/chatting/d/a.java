package com.tencent.mm.ui.chatting.d;

import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.util.Map;

public final class a extends com.tencent.mm.ax.a {
    public String yGX;
    public long yGY = 0;

    public a(Map<String, String> map, au auVar) {
        super(map, auVar);
    }

    protected final boolean QA() {
        if (this.values == null) {
            x.e("MicroMsg.InvokeMessageNewXmlMsg", "[parseXml] values == null ");
            return false;
        }
        if (this.values.containsKey(".sysmsg.invokeMessage.preContent")) {
            this.yGX = (String) this.values.get(".sysmsg.invokeMessage.preContent");
        }
        if (this.values.containsKey(".sysmsg.invokeMessage.timestamp")) {
            this.yGY = bh.VJ((String) this.values.get(".sysmsg.invokeMessage.timestamp"));
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (String str : this.values.keySet()) {
            String str2;
            if (!str2.startsWith(".sysmsg.invokeMessage.text")) {
                int i2;
                if (!str2.startsWith(".sysmsg.invokeMessage.link.text") || bh.ov((String) this.values.get(str2))) {
                    i2 = i;
                } else {
                    str2 = (String) this.values.get(str2);
                    stringBuilder.append(str2);
                    this.hIv.add(str2);
                    i2 = str2.length();
                }
                i = i2;
            } else if (stringBuilder.length() > 0) {
                stringBuilder.insert(0, (String) this.values.get(str2));
            } else {
                stringBuilder.append((String) this.values.get(str2));
            }
        }
        this.hIw.addFirst(Integer.valueOf(stringBuilder.length() - i));
        this.hIx.add(Integer.valueOf(stringBuilder.length()));
        this.hIt = stringBuilder.toString();
        if (System.currentTimeMillis() - this.yGY >= 300000 && !bh.ov(this.yGX)) {
            e.post(new 1(this), "[checkExpired]");
        }
        return true;
    }
}
