all:
	javac -d bin Problema2.java
	java -cp bin Problema2
clean:
	rm bin/*.class