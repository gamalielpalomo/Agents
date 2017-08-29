/*
 * === ANALOG POTENTIOMETER ===
 *
 */
#include <LiquidCrystal.h>

int potPin0 = 3;        /* Input PIN for the potentiometer 0   */
int potPin1 = 0;        /* Input PIN for the potentiometer 1.  */
int potPin2 = 1;        /* Input PIN for the potentiometer 2.  */
int potPin3 = 2;        /* Input PIN for the potentiometer 3.  */
int ledPin = 13;        /* Input PIN for the LED.  */
long val0 = 0;          /* Variable to store the value coming from the sensor.  */
float valNorm0 = 0;      /* Variable to store the normalize value of val. */
long val1 = 0;          /* Variable to store the value coming from the sensor.  */
float valNorm1 = 0;      /* Variable to store the normalize value of val. */
long val2 = 0;          /* Variable to store the value coming from the sensor.  */
float valNorm2 = 0;      /* Variable to store the normalize value of val. */
long val3 = 0;          /* Variable to store the value coming from the sensor.  */
float valNorm3 = 0;      /* Variable to store the normalize value of val. */
float valNorm0Fixed = 0;
float valNorm1Fixed = 0;
float valNorm2Fixed = 0;
float valNorm3Fixed = 0;
int buttonPressed = 0;
int valButton0 = 0;
int valButton1 = 0;
int valButton2 = 0;
int valButton3 = 0;
int NumPotAux = 0;

/*LiquidCrystal lcd(12, 11, 5, 4, 3, 2);*/
LiquidCrystal lcd(12, 11, 7, 6, 5, 4);

void setup() {
  lcd.begin(16, 2);
  pinMode(ledPin, OUTPUT);
  pinMode(13, INPUT_PULLUP);
  pinMode(8, INPUT_PULLUP);
  pinMode(9, INPUT_PULLUP);
  pinMode(10, INPUT_PULLUP);

  lcd.setCursor(0, 0);
  lcd.print("FLIGHT");
  lcd.setCursor(0, 1);
  lcd.print("SIMULATOR");
  Serial.begin(9600);
}

float normalizeValue(long Val)
{
  /* 1023 is the maximum value of the potentiometer */
  return ((float)Val / 1023);
}

void imprime(float Val0, float Val1, float Val2, float Val3)
{
  Serial.print(Val0);Serial.print(",");Serial.print(Val1);Serial.print(",");Serial.print(Val2);Serial.print(",");Serial.print(Val3);Serial.print(",");
}

int verifyButtons()
{
  if(digitalRead(8) == LOW)
    return 1;
  if(digitalRead(9) == LOW)
    return 2;
  if(digitalRead(10) == LOW)
    return 3;
  if(digitalRead(13) == LOW)
    return 4;
  return 0;
}

void changeLEDMessage(int NumButton)
{
  if(NumButton != 0)
  {
    lcd.begin(16, 2);
    lcd.setCursor(0, 0);
    
    if(NumPotAux == 0)
    {
      lcd.print("Elevators: ");
      lcd.setCursor(0, 1);
      lcd.print(valNorm0);
    }
    else if(NumPotAux == 1)
    {
      lcd.print("Aileron: ");
      lcd.setCursor(0, 1);
      lcd.print(valNorm1);
    }
    else if(NumPotAux == 2)
    {
      lcd.print("Rudder: ");
      lcd.setCursor(0, 1);
      lcd.print(valNorm2);
    }
    else if(NumPotAux == 3)
    {
      lcd.print("Throttle: ");
      lcd.setCursor(0, 1);
      lcd.print(valNorm3);
    }
    if(NumButton != 5)
      NumPotAux++;
    if(NumPotAux == 4)
      NumPotAux = 0;
  }
}

void loop() {  
  valButton0 = 0;
  valButton1 = 0;
  valButton2 = 0;
  valButton3 = 0;

  val0 = analogRead(potPin0);
  valNorm0 = (normalizeValue(val0)) * 2;
  val1 = analogRead(potPin1);
  valNorm1 = (normalizeValue(val1)) * 2;
  val2 = analogRead(potPin2);
  valNorm2 = (normalizeValue(val2)) * 2;
  val3 = analogRead(potPin3);
  valNorm3 = (normalizeValue(val3)) * 2;

  digitalWrite(ledPin, HIGH);
  buttonPressed = verifyButtons();
  if(buttonPressed == 1)
    valButton1 = (int)1;
  else if(buttonPressed == 2)
    valButton2 = (int)1;
  else if(buttonPressed == 3)
    valButton3 = (int)1;
  else if(buttonPressed == 4)
  {
    changeLEDMessage(4);
    valButton0 = (int)1;
  }
  
  if(valNorm0 != valNorm0Fixed || valNorm1 != valNorm1Fixed || valNorm2 != valNorm2Fixed || valNorm3 != valNorm3Fixed || 
     valButton1 == 1 || valButton2 == 1 || valButton3 == 1)
  {
    changeLEDMessage(5);
    imprime(valNorm0, valNorm1, valNorm2, valNorm3);
    Serial.print(valButton1);Serial.print(",");Serial.print(valButton2);Serial.print(",");Serial.print(valButton3);Serial.println();
    valNorm0Fixed = valNorm0;
    valNorm1Fixed = valNorm1;
    valNorm2Fixed = valNorm2;
    valNorm3Fixed = valNorm3;
  }

  delay(200);

  /*
  imprime(valNorm1, valNorm2, valNorm3);
  
  digitalWrite(ledPin, LOW);
  verifyButtons();
  */
}
