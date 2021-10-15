# Dictionary_Graphic
---

## Developers
* [Ngoc Minh](https://github.com/Mint18032)
* [Viet Khanh](https://github.com/khanhvankhanh141)

## Discription
A user-friendly dictionary application.

## Setup

### Setup Environment
* Download MySQL Installer [here](https://dev.mysql.com/downloads) to setup MySQL Server and Workbench (this [video](https://www.youtube.com/watch?v=OM4aZJW_Ojs) might help)
### Setup Project
* Open MySQL Workbench and run the SQL script in resources/dictionary.sql to import database (follow this [video](https://youtu.be/uyP46E0UA9I?t=248) from 4:08 to 6:00)
* In the DictionaryManager.java change the url of the database to your url database and your password to connect to the database.
## How to use

### Lookup
This is the main function of the app which is to look up the meaning of words.

Type the word in the textfield then click "Search" button or click to choose one of the words in our suggestion list. 
The word's definition should appears below the suggestion list.

If the searching word does not exist in our database, an alert will appear to tell you try our online searching function. 
After clicking "OK" the app will automatically close the alert and switch to the next tab, the word and its definition will present there.
You can click "Cancel" or close the alert window to skip this. 

### Translate pharagraph 
Online searching using Google API. 
Click on the tab called "Pharagraph" to use this function.

Click "Search" after typing word/sentence/paragraph in the first text field.

You can change language target (Vietnamese or English) by clicking the "VI_EN" or "EN-Vi" button.

### Add word
This function together with fix and delete word are located in "Custom" tab.

Click "Add word", a small window will appear. 
Type a word in the first textfield and its meaning in the other field then click "Add".

The label will tell you if the adding process is success or not. 
In paticular:
* "Please wait for a few seconds!" means it is processing.
* "The word is successfully added to dictionary!" means you can search it in you dictionary from now on.
* "Please type your word!" will be presented if you did not fill the first textfield.
* "Please type new explanation!" when you did not type the meaning.
* If it tells you "This word is already exist!", you can try next function.

### Fix word
You can fix an existing word's defition by this function.

Click "Fix word", a small window will appear.
Type a word in the first textfield and its meaning in the other field then click "Fix".

The label will tell you if the process is success or not. 

### Delete word
You can delete an existing word by this function.

Click "Delete word", a small window will appear.
Type a word in the textfield then click "Delete".

The label will tell you if the process is success or not.

## Captures