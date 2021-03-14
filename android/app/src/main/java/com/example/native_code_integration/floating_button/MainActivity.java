package com.example.native_code_integration.floating_button

import ...

public class MainActivity extends FlutterActivity {
    private static final String CHANNEL = "floating_button";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GeneratedPluginRegistrant.registerWith(this);

        MethodChannel channel = new MethodChannel(getFlutterEngine().getDartExecutor().getBinaryMessenger(), CHANNEL);
        
        channel.setMethodCallHandler(
            (call, result) -> {
                switch(call.method) {
                    case "create":
                        ImageView imageView = new ImageView(getApplicationContext());
                        imageView.setImageResource(R.drawable.plus);

                        FloatWindow.with(getApplicationContext()).setView(imageView)
                            .setWidth(Screen.width, 0.15f)
                            .setHeight(Screen.height, 0.15f)
                            .setX(Screen.width, 0.8f)
                            .setY(Screen.height, 0.3f)
                            .setDesktopShow(true)
                            .build();

                        break;
                    case "show":
                        FloatWindow.get().show();
                        break;
                    case "hide":
                        FloatWindow.get().hide();
                        break;
                }
            }
        );
    }
}