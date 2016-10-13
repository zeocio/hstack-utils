# How to use the tools

#### Download the latest standalone (RCP) version of Eclipse Memory Analyzer and unpack it to some location

#### Obtain a heap dump for the specific jvm process

#### Run the headless heap dump parse script against the heap dump like so:

```
mat/ParseHeapDump.sh -keep_unreachable_objects tmp/my-jvm.hprof xyz.xml
```

#### Wait for the process to complete on its own. Once complete, it will leave a zip file in the same direactory as the hprof file. You will have all relevant reports in html/csv format in the zip file. To read a specfic csv file in the zip archive, you can run:
```
unzip -p <xyz.zip> <abc.csv> | less
```
