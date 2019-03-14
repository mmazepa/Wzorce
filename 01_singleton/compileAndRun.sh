classfiles=(*.class)
if [[ -f ${classfiles[0]} ]]; then
  rm *.class
fi

classfiles=(*.ser)
if [[ -f ${classfiles[0]} ]]; then
  rm *.ser
fi

javac *.java
java SingletonTest
