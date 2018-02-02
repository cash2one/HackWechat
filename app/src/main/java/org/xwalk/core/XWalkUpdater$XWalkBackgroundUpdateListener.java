package org.xwalk.core;

public interface XWalkUpdater$XWalkBackgroundUpdateListener {
    void onXWalkUpdateCancelled();

    void onXWalkUpdateCompleted();

    void onXWalkUpdateFailed(int i);

    void onXWalkUpdateProgress(int i);

    void onXWalkUpdateStarted();
}
