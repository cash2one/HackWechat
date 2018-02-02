package com.tencent.mm.plugin.appbrand.ui.banner;

enum b$a {
    appId,
    versionType,
    appName,
    iconURL,
    customText;
    
    static final int jOh = 0;

    static {
        jOh = values().length;
    }

    public final String Jo() {
        return "appbrand_top_banner_in_chatting_extra_key_" + name();
    }
}
