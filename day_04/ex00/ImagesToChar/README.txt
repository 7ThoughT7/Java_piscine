#Deleting the directory
rm -rf target

#Creating the new dir since java -d donesn`t create it
mkdir target

#Set the destination directory for class files
javac -d ./target src/java/edu/school21/printer/*/*.java

#Specify where to find user clacc files
java -classpath target edu.school21.printer.app.Program . 0 /Users/bmohamme/Java_piscine/day_04/ex01/ImagesToChar/src/resources/it.bmp