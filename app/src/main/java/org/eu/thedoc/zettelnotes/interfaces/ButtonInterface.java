package org.eu.thedoc.zettelnotes.interfaces;

import androidx.fragment.app.FragmentManager;

public abstract class ButtonInterface {

  public static final String INTENT_ACTION = "org.eu.thedoc.zettelnotes.intent.buttons";

  protected Callback mCallback;
  protected FragmentManager mFragmentManager;

  public abstract String getName ();

  public abstract Listener getListener ();

  public void registerCallback (Callback callback) {
    mCallback = callback;
  }

  public void bindFragmentManager (FragmentManager manager) {mFragmentManager = manager;}

  public interface Listener {
    void onClick ();
    boolean onLongClick ();
  }

  public interface Callback {
    void insertText (String text);
    void replaceTextSelected (String text);
    String getTextSelected ();
  }

}
