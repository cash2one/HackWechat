package com.tencent.mm.pluginsdk.model;

import com.tencent.mm.pluginsdk.model.a.1;

public enum a$a {
    TencentMap(0),
    GoogleMap(1),
    SogouMap(2),
    BaiduMap(3),
    AutonaviMap(4);
    
    public final int code;

    private a$a(int i) {
        this.code = i;
    }

    public final String getPackage() {
        switch (1.vcZ[ordinal()]) {
            case 1:
                return "com.tencent.map";
            case 2:
                return "com.google.android.apps.maps";
            case 3:
                return "com.sogou.map.android.maps";
            case 4:
                return "com.baidu.BaiduMap";
            case 5:
                return "com.autonavi.minimap";
            default:
                return "com.tencent.map";
        }
    }

    public static a$a Bz(int i) {
        switch (i) {
            case 0:
                return TencentMap;
            case 1:
                return GoogleMap;
            case 2:
                return SogouMap;
            case 3:
                return BaiduMap;
            case 4:
                return AutonaviMap;
            default:
                return TencentMap;
        }
    }
}
