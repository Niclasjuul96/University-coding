import 'package:flutter/material.dart';

void main() {
  runApp(const MainApp());

  List<int> x = [ 7, 9, 13];
  var y = [1, 10, 13, ...x];

  print(y);
}

class MainApp extends StatelessWidget {
  const MainApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      home: Scaffold(
        body: Center(
          
          child: Text('DTU/s'),
        ),
      ),
      
    );
  }
}
