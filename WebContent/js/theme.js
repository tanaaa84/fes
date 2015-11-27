// JavaScript Document
var StyleFile = "theme" + document.cookie.charAt(6) + ".css";
   document.writeln('<link type="text/css" rel="stylesheet" href="css/' + StyleFile + '">');