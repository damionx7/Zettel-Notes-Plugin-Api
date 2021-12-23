package org.eu.thedoc.zettelnotes.interfaces;

import android.content.Intent;

import androidx.activity.result.ActivityResult;

public abstract class ButtonInterface {

  public static final long VERSION = 5;
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
    ActivityResultListener getActivityResultListener ();
  }

  public interface ActivityResultListener {
    void getActivityResult (ActivityResult result);
  }

  public interface Callback {
    void startActivityForResult (Intent intent);
    ActivityResultListener getActivityResultListener ();
    void setActivityResultListener (ActivityResultListener result);
    void insertText (String text);
    void replaceTextSelected (String text);
    String getTextSelected ();
  }

}
