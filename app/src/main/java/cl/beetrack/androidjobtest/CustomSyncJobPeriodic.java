package cl.beetrack.androidjobtest;

import android.support.annotation.NonNull;
import android.util.Log;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobManager;
import com.evernote.android.job.JobRequest;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by danielsantamaria on 10/2/17.
 */

public class CustomSyncJobPeriodic extends Job {

  public static final String TAG = "CustomSyncJobPeriodic";
  private static final long PERIOD = 1000 * 60 * 15;
  private static final SimpleDateFormat DISPLAY_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

  @NonNull
  @Override
  protected Result onRunJob(Params params) {
    LogUtils.append(getContext(), "Periodic Job at " + DISPLAY_FORMAT.format(new Date()));
    scheduleJob();
    return Result.SUCCESS;
  }

  public static void scheduleJob() {
    int jobRequests = JobManager.instance().getAllJobRequestsForTag(TAG).size();
    if (jobRequests > 0) {
      Log.d(TAG, "Periodic Job already exists. Current job requests for this tag: " + jobRequests);
      return;
    }

    new JobRequest.Builder(TAG)
        .setExact(PERIOD)
        .build()
        .schedule();
  }

  public static void cancelJob() {
    JobManager.instance().cancelAllForTag(TAG);
  }

}
