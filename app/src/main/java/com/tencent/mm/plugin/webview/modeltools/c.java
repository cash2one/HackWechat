package com.tencent.mm.plugin.webview.modeltools;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.webkit.ValueCallback;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.webview.model.ai;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.io.File;

public final class c {
    private String tum = null;
    private String tun = null;
    private ValueCallback<Uri> tuo = null;
    private ValueCallback<Uri[]> tup = null;

    public final boolean b(MMActivity mMActivity, int i, int i2, Intent intent) {
        if (i != 1) {
            return false;
        }
        if (this.tuo == null && this.tup == null) {
            x.w("MicroMsg.WebViewUI.FileChooser", "uploadFileCallback is null.");
        } else {
            Uri uri;
            if (i2 == -1) {
                String str = null;
                if (intent != null) {
                    uri = null;
                    if (intent.getData() == null) {
                        Bundle extras = intent.getExtras();
                        if (extras != null) {
                            uri = extras.getParcelable("android.intent.extra.STREAM") != null ? (Uri) extras.getParcelable("android.intent.extra.STREAM") : null;
                        }
                    } else {
                        uri = intent.getData();
                    }
                    str = bh.f(mMActivity, uri);
                    x.i("MicroMsg.WebViewUI.FileChooser", "get file path:[%s]", new Object[]{str});
                }
                if (bh.ov(str)) {
                    File file = new File(ai.Op(this.tun));
                    if (file.exists()) {
                        uri = Uri.fromFile(file);
                        x.d("MicroMsg.WebViewUI.FileChooser", "result = " + uri);
                        i(uri);
                        bRu();
                    }
                } else {
                    Object obj;
                    String SW = s.SW(str);
                    x.d("MicroMsg.WebViewUI.FileChooser", "get file mime type [%s]", new Object[]{SW});
                    if (bh.ov(this.tum)) {
                        obj = 1;
                    } else {
                        for (String replace : this.tum.split(",")) {
                            boolean z;
                            String replace2 = replace2.replace(" ", "");
                            if (bh.ov(replace2)) {
                                z = true;
                            } else {
                                if (!bh.ov(SW)) {
                                    if (replace2.contains("/") && SW.contains("/")) {
                                        String[] split = replace2.split("/");
                                        String[] split2 = SW.split("/");
                                        if (bh.ou(split[0]).equals(split2[0])) {
                                            z = bh.ou(split[1]).equals("*") || bh.ou(split[1]).equals(split2[1]);
                                        }
                                    } else {
                                        z = replace2.equals(SW);
                                    }
                                }
                                z = false;
                            }
                            if (z) {
                                obj = 1;
                                break;
                            }
                        }
                        obj = null;
                    }
                    if (obj != null) {
                        uri = intent.getData() == null ? Uri.fromFile(new File(str)) : intent.getData();
                        x.d("MicroMsg.WebViewUI.FileChooser", "result = " + uri);
                        i(uri);
                        bRu();
                    }
                }
            }
            uri = null;
            x.d("MicroMsg.WebViewUI.FileChooser", "result = " + uri);
            i(uri);
            bRu();
        }
        return true;
    }

    public final void a(Activity activity, e eVar, ValueCallback<Uri> valueCallback, ValueCallback<Uri[]> valueCallback2, String str, String str2) {
        Intent[] intentArr = null;
        x.i("MicroMsg.WebViewUI.FileChooser", "openFileChooser with wvPerm(%s), callback(%s), callbackLL(%s), acceptType(%s), capture(%s)", new Object[]{eVar, valueCallback, valueCallback2, str, str2});
        bRu();
        if (eVar == null || eVar.bSs() == null) {
            x.e("MicroMsg.WebViewUI.FileChooser", "openFileChooser fail, wvPerm is null");
            i(null);
        } else if (eVar.bSs().gn(56)) {
            int i;
            Parcelable[] parcelableArr;
            Intent intent;
            this.tuo = valueCallback;
            this.tup = valueCallback2;
            this.tun = System.currentTimeMillis();
            this.tum = str;
            String str3 = this.tun;
            Object intent2 = new Intent("android.intent.action.GET_CONTENT");
            intent2.addCategory("android.intent.category.OPENABLE");
            if (bh.ov(str)) {
                intent2.setType("*/*");
            } else {
                intent2.setType(str);
            }
            Object[] objArr;
            if (bh.ov(str2)) {
                if (f.fN(16)) {
                    x.i("MicroMsg.WebviewJSSDKUtil", "android API version is below 16.");
                    objArr = new Intent[]{ai.Oq(str3)};
                    i = 0;
                }
                parcelableArr = null;
                i = 0;
            } else if ("camera".equalsIgnoreCase(str2)) {
                parcelableArr = new Intent[]{ai.Oq(str3)};
                i = 0;
            } else if ("camcorder".equalsIgnoreCase(str2)) {
                objArr = new Intent[]{ai.bQS()};
                i = 0;
            } else if ("microphone".equalsIgnoreCase(str2)) {
                objArr = new Intent[]{ai.bQT()};
                i = 0;
            } else {
                if ("*".equalsIgnoreCase(str2)) {
                    if (str.equalsIgnoreCase("image/*")) {
                        intentArr = new Intent[]{ai.Oq(str3)};
                    } else if (str.equalsIgnoreCase("audio/*")) {
                        intentArr = new Intent[]{ai.bQT()};
                    } else if (str.equalsIgnoreCase("video/*")) {
                        intentArr = new Intent[]{ai.bQS()};
                    }
                    objArr = intentArr;
                    i = 1;
                }
                parcelableArr = null;
                i = 0;
            }
            if (i != 0 || parcelableArr == null || parcelableArr.length == 0) {
                intent = new Intent("android.intent.action.CHOOSER");
                intent.putExtra("android.intent.extra.INITIAL_INTENTS", parcelableArr);
                intent.putExtra("android.intent.extra.TITLE", ac.getContext().getString(R.l.eYz));
                intent.putExtra("android.intent.extra.INTENT", intent2);
            } else {
                intent = parcelableArr[0];
            }
            activity.startActivityForResult(intent, 1);
        } else {
            x.e("MicroMsg.WebViewUI.FileChooser", "open file chooser failed, permission fail");
            i(null);
        }
    }

    private void bRu() {
        this.tum = null;
        this.tuo = null;
        this.tup = null;
        this.tun = null;
    }

    private void i(Uri uri) {
        if (this.tuo != null) {
            this.tuo.onReceiveValue(uri);
        } else if (this.tup == null) {
        } else {
            if (uri == null) {
                this.tup.onReceiveValue(null);
                return;
            }
            this.tup.onReceiveValue(new Uri[]{uri});
        }
    }
}
