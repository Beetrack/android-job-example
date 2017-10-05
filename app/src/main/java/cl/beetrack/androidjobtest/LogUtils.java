package cl.beetrack.androidjobtest;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by danielsantamaria on 10/2/17.
 */

public class LogUtils {

  private static final String FILENAME = "job-test-logs.txt";

  public static void append(Context context, String text) {
    File file = new File(getPath(context), FILENAME);
    try {
      FileOutputStream stream = new FileOutputStream(file, true);
      stream.write(text.getBytes());
      stream.write("\r\n".getBytes());
      stream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String read(Context context) {
    File file = new File(getPath(context), FILENAME);
    int length = (int) file.length();
    byte[] bytes = new byte[length];
    try {
      FileInputStream in = new FileInputStream(file);
      in.read(bytes);
      in.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return new String(bytes);
  }

  public static void delete(Context context) {
    File file = new File(getPath(context), FILENAME);
    file.delete();
  }

  private static String getPath(Context context) {
    return context.getFilesDir().getAbsolutePath();
  }

}
