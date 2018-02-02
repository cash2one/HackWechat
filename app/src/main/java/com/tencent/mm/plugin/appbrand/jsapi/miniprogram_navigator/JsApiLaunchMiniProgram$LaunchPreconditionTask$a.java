package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

enum JsApiLaunchMiniProgram$LaunchPreconditionTask$a {
    FAIL("fail"),
    FAIL_MORE_THAN_ONE_TASK("fail can not launch more than 1 mini program"),
    OK("ok");
    
    public final String fpb;

    private JsApiLaunchMiniProgram$LaunchPreconditionTask$a(String str) {
        this.fpb = str;
    }

    public static JsApiLaunchMiniProgram$LaunchPreconditionTask$a kB(int i) {
        for (JsApiLaunchMiniProgram$LaunchPreconditionTask$a jsApiLaunchMiniProgram$LaunchPreconditionTask$a : values()) {
            if (i == jsApiLaunchMiniProgram$LaunchPreconditionTask$a.ordinal()) {
                return jsApiLaunchMiniProgram$LaunchPreconditionTask$a;
            }
        }
        return null;
    }
}
