package com.tinkerboots.sdk;

import android.content.Context;
import com.tencent.tinker.lib.b.b;
import com.tencent.tinker.lib.c.a;
import com.tencent.tinker.lib.d.c;
import com.tencent.tinker.lib.d.d;
import com.tencent.tinker.lib.service.AbstractResultService;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.app.ApplicationLike;

public class a$a {
    public b AiA;
    public c AiB;
    public d AiC;
    public a Auh;
    public Class<? extends AbstractResultService> Aui;
    public com.tinkerboots.sdk.a.a.b Auj;
    public final ApplicationLike applicationLike;
    public final Context context;

    public a$a(ApplicationLike applicationLike) {
        if (applicationLike == null) {
            throw new TinkerRuntimeException("applicationLike must not be null.");
        }
        this.context = applicationLike.getApplication();
        this.applicationLike = applicationLike;
    }
}
