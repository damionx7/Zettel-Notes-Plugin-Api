package org.eu.thedoc.zettelnotes.interfaces;

import android.content.Intent;

import androidx.activity.result.ActivityResult;

public abstract class ButtonInterface {

  public static final String VERSION = BuildConfig.API_VERSION;
  public static final String METADATA_API_VERSION = "org.eu.thedoc.zettelnotes.interfaces.version";

  public static final String INTENT_ACTION = "org.eu.thedoc.zettelnotes.intent.buttons";

  protected Callback mCallback;

  public abstract String getName ();

  public abstract Listener getListener ();

  public void registerCallback (Callback callback) {
    mCallback = callback;
  }

  public interface Listener {
    void onClick ();
    boolean onLongClick ();
  }

  public interface ActivityResultListener {
    void getActivityResult (ActivityResult result);
  }

  public interface Callback {
    void startActivityForResult (Intent intent);
    void setActivityResultListener (ActivityResultListener result);
    void insertText (String text);
    void replaceTextSelected (String text);
    String getTextSelected ();
  }

}
