package com.intellij.flex.uiDesigner.libraries;

import com.intellij.openapi.diagnostic.Attachment;
import com.intellij.flex.uiDesigner.FlashUIDesignerBundle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.PropertyKey;

public class InitException extends Exception {
  public final Attachment[] attachments;
  public final String technicalMessage;

  InitException(@NotNull Throwable e) {
      super(e);
      attachments = null;
      technicalMessage = null;
    }

  InitException(@NotNull Throwable e, @PropertyKey(resourceBundle = FlashUIDesignerBundle.BUNDLE) String key) {
    this(e, key, null, null);
  }

  InitException(@NotNull Throwable e, @PropertyKey(resourceBundle = FlashUIDesignerBundle.BUNDLE) String key, @Nullable Attachment[] attachments, @Nullable String technicalMessage) {
    super(FlashUIDesignerBundle.message(key), e);
    this.attachments = attachments;
    this.technicalMessage = technicalMessage;
  }
}