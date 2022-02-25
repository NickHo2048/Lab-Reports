
runall: MarkdownParse.class MarkdownParseTest.class
	java -cp .:libs/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest
MarkdownParseTest.class: MarkdownParseTest.java MarkdownParse.class
	javac -cp .:libs/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java

MarkdownParse.class: MarkdownParse.java
	javac MarkdownParse.java


