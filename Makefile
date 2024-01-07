.SUFFIXES: .java .class
SRCDIR=src
BINDIR=bin
JAVAC=/usr/bin/javac
JAVA=/usr/bin/java

$(BINDIR)/%.class: $(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) $<

CLASSES2=Vaccination.class VaccineArray.class VaccineArrayApp.class\
	 BinaryTreeNode.class BTQueueNode.class BTQueue.class\
	 BinaryTree.class BinarySearchTree.class VaccineBSTApp.class

CLASSES=$(CLASSES2:%.class=$(BINDIR)/%.class)

default: $(CLASSES)

run: $(CLASSES)
	$(JAVA) -cp $(BINDIR) VaccineBSTApp
	$(JAVA) -cp $(BINDIR) VaccineArrayApp
	
clean:
	rm $(BINDIR)/*.class
