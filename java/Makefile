JC = javac
FLAGS = -Xlint:deprecation
TARGET = target
SRC = src
.SUFFIXES: .java .class
.java.class:
	$(JC) $(FLAGS) -d $(TARGET) $(SRC)/Rocket.java $(SRC)/SimpleAnimation.java

default: .java.class

clean:
	@ $(RM) $(TARGET)/*.class
	@ $(RM) -rf $(TARGET)
