# hackthemac
store mac address of all the devices on your network

1.  You need to have Java 2 Standard Edition SDK(software development kit) for running this java program.
If you are on windows , Linux or Solaris ,you can download it from java.sun.com

2.  Optional J2SE API documentation . IT's worth the download.

3.  You will need a Text Editor .vi,gedit,sublimetext ,Notepad,TextEdit,wordpad etc any will work as long as it does not
    append a ".txt" to the end of your source code.
    
  (For Windows users)
4.  After downloading you need to add an entry to your PATH environment variable so that when
    you type javac filename.java at your commandline ,your terminal will know how to find javac compiler.
    You can run Java applications just fine without setting the PATH environment variable. 
    but it is preffered to set it for convenience.
    The PATH environment variable is a series of directories separated by semicolons (;)
    Microsoft Windows looks for programs in the PATH directories in order,
    from left to right. You should have only one bin directory for the JDK in the path at a time 
    (those following the first are ignored),
    so if one is already present, you can update that particular entry.
5.  Setting up path variable :
    Start->System->advanced system settings->click on the environment variable button->
    scroll down to PATH under system variables section ->click it for Editing it->
    append ;C:\Program Files\Java\jdkyour_version\bin to your path variable->save it->
    close your command prompt(if opened ).
    reopen it to see the new path variable with
    command echo %PATH%
    To find out if the path is properly set, execute:
     java -version
    This will print the version of the java tool, if it can find it. 
    If the version is old or you get the error java: Command not found, then the path is not properly set.
    Then Ask google uncle .
