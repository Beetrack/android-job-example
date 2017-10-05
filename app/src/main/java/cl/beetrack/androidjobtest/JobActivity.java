package cl.beetrack.androidjobtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class JobActivity extends AppCompatActivity implements View.OnClickListener {

  private Button manualJobBtn;
  private Button startPeriodicJobBtn;
  private Button stopPeriodicJobBtn;
  private Button sendLogsBtn;
  private Button refreshLogsBtn;
  private Button deleteLogsBtn;
  private EditText logsEt;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_job);

    manualJobBtn = findViewById(R.id.manualJobBtn);
    manualJobBtn.setOnClickListener(this);
    startPeriodicJobBtn = findViewById(R.id.startPeriodicJobBtn);
    startPeriodicJobBtn.setOnClickListener(this);
    stopPeriodicJobBtn = findViewById(R.id.stopPeriodicJobBtn);
    stopPeriodicJobBtn.setOnClickListener(this);
    sendLogsBtn = findViewById(R.id.sendLogsBtn);
    sendLogsBtn.setOnClickListener(this);
    refreshLogsBtn = findViewById(R.id.refreshLogsBtn);
    refreshLogsBtn.setOnClickListener(this);
    deleteLogsBtn = findViewById(R.id.deleteLogsBtn);
    deleteLogsBtn.setOnClickListener(this);
    logsEt = findViewById(R.id.logsEt);
  }

  @Override
  public void onClick(View view) {
    switch (view.getId()) {
      case R.id.manualJobBtn:
        CustomSyncJobManual.scheduleJob();
        break;
      case R.id.startPeriodicJobBtn:
        CustomSyncJobPeriodic.scheduleJob();
        break;
      case R.id.stopPeriodicJobBtn:
        CustomSyncJobPeriodic.cancelJob();
        break;
      case R.id.sendLogsBtn:
        shareAction();
        break;
      case R.id.refreshLogsBtn:
        logsEt.setText(LogUtils.read(this));
        break;
      case R.id.deleteLogsBtn:
        LogUtils.delete(this);
        break;
    }
  }

  private void shareAction() {
    Intent intent = new Intent(Intent.ACTION_SEND);
    intent.setType("text/plain");
    intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Logs API " + android.os.Build.VERSION.SDK_INT);
    intent.putExtra(Intent.EXTRA_TEXT, LogUtils.read(this));
    startActivity(Intent.createChooser(intent, "Enviar Logs"));
  }

}
