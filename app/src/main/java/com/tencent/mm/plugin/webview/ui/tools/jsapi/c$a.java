package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.protocal.c.bsb;
import java.util.LinkedList;

public interface c$a {

    public enum a {
        RET_OK(0),
        RET_FAIL(-1),
        RET_REJECT(-2),
        RET_ACCESS_DENIED(-3);
        
        private int code;

        private a(int i) {
            this.code = i;
        }

        public final int getCode() {
            return this.code;
        }
    }

    void a(a aVar, String str, LinkedList<bsb> linkedList, int i, int i2);
}
