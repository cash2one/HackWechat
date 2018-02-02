package com.tencent.mm.opensdk.modelmsg;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public final class WXMediaMessage {
    public static final String ACTION_WXAPPMESSAGE = "com.tencent.mm.sdk.openapi.Intent.ACTION_WXAPPMESSAGE";
    public static final int DESCRIPTION_LENGTH_LIMIT = 1024;
    public static final int MEDIA_TAG_NAME_LENGTH_LIMIT = 64;
    public static final int MESSAGE_ACTION_LENGTH_LIMIT = 2048;
    public static final int MESSAGE_EXT_LENGTH_LIMIT = 2048;
    public static final int MINI_PROGRAM__THUMB_LENGHT = 131072;
    private static final String TAG = "MicroMsg.SDK.WXMediaMessage";
    public static final int THUMB_LENGTH_LIMIT = 32768;
    public static final int TITLE_LENGTH_LIMIT = 512;
    public String description;
    public IMediaObject mediaObject;
    public String mediaTagName;
    public String messageAction;
    public String messageExt;
    public int sdkVer;
    public byte[] thumbData;
    public String title;

    public interface IMediaObject {
        public static final int TYPE_APPBRAND = 33;
        public static final int TYPE_APPDATA = 7;
        public static final int TYPE_CARD_SHARE = 16;
        public static final int TYPE_DESIGNER_SHARED = 25;
        public static final int TYPE_DEVICE_ACCESS = 12;
        public static final int TYPE_EMOJI = 8;
        public static final int TYPE_EMOJILIST_SHARED = 27;
        public static final int TYPE_EMOTICON_GIFT = 11;
        public static final int TYPE_EMOTICON_SHARED = 15;
        public static final int TYPE_EMOTIONLIST_SHARED = 26;
        public static final int TYPE_FILE = 6;
        public static final int TYPE_GAME_VIDEO_FILE = 39;
        public static final int TYPE_GIFTCARD = 34;
        public static final int TYPE_IMAGE = 2;
        public static final int TYPE_LOCATION = 30;
        public static final int TYPE_LOCATION_SHARE = 17;
        public static final int TYPE_MALL_PRODUCT = 13;
        public static final int TYPE_MUSIC = 3;
        public static final int TYPE_NOTE = 24;
        public static final int TYPE_OLD_TV = 14;
        public static final int TYPE_OPENSDK_APPBRAND = 36;
        public static final int TYPE_PRODUCT = 10;
        public static final int TYPE_RECORD = 19;
        public static final int TYPE_TEXT = 1;
        public static final int TYPE_TV = 20;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_URL = 5;
        public static final int TYPE_VIDEO = 4;
        public static final int TYPE_VIDEO_FILE = 38;

        boolean checkArgs();

        void serialize(Bundle bundle);

        int type();

        void unserialize(Bundle bundle);
    }

    public WXMediaMessage() {
        this(null);
    }

    public WXMediaMessage(IMediaObject iMediaObject) {
        this.mediaObject = iMediaObject;
    }

    final boolean checkArgs() {
        if (getType() == 8 && (this.thumbData == null || this.thumbData.length == 0)) {
            Log.e(TAG, "checkArgs fail, thumbData should not be null when send emoji");
            return false;
        } else if (getType() == 36 && (this.thumbData == null || this.thumbData.length > MINI_PROGRAM__THUMB_LENGHT)) {
            Log.e(TAG, "checkArgs fail, thumbData should not be null or exceed 128kb");
            return false;
        } else if (getType() != 36 && this.thumbData != null && this.thumbData.length > THUMB_LENGTH_LIMIT) {
            Log.e(TAG, "checkArgs fail, thumbData is invalid");
            return false;
        } else if (this.title != null && this.title.length() > TITLE_LENGTH_LIMIT) {
            Log.e(TAG, "checkArgs fail, title is invalid");
            return false;
        } else if (this.description != null && this.description.length() > DESCRIPTION_LENGTH_LIMIT) {
            Log.e(TAG, "checkArgs fail, description is invalid");
            return false;
        } else if (this.mediaObject == null) {
            Log.e(TAG, "checkArgs fail, mediaObject is null");
            return false;
        } else if (this.mediaTagName != null && this.mediaTagName.length() > 64) {
            Log.e(TAG, "checkArgs fail, mediaTagName is too long");
            return false;
        } else if (this.messageAction != null && this.messageAction.length() > 2048) {
            Log.e(TAG, "checkArgs fail, messageAction is too long");
            return false;
        } else if (this.messageExt == null || this.messageExt.length() <= 2048) {
            return this.mediaObject.checkArgs();
        } else {
            Log.e(TAG, "checkArgs fail, messageExt is too long");
            return false;
        }
    }

    public final int getType() {
        return this.mediaObject == null ? 0 : this.mediaObject.type();
    }

    public final void setThumbImage(Bitmap bitmap) {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(CompressFormat.JPEG, 85, byteArrayOutputStream);
            this.thumbData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Exception e) {
            Log.e(TAG, "setThumbImage exception:" + e.getMessage());
        }
    }
}
