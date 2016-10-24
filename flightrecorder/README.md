# How to

#### Steps
```
jcmd 29210 VM.unlock_commercial_features
jcmd 29210 JFR.start settings=profile name=prof1 duration=240s filename=/tmp/prof1.jfr
```
