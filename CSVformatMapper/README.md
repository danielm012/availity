# Eclipse environtmnet
# An example Java 11 project using Maven and JUnit 5.x

1. Get adoptopenjdk-11: https://adoptopenjdk.net/
2. Get maven 3.6.x: https://maven.apache.org/
3. Add above to your path if neccessary.
4. `git clone git@github.com:example/test.git`
5. `mvn clean package`
6. `java -jar target/test-1.0.0-SNAPSHOT.jar`


# Output:
enrollmentTest.csv
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
     Structure of enrollmentTest.csv     
 Index  |  Column Name  |  Column Type  |
-----------------------------------------
     0  |           Id  |      INTEGER  |
     1  |        First  |       STRING  |
     2  |         Last  |       STRING  |
     3  |      Version  |      INTEGER  |
     4  |    Insurance  |       STRING  |
                      enrollmentTest.csv                      
 Id  |    First    |    Last    |  Version  |   Insurance    |
--------------------------------------------------------------
  1  |       Mike  |      John  |        1  |         Cigna  |
  2  |      Pedro  |     Lopez  |        1  |        Humana  |
  3  |    Joselyn  |    Herman  |        1  |         Aetna  |
  4  |       Mike  |      John  |        2  |         Cigna  |
  5  |  Katherine  |      Lien  |        1  |     BlueCross  |
  6  |       John  |            |        1  |      Assurant  |
  7  |       Eden  |            |        2  |         Aetna  |
  8  |             |            |        1  |      CarePlus  |
  9  |     Carlos  |  Mendez		  |           |                |
 10  |       John  |    Decker  |           |  UnitedHealth  |
                    enrollmentTest.csv                     
 Id  |    First    |    Last    |  Version  |  Insurance  |
-----------------------------------------------------------
  9  |     Carlos  |  Mendez		  |           |             |
  7  |       Eden  |            |        2  |      Aetna  |
  3  |    Joselyn  |    Herman  |        1  |      Aetna  |
 14  |       Rose  |   Marylin  |        2  |      Aetna  |
  6  |       John  |            |        1  |   Assurant  |
 13  |    Spencer  |  Williams  |        1  |   Assurant  |
 12  |    Spencer  |  Williams  |        2  |   Assurant  |
 11  |    Spencer  |  Williams  |        3  |   Assurant  |
 15  |      Smith  |     Brian  |        1  |  BlueCross  |
  5  |  Katherine  |      Lien  |        1  |  BlueCross  |
[Aetna, , CarePlus, Humana, Assurant, Cigna, BlueCross, UnitedHealth]
                   enrollmentTest.csv                   
 Id  |   First   |   Last    |  Version  |  Insurance  |
--------------------------------------------------------
  7  |     Eden  |           |        2  |      Aetna  |
  3  |  Joselyn  |   Herman  |        1  |      Aetna  |
 14  |     Rose  |  Marylin  |        2  |      Aetna  |
                   enrollmentTest.csv                   
 Id  |  First   |    Last    |  Version  |  Insurance  |
--------------------------------------------------------
  9  |  Carlos  |  Mendez		  |           |             |
                enrollmentTest.csv                 
 Id  |  First  |  Last  |  Version  |  Insurance  |
---------------------------------------------------
  8  |         |        |        1  |   CarePlus  |
                 enrollmentTest.csv                 
 Id  |  First  |  Last   |  Version  |  Insurance  |
----------------------------------------------------
  2  |  Pedro  |  Lopez  |        1  |     Humana  |
                   enrollmentTest.csv                    
 Id  |   First   |    Last    |  Version  |  Insurance  |
---------------------------------------------------------
  6  |     John  |            |        1  |   Assurant  |
 11  |  Spencer  |  Williams  |        3  |   Assurant  |
                enrollmentTest.csv                 
 Id  |  First  |  Last  |  Version  |  Insurance  |
---------------------------------------------------
  4  |   Mike  |  John  |        2  |      Cigna  |
                   enrollmentTest.csv                   
 Id  |    First    |  Last   |  Version  |  Insurance  |
--------------------------------------------------------
 15  |      Smith  |  Brian  |        1  |  BlueCross  |
  5  |  Katherine  |   Lien  |        1  |  BlueCross  |
                   enrollmentTest.csv                   
 Id  |  First  |   Last   |  Version  |   Insurance    |
--------------------------------------------------------
 10  |   John  |  Decker  |           |  UnitedHealth  |