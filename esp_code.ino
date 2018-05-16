

/* ESP8266 Temperature Humidity & Moisture Soil Moisture
moded by www.14core.com / Java Script by Google.com {https://www.gstatic.com/charts/loader.js}
Note: You need to connect to the internet to get the guage which is transmit by the sensor .
**********************************************************************************************
Ip address: 192.168.1.100 // 
Gatway: 192.168.1.1 // Check your AP gateway 
Subnet Mask: 255.255.255.0 
*/                    

#include <ESP8266WiFi.h>
#include<ESP8266WebServer.h>
#include "DHT.h"
#define DHTTYPE DHT11

ESP8266WebServer server;

const char* ssid = "MANU"; //You can change the SSDI 
const char* password = "12345612"; //You can change the password as you like

//int WiFiStrength = 0;
//WiFiServer server(80);

const int DHTPin = 5;  // ~D1
const int moist = A0;  // 
//const int ledStatus = 4;// ~D2
const int pin1 = 4;//fan D2
const int pin2 = 13;//pump D7
const int pin3 = 15;//light D8
//const int pin4 = 12;//arduino D6
const int pin5 = 14;//right D5
const int pin6 = 12;//left D6

DHT dht (DHTPin, DHTTYPE);

static char celsiusTemp[7];
static char fahrenheitTemp[7];
static char humidityTemp[7];
double moisture = 0.0;
unsigned long timeHolder = 0;
int statef = LOW;
int statep = LOW;
int statel = LOW;
int statell = LOW;
int stater = LOW;


void setup() {
  pinMode(pin1, OUTPUT);
  pinMode(pin2, OUTPUT);
  pinMode(pin3, OUTPUT);
  pinMode(pin5, OUTPUT);
  pinMode(pin6, OUTPUT);
  Serial.begin(9600);
  delay(10);
  dht.begin();
  //pinMode(ledStatus, OUTPUT);
  pinMode(moisture, INPUT);
  //analogWrite(ledStatus, 280);
  Serial.println();
  Serial.print("Connecting to ");
  Serial.println(ssid);

  WiFi.begin(ssid, password);
  // This line should the same with your router/internet connection to parse the javascript which is provided by Google
  //WiFi.config(IPAddress(192, 168, 1, 221), IPAddress(192, 168, 1, 1), IPAddress(255, 255, 255, 0)); 
  // connect to WiFi router
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print("....");
  }

  Serial.println("------------------------");
  Serial.println("WiFi connected");
  // Start the server
  server.begin();
  Serial.println("Server started, setting up ESP8266 IP Address...");
  Serial.print("Use this URL to connect: ");
  Serial.print("http://");
  Serial.print(WiFi.localIP());
  Serial.println("/");
      server.on("/11", fan);
      server.on("/10", light);
      server.on("/00", pump);
      server.on("/t",temp);
      server.on("/h",humidity);
      server.on("/m",moistread);
      server.on("/r",right);
      server.on("/l",left);
       
  
  //Serial.println("Server started");

}

void loop() {

         /*float tem = dht.readTemperature();
      Serial.println(tem);
      delay(1000);
      float humid = dht.readHumidity();
       Serial.println(humid);
       delay(1000); **/
     // digitalWrite(pin1, HIGH);
     server.handleClient();
  }
void temp()
  {
    float temp = dht.readTemperature();
    float far = dht.readTemperature(true);
       Serial.println(temp);
  server.send(200, "text/plain", (String)temp + " °C "  );   
    }
void humidity()
  {
    float humid = dht.readHumidity();
  Serial.println(humid);
  server.send(200, "text/plain", (String)humid );   
    }
void moistread()
    {float a;
      float b;
    float mostval1;
    float moisture = analogRead(moist);
    int moistval = (moisture * 100) / 400;
    moistval = 100 - moistval;
    if((moistval <  0))
    {moistval=-moistval ;
    a=(156-moistval);
    mostval1=a/1.7;
  server.send(200, "text/plain", (String)mostval1 +" %" );   
    }
    else
   { //moistval =0 __0%;
      //40?100%
      b=100-moistval;
      mostval1=91.76+b/20;
      server.send(200, "text/plain", (String)mostval1 +" %" );}
    
    }

  void fan()
      {  
            if (statef ==LOW ) 
      
          {digitalWrite(pin1,HIGH);
          statef = HIGH; 
            Serial.println("Fan on...");
          server.send(200, "text/plain", "Fan on" ); 
        }
        else {
          Serial.println("Fan off...");
          digitalWrite(pin1, LOW);
          statef = LOW;
          server.send(200, "text/plain", "Fan off" );
        }
      
    }

    void pump()
      {  
        
            if (statep == LOW) {
          digitalWrite(pin2, HIGH);
          statep = HIGH;
          Serial.println("pump on...");
          server.send(200, "text/plain", "Pump on" );   
        } else {
          digitalWrite(pin2, LOW);
          statep = LOW;
          Serial.println("pump off...");
          server.send(200, "text/plain", "Pump off" );
        }
      
    }
    void light()
      {  
            if (statel == LOW) {
          digitalWrite(pin3, HIGH);
          statel = HIGH;
          Serial.println("light on...");
          server.send(200, "text/plain", "Light on" );   
        } else {
          statel = LOW;
          digitalWrite(pin3, LOW);
          Serial.println("light off...");
          server.send(200, "text/plain", "Light off" );
        }
      
    }
    void right()
      {  
            if (stater ==LOW ) 
      
          {digitalWrite(pin5,HIGH);
          stater = HIGH; 
            Serial.println("Towards right...");
          server.send(200, "text/plain", "Towards right" ); 
        }
        else {
          Serial.println("Stop...");
          digitalWrite(pin5, LOW);
          stater = LOW;
          server.send(200, "text/plain", "Stop" );
        }
      }
        void left()
      {  
            if (statell ==LOW ) 
      
          {digitalWrite(pin6,HIGH);
          statell = HIGH; 
            Serial.println("Towards left...");
          server.send(200, "text/plain", "Towards left" ); 
        }
        else {
          Serial.println("Stop...");
          digitalWrite(pin6, LOW);
          statell = LOW;
          server.send(200, "text/plain", "Stop" );
        }
      }
