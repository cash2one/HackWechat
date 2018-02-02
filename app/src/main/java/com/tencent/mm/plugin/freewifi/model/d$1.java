package com.tencent.mm.plugin.freewifi.model;

import java.util.HashMap;

class d$1 extends HashMap<Integer, String> {
    d$1() {
        put(Integer.valueOf(-1), "CONNECT_STATE_NOT_CONNECT");
        put(Integer.valueOf(0), "CONNECT_STATE_NOT_WECHAT_WIFI");
        put(Integer.valueOf(1), "CONNECT_STATE_CONNECTING");
        put(Integer.valueOf(2), "CONNECT_STATE_CONNECT_SUCCESS");
        put(Integer.valueOf(3), "CONNECT_STATE_CONNECT_FAILED");
        put(Integer.valueOf(4), "CONNECT_STATE_WAIT_START");
    }
}
