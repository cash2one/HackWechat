package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.g;
import com.tencent.mm.sdk.platformtools.x;

public class b extends a {
    protected int getLayoutId() {
        return R.i.dfS;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        x.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onAttach");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onCreate");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        x.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onCreateView");
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onActivityCreated(Bundle bundle) {
        x.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onActivityCreated");
        super.onActivityCreated(bundle);
    }

    public void onStart() {
        super.onStart();
        x.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onStart");
    }

    public void onResume() {
        super.onResume();
        x.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onResume");
    }

    public void onPause() {
        super.onPause();
        x.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onPause");
    }

    public void onStop() {
        super.onStop();
        x.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onStop");
    }

    public void onDestroyView() {
        super.onDestroyView();
        x.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onResume");
    }

    public void onDestroy() {
        super.onDestroy();
        x.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onDestroy");
    }

    public void onDetach() {
        super.onDetach();
        x.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onDestroy");
    }

    public final int aCq() {
        return 5;
    }

    public final a aCj() {
        return new g(getContext());
    }

    public final boolean aDq() {
        return true;
    }
}
