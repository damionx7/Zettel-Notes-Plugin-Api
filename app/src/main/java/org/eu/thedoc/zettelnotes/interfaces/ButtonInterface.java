package org.eu.thedoc.zettelnotes.interfaces;

import android.content.Intent;
import android.util.Pair;
import androidx.activity.result.ActivityResult;

public abstract class ButtonInterface {

  protected Callback mCallback;

  public abstract String getName();

  public abstract Listener getListener();

  public void registerCallback(Callback callback) {
    mCallback = callback;
  }

  public interface Listener {

    void onClick();

    boolean onLongClick();
  }

  public interface ActivityResultListener {

    void getActivityResult(ActivityResult result);
  }

  public interface Callback {

    void startActivityForResult(Intent intent);

    void setActivityResultListener(ActivityResultListener result);

    void insertText(String text);

    void replaceTextSelected(String text);

    /***
     * @return Pair with 1st Integer as Line
     * and String as line content
     */
    Pair<Integer, String> getCurrentLine();

    /***
     * Replaces text in line at line number
     * with Text in Pair
     */
    void replaceCurrentLine (Pair<Integer, String> pair);

    String getTextSelected(boolean returnAllIfEmpty);
  }

}
