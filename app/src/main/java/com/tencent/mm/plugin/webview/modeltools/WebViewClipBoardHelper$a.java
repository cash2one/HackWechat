package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.plugin.secinforeport.a.a;
import com.tencent.mm.plugin.webview.modeltools.WebViewClipBoardHelper.ClipBoardDataWrapper;
import com.tencent.mm.sdk.platformtools.x;

final class WebViewClipBoardHelper$a implements h<ClipBoardDataWrapper, Object> {
    private WebViewClipBoardHelper$a() {
    }

    public final /* synthetic */ void a(Object obj, i iVar) {
        ClipBoardDataWrapper clipBoardDataWrapper = (ClipBoardDataWrapper) obj;
        if (clipBoardDataWrapper != null) {
            int i = a.qff;
            a.d(3, clipBoardDataWrapper.url, clipBoardDataWrapper.length);
            return;
        }
        x.e("MicroMsg.WebViewClipBoardHelper", "InvokeTask, mm received invalid data");
    }
}
