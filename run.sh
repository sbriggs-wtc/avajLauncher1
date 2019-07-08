find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java -classpath . com.avaj.Simulator scenario.txt #> simulation.txt