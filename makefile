all:
	javac -d classes -sourcepath src src/org/ioopm/calculator/Calculator.java
run:
	java -cp classes Calculator
clean:
	rm -rf classes
