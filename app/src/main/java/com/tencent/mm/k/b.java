package com.tencent.mm.k;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public static int zz() {
        return bh.getInt(g.zY().getValue("InputLimitSessionTextMsg"), 8192) * 2;
    }

    public static int zA() {
        return bh.getInt(g.zY().getValue("InputLimitSNSObjectText"), MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) * 2;
    }

    public static int zB() {
        return bh.getInt(g.zY().getValue("SnsCommentMaxSize"), 1000) * 2;
    }

    public static int zC() {
        return bh.getInt(g.zY().getValue("InputLimitFavText"), 100000) * 2;
    }

    public static int zD() {
        return bh.getInt(g.zY().getValue("InputLimitSendEmotionBufSize"), 1048576);
    }

    public static int zE() {
        int i = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        try {
            i = bh.getInt(g.zY().getValue("InputLimitSendEmotionWidth"), WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        } catch (Exception e) {
            x.j("MicroMsg.BoundaryConfig", "getCustomEmojiMaxWidthAndHeight:%s", new Object[]{e});
        }
        return i;
    }

    public static int zF() {
        int i = 5242880;
        try {
            i = bh.getInt(g.zY().getValue("InputLimitSendAppMsgEmotionBufSize"), 5242880);
        } catch (Exception e) {
            x.j("MicroMsg.BoundaryConfig", "getAppEmojiMsgMaxSize:%s", new Object[]{e});
        }
        return i;
    }

    public static int zG() {
        return bh.getInt(g.zY().getValue("InputLimitFavImageSize"), 26214400);
    }

    public static int zH() {
        return bh.getInt(g.zY().getValue("InputLimitVideoSize"), 26214400);
    }

    public static String zI() {
        return g.zY().getValue("InputLimitForbiddenChar");
    }
}
