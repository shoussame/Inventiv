import 'package:flutter/material.dart';

class Home extends StatefulWidget {
  @override
  _HomeState createState() => _HomeState();
}

class _HomeState extends State<Home> {
  String name = 'Jeal';
  String intention = '';
  String role = '';

  List<Map<String, dynamic>> buttons = [
    {
      'img': 'assets/images/Page-1.svg',
      'text': 'Le reve libere l expression',
    },
    {
      'img': 'assets/images/Page-2.svg',
      'text': 'Le eclaire le parcours',
    },
    {
      'img': 'assets/images/Page-3.svg',
      'text': 'La difference rend unique',
    },
    {
      'img': 'assets/images/Page-4.svg',
      'text': 'La valeur humaine met en mouvement',
    },
    {
      'img': 'assets/images/Page-5.svg',
      'text': 'La clé exprime le style',
    },
    {
      'img': 'assets/images/Page-6.svg',
      'text': 'Le parcours associe reve et realité',
    },
    {
      'img': 'assets/images/Page-7.svg',
      'text': 'Le ciel bleu revele l alignement',
    },
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Row(
        children: [
          Expanded(
            child: Container(
              decoration: BoxDecoration(
                color: Color(0xFF8ED4CE),
              ),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Padding(
                    padding: EdgeInsets.only(left: 8.0),
                    child: Image.asset(
                      'assets/images/Image 2.png',
                      width: 50, // Set your width
                      height: 50, // Set your height
                      fit: BoxFit.contain,
                    ),
                  ),
                  Padding(
                    padding: const EdgeInsets.all(8.0),
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Text(
                          'Pour commencer...',
                          style: TextStyle(
                            fontSize: 24,
                          ),
                        ),
                        Text(
                          'Faire votre Shynlei, jouer avec, c\'est l\'occasion d\'écouter vos rêves, de les partager et de prendre confiance dans votre richesse.',
                          style: TextStyle(
                            fontSize: 16,
                            color: Colors.white,
                          ),
                        ),
                        FormInput(
                          label: 'Nom et prénom :',
                          placeholder: name,
                          callback: (val) => setState(() => name = val),
                          underlined: true,
                        ),
                        FormInput(
                          label: 'Mon intention :',
                          placeholder:
                              'L\'intention, l\'objectif de ce Shynlei',
                          callback: (val) => setState(() => intention = val),
                          underlined: false,
                        ),
                        FormInput(
                          label: 'Mon rôle :',
                          placeholder: '',
                          callback: (val) => setState(() => role = val),
                          underlined: true,
                        ),
                      ],
                    ),
                  ),
                ],
              ),
            ),
          ),
          Expanded(
            child: Container(
              color: Colors.white, // Change to your color
              padding: EdgeInsets.all(32.0),
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [
                  Icon(Icons.arrow_drop_down),
                  Text(
                    'Votre Shynlei c\'est..',
                    style: TextStyle(
                      fontSize: 24,
                    ),
                  ),
                  Text(
                    '7 étapes, 2 fiches pour prendre note des rencontres, 1 page pour éclairer le sens, 3 interprétations pour vous aider..',
                    style: TextStyle(fontSize: 16),
                  ),
                  Wrap(
                    alignment: WrapAlignment.center,
                    children: buttons
                        .map(
                          (button) => ButtonComponent(
                            src: button['img'],
                            text: button['text'],
                          ),
                        )
                        .toList(),
                  ),
                  ElevatedButton(
                    onPressed: () {},
                    child: Text('EXPRIMER MES REVES'),
                    style: ElevatedButton.styleFrom(
                      primary: Color(0xFF34DBD0),
                    ),
                  ),
                ],
              ),
            ),
          ),
        ],
      ),
    );
  }
}

class FormInput extends StatelessWidget {
  final String label;
  final String placeholder;
  final Function(String) callback;
  final bool underlined;

  const FormInput({
    Key? key,
    required this.label,
    required this.placeholder,
    required this.callback,
    required this.underlined,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text(
          label,
          style: TextStyle(fontSize: 16),
        ),
        TextFormField(
          decoration: InputDecoration(
            border: underlined ? UnderlineInputBorder() : OutlineInputBorder(),
            hintText: placeholder,
          ),
          onChanged: callback,
        ),
        SizedBox(height: 20),
      ],
    );
  }
}

class ButtonComponent extends StatelessWidget {
  final String src;
  final String text;

  const ButtonComponent({
    Key? key,
    required this.src,
    required this.text,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        Image.asset(
          src,
          width: 50, // Set your width
          height: 50, // Set your height
          fit: BoxFit.contain,
        ),
        Text(text),
      ],
    );
  }
}
