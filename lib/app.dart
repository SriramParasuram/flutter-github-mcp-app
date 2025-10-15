import 'package:flutter/material.dart';

class MyApp extends StatelessWidget {
  final String flavor;

  const MyApp({super.key, required this.flavor});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'MCP Flutter Demo',
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(
          title: Text('MCP Flutter Demo ($flavor)'),
          backgroundColor: _getFlavorColor(flavor),
        ),
        body: Center(
          child: Text(
            'Hello from $flavor flavor!',
            style: const TextStyle(fontSize: 22),
          ),
        ),
      ),
    );
  }

  Color _getFlavorColor(String flavor) {
    switch (flavor) {
      case 'dev':
        return Colors.orange;
      case 'staging':
        return Colors.purple;
      case 'prod':
        return Colors.green;
      default:
        return Colors.grey;
    }
  }
}