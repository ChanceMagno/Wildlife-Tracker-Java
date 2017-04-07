## Wildlife Tracker

An app for the forest service to track animals for an environmental impact study.

### Description

The Forest Service is considering a proposal from a timber company to clearcut a nearby forest of Douglas Fir. Before this proposal may be approved, they must complete an environmental impact study. This application was developed to allow Rangers to track wildlife sightings in the area.

## Specifications

| Behavior                   | Input Example     | Output Example    |
|:---:|:---:|:---:|
| Able to add an Animal|New Animal: "Donkey"| add "Donkey"| Animal "Donkey" added|
|Able to submit animal as endangered or not|"donkey"| "donkey" not endangered|
|Able to report a sighting of Animals listed|Animal sighted "Donkey"|Animal "Donkey Sighted"|
|Able to input details about spotting|"donkey" was a "male"|"Sighted: male Donkey"|
|Able to see time of sighting submission|sighted donkey submitted|Donkey sighted submission on 1/21/17|
|Able to see sightings by most recent|See most recent sightings|Horse 3/31/17, Donkey 1/21/17|
|user can select individual animal based on endangered or not|select endangered animals|"bald eagle"|

### Setup

* This repository is meant to be viewed. It can be viewed [here](https://ChanceMagno.github.io/Wildlife-Tracker-Java
).

### Or you can clone OR download a local instance of the site:

* Clone
  * Open your terminal program
    * On a Mac, this would be in the Applications/Utilities directory, and is called, "Terminal"
    * Windows uses a Terminal program as well, but a Terminal with all the capabilities we'll require is not installed by default. Thankfully, we can easily download and install a Terminal program that does fit our needs.
There are many options available, but we recommend using a terminal program called git bash. You can download this free program at [msysgit.github.io](https://ChanceMagno.github.io/Wildlife-Tracker-Java
).
  * Clone this track survey repository by typing, `git clone(https://ChanceMagno.github.io/Wildlife-Tracker-Java
)`
* Download
  * Click [here](https://ChanceMagno.github.io/Wildlife-Tracker-Java
/archive/master.zip) to download the repo
  * Unzip the zipped repository
* For launching the program if you are unsure visit [here](https://www.learnhowtoprogram.com/java/java-applications-ff6bacd3-bc1c-4c32-87c5-cc963b704cc2/compiling-and-running-a-java-program)

To create the necessary databases, launch postgres, then psql, and run the following commands:

* `CREATE DATABASE wildlife_tracker;`
* `\c wildlife_tracker;`
* `Then in a different terminal/command line type: psql wildlife_tracker < wildlife_tracker.sql`
* `Navigate back to your wildlife_tracker and type: \dt to verify all tables have loaded`

* After you have cloned the repository and loaded the supplied sql file into your database you should now be able to navigate in your terminal/command line into the folder named Wildlife-Tracker-Java.
* Once in the folder type gradle run.
* in a web browser go to localhost:4567.



### License


Copyright (c) 2017 **_MIT License_**
