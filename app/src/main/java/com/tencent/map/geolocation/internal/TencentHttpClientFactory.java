package com.tencent.map.geolocation.internal;

import android.content.Context;
import android.os.Bundle;
import c.t.m.g.dh;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;

public abstract class TencentHttpClientFactory {
    private static TencentHttpClientFactory sCustFact;

    public abstract Bundle getParams();

    public static TencentHttpClientFactory getInstance() {
        return new TencentHttpClientFactory() {
            public final Bundle getParams() {
                return null;
            }
        };
    }

    public static void setTencentHttpClientFactory(TencentHttpClientFactory tencentHttpClientFactory) {
        sCustFact = tencentHttpClientFactory;
    }

    public TencentHttpClient getTencentHttpClient(Context context, Bundle bundle) {
        if (sCustFact == null) {
            return new dh(context, bundle.getString(DownloadInfoColumns.CHANNELID));
        }
        TencentHttpClient tencentHttpClient = sCustFact.getTencentHttpClient(context, sCustFact.getParams());
        String str = "http client should NOT be null";
        if (tencentHttpClient != null) {
            return tencentHttpClient;
        }
        throw new NullPointerException(String.valueOf(str));
    }
}
