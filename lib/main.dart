import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      home: Home(),
    );
  }
}

class Home extends StatefulWidget {
  @override
  _HomeState createState() => _HomeState();
}

class _HomeState extends State<Home> {

  static const platform = const  MethodChannel("floating_button");

  int count = 0;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Floating Button Demo'),
        centerTitle: true,
      ),
      body: Padding(
        padding: const EdgeInsets.all(8.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            Text("$count", textAlign: TextAlign.center, style: TextStyle(
              fontSize: 50
            )),
            ElevatedButton(
              child: Text('Create'),
              onPressed: () {
                platform.invokeMethod('create');
              }
            ),
            ElevatedButton(
              child: Text('Show'),
              onPressed: () {
                platform.invokeMethod('show');
              }
            ),
            ElevatedButton(
              child: Text('Hide'),
              onPressed: () {
                platform.invokeMethod('hide');
              }
            )
          ],
        ),
      ),
    );
  }
}