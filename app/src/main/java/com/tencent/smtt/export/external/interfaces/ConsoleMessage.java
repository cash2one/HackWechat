package com.tencent.smtt.export.external.interfaces;

public interface ConsoleMessage {
    int lineNumber();

    String message();

    MessageLevel messageLevel();

    String sourceId();
}
