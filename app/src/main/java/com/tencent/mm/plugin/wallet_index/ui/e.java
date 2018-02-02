package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.constants.ConstantsAPI$Token;
import com.tencent.mm.opensdk.modelpay.PayReq$Options;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class e {
    public static boolean a(Context context, String str, PayResp payResp, PayReq$Options payReq$Options) {
        x.d("MicroMsg.PayCallbackHelper", "callback, packageName = " + str);
        String str2 = (payReq$Options == null || bh.ov(payReq$Options.callbackClassName)) ? str + ".wxapi.WXPayEntryActivity" : payReq$Options.callbackClassName;
        int i = (payReq$Options == null || payReq$Options.callbackFlags == -1) ? SQLiteDatabase.CREATE_IF_NECESSARY : payReq$Options.callbackFlags;
        x.d("MicroMsg.PayCallbackHelper", "callback, cbPkg = " + str + ", cbCls = " + str2 + ", cbFlags(hex) = " + Integer.toHexString(i));
        Bundle bundle = new Bundle();
        bundle.putString(ConstantsAPI$Token.WX_TOKEN_KEY, ConstantsAPI$Token.WX_TOKEN_VALUE_MSG);
        if (payResp != null) {
            payResp.toBundle(bundle);
        }
        Args args = new Args();
        args.targetPkgName = str;
        args.targetClassName = str2;
        args.bundle = bundle;
        args.flags = i;
        return MMessageActV2.send(context, args);
    }
}
