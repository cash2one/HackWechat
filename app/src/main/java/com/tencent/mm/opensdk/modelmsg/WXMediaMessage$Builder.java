package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.utils.Log;

public class WXMediaMessage$Builder {
    public static final String KEY_IDENTIFIER = "_wxobject_identifier_";

    public static WXMediaMessage fromBundle(Bundle bundle) {
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.sdkVer = bundle.getInt("_wxobject_sdkVer");
        wXMediaMessage.title = bundle.getString("_wxobject_title");
        wXMediaMessage.description = bundle.getString("_wxobject_description");
        wXMediaMessage.thumbData = bundle.getByteArray("_wxobject_thumbdata");
        wXMediaMessage.mediaTagName = bundle.getString("_wxobject_mediatagname");
        wXMediaMessage.messageAction = bundle.getString("_wxobject_message_action");
        wXMediaMessage.messageExt = bundle.getString("_wxobject_message_ext");
        String pathOldToNew = pathOldToNew(bundle.getString(KEY_IDENTIFIER));
        if (pathOldToNew == null || pathOldToNew.length() <= 0) {
            return wXMediaMessage;
        }
        try {
            wXMediaMessage.mediaObject = (IMediaObject) Class.forName(pathOldToNew).newInstance();
            wXMediaMessage.mediaObject.unserialize(bundle);
            return wXMediaMessage;
        } catch (Exception e) {
            Log.e("MicroMsg.SDK.WXMediaMessage", "get media object from bundle failed: unknown ident " + pathOldToNew + ", ex = " + e.getMessage());
            return wXMediaMessage;
        }
    }

    private static String pathNewToOld(String str) {
        if (str != null && str.length() != 0) {
            return str.replace("com.tencent.mm.opensdk.modelmsg", "com.tencent.mm.sdk.openapi");
        }
        Log.e("MicroMsg.SDK.WXMediaMessage", "pathNewToOld fail, newPath is null");
        return str;
    }

    private static String pathOldToNew(String str) {
        Log.i("MicroMsg.SDK.WXMediaMessage", "pathOldToNew, oldPath = " + str);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.SDK.WXMediaMessage", "pathOldToNew fail, oldPath is null");
            return str;
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            return "com.tencent.mm.opensdk.modelmsg" + str.substring(lastIndexOf);
        }
        Log.e("MicroMsg.SDK.WXMediaMessage", "pathOldToNew fail, invalid pos, oldPath = " + str);
        return str;
    }

    public static Bundle toBundle(WXMediaMessage wXMediaMessage) {
        Bundle bundle = new Bundle();
        bundle.putInt("_wxobject_sdkVer", wXMediaMessage.sdkVer);
        bundle.putString("_wxobject_title", wXMediaMessage.title);
        bundle.putString("_wxobject_description", wXMediaMessage.description);
        bundle.putByteArray("_wxobject_thumbdata", wXMediaMessage.thumbData);
        if (wXMediaMessage.mediaObject != null) {
            bundle.putString(KEY_IDENTIFIER, pathNewToOld(wXMediaMessage.mediaObject.getClass().getName()));
            wXMediaMessage.mediaObject.serialize(bundle);
        }
        bundle.putString("_wxobject_mediatagname", wXMediaMessage.mediaTagName);
        bundle.putString("_wxobject_message_action", wXMediaMessage.messageAction);
        bundle.putString("_wxobject_message_ext", wXMediaMessage.messageExt);
        return bundle;
    }
}
