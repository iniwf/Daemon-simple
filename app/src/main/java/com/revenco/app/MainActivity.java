package com.revenco.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.revenco.app.wakeup.assistantReceiver;
import com.revenco.daemon.DaemonManager;
import com.revenco.daemon.java.services.DaemonEnv;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Start();
    }

    private void Start() {
        //主要的业务逻辑进程
        String processName = "com.revenco.app:business";
        String serviceName = TraceServiceImpl.class.getCanonicalName();
        String receiveName = assistantReceiver.class.getCanonicalName();
        DaemonManager.INSTANCE.init(this, processName, serviceName, receiveName);
        //初始化开启LOG日志记录到SDCard，方便观察app如何被唤醒的日志
        DaemonManager.INSTANCE.initLogFile(this);

        //配置
        DaemonEnv.initialize(this, TraceServiceImpl.class, DaemonEnv.DEFAULT_WAKE_UP_INTERVAL);
        try {
            //启动
            startService(new Intent(this, TraceServiceImpl.class));
        } catch (Exception e) {
        }
    }
}
