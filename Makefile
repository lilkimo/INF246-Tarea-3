all:
	javac -d bin Main.java
	java -cp bin Main
clean:
	rm bin/*.class