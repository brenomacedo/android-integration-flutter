package com.example.native_code_integration.floating_button

import ...

public class MainActivity extends FlutterActivity {
    private static final String CHANNEL = "floating_button";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GeneratedPluginRegistrant.registerWith(this);

        MethodChannel channel = new MethodChannel(getFlutterEngine().getDartExecutor().getBinaryMessenger(), CHANNEL);

}