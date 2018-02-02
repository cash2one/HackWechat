package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.h;
import com.tencent.mm.sdk.platformtools.x;

public class c extends a {
    protected int getLayoutId() {
        return R.i.dfU;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        x.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onAttach");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onCreate");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        x.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onCreateView");
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onStart() {
        super.onStart();
        x.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onStart");
    }

    public void onResume() {
        super.onResume();
        x.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onResume");
        if (this.lFg != null) {
            this.lFg.aDt();
        }
    }

    public void onPause() {
        super.onPause();
        x.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onPause");
    }

    public void onStop() {
        super.onStop();
        x.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onStop");
    }

    public void onDestroyView() {
        super.onDestroyView();
        x.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onResume");
    }

    public void onDestroy() {
        super.onDestroy();
        x.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onDestroy");
    }

    public void onDetach() {
        super.onDetach();
        x.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onDestroy");
    }

    public final int aCq() {
        return 9;
    }

    public final a aCj() {
        return new h(getContext());
    }

    public final boolean aDq() {
        return false;
    }
}
