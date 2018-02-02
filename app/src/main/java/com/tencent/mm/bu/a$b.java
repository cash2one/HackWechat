package com.tencent.mm.bu;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;

public class a$b {
    public static boolean CX(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("key", i);
        return ac.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/userinfo/"), "ConfigStorage.getBoolean", null, bundle).getBoolean("key", false);
    }

    public static String aQ(int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("key", i);
        return ac.getContext().getContentResolver().call(Uri.parse("content://com.tencent.mm.storage.provider.emotion/userinfo/"), "ConfigStorage.getString", null, bundle).getString("key", str);
    }

    public static void UB(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadSettingTable$Columns.TYPE, Integer.valueOf(-29414086));
        contentValues.put(DownloadSettingTable$Columns.VALUE, str);
        ac.getContext().getContentResolver().update(Uri.parse("content://com.tencent.mm.storage.provider.emotion/userinfo/"), contentValues, null, null);
    }
}
