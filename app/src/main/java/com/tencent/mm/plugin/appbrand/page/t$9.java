package com.tencent.mm.plugin.appbrand.page;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.xweb.WebView;
import com.tencent.xweb.x5.a.a.a.a.b;

class t$9 extends b {
    final /* synthetic */ t jFj;

    t$9(t tVar) {
        this.jFj = tVar;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent, View view) {
        return t.j(this.jFj).z(motionEvent);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
        return t.j(this.jFj).B(motionEvent);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
        return t.j(this.jFj).A(motionEvent);
    }

    public final boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view) {
        return t.j(this.jFj).a(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
        t.j(this.jFj).onScrollChanged(i, i2, i3, i4, view);
    }

    public final void onOverScrolled(int i, int i2, boolean z, boolean z2, View view) {
        t.j(this.jFj).b(i, i2, z, z2);
    }

    public final void computeScroll(View view) {
        t.j(this.jFj).ahE();
    }

    public final boolean onShowLongClickPopupMenu() {
        if (WebView.getTbsCoreVersion(this.jFj.getContext()) >= 43011) {
            return false;
        }
        return true;
    }

    public final Object onMiscCallBack(String str, Bundle bundle) {
        if (bh.ov(str) || bundle == null) {
            return null;
        }
        x.i("MicroMsg.AppBrandWebView", "method = %s", new Object[]{str});
        if (!str.equalsIgnoreCase("shouldInterceptMediaUrl")) {
            return null;
        }
        String string = bundle.getString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (bh.ov(string)) {
            return null;
        }
        AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(t.a(this.jFj), string);
        if (itemByLocalId == null) {
            x.e("MicroMsg.AppBrandWebView", "get meidiaobj failed, appid : %s, localid :%s", new Object[]{t.a(this.jFj), string});
            return null;
        }
        Object obj = itemByLocalId.hhZ;
        x.i("MicroMsg.AppBrandWebView", new StringBuilder(DownloadInfoColumns.FILEPATH).append(obj).append("tempFilePath").append(string).toString());
        return obj;
    }

    public final boolean shouldDiscardCurrentPage() {
        boolean z;
        boolean ajc = t.k(this.jFj).ajc();
        String str = "MicroMsg.AppBrandWebView";
        String str2 = "shouldTrimCurrentPage: %b";
        Object[] objArr = new Object[1];
        if (!ajc || t.l(this.jFj)) {
            z = false;
        } else {
            z = true;
        }
        objArr[0] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        if (!ajc || t.l(this.jFj)) {
            return false;
        }
        return true;
    }

    public final void hasDiscardCurrentPage(boolean z) {
        t.b(this.jFj, z);
        t.a(this.jFj, !z);
    }
}
