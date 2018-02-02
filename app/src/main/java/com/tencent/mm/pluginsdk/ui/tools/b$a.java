package com.tencent.mm.pluginsdk.ui.tools;

import java.util.ArrayList;
import java.util.List;

class b$a {
    List<String> qjF;

    private b$a() {
        this.qjF = new ArrayList();
    }

    final String ccu() {
        if (this.qjF == null || this.qjF.size() == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String append : this.qjF) {
            stringBuffer.append(append);
            stringBuffer.append(";");
        }
        return stringBuffer.toString();
    }

    final void IC(String str) {
        this.qjF = new ArrayList();
        if (str != null && str.length() != 0) {
            for (Object add : str.split(";")) {
                this.qjF.add(add);
            }
        }
    }
}
