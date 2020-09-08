package com.example.emqttdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;


public class MainActivity extends AppCompatActivity {
    String clientId = "temp";
    private String clientName = "";
    private String subTopic = "xiaoyi/#";
    private String pubTopic = "xiaoyi/1";
    private String payLoad = "Hello World from xiaoyi";
    private EditText et_host;
    private Button btn_con;
    private TextView tv_console;
    private TextView et_clientname;
    private TextView et_clientid;
    int qos = 2;
    String broker = "tcp://www.ranye-iot.com:1883";        //"tcp://broker.emqx.io:1883" 测试成功

    MemoryPersistence persistence = new MemoryPersistence();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_host = findViewById(R.id.et_host);
        et_clientname = findViewById(R.id.et_clientname);
        et_clientid = findViewById(R.id.et_clientid);
        btn_con = findViewById(R.id.btn_con);
        btn_con.setOnClickListener(new MyOnClickListener());

        tv_console = findViewById(R.id.tv_console);
    }


    private void makeMqtt()
    {
        try {
            MqttClient client = new MqttClient(broker, clientId, persistence);

            // MQTT 连接选项
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setConnectionTimeout(3000);
            connOpts.setUserName("xiaoyi");
            connOpts.setPassword("12345678".toCharArray());
            // 保留会话
            connOpts.setCleanSession(true);

            // 设置回调
            //client.setCallback(new PushCallback());

            // 建立连接
//            System.out.println("Connecting to broker: " + broker);
//            client.connect(connOpts);
//
//            System.out.println("Connected");
//            System.out.println("Publishing message: " + content);
//
//            // 订阅
//            client.subscribe(subTopic);
//
//            // 消息发布所需参数
//            MqttMessage message = new MqttMessage(content.getBytes());
//            message.setQos(qos);
//            client.publish(pubTopic, message);
//            System.out.println("Message published");
//
//            client.disconnect();
//            System.out.println("Disconnected");
//            client.close();
//            System.exit(0);

            tv_console.append("\n"+"Connecting to broker: " + broker);
            client.connect(connOpts);
            tv_console.append("\n"+ "Connected");
            tv_console.append("\n"+ "Publishing message: \n Topic:  " + pubTopic + "\n  Payload:  " + payLoad);
            client.subscribe(subTopic);
            MqttMessage message = new MqttMessage(payLoad.getBytes());
            message.setQos(qos);
            client.publish(pubTopic, message);
            tv_console.append("\n"+ "Message published");
            client.disconnect();
            tv_console.append("\n"+ "Disconnected");
            client.close();
            //System.exit(0);
        } catch (MqttException me) {
//            System.out.println("reason " + me.getReasonCode());
//            System.out.println("msg " + me.getMessage());
//            System.out.println("loc " + me.getLocalizedMessage());
//            System.out.println("cause " + me.getCause());
//            System.out.println("excep " + me);
//            me.printStackTrace();
            tv_console.append("\n"+ "reason " + me.getReasonCode());
            tv_console.append("\n"+ "msg " + me.getMessage());
            tv_console.append("\n"+ "loc " + me.getLocalizedMessage());
            tv_console.append("\n"+ "cause " + me.getCause());
            tv_console.append("\n"+ "excep " + me);
            me.printStackTrace();

        }

    }


    class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) { // 点击事件的处理方法
            if (v.getId() == R.id.btn_con) { // 判断是否为btn_click被点击
                //Toast.makeText(getApplicationContext(), "您点击了控件：" + ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
                clientId = et_clientid.getText().toString();
                broker = "tcp://" + et_host.getText().toString();
                tv_console.append("\n"+broker);
                makeMqtt();

            }
        }
    }
}