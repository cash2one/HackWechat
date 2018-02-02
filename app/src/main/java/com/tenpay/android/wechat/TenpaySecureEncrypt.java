package com.tenpay.android.wechat;

import com.tenpay.ndk.Encrypt;

public final class TenpaySecureEncrypt implements ISecureEncrypt {
    public final String encryptPasswdWithRSA2048(boolean z, String str, String str2) {
        if (z) {
            str = TenpayUtil.md5HexDigest(str);
        }
        Encrypt encrypt = new Encrypt();
        if (str2 != null) {
            encrypt.setTimeStamp(str2);
        }
        return encrypt.encryptPasswdWithRSA2048(str);
    }

    public final String encryptPasswd(boolean z, String str, String str2) {
        if (z) {
            str = TenpayUtil.md5HexDigest(str);
        }
        Encrypt encrypt = new Encrypt();
        if (str2 != null) {
            encrypt.setTimeStamp(str2);
        }
        return encrypt.encryptPasswd(str);
    }

    public final String desedeEncode(String str, String str2) {
        return new Encrypt().desedeEncode(str);
    }

    public final String desedeVerifyCode(String str, String str2) {
        return new Encrypt().desedeVerifyCode(str);
    }
}
