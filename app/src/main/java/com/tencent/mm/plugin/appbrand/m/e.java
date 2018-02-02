package com.tencent.mm.plugin.appbrand.m;

import android.content.Context;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import java.util.List;

public interface e extends a {
    void a(Context context, String str, String str2, List<WxaEntryInfo> list);

    void w(Context context, int i);
}
