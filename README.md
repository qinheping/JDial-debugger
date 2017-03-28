# JDial-Debugger

Test instruction: 

1) build sketch and put the sketch and the sketch jar (for example in my machine is sketch-1.7.2-all-Linux-amd64.jar) file in lib/

2) test examples can be found in Test.java.testSimpleExample()

How-to:

Take the testSumUp() in src/Test.java as an example.

The input contains two files, one is the execution trace of the buggy source code in the format:

https://github.com/pgbovine/OnlinePythonTutor/blob/master/v3/docs/opt-trace-format.md

/benchmarks/sumup/oritrace is the execution trace in testSumUp(). Another one is the correction of program state taken from the execution trace, /benchmarks/sumup/correction is the example.

After constructing an instance of MainEntrace class with the above two strings and an index indicating where the correction happen (which program state you take from the states array), calling MainEntrance.Synthesize(true) will return repairs as a map from line numbers to repaired string.

### TODO list

- [ ] write a parameter loader to load parameter to live variables context
