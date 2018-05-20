# Indoor-Garden
Automation in the field of Gardening

# Abstract
Gardening is a tiresome, more or less a bit time consuming activity, more than turning switches on/off. So with the motive of bringing automation in the field of gardening we started with a small indoor garden project.

# Team Members
<ul>
<li ><a href="https://www.facebook.com/profile.php?id=100017434713564">Jeetendra Kumar</a></li>
<li><a href="https://www.facebook.com/manoj.parihar.18062533">Manoj Parihar</a></li>
<li><a href="https://www.facebook.com/prrachiagarwal2230473">Prachi Agarwal</a></li>
<li><a href="https://www.facebook.com/profile.php?id=100017682631797&ref=br_rs">Ujjwal Baranwal</a></li>
</ul>

# Mentors
<ul>
<li><a href="https://www.facebook.com/kumar.nikhil1198">Nikhil Kumar</a></li>
<li><a href="https://www.facebook.com/profile.php?id=100009857642161">Aayushi Shrivastava</a></li>
</ul>
v
# Pre-Requisites
 
 <b>Hardware:</b>
<ol>
<li>Arduino UNO</li>
<li>2	Motor Driver L298N</li>
<li> High Torque Stepper Motor</li>
<li>ULN2003</li>
<li>Jumper Wires</li>
<li>Breadboard</li>
<li>DST</li>
<li>15cm and 50cm Slider</li>
<li>Wooden Base (dia.52cm)</li>
<li>5m Square Channel</li>
<li>L Channels</li>
<li>Rack And Pinion</li>
<li>Aluminium Plate</li>
<li>Aluminium Sheet</li>
<li>Motor Mount</li>
<li>Some 3d printed Parts</li> 
 <li>Sensors
  <ol><li>Light sensors BH1750
   <li>Moisture sensor
    <li>Temperature Humidity Sensor DHT11
  </ol>
</ol>

 <b>Software:</b>
 
•	<a href ="https://www.arduino.cc/en/main/software">Arduino IDE</a>
  
 # Description
 <ol>
 <li>We got the real-time status of the indoor plant through the wifi-module esp8266 on an ardroid app which allowed us to remotely take care of our plant.
  <li>Dht11 temperature humidity sensor, moisture sensor were used to update parameters of temperature, humidity, and moisture of the soil.
   <li>An analysis of the data, we got, the was used to control lights, fan, and water pump through the app.
    <li>The water pump was adjusted to the place where the moisture was low with the help of positioning buttons of the app.
     </ol>
     
 
 # Useful Links
 <ol>
 <li>https://create.arduino.cc/projecthub/mega-das/arduino-indoor-garden-5d975c?ref=search&ref_id=indoor&offset=1
  <li>http://www.instructables.com/id/Indoor-CNC-Garden/
   </ol>


# Instruction on using source code
 Our overall code consists of two files provided above:
 <ol>
 <li><a href="https://github.com/Prachi0141/Indoor-Garden/blob/master/esp_code.ino"><b>esp_code</b></a> - To be upload in NodeMCU.
  <li><a href="https://github.com/Prachi0141/Indoor-Garden/blob/master/stepper_check.ino"><b>stepper.check</a></b> - To be upload in arduino uno.
  </ol>

# Results  
<ul>
 <li>The growth of plant is properly examined with precise information and thus taken care off.
<li> The mechanism used in the Bot is very effective in saving water and using it efficiently both position and time-wise.
<li> The energy requirements of the Bot is very low and can be used for long-time with low electricity requirements.
<li>The bot has very low heat radiation and thus can be used with continuous working for long time-span.
<li>It helps us to grow the plant with proper use of water which results in proper growth of the plant.
 </ul>

# Future scope
<ul>
 <li>The app could be further developed :
  <ol>
   <li>To provide remote access and notifications asking us to allow giving plant the required nutrients.
   <li>Further filters could be added depending on the plant type helping us to decide the requirements.
  </ol>
 <li>Useful in areas with quite variable conditions where gardening is difficult.
 <li> This bot has a very good scope in future for people who are not able to give time in gardening but want a patch of land full of   flowers in their backyard. They would require just to spend a few minutes in giving the seeds and water supply to the bot and       rest of the work is automatically done by the bot.
<li> For research purposes this bot can be used by researchers to examine the soil quality and its requirements for plantation accurately and without spending much time as most of the work is done by the bot.
<li>By farmers to have a proper information about the water and pesticide requirements of soil of their farm so that the growth of grains, vegetables etc. is done with precise information and their growth is properly examined and good quality crops are grown on a larger scale without wastage of water and other resources.
