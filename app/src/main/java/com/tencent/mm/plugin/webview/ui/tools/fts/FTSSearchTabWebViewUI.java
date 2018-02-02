package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.bc.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.wcdb.FileUtils;

public class FTSSearchTabWebViewUI extends FTSBaseWebViewUI {
    protected final String getHint() {
        Object stringExtra = getIntent().getStringExtra("key_search_input_hint");
        if (!TextUtils.isEmpty(stringExtra)) {
            return stringExtra;
        }
        int i = -1;
        switch (this.type) {
            case 1:
                i = R.l.eIQ;
                break;
            case 2:
                i = R.l.eIP;
                break;
            case 8:
                i = R.l.ekA;
                break;
            case 16:
                i = R.l.ekz;
                break;
            case 64:
                i = R.l.dDT;
                break;
            case FileUtils.S_IWUSR /*128*/:
                i = R.l.ekv;
                break;
            case 256:
            case 384:
                i = R.l.eku;
                break;
            case WXMediaMessage.TITLE_LENGTH_LIMIT /*512*/:
                i = R.l.ekx;
                break;
            case WXMediaMessage.DESCRIPTION_LENGTH_LIMIT /*1024*/:
                i = R.l.eky;
                break;
        }
        if (i < 0) {
            return ac.getContext().getResources().getString(R.l.dGz);
        }
        return ac.getContext().getResources().getString(R.l.eIO, new Object[]{ac.getContext().getResources().getString(i)});
    }

    protected void onResume() {
        super.onResume();
        g.QY();
    }

    protected void onPause() {
        super.onPause();
        g.QZ();
    }
}
